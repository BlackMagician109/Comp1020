import java.util.ArrayList;

public abstract class Flight extends Item{
    //Instance Variable
    private static boolean takenOff;

    //Constructor
    public Flight(){
        super();
    }

    //Constants
    static final int MAX_WEIGHT = 200;
    static final int MAX_PLAYLOAD = 100;
    
    //Instance Variables
    ArrayList<Payload> payloadList = new ArrayList<Payload>(MAX_PLAYLOAD);

    //Instance Methods
    public void book(Payload payload) throws InvalidBookingException{
        
        if((payload.getWeight() <= MAX_WEIGHT) && (payloadList.size() < MAX_PLAYLOAD)){
            payloadList.add(payload);
        }
        else{
            throw new InvalidBookingException("Unable to add payload.");
        }
    }

    //A default to String method
    public String toString(){
        return "";
    }

    //
    public boolean canTakeoff(){
        if(!takenOff && payloadList.size()>=2 && hasEmp()){
            return true;
        }
        else{
            return false;
        }
    }

    //
    public String doTakeoff(){
        if(canTakeoff()){
            takenOff = true;
            return "Flight " + id + " takes off at the speed of light!";
        }
        else{
            return "Flight " + id + "can not take off";
        }
    }

    //Helper Method
    private boolean hasEmp(){
        for(int i=0 ; i<payloadList.size() ; i++){
            if(payloadList.get(i) instanceof Employee){
                return true;
            }
        }
        return false;
    }
}