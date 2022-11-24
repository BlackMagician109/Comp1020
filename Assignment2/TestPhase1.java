
public class TestPhase1 {
	public static void main(String [] args) {
		
		Airline airline = new Airline();
		// Parse a single comment
		System.out.println("Should be \"this is totally a comment!\"");
		Main.processComment("* this is totally a comment");
		
		System.out.println("Should be \"this is totally a comment\"");
		Main.processComment("*          this is totally a comment");
		
		System.out.println("Should be \"this is totally a comment\"");
		Main.processComment("* \t\t\tthis is totally a comment");
		
		try {
			// call a command that will never exist
			String[] command = new String[] {"Not", "A", "COMMAND"};
			Main.parseCommand(command, airline);
			System.out.println("Should not be here!");
		}
		catch (InvalidInputException reason) {
			// should be here!
			System.out.println("Should print the error message!");
			System.out.println(reason.getMessage());
		}
		
	}

}
