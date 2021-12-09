package uk.ac.reigate.model.email

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * This class is used to send the same email to a collection of recipients.
 * 
 * @author Michael Horgan
 *
 */
@EqualsAndHashCode
@ToString
class BulkEmail extends EmailContent {
    
    List<String> recipients
    
    //EmailContent email
    
    String from
    
    String replyTo
    
}
