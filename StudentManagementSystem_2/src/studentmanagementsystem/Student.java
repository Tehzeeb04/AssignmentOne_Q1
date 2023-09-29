package studentmanagementsystem;
import java.util.ArrayList;
import java.util.Scanner;

public class Student 
{
    private String studentName;
    private int studentAge;
    private int studentID;
    private String studentEmail;
    private String studentCourse;
    private static final Scanner scanner = new Scanner(System.in);

    public Student(int id, String name, int age, String email, String course) {
        studentID = id;
        studentName = name;
        studentAge = age;
        studentEmail = email;
        studentCourse = course;
    }

   
    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }
    
    

    // Capture a new student
    public void SaveStudent(int idCounter) {
        int id;
        while (true) {
            try {
                System.out.print("Enter the student id: ");
                id = scanner.nextInt();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for student ID. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        studentID = id;
        // Get student name with spaces allowed
        while (true) {
            System.out.print("Enter the student name: ");
            String name = scanner.nextLine();
            if (name.matches("^[a-zA-Z ]+$")) {
                studentName = name;
                break;
            } else {
                System.out.println("Invalid name. Please enter a name with only letters and spaces.");
            }
        }
        int age;
        while (true) {
            try {
                System.out.print("Enter the student age: ");
                age = scanner.nextInt();
                if (age >= 16) {
                    break;
                } else {
                    System.out.println("Invalid age. Age must be 16 or older.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid age.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        studentAge = age;
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the student email: ");
        studentEmail = scanner.nextLine();

        System.out.print("Enter the student course: ");
        studentCourse = scanner.nextLine();

        System.out.println("Student details saved successfully.");
    }

    // Search for a student
    public Student searchStudent(ArrayList<Student> students, int searchID) {
        for (Student student : students) {
            if (student.getStudentID() == searchID) {
                return student;
            }
        }
        return null;
    }

    // Delete a student
    public void deleteStudent(ArrayList<Student> students, int deleteID) {
        Student studentToDelete = null;
        for (Student student : students) {
            if (student.getStudentID() == deleteID) {
                studentToDelete = student;
                break;
            }
        }
        if (studentToDelete != null) {
            students.remove(studentToDelete);
            System.out.println("Student with Student ID: " + deleteID + " was deleted!");
        } else {
            System.out.println("Student with Student ID: " + deleteID + " was not found!");
        }
    }

    // View student report
    public String viewStudentReport(ArrayList<Student> students) {
        StringBuilder report = new StringBuilder("STUDENT REPORT\n");

        for (Student student : students) {
            report.append("STUDENT ID: ").append(student.getStudentID()).append("\n")
                    .append("STUDENT NAME: ").append(student.getStudentName()).append("\n")
                    .append("STUDENT AGE: ").append(student.getStudentAge()).append("\n")
                    .append("STUDENT EMAIL: ").append(student.getStudentEmail()).append("\n")
                    .append("STUDENT COURSE: ").append(student.getStudentCourse()).append("\n")
                    .append("-----------------------\n");
        }

        return report.toString();
    }
}
