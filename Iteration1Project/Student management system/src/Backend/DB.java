import java.sql.*;

public class DB {
    public String url = "jdbc:mysql://127.0.0.1:3306/";
    public String user = "root";
    public String password = "123456";

    public DB(){
        try {
            Connection con = DriverManager.getConnection(url,user,password);
            Statement statement = con.createStatement();
            String create_studentTable = "create table students" +
                    "(id varchar(25) not NULL unique, " +
                    " account CHAR(9), " +
                    " password VARCHAR(25), " +
                    " address VARCHAR(100), " +
                    " degree VARCHAR(100), " +
                    " PRIMARY KEY ( account, password ))";

            String create_courseTable = "create table courses" +
                    "(id varchar(25) not NULL, " +
                    " name VARCHAR(20), " +
                    " credit VARCHAR(20), " +
                    " prequisites VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";

            String create_courseEnrolmentTable = "create table course_enrolment" +
                    "(course_id varchar(25) not null" +
                    " name VARCHAR(20), " +
                    " student_id VARCHAR(20), not null" +
                    " status VARCHAR(20), not null" +
                    " term_taken VARCHAR(20), not null" +
                    " prequisites VARCHAR(255), " +
                    " PRIMARY KEY ( course_id, student_id))" +
                    "FOREIGN KEY (student_id) REFERENCES students(id)" +
                    "FOREIGN KEY (course_id) REFERENCES courses(id)";

            String create_adminTable = "create table admins" +
                    "(id varchar(25) not NULL unique, " +
                    " account CHAR(10), " +
                    " password VARCHAR(25), " +
                    " address VARCHAR(100), " +
                    " faculty VARCHAR(30), " +
                    " PRIMARY KEY ( account, password ))";

            statement.executeUpdate(sql);
            System.out.println("Database created successfully...");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}