public class Cargo extends Payload {
	//Constructor
	public Cargo(double w) {
		super(w);
		id += 400000000;
		id += totalItems;
		totalItems++;
	}

}
