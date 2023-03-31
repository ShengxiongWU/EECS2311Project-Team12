package Backend;
import java.util.ArrayList;

import DB.DB;


//Course class
public class Course {
	private String course_id;
	private String name;
	private double credit;
	private ArrayList<Course> prerequisites;
	private DB db = DB.getInstance();
	
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

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(ArrayList<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}
	
	
}
