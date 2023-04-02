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
		frame = new JFrame("MainUIAdmin");
		InitialFrame();

        GridBagLayout gridBag = new GridBagLayout();   
		container.setLayout(new GridLayout(6,6));
		JPanel p1 = new JPanel(gridBag);
		JPanel p2 = new JPanel(gridBag);
		JPanel p3 = new JPanel(gridBag);
		JPanel p4 = new JPanel(gridBag);
		JPanel p5 = new JPanel(gridBag);
		JPanel p6 = new JPanel(new FlowLayout());
		CreateAndSetComponent(p1,p2,p3,p4,p5,p6);
		container.add(p1);
		container.add(p2);
		container.add(p3);
		container.add(p4);
		container.add(p5);
		container.add(p6);
		frame.setVisible(true);
	}
	
	private void CreateAndSetComponent(JPanel p1, JPanel p2, JPanel p3,JPanel p4, JPanel p5, JPanel p6) {

		

		JButton CreateCourse = new JButton("Create Course");
		JButton AddEnrollment = new JButton("Add Enrollment");
		JButton UpdatedEnrollment = new JButton("Updated Enrollment");
		JButton AddRequiredCourse = new JButton("Add RequiredCourse");
		JButton RemoveRequiredCourse = new JButton("Remove RequiredCourse");
		JButton GetRequiredCourses = new JButton("Get RequiredCourses");
		
		
		CreateCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				CreateCourse c = new CreateCourse(frame);
//				c.setVisible(true);
			}
		});
		
		
		AddEnrollment.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				AddCourse ad = new AddCourse(frame,"inprogress","NA");
//				ad.setVisible(true);
			}
		});
		
		
		UpdatedEnrollment.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				UpdatedEnrollment ad = new UpdatedEnrollment(frame);
//				ad.setVisible(true);
			}
		});
		
		AddRequiredCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				AddRequiredCourse ad = new AddRequiredCourse(frame);
//				ad.setVisible(true);
			}
		});
		
		RemoveRequiredCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				RemoveRequiredCourse ad = new RemoveRequiredCourse(frame);
//				ad.setVisible(true);
			}
		});
		
		GetRequiredCourses.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				GetRequiredCourses ad = new GetRequiredCourses(frame);
