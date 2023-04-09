package Backend;

import java.util.ArrayList;

public class Users {
	//Initialize users and user list
	private ArrayList<User> Users;
	private static Users User_list;
	
	private Users() {
		Users = new ArrayList<User>();
	}
	//get instance of a user
	 public static Users getInstance() {
		   if(User_list == null) {
			   User_list = new Users();
		   }  
		  
		return User_list;
	   }
	 //Getter method for user
	 public ArrayList<User> getUsers(){
		 return Users;
	 }
}
