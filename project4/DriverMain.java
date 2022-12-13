package maze;

import java.util.*;
public class DriverMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input the number of row of maze: ");
		int row = scanner.nextInt();
		while(row < 2 || row > 20) {
			System.out.println("This input is invalid, so please input the number from 2 to 20");
			System.out.print("Please input the number of row of maze: ");
			row = scanner.nextInt();
		}
		
		System.out.print("Please input the number of column of maze: ");
		int col = scanner.nextInt();
		while(col < 2 || col > 20) {
			System.out.println("This input is invalid, so please input the number from 2 to 20");
			System.out.print("Please input the number of col of maze: ");
			col = scanner.nextInt();
		}
		Maze maze = new Maze(row, col);
		System.out.println("The " + row + " by " + col + " maze: ");
		maze.print();
	}

}
