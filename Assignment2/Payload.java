public abstract class Payload extends Item {
	//Instance Variables
	private double wgt;
	public Payload(double wgt) {
		super();
		this.wgt = wgt;
	}

	public double getWeight(){
		return wgt;
	}
	
	//The standard toString
	public String toString(){
		return "ID: " + id + ", Weight:\t" + this.wgt + " kg";
	}
}
