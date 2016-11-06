package assignment;

public class Book {
	//Book instance variables
	private int ID;
	private String title;
	private String author;
	private int quantity;
	private int numOnLoan;
	private int numTimesLoaned;
	
	//Book constructor
	public Book(int iD, String title, String author, int quantity, int numOnLoan, int numTimesLoaned) {
		ID = iD;
		this.title = title;
		this.author = author;
		this.quantity = quantity;
		this.numOnLoan = numOnLoan;
		this.numTimesLoaned = numTimesLoaned;
	}
	//Getters and Setters for the Book Object
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNumOnLoan() {
		return numOnLoan;
	}

	public void setNumOnLoan(int numOnLoan) {
		this.numOnLoan = numOnLoan;
	}

	public int getNumTimesLoaned() {
		return numTimesLoaned;
	}

	public void setNumTimesLoaned(int numTimesLoaned) {
		this.numTimesLoaned = numTimesLoaned;
	}
	
	
	
	
	
	
}
