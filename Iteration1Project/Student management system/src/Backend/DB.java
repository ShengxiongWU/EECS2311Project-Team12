import java.sql.*;

public class DB {
	public String url;
    public String user;
    public String password;
    public Connection conn;
//    String url = "jdbc:mysql://127.0.0.1:3306";
//	String user = "root";
//    String password = "123456";
    
    public DB(){
	        try {
	        	this.url = url;
	        	this.user = user;
	        	this.password = password;
	            conn = DriverManager.getConnection(url,user,password);
	            Statement statement = conn.createStatement();
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
	                    " name varchar(50), " +
	                    " credit VARCHAR(20), " +
	                    " prequisites VARCHAR(255), " +
	                    " PRIMARY KEY ( id ));";

	            String create_courseEnrolmentTable = "create table course_enrollment" +
	                    "(course_id varchar(25) not null," +
	                    " name VARCHAR(50), " +
	                    " student_id VARCHAR(20) not null," +
	                    " status VARCHAR(20) not null," +
	                    " term_taken VARCHAR(10) not null," +
	                    " prequisites VARCHAR(255), " +
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
	        }
	        catch (SQLException e){
	            e.printStackTrace();
	        }
    }
    
    
    
    public boolean enroll(String id, String account, String password, String address, String degree) {
    	try {
    		String sql = "INSERT INTO students(id,account,password,address,degree) "
    	            + "VALUES(?,?,?,?,?)";

	    	PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	    	
	    	pstmt.setString(1, id);
	    	pstmt.setString(2, account);
	    	pstmt.setString(3, password);
	    	pstmt.setString(4, address);
	    	pstmt.setString(5, degree);
	    	
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
    
    public boolean login(String account, String password) {
    	try {
    		String sql = "select * from students where account = ? and password = ?";
    		PreparedStatement pstmt = conn.prepareStatement(sql);
	    	
    		pstmt.setString(1, account);
    		pstmt.setString(2, password);
	    	
	    	 ResultSet rs = pstmt.executeQuery(sql);
	    	 
	    	 if(rs.next()) return true;
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
		return false;
    	
    }
}