package library_management_system;

//Java Program to Illustrate Student Class
//to take Input from the student and related Information

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class Student extends Thread implements StudentAccount {

	
	// Class member variables
	private String studentName;
	private String BITS_ID;
	private String password = "Bits_123";
	public int booksIssued;
	public Map<Book,String> booksIssuedByStudent = new HashMap<Book,String>();
	public int amountDue;
	
	Scanner input = new Scanner(System.in);

	public Student()
	{
		Thread t1 = new Thread();
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("Enter Student Name"); 
		studentName = input.nextLine(); 
		System.out.println("Enter Student Id"); 
		BITS_ID = input.nextLine(); 
		
	}
	// Constructor
	public Student(String name, String id, String pwd)
	{
		Thread t1 = new Thread();
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		studentName = name;
		BITS_ID = id;
		password = pwd; 
	}

	public String getStudentName() {
		return studentName;
	}

	public String getBITS_ID() {
		return BITS_ID;
	}

	public String getPassword() {
		return password;
	}
	public static void pause(String data, TimeUnit unit, long delay)
	        throws InterruptedException {
	    for (char ch:data.toCharArray()) {
	        System.out.print(ch);
	        unit.sleep(delay);
	    }
	    }
	public synchronized void issueBook(Book b, String date)
	{
		try {
			pause("ISSUING BOOK....",TimeUnit.MILLISECONDS, 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Catalog catalog = new Catalog(); 
		if(catalog.isAvailable(b.getId())==1 && booksIssued<3)
			{
			  booksIssuedByStudent.put(b,date);
			  booksIssued++;
			  catalog.upgradeBookQty(b.getId(), -1);
			  System.out.println("\n"+b.getBookName()+" by "+b.getAuthorName()+" Issued Successfully!");
			}
		else if(catalog.isAvailable(b.getId())==-1)
			{System.out.println(b.getBookName()+"Book ID doesn't match");
			System.out.println("-------------------------------------------------------------------------------------------------------");
			}
		else if(booksIssued>=3)
			{System.out.println("\nCant issue more than 3 books");
			System.out.println("-------------------------------------------------------------------------------------------------------");
			}
		
	}
	@Override
	public void checkDues(String date2) {
		
		try {
			pause("CALCULATING DUES....",TimeUnit.MILLISECONDS, 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int finalDue=0;
		for (Map.Entry<Book,String> entry : booksIssuedByStudent.entrySet()) {

			SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
			int daysKept = 0, fees=0;
			String s = entry.getValue();
			try {
			Date dateBefore = myFormat.parse(entry.getValue());
		       Date dateAfter = myFormat.parse(date2);
		       long difference = dateAfter.getTime() - dateBefore.getTime();
		       Float daysBetween = (float)(difference / (1000*60*60*24));
		       daysKept = daysBetween.intValue();
			}
			catch(Exception e){
				System.out.println("Please enter date in 'dd mm yyyy' format.");
			}
		       Book b = entry.getKey();
		       if(daysKept<=15) {
		    	   System.out.println("\nDue date to submit " +b.getBookName() +" is after " + (15-daysKept) + "days.");
		    	   fees += 0;
		       }
		       else {
		    	   fees += (daysKept - 15)*(b.duePrice);
		    	   System.out.println("\nBook: " +b.getBookName() +" was due "+(daysKept-15) + " days ago!");
		    	   System.out.println("Penalty: Rs. "+((daysKept - 15)*(b.duePrice))+".\nThis amount will directly be deducted from SWD account.");
		    	   System.out.println("Due date passed, RETURN or REISSUE book.");
		    	   
		       }
		       finalDue += fees;
		}
		amountDue = finalDue;
		if(amountDue != 0 ) {
		System.out.println("\nTotal Amount Due: Rs. "+amountDue);
		}
		else 
			System.out.println("No dues!"); 
		System.out.println("-------------------------------------------------------------------------------------------------------");

	}
	
	public void showBooksIssued()
	{
		System.out.println("\t\t\t\tBOOKS ISSUED BY STUDENT\n");
		for (Map.Entry<Book,String> entry : booksIssuedByStudent.entrySet())
		{
			System.out.println(entry.getKey());
		}
		System.out.println("-------------------------------------------------------------------------------------------------------");

	}
	@Override
	public synchronized void returnBook(Book b)
	{
		try {
			pause("RETURNING BOOK....",TimeUnit.MILLISECONDS, 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (Map.Entry<Book,String> entry : booksIssuedByStudent.entrySet())
		{
			if(entry.getKey().getId() == b.getId())
			{	booksIssuedByStudent.remove(entry.getKey());
				booksIssued--; 
				Catalog catalog = new Catalog();
				catalog.addBook(b);
				return;
			}
			
		}
		System.out.println("Enter Correct Book Details!");
		return;
		
	}
	
	
}
