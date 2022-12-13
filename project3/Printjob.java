import java.util.*;

// This is printJob which is comparing the priority and print the output
public class Printjob implements Comparable<Printjob>{
	private String name; // set the private variable name
	private int priority; // set the private variable priority
	private int numPage; // set the private variable the number of page
	private String flag;
	public int jobPriority; // this is the what I need to figure out
	
	// Constructing the Printjob class, which contains the name, priority, and the number of page
	Printjob(String nname, int ppriority, int nnumPage){
		name = nname;
		priority = ppriority;
		numPage = nnumPage;
	}
	
	// Set the name
	public void setName(String name) {
		this.name = name;
	}
	// return the set name
	public String getName() {
		return name;
	}
	// set the priority
	public void setPriority(int priority) {
		this.priority = priority;
	}
	// return the priority
	public int getPriority() {
		return priority;
	}
	// set the number of page
	public void setNumpage(int numPage) {
		this.numPage = numPage;
	}
	// return the number of page
	public int getNumpage() {
		return numPage;
	}

	// To figure out the job priority which priority and number of page
	public int jobPriority() {
		jobPriority = priority * numPage;
		return jobPriority;
	}
	// To print the String for inside print job, which contains name and priority and the number of page
	public String output() {
		String stringg = this.name + "	" + this.priority + "	" + this.numPage;
		return stringg;
	}
	// compareTo function to comparing the priority
	// Overriding from the comparable()
	// implement Comparable with compareTo based on job priority
	@Override
	public int compareTo(Printjob user2) {
		int jobPriority_1 = this.jobPriority();
		int jobPriority_2 = user2.jobPriority();
		if(jobPriority_1 == jobPriority_2) {
			return 0;
		}else if(jobPriority_1 > jobPriority_2) {
			return 1;
		}else
			return -1;
	}
	
}
