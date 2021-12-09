package uk.ac.reigate.controller

import groovy.json.JsonBuilder

import java.security.Principal

import javax.validation.Valid

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import uk.ac.reigate.model.email.BulkEmail
import uk.ac.reigate.model.email.EmailMessage
import uk.ac.reigate.service.EmailService

@RestController
@RequestMapping(value="/email")
class TestEmailController {
    
    private final static Logger log = LoggerFactory.getLogger(TestEmailController.class.getName());
    
    @Autowired
    EmailService emailService
    
    @RequestMapping(value='/send-different', method=RequestMethod.POST)
    ResponseEntity<EmailMessage> sendEmail(@Valid @RequestBody EmailMessage email, BindingResult result) {
        
        if (result.hasErrors()) {
            return "error/notValid"
        }
        emailService.sendEmail(email)
        return email
    }
    
    @RequestMapping(value='/send', method=RequestMethod.POST)
    String sendEmailOld(@Valid @RequestBody EmailMessage email, BindingResult result) {
        if (result.hasErrors()) {
            return "Error Invalid Email Message"
        }
        emailService.sendEmail(email)
        return "Message Sent Successfully"
    }
    
    @RequestMapping(value='/send-bulk', method=RequestMethod.POST)
    String sendBulkEmail(@Valid @RequestBody BulkEmail bulkEmail, BindingResult result) {
        if (result.hasErrors()) {
            return "Error Invalid Email Message"
        }
        emailService.sendMultipleEmails(bulkEmail)
        return "Message Sent Successfully"
    }
    

    
    @RequestMapping(value='/test')
    String test() {
        log.info("*** EmailController.test() - Start")
        log.info("* Creating test email")
        EmailMessage email = new EmailMessage(
                from: 'cid.service@reigate.ac.uk',
                to: ['mike.horgan@reigate.ac.uk'],
                cc: ['michael.horgan@gmail.com'],
                subject: 'Hello',
                message: 'This is a test'
                )
        log.info("* Sending test email")
        def result = emailService.sendEmail(email)
        return new JsonBuilder(email).toPrettyString()
    }
    
    @RequestMapping(value='/test-no-reply')
    String testNoReply() {
        log.info("*** EmailController.test() - Start")
        log.info("* Creating test email")
        EmailMessage email = new EmailMessage(
                from: 'noreply@reigate.ac.uk',
                to: ['mike.horgan@reigate.ac.uk'],
                subject: 'Hello',
                message: 'This is a test'
                )
        log.info("* Sending test email")
        emailService.sendEmail(email)
        return new JsonBuilder(email).toPrettyString()
    }
    
    @RequestMapping(value='/testcc')
    String testCC() {
        log.info("*** EmailController.testCC() - Start")
        log.info("* Creating test email")
        EmailMessage email = new EmailMessage(
                from: 'mah@coulsdon.ac.uk',
                to: ['mike.horgan@reigate.ac.uk'],
                subject: 'Hello',
                message: 'This is a test'
                )
        log.info("* Sending test email")
        emailService.sendEmail(email)
        return new JsonBuilder(email).toPrettyString()
    }
    
    
    @RequestMapping(value='/test-attachment')
    String testAttachment() {
        log.info("*** EmailController.test() - Start")
        log.info("* Creating test email")
        File file = new File("/home/michael/Development/Source/cis/cis-email-service/sample.txt")
        File file2 = new File("/home/michael/Development/Source/cis/cis-email-service/sample.txt")
        EmailMessage email = new EmailMessage(
                from: 'cid.service@reigate.ac.uk',
                to: ['mike.horgan@reigate.ac.uk'],
                cc: ['michael.horgan@gmail.com'],
                subject: 'Hello',
                message: 'This is a test',
                attachments: [ file, file2 ]
                )
        log.info("* Sending test email")
        def result = emailService.sendEmail(email)
        return email
    }
    
    @RequestMapping(value='/test-bulk')
    String testBulkEmail() {
        log.info("*** EmailController.test() - Start")
        log.info("* Creating test email")
        BulkEmail bulkEmail = new BulkEmail(
                from: 'cid.service@reigate.ac.uk',
                recipients: ['mike.horgan@reigate.ac.uk','mike.horgan@reigate.ac.uk','mike.horgan@reigate.ac.uk'],
                subject: 'Hello',
                message: 'This is a test'
                )
        log.info("* Sending test email")
        def result = emailService.sendMultipleEmails(bulkEmail)
        return new JsonBuilder(bulkEmail).toPrettyString()
    }

    
    @RequestMapping(value='/test-auth')
    String testAuth(Principal principal) {
        if (principal) {
            Authentication auth = (Authentication) principal
            return "Success"
        }
        
        return "Failed"
    }
    
    @RequestMapping(value = '/blank')
    ResponseEntity<?> blank() {
        return new ResponseEntity<?>("Blank", HttpStatus.OK)
    }
    

}
