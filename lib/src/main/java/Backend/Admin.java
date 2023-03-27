package Backend;

import DB.DB;

public class Admin extends User{

	private String Faculty;
	private String address;
	private DB db = DB.getInstance();
	private boolean status;
	
	/*
     * Admin Constructor 
     */
	public Admin(String faculty,String ID, String Account, String Password, String address) {
		super(ID,Account,Password);
		this.address = address;
		Faculty = faculty;
		status = db.registerAdmin(faculty,ID, Account, Password, address);
	}
    /*
     * getter method for Faculty
     */
	public String getFaculty() {
		return Faculty;
	}
	/*
     * setter method for Faculty
     */
	public void setFaculty(String faculty) {
		Faculty = faculty;
	}
	//checking if an admin is registered in the database or not
		public boolean getStatus() {
			return status;
		}
	
}
