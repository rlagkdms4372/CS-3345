import java.util.*;
	// The generic Java class Names Pair with type parameter T
	public class Pair<T>{
		// There are two objects
		private T value1;
		private T value2;
		// set the first object
		public void setValue1(T v1){
		      value1 = v1;
		}
		// set the second object
		public void setValue2(T v2){
		      value2 = v2;
		}
		// return the First object (get method)
		public T getValue1(){
			return value1;
		}
		 // return the Second object (get method) 
		public T getValue2() {
			return value2;
	   }
		
	public static void main(String[] args) {
		Pair<String> pr = new Pair<>();
		pr.setValue1("Hello");
		pr.setValue2("World!");
		
		String value1 = pr.getValue1();
		System.out.println(value1);
		
		String value2 = pr.getValue2();
		System.out.println(value2);
		}
}

