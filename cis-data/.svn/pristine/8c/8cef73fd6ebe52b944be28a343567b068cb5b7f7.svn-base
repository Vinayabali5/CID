package uk.ac.reigate.util.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value=HttpStatus.NOT_FOUND) //, reason="Cannot find application with specified ID")  // 404
public class ApplicationNotFoundException extends RuntimeException {
    
    ApplicationNotFoundException(Integer id) {
        super("Student not found (id: " + id + ").")
    }
    
    ApplicationNotFoundException(String ref) {
        super("Student not found (ref: " + ref + ").")
    }
    
}
