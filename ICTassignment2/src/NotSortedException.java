/**
 * Custom exception class for situations where sorting is expected but not found.
 * 
 * This exception is thrown when an operation that requires sorted elements encounters
 * unsorted data.
 * 
 * <p>
 * Precondition: The data is expected to be sorted for the operation to succeed.
 * </p>
 * 
 * <p>
 * Postconditions: The state is not guaranteed to be consistent after this exception
 * is thrown. It indicates that the data is not sorted as expected.
 * </p>
 */
public class NotSortedException extends Exception {
    /**
     * Constructs a new NotSortedException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by
     *                the getMessage() method).
     */
    public NotSortedException(String message) {
        super(message);
    }
}