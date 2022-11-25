import java.io.*;

public class Main {
    
    //Constant Variables
    static final String FILE_NAME = "textfile.txt";

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

                try{
                    processComment(line);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
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
        if(tokens[0] == "*"){
            
        }
        throw new InvalidInputException("Command not found");
    }

    //
    public static void processComment(String data){
        System.out.println(data.split(" ", 2)[1]);
    }
}
