import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class BinaryHeap<AnyType extends Comparable<?super AnyType>> {
	// The Author's code (Binary Heap)
	public BinaryHeap() {
		this(DEFAULT_CAPACITY);
	}
	
	public BinaryHeap(int capacity) {
		currentSize = 0;
		array = (AnyType[]) new Comparable[capacity + 1];
	}
	
	public BinaryHeap(AnyType[] items){
		currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2)* 11 / 10];
        int i = 1;
        for(AnyType item : items)
        	array[i++] = item;
        buildHeap();
    }
	
	public void insert(AnyType x){
        if(currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);
        int hole = ++currentSize;
        for(array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }
	
	private void enlargeArray(int newSize){
		AnyType[] old = array;
	    array = (AnyType[]) new Comparable[newSize];
	    for(int i = 0; i < old.length; i++)
	    	array[i] = old[i];        
	}
	
	public AnyType findMin(){
	        if(isEmpty())
	            throw new UnderflowException();
	        return array[1];
	}
	
	 public AnyType deleteMin(){
	        if(isEmpty())
	            throw new UnderflowException();

	        AnyType minItem = findMin();
	        array[1] = array[currentSize--];
	        percolateDown(1);

	        return minItem;
	 }
	 
	 private void buildHeap(){
	        for(int i = currentSize/2; i > 0; i--)
	            percolateDown(i);
	 }
	 
	 public boolean isEmpty(){
		 return currentSize == 0;
	 }
	 
	 public void makeEmpty(){
		 currentSize = 0;
	 }
	 
	 private static final int DEFAULT_CAPACITY = 10;
	 private int currentSize;      // Number of elements in heap
	 private AnyType[] array; // The heap array
	 
	 private void percolateDown(int hole){
		 int child;
	     AnyType tmp = array[hole];

	     for( ; hole * 2 <= currentSize; hole = child){
	    	 child = hole*2;
	         if(child != currentSize && array[child + 1].compareTo(array[child]) < 0)
	        	 child++;
	         if(array[child].compareTo(tmp) < 0 )
	        	 array[hole] = array[child];
	         else
	             break;
	         }
	     array[hole] = tmp;
	     }
	 // The Author code end!!!
}

public class Printer{	 
	
	public static void main(String[] args) throws FileNotFoundException {
		// Searching the file by using the address of input.txt
		File file = new File("C:\\Users\\haeun\\input.txt");
		// Readin the file by using the file
		Scanner ffile = new Scanner(file);
		// Making the binaryHeap which is binaryHeap and store by using the priority
		BinaryHeap<Printjob> binaryHeap = new BinaryHeap<>();
		
		//Reading the file until the end of file
		while(ffile.hasNextLine()) {
			// file's next element is the name
			String name = ffile.next();
			// file's next element is priority
			String ppriority = ffile.next();
			// changing priority to integer
			int priority = Integer.parseInt(ppriority);
			// file's next element is the number of page
			String nnumPage = ffile.next();
			// changing the number of page to integer
			int numPage = Integer.parseInt(nnumPage);
			// the file's next element is "I" or "O"
			String flag = ffile.next();
			
			// If inOrout is "I", it means the inside printer job
			if(flag.equals("I")) {
				// inside print job
				Printjob insideJob = new Printjob(name, priority, numPage);
				// Set the variables
				insideJob.setName(name);
				insideJob.setPriority(priority);
				insideJob.setNumpage(numPage);
				// be added to binary heap
				binaryHeap.insert(insideJob);
			}
			// If inOrout is not "I", which means "O", it means the outside printer job
			else {
				// outside print job
				OutsidePrintJob outsideJob= new OutsidePrintJob(name, priority, numPage);
				// Set the variables
				outsideJob.setName(name);
				outsideJob.setPriority(priority);
				outsideJob.setNumpage(numPage);
				// be added to binary heap
				binaryHeap.insert(outsideJob);
			}		
		}
		// until the binaryHeap becomes empty, delete the min(which is the priority)
		while(!binaryHeap.isEmpty()) {
	// Print out the user's name, user's priority, user's page (+ cost for Outside job)
			Printjob deleted = binaryHeap.deleteMin();
			System.out.println(deleted.output());
		}
	}
}

