package Backend;


public class Admin extends User{

	private String Faculty;

	
	/*
     * Admin Constructor 
     */
	public Admin(String faculty,String ID, String Account, String Password) {
		super(ID,Account,Password);
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
