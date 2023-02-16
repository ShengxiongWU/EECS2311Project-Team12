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
				if(grade == "A+") {
					sumGrade += 9;
				}
				else if(grade == "A") {
					sumGrade += 8;
				}
				else if(grade == "B+") {
					sumGrade += 7;
				}
				else if(grade == "B") {
					sumGrade += 6;
				}
				else if(grade == "C+") {
					sumGrade += 5;
				}
				else if(grade == "C" ) {
					sumGrade += 4;
				}
				else if(grade == "D+") {
					sumGrade += 3;
				}
				else if(grade == "D") {
					sumGrade += 2;
				}
				else if(grade == "E") {
					sumGrade += 1;
				}
				else if(grade == "F") {
					sumGrade += 0;
				}
			}
		}
		double gpa = 0;
		for(int i = 0; i<enrollments.size(); i++) {
			if(enrollments.get(i).getStudent().getID() == student_id) {
				String grade = enrollments.get(i).getGrade();
				Double credit = enrollments.get(i).getEnrolled().getCredit();
				if(grade == "A+") {
					gpa += 9/sumGrade * credit/sumCredit;
				}
				else if(grade == "A") {
					gpa += 8/sumGrade * credit/sumCredit;
				}
				else if(grade == "B+") {
					gpa += 7/sumGrade * credit/sumCredit;
				}
				else if(grade == "B") {
					gpa += 6/sumGrade * credit/sumCredit;
				}
				else if(grade == "C+") {
					gpa += 5/sumGrade * credit/sumCredit;
				}
				else if(grade == "C" ) {
					gpa += 4/sumGrade * credit/sumCredit;
				}
				else if(grade == "D+") {
					gpa += 3/sumGrade * credit/sumCredit;
				}
				else if(grade == "D") {
					gpa += 2/sumGrade * credit/sumCredit;
				}
				else if(grade == "E") {
					gpa += 1/sumGrade * credit/sumCredit;
				}
				else if(grade == "F") {
					gpa += 0/sumGrade * credit/sumCredit;
				}
			}
		}
		
		return gpa;
	}
	
}
