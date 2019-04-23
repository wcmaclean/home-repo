
public class Bidder {

	/**
	 * @param args
	 */
	
	// instance variables
	int bidderNumber;
	int privateValuation;
	boolean isDroppedOut;
	
	// constructor
	public Bidder(int bidderNumber, int tempReserve){
		this.setBidderNumber(bidderNumber);
		this.setPrivateValuation(tempReserve);
		this.isDroppedOut = false;
	}
	
	// accessors
	public int getBidderNumber(){
		return this.bidderNumber;
	}
	public int getPrivateValuation(){
		return this.privateValuation;
	}
	public boolean checkIsDroppedOut(){
		return this.isDroppedOut;
	}
	
	// mutators
	public void setBidderNumber(int bidderNumber){
		this.bidderNumber = bidderNumber;
	}
	public void setPrivateValuation(int tempReserve){
		int plusOrMinus = (int)(Math.random() * 2);
		int numToAddOrSubtract = (int)(Math.random() * tempReserve);
		if (plusOrMinus==0)
			this.privateValuation = tempReserve - numToAddOrSubtract;
		else 
			this.privateValuation = tempReserve + numToAddOrSubtract;
	}
	public void dropOut(){
		this.isDroppedOut = true;
	}
	
	// methods
	public void printBidder(){
		System.out.println( "Bidder: " + this.getBidderNumber() + " " +
							"Maximum Bid: " + "$" + this.getPrivateValuation() + ".00" );
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
