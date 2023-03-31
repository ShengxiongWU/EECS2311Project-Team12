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
import javax.swing.JTextField;

import Backend.Admin;
import Backend.Course;
import DB.DB;





public class MainUIAdmin extends JDialog{


	private JFrame frame = null;
	private Container container = null;
	private static MainUIAdmin instance;
	private static DB db;
	
	public static MainUIAdmin getInstance() {
		if(instance == null) {
			instance = new MainUIAdmin();
		}
		return instance;
	}
	
	private MainUIAdmin() {
		db=DB.getInstance();
		frame = new JFrame("MainUI");
		InitialFrame();

        GridBagLayout gridBag = new GridBagLayout();   
		container.setLayout(new GridLayout(3,3));
		JPanel p1 = new JPanel(gridBag);
		JPanel p2 = new JPanel(gridBag);
		JPanel p3 = new JPanel(new FlowLayout());
		CreateAndSetComponent(p1,p2,p3);
		container.add(p1);
		container.add(p2);
		container.add(p3);
		frame.setVisible(true);
	}
	
	private void CreateAndSetComponent(JPanel p1, JPanel p2, JPanel p3) {

		

		JButton CreateCourse = new JButton("Create Course");
//		JButton CheckCourse = new JButton("Check Course");
		
		CreateCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				CreateCourse c = new CreateCourse(frame);
				c.setVisible(true);
			}
		});
		
		JButton CheckCourse = new JButton("Check Course");
		
		CheckCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
			}
		});
//		p1.add(CourseCode1);
//		p1.add(CourseCodeText1);
		p1.add(CreateCourse); 

//		p2.add(CourseCode2);
//		p2.add(CourseCodeText2);
//		p2.add(CheckCourse);
		
//		p3.add(CheckCourse);

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
	private class CreateCourse extends JDialog{

		private JTextField CourseIDBox = null;
		private JTextField CourseNameBox = null;
		private JTextField CreditBox = null;
		private JTextField PrequisitesBox = null;


		private CreateCourse ad = null;
		private Container container = null;
		
		
		public CreateCourse(JFrame j) {
			super(j,"AdminRegister",true);
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

			JLabel Username = new JLabel("CourseID:");
			GridBagConstraints c2 = new GridBagConstraints();
			GridBagConstraintsSetter(c2,0,1,0);
			
			CourseNameBox = new JTextField();
			CourseNameBox.setColumns(10);
			GridBagConstraints c3 = new GridBagConstraints();
			GridBagConstraintsSetter(c3,4,2,70);

			JLabel Password = new JLabel("CourseName:");
			GridBagConstraints c4 = new GridBagConstraints();
			GridBagConstraintsSetter(c4,0,2,0);
			
			CreditBox = new JTextField();
			CreditBox.setColumns(10);
			GridBagConstraints c5 = new GridBagConstraints();
			GridBagConstraintsSetter(c5,4,3,70);

			JLabel ID = new JLabel("Credit:");
			GridBagConstraints c6 = new GridBagConstraints();
			GridBagConstraintsSetter(c6,0,3,0);
			
			PrequisitesBox = new JTextField();
			PrequisitesBox.setColumns(10);
			GridBagConstraints c7 = new GridBagConstraints();
			GridBagConstraintsSetter(c7,4,4,70);

			JLabel Prequisites = new JLabel("Prequisites:");
			GridBagConstraints c8 = new GridBagConstraints();
			GridBagConstraintsSetter(c8,0,4,0);
			
	
			
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					
					DB.addCourse(CourseIDBox.getText(),CourseNameBox.getText(),CreditBox.getText(),PrequisitesBox.getText());
				}
			});

			p1.add(CourseIDBox,c1); 
			p1.add(Username,c2); 
			p1.add(CourseNameBox,c3); 
			p1.add(Password,c4);
			p1.add(CreditBox,c5); 
			p1.add(ID,c6);
			p1.add(PrequisitesBox,c7); 
			p1.add(Prequisites,c8);
			p2.add(submit);
		}
		
		
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			}
			
			
			
		}






	}
	

}
