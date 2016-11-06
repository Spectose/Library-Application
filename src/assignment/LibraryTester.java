package assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTester {
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//This generates creates an ArrayList named 'myBooks' using data from the HelperUtiliies Class.
		ArrayList<Book> myBooks = new ArrayList<Book>();
		myBooks = HelperUtilities.generateBooks();
		//This creates a new library object of type library
		Library mcClay = new Library("The McClay", myBooks);
		//The program's menu system. All methods are either stored or called upon here.
		boolean loop = true;
		while (loop)	{
		
		int userOption = printMenu(sc);
		switch(userOption)	{
		
		default: //You shouldn't see this unless you enter an option that is outside the range of 1-10
				System.out.println("Please enter a valid option");
				break;
		
		case 1:	//Add a Book
			int ID = myBooks.size();
			System.out.println("Enter a name");
			String title  = sc.nextLine();
			
			System.out.println("Enter an author");
			String author = sc.nextLine();
			
			System.out.println("Enter the quantity");
			while(!sc.hasNextInt()){
				System.out.println("Please enter an integer");
				sc.nextLine();
			}
			int quantity = sc.nextInt();
			
			System.out.println("Enter the number on loan");
			while(!sc.hasNextInt()){
				System.out.println("Please enter an integer");
				sc.nextLine();
			}
			int numOnLoan = sc.nextInt();
			System.out.println("Enter the number of times loaned");
			while(!sc.hasNextInt()){
				System.out.println("Please enter an integer");
				sc.nextLine();
			}
			int numTimesLoaned = sc.nextInt();
			mcClay.addBook(ID, title, author, quantity, numOnLoan, numTimesLoaned);
			
			
				break;
		
		case 2://Edit Book Method called from the Library Class
			mcClay.editBook3();
			/*System.out.println("Enter the book ID");
			while(sc.nextInt() >= myBooks.size())	{
				System.out.println("Please enter an ID inside the range (between 0 and " + (myBooks.size()-1) + ")");
				sc.nextLine();
			}
			ID = sc.nextInt();
			System.out.println("Enter a name");
			String newTitle  = sc.nextLine();
			System.out.println("Enter an author");
			String newAuthor = sc.nextLine();
			System.out.println("Enter the quantity");
			int newQuantity = sc.nextInt();
			System.out.println("Enter the number on loan");
			int newNumOnLoan = sc.nextInt();
			System.out.println("Enter the number of times loaned");
			int newNumTimesLoaned = sc.nextInt();
			mcClay.editBook(ID, newTitle, newAuthor, newQuantity, newNumOnLoan, newNumTimesLoaned);
			
			System.out.println(myBooks.get(ID).getID() + myBooks.get(ID).getTitle() + myBooks.get(ID).getAuthor());*/
				break;
		case 3: //Delete Book method
			System.out.println("Enter the book ID");
			while(sc.hasNextInt())	{//checks if ID entered against index values in arrayList otherwise loops back
				try{
					ID = sc.nextInt();
					System.out.println(myBooks.get(ID).getID());
					mcClay.deleteBook(ID);
					break;
				}catch(Exception e){
					System.out.println("Please enter an ID inside the range (between 0 and " + (myBooks.size()-1) + ")");	
				}
			}
			

		case 4://List all books
			System.out.println("Listing all books");
			for(int i=0; i<myBooks.size(); i++)	{//for loop to print the details of every book in the library
				mcClay.printBook(i);
			}
			break;	
		case 5:
			System.out.println("Enter the book you would like to loan");
			while(sc.hasNextInt())	{//similar implementation to that of case 3
				try{
					ID = sc.nextInt();
					mcClay.loanBook(ID);
					break;
				}catch(Exception e){
					System.out.println("Please enter an ID inside the range (between 0 and " + (myBooks.size()-1) + ")");	
				}
			}
			break;
			
		case 6://Returning a book()
			System.out.println("Enter the book you would like to return");
			while(sc.hasNextInt())	{//similar implementation to case 3 and case 5
				try{
					ID = sc.nextInt();
					mcClay.returnBook(ID);//calls returnBook() method from the Library Class
					break;
				}catch(Exception e){
					System.out.println("Please enter an ID inside the range (between 0 and " + (myBooks.size()-1) + ")");	
				}
			}
			break;
		case 7://Searching for a book
			System.out.println("Please enter your search query");
				String searchQuery = sc.nextLine();
				for(int i = 0; i<myBooks.size();i++ )	{
					if(myBooks.get(i).getTitle().contains(searchQuery))	{
						mcClay.printBook(i);
					}else{
						System.out.println("No matches found!");
					}
				}
			break;
		case 8://Organising books in ascending order
			System.out.println("Sortimg books by number of loans ascending...");
			mcClay.sortBooks();
			for(int i=myBooks.size()-1; i>=0; i--)	{
				mcClay.printBook(i);
				}
			break;
			
		case 9://Emptying the libray of all books
			System.out.println("You have chosen to clear the library");
			System.out.println("Are you sure you want to do this?");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("yes")){

			try {
			System.out.println("The library will clear in...");
			Thread.sleep(1000);
			System.out.println("3...");
			Thread.sleep(1000);
			System.out.println("2...");
			Thread.sleep(1000);
			System.out.println("1...");
			Thread.sleep(1000);
			System.out.println("Aaand it's gone.");
			mcClay.clearLibrary();
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
			}else{
				System.out.println("Operation cancelled");
				break;
			}
			break;
		case 10: //Exits the program
				System.out.println("Program Terminated");
				break;
	
		}
		if (userOption==10)	{
			loop = false;
			}
		}
			
	}
	
/*Print Menu Method: This displays the functions the user can select in the program, each number 
	corresponds to a case in the switch statement*/
	public static int printMenu(Scanner sc)	{
		System.out.println("+------------------------------------+");
		System.out.println("+Welcome to the McClay Library System+");
		System.out.println("+------------------------------------+");
		System.out.println("1: Add a new Book");
		System.out.println("2: Edit a Book's Details");
		System.out.println("3: Delete a Book");
		System.out.println("4: List all Books");
		System.out.println("5: Loan a Book");
		System.out.println("6: Return a Book");
		System.out.println("7: Search Library");
		System.out.println("8: Sort Library");
		System.out.println("9: Clear Library");
		System.out.println("10: Exit");
		int userOption = sc.nextInt();
		sc.nextLine();
		return userOption;
	}

}
