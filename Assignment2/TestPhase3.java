
public class TestPhase3 {
	public static void main(String [] args) {
		
		Flight aFlight = null;
		
		for (int i = 0; i < 3; i++) {
			aFlight = new Commercial();
			System.out.println(aFlight);
			aFlight = new Industrial();
			System.out.println(aFlight);
		}
		
		System.out.println("Should print 6");
		System.out.println(Item.getTotalNumberOfItems());
		
		System.out.println("Should print Industrial Flight 200000005 has a payload size of 0");
		System.out.println(aFlight);
		
	}

}
