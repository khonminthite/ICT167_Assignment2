/**
 * The Student class represents a student with information such as name, student number, and enrollment type.
 * <p>
 * This class provides constructors for creating a student with different combinations of information.
 * It also includes getter and setter methods for accessing and modifying the student's attributes.
 * </p>
 * <p>
 * Additionally, methods for reporting grades, comparing students based on student numbers, and 
 * displaying student details are included.
 * </p>
 * <p>
 * The class follows a simple structure with private instance variables and corresponding accessor and mutator methods.
 * </p>
 * 
 * @author [Khon Min Thite]
 * @version 1.0
 */
public class Student {

    // Private instance variables to store student information
    private String firstName;
    private String lastName;
    private long studentNumber;
    protected String enrolmentType;

    /** 
     * Default constructor initializes instance variables with default values
     */
    public Student() {
        this.firstName = "No firstName";
        this.lastName = "No lastName";
        this.studentNumber = -1;
    }

    // Constructor with parameters to initialize all instance variables
    /**
     * Constructs a new Student with specified enrollment type, first name, last name, and student number.
     * @param enrolmentType The type of enrollment for the student.
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     * @param studentNumber The unique student number.
     */
    public Student(String enrolmentType, String firstName, String lastName, long studentNumber) {
        this.enrolmentType = enrolmentType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    // Constructor to initialize name
    /**
     * Constructs a new Student with specified first name and last name.
     * @param enrolmentType The type of enrollment for the student.
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     */
    public Student(String enrolmentType,String firstName, String lastName) {
    	this.enrolmentType = enrolmentType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = -1;
    }

    // Constructor to initialize student number (ID)
    /**
     * Constructs a new Student with specified student number.
     * @param enrolmentType The type of enrollment for the student.
     * @param studentNumber The unique student number.
     */
    public Student(String enrolmentType,long studentNumber) {
    	this.enrolmentType = enrolmentType;
        this.firstName = "No firstName";
        this.lastName = "No lastName";
        this.studentNumber = studentNumber;
    }

    // Getter and Setter methods for firstName
    /**
     * Gets the first name of the student.
     * @return The first name of the student.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     * @param firstName The new first name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter methods for lastName
    /**
     * Gets the last name of the student.
     * @return The last name of the student.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     * @param lastName The new last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter methods for studentNumber
    /**
     * Gets the student number.
     * @return The student number.
     */
    public long getStudentNumber() {
        return studentNumber;
    }

    /**
     * Sets the student number.
     * @param studentNumber The new student number.
     */
    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * Gets the enrollment type of the student.
     * @return The enrollment type.
     */
    public String getEnrolmentType() {
        return enrolmentType;
    }

    /**
     * Sets the enrollment type of the student.
     * @param enrolmentType The new enrollment type.
     */
    public void setEnrolmentType(String enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    /**
     * Reports the grade of the student.
     */
    public void reportGrade() {
        System.out.println("There is no grade here.");
    }

    /**
     * Checks if two students are equal based on their student numbers.
     * @param otherStudent The other student to compare.
     * @return True if the student numbers are equal, otherwise false.
     */
    public boolean equals(Student otherStudent) {
        return this.studentNumber == otherStudent.getStudentNumber();
    }

    /**
     * Displays the details of the student.
     */
    public void display() {
        System.out.println("Enrolment Type: " + this.enrolmentType);
        System.out.println("Student Name: " + this.firstName + " " + this.lastName);
        System.out.println("Student Number: " + this.studentNumber);
    }
}
