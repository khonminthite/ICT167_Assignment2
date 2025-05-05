/**
 * Student_Course class represents a student enrolled in a Unit course.
 * <p>
 * This class extends the Student class and includes additional functionality
 * related to unit courses.
 * </p>
 * <p>
 * Precondition: The Student_Course class assumes that the Unit_Course class
 * is properly implemented and accessible.
 * </p>
 * <p>
 * Postcondition: An instance of Student_Course can be used to store information
 * about a student and the unit course they are enrolled in.
 * </p>
 * 
 * @author [Khon Min Thite]
 * @version 1.0
 */
public class Student_Course extends Student {

    // Private instance variable to store the unit course associated with the student
    private Unit_Course unitCourse;

    /**
     * Parameterized constructor for Student_Course.
     * Initializes the Student_Course with enrollment type, first name, last name, and student number.
     * 
     * @param enrolmentType The type of enrollment for the student.
     * @param firstName     The first name of the student.
     * @param lastName      The last name of the student.
     * @param studentNumber The unique identifier for the student.
     */
    public Student_Course(String enrolmentType, String firstName, String lastName, long studentNumber) {
        super("C", firstName, lastName, studentNumber);
    }

    /**
     * Getter method for retrieving the unit course associated with the student.
     * 
     * @return The Unit_Course object representing the unit course.
     */
    public Unit_Course getUnitCourse() {
        return unitCourse;
    }

    /**
     * Setter method for setting the unit course associated with the student.
     * 
     * @param unitCourse The Unit_Course object to be set.
     */
    public void setUnitCourse(Unit_Course unitCourse) {
        this.unitCourse = unitCourse;
    }

    /**
     * Overrides the reportGrade method in the superclass (Student).
     * Displays information about the student and their unit course, including unit ID,
     * unit level, overall mark, and final grade.
     */
    @Override
    public void reportGrade() {
        // Call the display method from the superclass (Student)
        display();

        // Display additional information about the unit course
        System.out.println("Unit ID: " + unitCourse.getUnitID() + "\n"
                + "Unit level: " + unitCourse.getLevel() + "\n"
                + "The Overall mark: " + unitCourse.overallMark() + "\n"
                + "The final grade: " + unitCourse.finalGrade());
    }
}