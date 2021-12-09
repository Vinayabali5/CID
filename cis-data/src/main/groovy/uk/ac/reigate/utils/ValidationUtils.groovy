package uk.ac.reigate.utils;

import java.util.regex.Pattern;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * Validation utility methods
 *
 */
public final class ValidationUtils {
    
    private static final Pattern EMAIL_REGEX = Pattern.compile('^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$');
    
    /**
     * This constructor will trigger a NotImplementedException if an instance of this object is created.
     */
    private ValidationUtils() {
        throw new NotImplementedException("Utility classes cannot be instantiated");
    }
    
    /**
     * This method is used to assert that the supplied value is not blank.
     * 
     * @param value the String value to test 
     * @param message the message to return in the exception
     */
    public static void assertNotBlank(String value, String message) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(message);
        }
    }
    
    /**
     * This method is used to assert that the supplied object is not null.
     * 
     * @param object the String object to test 
     * @param message the message to return in the exception
     */
    public static void assertNotNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
    
    /**
     * This method is used to assert that the supplied value has a minimum length of length.
     * 
     * @param value the String value to test 
     * @param length the minimum length that the value must be
     * @param message the message to return in the exception
     */
    public static void assertMinimumLength(String value, int length, String message) {
        if (value.length() < length) {
            throw new IllegalArgumentException(message);
        }
    }
    
    /**
     * This method is used to assert that the supplied value matches the given regular expression.
     * 
     * @param string the String value to test
     * @param regex the RegEx expression to use for the matching test
     * @param message the message to return in the exception
     */
    public static void assertMatches(String value, Pattern regex, String message) {
        if (!regex.matcher(value).matches()) {
            throw new IllegalArgumentException(message);
        }
    }
    
    /**
     * This method is used to assert that the supplied value matches the ValidationUtils.EMAIL_REGEX expression.
     * 
     * @param email the String email to test
     * @param message the message to return in the exception
     */
    public static void assertEmail(String email, String message) {
        assertMatches(email, EMAIL_REGEX, message);
    }
}
