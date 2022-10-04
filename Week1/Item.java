class Item {
    //Instance Variables
    private String name;
    private int size;
    private String code;
    private int quantity;
    private int reorderQuantity;
 
    public Item(String name, int size, String code, int quantity) {
       this.name = name;
       this.size = size;
       this.code = code;
       this.quantity = quantity;
       this.reorderQuantity = quantity/4;
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
       result += " reorder quantity=" + reorderQuantity;
 
       return result;
    }
 
    public Boolean mustReorder(){
       return quantity<reorderQuantity;
    }
 }

 public static void checkInventory(Item[] inventory){
    for(int i=0 ; i<inventory.length ; i++){
       if(inventory[i].mustReorder()){
          order(inventory[i], 200);
       }
    }
 }