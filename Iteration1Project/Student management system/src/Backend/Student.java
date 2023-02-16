package Backend;

public class Student extends User{
	private String Name;
	private String Degree;
	
	
	
	
	public Student(String name, String degree,String ID, String Account, String Password) {
		super(ID,Account,Password);
		this.Name = name;
		this.Degree = degree;
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
	
	
}
