package uk.ac.reigate.model.email

import javax.validation.constraints.NotNull

/**
 * This class is used to send a single email message. The email may have multiple recipients but they will all 
 * appear in the to, cc or bcc lines for the specific email that is sent.
 * 
 * @author Michael Horgan
 *
 */
class EmailMessage extends EmailContent {
    
    /**
     * This field is used to store a list of TO recipients
     */
    @NotNull
    String[] to
    
    /**
     * This field is used to store a list of CC recipients
     */
    String[] cc
    
    /**
     * This field is used to store a list of BCC recipients
     */
    String[] bcc
    
    /**
     * This field is used to store the email address of the sender
     */
    String from
    
    /**
     * This field is used to store the desired reply to address
     */
    String replyTo
    
}
