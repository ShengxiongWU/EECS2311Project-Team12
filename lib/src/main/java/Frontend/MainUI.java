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

		
		JLabel CourseCode = new JLabel("Course Code:");
		JButton AddCourse = new JButton("Add Course");
		
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
		p1.add(CourseCode);
		p1.add(AddCourse); 
		p2.add(CourseCode);
		p2.add(DropCourse);
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
	

}
