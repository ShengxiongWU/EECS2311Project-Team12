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

import javax.swing.JButton;
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
		container.setLayout(new GridLayout(4,4));
		JPanel p1 = new JPanel(gridBag);
		JPanel p2 = new JPanel(gridBag);
		JPanel p3 = new JPanel(gridBag);
		JPanel p4 = new JPanel(new FlowLayout());
		CreateAndSetComponent(p1,p2,p3,p4);
		container.add(p1);
		container.add(p2);
		container.add(p3);
		frame.setVisible(true);
	}
	
	private class Result extends JDialog {
		public Result(JFrame j,String m) {
			super(j,"result",true);
			setSize(450,150);
			setLocationRelativeTo(null);
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			JTextArea error = new JTextArea(m);
			c.add(error);
		}

	}
	
	private void CreateAndSetComponent(JPanel p1, JPanel p2, JPanel p3,JPanel p4) {

		
		JLabel CourseCode1 = new JLabel("Course Code:");
		JLabel CourseCode2 = new JLabel("Course Code:");
//		JTextField CourseCodeText1 = new JTextField();
//		JTextField CourseCodeText2 = new JTextField();
//		CourseCodeText1.setColumns(10);
//		CourseCodeText2.setColumns(10);
		JButton AddCourse = new JButton("Add Course");
		
		JButton GetPersonalInfo = new JButton("Get personal information");
		
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
		
		JButton CheckCourse = new JButton("Check Course");
		
		AddCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				AddCourse ad = new AddCourse(frame,DB.student_info(account, password).get(1),DB.student_info(account, password).get(0),"waiting","NA");
				ad.setVisible(true);
			}
		});
		
		JButton DropCourse = new JButton("Drop Course");
		
		DropCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
			}
		});
//		p1.add(CourseCode1);
//		p1.add(CourseCodeText1);
		p1.add(AddCourse); 

//		p2.add(CourseCode2);
//		p2.add(CourseCodeText2);
		p2.add(DropCourse);
		p3.add(GetPersonalInfo);
		p4.add(CheckCourse);

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
		private JTextField TermBox = null;
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
				super(j,"error",true);
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
			
			TermBox = new JTextField();
			TermBox.setColumns(10);
			GridBagConstraints c3 = new GridBagConstraints();
			GridBagConstraintsSetter(c3,4,2,70);

			JLabel Term = new JLabel("Term:");
			GridBagConstraints c4 = new GridBagConstraints();
			GridBagConstraintsSetter(c4,0,2,0);
			
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					DB.addEnrollment(CourseIDBox.getText(), StudentName, StudentID, status, TermBox.getText(), grade);
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

	

}
