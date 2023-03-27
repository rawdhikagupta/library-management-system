package library_management_system;
import java.util.*;
public class Book {
	 
    
	// Class fields
    private int id;
    private String bookName;
    private String authorName;
    public int bookQty=0;
    public static final int duePrice = 5;
  
    // Creating object of Scanner class to read input from users
    Scanner input = new Scanner(System.in);
 
    // Constructor to add Book details
  public Book()
    {
        System.out.println("Enter ISBN No. of Book:");
        id = input.nextInt();
        input.nextLine();
 
        System.out.println("Enter Book Name:");
        bookName = input.nextLine();
 
        System.out.println("Enter Author Name:");
        authorName = input.nextLine();
        bookQty =1; 
//        System.out.println("Enter Quantity of Books:");
//        bookQty = input.nextInt();
        
    } 
    
    public Book(int isbn, String name, String authorname) {
    	id = isbn; 
    	bookName = name; 
    	authorName = authorname; 
    	bookQty =1; 
		// TODO Auto-generated constructor stub
	}
    
	public String toString()
    {
    	return "Book Name: "+ this.bookName+
    	"\nAuthor Name: "+ this.authorName+
    	"\nID Number: "+ this.id+"\n";
    	
    }
//getter methods to allow access to private fields of this class
	public int getId() {
		return id;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthorName() {
		return authorName;
	}
	
}