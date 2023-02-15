package Backend;
import java.sql.*;
import java.util.*;

public class DatabaseController {
	// database connection details
	private final String url = "jdbc:mysql://localhost:3306/report";
	private final String user = "admin";
	private final String pass = "!!PrivateEyes!!";
	private Connection con;

	public DatabaseController() {
		try {
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("CONNECTED TO DB!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> getStudentCourses(int studentID) {
		/*
		 * Args: the student ID you want the courses for.
		 * Returns: List of the courses that they have enrolled in.
		 */
		String query ="SELECT student_id,course_id,status FROM course_enrollment WHERE student_id=" + studentID + " and status='Completed'";
		List<String> courses = new ArrayList<>();
		try(
				Statement statement = con.createStatement();
				ResultSet res = statement.executeQuery(query);
				){
			while(res.next()) {
				courses.add(res.getString("course_id"));
			}
			return courses;
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return courses;
	}


}
