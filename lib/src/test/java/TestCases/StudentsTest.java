package TestCases;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Backend.*;
import DB.DB;

public class StudentsTest {

	Students student;
	ArrayList<Student> Stud;
	DB db;

	@BeforeEach
	public void init() {
		student = Students.getInstance();
		Stud = student.getStudents();
		db = DB.getInstance();
	}

	
	@Test
	public void GetStudent() {
		String[] StudName = {"bruce","wu","dave"};
		String[] StudDeg = {"Software Engineering","Software Engineering","Software Engineering"};
		String[] StudAcc = {"123456789","123456781","123456782"};

		// this test cases are for the student class and checking the student name
		assertTrue(Stud.get(0).getName().equals(StudName[0]));
		assertTrue(Stud.get(1).getName().equals(StudName[1]));
		assertTrue(Stud.get(2).getName().equals(StudName[2]));

		// this test cases are for the student class and checking the student Degree
		assertTrue(Stud.get(0).getDegree().equals(StudDeg[0]));
		assertTrue(Stud.get(1).getDegree().equals(StudDeg[1]));
		assertTrue(Stud.get(2).getDegree().equals(StudDeg[2]));

		// this test cases are for the student class and checking the student Acc
		assertTrue(Stud.get(0).getAccount().equals(StudAcc[0]));
		assertTrue(Stud.get(1).getAccount().equals(StudAcc[1]));
		assertTrue(Stud.get(2).getAccount().equals(StudAcc[2]));

	}

}
