import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The `Client` class serves as the main entry point for the Student Grade System program.
 * It provides a menu-driven interface for managing student information.
 *
 * <p>This class includes methods to perform operations such as adding new students, updating grades,
 * and generating reports.</p>
 *
 * @author [Khon Min Thite]
 * @version 1.0
 */
public class Client {

	/**
	 * ArrayList that contain student objects.
	 */
    private static ArrayList<Student> students = new ArrayList<>();

    /**
     * The main method that drives the Student Grade System program.
     * 
     * This method provides a menu-driven interface for managing student information.
     * Users can perform various operations like loading data from a file, displaying
     * student details, removing a student, analyzing grades, and more.
     * 
     * <p>
     * Precondition: The program assumes that the necessary methods (e.g., 
     * loadStudentsInformationFromFile, removeStudentByStudentNumber, etc.) are 
     * implemented and handle their respective functionalities correctly.
     * </p>
     * 
     * <p>
     * Postconditions: The program exits when the user chooses option 1 to exit the
     * program. The state of the students' information may be modified based on user
     * actions during the program's execution.
     * </p>
     * 
     * @param args Command line arguments (not used in this program).
     * @throws IOException         If an I/O error occurs during file operations.
     * @throws InputMismatchException If the user enters invalid input.
     * @throws NotSortedException    If student ArrayList is not sorted.
     */
    public static void main(String[] args) throws IOException,InputMismatchException, NotSortedException {
        Scanner sc = new Scanner(System.in);

        studentInformation();

        System.out.println("=======================================");
        System.out.println("Student Grade System program starting");
        System.out.println("=======================================");

        try {
            loadStudentsInformationFromFile(students, "C:\\Users\\Acer\\eclipse-workspace\\ICTassignment2\\src\\student_mark.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file path and try again.");
        }

        int choice = 0;

        do {
            menuDisplay();

            System.out.println("Please enter your choice: ");
            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    case 2:
                        System.out.println("Please enter your file name (file source): ");
                        String fileName = sc.nextLine();
                        try {
                            loadStudentsInformationFromFile(students, fileName);
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found. Please check the file path and try again.");
                        }
                        break;

                    case 3:
                        System.out.println("Please enter a student number to remove: ");
                        long studentNumber = sc.nextLong();
                        sc.nextLine();
                        removeStudentByStudentNumber(studentNumber);
                        break;

                    case 4:
                        displayAllStudentDetails(students);
                        break;

                    case 5:
                        analyzeStudentGrades(students);
                        break;

                    case 6:
                        System.out.println("Please enter the student number: ");
                        studentNumber = sc.nextLong();
                        sc.nextLine();
                        reportGradeOfStudent(students, studentNumber);
                        break;

                    case 7:
                        sortStudentsByStudentNumber(students);
                        displayAllStudentDetails(students);
                        System.out.println("Students sorted by student number: ");
                        break;

                    case 8:
                        System.out.println("Please enter the file name to save the sorted students (CSV format): ");
                        fileName = sc.nextLine();
                        try {
                            outputSortedStudentsToCSV(students, fileName);
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found. Please check the file path and try again.");
                        } catch (IOException e) {
                            System.out.println("An error occurred while writing to the file. Please try again.");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice option");
                        break;
                } 
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        } while (choice != 1);

        sc.close();
    }
    /**
     * Displays student information.
     */
    public static void studentInformation() {
        System.out.println("Title: ICT167 Assignment 2");
        System.out.println("Author / Student Name: Khon Min THite");
        System.out.println("Student ID: 35141021");
        System.out.println("Unit Code: ICT167");
        System.out.println("Unit Name: Principles of Computer Science");
        System.out.println("Professor: Aaron Yeo");
        System.out.println("File Name: client.java");
        System.out.println("Date: 18 November 2023");
    }

