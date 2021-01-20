import java.util.ArrayList;

public class Battleship {
	
	private ArrayList<Part> parts;
	
	public Battleship(int row) {
		
		parts = new ArrayList<Part>();
		setSize(row);

	}
	
	public void setSize(int row) {
		
		addParts(row, 5);
		
	}
	
	public void addParts(int row, int size) {
		
		for ( int i = 0; i < size; i++ ) {
			
			parts.add(new Part(row, i));
		
		}
	
	}
	
	public boolean hit(int row, int column) {
		
		Part dummyPart = new Part(row, column);
		
		for ( Part part : parts ) {
			
			if ( part.equals(dummyPart) ) {
				
				part.setDestroyed();
				return true;
			
			}
			
		}
		
		return false;
		
	}
	
	private boolean isDestroyed() {
		
		for ( Part part : parts ) {
			
			if ( !part.isDestroyed() ) return false;
			
		}
		
		return true;
		
	}
	
	public boolean equals(Object otherShip) {
		
		if ( !(otherShip instanceof Battleship) ) return false;
		
		if ( isDestroyed() != ((Battleship)otherShip).isDestroyed() ) return false;
		
		return parts.size() == ((Battleship)otherShip).parts.size();
		
	}
	
	public String toString() {
		
		return parts.toString().substring(1, parts.toString().length() - 1);
		
	}

}
