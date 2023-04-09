package Backend;
import java.util.ArrayList;

import DB.DB;



public class Enrollment {
	//initialize variables 
	private Course enroll;
	private Student student;
	private String status;
	private String term_taken;
	private String grade;
	private DB db = DB.getInstance();
	/*
	 * Enrollment constructor 
	 */
	public Enrollment(Course enroll, Student student, String status, String term_taken, String grade) {
		this.enroll = enroll;
		this.grade = grade;
		this.status = status;
		this.student = student;
		this.term_taken = term_taken;
		String course_id = enroll.getCourse_id();
		String course_name = enroll.getCourse_Name();
		String student_id = student.getID();
		db.addEnrollment(student_id, course_name, course_id, term_taken, status, grade);
	}
	/*
	 * Getter method for enroll 
	 */
	public Course getEnrolled() {
		return enroll;
	}
	/*
	 * setter method for enroll 
	 */
	public void setEnrolled(Course enrolled) {
		this.enroll = enrolled;
	}
	/*
	 * Getter method for student 
	 */
	public Student getStudent() {
		return student;
	}
	/*
	 * setter method for student 
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/*
	 * getter method for status 
	 */
	public String getStatus() {
		return status;
	}
	/*
	 * setter method for status 
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/*
	 * Getter method for term taken 
	 */
	public String getTerm_taken() {
		return term_taken;
	}
	/*
	 * setter method for set term 
	 */
	public void setTerm_taken(String term_taken) {
		this.term_taken = term_taken;
	}
	/*
	 * Getter method for grade 
	 */
	public String getGrade() {
		return grade;
	}
	/*
	 * setter method for grade 
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}

