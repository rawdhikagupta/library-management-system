package library_management_system;
import java.util.*;

public class Register extends Students{
	Scanner sc = new Scanner(System.in);
	
	public Register()
	{
		System.out.println("Enter Name");
		String name = sc.nextLine();
		System.out.println("Enter BITS ID");
		String id = sc.nextLine(); 
		System.out.println("Enter password");
		String pwd = sc.nextLine(); 
		System.out.println("Confirm password"); 
		String cpwd = sc.nextLine(); 
		if(pwd.equals(cpwd))
		{
			addStudent(new Student(name, id, pwd));
		}
		else 
			System.out.println("Password doesn't match, try again.");
	}
	public void add() {
		addStudent(new Student("Vansh Agrawal","2021A7PS2215P","vansh1"));
		addStudent(new Student("Radhika Gupta","2020A7PS0600P","radhika1"));
		addStudent(new Student("Stavya Puri","2020A7PS2000P","stavya1"));
		addStudent(new Student("Aditya","2020A7PS2201P","aditya1"));
		addStudent(new Student("Mithil","2020A7PS0055P","mithil1"));
	}

	
	@Override
	public void addStudent(Student s)
	{
		System.out.println("Registering new student");
		for(Student students: student_list) {
			if (students.getBITS_ID().equals(s.getBITS_ID()))
			{	System.out.println("Student already registered please login.");
				return;
			}}
		student_list.add(s); 	
		System.out.println("Student succesfully registered");
		
		}
		}
	

	
