package Frontend;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DB.DB;




public class MainUI extends JDialog{


	private JFrame frame = null;
	private Container container = null;
	private static DB db;
	private static String id;

	
	public static MainUI getInstance(String id) {

		return new MainUI(id);
	}
	
	private MainUI(String id) {
		this.id = id;
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
		JTextField CourseCodeText1 = new JTextField();
		JTextField CourseCodeText2 = new JTextField();
		CourseCodeText1.setColumns(10);
		CourseCodeText2.setColumns(10);
		JButton AddCourse = new JButton("Add Course");
		
		JButton GetPersonalInfo = new JButton("Get personal information");
		
		GetPersonalInfo.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ArrayList<String> result = DB.student_info(id);
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
				
			}
		});
		
		JButton DropCourse = new JButton("Drop Course");
		
		DropCourse.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
			}
		});
		p1.add(CourseCode1);
		p1.add(CourseCodeText1);
		p1.add(AddCourse); 

		p2.add(CourseCode2);
		p2.add(CourseCodeText2);
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

	

}
