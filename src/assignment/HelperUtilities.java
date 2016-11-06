package assignment;


import java.util.ArrayList;

public class HelperUtilities {
	
	/*This class has been set up to populate the library with books. A set of ids, titles, authors etc are created and stored
	as individual arrays before being passed into the book constructor and forming a part of the ArrayList of Book objects
	appropriately named "books".*/
	
	private static int[] ids  = {
			0,1,2,3,4,5,6,7
	};
	
	private static String[] titles = {
			"Harry Potter and the Philosopher's Stone", "Harry Potter and the Chamber of Secrets", 
			"Harry Potter and the Prisoner of Askaban", "Harry Potter and the Goblet of Fire", 
			"Harry Potter and the Order of the Phoenix", "Harry Potter and the Half-Blood Prince", 
			"Harry Potter and the Deathly Hallows"
	};
	
	private static String[] authors = {
			"J.K. Rowling", "J.K. Rowling", "J.K. Rowling", "J.K. Rowling", "J.K. Rowling", "J.K. Rowling", 
			"J.K. Rowling", "J.K. Rowling", 
	};
	
	private static int[] quantities  = {
			3,3,3,3,3,3,3
	};
	
	private static int[] numsOnLoan  = {
			1,3,2,1,2,0,0
	};
	
	private static int[] numsTimesLoaned  = {
			0,0,1,1,1,2,3
	};
	
	public static ArrayList<Book> generateBooks()	{
		
		ArrayList<Book> books = new ArrayList<Book>();
		
		for(int i = 0; i<titles.length; i++){
			books.add(new Book (ids[i], titles[i], authors[i], quantities[i], numsOnLoan[i], numsTimesLoaned[i]));
		}
		return books;
		
	}

}
