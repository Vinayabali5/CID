package uk.ac.reigate.util.exception

/**
 * This exception is used when an ID field is required but has not been supplied. 
 * 
 * @author Michael Horgan
 *
 */
class IdMissingException extends RuntimeException {
    
    IdMissingException() {
        super("ID missing.")
    }
    
    IdMissingException(String msg) {
        super(msg)
    }
}
