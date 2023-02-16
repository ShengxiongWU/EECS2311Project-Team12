package TestCases;

import Backend.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CoursesTest {
	
	Courses courses;
	ArrayList<Course> allCourses;

	@Before
	public void init() {
		courses = Courses.getInstance();
		allCourses = courses.getAll_Courses();
	}
	// this test is to check if the courses is initialized with setup course information or not
	@Test
	public void test() {
		assertTrue(courses.getAll_Courses().size() != 0);
	}
	
	@Test
	public void test2() {
		Course c2 = new Course("EECS 1000","intro to programming", 3.0,new ArrayList<Course>());
		ArrayList<Course> pre = new ArrayList<Course>();
		pre.add(c2);
		Course c1 = new Course("EECS 4412","data mining", 3.0,pre);
		allCourses.add(c1);
		allCourses.add(c2);
		
		assertEquals(c1,allCourses.get(allCourses.size()-2));
		assertEquals(c2,allCourses.get(allCourses.size()-1));
	}
	
	@Test
	public void Test3() {
		String A1 = "EECS 2030";
		
		assertEquals(A1,allCourses.get(4).getCourse_id());
	}
	
	@Test
	public void Test4() {}
	
}
