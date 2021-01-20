import java.util.ArrayList;

public class Board {
	
	private ArrayList<Battleship> ships;
	
	public Board() {
		
		ships = new ArrayList<Battleship>();
		setupBoard();
		
	}
	
	private void setupBoard() {
		
		ships.add(new Battleship(0));
		ships.add(new Cruiser(1));
		ships.add(new Cruiser(2));
		ships.add(new Frigate(3));
		ships.add(new Minesweeper(4));
		
	}
	
	public ArrayList<Battleship> getShips() {
		
		return ships;
		
	}
	
	public boolean hit(int row, int column) {
		
		for ( Battleship ship : ships ) {
			
			if ( ship.hit(row, column) ) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public String toString() {
		
		String output = "";
		
		for ( Battleship ship : ships ) {
			
			output += ship;
			
			int size = 5;
			
			if ( ship instanceof Cruiser ) {
				
				size = 4;
				
			} else if ( ship instanceof Frigate ) {
				
				size = 3;
				
			} else if ( ship instanceof Minesweeper ) {
				
				size = 2;
				
			}
			
			for ( int i = size; i < 5; i++ ) {
				
				output += ", [ ]";
				
			}
			
			output += "\n";
			
		}
		
		return output;
		
	}

}
