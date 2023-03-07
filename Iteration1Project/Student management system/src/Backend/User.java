package Backend;

public class User {
	
	private String ID;
	private String Account;
	private String Password;
	private int totalCourses;
    private int completedCourses;

	
	
	
	public User(String ID, String Account, String Password) {
		this.ID = ID;
		this.Account = Account;
		this.Password = Password;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	 public int getTotalCourses() {
	    return totalCourses;
	}

    public void setTotalCourses(int totalCourses) {
	    this.totalCourses = totalCourses;
    }

    public int getCompletedCourses() {
	    return completedCourses;
	 }
}
