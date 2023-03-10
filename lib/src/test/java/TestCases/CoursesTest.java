package TestCases;

import Backend.*;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoursesTest {

	Courses courses;
	ArrayList<Course> allCourses;

	@BeforeEach
	public void init() {
		courses = Courses.getInstance();
		allCourses = courses.getAll_Courses();
	}
	// this test is to check if the courses is initialized with setup course information or not
	@Test
	public void Test1() {
		assertTrue(courses.getAll_Courses().size() != 0);
	}

	@Test
	public void Test2() {
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
	public void Test4() {
		Course S1 = new Course("ADMS 1000","intro to Buisness", 3.0,new ArrayList<Course>());
		ArrayList<Course> pre = new ArrayList<Course>();
		pre.add(S1);
		Course S2 = new Course("ADMS 1001","Funtion And Stragies of Buisness", 3.0,pre);
		Course S3 = new Course("PHYS 1800","Engineering Mechanics", 3.0,new ArrayList<Course>());
		ArrayList<Course> pre1 = new ArrayList<Course>();
		pre.add(S3);
		Course S4 = new Course("PHYS 1801","Electricity, Magnetism and Optics for Engineers", 3.0,pre1);
		Course S5 = new Course("MATHS 1013","Applied Calculus I ", 3.0,new ArrayList<Course>());
		ArrayList<Course> pre2 = new ArrayList<Course>();
		pre.add(S5);
		Course S6 = new Course("MATHS 1014","Applied Calculus II ", 3.0,new ArrayList<Course>());
		allCourses.add(S1);
		allCourses.add(S2);
		allCourses.add(S3);
		allCourses.add(S4);
		allCourses.add(S5);
		allCourses.add(S6);
		assertFalse(courses.getAll_Courses().size() == 0);
		assertEquals(S6,allCourses.get(allCourses.size()-1));
		assertEquals(S1,allCourses.get(allCourses.size()-6));
		assertEquals(S4,allCourses.get(allCourses.size()-3));

	}

}
