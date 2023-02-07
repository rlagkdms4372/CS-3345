import java.util.*;
public class question06 {
	//When the X(backward position) becomes less than Z(forward position), the number increase
	//When the X(backward position) becomes larger than Z(forward position), the number decrease
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		// Getting the any integer number 
		int n = input.nextInt();
		// X is for the length of output
		int x = 2*n + 1;
		// z is the number for position
		int z = 1;
		series(x, n, z);
	}
	// This class is for the recursion
	public static int series(int x, int n, int z) {
		// when the length of output is 0
		if(x == 0) {
			// finish the code
			return 1;
		// This case is for decreasing 
		}else if(x > z) {
			System.out.print(n + " ");
			return series(x-1, n-1, z+1);
			// This case is for increasing
		}else {
			System.out.print(n + " ");
			return series(x-1, n+1, z+1);
		}
	}

}
