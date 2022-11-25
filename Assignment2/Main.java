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
        
        if(tokens[0] == "CREATE-FLIGHT"){
            if(tokens[1] == "C"){
                air.addFlight('C');
            }
            else if(tokens[1] == "I"){
                air.addFlight('I');
            }
            else{
                throw new InvalidInputException("Flight Creation Command Incorrect");
            }
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
    }

    //
    public static void processComment(String data){
        System.out.println(data.split(" ", 2)[1]);
    }
}
