package assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Library {
	//Library instance variables
	private String name;
	private ArrayList<Book> myLibrary = new ArrayList<Book>();
	
	//Constructor for the Library Object
	public Library(String name, ArrayList<Book> myLibrary) {
		this.name = name;
		this.myLibrary = myLibrary;
	}
	//Add Book Method. This method adds a book to the library with the specifications detailed in the book constructor
	public void addBook(int ID, String title, String author, int quantity, int numOnLoan, int numTimesLoaned)	{
		Book newBook = new Book(ID, title, author, quantity, numOnLoan, numTimesLoaned);
		this.myLibrary.add(newBook);
	}
	
	static Scanner in = new Scanner(System.in);
	
	//Edit book Method. This edits the details of an existing book in the library

	public void editBook3()	{
		System.out.print("Please enter the book ID you wish to edit: ");
		int BookID = in.nextInt(); //user enters the id of the book they want to manipulate
		
		/* the for statement then cycles through all the values stored in the array list 
		 * then if there is a value in the array list that matches the users entry it moves onto the accessor methods
		 */
		for (int i = 0; i < myLibrary.size(); i++){ 
			if(BookID == myLibrary.get(i).getID()){
				System.out.println("Which part would you like to edit first 1)Title, 2)Author, "
						+ "3)Quantity, 4)Number on Loan, 5)Number of times Loaned "); //gives the user the variables in which they can edit
				int edit1 = in.nextInt(); //stores the next integer entered as edit1
				in.nextLine();//Assigns each option and integer value
				if (edit1 == 1){
					//if the user enters one then this runs the edit title
					System.out.println(myLibrary.get(i).getTitle());//displays the current book title
					System.out.println("Please enter new value: "); //prompts user for new value
					String newTitle = in.nextLine(); //stores the next text string under the variable newTitle
					myLibrary.get(i).setTitle(newTitle); //sets the title to the new value
					System.out.println("New title: " + myLibrary.get(i).getTitle());//prints of the new current value as confirmation
					
				} else if (edit1 == 2){
					//this runs if the user picks option 2
					System.out.println(myLibrary.get(i).getAuthor());//displays the current book author
					System.out.println("Please enter new value: ");//prompts user for new value
					String newAuthor = in.nextLine();//stores the next text string under the variable newAuthor
					myLibrary.get(i).setAuthor(newAuthor);//sets the author to the new value
					System.out.println("New author: " + myLibrary.get(i).getAuthor());//prints of the new current value as confirmation
					
				} else if (edit1 == 3){
					//this runs if the user picks option 3, this is only needed if someone made a mistake for this value and it needs fixed
					System.out.println(myLibrary.get(i).getQuantity());//displays the current quantity
					System.out.println("Please enter new value: ");//prompts user for new value
					int newQuantity = in.nextInt();//stores the next integer under the variable newQuantity
					myLibrary.get(i).setQuantity(newQuantity);//sets the quantity to the new value
					System.out.println("New number of times loaned: " + myLibrary.get(i).getNumTimesLoaned());//prints of the new current value as confirmation
				
				} else if (edit1 == 4){
					//this runs if the user picks option 4
					System.out.println("Current Number on Loan: " + myLibrary.get(i).getNumOnLoan());//displays the current number on loan
					System.out.println("Please enter new value: ");//prompts user for new value
					int newNumOnLoan = in.nextInt();//stores the next integer under the variable newNumOnLoan
					myLibrary.get(i).setQuantity(newNumOnLoan);//sets the number on loan to the new value
					System.out.println("New Number On Loan: " + myLibrary.get(i).getQuantity());//prints of the new current value as confirmation
				
				
				} else if (edit1 == 5){
					//this runs if the user picks option 5
					System.out.println("Current No. of Times Loaned: " + myLibrary.get(i).getNumTimesLoaned());//displays the current number of times loaned
					System.out.println("Please enter new value: ");//prompts user for new value
					int newNumTimesLoaned = in.nextInt();//stores the next integer under the variable newNumTimesLoaned
					myLibrary.get(i).setNumTimesLoaned(newNumTimesLoaned);//sets the number of times Loaned to the new value
					System.out.println("New number on Loan: " + myLibrary.get(i).getNumTimesLoaned());//prints of the new current value as confirmation
				}
				else{ //if the user tries to enter a value not presented in the menu options then the below error is displayed
					System.out.println("We are sorry but your choice is not part of the menu!");
				}
			}
		}
		
	}
	//Unused edit book method (couldn't get to work)
	public void editBook(int ID, String title, String author, int quantity, int numOnLoan, int numTimesLoaned)	{
			this.myLibrary.get(ID).setTitle(title);
			this.myLibrary.get(ID).setAuthor(author);
			this.myLibrary.get(ID).setQuantity(quantity);
			this.myLibrary.get(ID).setNumOnLoan(numOnLoan);
			this.myLibrary.get(ID).setNumTimesLoaned(numTimesLoaned);
	//The new details of the book are printed out below to confirm the details that the user has entered		
			System.out.println("The new details of this book are: " + "ID: " + this.myLibrary.get(ID).getID() + 
					"Title: " + this.myLibrary.get(ID).getTitle() + " Author: " + 
			this.myLibrary.get(ID).getAuthor() + " Quantity: " + this.myLibrary.get(ID).getQuantity() + " No. on Loan: " +
			this.myLibrary.get(ID).getNumOnLoan() + " No. of times loaned: " + this.myLibrary.get(ID).getNumTimesLoaned());
			

									}
	//unused delete book method (couldn't get to work)
	public void deleteBook2()	{
		System.out.print("Which book ID would you like to delete: ");
		int ID = in.nextInt();
		for (int i = 0; i <myLibrary.size(); i++){
					if(ID == myLibrary.get(i).getID()){
					System.out.print("Book details: " + myLibrary.get(i).getTitle() + 
							" by " + myLibrary.get(i).getAuthor());
					System.out.print("\nAre you sure you want to delete this book?(true/false): ");
					} else {
						System.out.println("Sorry but this book doesnt exist, please try again!");
						deleteBook2();
					}
					boolean deleteConfirm = in.nextBoolean();
					if (deleteConfirm == true){
						myLibrary.remove(i);
						System.out.println("Delete successful");
						break;
					} else {
						if (deleteConfirm == false){
						System.out.println("Delete cancelled!");
					  }
					 }	
				}
		}
		
	//Delete Book Method. This method removes a book based on its index position in the ArrayList.
	public void deleteBook(int ID)	{
		System.out.println("Book ID: " + myLibrary.get(ID).getID() + " " + myLibrary.get(ID).getTitle() + 
				" will be deleted");
		
		this.myLibrary.remove(ID);
		
	}
	
	//Print Book Method. This prints out the details of a book in the library based on its index. Can be a real time saver.
	public void printBook(int i)	{
		System.out.println("ID: " + this.myLibrary.get(i).getID());
		System.out.println("Title: " + this.myLibrary.get(i).getTitle());
		System.out.println("Author: " + this.myLibrary.get(i).getAuthor());
		System.out.println("Quantity: " + this.myLibrary.get(i).getQuantity());
		System.out.println("NumOnLoan: " + this.myLibrary.get(i).getNumOnLoan());
		System.out.println("NumTimesLoaned: " + this.myLibrary.get(i).getNumTimesLoaned());
	}
	//This empties the library of all books and reduces the size of the ArrayList to 0.
	public void emptyLibrary()	{
		System.out.println("The library will be emptied of all books");
		myLibrary.clear();
	}
	//This allows a user to loan a book by entering the index of the book they would like to loan
	public void loanBook(int i)	{
		int numOnLoan = myLibrary.get(i).getNumOnLoan();
	//An if statement ensures that a book can't be loaned unless there are sufficient copies in the library to do so
		if(myLibrary.get(i).getNumOnLoan() < myLibrary.get(i).getQuantity())	{
			numOnLoan++;
			myLibrary.get(i).setNumOnLoan(numOnLoan);
			System.out.println(myLibrary.get(i).getTitle() + " is now on loan");
	//Otherwise, the error message below is produced		
		}else{
			System.out.println("All copies of this book are already on loan.");
		}
		
		
	}
	//The Return Book Method: This allows a user to return a book by entering its index
	public void returnBook(int i)	{
		int numOnLoan = myLibrary.get(i).getNumOnLoan();
		int numTimesLoaned = myLibrary.get(i).getNumTimesLoaned();
		//An if statement ensures that at least one copy of the book is out on loan before it can be returned
	
		if(numOnLoan > 0)	{
			numOnLoan--;
			System.out.println(myLibrary.get(i).getTitle() + " has been returned.");
			numTimesLoaned++;
			myLibrary.get(i).setNumOnLoan(numOnLoan);
			myLibrary.get(i).setNumTimesLoaned(numTimesLoaned);
			//Otherwise, the following error message is printed		
		}else{
			System.out.println("No copies of this book were on loan.");
		}
	}
	//The Sort Book Method. This sorts the books by the number of times they have been loaned	
	public void sortBooks()	{
		myLibrary.sort(Comparator.comparing(Book::getNumTimesLoaned));
	}
	//Library getters and setters	
	public void clearLibrary()	{
		myLibrary.clear();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getBooks() {
		return myLibrary;
	}

	public void setBooks(ArrayList<Book> myLibrary) {
		this.myLibrary = myLibrary;
	}
	
	
	
	
	
}
