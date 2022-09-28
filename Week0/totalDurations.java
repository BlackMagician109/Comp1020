public class totalDurations {
    public static void totalDurations(String[] phoneNumbers, int[] callDurations, int size){
        String[] phoneNum = new String[size];
        int[] callLength = new int[size];
        int totalNumbers = 0;
  
        for(int i=0 ; i<size ; i++){
           int pos = find(phoneNum, totalNumbers, 0, phoneNumbers[i]);
           if(pos == -1){
              phoneNum[totalNumbers] = phoneNumbers[i];
              callLength[totalNumbers] = callDurations[i];
              totalNumbers++;
           }
           else{
              callLength[pos] += callDurations[i];
           }
        }
        printList(phoneNum, callLength, totalNumbers);
     }
}
