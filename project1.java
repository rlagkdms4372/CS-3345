import java.util.*;
import java.util.NoSuchElementException;

// Making the Linked List with Generic(E)
public class LL <E> {
	private Node<E> head;
	private Node<E> tail;
	int size = 0;
	
	// add the node to the front to end
	public void addFront(E d) {
		// if head is null
		if(head == null) {
			head = new Node<E>(d, null);// input the d to the node
			tail = head;// When head is null, tail get head data.
		}else {
			// If head is not null, then head becomes new data 
			head = new Node<E>(d, head);
		}
		// increase the linked list size by 1
		size++;
	}
	
	public void addEnd(E d) {
		// if head is null
		if(head == null) {
			head = new Node<E>(d, null); // input the d to the node
			tail = head;// When head is null, tail get head data.
		}else {
			// Tail becomes new data
			tail.next = new Node<E>(d, null);
			// the tail becomes the last one
			tail = tail.next;
		}
		// increase the linked list size by 1
		size++;
	}
	public E removeFront(){
		E olddata;
		// When the head is null
		if(head == null) {
			throw new NoSuchElementException();// there's no such a data
			// if head equals to tail
		}else if(head == tail) {
			// the existed head data becomes old data
			olddata = head.data;
			// both of head and tail becomes null
			head = null;
			tail = null;
		}else {
			// the existed head data becomes old data
			olddata = head.data;
			// and the next head becomes head
			head = head.next;
		}
		// decrease the linked list size by 1
		size--;
		// returning the removed data
		return olddata;
	}
	
	// Removing the End Node
	public E removeEnd() {
		E olddata;
		// When the head is null
		if(head == null) {		
			throw new NoSuchElementException(); // there's no such a data
		// if head equals to tail
		}else if (head == tail) {
			// the existed head data becomes old data
			olddata = head.data;
			// both of head and tail becomes null
			head = null;
			tail = null;
		}else {
			// if head is unequal to taol
			Node<E> p = head;
			// until next head is not tail
			while(p.next != tail)
				p = p.next;
			// current tail data becomes old data
			olddata = tail.data;
			// there's no data after p because p is tail now
			p.next = null;
			// p becomes tail from now
			tail = p;
		}
		// decrease the linked list size by 1
		size--;
		// returning the removed data
		return olddata;
	}
	
	// The method is to set the element to the Linked List
	public void set(int i, E d) {
		// When the index i is not range of size 
		if(i < 0 || i > size-1) {
			// Then ArrayIndexOutOfBoundsException
			throw new ArrayIndexOutOfBoundsException("Index" + i + ": size " + size);
		}else {
			Node<E> p = head;
			//By using the for-loop, we can find the node for the index
			for(int k = 0; k < i; k++)
				p = p.next;
			// and change the element to d
			p.data = d;
		}
	}
	
	// The method is to get the element from the Linked List
	public E get(int i) {
		// When the index i is not range of size
		if(i < 0 || i > size-1) {
			// Then ArrayIndexOutOfBoundsException
			throw new ArrayIndexOutOfBoundsException("Index" + i + ": size " + size);
		}else {
			Node<E> p = head;
			//By using the for-loop, we can find the node for the index
			for(int k = 0; k < i; k++)
				p = p.next;
			// Print out the data
			return p.data;
		}
	}
	
