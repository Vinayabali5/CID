package uk.ac.reigate.util.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value=HttpStatus.NOT_FOUND) //, reason="Cannot find application with specified ID")  // 404
public class RequestNotFoundException extends RuntimeException {
    
    RequestNotFoundException() {
        super("Request not found.")
    }
    
    RequestNotFoundException(Integer id) {
        super("Request not found (id: " + id + ").")
    }
    
    RequestNotFoundException(String msg) {
        super(msg)
    }
    
}