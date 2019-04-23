import java.awt.event.*;

public class StartAction implements ActionListener{
	
	Auction anAuction;

	public StartAction(Auction anAuction){
		this.anAuction = anAuction;
	}
	
	public void actionPerformed(ActionEvent event){
		this.anAuction.start();
	}

}
