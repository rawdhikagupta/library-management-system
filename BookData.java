package library_management_system;

public class BookData extends Catalog{
	public void add() {
		catalog_list.add(new Book(11011, "Organizational Psychology", "Steve M. Jex"));
		catalog_list.add(new Book(11012, "Introduction to Topology", "Bert Mendelson"));
		catalog_list.add(new Book(11013, "Applied Numerical Analysis", "Curtis Gerald"));
		catalog_list.add(new Book(11014, "Ordinary Differential Equation", "William Adkin"));
		catalog_list.add(new Book(11015, "Java: A Beginner's Guide", "Herbert Schildt"));
		catalog_list.add(new Book(11016, "Human Resource Management", "John Jackson"));
	}
	
}
