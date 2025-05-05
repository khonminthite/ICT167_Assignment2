/**
 * IllegalMarkException Class
 *
 * This class represents an exception for illegal marks.
 * <p>
 * Precondition: The mark provided is outside the valid range.
 * Postconditions: An instance of this exception is thrown with an appropriate message.
 * </p>
 */
public class IllegalMarkException extends Exception {
    
    /**
     * Constructor for IllegalMarkException.
     *
     * @param message The error message associated with the exception.
     */
    public IllegalMarkException(String message) {
        super(message);
    }
}
