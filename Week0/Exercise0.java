public class Exercise0 {
   public static void main(String[] args) {
      String[] phoneNumbers = new String[100];
      int[] callDurations = new int[phoneNumbers.length];
      int size = 0;

      size = addCall(phoneNumbers, callDurations, size, "555-555-5555", 137);
      size = addCall(phoneNumbers, callDurations, size, "555-555-5555", 12);
      size = addCall(phoneNumbers, callDurations, size, "555-555-1234", 26);
      size = addCall(phoneNumbers, callDurations, size, "555-555-9876", 382);

      System.out.println("Phone numbers (initially):");
      printList(phoneNumbers, callDurations, size);
      System.out.println("After");
      totalDurations(phoneNumbers, callDurations, size);

      System.out.println("\nEnd of processing.");
   }

   public static int addCall(String[] phoneNumbers, int[] callDurations, int size, String newNumber, int newDuration) {
      if (size >= phoneNumbers.length) {
         System.out.println("Error adding " + newNumber + ": array capacity exceeded.");
      } else {
         phoneNumbers[size] = newNumber;
         callDurations[size] = newDuration;
         size++;
      }

      return size;
   }

   public static void printList(String[] phoneNumbers, int[] callDurations, int size) {
      for (int i = 0; i < size; i++) {
         System.out.println(phoneNumbers[i] + " duration: " + callDurations[i] + "s");
      }
   }

   public static int find(String[] list, int size, int start, String target) {
      int pos = start;

      while (pos < size && !target.equals(list[pos])) {
         pos++;
      }

      if (pos == size)
         pos = -1;

      return pos;
   }

   public static void findAllCalls(String[] phoneNumbers, int[] callDurations, int size, String targetNumber) {
      int matchPos;

      System.out.println("Calls from " + targetNumber + ":");
      matchPos = find(phoneNumbers, size, 0, targetNumber);
      while (matchPos >= 0) {
         System.out.println(phoneNumbers[matchPos] + " duration: " + callDurations[matchPos] + "s");

         // Find the next match, starting after the last one
         matchPos = find(phoneNumbers, size, matchPos + 1, targetNumber);
      }
   }

   public static int removeCall(String[] phoneNumbers, int[] callDurations, int size, int posToRemove) {
      for (int i = posToRemove + 1; i < size; i++) {
         phoneNumbers[i - 1] = phoneNumbers[i];
         callDurations[i - 1] = callDurations[i];
      }
      size--;

      return size;
   }
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