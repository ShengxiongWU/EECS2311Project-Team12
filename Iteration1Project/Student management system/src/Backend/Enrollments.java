package Backend;
import java.util.ArrayList;
import java.util.Objects;

import DB.DB;



public class Enrollments {
	private ArrayList<Enrollment> enrollments;
	private static Enrollments enroll_list;
	 private DB db = DB.getInstance();
	private Enrollments() {
		ArrayList<Student> Student = Students.getInstance().getStudents();
		
		ArrayList<Course> course_list = Courses.getInstance().getAll_Courses();
		
		Enrollment enroll_1 = new Enrollment(course_list.get(0), Student.get(0), "finished", "Fall", "B+");
		Enrollment enroll_2 = new Enrollment(course_list.get(4), Student.get(0), "finished", "Fall", "C");
		Enrollment enroll_3 = new Enrollment(course_list.get(2), Student.get(0), "finished", "Fall", "A");
		Enrollment enroll_4 = new Enrollment(course_list.get(5), Student.get(0), "in progress", "Winter", "NGA");
		
		Enrollment enroll_5 = new Enrollment(course_list.get(0), Student.get(1), "in progress", "Fall", "NGA");
		Enrollment enroll_6 = new Enrollment(course_list.get(1), Student.get(1), "finished", "Fall", "C");
		Enrollment enroll_7 = new Enrollment(course_list.get(2), Student.get(1), "finished", "Fall", "A");
		Enrollment enroll_8 = new Enrollment(course_list.get(5), Student.get(1), "in progress", "Winter", "NGA");
		Enrollment enroll_9 = new Enrollment(course_list.get(7), Student.get(1), "finished", "Fall", "F");
		
		Enrollment enroll_10 = new Enrollment(course_list.get(0), Student.get(2), "in progress", "Fall", "NGA");
		Enrollment enroll_11 = new Enrollment(course_list.get(1), Student.get(2), "finished", "Fall", "A+");
		Enrollment enroll_12 = new Enrollment(course_list.get(2), Student.get(2), "finished", "Fall", "F");
		
	
		
		enrollments = new ArrayList<Enrollment>();
		
		enrollments.add(enroll_1);
		enrollments.add(enroll_2);
		enrollments.add(enroll_3);
		enrollments.add(enroll_4);
		enrollments.add(enroll_5);
		enrollments.add(enroll_7);
		enrollments.add(enroll_8);
		enrollments.add(enroll_9);
		enrollments.add(enroll_10);
		enrollments.add(enroll_11);
		enrollments.add(enroll_12);
	}
	
	 public static Enrollments getInstance() {
		   if(enroll_list == null) {
		         enroll_list = new Enrollments();
		   }  
		  
		return enroll_list;
	   }
    //delete enrollment from enrollments
	
	public double getOverAllGPA(String student_id) {
		double sumCredit = 0;
		for(int i = 0; i<enrollments.size(); i++) {
			if(enrollments.get(i).getStudent().getID() == student_id) {
				String grade = enrollments.get(i).getGrade();
				Double credit = enrollments.get(i).getEnrolled().getCredit();
				sumCredit += credit;
			}
		}
		double gpa = 0;
		for(int i = 0; i<enrollments.size(); i++) {
			if(enrollments.get(i).getStudent().getID() == student_id) {
				String grade = enrollments.get(i).getGrade();
				Double credit = enrollments.get(i).getEnrolled().getCredit();
				if(grade == "A+") {
					gpa += 9 * credit/sumCredit;
				}
				else if(grade == "A") {
					gpa += 8 * credit/sumCredit;
				}
				else if(grade == "B+") {
					gpa += 7 * credit/sumCredit;
				}
				else if(grade == "B") {
					gpa += 6 * credit/sumCredit;
				}
				else if(grade == "C+") {
					gpa += 5 * credit/sumCredit;
				}
				else if(grade == "C" ) {
					gpa += 4 * credit/sumCredit;
				}
				else if(grade == "D+") {
					gpa += 3 * credit/sumCredit;
				}
				else if(grade == "D") {
					gpa += 2 * credit/sumCredit;
				}
				else if(grade == "E") {
					gpa += 1 * credit/sumCredit;
				}
				else if(grade == "F") {
					gpa += 0 * credit/sumCredit;
				}
			}
		}
		
		return Math.round(gpa * 10.0) / 10.0;
	}
	
	public ArrayList<Course> getSatisfiedCourse(String student_id){
		ArrayList<Course> satisfiedCourse = new ArrayList<Course>();
		for(int i = 0; i<enrollments.size(); i++) {
			if(enrollments.get(i).getStudent().getID() == student_id && Objects.nonNull(enrollments.get(i).getGrade()) 
			   && enrollments.get(i).getGrade() != "NGA" && enrollments.get(i).getGrade() != "F") {
				satisfiedCourse.add(enrollments.get(i).getEnrolled());
		}
	}
		return satisfiedCourse;
	}
	
	public ArrayList<Course> getUnsatisfiedCourse(String student_id){
		ArrayList<Course> unsatisfiedCourse = new ArrayList<Course>();
		for(int i = 0; i<enrollments.size(); i++) {
			if(enrollments.get(i).getStudent().getID() == student_id && (Objects.isNull(enrollments.get(i).getGrade()) 
			   || enrollments.get(i).getGrade() != "NGA" || enrollments.get(i).getGrade() != "F")) {
				unsatisfiedCourse.add(enrollments.get(i).getEnrolled());
		}
	}
		return unsatisfiedCourse;
	}
    
	public ArrayList<Course> getAllCoursesEnrolled(String student_id){
		ArrayList<Course> enrolledCourse = new ArrayList<Course>();
		for(int i = 0; i<enrollments.size(); i++) {
			if(enrollments.get(i).getStudent().getID() == student_id) {
				enrolledCourse.add(enrollments.get(i).getEnrolled());
		}
	}
		return enrolledCourse;
	}
	
	public ArrayList<Enrollment> getEnrollments() {
		return enrollments;
	}
	public void dropCourse(String student_Id, String course_Id) {
	    for (int i = 0; i < enrollments.size(); i++) {
	        Enrollment enrollment = enrollments.get(i);
	        if (enrollment.getStudent().getID().equals(student_Id) &&
	            enrollment.getEnrolled().getCourse_id().equals(course_Id)) {
	            enrollments.remove(i);
	            break;
	        }
	    }
	}
	
}