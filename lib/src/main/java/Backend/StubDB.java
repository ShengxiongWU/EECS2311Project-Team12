package Backend;
import java.util.ArrayList;

public class StubDB {
	
	private static StubDB db;
	private Courses course_list;
	private Enrollments enroll_list;
	
	private StubDB() {
	      // constructor of the SingletonExample class
		course_list = Courses.getInstance();
		enroll_list = Enrollments.getInstance();
	   }
	   /*
	    * get instance of stubDB
	    */
	   public static StubDB getInstance() {
		   if(db == null) {
		         db = new StubDB();
		   }  
		  
		return db;
	   }
	/*
	 * get course list   
	 */
	public Courses getCourse_list() {
		return course_list;
	}

	/*
	 * get enrollment list   
	 */
	public Enrollments getEnroll_list() {
		return enroll_list;
	}

    //main method 
	public static void main(String[] args) {
			StubDB db = StubDB.getInstance();
			double gpa = db.getEnroll_list().getOverAllGPA("316408091");
			System.out.println("316408091's gpa is " + gpa);
			
	}

}
