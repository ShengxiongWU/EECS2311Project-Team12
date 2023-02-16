package Backend;

public class User {
	
	private String ID;
	private String Account;
	private String Password;
	
	
	
	
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
	
}
