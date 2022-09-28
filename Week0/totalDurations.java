/**
* Name of class or program totalDurations
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh
* ASSIGNMENT Exercise 0
* @author Shivam Sharma, 7885183
* @version 27-09-2022
*
* PURPOSE: This program calculates the total duration of each call.
*/
public class totalDurations {
    public static void totalDurations(String[] phoneNumbers, int[] callDurations, int size){
        String[] phoneNum = new String[size];
        int[] callLength = new int[size];
        int totalNumbers = 0;
  
        for(int i=0 ; i<size ; i++){
           int pos = find(phoneNum, totalNumbers, 0, phoneNumbers[i]);  //Returns position in the list or -1 if not found.
           if(pos == -1){   //Adds number to the list if not already present
              phoneNum[totalNumbers] = phoneNumbers[i];
              callLength[totalNumbers] = callDurations[i];
              totalNumbers++;
           }
           else{    //Adds to the duration of the call if the number was already present in the list.
              callLength[pos] += callDurations[i];
           }
        }
        printList(phoneNum, callLength, totalNumbers);  //Prints the final list.
     }
}
