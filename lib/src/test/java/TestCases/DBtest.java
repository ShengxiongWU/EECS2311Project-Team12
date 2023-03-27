package TestCases;



import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;


import Backend.Course;
import Backend.Courses;
import Backend.Enrollments;
import Backend.Student;
import Backend.Students;
import DB.DB;
public class DBtest {
	Students student;
	ArrayList<Student> Stud;
	Enrollments enroll;
	Courses courses;
	Course course;
	DB db;
	
	@BeforeEach
	public void init() {
		enroll = Enrollments.getInstance();
		courses = Courses.getInstance();
		student = Students.getInstance();
		Stud = student.getStudents();
		db = DB.getInstance();

		}
	@Test
	public void test() {
		DB.getInstance().addCourse("MATH 0001", "Basic Maths","3.0","   ");
//		DB.getInstance().addEnrollment("MATH 0001", "Basic Maths","316408093","in progress","FAll","NG");
//		assertTrue(DB.getEnrolledCourses("316408093").size() == 2);
		
	}

	@Test
	public void test2() {
		DB.getInstance().registerStudent("213456874", "Amit", "123456784","amit123","Scarborough", "Computer Engineering");
		DB.getInstance().registerStudent("213496844", "Birva", "123456784","amit123","Scarborough", "Computer Engineering");
		DB.getInstance().registerStudent("213436884", "Parth", "123456987","parth123","Toronto", "Electrical Engineering");
		DB.getInstance().registerStudent("213436880", "Pat", "123456977","pat123","Toronto", "Electrical Engineering");
		DB.getInstance().registerStudent("213436881", "Pate", "124456977","pate123","Toronto", "Mechnical Engineering");
        assertTrue(Students.getInstance().getStudents().size() < 10);
	}
	@Test
	public void test3() {
//		DB.getInstance().addEnrollment("EECS 1000", "intro to programming","316408093","in progress","FAll","NG");
//		assertFalse(DB.getEnrolledCourses("316408093").size() > 10);
	}
	
	@Test
	public void test4() {
		DB.getInstance().dropEnrollment("316408093", "Math 1025");
	}

}
