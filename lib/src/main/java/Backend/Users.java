package Backend;

import java.util.ArrayList;

public class Users {

	private ArrayList<User> Users;
	private static Users User_list;
	
	private Users() {
		Users = new ArrayList<User>();
	}
	
	 public static Users getInstance() {
		   if(User_list == null) {
			   User_list = new Users();
		   }  
		  
		return User_list;
	   }
	 
	 public ArrayList<User> getUsers(){
		 return Users;
	 }
}
