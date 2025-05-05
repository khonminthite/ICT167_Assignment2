/**
 * Unit_Course Class
 * <p>
 * This class extends the Unit class and represents a specific course unit with additional attributes
 * such as unit ID, level, assignment marks, and final exam mark.
 * </p>
 * <p>
 * Preconditions: The Unit class must be defined.
 * Postconditions: A Unit_Course object is created with specified attributes.
 * </p>
 * 
 * @author [Khon Min Thite]
 * @version 1.0
 */
public class Unit_Course extends Unit {
    
    // Attributes
    private String unitID;
    private int level, assignment1Mark, assignment2Mark, finalExamMark;
    private static final int MAX_MARK = 100;
    
    // Constructors
    
    /**
     * Parameterized constructor for Unit_Course.
     * Initializes attributes with the provided values.
     *
     * @param unitID          The unique identifier of the unit.
     * @param level           The level of the unit.
     * @param assignment1Mark Marks obtained in the first assignment.
     * @param assignment2Mark Marks obtained in the second assignment.
     * @param finalExamMark   Marks obtained in the final exam.
     */
    public Unit_Course(String unitID, int level, int assignment1Mark, int assignment2Mark, int finalExamMark) {
        super("C");
        this.unitID = unitID;
        this.level = level;
        this.setAssignment1Mark(assignment1Mark);
        this.setAssignment2Mark(assignment2Mark);;
        this.setFinalExamMark(finalExamMark);;
    }

    // Getters and Setters
    /**
     * Gets the unit ID.
     *
     * @return The unit ID.
     */
    public String getUnitID() {
        return unitID;
    }

    /**
     * Sets the unit ID.
     *
     * @param unitID The unit ID to be set.
     */
    public void setUnitID(String unitID) {
        this.unitID = unitID;
    }

    /**
     * Gets the level of the unit.
     *
     * @return The level of the unit.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level of the unit.
     *
     * @param level The level to be set.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the marks obtained in the first assignment.
     *
     * @return Marks obtained in the first assignment.
     */
    public int getAssignment1Mark() {
        return assignment1Mark;
    }

    /**
     * Sets the marks obtained in the first assignment.
     *
     * @param assignment1Mark Marks obtained in the first assignment.
     */
    public void setAssignment1Mark(int assignment1Mark) {
        try {
            // Validate and ensure that the marks are within the valid range (0 to MAX_MARK)
            this.assignment1Mark = validateAndSetMark(assignment1Mark);
        } catch (IllegalMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Gets the marks obtained in the second assignment.
     *
     * @return Marks obtained in the second assignment.
     */
    public int getAssignment2Mark() {
        return assignment2Mark;
    }

    /**
     * Sets the marks obtained in the second assignment.
     *
     * @param assignment2Mark Marks obtained in the second assignment.
     */
    public void setAssignment2Mark(int assignment2Mark) {
        try {
            // Validate and ensure that the marks are within the valid range (0 to MAX_MARK)
            this.assignment2Mark = validateAndSetMark(assignment2Mark);
        } catch (IllegalMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Gets the marks obtained in the final exam.
     *
     * @return Marks obtained in the final exam.
     */
    public int getFinalExamMark() {
        return finalExamMark;
    }

    /**
     * Sets the marks obtained in the final exam.
     *
     * @param finalExamMark Marks obtained in the final exam.
     */
    public void setFinalExamMark(int finalExamMark) {
        try {
            // Validate and ensure that the marks are within the valid range (0 to MAX_MARK)
            this.finalExamMark = validateAndSetMark(finalExamMark);
        } catch (IllegalMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Methods

    /**
     * Calculates and returns the overall mark for the unit.
     *
     * @return The overall mark for the unit.
     */
    public double overallMark() {
        return (assignment1Mark * 0.25) + (assignment2Mark * 0.25) + (finalExamMark * 0.5);
    }

    /**
     * Calculates and returns the final grade based on the overall mark.
     *
     * @return The final grade for the unit.
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
