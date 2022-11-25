import java.util.ArrayList;
public class Airline {
    //Instance Variables
    public ArrayList<Flight> flights = new ArrayList<Flight>();
    public ArrayList<Payload> payloads = new ArrayList<Payload>();
	
    //Instance Metods
    public String addFlight(char type) throws InvalidInputException{
        String toReturn = "";
        if(type == 'C'){
            Flight comFlight = new Commercial();
            flights.add(comFlight);
            toReturn = comFlight.toString();
        }
        else if(type == 'I'){
            Flight indFlight = new Industrial();
            flights.add(indFlight);
            toReturn = indFlight.toString();
        }
        else{
            throw new InvalidInputException("Flight Creation Command Incorrect");
        }
        return toReturn;
    }

    //Returns flights with id number
    public Flight getFlight(int id){
        for(int i=0 ; i<flights.size() ; i++){
            if(flights.get(i).id == id){
                return flights.get(i);
            }
        }
        return null;
    }

    //
    public void addPayload(Payload thePayload){
        payloads.add(thePayload);
    }

    //
    public Payload getPayload(int id){
        for(int i=0 ; i<payloads.size() ; i++){
            if(payloads.get(i).id == id){
                return payloads.get(i);
            }    
        }
        return null;
    }
}
