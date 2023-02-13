package Backend;

import java.util.ArrayList;
import java.util.List;


public class Courses {
		
		//initialize lists
	    private List<String> satisfiedCourses = new ArrayList<>();
	    private List<String> unsatisfiedCourses = new ArrayList<>();

	    //adds the course to the corresponding lists depending on the grade
	    public void storeCourseList(String courseName, int grade) {
	        if (grade >= 50) {
	            satisfiedCourses.add(courseName);
	        } 
	        else {
	            unsatisfiedCourses.add(courseName);
	        }
	    }
	    //getter method for unsatisfied courses
	    public List<String> getUnsatisfiedCourses() {
	        return unsatisfiedCourses;
	    }
	    //getter method for satisfied courses
	    public List<String> getSatisfiedCourses() {
	        return satisfiedCourses;
	    }

	   
}
