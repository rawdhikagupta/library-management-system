package library_management_system;

import java.util.ArrayList;
import java.io.*;

public class Students implements Serializable{
	protected static ArrayList<Student> student_list = new ArrayList<Student>(); 
//	student_list.add(new Student("Vansh Agrawal", "2021A7PS2215P", "vansh1"));
	public void addStudent(Student s)
	{
		for(Student students: student_list) {
		if (students.getBITS_ID().equals(s.getBITS_ID()))
			return;
		} 
	student_list.add(s); 	
	}
	
	
	public void removeStudent(Student s)
	{
		int c=0; 
		for(Student students: student_list) {
		if (students.getBITS_ID().equals(s.getBITS_ID()))
			{student_list.remove(students);
			c++;
			return;}
		} 
		if(c==0)
		{
			System.out.println("Student not found!");
		}
	
	}
	public void showAllStudents()
	{

		System.out.println("\t\t\t\tSHOWING ALL STUDENTS\n");
		System.out.println("S.No.\t\tID.No\t\t\tName\n");
        int sno=1;
		for (Student students: student_list) {

			System.out.println(
					sno+".\t\t"+
					students.getBITS_ID() + "\t\t"
					+ students.getStudentName() + "\t\t");
			sno++;
		}
		System.out.println("-------------------------------------------------------------------------------------------------------");

	}
	public boolean doesStudentExist(Student s)
	{
		for(Student students: student_list) {
			if (students.getBITS_ID().equals(s.getBITS_ID()))
				return true;
		}
		return false; 
	}
	public boolean isPasswordCorrect(String pwd,String id)
	{
		for(Student students: student_list) {
			if (students.getBITS_ID().equals(id))
			{if(pwd.equals(students.getPassword()))
				return true;
			else 
				return false; 
			}
		}
		return false;
		
	}
}
