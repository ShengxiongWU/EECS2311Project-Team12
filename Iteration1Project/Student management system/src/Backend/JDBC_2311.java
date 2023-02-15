import java.sql.*;

public class JDBC_2311 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/";
		String user = "root";
		String password = "123456";
		String query = "CREATE database MyDatabase";
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			Statement statement = con.createStatement();
			String sql = "CREATE DATABASE STUDENTS";
	        statement.executeUpdate(sql);
	        System.out.println("Database created successfully...");
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
}
