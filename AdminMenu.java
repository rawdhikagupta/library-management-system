package library_management_system;
import java.util.*; 
public class AdminMenu {
	Scanner sc = new Scanner(System.in); 
	public AdminMenu()
	{
		String choice;
		String searchChoice; 
		Students s = new Students(); 
		Catalog catalog = new Catalog(); 
//Do-while loop to keep taking choice from the user till the choice is 0; 
	
		do {
			dispMenu(); 
			choice = sc.nextLine(); 
			switch(choice)
			{
				case "1":  
					s.showAllStudents();
					break; 
					
				case "2":  
					System.out.println("Press 1 to Add Student.");
		            System.out.println("Press 2 to Remove Student.");
		   
		                searchChoice = sc.nextLine();
		 
		                // Nested switch
		                switch (searchChoice) {
		                    // Case
		                case "1":
		                	Student student = new Student(); 
		                	s.addStudent(student);
		                    break;
		 
		                    // Case
		                case "2":
		                	Student student1 = new Student();
		                    s.removeStudent(student1);
		                    break;
		             
		                }
		              break;
		       case "3":
		    	   
		    	   catalog.showAllBooks();
		           break; 
		       
		       case "4":
		    	   
		    	   System.out.println("Enter the details of the book you want to add"); 
		    	   Book b1 = new Book(); 
		    	   catalog.addBook(b1);
		    	   break;
		    	   
		       case "5":
		    	   System.out.println("Enter the details of the book to be removed");
		    	   Book b2 = new Book(); 
		    	   catalog.removeBook(b2);
		    	   break; 
		        
		       case "6":
		    	   System.out.println("Enter book whose quantity you wanna upgrade"); 
		    	   Book b3 = new Book(); 
		    	   System.out.println("Enter new quantity"); 
		    	   int qty = sc.nextInt(); 
		    	   catalog.upgradeBookQty(b3.getId(), qty);
				   break; 
		       case "0":
		    	   System.out.println("Exiting Admin Mode"); 
		    	   break;  
		       default:
		    	   System.out.println("Enter choice between 0-6"); 
			}
		}while(!choice.equals("0")); 

	}
	public void dispMenu()
	{
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("Select from the following options"); 
		System.out.println("Press 1 to View Student Details");
		System.out.println("Press 2 to Edit Student Details");
		System.out.println("Press 3 to View Books");
		System.out.println("Press 4 to Add Book");
		System.out.println("Press 5 to Remove Book");
		System.out.println("Press 6 to Upgrade Quantity of a Book");
		System.out.println("Press 0 to Exit the Admin Mode"); 
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("Enter your choice");
	}

}
