import java.awt.event.*;

import javax.swing.JOptionPane;

public class BidAction implements ActionListener{
	
	Auction anAuction;

	public BidAction(Auction anAuction){
		this.anAuction = anAuction;
	}
	
	public void actionPerformed(ActionEvent event){
		this.anAuction.suspend();
		int temp = 0;
		String tempString = 
			JOptionPane.showInputDialog("Please enter an integer for your bid (no decimal): ");
		System.out.println(tempString);
		if (hasNumber(tempString)){
			temp = Integer.parseInt(tempString);
		}else{
			JOptionPane.showMessageDialog(null, "Error: Value must be an integer.");
		}
		if (temp > anAuction.getCurrentBid()){
			anAuction.setCurrentBid(temp);
			int userBidderNumber = anAuction.getNumBidder();
			anAuction.setCurrentBidder(userBidderNumber);
			anAuction.checkUserBidder(temp, userBidderNumber);
			
			
		}
		this.anAuction.resume();
	}
	public boolean hasNumber(String s) {
		  for (int j = 0;j < s.length();j++) {
		    if (!Character.isDigit(s.charAt(j))) {
		      return false;
		    }
		  }
		  return true;
		}

}