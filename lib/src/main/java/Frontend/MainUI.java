package Frontend;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Backend.Admin;
import DB.DB;







public class MainUI extends JDialog{


	private JFrame frame = null;
	private Container container = null;
	private static DB db;
	private static String account;
	private static String password;

	
	public static MainUI getInstance(String account, String password) {

		return new MainUI(account,password);
	}
	
	private MainUI(String account, String password) {
		this.account = account;
		this.password = password;
		db=DB.getInstance();
		frame = new JFrame("MainUI");
		InitialFrame();

        GridBagLayout gridBag = new GridBagLayout();   
		container.setLayout(new GridLayout(7,7));
		JPanel p1 = new JPanel(gridBag);
		JPanel p2 = new JPanel(gridBag);
		JPanel p3 = new JPanel(gridBag);
		JPanel p4 = new JPanel(gridBag);
		JPanel p5 = new JPanel(gridBag);
		JPanel p6 = new JPanel(gridBag);
		JPanel p7 = new JPanel(new FlowLayout());
		CreateAndSetComponent(p1,p2,p3,p4,p5,p6,p7);
		container.add(p1);
		container.add(p2);
		container.add(p3);
		container.add(p4);
		container.add(p5);
		container.add(p6);
		container.add(p7);
		frame.setVisible(true);
	}
	
	private class Result extends JDialog {
		public Result(JFrame j,String m) {
			super(j,"result",true);
			setSize(800,500);
			setLocationRelativeTo(null);
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			JTextArea error = new JTextArea(m);
			c.add(error);
		}

	}
	
	private void CreateAndSetComponent(JPanel p1, JPanel p2, JPanel p3,JPanel p4,JPanel p5,JPanel p6,JPanel p7) {

		

		JButton AddCourse = new JButton("Add Course");
		
		JButton DropCourse = new JButton("Drop Course");
		
		JButton GetPersonalInfo = new JButton("Get personal information");
		
		JButton CheckCourse = new JButton("Check Course");
		
		JButton GetOverallGPA = new JButton("Check GPA");
		
		JButton GetRequiredCourses = new JButton("Get Required Courses");
		
		JButton ChangePersonalInfo = new JButton("Change personal information");
		

		
		GetPersonalInfo.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ArrayList<String> result = DB.student_info(account, password);
				String s = "id: "+result.get(0)+"\n"+"name: "+result.get(1)
				+ "\n" + "account: " + result.get(2) + "\n" + "password: "
				+ result.get(3) + "\n" + "address: " + result.get(4) + "\n"
				+ "degree: " + result.get(5);
				Result s2 = new Result(frame, s);
				s2.setVisible(true);
			}
		});
		
		ChangePersonalInfo.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ChangePersonalInfo ad = new ChangePersonalInfo(frame);

			}
		});
		
		AddCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				AddCourse ad = new AddCourse(frame,DB.student_info(account, password).get(1),DB.student_info(account, password).get(0),"inprogress","NA");
