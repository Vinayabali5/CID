package uk.ac.reigate.exceptions

/**
 * This Exception class is used for any method or API call where the operation is not valid for the specified class.
 * Typical uses for this exception might be for a service methods that should not used but is require by an interface.
 * 
 * @author Michael Horgan
 *
 */
class InvalidOperationException extends ApiException {
    
    private static final int DEFAULT_CODE = 10
    
    public InvalidOperationException() {
        super("Invalid Operation")
        this.code = DEFAULT_CODE
    }
    
    public InvalidOperationException(String msg) {
        super(msg)
        this.code = DEFAULT_CODE
    }
}
