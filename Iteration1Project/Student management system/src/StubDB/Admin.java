package StubDB;

public class Admin extends User{

	private String Faculty;

	
	
	public Admin(String faculty,String ID, String Account, String Password) {
		super(ID,Account,Password);
		Faculty = faculty;
	}

	public String getFaculty() {
		return Faculty;
	}

	public void setFaculty(String faculty) {
		Faculty = faculty;
	}
	
	
}
