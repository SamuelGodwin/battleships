import java.util.ArrayList;
//import java.util.Arrays;

/**
 *
 *	'Battleship' class. This class contains definitions for 2 constructor methods 'Battleship' (one of which is used in my 'Board' class), as well as overridden methods 
 *	'equals' and 'toString'. There is also an accessor method 'getIsDestroyed' and a mutator method 'setIsDestroyed'. Additionally I have an 'isDestroyed' method, 
 *	which determines whether or not a ship is destroyed, based on the status of the parts from which it is made. Finally, this class contains a 'hit' method which is the
 *	basis of all attacks within my game of Battleship.
 *	This class is the superclass of my other classes 'Cruiser', 'Frigate' and 'Minesweeper'.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
public class Battleship {

	private ArrayList<Part> parts;
	private boolean isDestroyed;

	/**
	*	'Battleship' method. This is one of two constructor methods for objects of the 'Battleship' class. 
	*	The 'Battleship' class is the superclass of each of my other ship classes.
	*	This particular constructor is the constructor used by all subclasses.
	*/
	public Battleship(int row, int N){
		isDestroyed = false;
		
		parts = new ArrayList<Part>();
		for (int i = 0; i < N; i++) {
			parts.add(new Part(row, i));
		}
	}
	

	/**
	*	'Battleship' method. This is one of two constructor methods for objects of the 'Battleship' class, however takes only a single parameter 'row'.
	*	The 'Battleship' class is the superclass of each of my other ship classes.
	*	This particular constructor is used for, specifically, creating a ship of type 'Battleship'. This takes up exactly 5 columns.
	*/
	public Battleship(int row) {
		this(row, 5);
	}
	
	/**
	*	'Hit' method for 'Battleship'.
	*/
	public int hit(int row, int column){

		int result = 0;
		Part partSupplied = new Part(row, column);
		boolean partMatches = false;
		
		for (Part part : parts)  {			
			if (partSupplied.equals(part)) {
				partMatches = true;
				if (part.getIsDestroyed() == false){
					part.setIsDestroyed(true);
					result = 1;
				}
				else {
					result = 2;
				}
			}
		}

		if (partMatches == false){
			result = 3;
		}
		
		//	Calls 'isDestroyed' method - ensuring that if a ship has just been destroyed, its 'isDestroyed' field is updated to true.
		isDestroyed();
		
		return result;
	}
	
	/**
	*	'Equals' overriden method for 'Part'.
	*/
	public boolean equals(Object battleship) {
		if (!(battleship instanceof Battleship)) return false;
		
		else {
			if (isDestroyed() == ((Battleship)battleship).isDestroyed()) {
				return parts.size() == ((Battleship)battleship).parts.size();
			}
			else {
				return false;
			}
		}
	}
	
	/**
	*	'toString' method. Creates a default String representation for each of the items in 'parts' (as a collective).
	*/
	public String toString() {
		String output = "";
		for (int n = 0; n < parts.size(); n++){
			output  = output + parts.get(n) + ", ";
		}
		
		int toAdd = 5 - parts.size(); 
			
		for( int i = 0; i < toAdd; i++ ) {
            	
		output = output + "[ ], ";
                
		} 
		
		return output;
			
	}
	
	/**
	*	'isDestroyed' method for 'Battleship' - updated 'isDestroyed' field if a ship is destroyed - called within my 'hit' method.
	*/
	public boolean isDestroyed() {
		int destroyedParts = 0;
		for (Part part : parts) {
			if (part.getIsDestroyed() == true) {
				destroyedParts += 1;
			}
		}
		if (destroyedParts == parts.size()){
			setIsDestroyed(true);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	*	'setIsDestroyed' mutator method for 'Battleship'.
	*/
	public void setIsDestroyed(boolean isDestroyed){
		this.isDestroyed = isDestroyed;
	}

	/**
	*	'getIsDestroyed' accessor method for 'Battleship'.
	*/
	public boolean getIsDestroyed(){
		return isDestroyed;
	}
	
}