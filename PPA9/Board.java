//	Imports 'ArrayList'.
import java.util.ArrayList;
//	Imports 'Collections' class (for use of static method 'frequency').
import java.util.Collections;

/**
 *
 *	'Board' class. This class contains definitions for a constructor method 'Board' as well as an overridden method 'toString'. 
 *	It also contains a method to get the frequency of ships on the board, which is based on whether or not they have been destroyed yet.
 *	Finally, this class contains a 'hit' method which is the basis of all attacks within my game of Battleship. This method also accesses 'hit' from within 'Battleship' for extra functionality.
 *	This class acts as the board on which a game of Battleship is played.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
public class Board {

private ArrayList<Battleship> ships;

	public Board() {
		
		ships = new ArrayList<Battleship>();
		// parameter is the row the ship will be put on
		ships.add(new Battleship(0));
		ships.add(new Cruiser(1));	
		ships.add(new Cruiser(2));	
		ships.add(new Frigate(3));	
		ships.add(new Minesweeper(4));	
	}
	
	/**
	*	'getShips' method. This is the accessor method for ships from 'ships'.
	*/
	public Battleship getShips(int index){
		return ships.get(index);
	}

	/**
	*	'hit' method. This forms the basis for all attacks on a target from my main method within my game of Battleship. 
	*	This method also accesses 'hit' from within 'Battleship' for extra functionality if needed.
	*/
	public boolean hit(int row, int column){
		
		Part partSupplied = new Part(row, column);
		boolean partMatches = false;
		
		for (Battleship ship : ships)  {
			//	As can be seen in the 'hit' methods for a ship, if the result is not 3 then the hit was in fact on target.
			if (ship.hit(row, column) != 3) {
				partMatches = true;
				ship.hit(row, column);
			}
		}
		if (partMatches == true){
			//System.out.println("Hit! The hit was successfully on target).");
			return true;
		}
		else {
			//System.out.println("Miss! The hit was not successful.");
			return false;
		}
	}
	
	/**
	*	'toString' method. Creates a default String representation for each of the items in 'ships' (as a collective).
	*/
	public String toString(){
		String output = "";
		for (int n = 0; n < ships.size(); n++){
			output  = output + ships.get(n) + "\n";
		}
		return output;
	}
	
	/**
	*	'getFrequencies' method to get the frequency of each type of ship (not destroyed) on the game board. Uses static method 'frequency' from 'Collections' class in
	*	Java class library.
	*/
	public void getFrequencies() {

		Battleship battleship = new Battleship(0);
		Cruiser cruiser1 = new Cruiser(1);
		Cruiser cruiser2 = new Cruiser(2);
		Frigate frigate = new Frigate(3);
		Minesweeper minesweeper = new Minesweeper(4);
		
		int freqBattleship = Collections.frequency(ships, battleship);
		int freqCruiser = Collections.frequency(ships, cruiser1);
		int freqFrigate = Collections.frequency(ships, frigate);
		int freqMinesweeper = Collections.frequency(ships, minesweeper);
		
		System.out.println("Battleships: "+freqBattleship); 
		System.out.println("Cruisers: "+freqCruiser); 
		System.out.println("Frigates: "+freqFrigate); 
		System.out.println("Minesweepers: "+freqMinesweeper); 
		
	}
}