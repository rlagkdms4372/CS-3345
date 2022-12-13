package maze;

import java.util.*;

public class Maze {
	
	// The initialize row and col in int data type
	private int col;
	private int row;
	
	// The initialize right and down in boolean data trpe
	private boolean right;
	private boolean down;
	
	DisjSets disjoint;
	Node[][] mazee;
	// Construct the Maze class
	
	public Maze(int rrow, int ccol) {
			row = rrow;
			col = ccol;
			mazee= new Node[row][col];
	}
	
	// The method to disjoint the sets to make the maze
	public void disj() {
		int number = 0;
		//The disjoint set has as much as the number of row*col
		disjoint = new DisjSets(row*col);
		// Initialize the mazee from Node class
		mazee = new Node[row][col];
		
		// Initializing the number of each boxes to make corresponding the the Disjoint set
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				mazee[i][j] = new Node(number, true, true);
				number++;
			}
		}	

		int total = row*col;
		
		
		while (disjoint.find(0) != disjoint.find(total - 1)){
			// Randomly choose the number of row and col
			int randomRow = (int)(Math.random() * row);
			int randomCol = (int)(Math.random() * col);
			
			// the number1 is the root number of number selected randomly
			int number1 = disjoint.find(mazee[randomRow][randomCol].getNumber());
			// the number2 will be the root number of number nearby number1 boxes(right or down)
			int number2 = 0;
			
			// The first condition when the row is the last one and the column is not the last one
			if((randomRow == row - 1) && (randomCol != col -1)) {
				// There is not the row anymore, the number 2 will be the right next box
				number2 = disjoint.find(mazee[randomRow][randomCol+1].getNumber());	
				// when the number 1 and number 2 are disjoint
				if(disjoint.find(number1)!=disjoint.find(number2)) {	
					// delete the right wall
					mazee[randomRow][randomCol].setRight(false);
					// union two sets
					disjoint.union(number1, number2);
				// when they are already in the same set
				}else
					// move to next one
					continue;
			
			// When the col is the last one and the row is not the last one
			}else if((randomCol == col - 1) && (randomRow != row -1)) {
				// There is not the column anymore, so the number2 will be the down boxes with is adjacent to current one
				number2 = disjoint.find(mazee[randomRow+1][randomCol].getNumber());
				// when the number 1 and number 2 are disjoint
				if(disjoint.find(number1)!=disjoint.find(number2)) {
					// delete the down wall
						mazee[randomRow][randomCol].setDown(false);
						// union two sets
						disjoint.union(number1, number2);
					// when they are already in the same set
					}else
						// move to next one
						continue;
			// When the selected number1 is the last boxes of the maze,
			}else if((randomRow == row - 1) && (randomCol == col-1)) {
				// there's nothing to do, so move to next one
				continue;
			
			// When the selected number1 is not on the last row and the last col
			}else {
				// when we need to decide which adjacent(right or down) box need to check
				int rrandom = (int)(Math.random() * 2);
				// If the random number is 1, we'll check the right side wall
				if(rrandom == 1) {
					//the number 2 will be the right next box
					number2 = disjoint.find(mazee[randomRow][randomCol+1].getNumber());
					// when the number 1 and number 2 are disjoint
					if(disjoint.find(number1)!=disjoint.find(number2)) {	
						// delete the right wall
						mazee[randomRow][randomCol].setRight(false);
						// union two sets
						disjoint.union(number1, number2);
					// when they are already in the same set
					}else
						// move to next one
						continue;
					// If the random number is 0, we'll check the down side wall
				}else {
					//the number 2 will be the down box
					number2 = disjoint.find(mazee[randomRow+1][randomCol].getNumber());
					// when the number 1 and number 2 are disjoint
					if(disjoint.find(number1)!=disjoint.find(number2)) {
						// delete the down wall
							mazee[randomRow][randomCol].setDown(false);
							// union two sets
							disjoint.union(number1, number2);
						// when they are already in the same set
						}else
							// move to next one
							continue;
				}
			}
		}
			
			
	}
	
	// This is to print the maze on the command-Line
	public void print() {
		// Operate the basic operations to make the maze
		disj();
		
		// The top of the maze
		System.out.print("  ");
		for(int i = 1; i < col; i++) {
			System.out.print(" _");
		}
		System.out.println();
		
		for(int k = 0; k < row; k++) {
			// The left side of the maze
			System.out.print("|");
			for(int j = 0; j < col; j++) {
				// When the down exists
				if(mazee[k][j].getDown()) {
					// input "_"
					System.out.print("_");
				// When the down does not exist
				}else
					System.out.print(" ");
				// When the right exists
				if(mazee[k][j].getRight()) {
					// The last boxes of the maze is empty
					if((j == col-1) && (k == row-1)) {
						System.out.print(" ");
					// If it is not the last boxes of the maze, input "|"
					}else
						System.out.print("|");
				// When the right doesn't exist
				}else
					System.out.print(" ");
			}
		 // To move to the next line
		  System.out.println();
		}
		
		
	
		
	}
}
	
	
	

