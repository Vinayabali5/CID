package uk.ac.reigate.exceptions

/**
 * This Exception class is used for an exception the may be thrown by the API. 
 * 
 * @author Michael Horgan
 *
 */
public class ApiException extends RuntimeException {
    
    protected int code;
    
    public ApiException() {
        super("API Exception");
        this.code = 1;
    }
    
    public ApiException(String msg) {
        super(msg);
        this.code = code;
    }
    
    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
