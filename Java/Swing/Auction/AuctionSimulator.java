import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AuctionSimulator extends JFrame{

	/**
	 * 
	 * Run as:
	 * 
	 * >java AuctionSimulator 50 2000 100 10
	 * 
	 * Where:
	 *  50 - numBidders
	 *  2000 - reservePrice
	 *  100 - minBid
	 *  10 - increment
	 * 
	 * @param args
	 */
	
	Auction anAuction;
	static int increment;
	static Bidder[] theBidder;
	static Item anItem;
	JTextArea anAuctionTextArea;
	
	public AuctionSimulator(String[] args){
    	setSize(350, 175);
    	setTitle("Auction Simulator");	
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	// getting a warning asking for this
    	final long serialVersionUID = 0;
    	
    	//==========================
    	// create auction components
    	//==========================
	increment = Integer.parseInt(args[3]);
	
	// init item
	int tempReserve = Integer.parseInt(args[1]);
	int tempBid = Integer.parseInt(args[2]);
	anItem = new Item(
			tempReserve, 
			tempBid, 
			"The Greatest Thing EVER!!");
	anItem.printItem();
	
	// init an array of bidders
	int tempBidders = Integer.parseInt(args[0]);
	//Bidder[] theBidder = new Bidder[tempBidders];
	theBidder = new Bidder[tempBidders];
	for (int i = 0; i<tempBidders; i++){
		theBidder[i] = new Bidder(tempBidders, tempReserve);
		theBidder[i].printBidder();
	}
	Auction anAuction = new Auction(theBidder, anItem, increment, tempBidders, this);
		 

		
    	//===============
    	// GUI components
	//===============
    	Container contentPane = getContentPane();
    	contentPane.setVisible(true);
   	anAuctionTextArea = anAuction.getAnAuctionTextArea();
    	JPanel p = new JPanel();
    	p.setVisible(true);
    	   	
    	// create start button
    	JButton aStartButton = new JButton("Start the Bidding");
    	StartAction aStartAction = new StartAction(anAuction);
    	aStartButton.addActionListener(aStartAction);
    	p.add(aStartButton);
    	
    	// create bid button
    	JButton aBidButton = new JButton("Bid");
    	BidAction aBidAction = new BidAction(anAuction);
    	aBidButton.addActionListener(aBidAction);
    	p.add(aBidButton);

	// adding everything to the picture
    	p.setVisible(true);
    	contentPane.setVisible(true);
    	contentPane.add(p, "South");
    	contentPane.add(anAuctionTextArea, "Center");
    	show();
	}
	
	
	public static void main(String[] args) {		
		JFrame anAuctionSimulator = new AuctionSimulator(args);		
	} // closing main
	
	public void setAnAuctionTextArea(String someText){
		this.anAuctionTextArea.setText(someText);
	}
	
	
	
} // closing class
