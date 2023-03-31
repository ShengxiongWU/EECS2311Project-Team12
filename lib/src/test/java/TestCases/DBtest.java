package TestCases;



import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
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
		//		enroll = Enrollments.getInstance();
		//		courses = Courses.getInstance();
		//		student = Students.getInstance();
		//		Stud = student.getStudents();
		//		db = DB.getInstance();

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
		db = DB.getInstance();
		//		if(!db.login("TestUser", "123")) {
		//			db.registerStudent("213456789", "TestUser" , "TestUser", "123", "TestAddress", "Software");
		//		}
		//Adding Test Courses can ignore stack traces if ran multiple times
		db.addCourse("TestCourse1111", "TestCourse1", "3.0", "");
		db.addCourse("TestCourse1112", "TestCourse2", "3.0", "TestCourse1");
		db.addCourse("TestCourse1113", "TestCourse3", "3.0", "TestCourse2");
		db.addCourse("TestCourse1114", "TestCourse4", "3.0", "TestCourse3");
		assertTrue(DB.addRequiredCourse("TestCourse1111", "TestDegree"));
		assertTrue(DB.addRequiredCourse("TestCourse1112", "TestDegree"));
		assertTrue(DB.addRequiredCourse("TestCourse1113", "TestDegree"));
		assertTrue(DB.addRequiredCourse("TestCourse1114", "TestDegree"));
		assertTrue(DB.getRequiredCourses("TestDegree").size() == 4);
		assertTrue(DB.removeRequiredCourse("TestCourse1111", "TestDegree"));
		assertTrue(DB.removeRequiredCourse("TestCourse1112", "TestDegree"));
		assertTrue(DB.removeRequiredCourse("TestCourse1113", "TestDegree"));
		assertTrue(DB.removeRequiredCourse("TestCourse1114", "TestDegree"));
	}

	@Test
	public void getStudentSpecificCourseRequirementsTest() {
		db = DB.getInstance();
		//		db.addCourse("EECS2311", "Software Development Project", "3.0", "EECS1011");
		//		db.addCourse("EECS1011", "EECS1011 NAME", "3.0", "");
		//		db.addCourse("EECS2030", "Data Structures", "3.0", "EECS1011");
		
		//Adding test course can ignore stack trace if running multiple times
		db.addCourse("TestCourse0001", "TestCourse1", "3.0", "");
		db.addCourse("TestCourse0002", "TestCourse2", "3.0", "TestCourse1");
		db.addCourse("TestCourse0003", "TestCourse3", "3.0", "TestCourse2");
		
		System.out.println("EECS2311 Added: " + DB.addRequiredCourse("TestCourse0001", "TestDegree0"));
		System.out.println("EECS1011 Added: " + DB.addRequiredCourse("TestCourse0002", "TestDegree0"));
		System.out.println("EECS2030 Added: " + DB.addRequiredCourse("TestCourse0003", "TestDegree0"));

		if(!db.login("TestUser", "123")) {
			db.registerStudent("213456789", "TestUser" , "TestUser", "123", "TestAddress", "TestDegree0");
		}
		/*
		 * id: 0
		 * name: 1
		 * account: 2
		 * pass: 3
		 * Address: 4
		 * Degree: 5
		 */
		ArrayList<HashMap<String, String>> softReq = DB.getRequiredCourses("TestDegree0");
		ArrayList<String> info = DB.student_info("TestUser", "123");
		System.out.println(db.addEnrollment("TestCourse0001", "", info.get(0), "InProgress", "Fall", "NA"));
		ArrayList<HashMap<String,String>> stdReq = DB.getRequiredCoursesForStudent(info.get(0), info.get(5));

//		String EECS1011StdReq = stdReq.get(0).get("courseId");
//		String EECS1011SoftReq = softReq.get(0).get("courseId");
//		assertTrue(EECS1011StdReq.equals(EECS1011SoftReq));
//
//		String EECS2030str = stdReq.get(1).get("courseId");
//		String EECS2030sr = softReq.get(1).get("courseId");
//		assertTrue(EECS2030str.equals(EECS2030sr));
		int studReq = 0;
		int softReqNum = 0;
		for(int i =0; i<stdReq.size(); i++) {
			if(stdReq.get(i).get("courseId").contains("000")) {
				studReq++;
			}
		}
		for(int j = 0; j<softReq.size(); j++) {
			if(softReq.get(j).get("courseId").contains("000")) {
				softReqNum++;
			}
		}
		assertTrue(studReq == 2);
		assertTrue(softReqNum == 3);

		
		System.out.println("Drop enrollment TestCourse0001: " + db.dropEnrollment(info.get(0), "TestCourse0001"));
		System.out.println("EECS2311 Removed: " + DB.removeRequiredCourse("TestCourse0001", "TestDegree0"));
		System.out.println("EECS1011 Removed: " + DB.removeRequiredCourse("TestCourse0002", "TestDegree0"));
		System.out.println("EECS2030 Removed: " + DB.removeRequiredCourse("TestCourse0003", "TestDegree0"));

	}

}
