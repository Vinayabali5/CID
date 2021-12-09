package uk.ac.reigate.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Service

import uk.ac.reigate.model.email.EmailMessage

@Service
class EmailLogger {
    
    private final static Logger LOGGER = LoggerFactory.getLogger("Email Status Log");
    
    void logEmailStatus(EmailMessage message, String status) {
        LOGGER.info("Email To: $message.to, Subject: $message.subject, Status: $status");
        // #TODO: Add more interesting email logging here
    }
    
}
