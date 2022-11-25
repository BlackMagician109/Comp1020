
public class Employee extends Person {
	//Static Variable
	private static int totalEmp = 0;

	//Instance Varibale
	private int empID = 000000000;
	private String job;

	//Constructor
	public Employee(double w, String firstName, String lastName, String job) {
		super(w, firstName, lastName);
		this.empID += 500000000;
		this.empID += totalEmp;
		totalEmp++;
		this.job = job;
	}

	//Instance Method
	public boolean hasJob(String isItThisJob){
		return this.job == isItThisJob;
	}
	
	//The standard toString
	public String toString(){
		return "ID: " + id + ", Weight:\t" + super.getWeight() + " kg, Name: " + firstName + ", EMP: " + this.empID + ", Job: " + this.job;
	}
}