//				ad.setVisible(true);
			}
		});
		

		p1.add(CreateCourse); 
		p2.add(AddEnrollment);
		p3.add(UpdatedEnrollment);
		p4.add(AddRequiredCourse);
		p5.add(RemoveRequiredCourse);
		p6.add(GetRequiredCourses);


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
	
	private class Result extends JDialog {
		public Result(JFrame j,String m) {
			super(j,"result",true);
			setSize(700,400);
			setLocationRelativeTo(null);
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			JTextArea error = new JTextArea(m);
			c.add(error);
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
					
				boolean f = DB.addCourse(CourseIDBox.getText(),CourseNameBox.getText(),CreditBox.getText(),PrequisitesBox.getText());
				
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
	
	private class AddCourse extends JDialog{

		private JTextField CourseIDBox = null;
		Vector<String> TermName = new Vector<String>();
		JComboBox<String> TermBox;
		private JTextField StudentIDBox = null;
		private AddCourse ad = null;
		private Container container = null;
		private String status;
		private String grade;
		
		
		public AddCourse(JFrame j,String status, String grade) {
			super(j,"AddEnrollment",true);
			this.ad = this;
			InitialFrame();
	        GridBagLayout gridBag = new GridBagLayout();   
			container.setLayout(new GridLayout(2,1));
			JPanel p1 = new JPanel(gridBag);
			JPanel p2 = new JPanel(new FlowLayout());

			CreateAndSetComponent(p1,p2);
			container.add(p1);
			container.add(p2);
			
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
			

			GridBagConstraints c3 = new GridBagConstraints();
			GridBagConstraintsSetter(c3,4,2,70);

			JLabel Term = new JLabel("Term:");
			GridBagConstraints c4 = new GridBagConstraints();
			GridBagConstraintsSetter(c4,0,2,0);
			
			StudentIDBox = new JTextField();
			StudentIDBox.setColumns(10);
			GridBagConstraints c5 = new GridBagConstraints();
			GridBagConstraintsSetter(c5,4,3,70);

			JLabel StudentID = new JLabel("Student ID:");
			GridBagConstraints c6 = new GridBagConstraints();
			GridBagConstraintsSetter(c6,0,3,0);
			
			TermName.add("FALL");
			TermName.add("WINTER");
			TermName.add("SUMMER");
			TermBox = new JComboBox<String>(TermName);
			TermBox.setSelectedItem("FALL");
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					boolean f = DB.addEnrollment(CourseIDBox.getText(),DB.getCourseInfo(CourseIDBox.getText()).get("name") , StudentIDBox.getText(), status, (String)TermBox.getSelectedItem(), grade);

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
			
			p1.add(StudentIDBox,c5); 
			p1.add(StudentID,c6);
			

			p2.add(submit);
		}
		
		
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			}
			
			
			
		}






	}

	private class AddRequiredCourse extends JDialog{

		private JTextField CourseIDBox = null;
		private JTextField DegreeBox = null;
		private JTextField StudentIDBox = null;
		private AddRequiredCourse ad = null;
		private Container container = null;
		private String status;
		private String grade;
		
		
		public AddRequiredCourse(JFrame j) {
			super(j,"AddRequiredCourse",true);
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
			
			DegreeBox = new JTextField();
			DegreeBox.setColumns(10);
			GridBagConstraints c3 = new GridBagConstraints();
			GridBagConstraintsSetter(c3,4,2,70);

			JLabel Term = new JLabel("Degree:");
			GridBagConstraints c4 = new GridBagConstraints();
			GridBagConstraintsSetter(c4,0,2,0);
			
			
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					boolean f = DB.addRequiredCourse(CourseIDBox.getText(),DegreeBox.getText());
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
			
			p1.add(DegreeBox,c3); 
			p1.add(Term,c4);
			
			

			p2.add(submit);
		}
		
		
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			}
			
			
			
		}






	}
	
	private class RemoveRequiredCourse extends JDialog{

		private JTextField CourseIDBox = null;
		private JTextField DegreeBox = null;
		private JTextField StudentIDBox = null;
		private RemoveRequiredCourse ad = null;
		private Container container = null;
		private String status;
		private String grade;
		
		
		public RemoveRequiredCourse(JFrame j) {
			super(j,"RemoveRequiredCourse",true);
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
			
			DegreeBox = new JTextField();
			DegreeBox.setColumns(10);
			GridBagConstraints c3 = new GridBagConstraints();
			GridBagConstraintsSetter(c3,4,2,70);

			JLabel Term = new JLabel("Degree:");
			GridBagConstraints c4 = new GridBagConstraints();
			GridBagConstraintsSetter(c4,0,2,0);
			
			
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					boolean f = DB.removeRequiredCourse(CourseIDBox.getText(),DegreeBox.getText());
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
			
			p1.add(DegreeBox,c3); 
			p1.add(Term,c4);
			
			

			p2.add(submit);
		}
		
		
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			}
			
			
			
		}






	}
	
	private class UpdatedEnrollment extends JDialog{

		private JTextField CourseIDBox = null;
		private JComboBox<String> StatusBox = null;
		private JTextField StudentIDBox = null;
		private JComboBox<String> GradeBox = null;
		private UpdatedEnrollment ad = null;
		private Container container = null;

		
		public UpdatedEnrollment(JFrame j) {
			super(j,"UpdatedEnrollment",true);
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
			
			StudentIDBox = new JTextField();
			StudentIDBox.setColumns(10);
			GridBagConstraints c3 = new GridBagConstraints();
			GridBagConstraintsSetter(c3,4,2,70);

			JLabel Term = new JLabel("StudentID:");
			GridBagConstraints c4 = new GridBagConstraints();
			GridBagConstraintsSetter(c4,0,2,0);
			
			Vector<String> StatusName = new Vector<String>();
			StatusName.add("In Progress");
			StatusName.add("Finished");
			
			StatusBox = new JComboBox<String>(StatusName);;

			GridBagConstraints c5 = new GridBagConstraints();
			GridBagConstraintsSetter(c5,4,3,70);

			JLabel Status = new JLabel("Status:");
			GridBagConstraints c6 = new GridBagConstraints();
			GridBagConstraintsSetter(c6,0,3,0);
			
			Vector<String> GradeName = new Vector<String>();
			GradeName.add("A+");
			GradeName.add("A");
			GradeName.add("B+");
			GradeName.add("B");
			GradeName.add("C+");
			GradeName.add("C");
			GradeName.add("D+");
			GradeName.add("D");
			GradeName.add("E");
			GradeName.add("F");
			GradeName.add("NA");
			GradeBox = new JComboBox<String>(GradeName);
			GridBagConstraints c7 = new GridBagConstraints();
			GridBagConstraintsSetter(c7,4,4,70);

			JLabel Grade = new JLabel("Grade:");
			GridBagConstraints c8 = new GridBagConstraints();
			GridBagConstraintsSetter(c8,0,4,0);
			
			
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					boolean f = DB.updateEnrollment(CourseIDBox.getText(),StudentIDBox.getText(),(String)StatusBox.getSelectedItem(),(String)GradeBox.getSelectedItem());;
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
			
			p1.add(StudentIDBox,c3); 
			p1.add(Term,c4);
			
			p1.add(StatusBox,c5); 
			p1.add(Status,c6);
			
			p1.add(GradeBox,c7); 
			p1.add(Grade,c8);
			
			
			

			p2.add(submit);
		}
		
		
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			}
			
			
			
		}






	}
	
	private class GetRequiredCourses extends JDialog{

		private JTextField DegreeBox = null;
		private GetRequiredCourses ad = null;
		private Container container = null;

		
		public GetRequiredCourses(JFrame j) {
			super(j,"GetRequiredCourses",true);
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
			DegreeBox = new JTextField();
			DegreeBox.setColumns(10);
			GridBagConstraints c1 = new GridBagConstraints();
			GridBagConstraintsSetter(c1,4,1,70);

			JLabel Degree = new JLabel("Degree:");
			GridBagConstraints c2 = new GridBagConstraints();
			GridBagConstraintsSetter(c2,0,1,0);
			
			
			
			JButton submit = new JButton("Submit!");
			
			submit.addActionListener(new AccessListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					ArrayList<HashMap<String, String>> result0 = DB.getRequiredCourses(DegreeBox.getText());
					String s = "";
					for(HashMap<String, String> result: result0 ) {
						s += "course_id: "+result.get("courseId")+"\n"+"Course_name: "+result.get("name")
						+ "\n" + "credit: " + result.get("credit") + "\n" +
						"prerequisites: "+result.get("prerequisites")+"\n\n";
					}

					Result s2 = new Result(frame, s);
					s2.setVisible(true);
				}
			});
			
			p1.add(DegreeBox,c1); 
			p1.add(Degree,c2); 
			

			
			
			

			p2.add(submit);
		}
		
		
		
		private class AccessListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			}
			
			
			
		}






	}
	

	




	

}
