// A simple Client to test TradeBean. 

package examples.trade; 

import javax.ejb.*;
import javax.naming.*;
import java.rmi.*;
import java.util.*;
import java.lang.Long;

//import java.util.Calendar;

// modified from ProductClient.java

/**
 * Client test application on a Container-Managed Entity Bean, Product.
 */
public class TradeClient {

	public static void main(String[] args) throws Exception {

		TradeHome home = null;

		try {
			/*
			 * Get a reference to the Trade Home Object - the
			 * factory for Product EJB Objects
			 */
			Context ctx = new InitialContext(System.getProperties());
			home = (TradeHome) javax.rmi.PortableRemoteObject.narrow(ctx.lookup("RemoteTraderHome"), TradeHome.class);

			/*
			 * Use the factory to create the Trade EJB Object
			 */
			long now;
			long testClientID;
			
			now = System.currentTimeMillis();
			Long clSeqIDTest1 = new Long("56568891");
			testClientID = 1;
			home.create("-", testClientID, clSeqIDTest1, 10, 100, now);

			now = System.currentTimeMillis();
			Long clSeqIDTest2 = new Long("56568892");
			testClientID =2;
			home.create("+", testClientID, clSeqIDTest2, 20, 150, now);


			/*
			 * Find a Trade, and print out it's description
			 */
			Iterator i = home.findByLimit("+").iterator();
			while (i.hasNext()) {
				Trade aTrade = (Trade) javax.rmi.PortableRemoteObject.narrow(i.next(), Trade.class);
				System.out.println("LIMIT: " + aTrade.getLimit());
				System.out.println("ClientID: " + aTrade.getClientID());
				System.out.println("ClientSeqID: " + aTrade.getClSeqID());
				System.out.println("Quantity: " + aTrade.getQuantity());
				System.out.println("Price: " + aTrade.getPrice());
				System.out.println("ClTime: " + aTrade.getClTime());

			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		

//			if (home != null) {

//				System.out.println("Destroying trades..");

				/*
				 * Find all the trades
				 */
//				Iterator i = home.findAllTrades().iterator();
//				while (i.hasNext()) {
//					try {
//						Trade aTrade = (Trade) javax.rmi.PortableRemoteObject.narrow(i.next(), Trade.class);
//						if (aTrade.getLIMIT().startsWith("+" || "-")) {
//							aTrade.remove();
//						}
//					}
//					catch (Exception e) {
						//e.
//				}
//			}

		}
	}
}
