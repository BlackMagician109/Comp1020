public class Commercial extends Flight {
    //Instance Method
    public void book(Payload payload) throws InvalidBookingException{
        
        if((payload.getWeight() <= MAX_WEIGHT) && (payloadList.size() < MAX_PLAYLOAD) && (payload instanceof Person)){
            payloadList.add(payload);
        }
        else{
            throw new InvalidBookingException("Unable to add payload.");
        }
    }

    //toString metod for Commertial type of payload
    public String toString(){
        String toReturn = "";

        toReturn += "Commercial Flight [a number] has a payload of size of ";
        toReturn += super.payloadList.size();

        return toReturn;
    }
}
