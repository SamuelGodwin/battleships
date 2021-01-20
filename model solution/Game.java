import java.util.Collections;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		Board board = new Board();
		
		Scanner in = new Scanner(System.in);
		
		String userInput;
		
		do {
			
			System.out.println("Battleships: " + Collections.frequency(board.getShips(), new Battleship(-1)));
			System.out.println("Cruisers: " + Collections.frequency(board.getShips(), new Cruiser(-1)));
			System.out.println("Frigates: " + Collections.frequency(board.getShips(), new Frigate(-1)));
			System.out.println("Minesweepers: " + Collections.frequency(board.getShips(), new Minesweeper(-1)));
			
			System.out.println(board);
			
			userInput = in.nextLine();
			
			if ( !userInput.equals("quit") ) {
				
				try {
					
					if ( board.hit(Integer.parseInt(userInput.substring(0, 1) + ""), Integer.parseInt(userInput.substring(2, 3) + "")) ) {
					
						System.out.println("Hit!");
					 
					} else {
					
						System.out.println("Miss!");
					
					}
				
				} catch (NumberFormatException e) {
					
					e.getMessage();
									e.printStackTrace();
					
				}
				
			}
			
		} while ( !userInput.equals("quit") );
		
		in.close();
		
	}
	
}
