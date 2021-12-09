package uk.ac.reigate.services.integration.email;

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
import org.springframework.context.annotation.Profile
import org.springframework.mail.MailAuthenticationException
import org.springframework.mail.MailParseException
import org.springframework.mail.MailPreparationException
import org.springframework.mail.MailSendException
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.system.Setting
import uk.ac.reigate.model.email.BulkEmail
import uk.ac.reigate.model.email.EmailMessage
import uk.ac.reigate.services.SettingService

/**
 * This service is used to process the sending and storage of emails send for the CID system. 
 * 
 * @author Michael Horgan
 *
 */
@Profile("mail")
@Service
class EmailService {
    
    private final static Logger LOGGER = LoggerFactory.getLogger("Email Service");
    
    /**
     * This value is used to store the name of the setting that is used to BCC all emails sent via this service. 
     */
    final static String BCCEmailSetting = 'DefaultBCCEmailAddress'
    
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
    
    @Autowired
    SettingService settingService
    
    /**
     * This method is used to send an email message based on the supplied EmailMessage object. 
     * 
     * @param email the EmailMessage object to use for sending the email.
     * @return
     */
    @Async
    Future<String> sendEmail(EmailMessage email) {
        LOGGER.debug("** EmailService.sendEmail() - started")
        
        MimeMessage message = mailSender.createMimeMessage() //new MimeMessage(session)
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setFrom(email.from == null ? this.DEFAULT_SENDER : email.from)
        // Add TOs from EmailMessage
        email.to.each { it ->
            helper.addTo(it)
        }
        // Add CCs from EmailMessage
        email.cc.each { it ->
            helper.addCc(it)
        }
        // Add default BCC email address
        Setting defaultBCC = settingService.getSetting(BCCEmailSetting)
        if (defaultBCC != null) {
            helper.addBcc(defaultBCC.value)
        }
        // Add BCCs from EmailMessage
        email.bcc.each { it ->
            helper.addBcc(it)
        }
        if (email.replyTo != null) {
            helper.setReplyTo(email.replyTo)
        }
        // Create the email from EmailMessage
        helper.setSubject(email.subject)
        helper.setText(email.message != null ? email.message : '', true)
        // Add any attachments
        if (email.attachments != null && email.attachments.size() > 0) {
            email.attachments.each { it ->
                helper.addAttachment(it.getName(), it)
            }
        }
        // Attempt to send the email
        try {
            mailSender.send(message)
            storeEmailMessage(message)
            LOGGER.info("Email Sent Successful: " + email)
        } catch (MailAuthenticationException maex) {
            LOGGER.error("EE Authentication Error: " + maex.getMessage());
        } catch (MailPreparationException|MailParseException|MailSendException ex) {
            LOGGER.error("EE Failed to send email: " + ex.getMessage());
        } catch (Exception ex) {
            LOGGER.error("Failed to send email: " + ex.getMessage());
        }
        LOGGER.debug("** EmailService.sendEmail() - Finish")
    }
    
    /**
     * This method is used to send a bulk collection of emails based on the BulkEmail object supplied. 
     * 
     * @param bulkEmail the BulkEmail object to use for sending the emails.
     * @return
     */
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
    
    /**
     * This method is used as a helper method to store the emails that are sent into the archive folder specified 
     * by the settings of the system.
     * 
     * @param message the MimeMessage to store.
     * @return
     */
    @Async
    private Future<String> storeEmailMessage(MimeMessage message) {
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
    
}
