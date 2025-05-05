/**
 * Research_Course class represents a research course with specific assessment components.
 * <p>
 * This class extends the Unit class and includes additional functionality for managing
 * research proposal marks, final dissertation marks, calculating the overall mark,
 * and determining the final grade.
 * </p>
 * <p>
 * Precondition: The proposalMark and finalDissertationMark parameters should be valid
 * integer values representing the student's performance in the research course.
 * </p>
 * <p>
 * Postcondition: An instance of the Research_Course class can be used to store information
 * about a specific research course and calculate the overall mark and final grade.
 * </p>
 * 
 * @author [Khon Min Thite]
 * @version 1.0
 */
public class Research_Course extends Unit {

    // Private instance variables to store research course-specific information
    private int proposalMark;
    private int finalDissertationMark;
    private static final int MAX_MARK = 100;
    
    /**
     * Parameterized constructor for the Research_Course class.
     * Initializes the Research_Course with specific research course details.
     * 
     * @param proposalMark           The mark obtained in the research proposal.
     * @param finalDissertationMark The mark obtained in the final dissertation.
     */
    public Research_Course(int proposalMark, int finalDissertationMark) {
        super("R");
        this.setProposalMark(proposalMark);;
        this.setFinalDissertationMark(finalDissertationMark);;
    }

    // Getter and setter methods for private instance variables
    // ...

    /**
     * Getter method for retrieving the research proposal mark.
     * 
     * @return The research proposal mark.
     */
    public int getProposalMark() {
        return proposalMark;
    }

    /**
     * Setter method for setting the research proposal mark.
     * 
     * @param proposalMark The research proposal mark to be set.
     */
    public void setProposalMark(int proposalMark) {
        try {
            // Validate and ensure that the proposal mark is within the valid range (0 to MAX_MARK)
            this.proposalMark = validateAndSetMark(proposalMark);
        } catch (IllegalMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Getter method for retrieving the final dissertation mark.
     * 
     * @return The final dissertation mark.
     */
    public int getFinalDissertationMark() {
        return finalDissertationMark;
    }

    /**
     * Setter method for setting the final dissertation mark.
     * 
     * @param finalDissertationMark The final dissertation mark to be set.
     */
    public void setFinalDissertationMark(int finalDissertationMark) {
        try {
            // Validate and ensure that the final dissertation mark is within the valid range (0 to MAX_MARK)
            this.finalDissertationMark = validateAndSetMark(finalDissertationMark);
        } catch (IllegalMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Calculates and returns the overall mark for the research course.
     * 
     * @return The overall mark based on research proposal and final dissertation marks.
     */
    public double overallMark() {
        return (proposalMark * 0.35) + (finalDissertationMark * 0.65);
    }

    /**
     * Calls the finalGrade method from the superclass (Unit),
     * using the overall mark calculated by the overallMark method.
     * 
     * @return The final grade for the research course.
     */
    public String finalGrade() {
        double overallMark = overallMark();
        return super.finalGrade(overallMark);
    }

    // Helper method to validate and set the mark
    /**
     * Validates and sets the mark for a certain operation.
     *
     * This method is used to ensure that the provided mark is within the valid range.
     *
     * Precondition: The mark parameter should represent a numerical value.
     * Postconditions: The mark is set if it is within the valid range (0 to MAX_MARK).
     *
     * @param mark The mark to be validated and set.
     * @return The validated mark.
     * @throws IllegalMarkException If the provided mark is outside the valid range.
     */
    private int validateAndSetMark(int mark) throws IllegalMarkException {
        if (mark < 0 || mark > MAX_MARK) {
            throw new IllegalMarkException("Mark must be between 0 and " + MAX_MARK);
        }
        return mark;
    }
}
