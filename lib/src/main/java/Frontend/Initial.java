package Frontend;

import java.awt.Container;


import java.awt.Dialog;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Backend.Admin;
import Backend.Student;
import Backend.User;
import DB.DB;




public class Initial {
	

	private JFrame frame = null;
	private Container container = null;
	private static Initial instance;
	private static DB db;
	
	public static Initial getInstance() {
		if(instance == null) {
			instance = new Initial();
		}
		return instance;
	}
	
	private Initial() {
		db=DB.getInstance();
		frame = new JFrame("Initial");
		InitialFrame();

        GridBagLayout gridBag = new GridBagLayout();   
		container.setLayout(new GridLayout(2,1));
		JPanel p1 = new JPanel(gridBag);
		JPanel p2 = new JPanel(new FlowLayout());
		CreateAndSetComponent(p1,p2);
		container.add(p1);
		container.add(p2);
		frame.setVisible(true);
	}
	
	private void CreateAndSetComponent(JPanel p1, JPanel p2) {

		
		
		JButton register = new JButton("Register");
		
		register.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				new TypeSelector(frame);
			}
		});
		
		JButton login = new JButton("Login");
		
		login.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				new Login(frame);
			}
		});
		
		p1.add(login); 

		p2.add(register);
	}
	

	
	private void InitialFrame() {
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		container = frame.getContentPane();
	}
	
	private class AccessListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
		
		
		
	}
	
	private class Login extends JDialog{

		
		private JTextField UsernameBox = null;
		private JPasswordField PasswordBox = null;
//		private Map<String,String> DataBase = null;
		private Login lg = null;
		private Container container = null;
		
		
		public Login(JFrame j) {
			super(j,"Login",true);
			this.lg = this;
			InitialFrame();
	        GridBagLayout gridBag = new GridBagLayout();   
			container.setLayout(new GridLayout(2,1));
			JPanel p1 = new JPanel(gridBag);
			JPanel p2 = new JPanel(new FlowLayout());
			Map<String,String> db = new HashMap<String,String>();
//			DataBase = db;
			CreateAndSetComponent(p1,p2);
			container.add(p1);
			container.add(p2);
			lg.setVisible(true);
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
			lg.setSize(400, 150);
			lg.setLocationRelativeTo(null);
			container = lg.getContentPane();
		}
		private void GridBagConstraintsSetter(GridBagConstraints c, int gridx, int gridy, int ipadx) {
			c.gridx = gridx;
			c.gridy = gridy;
			c.ipadx = ipadx;
		}
		private void CreateAndSetComponent(JPanel p1, JPanel p2) {
			UsernameBox = new JTextField();
			UsernameBox.setColumns(10);
			GridBagConstraints c1 = new GridBagConstraints();
			GridBagConstraintsSetter(c1,4,1,70);

			JLabel Username = new JLabel("Username:");
			GridBagConstraints c2 = new GridBagConstraints();
			GridBagConstraintsSetter(c2,0,1,0);
			
			PasswordBox = new JPasswordField();
			PasswordBox.setColumns(10);
			GridBagConstraints c3 = new GridBagConstraints();
			GridBagConstraintsSetter(c3,4,2,70);

			JLabel Password = new JLabel("Password:");
			GridBagConstraints c4 = new GridBagConstraints();
			GridBagConstraintsSetter(c4,0,2,0);
			
			JLabel fill1 = new JLabel(" ");
			GridBagConstraints cf1 = new GridBagConstraints();
			GridBagConstraintsSetter(cf1,0,0,0);
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					if(UsernameBox.getText().length()==9)
					{
						if(db.login(UsernameBox.getText(),new String(PasswordBox.getPassword()))) {
							frame.setVisible(false);
							lg.setVisible(false);
							MainUI.getInstance(UsernameBox.getText(),new String(PasswordBox.getPassword()));
						}else {
							Error error = new Error(frame,"fail");
							error.setVisible(true);
							System.exit(0);
						}
					}else if(UsernameBox.getText().length()==10) {
						if(db.adminLogin(UsernameBox.getText(),new String(PasswordBox.getPassword()))) {
							frame.setVisible(false);
							lg.setVisible(false);
							MainUIAdmin.getInstance();
						}else {
								Error error = new Error(frame,"fail");
								error.setVisible(true);
								System.exit(0);
						}

					}
					Error error = new Error(frame,"incorrect username");
					error.setVisible(true);
					
					
				}

					
		

					
				
			});
			
			p1.add(fill1,cf1); 
			p1.add(UsernameBox,c1); 
			p1.add(Username,c2); 
			p1.add(PasswordBox,c3); 
			p1.add(Password,c4);
			p2.add(submit);
		}
		
		


		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {

			}
			
			
			
		}






	}
	
	private class TypeSelector extends JDialog{

		
		private Container container = null;
		private TypeSelector ts = null;
		
		public TypeSelector(JFrame j) {
			super(j,"TypeSelector",true);
			this.ts = this;
			InitialFrame();
	        GridBagLayout gridBag = new GridBagLayout();   
			container.setLayout(new GridLayout(2,1));
			JPanel p1 = new JPanel(gridBag);
			JPanel p2 = new JPanel(new FlowLayout());
			CreateAndSetComponent(p1,p2);
			container.add(p1);
			container.add(p2);
			ts.setVisible(true);
		}
		
		private void CreateAndSetComponent(JPanel p1, JPanel p2) {

			
			
			JButton register = new JButton("Student");
			
			register.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					new StudentRegister(frame);
				}
			});
			
			JButton login = new JButton("Admin");
			
			login.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					new AdminRegister(frame);
				}
			});
			
			p1.add(login); 

			p2.add(register);
		}
		

		
		private void InitialFrame() {
			ts.setSize(500, 300);
			ts.setLocationRelativeTo(null);
			container = ts.getContentPane();
		}
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				
			}
			
			
			
		}
		
		private class StudentRegister extends JDialog{

			
			private JTextField UsernameBox = null;
			private JTextField PasswordBox = null;
			private JTextField IDBox = null;
			private JTextField NameBox = null;
			private JTextField AddressBox = null;
			private JTextField DegreeBox = null;
			private Map<String,String> DataBase = null;
			private StudentRegister sr = null;
			private Container container = null;
			
			
			public StudentRegister(JFrame j) {
				super(j,"StudentRegister",true);
				this.sr = this;
				InitialFrame();
		        GridBagLayout gridBag = new GridBagLayout();   
				container.setLayout(new GridLayout(2,1));
				JPanel p1 = new JPanel(gridBag);
				JPanel p2 = new JPanel(new FlowLayout());
				Map<String,String> db = new HashMap<String,String>();
				DataBase = db;
				CreateAndSetComponent(p1,p2);
				container.add(p1);
				container.add(p2);
				sr.setVisible(true);
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
				sr.setSize(400, 350);
				sr.setLocationRelativeTo(null);
				container = sr.getContentPane();
			}
			private void GridBagConstraintsSetter(GridBagConstraints c, int gridx, int gridy, int ipadx) {
				c.gridx = gridx;
				c.gridy = gridy;
				c.ipadx = ipadx;
			}
			private void CreateAndSetComponent(JPanel p1, JPanel p2) {
				UsernameBox = new JTextField();
				UsernameBox.setColumns(10);
				GridBagConstraints c1 = new GridBagConstraints();
				GridBagConstraintsSetter(c1,4,1,70);

				JLabel Username = new JLabel("Username:");
				GridBagConstraints c2 = new GridBagConstraints();
				GridBagConstraintsSetter(c2,0,1,0);
				
				PasswordBox = new JTextField();
				PasswordBox.setColumns(10);
				GridBagConstraints c3 = new GridBagConstraints();
				GridBagConstraintsSetter(c3,4,2,70);

				JLabel Password = new JLabel("Password:");
				GridBagConstraints c4 = new GridBagConstraints();
				GridBagConstraintsSetter(c4,0,2,0);
				
				IDBox = new JTextField();
				IDBox.setColumns(10);
				GridBagConstraints c5 = new GridBagConstraints();
				GridBagConstraintsSetter(c5,4,3,70);

				JLabel ID = new JLabel("ID:");
				GridBagConstraints c6 = new GridBagConstraints();
				GridBagConstraintsSetter(c6,0,3,0);
				
				NameBox = new JTextField();
				NameBox.setColumns(10);
				GridBagConstraints c7 = new GridBagConstraints();
				GridBagConstraintsSetter(c7,4,4,70);

				JLabel Name = new JLabel("Name:");
				GridBagConstraints c8 = new GridBagConstraints();
				GridBagConstraintsSetter(c8,0,4,0);
				
				AddressBox = new JTextField();
				AddressBox.setColumns(10);
				GridBagConstraints c9 = new GridBagConstraints();
				GridBagConstraintsSetter(c9,4,5,70);

				JLabel Address = new JLabel("Address:");
				GridBagConstraints c10 = new GridBagConstraints();
				GridBagConstraintsSetter(c10,0,5,0);
				
				DegreeBox = new JTextField();
				DegreeBox.setColumns(10);
				GridBagConstraints c11 = new GridBagConstraints();
				GridBagConstraintsSetter(c11,4,6,70);

				JLabel Degree = new JLabel("Degree:");
				GridBagConstraints c12 = new GridBagConstraints();
				GridBagConstraintsSetter(c12,0,6,0);
				
				JLabel fill1 = new JLabel(" ");
				GridBagConstraints cf1 = new GridBagConstraints();
				GridBagConstraintsSetter(cf1,0,0,0);
				
				JButton submit = new JButton("Submit!");
				
				submit.addActionListener(new AccessListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						if(UsernameBox.getText().length()!=9) {
							Error error = new Error(frame,"valid username is 9 digits");
							error.setVisible(true);
							
						}else {
							Student s = new Student(NameBox.getText(),DegreeBox.getText(),AddressBox.getText(),IDBox.getText(),UsernameBox.getText(),PasswordBox.getText());				
							if(!s.getStatus()) {
								Error error = new Error(frame,"fail");
								error.setVisible(true);
								System.exit(0);
							}
							Error error = new Error(frame,"success");
							error.setVisible(true);
							sr.setVisible(false);
						}

//					System.out.println(UsernameBox.getText()+" "+PasswordBox.getText());
					}
				});
				
				p1.add(fill1,cf1); 
				p1.add(UsernameBox,c1); 
				p1.add(Username,c2); 
				p1.add(PasswordBox,c3); 
				p1.add(Password,c4);
				p1.add(IDBox,c5); 
				p1.add(ID,c6);
				p1.add(NameBox,c7); 
				p1.add(Name,c8);
				p1.add(AddressBox,c9); 
				p1.add(Address,c10);
				p1.add(DegreeBox,c11); 
				p1.add(Degree,c12);
				p2.add(submit);
			}
			
			

			
			private class AccessListener implements ActionListener{
				
				public void actionPerformed(ActionEvent e) {
				}
				
				
				
			}






		}
		
		private class AdminRegister extends JDialog{

			private JTextField UsernameBox = null;
			private JTextField PasswordBox = null;
			private JTextField IDBox = null;
			private JTextField NameBox = null;
			private JTextField AddressBox = null;
			private JTextField FacultyBox = null;
			private Map<String,String> DataBase = null;
			private AdminRegister ad = null;
			private Container container = null;
			
			
			public AdminRegister(JFrame j) {
				super(j,"AdminRegister",true);
				this.ad = this;
				InitialFrame();
		        GridBagLayout gridBag = new GridBagLayout();   
				container.setLayout(new GridLayout(2,1));
				JPanel p1 = new JPanel(gridBag);
				JPanel p2 = new JPanel(new FlowLayout());
				Map<String,String> db = new HashMap<String,String>();
				DataBase = db;
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
				UsernameBox = new JTextField();
				UsernameBox.setColumns(10);
				GridBagConstraints c1 = new GridBagConstraints();
				GridBagConstraintsSetter(c1,4,1,70);

				JLabel Username = new JLabel("Username:");
				GridBagConstraints c2 = new GridBagConstraints();
				GridBagConstraintsSetter(c2,0,1,0);
				
				PasswordBox = new JTextField();
				PasswordBox.setColumns(10);
				GridBagConstraints c3 = new GridBagConstraints();
				GridBagConstraintsSetter(c3,4,2,70);

				JLabel Password = new JLabel("Password:");
				GridBagConstraints c4 = new GridBagConstraints();
				GridBagConstraintsSetter(c4,0,2,0);
				
				IDBox = new JTextField();
				IDBox.setColumns(10);
				GridBagConstraints c5 = new GridBagConstraints();
				GridBagConstraintsSetter(c5,4,3,70);

				JLabel ID = new JLabel("ID:");
				GridBagConstraints c6 = new GridBagConstraints();
				GridBagConstraintsSetter(c6,0,3,0);
				
				NameBox = new JTextField();
				NameBox.setColumns(10);
				GridBagConstraints c7 = new GridBagConstraints();
				GridBagConstraintsSetter(c7,4,4,70);

				JLabel Name = new JLabel("Name:");
				GridBagConstraints c8 = new GridBagConstraints();
				GridBagConstraintsSetter(c8,0,4,0);
				
				AddressBox = new JTextField();
				AddressBox.setColumns(10);
				GridBagConstraints c9 = new GridBagConstraints();
				GridBagConstraintsSetter(c9,4,5,70);

				JLabel Address = new JLabel("Address:");
				GridBagConstraints c10 = new GridBagConstraints();
				GridBagConstraintsSetter(c10,0,5,0);
				
				FacultyBox = new JTextField();
				FacultyBox.setColumns(10);
				GridBagConstraints c11 = new GridBagConstraints();
				GridBagConstraintsSetter(c11,4,6,70);
				
				JLabel Faculty = new JLabel("Faculty:");
				GridBagConstraints c12 = new GridBagConstraints();
				GridBagConstraintsSetter(c12,0,6,0);
				
				JLabel fill1 = new JLabel(" ");
				GridBagConstraints cf1 = new GridBagConstraints();
				GridBagConstraintsSetter(cf1,0,0,0);
				
				JButton submit = new JButton("Submit!");
				
				submit.addActionListener(new AccessListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						if(UsernameBox.getText().length()!=10) {
							Error error = new Error(frame,"valid username is 10 digits");
							error.setVisible(true);
							
						}else {
							Admin a = new Admin(FacultyBox.getText(),IDBox.getText(),UsernameBox.getText(),PasswordBox.getText(),Address.getText());
							if(!a.getStatus()) {
								Error error = new Error(frame,"fail");
								error.setVisible(true);
								System.exit(0);
							}
							Error error = new Error(frame,"success");
							error.setVisible(true);
							ad.setVisible(false);
						}

					}
				});
				
				p1.add(fill1,cf1); 
				p1.add(UsernameBox,c1); 
				p1.add(Username,c2); 
				p1.add(PasswordBox,c3); 
				p1.add(Password,c4);
				p1.add(IDBox,c5); 
				p1.add(ID,c6);
				p1.add(NameBox,c7); 
				p1.add(Name,c8);
				p1.add(AddressBox,c9); 
				p1.add(Address,c10);
				p1.add(FacultyBox,c11); 
				p1.add(Faculty,c12);
				p2.add(submit);
			}
			
			
			
			private class AccessListener implements ActionListener{
				
				public void actionPerformed(ActionEvent e) {
				}
				
				
				
			}






		}
	
	}
}