//				ad.setVisible(true);
			}
		});
		

		
		DropCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				DropCourse d = new DropCourse(frame);
			}
		});
		
		CheckCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ArrayList<ArrayList<String>> result0 = DB.getEnrolledCourses(DB.getStudentID(account, password));
				
				String s = "";
				for(ArrayList<String> result: result0 ) {
					s += "course_id: "+result.get(0)+"\n"+"Course_name: "+result.get(1)
					+ "\n" + "status: " + result.get(3) + "\n" + "term_taken: "
					+ result.get(4) + "\n" + "grade: " + result.get(5) + "\n\n";
				}

				Result s2 = new Result(frame, s);
				s2.setVisible(true);
			}
		});
		
		GetOverallGPA.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String result = "Your Overall GPA is " + DB.getOverAllGPAForStudent(DB.getStudentID(account, password));
				Result s2 = new Result(frame, result);
				s2.setVisible(true);
			}
		});
		
		GetRequiredCourses.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ArrayList<HashMap<String, String>> result0 = DB.getRequiredCoursesForStudent(DB.getStudentID(account, password),DB.getStudentDegree(account, password));
				
				String s = "";
				for(HashMap<String, String> result: result0 ) {
					s += "course_id: "+result.get("courseId")+"\n"+"Course_name: "+result.get("name")
					+ "\n" + "credit: " + result.get("credit") + "\n" +
					"prerequisites: "+result.get("prerequisites") + "\n\n";
				}

				Result s2 = new Result(frame, s);
				s2.setVisible(true);
			}
		});
		

		p1.add(AddCourse); 

		p2.add(DropCourse);
		p3.add(GetPersonalInfo);
		p4.add(CheckCourse);
		p5.add(GetOverallGPA);
		p6.add(GetRequiredCourses);
		p7.add(ChangePersonalInfo);

	}
	

	
	private void InitialFrame() {
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		container = frame.getContentPane();
	}
	
	private class AccessListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
		
		
		
	}
	
	private class AddCourse extends JDialog{

		private JTextField CourseIDBox = null;
		Vector<String> TermName = new Vector<String>();
		JComboBox<String> TermBox;
		private AddCourse ad = null;
		private Container container = null;
		private String StudentName;
		private String StudentID;
		private String status;
		private String grade;
		
		
		public AddCourse(JFrame j, String StudentName, String StudentID, String status, String grade) {
			super(j,"AddCourse",true);
			this.ad = this;
			InitialFrame();
	        GridBagLayout gridBag = new GridBagLayout();   
			container.setLayout(new GridLayout(2,1));
			JPanel p1 = new JPanel(gridBag);
			JPanel p2 = new JPanel(new FlowLayout());

			CreateAndSetComponent(p1,p2);
			container.add(p1);
			container.add(p2);
			
			this.StudentName = StudentName;
			this.StudentID = StudentID;
			this.status = status;
			this.grade = grade;
			ad.setVisible(true);
		}

		private class Error extends JDialog {
			public Error(JFrame j,String m) {
				super(j,"result",true);
				setSize(450,150);
				setLocationRelativeTo(null);
				Container c = getContentPane();
				c.setLayout(new FlowLayout());
				JLabel error = new JLabel(m);
				c.add(error);
			}

		}
		private void InitialFrame() {
			ad.setSize(400, 350);
			ad.setLocationRelativeTo(null);
			container = ad.getContentPane();
		}
		private void GridBagConstraintsSetter(GridBagConstraints c, int gridx, int gridy, int ipadx) {
			c.gridx = gridx;
			c.gridy = gridy;
			c.ipadx = ipadx;
		}
		private void CreateAndSetComponent(JPanel p1, JPanel p2) {
			CourseIDBox = new JTextField();
			CourseIDBox.setColumns(10);
			GridBagConstraints c1 = new GridBagConstraints();
			GridBagConstraintsSetter(c1,4,1,70);

			JLabel CourseID = new JLabel("Course ID:");
			GridBagConstraints c2 = new GridBagConstraints();
			GridBagConstraintsSetter(c2,0,1,0);
			
			TermName.add("FALL");
			TermName.add("WINTER");
			TermName.add("SUMMER");
			TermBox = new JComboBox<String>(TermName);
			TermBox.setSelectedItem("FALL");
			GridBagConstraints c3 = new GridBagConstraints();
			GridBagConstraintsSetter(c3,4,2,70);

			JLabel Term = new JLabel("Term:");
			GridBagConstraints c4 = new GridBagConstraints();
			GridBagConstraintsSetter(c4,0,2,0);
			
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					boolean f = DB.addEnrollment(CourseIDBox.getText(), StudentName, StudentID, status, (String)TermBox.getSelectedItem(), grade);
					if(f) {
						Error e1 = new Error(frame,"success");
						ad.setVisible(false);
						e1.setVisible(true);

						
					}else {
						Error e2 = new Error(frame,"fail");
						ad.setVisible(false);
						e2.setVisible(true);

					}
					
				
				}
			});
			
			p1.add(CourseIDBox,c1); 
			p1.add(CourseID,c2); 
			p1.add(TermBox,c3); 
			p1.add(Term,c4);

			p2.add(submit);
		}
		
		
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			}
			
			
			
		}






	}
	
	private class DropCourse extends JDialog{

		private JTextField CourseIDBox = null;
		private DropCourse ad = null;
		private Container container = null;

		
		public DropCourse(JFrame j) {
			super(j,"AddCourse",true);
			this.ad = this;
			InitialFrame();
	        GridBagLayout gridBag = new GridBagLayout();   
			container.setLayout(new GridLayout(2,1));
			JPanel p1 = new JPanel(gridBag);
			JPanel p2 = new JPanel(new FlowLayout());

			CreateAndSetComponent(p1,p2);
			container.add(p1);
			container.add(p2);
			
			ad.setVisible(true);
		}

		private class Error extends JDialog {
			public Error(JFrame j,String m) {
				super(j,"result",true);
				setSize(450,150);
				setLocationRelativeTo(null);
				Container c = getContentPane();
				c.setLayout(new FlowLayout());
				JLabel error = new JLabel(m);
				c.add(error);
			}

		}
		private void InitialFrame() {
			ad.setSize(400, 350);
			ad.setLocationRelativeTo(null);
			container = ad.getContentPane();
		}
		private void GridBagConstraintsSetter(GridBagConstraints c, int gridx, int gridy, int ipadx) {
			c.gridx = gridx;
			c.gridy = gridy;
			c.ipadx = ipadx;
		}
		private void CreateAndSetComponent(JPanel p1, JPanel p2) {
			CourseIDBox = new JTextField();
			CourseIDBox.setColumns(10);
			GridBagConstraints c1 = new GridBagConstraints();
			GridBagConstraintsSetter(c1,4,1,70);

			JLabel CourseID = new JLabel("Course ID:");
			GridBagConstraints c2 = new GridBagConstraints();
			GridBagConstraintsSetter(c2,0,1,0);
	
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					boolean f = DB.dropEnrollment(DB.getStudentID(account, password), CourseIDBox.getText());
					if(f) {
						Error e1 = new Error(frame,"success");
						ad.setVisible(false);
						e1.setVisible(true);

						
					}else {
						Error e2 = new Error(frame,"fail");
						ad.setVisible(false);
						e2.setVisible(true);

					}
					
				
				}
			});
			
			p1.add(CourseIDBox,c1); 
			p1.add(CourseID,c2); 

			p2.add(submit);
		}
		
		
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			}
			
			
			
		}






	}
	
	private class ChangePersonalInfo extends JDialog{

		private JTextField NameBox = null;
		private JTextField DegreeBox = null;
		private JTextField PasswordBox = null;
		private JTextField AddressBox = null;
		private ChangePersonalInfo ad = null;
		private Container container = null;
		private String status;
		private String grade;
		
		
		public ChangePersonalInfo(JFrame j) {
			super(j,"ChangePersonalInfo",true);
			this.ad = this;
			InitialFrame();
	        GridBagLayout gridBag = new GridBagLayout();   
			container.setLayout(new GridLayout(2,1));
			JPanel p1 = new JPanel(gridBag);
			JPanel p2 = new JPanel(new FlowLayout());

			CreateAndSetComponent(p1,p2);
			container.add(p1);
			container.add(p2);

			ad.setVisible(true);
		}

		private class Error extends JDialog {
			public Error(JFrame j,String m) {
				super(j,"result",true);
				setSize(450,150);
				setLocationRelativeTo(null);
				Container c = getContentPane();
				c.setLayout(new FlowLayout());
				JLabel error = new JLabel(m);
				c.add(error);
			}

		}
		private void InitialFrame() {
			ad.setSize(400, 350);
			ad.setLocationRelativeTo(null);
			container = ad.getContentPane();
		}
		private void GridBagConstraintsSetter(GridBagConstraints c, int gridx, int gridy, int ipadx) {
			c.gridx = gridx;
			c.gridy = gridy;
			c.ipadx = ipadx;
		}
		private void CreateAndSetComponent(JPanel p1, JPanel p2) {
			NameBox = new JTextField();
			NameBox.setColumns(10);
			GridBagConstraints c1 = new GridBagConstraints();
			GridBagConstraintsSetter(c1,4,1,70);

			JLabel Name = new JLabel("Name:");
			GridBagConstraints c2 = new GridBagConstraints();
			GridBagConstraintsSetter(c2,0,1,0);
			
			DegreeBox = new JTextField();
			DegreeBox.setColumns(10);
			GridBagConstraints c3 = new GridBagConstraints();
			GridBagConstraintsSetter(c3,4,2,70);

			JLabel Term = new JLabel("Degree:");
			GridBagConstraints c4 = new GridBagConstraints();
			GridBagConstraintsSetter(c4,0,2,0);
			
			PasswordBox = new JTextField();
			PasswordBox.setColumns(10);
			GridBagConstraints c5 = new GridBagConstraints();
			GridBagConstraintsSetter(c5,4,3,70);

			JLabel Password = new JLabel("Password:");
			GridBagConstraints c6 = new GridBagConstraints();
			GridBagConstraintsSetter(c6,0,3,0);
			
			AddressBox = new JTextField();
			AddressBox.setColumns(10);
			GridBagConstraints c7 = new GridBagConstraints();
			GridBagConstraintsSetter(c7,4,4,70);

			JLabel Address = new JLabel("Address:");
			GridBagConstraints c8 = new GridBagConstraints();
			GridBagConstraintsSetter(c8,0,4,0);
			
			
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					HashMap<String, Boolean> h =  DB.changePersonalInfo(DB.getStudentID(account, password),NameBox.getText(),PasswordBox.getText(),AddressBox.getText(),DegreeBox.getText());
					String s = "";
					for(String k :h.keySet()) {
						s += k + " : " + h.get(k) + "\n";
					}
					
					Result r = new Result(frame,s);


				}
			});
			
			p1.add(NameBox,c1); 
			p1.add(Name,c2); 
			
			p1.add(DegreeBox,c7); 
			p1.add(Term,c8);
			
			p1.add(PasswordBox,c3); 
			p1.add(Password,c4); 
			
			p1.add(AddressBox,c5); 
			p1.add(Address,c6);
			

			p2.add(submit);
		}
		
		
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			}
			
			
			
		}






	}

	

}
