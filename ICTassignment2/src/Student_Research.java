/**
 * Student_Research class represents a student enrolled in a research.
 * <p>
 * This class extends the Student class and includes additional functionality
 * related to research courses.
 * </p>
 * <p>
 * Precondition: The Research_Course class is assumed to be properly implemented
 * and accessible for this class to function correctly.
 * </p>
 * <p>
 * Postcondition: An instance of Student_Research can be used to store information
 * about a student enrolled in a research course.
 * </p>
 * 
 * @author [Khon Min Thite]
 * @version 1.0
 */
public class Student_Research extends Student {

    // Private instance variable to store the research course associated with the student
    private Research_Course researchCourse;

    /**
     * Parameterized constructor for Student_Research.
     * Initializes the Student_Research with enrollment type, first name, last name, and student number.
     * 
     * @param enrolmentType The type of enrollment for the student.
     * @param firstName     The first name of the student.
     * @param lastName      The last name of the student.
     * @param studentNumber The unique identifier for the student.
     */
    public Student_Research(String enrolmentType, String firstName, String lastName, long studentNumber) {
        super("R", firstName, lastName, studentNumber);
    }

    /**
     * Getter method for retrieving the research course associated with the student.
     * 
     * @return The Research_Course object representing the research course.
     */
    public Research_Course getResearchCourse() {
        return researchCourse;
    }

    /**
     * Setter method for setting the research course associated with the student.
     * 
     * @param researchCourse The Research_Course object to be set.
     */
    public void setResearchCourse(Research_Course researchCourse) {
        this.researchCourse = researchCourse;
    }

    /**
     * Overrides the reportGrade method in the superclass (Student).
     * Displays information about the student and their research course, including
     * overall mark and final grade.
     */
    @Override
    public void reportGrade() {
        // Call the display method from the superclass (Student)
        display();

        // Display additional information about the research course
        System.out.println("The Overall mark: " + researchCourse.overallMark() + "\n"
                + "The final grade: " + researchCourse.finalGrade());
    }
}
