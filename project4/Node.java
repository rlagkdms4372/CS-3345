package maze;

public class Node {
	private int number;
	private boolean right;
	private boolean down;
	
	// Node has each boxes value and boolean value which indicates there are right wall and down wall
	Node(int nnumber, boolean rright, boolean ddown){
		number = nnumber;
		right = rright;
		down = ddown;
	}
	
	// set the number
	public void setNumber(int number) {
		this.number = number;
	} 
	// return the number
	public int getNumber() {
		return number;
	}
	// set the boolean value whether the right wall exists or not
	public void setRight(boolean right) {
		this.right = right;
	} 
	// return the existence of right wall
	public boolean getRight() {
		return right;
	}
	// set the boolean value whether the down wall exists or not
	public void setDown(boolean down) {
		this.down = down;
	} 
	// return the existence of down wall
	public boolean getDown() {
		return down;
	}
}
