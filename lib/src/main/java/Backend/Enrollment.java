package Backend;
import java.util.ArrayList;

import DB.DB;



public class Enrollment {
	private Course enroll;
	private Student student;
	private String status;
	private String term_taken;
	private String grade;
	private DB db = DB.getInstance();
	 
	public Enrollment(Course enroll, Student student, String status, String term_taken, String grade) {
		this.enroll = enroll;
		this.grade = grade;
		this.status = status;
		this.student = student;
		this.term_taken = term_taken;
		String course_id = enroll.getCourse_id();
		String course_name = enroll.getName();
		String student_id = student.getID();
//		db.addEnrollment(student_id, course_name, course_id, term_taken, status, grade);
	}
	
	public Course getEnrolled() {
		return enroll;
	}
	public void setEnrolled(Course enrolled) {
		this.enroll = enrolled;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTerm_taken() {
		return term_taken;
	}
	public void setTerm_taken(String term_taken) {
		this.term_taken = term_taken;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}

