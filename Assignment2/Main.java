import java.io.*;

public class Main {
    
    //Constant Variables
    static final String FILE_NAME = "TestPhase4.txt";

    //Main
    public static void main(String[] args) {
        Airline airline = new Airline();

        readInputFile(FILE_NAME, airline);
    }

    //Instance Mehtods
    public static void readInputFile(String fileName, Airline airline){
        BufferedReader inputFile;
        String line;
        String[][] data = new String[99][];
        int counter = 0;
        try{
            inputFile = new BufferedReader(new FileReader("textfile.txt"));

            line = inputFile.readLine();
            while(line != null){
                data[counter] = line.split(" ");

                try{
                    parseCommand(data[counter], airline);
                }
                catch(InvalidInputException iie){
                    System.out.println(iie.getMessage());
                }
                if(data[counter][0] == "*"){
                    try{
                        processComment(line);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }

                counter++;
                line = inputFile.readLine();
            }

            inputFile.close();
        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    //
    public static void parseCommand(String[] tokens, Airline air) throws InvalidInputException{
        
        if(tokens[0].equals("CREATE-FLIGHT")){
            air.addFlight(tokens[1].charAt(0));
        }
        else if(tokens[0] == "GET-FLIGHT"){
            Flight inFlight;
            inFlight = air.getFlight(Integer.parseInt(tokens[1]));
            if(inFlight == null){
                System.out.println("Flight " + tokens[1] + " not found");
            }
            else{
                System.out.println(inFlight);
            }
        }
        else if(tokens[0].equals("CREATE-PAYLOAD")){
            if(tokens.length == 6){
                Payload newPayload = Payload.payloadFactory(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                air.addPayload(newPayload);
            }
            else if(tokens.length == 5){
                Payload newPayload = Payload.payloadFactory(tokens[1], tokens[2], tokens[3], tokens[4], null);
                air.addPayload(newPayload);
            }
            else if(tokens.length == 3){
                Payload newPayload = Payload.payloadFactory(tokens[1], tokens[2], null, null, null);
                air.addPayload(newPayload);
            }
        }
        else if(tokens[0].equals("GET-PAYLOAD")){
            Flight inFlight;
            inFlight = air.getFlight(Integer.parseInt(tokens[1]));
            if(inFlight == null){
                System.out.println("Payload " + tokens[1] + " does not exist");
            }
            else{
                System.out.println(inFlight);
            }
        }
        else if(tokens[0].equals("ASSIGN-PAYLOAD")){
            Flight inFlight;
            inFlight = air.getFlight(Integer.parseInt(tokens[1]));
            Payload inPayload;
            inPayload = air.getPayload(Integer.parseInt(tokens[2]));
            if((inFlight == null) || (inPayload == null)){
                throw new InvalidInputException("Invalid Flight or Payload");
            }
            try{
                inFlight.book(inPayload);
            }
            catch(InvalidBookingException ibe){
                System.out.println(ibe.getMessage());
            }
        }
        else if(tokens[0].equals("TAKEOFF")){
            Flight flight;
            flight = air.getFlight(Integer.parseInt(tokens[1]));
            if(flight == null){
                throw new InvalidInputException("FlightId does not exist");
            }
            else{
                System.out.println(flight.doTakeoff());
            }
        }
        else{
            throw new InvalidInputException("Command not found");
        }
    }

    //
    public static void processComment(String data){
        System.out.println(data.split(" ", 2)[1]);
    }
}
