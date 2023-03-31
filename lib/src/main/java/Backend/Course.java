package Backend;
import java.util.ArrayList;

import DB.DB;


//Course class
public class Course {
	//Initialize attributes for courses
	private String course_id;
	private String name;
	private double credit;
	private ArrayList<Course> prerequisites;
	private DB db = DB.getInstance();
	
	//Course constructor 
	public Course(String course_id,String name, double credit, ArrayList<Course> prerequisites) {
		this.course_id = course_id;
		this.credit = credit;
		this.name = name;
		this.prerequisites = prerequisites;
		String pre = "";
		for(int i = 0; i < prerequisites.size(); i++) {
			pre += prerequisites.get(i).getCourse_id() + ",";
		}
		db.addCourse(course_id, name, String.valueOf(credit), pre);
	}
    /*
     * getter method for courseID
     */
	public String getCourse_id() {
		return course_id;
	}
	/*
     * setter method for courseID
     */
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	/*
     * getter method for course name
     */
	public String getCourse_Name() {
		return name;
	}
	/*
     * setter method for course name
     */
	public void setCourse_Name(String name) {
		this.name = name;
	}
	/*
     * getter method for course credit
     */
	public double getCredit() {
		return credit;
	}
	/*
     * setter method for course credit
     */
	public void setCredit(double credit) {
		this.credit = credit;
	}
	/*
     * getter method for course prerequisites
     */
	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}
	/*
     * setter method for course name
     */
	public void setPrerequisites(ArrayList<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}
	
	
}
