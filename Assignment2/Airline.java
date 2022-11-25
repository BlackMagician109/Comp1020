import java.util.ArrayList;
public class Airline {
    //Instance Variables
    public ArrayList<Flight> flights = new ArrayList<Flight>();
    public ArrayList<Payload> payloads = new ArrayList<Payload>();
	
    //Instance Metods
    public String addFlight(char type) throws InvalidInputException{
        if(type == 'C'){
            Flight comFlight = new Commercial();
            flights.add(comFlight);
        }
        else if(type == 'I'){
            Flight indFlight = new Industrial();
            flights.add(indFlight);
        }
        else{
            throw new InvalidInputException("Flight Creation Command Incorrect");
        }
        return "";
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
}
