package Backend;
import java.util.ArrayList;

public class Enrollment {
	private Course enroll;
	private Student student;
	private String status;
	private String term_taken;
	private String grade;
	
	public Enrollment(Course enroll, Student student, String status, String term_taken, String grade) {
		this.enroll = enroll;
		this.grade = grade;
		this.status = status;
		this.student = student;
		this.term_taken = term_taken;
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