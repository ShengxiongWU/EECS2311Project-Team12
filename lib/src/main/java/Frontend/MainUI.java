package Frontend;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.DB;




public class MainUI extends JDialog{


	private JFrame frame = null;
	private Container container = null;
	private static MainUI instance;
	private static DB db;
	
	public static MainUI getInstance() {
		if(instance == null) {
			instance = new MainUI();
		}
		return instance;
	}
	
	private MainUI() {
		db=DB.getInstance();
		frame = new JFrame("MainUI");
		InitialFrame();

        GridBagLayout gridBag = new GridBagLayout();   
		container.setLayout(new GridLayout(3,3));
		JPanel p1 = new JPanel(gridBag);
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());
		CreateAndSetComponent(p1,p2,p3);
		container.add(p1);
		container.add(p2);
		container.add(p3);
		frame.setVisible(true);
	}
	
	private void CreateAndSetComponent(JPanel p1, JPanel p2, JPanel p3) {

		
		JLabel CourseCode1 = new JLabel("Course Code:");
		JLabel CourseCode2 = new JLabel("Course Code:");
		JTextField CourseCodeText1 = new JTextField();
		JTextField CourseCodeText2 = new JTextField();
		CourseCodeText1.setColumns(10);
		CourseCodeText2.setColumns(10);
		JButton AddCourse = new JButton("Add Course");
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
		
		p3.add(CheckCourse);

	}
	

	
	private void InitialFrame() {
		frame.setSize(1000, 800);
		frame.setLocationRelativeTo(null);
		container = frame.getContentPane();
	}
	
	private class AccessListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
		
		
		
	}
	public static void main(String[] args) {
		MainUI.getInstance();
	}
	

}
