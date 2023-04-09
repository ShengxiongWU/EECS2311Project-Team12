package Backend;

public class User {
	//Initialize user variables
	private String ID;
	private String Account;
	private String Password;
	
	/*
	 * User constructor 
	 */
	public User(String ID, String Account, String Password) {
		this.ID = ID;
		this.Account = Account;
		this.Password = Password;
		
	}
	/*
	 * Getter method for user id
	 */
	public String getID() {
		return ID;
	}
	/*
	 * setter method for user id
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	/*
	 * Getter method for user account
	 */
	public String getAccount() {
		return Account;
	}
	/*
	 * setter method for user account
	 */
	public void setAccount(String account) {
		Account = account;
	}
	/*
	 * Getter method for user password
	 */
	public String getPassword() {
		return Password;
	}
	/*
	 * setter method for user password
	 */
	public void setPassword(String password) {
		Password = password;
	}
	
}
