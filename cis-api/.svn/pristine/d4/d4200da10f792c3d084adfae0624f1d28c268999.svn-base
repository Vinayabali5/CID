package uk.ac.reigate.model.email

import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotNull

/**
 * This class is used to send a single email message. The email may have multiple recipients but they will all 
 * appear in the to, cc or bcc lines for the specific email that is sent.
 * 
 * @author Michael Horgan
 *
 */
@EqualsAndHashCode
class EmailMessage extends EmailContent {
    
    /**
     * This field is used to store a list of TO recipients
     */
    @NotNull
    List<String> to
    
    /**
     * This field is used to store a list of CC recipients
     */
    List<String> cc
    
    /**
     * This field is used to store a list of BCC recipients
     */
    List<String> bcc
    
    /**
     * This field is used to store the email address of the sender
     */
    String from
    
    /**
     * This field is used to store the desired reply to address
     */
    String replyTo
    
    EmailMessage() {
        to = new ArrayList<String>()
        cc = new ArrayList<String>()
        bcc = new ArrayList<String>()
    }
    
    /**
     * This method is used to produce a string representation of the EmailMessage object.
     */
    @Override
    public String toString() {
        return "EmailMessage [to=" + to + ", cc=" + cc + ", bcc=" + bcc + ", from=" + from + ", replyTo=" + replyTo + "]";
    }
}
