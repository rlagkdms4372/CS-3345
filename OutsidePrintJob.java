import java.util.*;

public class OutsidePrintJob extends Printjob{

	OutsidePrintJob(String nname, int ppriority, int nnumPage) {
		// It is the subclass from the Printjob class
		// So, I used super
		super(nname, ppriority, nnumPage);
	}
	// Getting the cost for the outside print job
	public double getCost() {
		return super.getNumpage()*0.10;
	}
	// Printing out the result
	public String output() {
		String stringg = super.getName() + "	" + super.getPriority() + "	" + super.getNumpage() + "	" + this.getCost();
		return stringg;
	}
}