	// The method is to swap the element each other
	public void swap(int i, int j) {
		// This is when the 'i' is bigger or less than the size of Linked List
				Node<E> p = head;
				Node<E> q = tail;
				// if the head is null or tail is also null
				if(p == null || q == null) {
					throw new NoSuchElementException();// then there is the NoSuchElementException error
				}else {
						// if i and j are not in the range of size, 
						if(i < 0 || i > size-1 || j < 0 || j > size - 1) {
								// then ArrayIndexOutOfBoundsException
								throw new ArrayIndexOutOfBoundsException("Index" + i + ": size " + size);
						}else {
							Node<E> a = head;
							Node<E> b = head;
		
							// To find the element of index i
							for(int k = 0; k < i; k++) {
								a = a.next;
							}
							// To find the element of index j 
							for(int k = 0; k < j; k++) {
								b = b.next;
							}
							// and swap those elements each other
							E r = b.data;
							b.data = a.data;
							a.data = r;
						}
				}
	}
	
// This shift method is that the element of list is moved as much as parameter
// if i is not in the size, when I'll put the ArrayIndexOutOfBoundsException
// else case I'll divide them into two (i > 0 or i < 0)
// When the i is positive, the I move the element from Front to the End as much as i.
// When the i is negative, the I move the element from End to the Front as much as i.
// To use for-loop and find the size of Linked List, I need to figure out the absolute number for the i
	public void shift(int i) {
		// This is when the 'i' is bigger or less than the size of Linked List
		Node<E> p = head;
		Node<E> q = tail;
		// if the head is null or tail is also null
		if(p == null || q == null) {
			throw new NoSuchElementException();// then there is the NoSuchElementException error
		}else {
			if(i > size || i < -size) {
				throw new ArrayIndexOutOfBoundsException("Index" + i + ": size " + size);
		// absolute number for i
			}else {
				int abs = Math.abs(i);
				// When i is bigger than 0
				if(i > 0) {
					for(int k = 0; k < i; k++) {
						E r = removeFront(); // I'll remove the element from the Front
						addEnd(r); // And put them to the End
					}
					// When i is less than 0
				}else if(i < 0) {
					for(int k = 0; k < abs; k++) {
						E r = removeEnd();// I'll remove the element from the End
						addFront(r);// And put them to the Front
					}
				}
			}
		}
		
	}
// This method is to remove the same element all through the linked list
	public void removeMatching(E value) {
		Node<E> p = head;
		Node<E> q = tail;
		// if the head is null or tail is also null
		if(p == null || q == null) {
			throw new NoSuchElementException();// then there is the NoSuchElementException error
		} else {
			// ssize is the size for the list
			// I can't use size because it reduces when I use removeFront() method
			int ssize = size;
			// by using for-loop, looking over the all the data
			for(int j = 0; j < ssize; j++) {
				// if the value to remove is same as the data
				if(value == p.data) {
					// remove the data from the first, and delete it by using null
					E r = removeFront();
					r = null;	
					// if the value to remove is not same as the data
				}else{
					// remove the data from the first, and put it at the end of Linked List
					E r = removeFront();
					addEnd(r);
				}
				p = p.next; // move to the next node
			}
		}
	}
	
//I'll erase the element from a as much as b
	public void erase(int a, int b) {
		// by using shift method, I'll move the element before 'a' to the end
		shift(a);
		// When using removeFront(), the linked list size will be reduced
		// So, storing the current linked list size by declaring ssize
		int ssize = size;
		Node<E> p = head;
		Node<E> q = tail;
		// if the head is null or tail is also null
		if(p == null || q == null) {
			throw new NoSuchElementException();// then there is the NoSuchElementException error
		} else {
		// When a is not in the range of size or, after the index a, the number of erasing element is greater than the number of rest index
			if(a > ssize-1 || a < 0 || (size-a) < b) {
			// then, ArrayIndexOutOfBoundsException applied
				throw new ArrayIndexOutOfBoundsException("Index" + a + ": size " + size);
			} else {
			// I'll remove the element from front as much as b
				for(int i = 0; i < b; i++) {
					E r = removeFront();
					r = null; // by using null
				}
				// Shift the rest of element from Linked List as order
				shift(ssize-b-a);
			}
		}
	}
	
	// This method is to put the insertList at the index 'a'
	public void insertList(LL<E> insertList, int a) {
		// At first, move the element before index a to the end
		shift(a);
		// This is size for the Linked list
		int ssize = size;
		// This is size for the inserList
		int sssize = insertList.size;
		Node<E> p = head;
		Node<E> q = tail;
		// if the head is null or tail is also null
		if(p == null || q == null) {
			throw new NoSuchElementException();// then there is the NoSuchElementException error
		}else {
		// When the a is less than 0 or bigger than the size of linked List, then it should have the exception
			if(a < 0 || a > ssize-1) {
				throw new ArrayIndexOutOfBoundsException("Index" + a + ": size " + size);
		// If 'a' is valid
			}else {
				Node<E> m = insertList.head;
			// after the shift(a), We need to insert the insertList to the end of Linked List
			// So, by using the removeFront() from inserList, the removed element is put to the end of Linked list as much as the size of insertList
				for(int i = 0; i < sssize; i++) {
					E r = insertList.removeFront();
					addEnd(r);
					m = m.next;	
				}
			// After all the inserList is put to the LinkedList, we move the rest of element from Linked list as order
				shift(ssize-a);
			}
		}
	}
	
