package library_management_system;
import java.util.*;
public class Login {
	Scanner sc = new Scanner(System.in);
	public Login()
	{ 
		System.out.println("Enter Name");
		String name = sc.nextLine();
		String id="";
		if(!name.equals("admin"))
		{
			System.out.println("Enter BITS ID");
			id = sc.nextLine(); 
		}
		System.out.println("Enter password");
		String pwd = sc.nextLine(); 
		
		Student student = new Student(name, id, pwd);
		Students s = new Students(); 
		
		//If the user is an admin then the system enters admin mode
		if(name.equals("admin") && pwd.equals("adminmode"))
		{
			System.out.println("Login Successful");
			System.out.println("You've entered the Admin Mode");
			AdminMenu menu = new AdminMenu();
			
		}
		else if(name.equals("admin") && !pwd.equals("adminmode"))
		{
//			System.out.println("Login failed");
			System.out.println("Incorrect Password, try again.");
//			AdminMenu menu = new AdminMenu();
			
		}
		//If the user is an existing student then the system enters student mode
		else if(s.doesStudentExist(student) && s.isPasswordCorrect(pwd,id))
		{
			System.out.println("Login succesfull");
			System.out.println("You've entered student mode");
			StudentMenu menu= new StudentMenu(student); 
		}
		else if(!s.doesStudentExist(new Student(name,id,pwd)))
			System.out.println("Student not found, please register");
		else if(!s.isPasswordCorrect(pwd,id))
		{
			System.out.println("Incorrect Password, try again."); 
		}
	
}}
