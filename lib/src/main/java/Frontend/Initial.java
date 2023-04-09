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
	

	// JFrame object for the main window
    private JFrame frame = null; 
    // Container object for the main window
	private Container container = null;
	// Singleton instance of the Initial class
	private static Initial instance; 
	// A DB object for database interactions
	private static DB db; 
	
	// Singleton instance method
	public static Initial getInstance() {
		if(instance == null) {
			instance = new Initial();
		}
		return instance;
	}
	
	private Initial() {
		// Gets the singleton instance of the DB class
		db=DB.getInstance(); 
		 // Sets the title of the main window
		frame = new JFrame("Initial");
		InitialFrame();
        GridBagLayout gridBag = new GridBagLayout(); 
        // Sets the layout of the main window
		container.setLayout(new GridLayout(2,1)); 
		// JPanel for the login button
		JPanel p1 = new JPanel(gridBag); 
		// JPanel for the register button
		JPanel p2 = new JPanel(new FlowLayout()); 
		// Creates and sets the components for the main window
		CreateAndSetComponent(p1,p2); 
		// Adds the login JPanel to the main window
		container.add(p1); 
		 // Adds the register JPanel to the main window
		container.add(p2);
		// Makes the main window visible
		frame.setVisible(true); 
	}
	
	// Method for creating and setting the components for the main window
       private void CreateAndSetComponent(JPanel p1, JPanel p2) {
    	// JButton for registering new users
		JButton register = new JButton("Register"); 
		
		// ActionListener for the register button
		register.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// Opens a new TypeSelector window for selecting user type
				new TypeSelector(frame); 
			}
		});
		// JButton for logging in
        JButton login = new JButton("Login"); 
		
		// ActionListener for the login button
		login.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// Opens a new Login window for logging in
				new Login(frame); 
			}
		});
		// Adds the login button to the login JPanel
		p1.add(login); 
		// Adds the register button to the register JPanel
		p2.add(register); 
	}
	

	
    // Method for initializing the main window
   	private void InitialFrame() {
   	 // Sets the size of the main window
   		frame.setSize(600, 400);
   	// Centers the main window on the screen
   		frame.setLocationRelativeTo(null);
   	// Gets the content pane of the main window
   		container = frame.getContentPane(); 
   	}
   	
   	// ActionListener for the login and register buttons
   	private class AccessListener implements ActionListener{
   		
   		public void actionPerformed(ActionEvent e) {
   			
   		}
   		
   	}
	private class Login extends JDialog{
		  private JTextField UsernameBox = null;
		    private JPasswordField PasswordBox = null;
		    private Login lg = null;
		    private Container container = null;

		    public Login(JFrame j) {
		        // Constructor for the Login class, takes in a JFrame as an argument
		        super(j, "Login", true);
		        // Calls the JDialog constructor with the parent JFrame, title, and modality set
		        this.lg = this;
		        // Sets the Login object to this instance
		        InitialFrame();
		        // Calls the InitialFrame() method to initialize the JFrame and container
		        GridBagLayout gridBag = new GridBagLayout();
		        // Creates a new GridBagLayout
		        container.setLayout(new GridLayout(2,1));
		        // Sets the layout of the container to a GridLayout with 2 rows and 1 column
		        JPanel p1 = new JPanel(gridBag);
		        // Creates a new JPanel with the GridBagLayout
		        JPanel p2 = new JPanel(new FlowLayout());
		        // Creates a new JPanel with the FlowLayout
		        Map<String,String> db = new HashMap<String,String>();
		        // Creates a new HashMap to store the database
		        CreateAndSetComponent(p1,p2);
		        // Calls the CreateAndSetComponent() method to create and set the components in the panels
		        container.add(p1);
		        container.add(p2);
		        // Adds the panels to the container
		        lg.setVisible(true);
		        // Makes the login dialog visible
		    }

		    private class Error extends JDialog {
		        // Private class for an error dialog that extends JDialog
		        public Error(JFrame j,String m) {
		            // Constructor for the Error class that takes in a JFrame and message as arguments
		            super(j,"result",true);
		            // Calls the JDialog constructor with the parent JFrame, title, and modality set
		            setSize(450,150);
		            // Sets the size of the dialog
		            setLocationRelativeTo(null);
		            // Centers the dialog on the screen
		            Container c = getContentPane();
		            // Gets the content pane of the dialog
		            c.setLayout(new FlowLayout());
		            // Sets the layout of the content pane to a FlowLayout
		            JLabel error = new JLabel(m);
		            // Creates a new JLabel with the message passed in
		            c.add(error);
		            
		        }
		    }

		    private void InitialFrame() {
		        // Private method to initialize the JFrame and container
		        lg.setSize(400, 150);
		        // Sets the size of the Login dialog
		        lg.setLocationRelativeTo(null);
		        // Centers the Login dialog on the screen
		        container = lg.getContentPane();
		        // Gets the content pane of the Login dialog
		    }

		    private void GridBagConstraintsSetter(GridBagConstraints c, int gridx, int gridy, int ipadx) {
		        // Private method to set the constraints for the GridBagLayout
		        c.gridx = gridx;
		        // Sets the x coordinate of the component
		        c.gridy = gridy;
		        // Sets the y coordinate of the component
		        c.ipadx = ipadx;
		        // Sets the internal padding of the component
		    }
		private void CreateAndSetComponent(JPanel p1, JPanel p2) {
			 // Create a JTextField for username input and set its number of columns to 10.
		    UsernameBox = new JTextField();
		    UsernameBox.setColumns(10);
		    // Create a new instance of GridBagConstraints and configure it for the username field.
		    GridBagConstraints c1 = new GridBagConstraints();
		    GridBagConstraintsSetter(c1,4,1,70);

		    // Create a JLabel for the "Username" text.
		    JLabel Username = new JLabel("Username:");
		    // Create a new instance of GridBagConstraints and configure it for the username label.
		    GridBagConstraints c2 = new GridBagConstraints();
		    GridBagConstraintsSetter(c2,0,1,0);

		    // Create a JPasswordField for password input and set its number of columns to 10.
		    PasswordBox = new JPasswordField();
		    PasswordBox.setColumns(10);
		    // Create a new instance of GridBagConstraints and configure it for the password field.
		    GridBagConstraints c3 = new GridBagConstraints();
		    GridBagConstraintsSetter(c3,4,2,70);

		    // Create a JLabel for the "Password" text.
		    JLabel Password = new JLabel("Password:");
		    // Create a new instance of GridBagConstraints and configure it for the password label.
		    GridBagConstraints c4 = new GridBagConstraints();
		    GridBagConstraintsSetter(c4,0,2,0);

		    // Create a blank JLabel to fill up some space in the layout.
		    JLabel fill1 = new JLabel(" ");
		    // Create a new instance of GridBagConstraints and configure it for the filler label.
		    GridBagConstraints cf1 = new GridBagConstraints();
		    GridBagConstraintsSetter(cf1,0,0,0);

		    // Create a JButton for submitting the login credentials.
		    JButton submit = new JButton("Submit!");
		    // Add an ActionListener to the button that checks the credentials and opens the appropriate UI.
		    submit.addActionListener(new AccessListener(){
		        @Override
		        public void actionPerformed(ActionEvent e){
		            // Check if the entered username is a student ID number (9 digits).
		            if(UsernameBox.getText().length()==9)
		            {
		                // If so, attempt to log in with the student database.
		                if(db.login(UsernameBox.getText(),new String(PasswordBox.getPassword()))) {
		                    // If successful, hide the login window and open the main UI for students.
		                    frame.setVisible(false);
		                    lg.setVisible(false);
		                    MainUI.getInstance(UsernameBox.getText(),new String(PasswordBox.getPassword()));
		                }else {
		                    // If unsuccessful, display an error message and exit the application.
		                    Error error = new Error(frame,"fail");
		                    error.setVisible(true);
		                    System.exit(0);
		                }
		            }
		            // Check if the entered username is an admin ID number (10 digits).
		            else if(UsernameBox.getText().length()==10) {
		                // If so, attempt to log in with the admin database.
		                if(db.adminLogin(UsernameBox.getText(),new String(PasswordBox.getPassword()))) {
		                    // If successful, hide the login window and open the main UI for admins.
		                    frame.setVisible(false);
		                    lg.setVisible(false);
		                    MainUIAdmin.getInstance();
		                }else {
		                    // If unsuccessful, display an error message and exit the application.
		                    Error error = new Error(frame,"fail");
		                    error.setVisible(true);
		                    System.exit(0);
		                }

		            }else {                
		                // If the username is neither a student nor an admin ID, display an error message.
		                Error error = new Error(frame,"incorrect username");
		                error.setVisible(true);
		            }
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
	// This class extends JDialog and creates a dialog box for selecting the type of user
	private class TypeSelector extends JDialog{

		
		// Variables for the container and the instance of the TypeSelector class
		private Container container = null;
		private TypeSelector ts = null;
		
		// Constructor for the TypeSelector class
		public TypeSelector(JFrame j) {
			// Calls the JDialog constructor with the specified parameters
			super(j,"TypeSelector",true);
			// Initializes the ts variable with this instance
			this.ts = this;
			// Calls the InitialFrame method to set the size and location of the dialog box
			InitialFrame();
			// Creates a GridBagLayout and sets the layout of the container to a 2x1 GridLayout
	        GridBagLayout gridBag = new GridBagLayout();   
			container.setLayout(new GridLayout(2,1));
			// Creates two JPanels and adds them to the container
			JPanel p1 = new JPanel(gridBag);
			JPanel p2 = new JPanel(new FlowLayout());
			CreateAndSetComponent(p1,p2);
			container.add(p1);
			container.add(p2);
			// Makes the dialog box visible
			ts.setVisible(true);
		}
		
		// Method for creating and setting the components in the dialog box
		private void CreateAndSetComponent(JPanel p1, JPanel p2) {
			// Creates a JButton for registering as a student and sets its ActionListener to create a new StudentRegister dialog box
			JButton register = new JButton("Student");
			register.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					new StudentRegister(frame);
				}
			});
			// Creates a JButton for logging in as an admin and sets its ActionListener to create a new AdminRegister dialog box
			JButton login = new JButton("Admin");
			login.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					new AdminRegister(frame);
				}
			});
			// Adds the login and register buttons to the JPanels
			p1.add(login); 
			p2.add(register);
		}
		
		// Method for initializing the size and location of the dialog box
		private void InitialFrame() {
			ts.setSize(500, 300);
			ts.setLocationRelativeTo(null);
			container = ts.getContentPane();
		}
		
		// ActionListener class for handling button clicks
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				
			}
		}
		// Define a private class named StudentRegister that extends JDialog
		private class StudentRegister extends JDialog{

			   // Define the variables to hold the input fields, database, and other objects
		    private JTextField UsernameBox = null;
		    private JTextField PasswordBox = null;
		    private JTextField IDBox = null;
		    private JTextField NameBox = null;
		    private JTextField AddressBox = null;
		    private JTextField DegreeBox = null;
		    private Map<String,String> DataBase = null;
		    private StudentRegister sr = null;
		    private Container container = null;

		    // Constructor for StudentRegister class
		    public StudentRegister(JFrame j) {
		        // Call the JDialog constructor with a title and modal flag
		        super(j,"StudentRegister",true);
		        // Set the current instance of the class to the sr variable
		        this.sr = this;
		        // Call the InitialFrame method to set the size and location of the dialog box
		        InitialFrame();
		        // Create a GridBagLayout for the input fields
		        GridBagLayout gridBag = new GridBagLayout();   
		        container.setLayout(new GridLayout(2,1));
		        // Create two JPanels, one for the input fields and one for the submit button
		        JPanel p1 = new JPanel(gridBag);
		        JPanel p2 = new JPanel(new FlowLayout());
		        // Create a HashMap to hold the student information and set it to the class variable
		        Map<String,String> db = new HashMap<String,String>();
		        DataBase = db;
		        // Call the CreateAndSetComponent method to create the input fields and add them to the dialog box
		        CreateAndSetComponent(p1,p2);
		        // Add the two JPanels to the dialog box
		        container.add(p1);
		        container.add(p2);
		        // Make the dialog box visible
		        sr.setVisible(true);
		    }

		    // Define a private class named Error that extends JDialog
		    private class Error extends JDialog {
		        // Constructor for the Error class
		        public Error(JFrame j,String m) {
		            // Call the JDialog constructor with a title and modal flag
		            super(j,"result",true);
		            // Set the size and location of the dialog box
		            setSize(450,150);
		            setLocationRelativeTo(null);
		            // Get the content pane of the dialog box
		            Container c = getContentPane();
		            // Set the layout of the content pane to FlowLayout
		            c.setLayout(new FlowLayout());
		            // Create a JLabel with the error message and add it to the content pane
		            JLabel error = new JLabel(m);
		            c.add(error);
		        }
		    }

		    // Define the InitialFrame method to set the size and location of the dialog box
		    private void InitialFrame() {
		        sr.setSize(400, 350);
		        sr.setLocationRelativeTo(null);
		        container = sr.getContentPane();
		    }

		    // Define a helper method to set the GridBagConstraints properties
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

			// These are the components used for the dialog box
			private JTextField UsernameBox = null;
			private JTextField PasswordBox = null;
			private JTextField IDBox = null;
			private JTextField NameBox = null;
			private JTextField AddressBox = null;
			private JTextField FacultyBox = null;
			private Map<String, String> DataBase = null; // A map for storing data
			private AdminRegister ad = null; // Reference to the dialog box
			private Container container = null;

			// Constructor for the dialog box
			public AdminRegister(JFrame j) {
				super(j, "AdminRegister", true);
				this.ad = this;
				// Initialize the dialog box
				InitialFrame(); 
				GridBagLayout gridBag = new GridBagLayout();
				 // Set the layout
				container.setLayout(new GridLayout(2, 1));
				JPanel p1 = new JPanel(gridBag);
				JPanel p2 = new JPanel(new FlowLayout());
				Map<String, String> db = new HashMap<String, String>();
				DataBase = db; 
				// Create and set the components
				CreateAndSetComponent(p1, p2); 
				// Add the components to the dialog box
				container.add(p1); 
				container.add(p2);
				// Show the dialog box
				ad.setVisible(true); 
			}

			// Class for displaying error messages
			private class Error extends JDialog {
				public Error(JFrame j, String m) {
					super(j, "result", true);
					setSize(450, 150);
					setLocationRelativeTo(null);
					Container c = getContentPane();
					c.setLayout(new FlowLayout());
					JLabel error = new JLabel(m);
					c.add(error);
				}
			}

			// Initialize the dialog box
			private void InitialFrame() {
				ad.setSize(400, 350);
				ad.setLocationRelativeTo(null);
				container = ad.getContentPane();
			}

			// Set the constraints for the grid layout
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
