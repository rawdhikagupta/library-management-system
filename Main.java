package library_management_system;

import java.util.Scanner;

public class Main {
	
	private static Scanner sc;

	public static void main(String[] args)
	{
		
		StudentData sd = new StudentData();
		sd.add();
		BookData bd = new BookData();
		bd.add();
		sc = new Scanner(System.in);
		
		System.out.println("WELCOME TO THE BITS LIBRARY PORTAL!--------------------------------------------------------------");
		System.out.println(
				"\nCreated By:\nRadhika Gupta \nAgrawal Vansh Anil\nStavya Puri\nAditya Holikatti\n");
		System.out.println(
			"Select From The Following Options:			 ");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		String choice;
		// Creating menu using do-while loop
		do {
//			register.add();
			System.out.println("Press 0 to Exit Application.");
		    System.out.println("Press 1 to Login.");
		    System.out.println("Press 2 to Register.");
		    System.out.println("Enter your choice");
		    choice = sc.nextLine();
			switch (choice) {
			case "1": 
				new Login(); 
				break; 
			case "2":
				new Register();
				
				Students s = new Students(); 
				s.showAllStudents();
				break;			
			case "0":
				System.out.println("Exiting Application"); 
				break; 
			default:
				System.out.println("Enter choice between 0-2");	
			}
		}while (!choice.equals("0")); 
		// Checking condition at last where we are checking case entered value is not zero
	}
}
