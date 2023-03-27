package Backend;


public class Admin extends User{

	private String Faculty;
	private String address;
	
	/*
     * Admin Constructor 
     */
	public Admin(String faculty,String ID, String Account, String Password, String address) {
		super(ID,Account,Password);
		this.address = address;
		Faculty = faculty;
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
	
	
}
