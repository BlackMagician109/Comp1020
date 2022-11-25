
public class TestPhase2 {
	public static void main(String [] args) {
		
		Flight aCFlight = new Commercial();
		System.out.println("Should print Commercial Flight [a number] has a payload size of 0");
		System.out.println(aCFlight);
		
		Flight aFlight = new Industrial();
		
		try {
			aFlight.book(new Cargo(1));
		}
		catch (InvalidBookingException reason) {
			System.out.println("This should not run!!");
			System.out.println(reason.getMessage());
		}
		
		
		System.out.println("Should print Industrial Flight [a number] has a payload size of 1");
		System.out.println(aFlight);
		
		try {
			for (int i = 0; i < 99; i++)
				aFlight.book(new Cargo(1));
		}
		catch (InvalidBookingException reason) {
			System.out.println("This should not run!!");
			System.out.println(reason.getMessage());
		}
		
		System.out.println("Should print Industrial Flight [a number] has a payload size of 100");
		System.out.println(aFlight);
		
		try {
			aFlight.book(new Cargo(1));
			System.out.println("I should not run");
		}
		catch (InvalidBookingException reason) {
			System.out.println("I failed successfully! Should print that it is full.");
			System.out.println(reason);
		}
		
	}

}
