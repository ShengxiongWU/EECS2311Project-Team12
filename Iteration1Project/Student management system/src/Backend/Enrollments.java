package Backend;
import java.util.ArrayList;

public class Enrollments {
	private ArrayList<Enrollment> enrollments;
	
	public double getOverAllGPA(String student_id) {
		double sumGrade = 0;
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
		
		return gpa;
	}
	
	public ArrayLst<Course> getSatisfiedCourse(String student_id){
		for(int i = 0; i<enrollments.size(); i++) {
			if(enrollments.get(i).getStudent().getID() == student_id) {
				String grade = enrollments.get(i).getGrade();
				String status = enrollments.get(i).getEnrolled();
				sumCredit += credit;
			}
		}
	}
	
}
