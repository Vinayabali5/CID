package uk.ac.reigate.service;

import java.util.concurrent.Future

import javax.mail.Flags
import javax.mail.Folder
import javax.mail.Session
import javax.mail.Store
import javax.mail.internet.MimeMessage

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.MailAuthenticationException
import org.springframework.mail.MailParseException
import org.springframework.mail.MailPreparationException
import org.springframework.mail.MailSendException
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

import uk.ac.reigate.model.email.BulkEmail
import uk.ac.reigate.model.email.EmailMessage

@Service
class EmailService {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class.getName());
    
    @Autowired
    EmailLogger emailLogger
    
    @Value('${email.default-sender}')
    String DEFAULT_SENDER 
    
    @Value('${email.archive.server}')
    String ARCHIVE_SERVER
    
    @Value('${email.archive.port}')
    Integer ARCHIVE_PORT
    
    @Value('${email.archive.user}')
    String ARCHIVE_USER
    
    @Value('${email.archive.password}')
    String ARCHIVE_PASSWORD
    
    @Value('${email.archive.folder}')
    String ARCHIVE_FOLDER
    
    @Autowired
    JavaMailSender mailSender
    
    @Async
    Future<String> sendEmail(EmailMessage email) {
        LOGGER.debug("** EmailService.sendEmail() - started")
        
        MimeMessage message = mailSender.createMimeMessage() //new MimeMessage(session)
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setFrom(email.from == null ? this.DEFAULT_SENDER : email.from)
        email.to.each { it ->
            helper.addTo(it)
        }
        email.cc.each { it ->
            helper.addCc(it)
        }
        email.bcc.each { it ->
            helper.addBcc(it)
        }
        if (email.replyTo != null) {
            helper.setReplyTo(email.replyTo)
        }
        helper.setSubject(email.subject)
        helper.setText(email.message)
        if (email.attachments != null && email.attachments.size() > 0) {
            email.attachments.each { it ->
                helper.addAttachment(it.getName(), it)
            } 
        }
        
        try {
            mailSender.send(message)
            storeEmailMessage(message)
            emailLogger.logEmailStatus(email, "Send Successful")
        } catch (MailAuthenticationException maex) {
            LOGGER.error("EE Authentication Error: " + maex.getMessage());
            emailLogger.logEmailStatus(email, "Send Failed: Authentication Failed")
        } catch (MailPreparationException|MailParseException|MailSendException ex) {
            LOGGER.error("EE Failed to send email: " + ex.getMessage());
            emailLogger.logEmailStatus(email, "Send Failed: $ex.getMessage()")
        } catch (Exception ex) {
            LOGGER.error("Failed to send email: " + ex.getMessage());
            emailLogger.logEmailStatus(email, "Send Failed: $ex.getMessage()")
        }
        LOGGER.debug("** EmailService.sendEmail() - Finish")
    }
    
    @Async
    Future<String> storeEmailMessage(MimeMessage message) {
        LOGGER.debug("** EmailService.storeEmailMessage :: started")
        Session session = mailSender.getSession()
        
        Store store = session.getStore("imap");
        store.connect(ARCHIVE_SERVER, ARCHIVE_PORT, ARCHIVE_USER, ARCHIVE_PASSWORD)
        
        Folder folder = (Folder) store.getFolder(ARCHIVE_FOLDER)
        folder.open(Folder.READ_WRITE)
        try {
            message.setFlag(Flags.Flag.RECENT, false);
            folder.appendMessages(message);
        } catch (Exception ignore) {
            LOGGER.error("error processing message " + ignore.getMessage());
        } finally {
            store.close();
        }
        LOGGER.debug("EmailService.storeEmailMessage :: finished")
    }
    
    @Async
    Future<String> sendMultipleEmails(BulkEmail bulkEmail) {
        List<EmailMessage> messagesToSend = new ArrayList<EmailMessage>();
        if (bulkEmail && bulkEmail.recipients.size() > 0) {
            bulkEmail.recipients.each { it ->
                messagesToSend.add(new EmailMessage(
                    to: [it],
                    from: bulkEmail.from,
                    replyTo: bulkEmail.replyTo,
                    subject: bulkEmail.subject, 
                    message: bulkEmail.message
                ));
            }
            if (messagesToSend.size() > 0) {
                LOGGER.info('II Email Service - Send Multiple Emails - Sending: ' + messagesToSend.size() + ' emails.');
                messagesToSend.each { it ->
                    def output = sendEmail(it)
                }
            }
        }
    }
}
