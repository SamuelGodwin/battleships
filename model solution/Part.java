
public class Part {

	private int row;
	private int column;
	private boolean destroyed;
	
	public Part(int row, int column) {
		
		this.row = row;
		this.column = column;
		
	}
	
	public boolean isDestroyed() {
		
		return destroyed;
		
	}
	
	public void setDestroyed() {
		
		destroyed = true;
		
	}
	
	public boolean equals(Object part) {
		
		if ( !(part instanceof Part) ) return false;
		
		return row == ((Part)part).row && column == ((Part)part).column;
		
	}
	
	public String toString() {
		
		if ( destroyed ) {
			
			return "[X]";
			
		} else {
			
			return "[ ]";
			
		}
		
	}
	
}
