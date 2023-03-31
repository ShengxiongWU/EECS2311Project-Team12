package DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DB {
	public String url;
	public String user;
	public String password;
	public static Connection conn;
	//    String url = "jdbc:mysql://127.0.0.1:3306";
	//	String user = "root";
	//    String password = "123456";
	private static DB db;
	
	private DB(){
		try {

		   String url = "jdbc:mysql://localhost:3306/";
		   String user = "root";
		    String password = "root1234";

			conn = DriverManager.getConnection(url,user,password);
			Statement statement = conn.createStatement();
			String checkDB = "select Count(*), schema_name from information_schema.schemata where schema_name='db';";
			String create_database = "create database db;";
			String use_database = "use db;";

			String create_studentTable = "create table students" +
					"(id varchar(25) not NULL unique, " +
					" name varchar(40), " +
					" account CHAR(9), " +
					" password VARCHAR(25), " +
					" address VARCHAR(100), " +
					" degree VARCHAR(100), " +
					" PRIMARY KEY ( account, password ));";

			String create_courseTable = "create table courses" +
					"(id varchar(25) not NULL, " +
					" name varchar(100), " +
					" credit VARCHAR(20), " +
					" prequisites VARCHAR(255), " +
					" PRIMARY KEY ( id ));";

			String create_courseEnrolmentTable = "create table course_enrollment" +
					"(course_id varchar(25) not null," +
					" name VARCHAR(100), " +
					" student_id VARCHAR(20) not null," +
					" status VARCHAR(20) not null," +
					" term_taken VARCHAR(10) not null," +
					" grade VARCHAR(2)," +
					" PRIMARY KEY (course_id, student_id)," +
					" FOREIGN KEY (student_id) REFERENCES students(id)," +
					" FOREIGN KEY (course_id) REFERENCES courses(id));";

			String create_adminTable = "create table admins" +
					"(id varchar(25) not NULL unique, " +
					" account CHAR(10), " +
					" password VARCHAR(25), " +
					" address VARCHAR(100), " +
					" faculty VARCHAR(30), " +
					" PRIMARY KEY ( account, password ));";
			String create_courseRequirementsTable = "create table course_requirements" +
					"(course_id VARCHAR(25) not null," +
					"name VARCHAR(100),"+
					"degree VARCHAR(100),"+
					"FOREIGN KEY (course_id) REFERENCES courses(id),"+
					"PRIMARY KEY(degree, course_id));";
			// DB already created check
			ResultSet rs = statement.executeQuery(checkDB);
			rs.next();
			if(rs.getInt(1) == 0) {
				System.out.println("Database not found creating it now...");
				statement.executeUpdate(create_database);
				System.out.println("Database created successfully...");
				statement.executeUpdate(use_database);
				System.out.println("Database used successfully...");
				statement.executeUpdate(create_studentTable);
				System.out.println("Student table created successfully...");
				statement.executeUpdate(create_courseTable);
				System.out.println("course table created successfully...");
				statement.executeUpdate(create_courseEnrolmentTable);
				System.out.println("course enrollment table created successfully...");
				statement.executeUpdate(create_adminTable);
				System.out.println("admin table created successfully...");
				statement.executeUpdate(create_courseRequirementsTable);
				System.out.println("course requirements talbe created successfully...");
//			sampleDB();
			}else {
				statement.executeUpdate(use_database);
				System.out.println("Database used successfully...");
				System.out.println("Database already created and inserted into...");
			}


		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	 public static DB getInstance() {
		   if(db == null) {
			   db = new DB();
		   }  
		  
		return db;
	   }

//	public void sampleDB() {
//		try {
//			conn = DriverManager.getConnection(this.url + "/db",this.user,this.password);
//			Statement statement = conn.createStatement();
//
//			String insert_student_1 = "insert into students values('218041103','matthew','145214321', 'mattpat1','Toronto','software engineering');";
//			String insert_student_2 = "insert into students values('218041106','joe','171456998', 'joeman','Toronto','software engineering');";
//			statement.executeUpdate(insert_student_1);
//			statement.executeUpdate(insert_student_2);
//			System.out.println("inserted students successfully...");
//
//			String insert_course_1 = "insert into courses values('EECS2030', 'Data Structures', '3.0', 'EECS2011 EECS1090');";
//			String insert_course_2 = "insert into courses values('EECS1090', 'Intro Computer Science Logic', '3.0', 'EECS 1019');";
//			statement.executeUpdate(insert_course_1);
//			statement.executeUpdate(insert_course_2);
//			System.out.println("inserted courses successfully...");
//
//			String insert_enrollment_1 = "insert into course_enrollment values('EECS2030','Data Structures','218041103', 'Completed','fall', 'A');";
//			String insert_enrollment_4 = "insert into course_enrollment values('EECS2030','Data Structures','218041106', 'InProgress','winter', 'C+');";
//
//			statement.executeUpdate(insert_enrollment_1);
//			statement.executeUpdate(insert_enrollment_4);
//			System.out.println("inserted enrollments successfully...");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	//add one course to the course table in other words creating one course in the course system
	public boolean addCourse(String id, String name, String credit, String prequisites) {
		try {
			String sql = "INSERT INTO courses(id,name,credit,prequisites)" + "VALUES(?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, credit);
			pstmt.setString(4, prequisites);

			int rowAffected = pstmt.executeUpdate();
			if(rowAffected == 1)
			{
				return true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;	
	 }
	
	//add course for one student
	public boolean addEnrollment(String courseId, String name, String studentId , String status, String term, String grade) {
		try {
			 String sql1 = "INSERT INTO course_enrollment(course_id,name,student_id,status,term_taken,grade)" + "VALUES(?,?,?,?,?,?);";
			 
			PreparedStatement pstmt1 = conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
			pstmt1.setString(1, courseId);
			pstmt1.setString(2, name);
			pstmt1.setString(3, studentId);
			pstmt1.setString(4, status);
			pstmt1.setString(5, term);
			pstmt1.setString(6, grade);
		

			int rowAffected = pstmt1.executeUpdate();
			if(rowAffected == 1)
			{
				return true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	//drop one record of enrollment, by using this function, a student can drop his course or admin can drop one student's course
	public boolean dropEnrollment(String studentId, String courseId) {
		try {
			String query = String.format("DELETE FROM course_enrollment WHERE student_id=%s and course_id=%s;",studentId, courseId);
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			int rowAffected = pstmt.executeUpdate();
			if(rowAffected == 1)
			{
				return true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	// add a student to student table
	public boolean registerStudent(String id, String name,String account, String password, String address, String degree) {
		try {
			String sql = "INSERT INTO students(id,name,account,password,address,degree) "
					+ "VALUES(?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, account);
			pstmt.setString(4, password);
			pstmt.setString(5, address);
			pstmt.setString(6, degree);

			int rowAffected = pstmt.executeUpdate();
			if(rowAffected == 1)
			{
				return true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}

	//student login
	public boolean login(String account, String password) {
		try {
			String sql = "select * from students where account = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, account);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	// add an admin to admin table in other words register admin account
		public boolean registerAdmin(String faculty,String ID, String Account, String Password, String address) {
			try {
				String sql = "INSERT INTO admins(id,account,password,address,faculty) "
						+ "VALUES(?,?,?,?,?)";

				PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, ID);
				pstmt.setString(2, Account);
				pstmt.setString(3, Password);
				pstmt.setString(4, address);
				pstmt.setString(5, faculty);

				int rowAffected = pstmt.executeUpdate();
				if(rowAffected == 1)
				{
					return true;
				}

			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;	
		}
	
		//admin login
		public boolean adminLogin(String account, String password) {
			try {
				String sql = "select * from admins where account = ? and password = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, account);
				pstmt.setString(2, password);

				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) return true;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;

		}
	//by inputting the course ID, return a long String of all courses prerequisite
	public String course_prerequisite(String course_id){
		try {
			String sql = "select prequisites from courses where id = " + "'" + course_id + "';";
			Statement pstmt = conn.createStatement();

			ResultSet rs = pstmt.executeQuery(sql);

			if(rs.next()) {
				String result = rs.getString("prequisites");
				return result;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	//get all information from one stduent by inputting the stduent account and password
	public static ArrayList<String> student_info(String account, String password){
		ArrayList<String> result = new ArrayList<String>();
		try {
			String sql = "select * from students where account = ? and password = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, account);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String account1 = rs.getString("account");
				String password1 = rs.getString("password");
				String address = rs.getString("address");
				String degree = rs.getString("degree");
				result.add(id);
				result.add(name);
				result.add(account1);
				result.add(password1);
				result.add(address);
				result.add(degree);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//return the enrolled course of one student using the student ID
	public static ArrayList<ArrayList<String>> getEnrolledCourses(String student_id){
		ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
		try {
			String sql = "select * from course_enrollment where student_id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, student_id);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				ArrayList<String> record = new ArrayList<String>();
				String course_id = rs.getString("course_id");
				String name = rs.getString("name");
				String student_idr = rs.getString("student_id");
				String status = rs.getString("status");
				String term_taken = rs.getString("term_taken");
				String grade = rs.getString("grade");
				record.add(course_id);
				record.add(name);
				record.add(student_idr);
				record.add(status);
				record.add(term_taken);
				record.add(grade);
				records.add(record);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return records;
	}
	public static ArrayList<HashMap<String, String>> getRequiredCourses(String degree){
		/*
		 * Input the degree of the student.
		 * Returns Array list of course name and id in a hashmap
		 */
		ArrayList<HashMap<String,String>> courses = new ArrayList<HashMap<String,String>>();
		String query = "SELECT * FROM course_requirements WHERE degree = ?;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, degree);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HashMap<String, String> course = new HashMap<String, String>();
				String courseId = rs.getString("course_id");
				String name = rs.getString("name");
				course.put("courseId", courseId);
				course.put("name", name);
				courses.add(course);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return courses;

	}
	public static boolean addRequiredCourse(String courseId, String degree) {
		/*
		 * Inputs courseId and the degree it is meant to be required for.
		 * Returns boolean true if the insertion is executed with no problem, false otherwise.
		 * 
		 */
		
		String query = "INSERT INTO course_requirements(course_id,name,degree) VALUES(?,?,?);";
		String courseName = getCourseName(courseId);
		try {
			PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, courseId);
			pstmt.setString(2, courseName);
			pstmt.setString(3, degree);
			int rowsEffected = pstmt.executeUpdate();
			if(rowsEffected == 1) return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public static boolean removeRequiredCourse(String courseId, String degree) {
		/*
		 * Removes a required course using the inputs of the courseID and the degree it is required for
		 * returns boolean true if successful, false if not.
		 * 
		 */
		
		String query = "DELETE FROM course_requirements WHERE course_id = ? AND degree = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, courseId);
			pstmt.setString(2, degree);
			int rowsEffected = pstmt.executeUpdate();
			if(rowsEffected == 1) return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	private static String getCourseName(String courseId) {
		/*
		 * Used to get the name of a course using its Course ID
		 * Returns name if successful null if not
		 */
		String query = "SELECT * FROM courses WHERE id= ?";
		String courseName=null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, courseId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				courseName = rs.getString("name");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return courseName;
	}
	public static HashMap<String,String> getCrouseInfo(String course_id) {
		/*
		 * Input the course id (e.g. EECS2311)
		 * Returns hashmap info of the course (courseId, name, credit and prerequisites).
		 */
		String query = "SELECT * FROM courses where id = ?";
		HashMap<String,String> info = new HashMap<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, course_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				info.put("courseId", rs.getString("id"));
				info.put("name", rs.getString("name"));
				info.put("credit", rs.getString("credit"));
				info.put("prerequisites", rs.getString("prequisites"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	public static ArrayList<HashMap<String, String>> getRequiredCoursesForStudent(String studentId, String degree){
		/*
		 * Input the id of the student
		 * Returns ArrayList of the required courses of the student that they, 
		 * haven't enrolled in yet in a hashmap.
		 */
		// Enrollment: 
		ArrayList<HashMap<String, String>> studReqCours = new ArrayList<HashMap<String, String>>();
		ArrayList<HashMap<String, String>> reqCours = getRequiredCourses(degree);
		ArrayList<ArrayList<String>> enrolledCourses = getEnrolledCourses(studentId);

		for(int i = 0; i<reqCours.size(); i++) {
			boolean flag = false;
			for(int j = 0; j<enrolledCourses.size(); j++) {
				// if a required course is in the enrolledCourses make flag true and break.
				if(reqCours.get(i).get("courseId").equals(enrolledCourses.get(j).get(0))) {
					flag = true;
					break;
				}
			}
			// if required course isn't found in enrolled courses add to studReqCours
			if(!flag) {
				studReqCours.add(reqCours.get(i));
			}
		}
		return studReqCours;
	}
}
