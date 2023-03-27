package library_management_system;
//Java Program to Illustrate Catalog class
//To do all the Operations related to Books such as
//add, issue, return, update 

//Importing required classes
import java.util.*;

public class Catalog {

	// Class data members
	protected static ArrayList<Book> catalog_list = new ArrayList<Book>(); 
	public static int count;
 
	Scanner input = new Scanner(System.in);

	// Method to compare books
	public int compareBookObjects(Book b1, Book b2)
	{

		// If book name matches
		if (b1.getBookName().equalsIgnoreCase(b2.getBookName())) {
			
			return 0;
		}

		// if book id number matches
		if (b1.getId() == b2.getId()) {


			return 0;
		}
		return 1;
	}

	// Method to add book
	public void addBook(Book b)
	{

		for(Book books: catalog_list) {
			if (this.compareBookObjects(b, books)== 0) 
				{
				books.bookQty ++;
				return;
				}
		}

		catalog_list.add(b);
		
		
		
	}
	public void removeBook(Book b)
	{
		int c=0;
		for(Book books: catalog_list) {
			if (this.compareBookObjects(b, books)== 0) {
				if(books.bookQty >= 0)
					catalog_list.remove(books);
				c++;
				System.out.println("Book removed successfully");
				return;
			}
			
			
		
		} 
		if(c==0) {
		 
				System.out.println("Book Not found!");
		}
		
		
	}
	

	// Method to search book by ISBN number
	public void searchByIDno()
	{

		System.out.println("SEARCH BY ID NUMBER\n");

		// Class data members
		int id;
		System.out.println("Enter the ID No. of Book:");
		id = input.nextInt();

		int flag = 0;
		System.out.println("ID.No\t\tName\t\t\t\t\tAuthor\t\t\t\tTotal Qty");

		for (Book books: catalog_list) {
			if (id == books.getId()) {
				System.out.println(
					books.getId() + "\t\t"
					+ books.getBookName() + "\t\t"
					+ books.getAuthorName() + "\t\t"
					+ books.bookQty);
				flag++;
				return;
			}
		}
		if (flag == 0)
			System.out.println("No Book for ID No "+ id + " Found.");
	}

	// Method 4
	// To search author by name
	public void searchByAuthorName()
	{

		
		System.out.println("SEARCH BY AUTHOR'S NAME");
		System.out.println("Enter Author Name:");
		String authorName = input.nextLine();

		int flag = 0;

		System.out.println("ID.No\t\tName\t\t\t\t\tAuthor\t\t\t\tTotal Qty");

		for (Book books: catalog_list) {

			// if author matches any of its book
			if (authorName.equalsIgnoreCase(
					books.getAuthorName())) {

				// Print below corresponding credentials
				System.out.println(
					books.getId() + "\t\t"
					+ books.getBookName() + "\t\t"
					+ books.getAuthorName() + "\t\t\t"
					+ books.bookQty);
				flag++;
			}
		}

		// If no book for the given author name exists
		if (flag == 0)
			System.out.println("No Books of" + authorName + " Found.");
	}
	public void searchByTitle()
	{

		
		System.out.println("SEARCH BY TITLE\n");
		System.out.println("Enter Book Title\n");
		String bookTitle = input.nextLine();

		int flag = 0;

		System.out.println("ID.No\t\tName\t\t\t\t\tAuthor\t\t\t\tTotal Qty");

		for (Book books: catalog_list) {

			// if author matches any of its book
			if (bookTitle.equalsIgnoreCase(
					books.getBookName())) {

				// Print below corresponding credentials
				System.out.println(
					books.getId() + "\t\t"
					+ books.getBookName() + "\t\t"
					+ books.getAuthorName() + "\t\t\t"
					+ books.bookQty);
				flag++;
			}
		}

		// If no book for the given author name exists
		if (flag == 0)
			System.out.println("No Books of" + bookTitle + " Found.");
	}

	// Method to display all books
	public void showAllBooks()
	{

		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("ID.No\t\tName\t\t\t\t\tAuthor\t\t\t\tTotal Qty");

		for (Book books: catalog_list) {

			System.out.println(
					books.getId() + "\t\t"
					+ books.getBookName() + "\t\t"
					+ books.getAuthorName() + "\t\t\t"
					+ books.bookQty);
		}
		System.out.println("-------------------------------------------------------------------------------------------------------");
	}

	// Method to update book quantity 
	public void upgradeBookQty(int id, int qty)
	{
		for (Book books: catalog_list) {

			if (id == books.getId()) {
				books.bookQty+= qty;
				System.out.println("\nBook qantity upgraded.");
				return;
			}
		}
		System.out.println("Book of the given ID no. not found!");
	}
	// Method to search whether the book is available
		public int isAvailable(int id)
		{
			for (Book books: catalog_list) {
				if (id == books.getId()) {
					if (books.bookQty > 0) {
						return 1;
					}
					else 
						System.out.println("Book Not Available!");
						return -1; 
					
				}
			}
			System.out.println("Book ID doesn't match"); 
			return -1;
		}
		
	}


