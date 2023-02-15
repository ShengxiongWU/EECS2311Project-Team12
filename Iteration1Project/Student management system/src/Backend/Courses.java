package Backend;

import java.util.ArrayList;
import java.util.List;


public class Courses {
		
		//initialize lists
	    private List<String> satisfiedCourses = new ArrayList<>();
	    private List<String> unsatisfiedCourses = new ArrayList<>();

	    //adds the course to the corresponding lists depending on the grade
	    
	    
	    public boolean validInput (String grade) {
	    	
	    	ArrayList<String> validArray = new ArrayList<String>();
	    	
	    	validArray.add("A+");
	    	validArray.add("A");
	    	validArray.add("B+");
	    	validArray.add("B");
	    	validArray.add("C+");
	    	validArray.add("C");
	    	validArray.add("D+");
	    	validArray.add("D");
	    	validArray.add("F");
	    	validArray.add("E");
	    	
	    	
	    	return validArray.contains(grade);
	    }
	    public void storeCourseList(String courseName, String grade) {
	    	
	    	if (!validInput(grade)) {
	    		throw new IllegalArgumentException();
	    	}
	        if (grade == "E" || grade == "F") {
	        	unsatisfiedCourses.add(courseName);
	        } 
	        else {
	            satisfiedCourses.add(courseName);
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
