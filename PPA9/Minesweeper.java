//	Imports 'Random' (for 50% chance).
import java.util.Random;

/**
 *
 *	'Minesweeper' class. This class is a subclass of my 'Battleship' superclass. It contains a constructor method within which the number of columns a Minesweeper fills in my 
 *	'Battleship' superclass constructor is always 2.
 *	Also in this class is an overwritten 'hit' method which, contrary to 'hit' in 'Battleship', additionally determines (with a 50% chance) whether or not a risilient 
 *	minesweeper will actually take any damage from a hit.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
public class Minesweeper extends Battleship {

	/**
	*	'Minesweeper' method. This is a constructor method.
	*/
	public Minesweeper(int row){
		//	We simply write super (with parameters) to call a constructor in the superclass.  
		super(row, 2);
	}
		
	/**
	*	'Hit' method for 'Minesweeper'. This method involves the extra complication of only a 50% chance of a successful hit on a minesweeper.
	*/
	public int hit(int row, int column){
		Random rnd = new Random();		
		int result = 0;

		//	The extra line necessary that determines 50% whether the Minesweeper will be hit.
		if (rnd.nextInt(2) == 1) {
			//	Access original method 'hit' from 'Battleship' superclass.
			super.hit(row, column);
		}

		else {
			result = 3;
		}
		return result;
	}

}