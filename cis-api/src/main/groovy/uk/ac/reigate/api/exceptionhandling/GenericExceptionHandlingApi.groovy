package uk.ac.reigate.api.exceptionhandling

import javax.naming.CommunicationException
import javax.servlet.http.HttpServletRequest

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.data.mapping.MappingException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException

import uk.ac.reigate.dto.errorhandling.ErrorDto
import uk.ac.reigate.exceptions.DataAlreadyExistsException
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException

@ControllerAdvice
public class GenericExceptionHandlingApi {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(GenericExceptionHandlingApi.class.getName());
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleErrorNotFoundException(HttpServletRequest req, Exception exception) {
        LOGGER.info("** GenericExceptionHandlingApi - handleErrorNotFoundException ");
        NotFoundException ex = (NotFoundException) exception
        return new ResponseEntity<ErrorDto> (new ErrorDto(code: ex.code != null ? ex.code : 404, message: ex.message != null ? ex.message : "Not Found"), HttpStatus.NOT_FOUND)
    }
    
    @ExceptionHandler([
        InvalidDataException.class,
        MappingException.class,
        HttpMessageNotReadableException.class
    ])
    public ResponseEntity<ErrorDto> handleErrorMappingException(HttpServletRequest req, Exception exception) {
        LOGGER.info("** GenericExceptionHandlingApi - handleErrorMappingException ");
        String message = exception.getMessage() != null ? exception.getMessage() : "Invalid Data Supplied"
        return new ResponseEntity<ErrorDto> (new ErrorDto(code: 400, message: message), HttpStatus.BAD_REQUEST)
    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorDto> handleErrorHttpRequestMethodNotSupportedException(HttpServletRequest req, Exception exception) {
        LOGGER.info("** GenericExceptionHandlingApi - handleErrorHttpRequestMethodNotSupportedException ");
        return new ResponseEntity<ErrorDto> (new ErrorDto(code: 405, message: "Method Not Supported"), HttpStatus.METHOD_NOT_ALLOWED)
    }
    
    @ExceptionHandler(DataAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleErrorDataAlreadyExistsException(HttpServletRequest req, Exception exception) {
        LOGGER.info("** GenericExceptionHandlingApi - handleErrorDataAlreadyExistsException");
        DataAlreadyExistsException ex = (DataAlreadyExistsException) exception
        return new ResponseEntity<ErrorDto> (new ErrorDto(code: 409, message: ex.message != null ? ex.message : "Data Already Exists"), HttpStatus.CONFLICT)
    }
    
    /**
     * This method is used as an exception handler for communication errors. This is a problem that can occur when the API server cannot communicate with 
     * one of the other required server (typically the LDAP server).
     * 
     * @param req the HttpServletRequest that triggered the exception
     * @param exception the Exception itself
     * @return a ResponseEntity informing the user of the problem
     */
    @ExceptionHandler(CommunicationException.class)
    public ResponseEntity<ErrorDto> handleErrorCommunicationException(HttpServletRequest req, Exception exception) {
        LOGGER.info("** GenericExceptionHandlingApi - handleErrorCommunicationException");
        CommunicationException ex = (CommunicationException) exception
        return new ResponseEntity<ErrorDto> (new ErrorDto(code: 666, message: ex.message != null ? ex.message : "Error communicating with server."), HttpStatus.SERVICE_UNAVAILABLE)
    }
    
    
    @ExceptionHandler([
        AuthenticationException.class,
        BadCredentialsException.class
    ])
    public ResponseEntity<ErrorDto> handleAuthenticationException(HttpServletRequest req, Exception exception) {
        LOGGER.info("** ExceptionHandlingApi - handleAuthenticationException");
        exception.printStackTrace()
        return new ResponseEntity<ErrorDto> (new ErrorDto(code: 500, message: "Authentication Error Occurred"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
    
    @ExceptionHandler([
        HttpClientErrorException.class
    ])
    public ResponseEntity<ErrorDto> handleHttpClientErrorException(HttpServletRequest req, Exception exception) {
        LOGGER.info("** ExceptionHandlingApi - handleHttpClientErrorException");
        exception.printStackTrace()
        return new ResponseEntity<ErrorDto> (new ErrorDto(code: 500, message: "Http Client Error Exception Occurred"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
    
    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleErrorException(HttpServletRequest req, Exception exception) {
        LOGGER.info("** ExceptionHandlingApi - handleErrorException");
        exception.printStackTrace()
        return new ResponseEntity<ErrorDto> (new ErrorDto(code: 500, message: "Unknown Error Occurred"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}