    /**
     * Displays the menu options for the program.
     */
    public static void menuDisplay() {
        System.out.println("\nMenu Options:\r\n"
                + "1. Quit: Exit the program.\r\n"
                + "2. Add student information from a CSV file.\r\n"
                + "3. Remove a student by student number.\r\n"
                + "4. Display all student details.\r\n"
                + "5. Analyze students' grades.\r\n"
                + "6. Report grade of a student by student number.\r\n"
                + "7. Sort students by student number.\r\n"
                + "8. Output sorted students to a CSV file.\r\n"
                + "");
    }
    
//  --------------------------------------------------------------------------------------------------------------------------------------------------
//  8 Options display menu logic function
	
    
    /**
     * Loads student information from a file and populates the provided ArrayList of Student objects.
     *
     * @param students  The ArrayList to store the loaded Student objects.
     * @param fileName  The name of the file containing student information.
     * @throws NumberFormatException If invalid format
     * @throws FileNotFoundException If file is not found.
     */
    public static void loadStudentsInformationFromFile(ArrayList<Student> students, String fileName) throws NumberFormatException,FileNotFoundException  {
        try {
            // Open the file and create a Scanner to read its contents
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            // Iterate through each line in the file
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                // Check if the data length is sufficient for Course Work students
                if (data.length >= 9) {
                    String enrolmentType = data[0].trim().toUpperCase();
                    String firstName = data[1].trim();
                    String lastName = data[2].trim();

                    long studentNumber;
                    try {
                        studentNumber = Long.parseLong(data[3].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid student number format: " + data[3]);
                        continue;
                    }

                    if (enrolmentType.equalsIgnoreCase("C")) {
                        // Extract Course Work specific data
                        String unitId = data[4].trim();
                        int level = Integer.parseInt(data[5].trim());

                        // Check if the assignment and exam marks are valid integer values
                        int assignment1Mark, assignment2Mark, finalExamMark;
                        try {
                            assignment1Mark = Integer.parseInt(data[6].trim());
                            assignment2Mark = Integer.parseInt(data[7].trim());
                            finalExamMark = Integer.parseInt(data[8].trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid marks format for course work student: " + line);
                            continue;
                        }

                        // Create Unit_Course and Student_Course instances
                        Unit_Course unitCourse = new Unit_Course(unitId, level, assignment1Mark, assignment2Mark, finalExamMark);
                        Student_Course studentCourse = new Student_Course(enrolmentType, firstName, lastName, studentNumber);
                        studentCourse.setUnitCourse(unitCourse);

                        students.add(studentCourse);
                    }
                }

                // Check if the data length is sufficient for Research students
                if (data.length >= 6) {
                    String enrolmentType = data[0].trim().toUpperCase();
                    String firstName = data[1].trim();
                    String lastName = data[2].trim();

                    long studentNumber;
                    try {
                        studentNumber = Long.parseLong(data[3].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid student number format: " + data[3]);
                        continue;
                    }

                    if (enrolmentType.equalsIgnoreCase("R")) {
                        // Extract Research specific data
                        int proposalMark, dissertationMark;
                        try {
                            proposalMark = Integer.parseInt(data[4].trim());
                            dissertationMark = Integer.parseInt(data[5].trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid marks format for research student: " + line);
                            continue;
                        }

                        // Create Research_Course and Student_Research instances
                        Research_Course research = new Research_Course(proposalMark, dissertationMark);
                        Student_Research studentResearch = new Student_Research(enrolmentType, firstName, lastName, studentNumber);
                        studentResearch.setResearchCourse(research);

                        students.add(studentResearch);
                    }
                }
            }

            // Close the Scanner after reading the file
            sc.close();
            System.out.println("Loaded student information successfully from the file.");
        } catch (FileNotFoundException e) {
        	System.out.println("File not Found: " + fileName);
        } catch (Exception e) {
            System.out.println("Error while loading the file.");
            e.printStackTrace();
        }
    }

    
    /**
     * Removes a student from the ArrayList based on the provided student number after user confirmation.
     *
     * @param studentNumber The student number of the student to be removed.
     */
    public static void removeStudentByStudentNumber(long studentNumber) {
        if (studentNumber < 0) {
            System.out.println("Invalid student number. Please enter a non-negative value.");
            return;
        }
        // Initialize a reference to the student to be removed
        Student removeStudent = null;

        // Search for the student in the list by their student number
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                // If found, assign the student to the removeStudent variable and break the loop
                removeStudent = student;
                break;
            }
        }

        // Check if the student was found
        if (removeStudent != null) {
            // If the student is found, display the student's information and ask for confirmation
            System.out.println("Please confirm if you want to remove this student: ");
            System.out.println("Student number: " + removeStudent.getStudentNumber());
            System.out.println("Student name: " + removeStudent.getFirstName() + " " + removeStudent.getLastName());
            System.out.println("Student type: " + (removeStudent instanceof Student_Course ? "Course Work" : "Research"));
            System.out.println("If you are confirm, please press 'Y', or press any key to cancel");

            // Read user input for confirmation
            Scanner sc = new Scanner(System.in);
            String confirm = sc.nextLine();

            // Check if the user confirms the removal
            if (confirm.equalsIgnoreCase("Y")) {
                // If confirmed, remove the student from the list
                students.remove(removeStudent);
                System.out.println("Student successfully removed.");
            } else {
                // If canceled, display a message indicating that the removal was canceled
                System.out.println("Removal canceled. Student is not removed.");
            }

        } else {
            // If the student is not found, display a message indicating that the student was not found
            System.out.println("Student with student number " + studentNumber + " was not found!");
        }
     
    }
    
    /**
     * Displays detailed information for all students in the provided ArrayList.
     *
     * @param students The ArrayList containing the Student objects to be displayed.
     */
    public static void displayAllStudentDetails(ArrayList<Student> students) {
        System.out.println("Student detail list: ");
        for (Student student : students) {
            // Display common student details: type, name, and student number
            student.display();

            // Check if the student is of type Student_Course (course work student)
            if (student instanceof Student_Course) {
                // If the student is of type Student_Course, cast the student to Student_Course type
                Student_Course courseStudent = (Student_Course) student;

                // Check if the associated Unit_Course exists
                Unit_Course unitCourse = courseStudent.getUnitCourse();
                if (unitCourse != null) {
                    // If the associated Unit_Course exists, display its details: unit ID, Assignment 1 Mark, Assignment 2 Mark, Final Exam Mark
                    System.out.println("Unit ID: " + unitCourse.getUnitID());
                    System.out.println("Unit Level: " + unitCourse.getLevel());
                    System.out.println("Assignment 1 Mark: " + unitCourse.getAssignment1Mark());
                    System.out.println("Assignment 2 Mark: " + unitCourse.getAssignment2Mark());
                    System.out.println("Final Exam Mark: " + unitCourse.getFinalExamMark());
                } else {
                    // If no associated Unit_Course, display a message indicating it
                    System.out.println("No Unit Course Information");
                }
            }
            // Check if the student is of type Student_Research (research student)
            else if (student instanceof Student_Research) {
                // If the student is of type Student_Research, cast the student to Student_Research type
                Student_Research researchStudent = (Student_Research) student;

                // Check if the associated Research exists
                Research_Course researchCourse = researchStudent.getResearchCourse();
                if (researchCourse != null) {
                    // If the associated Research exists, display its details: proposal mark and final dissertation mark
                    System.out.println("Proposal Mark: " + researchCourse.getProposalMark());
                    System.out.println("Final Dissertation Mark: " + researchCourse.getFinalDissertationMark());
                    // You can add more research-related details here if needed
                } else {
                    // If no associated Research, display a message indicating it
                    System.out.println("No Research Information");
                }
            }
            System.out.println(); // Add an empty line between each student's details
        }
    }

    /**
     * Analyzes student grades based on their overall marks, displaying average overall marks,
     * and the number of students above and below the average.
     *
     * @param students The ArrayList containing the Student objects to be analyzed.
     */
    public static void analyzeStudentGrades(ArrayList<Student> students) {
        int totalMarks = 0;
        int numCourseWorkStudents = 0;
        int numResearchStudents = 0;

        // Calculate the total marks and count the number of course work students
        for (Student student : students) {
            // Check if the student is of type Student_Course (course work student)
            if (student instanceof Student_Course) {
                // If the student is of type Student_Course, cast the student to Student_Course type
                Student_Course courseStudent = (Student_Course) student;

                // Check if the associated Unit_Course exists
                Unit_Course unitCourse = courseStudent.getUnitCourse();
                if (unitCourse != null) {
                    // If the associated Unit_Course exists, add the overall mark to the total and increment the count
                    totalMarks += unitCourse.overallMark();
                    numCourseWorkStudents++;
                }
            }
            if (student instanceof Student_Research) {
                Student_Research researchStudent = (Student_Research) student;

                Research_Course researchCourse = researchStudent.getResearchCourse();

                if (researchCourse != null) {
                    totalMarks += researchCourse.overallMark();
                    numResearchStudents++;
                }
            }
        }

        // Calculate the average overall mark for course work students
        double averageOverallMark = (double) totalMarks / (numCourseWorkStudents + numResearchStudents);

        // Count the number of course work students above and below the average overall mark
        int numAboveAverage = 0;
        int numBelowAverage = 0;
        for (Student student : students) {
            // Check if the student is of type Student_Course (course work student)
            if (student instanceof Student_Course) {
                // If the student is of type Student_Course, cast the student to Student_Course type
                Student_Course courseStudent = (Student_Course) student;

                // Check if the associated Unit_Course exists
                Unit_Course unitCourse = courseStudent.getUnitCourse();
                if (unitCourse != null) {
                    // If the associated Unit_Course exists, get the overall mark
                    double overallMark = unitCourse.overallMark();

                    // Compare the overall mark with the average and increment the respective counters
                    if (overallMark >= averageOverallMark) {
                        numAboveAverage++;
                    } else {
                        numBelowAverage++;
                    }
                }
            }

            if (student instanceof Student_Research) {
                Student_Research researchStudent = (Student_Research) student;

                Research_Course researchCourse = researchStudent.getResearchCourse();
                if (researchCourse != null) {
                    double overallMark = researchCourse.overallMark();

                    if (overallMark >= averageOverallMark) {
                        numAboveAverage++;
                    } else {
                        numBelowAverage++;
                    }
                }
            }
        }

        // Display the results
        System.out.println("Student grades analysis:");
        System.out.println("Average overall mark: " + String.format("%.2f", averageOverallMark));
        
        System.out.println("Number of students below average Mark: " + numBelowAverage);
        System.out.println("Number of students above average Mark: " + numAboveAverage);
    }
    
    /**
     * Reports the grade of a student with a given student number.
     * If the student is found, their grade is reported; otherwise, a message is printed.
     *
     * @param students      The ArrayList of Student objects to search through.
     * @param studentNumber The student number of the student whose grade is to be reported.
     */
    public static void reportGradeOfStudent(ArrayList<Student> students, long studentNumber) {
        boolean found = false;

        // Search for the student with the given student number
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                found = true;
                student.reportGrade();
                // Exit the loop since the student has been found
                break;
            }
        }

