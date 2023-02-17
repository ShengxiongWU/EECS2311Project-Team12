package TestCases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import org.junit.Test;

import Backend.*;

public class EnrollmentTest {

	Enrollments enroll;
	Courses courses;
	
	@Before
	public void init() {
		enroll = Enrollments.getInstance();
		courses = Courses.getInstance();
		
	}
	@Test
	public void getAllCoursesEnrolledTest() {
		/*
		 * Explicit testing for the main courses for ease of developer understanding.
		 */
		ArrayList<Course> enrollCourses = enroll.getAllCoursesEnrolled("316408091");
		String[] courseID = {"EECS 1090", "EECS 2030", "EECS 1012", "EECS 2011"};
		Double[] credits = {3.0, 3.0, 3.0, 4.0};
		String[] courseName = {"Computational Logic", "advanced computer programming", "introduction to webprogramming", "computational organization"};
		
		
		
		//Prerequisite data 1090 (Empty)
		
		//Prerequisite data 2030 (3 courses 1090,1019,1021)
		String[] courseID2030 = {"EECS 1090", "EECS 1019", "EECS 1021"};
		Double[] credits2030 = {3.0,4.0,6.0};
		String[] courseName2030 = {"Computational Logic", "Math for Programming", "introduction to OOP programming"};
		
		//Prerequisite data 2011 (2 courses 1019, 1021)
		String[] courseID2011 = {"EECS 1019", "EECS 1021"};
		Double[] credits2011 = {4.0,6.0};
		String[] courseName2011 = {"Math for Programming", "introduction to OOP programming"};
		
		
		// Testing if course id are correct
		assertTrue(enrollCourses.get(0).getCourse_id().equals(courseID[0]));
		assertTrue(enrollCourses.get(1).getCourse_id().equals(courseID[1]));
		assertTrue(enrollCourses.get(2).getCourse_id().equals(courseID[2]));
		assertTrue(enrollCourses.get(3).getCourse_id().equals(courseID[3]));
		
		// Testing if credit value is correct
		assertEquals(enrollCourses.get(0).getCredit(), credits[0], 0.1);
		assertEquals(enrollCourses.get(1).getCredit(), credits[1], 0.1);
		assertEquals(enrollCourses.get(2).getCredit(), credits[2], 0.1);
		assertEquals(enrollCourses.get(3).getCredit(), credits[3], 0.1);
		
		// Testing if course name is correct
		assertEquals(enrollCourses.get(0).getName(), courseName[0]);
		assertEquals(enrollCourses.get(1).getName(), courseName[1]);
		assertEquals(enrollCourses.get(2).getName(), courseName[2]);
		assertEquals(enrollCourses.get(3).getName(), courseName[3]);
		
		
		// Testing if prerequisite courses are correct
		
		//1090 prereq test
		assertTrue(enrollCourses.get(0).getPrerequisites().size() == 0);
		
		//2030 prereq test
		//course id
		ArrayList<Course> prereq2030 = enrollCourses.get(1).getPrerequisites();
		for(int i = 0; i<prereq2030.size(); i++) {
			assertTrue(prereq2030.get(i).getCourse_id().equals(courseID2030[i]));
			assertEquals(prereq2030.get(i).getCredit(), credits2030[i], 0.1);
			assertEquals(prereq2030.get(i).getName(), courseName2030[i]);
		}
		
		//2011 prereq test
		ArrayList<Course> prereq2011 = enrollCourses.get(3).getPrerequisites();
		for(int i = 0; i<prereq2011.size(); i++) {
			assertTrue(prereq2011.get(i).getCourse_id().equals(courseID2011[i]));
			assertEquals(prereq2011.get(i).getCredit(), credits2011[i], 0.1);
			assertEquals(prereq2011.get(i).getName(), courseName2011[i]);
		}
		
	}

}
