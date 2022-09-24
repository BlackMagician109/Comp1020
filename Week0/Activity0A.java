public class Activity0A {
   public static void main(String[] args) {
      String[] phoneNumbers;           // declaration
      phoneNumbers = new String[100];  // instantiation
      int size = 0;

      phoneNumbers[0] = "555-555-5555";
      phoneNumbers[1] = "555-555-1234";
      phoneNumbers[2] = "555-555-9876";
      size = 3;

      System.out.println("Phone numbers (initially):");
      printList(phoneNumbers, size);

      phoneNumbers[size] = "555-555-0000";
      size++;

      System.out.println("\nPhone numbers (after):");
      printList(phoneNumbers, size);

      System.out.println("\nEnd of processing.");
   }

   public static void printList(String[] phoneNumbers, int size) {
      for (int i = 0; i < size; i++) {
         System.out.println(phoneNumbers[i]);
      }
   }
}