import java.lang.reflect.Array;
import javax.swing.*;

public class Auction extends Thread{

	/**
	 * @param args
	 */
	
	Bidder[] theBidder;
	Item anItem;
	int increment;
	int currentBidder;
	int currentBid;
	int numBidder;
	JTextArea anAuctionTextArea;
	AuctionSimulator anAuctionSimulator;
	// int highBidder;
	
	
	public Auction(	Bidder[] theBidder, 
					Item anItem, 
					int increment, 
					int tempBidder,
					AuctionSimulator anAuctionSimulator){
		this.theBidder = theBidder;
		this.anItem = anItem;
		this.increment = increment;
		this.numBidder = tempBidder;
		this.currentBid = anItem.getMinBid();
		this.currentBidder = 0;
		anAuctionTextArea = new JTextArea("\n\n Click 'Start the Bidding' to begin.");
		this.anAuctionSimulator = anAuctionSimulator;
	}
	
	// mutators
	public void setAnAuctionTextArea(String someText){
		this.anAuctionTextArea.setText(someText);
	}
	public void setCurrentBid(int temp){
		this.currentBid = temp;
	}
	public void setCurrentBidder(int temp){
		this.currentBidder = temp;
	}
	
	// accessors
	public JTextArea getAnAuctionTextArea(){
		return this.anAuctionTextArea;
	}
	public int getCurrentBid(){
		return this.currentBid;
	}
	public int getCurrentBidder(){
		return this.currentBidder;
	}
	public int getNumBidder(){
		return this.numBidder;
	}
	
	// methods
	public void getBid(){
		//System.out.println("Getting a bid.");
		if(currentBidder==numBidder){
			checkUserBidder(currentBid, currentBidder);
		}
		int aBid = (int)(Math.random() * Array.getLength(theBidder));
		checkBid(aBid);

	} // close getBid()
	
	public void checkBid(int aBid){
		//getting the bidder
		Bidder tempBidder = theBidder[aBid];
		//System.out.println(aBid);
		//theBidder[aBid].printBidder();
		
		// check it isn't the current bidder
		if (aBid == currentBidder){
			// do nothing
			System.out.println("Bidder " + aBid + " can't build against self.");
			printBid();
		} 
		// check bidder isn't overbidding, drop out if yes
		else if (currentBid + increment > tempBidder.getPrivateValuation()){
			System.out.println("Bidder " + aBid + " is dropping out.");
			printBid();
			tempBidder.dropOut();
		}
		// make sure bidder is not dropped out already, then go
		else if (tempBidder.isDroppedOut = true){
			//System.out.println("Found a valid bid.");
			currentBidder = aBid;
			currentBid = currentBid + increment;
			printBid();
			// check for a winner
			if (currentBid > anItem.getReservePrice()){
				
				// print to console
				System.out.println("And the winner is Bidder #" + aBid);
				
				// print to GUI
				this.anAuctionSimulator.setAnAuctionTextArea(	"\n Item: " + anItem.getItemName() +
																"\n Bidder: " + Integer.toString(currentBidder) +
																"\n Current Bid: $" + Integer.toString(currentBid) + ".00" +
																"\n\n And the winner is Bidder #" + Integer.toString(currentBidder));
				
				this.interrupt();
				//System.exit(0);
			}
		}else{
			System.out.println("Nothing happened.");
			System.out.println(currentBid);
		}
	} // close getBid()
	
	public int getNumberOfBidders(){
		return Array.getLength(theBidder);
	}
	
	public void checkUserBidder(int temp, int aBid){
		currentBidder = aBid;
		currentBid = temp;
		printBid();
		// check for a winner
		if (currentBid > anItem.getReservePrice()){
			
			// print to console
			System.out.println("And the winner is Bidder #" + aBid);
			
			// print to GUI
			this.anAuctionSimulator.setAnAuctionTextArea(	"\n Item: " + anItem.getItemName() +
															"\n Bidder: " + Integer.toString(currentBidder) +
															"\n Current Bid: $" + Integer.toString(currentBid) + ".00" +
															"\n\n And the winner is Bidder #" + Integer.toString(currentBidder));
			this.interrupt();
		}
	}
	
	
	public void printBid(){
		
		// printing to console
		System.out.println();
		System.out.println("Item: " + anItem.getItemName());
		System.out.println("Current Bidder: " + currentBidder);
		System.out.println("Current Bid: " + "$" + currentBid + ".00");
		System.out.println();
		
		// changing text area
		this.anAuctionTextArea.setText("We have bidding");
		this.anAuctionTextArea.repaint();
		this.anAuctionSimulator.setAnAuctionTextArea(	"\n Item: " + anItem.getItemName() +
														"\n Bidder: " + Integer.toString(currentBidder) +
														"\n Current Bid: $" + Integer.toString(currentBid) + ".00");
		
		//anAuctionTextArea.setText("ugh");
	}
	
	public void run(){
		try{
			while(true){
				sleep(1000);
				//sleep((int)(Math.random() * 1000));
				getBid();
//				System.out.println("doing something");
				//sleep((int)(Math.random() * 1000));
				sleep(1000);
			}
		}catch(Exception e){}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
