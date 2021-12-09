package uk.ac.reigate.util.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value=HttpStatus.NOT_FOUND) //, reason="Cannot find application with specified ID")  // 404
public class InterviewNotFoundException extends RuntimeException {
    
    InterviewNotFoundException() {
        super("Interview not found.")
    }
    
    InterviewNotFoundException(Integer id) {
        super("Interview not found (id: " + id + ").")
    }
    
    InterviewNotFoundException(String ref) {
        super("Interview not found (ref: " + ref + ").")
    }
    
}
