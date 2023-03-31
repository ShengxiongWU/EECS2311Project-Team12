package Backend;
import java.util.ArrayList;
import java.util.List;

import DB.DB;



public class Courses {
	    //initialize variables 
		private ArrayList<Course> all_Courses;
		private static Courses courses;
		private DB db = DB.getInstance();
		
		private Courses() {
			//1000 level course
			Course course1 = new Course("EECS 1090", "Computational Logic", 3.0, new ArrayList<Course>()); 
			Course course1_2 = new Course("EECS 1019", "Math for Programming", 4.0, new ArrayList<Course>());
			Course course1_3 = new Course("EECS 1012", "introduction to webprogramming", 3.0, new ArrayList<Course>());
			Course course1_4 = new Course("EECS 1021", "introduction to OOP programming", 6.0, new ArrayList<Course>());
			//pre for 2030 and 2311
			ArrayList<Course> prerequisites_2 = new ArrayList<Course>();
			prerequisites_2.add(course1);
			prerequisites_2.add(course1_2);
			prerequisites_2.add(course1_4);
			//pre for 2011
			ArrayList<Course> prerequisites_2_1 = new ArrayList<Course>();
			prerequisites_2_1.add(course1_2);
			prerequisites_2_1.add(course1_4);
			
			Course course2 = new Course("EECS 2030","advanced computer programming", 3.0, prerequisites_2);
			Course course2_1 = new Course("EECS 2011","computational organization", 4.0, prerequisites_2_1);
			Course course2_2 = new Course("EECS 2311","computational project", 3.0, prerequisites_2);
			
			//pre for 3311
			ArrayList<Course> prerequisites_3 = new ArrayList<Course>();
			prerequisites_3.add(course2);
			prerequisites_3.add(course2_2);
			
			Course course3 = new Course("EECS 3311","advanced computational project", 3.0, prerequisites_3);
			
			all_Courses = new ArrayList<Course>();
			
			all_Courses.add(course1);
			all_Courses.add(course1_2);
			all_Courses.add(course1_3);
			all_Courses.add(course1_4);
			all_Courses.add(course2);
			all_Courses.add(course2_1);
			all_Courses.add(course2_2);
			all_Courses.add(course3);
		}
		//get instance of a course
		 public static Courses getInstance() {
			   if(courses == null) {
			         courses = new Courses();
			   }  
			  
			return courses;
		   }
		 
		//get all courses as a arraylist
		public ArrayList<Course> getAll_Courses() {
			return all_Courses;
		}
	   
}
