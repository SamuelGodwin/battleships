/**
 *
 *	'Frigate' class. This class is a subclass of my 'Battleship' superclass. It contains a constructor method within which the number of columns a Frigate fills in my 
 *	'Battleship' superclass constructor is always 3.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
public class Frigate extends Battleship {
	/**
	*	
	*/
	public Frigate(int row){
		//	We simply write super (with parameters) to call a constructor in the superclass.  
		super(row, 3);
	}

}