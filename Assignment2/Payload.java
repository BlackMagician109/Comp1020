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
	
	//Instance Methods

	//The standard toString
	public String toString(){
		return "ID: " + id + ", Weight:\t" + this.wgt + " kg";
	}

	//
	public static Payload payloadFactory(String payloadType, String weight, String firstname, String lastname, String job) throws InvalidInputException{
	
		if(canConvert(weight)){
			if(payloadType == "P"){
				Person newPerson = new Person(Double.parseDouble(weight), firstname, lastname);
				return newPerson;
			}
			else if(payloadType == "E"){
				Employee newEmployee = new Employee(Double.parseDouble(weight), firstname, lastname, job);
				return newEmployee;
			}
			else if(payloadType == "C"){
				Cargo newCargo = new Cargo(Double.parseDouble(weight));
				return newCargo;
			}
		}
		else{
			throw new InvalidInputException("Cannot convert Double");
		}
		return null;
	}

	//Helper Method
	private static boolean canConvert(String weight){
		try{
			Double.parseDouble(weight);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
}
