package uk.ac.reigate.util.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class PersonNotFoundException extends RuntimeException  {
    
    PersonNotFoundException(String personId) {
        super("Could not find person '" + personId + "'.")
    }
}

