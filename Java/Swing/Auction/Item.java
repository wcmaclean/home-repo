
public class Item {

	/**
	 * @param args
	 */
	
	// instance variables
	String itemName;
	int reservePrice;
	int minBid;
	
	// constructor
	public Item(int reservePrice, int minBid, String itemName){
		this.setReservePrice(reservePrice);
		this.setMinBid(minBid);
		this.setItemName(itemName);
	}
	
	// mutators
	public void setReservePrice(int reservePrice){
		this.reservePrice = reservePrice;
	}
	public void setMinBid(int minBid){
		this.minBid = minBid;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	
	// accessors
	public int getReservePrice(){
		return this.reservePrice;
	}
	public int getMinBid(){
		return this.minBid;
	}
	public String getItemName(){
		return this.itemName;
	}
	
	// methods
	public void printItem(){
		System.out.println("Item: " + this.getItemName());
		System.out.println("Starting Bid: " + "$" + this.getMinBid()  + ".00");
		System.out.println("Will Sell: " +  "$" + this.getReservePrice()  + ".00");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
