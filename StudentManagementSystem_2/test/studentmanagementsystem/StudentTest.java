/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Windows 10 Pro
 */
public class StudentTest {
    private ArrayList<Student> students;

    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing has begun...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("...Testing has ended.");
    }
    
    @Before
    public void setUp() {
    // Create a list of students for testing
    students = new ArrayList<>();
    students.add(new Student(1, "John Doe", 20, "john@example.com", "Math"));
    students.add(new Student(2, "Jane Smith", 22, "jane@example.com", "Science"));
}

    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSaveStudent() {
        Student student = new Student(0, "", 0, "", "");

        // Set sample values directly in the Student object
        student.setStudentID(3);
        student.setStudentName("Sample Name");
        student.setStudentAge(18);
        student.setStudentEmail("sample@email.com");
        student.setStudentCourse("Sample Course");


        // Assert that the student object has been correctly updated
        assertEquals(3, student.getStudentID());
        assertEquals("Sample Name", student.getStudentName());
        assertEquals(18, student.getStudentAge());
        assertEquals("sample@email.com", student.getStudentEmail());
        assertEquals("Sample Course", student.getStudentCourse());
    }

    @Test
    public void testSearchStudent() {
        // Call the searchStudent method with an existing student ID
        Student foundStudent = new Student(0, "", 0, "", "").searchStudent(students, 1);

        // Assert that the correct student has been found
        assertNotNull(foundStudent);
        assertEquals("John Doe", foundStudent.getStudentName());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Call the searchStudent method with an invalid student ID
        Student foundStudent = new Student(0, "", 0, "", "").searchStudent(students, 3);

        // Assert that no student is found
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent() {
        // Create a new student and add it to the list
        Student studentToDelete = new Student(3, "Alice Johnson", 19, "alice@example.com", "History");
        students.add(studentToDelete);

        // Call the deleteStudent method to delete the student
        studentToDelete.deleteStudent(students, 3);

        // Assert that the student has been deleted from the list
        assertNull(new Student(0, "", 0, "", "").searchStudent(students, 3));
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Call the deleteStudent method with an invalid student ID
        new Student(0, "", 0, "", "").deleteStudent(students, 3);

        // Assert that no student is found to delete
        assertNull(new Student(0, "", 0, "", "").searchStudent(students, 3));
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        // Create a new student with a valid age
        Student student = new Student(4, "Eva Green", 18, "eva@example.com", "Art");

        // Assert that the age is valid (greater than or equal to 16)
        assertTrue(student.getStudentAge() >= 16);
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        // Create a new student with an invalid age
        Student student = new Student(5, "Sam Brown", 15, "sam@example.com", "Music");

        // Assert that the age is invalid (less than 16)
        assertFalse(student.getStudentAge() >= 16);
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        // Create a new student with an age containing invalid characters
        Student student = new Student(6, "Invalid Age", 0, "invalid@example.com", "Invalid Course");

        // Assert that the age is invalid (not a number)
        assertFalse(student.getStudentAge() >= 16);
    }
}

