/**
 *
 *	'Cruiser' class. This class is a subclass of my 'Battleship' superclass. It contains a constructor method within which the number of columns a Cruiser fills in my 
 *	'Battleship' superclass constructor is always 4.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
public class Cruiser extends Battleship {
	/**
	*	'Cruiser' method. This is a constructor method.
	*/
	public Cruiser(int row){
		//	We simply write super (with parameters) to call a constructor in the superclass.  
		super(row, 4);
	}

}