	// This method is for the Node to set the Node
	private static class Node<E>{
		E data;
		Node<E> next;
		
		Node(E d, Node<E> n){
			data = d;
			next = n;
		}
	}
	
	// This toString() is essential because it makes us can see the the Linked List
	@Override
    public String toString()
    {
       StringBuilder sb = new StringBuilder("[ ");

       Node<E> p = head;
       while (p != null)
       {
          sb.append(p.data + " ");
          p = p.next;
       }

       sb.append("]");

       return new String(sb);
    }
	
	public static void main(String args[]) {
		
		LL example = new LL();
		LL insertList = new LL();
		
		System.out.println( "Linked List is emplty : " + example);
		
		example.addFront(5);
		example.addFront(4);
		example.addFront(3);
		example.addFront(2);
		example.addFront(1);	
		System.out.println("Inputting the elements from Front : " + example);
		
		example.addEnd(6);
		example.addEnd(7);
		example.addEnd(8);
		example.addEnd(9);
		System.out.println("Inputting the elements from End : " + example);
		
		example.addFront(0);
		example.addEnd(10);
		System.out.println("Adding the 0 at the front by using addFront method, and adding the 10 at the end : " + example);
		
		example.removeFront();
		example.removeEnd();
		System.out.println("Removing the 0 at the front by using removeFront method, and removing the 10 at the end : " + example);

		// We'll get the element from the index --> get() method
		System.out.println("Getting the element from index 3 : " + example.get(3));
		System.out.println("Getting the element from index 5 : " + example.get(5));
		System.out.println("Getting the element from index 7 : " + example.get(7));
		
		example.shift(4);
		System.out.println("Shift the Linked list as much as 4 : " + example);
		example.shift(-4);
		System.out.println("Shift the Linked list as much as -4 : " + example);
		example.shift(-2);
		System.out.println("Shift the Linked list as much as -2 : " + example);
		example.shift(2);
		System.out.println("Shift the Linked list as much as 2 : " + example);
		
		
		example.swap(0, 8);
		System.out.println("Swapping the element of 0 and 8 by using swap method : " + example);
		example.swap(1, 7);
		System.out.println("Swapping the element of 1 and 7 by using swap method : " + example);
		example.swap(2, 6);
		System.out.println("Swapping the element of 2 and 6 by using swap method : " + example);
		example.swap(3, 5);
		System.out.println("Swapping the element of 3 and 5 by using swap method : " + example);
		example.swap(8, 0);
		System.out.println("Swapping the element of 8 and 0 by using swap method : " + example);
		example.swap(7, 1);
		System.out.println("Swapping the element of 7 and 1 by using swap method : " + example);
		example.swap(6, 2);
		System.out.println("Swapping the element of 6 and 2 by using swap method : " + example);
		example.swap(5, 3);
		System.out.println("Swapping the element of 5 and 3 by using swap method : " + example);
		
		example.set(2, "A");
		System.out.println("Setting the element of 2 as A : " + example);
		example.set(4, "A");
		System.out.println("Setting the element of 4 as A : " + example);
		example.set(6, "A");
		System.out.println("Setting the element of 6 as A : " + example);
		
		example.removeMatching("A");
		System.out.println("Removing all the Node which have A as element :" + example);
		
		example.erase(2, 3);
		System.out.println("Removing Node from index 2 as much as 3 :" + example);
		
		insertList.addFront("C");
		insertList.addFront("B");
		insertList.addFront("A");
		System.out.println("Inputting the elements from Front(insert List) : " + insertList);
		insertList.addEnd("X");
		insertList.addEnd("Y");
		insertList.addEnd("Z");
		System.out.println("Inputting the elements from End(insert List) : " + insertList);
		
		example.insertList(insertList, 2);
		System.out.println("Adding the another list to the index 2 : " + example);
		

	
	}
	
}
