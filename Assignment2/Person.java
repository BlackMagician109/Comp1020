
public class Person extends Payload {
	//Instance Varibale
	protected String firstName;
	protected String lastName;

	//Consturctor
	public Person(double wgt, String firstName, String lastName) {
		super(wgt);
		id += 300000000;
		id += totalItems;
		totalItems++;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//Instance Methods

	//The standard toString
	public String toString(){
		return "ID: " + id + ", Weight:\t" + super.getWeight() + " kg, Name: " + this.firstName;
	}
}
