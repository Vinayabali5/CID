package uk.ac.reigate.model.email

/**
 * This class is used to send the same email to a collection of recipients.
 * 
 * @author Michael Horgan
 *
 */
class BulkEmail extends EmailContent {
    
    List<String> recipients
    
    //EmailContent email
    
    String from
    
    String replyTo
 
}
