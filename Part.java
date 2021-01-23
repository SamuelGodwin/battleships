/**
 *
 *	'Part' class. This class contains definitions for a constructor method 'Part' as well as overridden methods 
 *	'equals' and 'toString', an accessor method 'getIsDestroyed' and a mutator method 'setIsDestroyed'.
 *	This class also contains integer fields 'row' and 'column' for a Part's location on my game board. My other field, 'isDestroyed', is of type boolean and holds whether 
 *	or not the part of a ship has been destroyed yet.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
 public class Part {

	private int row;
	
	private int column;
	
	private boolean isDestroyed;

	/**
	*
	*/
	public Part(int row, int column){
		this.row = row;
		this.column = column;
		isDestroyed = false;
	}

	/**
	*
	*/
	public void setIsDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	
	/**
	*
	*/
	public boolean getIsDestroyed(){
		return isDestroyed;
	}

	/**
	*	'Equals' overriden method for 'Part'.
	*/
	public boolean equals(Object part) {
		if (!(part instanceof Part)) return false;
		
		else {
			return row == ((Part)part).row && column == ((Part)part).column;
		}
		//return x == ((Coordinates)coordinates).x && y == ((Coordinates)coordinates).y;
	}
	
	/**
	*	'toString' method. Creates default String representation.
	*/
	public String toString(){
		if (isDestroyed == false) {
			return "[ ]";
		}
		else {
			return "[X]";
		}
	}
}