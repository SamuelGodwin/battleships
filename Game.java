import java.util.Scanner;

/**
 *
 *	'Game' class. This is the driver class for my PPA9 solution. It contains my 'main' method for a game of Battleship.
 *	This  class is the only class that is to be compiled and run directly, as the compiler will automatically compile my other referenced classes.
 *	This class and its method are public, so are accessible anywhere.	
 *
 */
public class Game {

 	/**
	*	'main' method. The main purpose of this method is to create objects of my classes and control the main flow of my program. 
	*	I also create an object 'in', which is a copy of the 'Scanner' class from Java's Class Library, for user input.	
	*/
	public static void main(String[] args){	
		Scanner in = new Scanner(System.in);
		
		Board board = new Board();

		String userInput="";

		do {
			board.getFrequencies();
			System.out.println(board.toString());	
			System.out.println("Enter a single row and column number on a single line, separated by a space. Enter 'exit' to exit.");

			userInput = in.next();
			//	Initialised to arbitrary numbers
			int row = -1;
			int column = -1;
			if (userInput.equals("exit")) {
				break;
			}

			row = Integer.parseInt(userInput);
			column = Integer.parseInt(in.next());
						
			if (board.hit(row, column) == true) {
				System.out.println("Hit! The hit was successful.");
			}	
			else {
				System.out.println("Miss! The hit was not successful.");
			}
		}
		while(!userInput.equals("exit"));
		
		//	Compiling this code gives a warning unless I call the close method on my Scanner instance.
		in.close();
	}
}