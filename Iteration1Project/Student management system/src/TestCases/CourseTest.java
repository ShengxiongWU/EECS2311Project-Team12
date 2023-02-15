package Backend;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {

	private Courses courseGrade;
	
    @Before
    public void setUp() {
    	
        courseGrade = new Courses();
    }

    
    /*
	 * This test if passing course is added to the satisfied courses list and unsatisfied course list will be empty
	 */
    @Test
    public void testSatisfiedCourse() {
    	
    	courseGrade.storeCourseList("Data Structures", 80);
        

        List<String> satisfiedCourses = courseGrade.getSatisfiedCourses();
        List<String> unsatisfiedCourses = courseGrade.getUnsatisfiedCourses();
        
        assertEquals(1, satisfiedCourses.size());
        assertTrue(satisfiedCourses.contains("Data Structures"));

        assertTrue(unsatisfiedCourses.isEmpty());
    }
    
    /*
	 * Tests if the passing course is contained within the satisfiedCourses list
	 */
    @Test
    public void testSatisfiedCoursesList() {
        Courses courses = new Courses();

        courses.storeCourseList("Software Development", 70);

        List<String> satisfiedCourses = courses.getSatisfiedCourses();

        assertTrue(satisfiedCourses.contains("Software Development"));
    }
    
    
    /*
	 * Tests if the failing course is contained within the unsatisfiedCourses list
	 */
    @Test
    public void testUnsatisfiedCoursesList() {
        Courses courses = new Courses();

        courses.storeCourseList("Software Development", 40);

        List<String> unsatisfiedCourses = courses.getUnsatisfiedCourses();

        assertTrue(unsatisfiedCourses.contains("Software Development"));
    }
    
    /*
	 * Tests if the passing course is contained within the unsatisfiedCourses list
	 */
    @Test
    public void testUnsatisfiedCourses() {

    	Courses courses = new Courses();

        courses.storeCourseList("Data Structures", 80);

        List<String> unsatisfiedCourses = courses.getUnsatisfiedCourses();

        assertFalse(unsatisfiedCourses.contains("Data Structures"));
    }
}


