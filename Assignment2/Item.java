public abstract class Item {
	protected int id = 000000000;
	protected static int totalItems = 0;
	
	public Item() {
	}
	
	//Instance Mehtods
	public static int getTotalNumberOfItems(){
		return totalItems;
	}

	//getId
	public int getId(){
		return id;
	}
}
