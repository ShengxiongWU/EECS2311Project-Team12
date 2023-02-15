package Backend;

import java.util.ArrayList;
import java.util.List;


public class Courses {
		
		//initialize lists
	    private List<String> satisfiedCourses = new ArrayList<>();
	    private List<String> unsatisfiedCourses = new ArrayList<>();

	    //adds the course to the corresponding lists depending on the grade
	    
	    
	    public boolean validInput (String grade) {
	    	
	    	ArrayList<String> a = new ArrayList<String>();
	    	
	    	a.add("A+");
	    	a.add("A");
	    	a.add("B+");
	    	a.add("B");
	    	a.add("C+");
	    	a.add("C");
	    	a.add("D+");
	    	a.add("D");
	    	a.add("F");
	    	a.add("E");
	    	
	    	
	    	return a.contains(grade);
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
