package uk.ac.reigate.api.exceptionhandling

import javax.servlet.http.HttpServletRequest

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice

import uk.ac.reigate.dto.errorhandling.ErrorDto
import uk.ac.reigate.exceptions.EdiCreationException

@ControllerAdvice
class SqlExceptionHandler {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(SqlExceptionHandler.class.getName());
    
    //@ExceptionHandler(EdiCreationException.class)
    public ResponseEntity<ErrorDto> handleEdiCreateionException(HttpServletRequest req, Exception exception) {
        LOGGER.error("EE EdiCreationExceptionHandler - handleEdiCreateionException");
        EdiCreationException ex = (EdiCreationException) exception
        return new ResponseEntity<ErrorDto> (new ErrorDto(code: ex.code != null ? ex.code : 404, message: ex.message != null ? ex.message : "Not Found") , HttpStatus.NOT_FOUND)
    }
}
