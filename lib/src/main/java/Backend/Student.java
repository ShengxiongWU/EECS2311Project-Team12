package Backend;

import DB.DB;

public class Student extends User{
	//Initialize student information 
	private String studentName;
	private String Degree;
	private String studentAddress;
    private DB db = DB.getInstance();
    private boolean status;
    /*
     * Student constructor 
     */
	public Student(String name, String degree,String Address, String ID, String Account, String Password) {
		super(ID,Account,Password);
		this.studentName = name;
		this.Degree = degree;
		this.studentAddress = Address;
		status = db.registerStudent(ID, name, Account, Password, Address, degree);
	}
	/*
     * getter method for Student name 
     */
	public String getName() {
		return studentName;
	}
	/*
     * setter method for Student name 
     */
	public void setName(String name) {
		studentName = name;
	}
	/*
     * getter method for student degree
     */
	public String getDegree() {
		return Degree;
	}
	/*
     * setter method for student degree 
     */
	public void setDegree(String degree) {
		Degree = degree;
	}
	/*
     * getter method for Student address 
     */
	public String getAddress() {
		return studentAddress;
	}
	/*
     * setter method for Student address 
     */
	public void setAddress(String address) {
		studentAddress = address;
	}
	
	//checking if a stduent is registered in the database or not
	public boolean getStatus() {
		return status;
	}
	
}