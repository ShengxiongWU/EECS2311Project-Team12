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
		DB.getInstance().addEnrollment("EECS 1000", "intro to programming","316408093","in progress","FAll","NG");
		assertFalse(DB.getEnrolledCourses("316408093").size() > 10);
	}
	
	@Test
	public void test4() {
		DB.getInstance().dropEnrollment("316408093", "Math 1025");
	}
	
	@Test
	public void courseRequirementsTest() {
//		if(!db.login("TestUser", "123")) {
//			db.registerStudent("213456789", "TestUser" , "TestUser", "123", "TestAddress", "Software");
//		}	
		System.out.println("EECS2311 Added: " + DB.addRequiredCourse("EECS2311", "Software"));
		System.out.println("EECS1011 Added: " +DB.addRequiredCourse("EECS1011", "Software"));
		System.out.println("EECS2030 Added: "+ DB.addRequiredCourse("EECS2030", "Software"));
		
		ArrayList<ArrayList<String>> reqs = DB.getRequiredCourses("Software");
		for(int i = 0; i<reqs.size(); i++) {
			System.out.println(reqs.get(i));
		}
		System.out.println("EECS2311 Removed: "+DB.removeRequiredCourse("EECS2311", "Software"));
		System.out.println("EECES1011 Removed: "+DB.removeRequiredCourse("EECS1011", "Software"));
		System.out.println("EECS2030 Removed: "+DB.removeRequiredCourse("EECS2030", "Software"));
		
	}

}
