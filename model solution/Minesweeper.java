
public class Minesweeper extends Battleship {

	public Minesweeper(int row) {
		
		super(row);
		
	}

	public void setSize(int row) {
		
		addParts(row, 2);
		
	}
	
	public boolean hit(int row, int column) {
		
		int chance = (int)(Math.random() * 2);
		
		if ( chance == 0 ) {
			
			return super.hit(row, column);
			
		} else {
			
			return false;
			
		}
		
	}
	
}
