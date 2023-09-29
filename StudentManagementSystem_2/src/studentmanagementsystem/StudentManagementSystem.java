package studentmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem 
{
    private static final ArrayList<Student> students = new ArrayList<>();
    private static int studentIDCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        Menu();
    }

    // Allows the user to make a choice in the program
    public static void Menu() 
    {
        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("*******************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");

            String userInput = scanner.nextLine();

            if (!userInput.equals("1")) {
                System.out.println("Exiting the application.");
                System.exit(0);
            }

            String[] options = {"Capture a new student", "Search for a student", "Delete a student", "Print student report", "Exit Application"};
            System.out.println("Student Management System");
            System.out.println("Menu:");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int choice = getIntInput("Enter your choice: ");

            Student student = new Student(0, "", 0, "", ""); // Create a new student

            switch (choice) {
                case 1:
                    student.SaveStudent(studentIDCounter++);
                    students.add(student);
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewStudentReport();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    //Calling the search method
    public static void searchStudent() {
        int searchID;
        try {
            searchID = getIntInput("Enter the student id to search: ");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for student ID. Please enter a number.");
            return;
        }

        Student foundStudent = new Student(0, "", 0, "", "").searchStudent(students, searchID);
        if (foundStudent != null) {
            System.out.println("STUDENT ID: " + foundStudent.getStudentID());
            System.out.println("STUDENT NAME: " + foundStudent.getStudentName());
            System.out.println("STUDENT AGE: " + foundStudent.getStudentAge());
            System.out.println("STUDENT EMAIL: " + foundStudent.getStudentEmail());
            System.out.println("STUDENT COURSE: " + foundStudent.getStudentCourse());
        } else {
            System.out.println("Student with Student ID: " + searchID + " was not found!");
        }
    }
    
    //Calling the delete student method
    public static void deleteStudent() {
        int deleteID;
        try {
            deleteID = getIntInput("Enter the student id to delete: ");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for student ID. Please enter a number.");
            return;
        }

        new Student(0, "", 0, "", "").deleteStudent(students, deleteID);
    }

    public static void viewStudentReport() {
        String report = new Student(0, "", 0, "", "").viewStudentReport(students);
        System.out.println(report);
    }

    // Helper method to get integer input from the user
    private static int getIntInput(String message) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(message);
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return input;
    }
}
