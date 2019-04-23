package examples.sell; 

import javax.ejb.*;
import javax.naming.*;
import java.rmi.*;
import java.util.*;

//import java.util.Calendar;

// modified from ProductClient.java

/**
 * Client test application on a Container-Managed Entity Bean, Product.
 */
public class SellClient {

	public static void main(String[] args) throws Exception {

		SellHome home = null;

		try {
			/*
			 * Get a reference to the Sell Home Object - the
			 * factory for Product EJB Objects
			 */
			Context ctx = new InitialContext(System.getProperties());
			home = (SellHome) javax.rmi.PortableRemoteObject.narrow(ctx.lookup("RemoteSellHome"), SellHome.class);

			/*
			 * Use the factory to create the Sell EJB Object
			 */
			long now;

			now = System.currentTimeMillis();
			home.create("Sell_Number_1", 123456789, 8764532, 10, 100, now);

			now = System.currentTimeMillis();
			home.create("Sell_Number_2", 1765489, 8632, 20, 150, now);


			/*
			 * Find a Sell, and print out it's description
			 */
			Iterator i = home.findBySellID("Sell_Number_1").iterator();
			System.out.println("The following Sell is under the ID Sell_Number_1:");
			while (i.hasNext()) {
				Sell aSell = (Product) javax.rmi.PortableRemoteObject.narrow(i.next(), Sell.class);
				System.out.println("SellID: " + aSell.getSellID());
				System.out.println("ClientID: " + aSell.getClientID());
				System.out.println("ClientSeqID: " + aSell.getClSeqID());
				System.out.println("Quantity: " + aSell.getQuantity());
				System.out.println("Price: " + aSell.getPrice());
				System.out.println("ClTime: " + aSell.getClTime());

			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (home != null) {
				System.out.println("Destroying sells..");

				/*
				 * Find all the sells
				 */
				Iterator i = home.findAllSells().iterator();
				while (i.hasNext()) {
					try {
						Sell aSell = (Sell) javax.rmi.PortableRemoteObject.narrow(i.next(), Sell.class);
						if (aSell.getSellID().startsWith("Sell_Number")) {
							aSell.remove();
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
