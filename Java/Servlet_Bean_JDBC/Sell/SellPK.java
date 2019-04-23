package examples.sell;

import java.io.Serializable;

// Modified from Product example

/**
 * Primary Key class for our 'Sell' Container-Managed
 * Entity Bean
 */

public class SellPK implements java.io.Serializable {

	/*
	 * Note that the primary key fields must be a
	 * subset of the the container-managed Bean fields.
	 * The fields we are marking as container-managed in
	 * our Bean are productID, name, desc, and basePrice.
	 * Therefore our PK fields need to be from that set.
	*/

	public String sellID;

	public SellPK(String sellID) {
		this.sellID = sellID;
	}
	public SellPK() {
	}

	public String toString() {
		return sellID.toString();
	}

	public int hashCode()
	{
	      return sellID.hashCode();
	}

	public boolean equals(Object sell)
	{
	      return ((SellPK)sell).sellID.equals(sellID);
	}  
}
