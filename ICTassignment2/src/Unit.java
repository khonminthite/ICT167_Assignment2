/**
 * Unit class represents a generic unit of study.
 * <p>
 * This class provides functionality for managing the enrollment type and
 * reporting final grades based on overall marks.
 * </p>
 * <p>
 * Precondition: The overallMark parameter in the finalGrade method should be
 * a valid double value representing the overall performance of a student in the unit.
 * </p>
 * <p>
 * Postcondition: An instance of the Unit class can be used to store and retrieve
 * information about a unit, including enrollment type and final grades.
 * </p>
 * 
 * @author [Khon Min Thite]
 * @version 1.0
 */
public class Unit {

    // Private instance variable to store the enrollment type of the unit
    private String enrolmentType;

    /**
     * Parameterized constructor for the Unit class.
     * Initializes the Unit with a specified enrollment type.
     * 
     * @param enrolmentType The type of enrollment for the unit.
     */
    public Unit(String enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    /**
     * Getter method for retrieving the enrollment type of the unit.
     * 
     * @return The enrollment type of the unit.
     */
    public String getEnrolmentType() {
        return enrolmentType;
    }

    /**
     * Setter method for setting the enrollment type of the unit.
     * 
     * @param enrolmentType The enrollment type to be set.
     */
    public void setEnrolmentType(String enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    /**
     * Reports the final grade for the unit.
     * This method is a placeholder that simply prints "NA" as the final grade.
     */
    public void reportFinalGrade() {
        System.out.println("NA");
    }

    /**
     * Determines and returns the final grade based on the overall mark.
     * 
     * @param overallMark The overall mark representing the student's performance in the unit.
     * @return The final grade (e.g., "HD", "D", "C", "P", or "N").
     */
    public String finalGrade(double overallMark) {
        if (overallMark >= 80) {
            return "HD";
        } else if (overallMark >= 70) {
            return "D";
        } else if (overallMark >= 60) {
            return "C";
        } else if (overallMark >= 50) {
            return "P";
        } else {
            return "N";
        }
    }    
}
   
