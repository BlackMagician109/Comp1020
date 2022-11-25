public class Industrial extends Flight {
    //Consturctor
    public Industrial(){
        super();
        id += 200000000;
        id += totalItems;
    }

    //Instance Method
    public void book(Payload payload) throws InvalidBookingException{
        
        if((payload.getWeight() <= MAX_WEIGHT) && (payloadList.size() < MAX_PLAYLOAD) && ((payload instanceof Cargo) || (payload instanceof Employee))){
            payloadList.add(payload);
        }
        else{
            throw new InvalidBookingException("Unable to add payload.");
        }
        
    }

    //toString metod for Commertial type of payload
    public String toString(){
        String toReturn = "";

        toReturn += "Industrial Flight " + id + " has a payload of size of ";
        toReturn += super.payloadList.size();

        return toReturn;
    }
}
