
public class Cruiser extends Battleship {

	public Cruiser(int row) {
		
		super(row);
		
	}
	
	public void setSize(int row) {
		
		addParts(row, 4);
		
	}
	
}
