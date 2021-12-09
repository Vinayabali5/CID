package uk.ac.reigate.util.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ContactNotFoundException extends RuntimeException  {
    
    ContactNotFoundException(String contactId) {
        super("Could not find contact '" + contactId + "'.")
    }
}