        // If no student with the given student number is found, print a message indicating so
        if (!found) {
            System.out.println("Student with student number " + studentNumber + " was not found.");
        }
    }

    /**
     * Sorts an ArrayList of Student objects based on their student numbers using sorting algorithm.
     *
     * @param students The ArrayList of Student objects to be sorted.
     */
    public static void sortStudentsByStudentNumber(ArrayList<Student> students) {
        int n = students.size();

        // Apply Bubble Sort algorithm to sort the students based on their student numbers
        for (int i = 0; i < n-1; ++i) {
            for (int j = 0; j < n - i-1; ++j) {
                // Compare adjacent elements and swap them if they are in the wrong order
                if (students.get(j).getStudentNumber() > students.get(j+1).getStudentNumber()) {
                    // Swap students[j] and students[j+1]
                	Student temp = students.get(j);
                	students.set(j , students.get(j+1));
                    students.set(j+1, temp);
                }
            }
                       
        }
    }
    
    /**
     * Checks if an ArrayList of Student objects is sorted by student number.
     *
     * <p>
     * Precondition: The input ArrayList students contains objects of type Student.
     * Postconditions:
     * - The original order of students is preserved.
     * - The students are sorted in ascending order based on their student numbers.
     * </p>
     *
     * @param students An ArrayList of Student objects to be checked for sorting.
     * @return true if the ArrayList is sorted by student number, false otherwise.
     * @throws NullPointerException if students is null.
     */
    private static boolean isSorted(ArrayList<Student> students) {
        // Create a copy of the original ArrayList to compare after sorting
        ArrayList<Student> original = new ArrayList<>(students);

        // Sort the students by their student numbers
        sortStudentsByStudentNumber(students);

        // Check if the original ArrayList is equal to the sorted ArrayList
        return original.equals(students);
    }   
    
    /**
     * Outputs the sorted student data to a CSV file.
     *
     * @param students The ArrayList of Student objects containing sorted data.
     * @param fileName The name of the CSV file to write the data to.
     * @throws IOException If writing to CSV file fails.
     * @throws NotSortedException If ArrayList is not sorted
     */
    public static void outputSortedStudentsToCSV(ArrayList<Student> students, String fileName) throws IOException, NotSortedException {
    	
        if (!isSorted(students)) {
        	throw new NotSortedException("ArrayList is not sorted. Please sort it first (Option 7).");
        }
    		
        try {
            StringBuilder csvData = new StringBuilder();
            csvData.append("EnrolmentType,FirstName,LastName,StudentNumber,UnitID,Level,Assignment1Mark,Assignment2Mark,FinalExamMark,ProposalMark,DissertationMark\n");

            // Write the sorted student data to the CSV string
            for (Student student : students) {
                String enrolmentType = student instanceof Student_Course ? "C" : "R";
                String firstName = student.getFirstName();
                String lastName = student.getLastName();
                long studentNumber = student.getStudentNumber();

                if (student instanceof Student_Course) {
                    Student_Course courseStudent = (Student_Course) student;
                    Unit_Course unitCourse = courseStudent.getUnitCourse();
                    String unitID = unitCourse.getUnitID();
                    int level = unitCourse.getLevel();
                    int assignment1Mark = unitCourse.getAssignment1Mark();
                    int assignment2Mark = unitCourse.getAssignment2Mark();
                    int finalExamMark = unitCourse.getFinalExamMark();

                    // Append the course student information to the CSV data
                    csvData.append(String.format("%s,%s,%s,%d,%s,%d,%d,%d,%d,,\n",
                            enrolmentType, firstName, lastName, studentNumber,
                            unitID, level, assignment1Mark, assignment2Mark, finalExamMark));
                } else if (student instanceof Student_Research) {
                    Student_Research researchStudent = (Student_Research) student;
                    Research_Course researchCourse = researchStudent.getResearchCourse();
                    int proposalMark = researchCourse.getProposalMark();
                    int dissertationMark = researchCourse.getFinalDissertationMark();

                    // Append the research student information to the CSV data
                    csvData.append(String.format("%s,%s,%s,%d,,,,,,%d,%d\n",
                            enrolmentType, firstName, lastName, studentNumber,
                            proposalMark, dissertationMark));
                }
            }
            // Write the CSV string to a file using java.nio.file.Files
            java.nio.file.Files.write(java.nio.file.Paths.get(fileName), csvData.toString().getBytes());
            System.out.println("Sorted students successfully output to CSV file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + fileName);
        }
    }
    
}
