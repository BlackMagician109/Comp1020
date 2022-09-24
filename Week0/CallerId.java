/**
 * Week0
 * Class Name: CallerId
 * @author Shivam Sharma
 * 
 * This Class will keep track of incoming phone numbers and 
 * additional details like when the call was made and how long
 * the call lasted. It will also keep a track of outgoing calls
 * as well.
 */
public class CallerId {
    public static void main(String[] args) {
        String[] phoneNumbers = new String[100];
        int size = 0;
        //Version 2 adding a Call Duration Function
        int[] callDurations = new int[phoneNumbers.length];



        size = addCall(phoneNumbers, callDurations, size, "555-555-5555", 137);
        size = addCall(phoneNumbers, callDurations, size, "555-555-1234", 26);
        size = addCall(phoneNumbers, callDurations, size, "555-555-9876", 382);

        System.out.println("Phone Numbers: ");
        printList(phoneNumbers, size, callDurations);

        //Adding another phone number
        phoneNumbers[size] = "555-555-0000";
        size++;

    }

    //Prints all the numbers in the list along with their call durations.
    public static void printList(String[] list, int size, int[] callDurations){
        for(int i=0; i<size; i++){
            System.out.println(list[i] + " durations: " + callDurations[i] + "s");
        }
    }

    //Adds a new number to the list along with the duration of the call.
    public static int addCall(String[] phoneNumbers, int[] callDurations, int size, String newNumber, int newDuration){
        if(size >= phoneNumbers.length){
            System.out.println("Error adding" + newNumber + ": aray capacity exceeded.");;
        }
        else{
            phoneNumbers[size] = newNumber;
            callDurations[size] = newDuration;
            size++;
        }
        return size;
    }
}
//End of Class CallerId