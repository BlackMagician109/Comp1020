/**
 * Week0
 * Class Name: CallList 
 * Written By: Shivam Sharma
 */
public class CallList {
    public static void main(String[] args) {
        String[] phoneNumbers = new String[100];
        int size = 0;

        //Initial set of phoneNumbers
        phoneNumbers[0] = "555-555-5555";
        phoneNumbers[1] = "555-555-1234";
        phoneNumbers[2] = "555-555-9876";
        size = 3;

        System.out.println("Phone Numbers (Initally): ");
        printList(phoneNumbers, size);

        //Adding another phone number
        phoneNumbers[size] = "555-555-0000";
        size++;

        System.out.println("Phone Numbers (After): ");
        printList(phoneNumbers, size);
    }
    public static void printList(String[] list, int size){
        for(int i=0; i<size; i++){
            System.out.println(list[i]);
        }
    }
}
//End of Class CallList