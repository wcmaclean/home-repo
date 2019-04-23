// This is the working MatchingEngine. I also tried to 
// add jms, but flopped - see jms_attempt_3. 

import java.sql.*;
import java.lang.Long;
import java.lang.Integer;

public class MatchingEngine extends Thread{

	public void run(){
		try {
			while(true){
				getMatches();
				sleep(2000);
			}
		}catch(Exception e){}
	}

	public void getMatches(){
		Connection aConnection = null;
		Connection aConnection2 = null;
		int iRowCount = 0;
		Statement stmt = null;
		Statement stmt2 = null;
		long returnThis =0;
		ResultSet sell = null;
		ResultSet buy = null;
		int sellQuantity=0;
		int buyQuantity=0;
		int newSellQuantity=0;
		int newBuyQuantity=0;
		long sellClSeqID=0;
		long buyClSeqID=0;

		// get a connection to the database
		//aConnection = DBLink.getConnection();

		try{
				aConnection = DBLink.getConnection();
		    	stmt = aConnection.createStatement();
		    	aConnection2 = DBLink.getConnection();
		    	stmt2 = aConnection2.createStatement();
		}catch ( Exception e){
		    	System.err.println( "problems connecting");
		    	System.err.println( e.getMessage() );
		    	if( aConnection != null){
				try { aConnection.close(); }
					catch( Exception e2 ) { }
		    	}
		} // end catch-try
		try{
			// get sells 
		    String sellQuery = 
		    	"SELECT * FROM Trade WHERE limit=\'-\'";    	
				sell = stmt.executeQuery(sellQuery);			
			 System.out.println(sellQuery);
			 

								
			 
/*
ResultSetMetaData blech = sell.getMetaData();			
while(sell.next()){
 for (int i=1; i<blech.getColumnCount(); i++){
 	System.out.println(sell.getString(i));
 }
}				
*/					 
			
			// reset the sell restultset
			//sell.first();

			// iterate the result sets 
			while(sell.next()) {
				System.out.println("in sell while loop of algo");
			
			 	// get all the sell info you'll need 
			 	sellClSeqID = sell.getLong(3);
			 	int sellPrice = sell.getInt(5);
			 	sellQuantity = sell.getInt(4);
			 	String sellLimit = sell.getString(1);
			 	System.out.println("sellLimit: " + sellLimit);			
			

				// reset the buy resultset 
				// get buys 
		   	String buyQuery = 
		    		"SELECT * FROM Trade WHERE limit=\'+\'";    	
				buy = stmt2.executeQuery(buyQuery);
				System.out.println(buyQuery);
/*
ResultSetMetaData blech = buy.getMetaData();			
while(buy.next()){
 for (int i=1; i<blech.getColumnCount(); i++){
 	System.out.println(buy.getString(i));
 }
}				
*/				
				// matching algorithm
				while(buy.next()){
					System.out.println("in buy while loop of algo");
					
			 		// get all the buy info 
					buyClSeqID = buy.getLong(3);
				 	int buyPrice = buy.getInt(5);
			 		buyQuantity = buy.getInt(4);
			 		String buyLimit = buy.getString(1);
			 		System.out.println("buyLimit: " + buyLimit);					
		
System.out.println("Looking for a match...");	
System.out.println("sell: " + sellPrice);	
System.out.println("buy: " + buyPrice);					
					
					// if prices match   
					if(sellPrice<=buyPrice){

						// print
						System.out.println("We have a match"); 
																	
						// compare quantities and subtract apropos 
						if (	sellQuantity > 0 &&
							 	buyQuantity > 0 ){
							 	
					 		// calculate amount sold 	
							newSellQuantity = sellQuantity - buyQuantity;
							newBuyQuantity = buyQuantity - sellQuantity;
							
							System.out.println("sellClSeqID: " + sellClSeqID);
							System.out.println("buyClSeqID: " + buyClSeqID);
						 		
						 	// update Trade DB for seller 
		   				stmt.executeUpdate(
		   					"UPDATE Trade SET quantity=" + newSellQuantity + "WHERE clSeqID=" + sellClSeqID);
						 	// update Trade DB for buyerer 
		   				stmt.executeUpdate(
		   					"UPDATE Trade SET quantity=" + newBuyQuantity + "WHERE clSeqID=" + buyClSeqID);
	
						 	// update volume 
						 	Volume aVolume = new Volume();
						 	int theVolume = aVolume.getVolume(buyQuantity);
					 	
						 	// update totaltrades 
						 	TradeTotal aTradeTotal = new TradeTotal();
						 	int theTradeTotal = aTradeTotal.getTradeTotal();
					 	
						 	// get time 
						 	long mkTime = System.currentTimeMillis();
					 	
						 	// get a ClSeqCountID for the match 
						 	SeqCount aSeqCount = new SeqCount();
  	      				long tempClSeqID = aSeqCount.getSeqCount();
  	      				System.out.println("buyClSeqID: " + buyClSeqID);
  	      				System.out.println("sellClSeqID: " + sellClSeqID);
							System.out.println("tempClSeqID: " + tempClSeqID);  	      			
  	      				System.out.println("buyQuantity: " + buyQuantity);
  	      				System.out.println("mkTime: " + mkTime);
  	      				System.out.println("theVolume: " + theVolume);
  	      				System.out.println("theTradeTotal: " + theTradeTotal);
  	      				
						 	// update FilledTradeDB 
   						stmt.executeUpdate(
	 	  					"INSERT INTO FilledTrade VALUES(" + 
	 	  							buyClSeqID + ", " + 
	 	  							sellClSeqID + ", " + 
	 	  							tempClSeqID + ", " + 
	 	  							buyQuantity + ", " + 
	 	  							sellPrice + ", " + 
	 	  							mkTime + ", " + 
	 	  							theVolume + ", " + 
	 	  							theTradeTotal +
	 	  							")");		
	 	  							
	 	  					// send market data
	 	  					
	 	  					
/*
	 	  					InitialContext ic = 
	 	  						getInitialContext
	 	  							("examples.jms.marketdatatopic.MarketDataTopicSend", 
	 	  								"http://washington.cs.uchicago.edu:7001");
    						MarketDataTopicSend aSend = new MarketDataTopicSend();
    						aSend.init(ic, TOPIC);
    						String line = 	mkTime + ", " + 
	 	  										theVolume + ", " + 
	 	  										theTradeTotal;
    						MarketDataTopicSend.areadAndSend(aSend, line);
    						aSend.close();			
*/ 	
				 	
						} // close 0 test if 
					} // close match test if
				} // close buy while		
				//buy.first(); 		
			} // close sell while 
			
//	   stmt.executeUpdate(
//	   	"UPDATE SeqCount SET SeqCountNum=" + returnThis + "WHERE SeqCountKey=1");


	 	}catch( Exception e ){
	    	System.err.println("problem with SQL" );
	    	System.err.println( e.getMessage() );
		}finally{
	    	try { stmt.close(); }
	    	catch( Exception e ) {}

	    	try { aConnection.close(); }
	    	catch( Exception e ) {}
		} // end finally clause	
		
	}

    public static void main(String[] args) {
    	MatchingEngine aMatchingEngine =
    		new MatchingEngine();
    	//aMatchingEngine.getMatches();
    	aMatchingEngine.run(); 
    } // end main
} // end class Matching Engine