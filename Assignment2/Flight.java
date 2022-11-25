import java.util.ArrayList;;

abstract class Flight{
    //Constants
    static final int MAX_WEIGHT = 200;
    static final int MAX_PLAYLOAD = 100;
    
    //Instance Variables
    ArrayList<Payload> payloadList = new ArrayList<Payload>(MAX_PLAYLOAD);

    //Instance Methods
    public void book(Payload payload){
        try{
            if((payload.getWeight() <= MAX_WEIGHT) && (payloadList.size() < MAX_PLAYLOAD)){
                payloadList.add(payload);
            }
            else{
                throw new InvalidBookingException("Unable to add payload.");
            }
        }
        catch(InvalidBookingException ibe){
            System.out.println(ibe.getMessage());
        }
    }

    //A default to String method
    public String toString(){
        return "";
    }
}