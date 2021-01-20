
public class Frigate extends Battleship {
	
	public Frigate(int row) {
		
		super(row);
		
	}

	public void setSize(int row) {
		
		addParts(row, 3);
		
	}

}
