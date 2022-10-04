public class Activity1C {
   public static void main(String[] args) {
      Item[] inventory = new Item[4];

      inventory[0] = new Item("machine bolt", 50, "M50-H", 120);
      inventory[1] = new Item("phillips screw", 25, "P25-16", 750);
      inventory[2] = new Item("lock washer", 12, "W12-L", 400);
      inventory[3] = new Item("drywall screw", 38, "P38-DW", 2400);

      printInventory(inventory);

      sell(inventory[0], 90);
      sell(inventory[1], 750);
      sell(inventory[2], 600);
      sell(inventory[3], 2500);

      printInventory(inventory);

      order(inventory[0], 90);
      order(inventory[1], 1);
      order(inventory[2], 220);
      order(inventory[3], 50);
      order(inventory[3], -50);

      printInventory(inventory);

      System.out.println("\nEnd of processing.");
   }

   public static void sell(Item item, int amount) {
      int inStock;

      inStock = item.sell(amount);

      System.out.print("Selling " + amount + " of item: ");
      if (inStock == amount) {
         System.out.println("all are in stock.");
      } else {
         System.out.println(inStock + " in stock, " + (amount - inStock) + " on backorder.");
      }
   }
   
   public static void order(Item item, int amount) {
   	String reorder;

   	reorder = item.order(amount);

   	if (reorder == null) {
   		System.out.println("Unable to order item: invalid amount " + amount);
   	} else {
   		System.out.println(reorder);
   	}
   }

   public static void printInventory(Item[] inventory) {
      System.out.println("Inventory:");
      for (int i = 0; i < inventory.length; i++) {
         System.out.println(inventory[i]);
      }
   }
}

class Item {
   private String name;
   private int size;
   private String code;
   private int quantity;

   public Item(String name, int size, String code, int quantity) {
      this.name = name;
      this.size = size;
      this.code = code;
      this.quantity = quantity;
   }

   public String order(int amount) {
      String result = null;

      if (amount > 0) {
         result = "Re-order item: " + code + "\nAmount ordered: " + amount;
         quantity += amount;
      }

      return result;
   }

   public int sell(int amount) {
      int result = amount;

      if (amount < 0) {
         result = 0;
      } else {
         if (amount > quantity) {
            result = quantity;
         }
         quantity -= amount;
      }

      return result;
   }

   public String toString() {
      String result;

      result = "Item '" + name + "' size=" + size + "mm code='" + code;
      if (quantity >= 0) {
         result += " quantity=" + quantity;
      } else {
         result += " quantity=0 (" + -quantity + " backordered)";
      }

      return result;
   }
}
