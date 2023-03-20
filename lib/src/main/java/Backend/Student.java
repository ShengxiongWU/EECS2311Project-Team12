package Backend;

import DB.DB;

public class Student extends User{
	private String Name;
	private String Degree;
	private String Address;
    private DB db = DB.getInstance();
    private boolean status;
    
	public Student(String name, String degree,String Address, String ID, String Account, String Password) {
		super(ID,Account,Password);
		this.Name = name;
		this.Degree = degree;
		this.Address = Address;
		status = db.registerStudent(ID, name, Account, Password, Address, degree);
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getDegree() {
		return Degree;
	}
	
	public void setDegree(String degree) {
		Degree = degree;
	}
	
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	//checking if a stduent is registered in the database or not
	public boolean getStatus() {
		return status;
	}
	
}