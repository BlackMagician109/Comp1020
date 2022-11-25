
public class TestPhase4 {
	public static void main(String [] args) {
		
		Airline airline = new Airline();
		Main.readInputFile("TestPhase4.txt", airline);
		
		
		// test the methods, too
		Airline airline2 = new Airline();
		try {
			System.out.println("Should print Commercial Flight 100000003 has a payload size of 0");
			System.out.println(airline2.addFlight('C'));
			System.out.println("Should print Industrial Flight 200000004 has a payload size of 0");
			System.out.println(airline2.addFlight('I'));
		} catch (InvalidInputException e) {
			System.out.println("Should not run!");
		}
		
		System.out.println(airline2.getFlight(100000003));
		
		// should be null. Is a flight in the other airline
		System.out.println(airline2.getFlight(100000000));
		System.out.println("Should print Commercial Flight 100000000 has a payload size of 0");
		System.out.println(airline.getFlight(100000000));
		
	}

}
