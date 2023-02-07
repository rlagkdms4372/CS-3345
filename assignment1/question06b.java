import java.util.*;

public class question06b {
	public static void main(String[] args) {
		// Getting the number from user
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] array;
		// Declaring an array with size
		array = new int[size];
		// Inputting the number in array
		for(int i = 0; i < size; i++) {
			array[i] = input.nextInt();
		}
		int n = 0;
		// This total will count the number of odd number
		int total = oddNum(array, n, size);
		System.out.println(total);
	}
	public static int oddNum(int[] arr, int n, int size) {
		// n should be less than size to look over all the array number
		if( n < size) {
			// This is even number case
			if(arr[n] % 2 == 0) {
				return oddNum(arr, n+1, size);
			// This is odd number case
			}else
				// I'll make add '1'
				return oddNum(arr,  n+1, size) + 1;
		// When n is over the size, end the code
		}else {
			return 0;
		}
	}
}

