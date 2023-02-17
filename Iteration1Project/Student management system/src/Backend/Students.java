package Backend;

import java.util.ArrayList;

public class Students {
	private ArrayList<Student> Students;
	private static Students Student_list;
	
	private Students() {
		Student student1 = new Student("bruce", "Software Engineering","North York", "316408091", "123456789", "123456");
		Student student2 = new Student("wu", "Software Engineering","North York", "316408092", "123456781", "wu123");
		Student student3 = new Student("dave", "Software Engineering","North York", "316408093", "123456782", "dave456");
	
		Students = new ArrayList<Student>();
		Students.add(student1);
		Students.add(student2);
		Students.add(student3);
		Users.getInstance().getUsers().add(student1);
		Users.getInstance().getUsers().add(student2);
		Users.getInstance().getUsers().add(student3);

	}
	
	 public static Students getInstance() {
		   if(Student_list == null) {
			   Student_list = new Students();
		   }  
		  
		return Student_list;
	   }
	 
	 public ArrayList<Student> getStudents(){
		 return Students;
	 }
}
