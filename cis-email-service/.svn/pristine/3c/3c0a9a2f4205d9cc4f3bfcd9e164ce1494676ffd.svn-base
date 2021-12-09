package uk.ac.reigate.model.email

import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is used to collect the require components for a email. 
 * 
 * @author Michael Horgan
 *
 */
@JsonIgnoreProperties(['attachments'])
class EmailContent {
    
    @NotNull
    String subject
    
    @NotNull
    String message
    
    @JsonIgnore
    File[] attachments

}
