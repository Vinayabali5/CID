package uk.ac.reigate.model.email

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonIgnore

/**
 * This class is used to collect the require components for a email. 
 * 
 * @author Michael Horgan
 *
 */
@EqualsAndHashCode
@ToString
class EmailContent {
    
    @NotNull
    String subject
    
    @NotNull
    String message
    
    @JsonIgnore
    File[] attachments
}
