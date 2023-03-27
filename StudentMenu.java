package library_management_system;
import java.util.*;
public class StudentMenu extends Catalog{
	Scanner sc = new Scanner(System.in); 
	StudentMenu(Student s)
	{
		String choice;
		String searchChoice; 
//Do-while loop to keep taking choice from the user till the choice is 0; 
		do {
			dispMenu(); 
			choice = sc.nextLine(); 
			switch(choice)
			{
				case "1":  
					System.out.println("Press 1 to Search with ID No.");
		            System.out.println(" Press 2 to Search with Book's Author Name.");
		            System.out.println(" Press 3 to Search with Book's Name.");   
		                searchChoice = sc.nextLine();
		 
		                // Nested switch
		                switch (searchChoice) {
		                    // Case
		                case "1":
		                	searchByIDno();
		                    break;
		 
		                    // Case
		                case "2":
		                    searchByAuthorName();
		                    break;
		                case "3":
		                	searchByTitle(); 
		                	break; 
	
		                }
		                break;
		          
				case "2":
					showAllBooks(); 
					break;
					
				case "3":
					
					System.out.println("Enter issue date in dd mm yyyy");
					String date = sc.nextLine(); 
					System.out.println("Enter the details of the book you wanna issue"); 
					Book issue_book = new Book(); 
					s.issueBook(issue_book, date);
					break; 
					
				case "4":
					s.showBooksIssued();
					break; 
					
				case "5":
					s.showBooksIssued();
					System.out.println("Enter date of returning the book in dd mm yyyy");
					String d = sc.nextLine(); 
					s.checkDues(d);
					System.out.println("Enter the details of the book you wish to return"); 
					Book return_book = new Book(); 
					s.returnBook(return_book);
					break;
				
				case "6":
					System.out.println("Enter date of reissuing book in dd mm yyyy"); 
					String da = sc.nextLine();
					s.checkDues(da);
					System.out.println("Enter the details of the book you wanna reissue"); 
					Book reissue_book = new Book(); 
					s.returnBook(reissue_book);
					s.issueBook(reissue_book, da);
					break; 
				
				case "7":
					System.out.println("Enter date for checking dues in dd mm yyyy\n"); 
					String today_date = sc.nextLine();
					s.checkDues(today_date);
					break; 
				case "0":
					System.out.println("Exiting Student Mode");
					break;
				default:
					System.out.println("Please enter choice between 0-7"); 
					break; 
			}
	}while(!choice.equals("0")); 
}
	public void dispMenu()
	{
		
	    System.out.println("----------------------------------------------------------------------------------------------------------");
	    System.out.println("Press 0 to Exit Student Mode.");
	    System.out.println("Press 1 to Search a Book");
	    System.out.println("Press 2 to Show All Books.");
	    System.out.println("Press 3 to Issue Book. ");
	    System.out.println("Press 4 to Show all Issued Books. ");
	    System.out.println("Press 5 to Return Book");
	    System.out.println("Press 6 to Reissue Book");
	    System.out.println("Press 7 to View Dues");
	    System.out.println(
	        "-------------------------------------------------------------------------------------------------------");
	    System.out.println("Enter your choice");
	}
}
