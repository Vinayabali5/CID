package uk.ac.reigate.exceptions;

/**
 * This exception is used when the data supplied to a method is incomplete or invalid.
 * 
 * @author Michael Horgan
 *
 */
public class InvalidDataException extends ApiException {
    
    private int code;
    
    public InvalidDataException() {
        this(400, "Invalid Data Provided");
    }
    
    public InvalidDataException(String msg) {
        this(400, msg);
    }
    
    public InvalidDataException(int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
