package examples.trade;

import java.io.Serializable;
import java.lang.*;

// Modified from Product example

/**
 * Primary Key class for our 'Trade' Container-Managed
 * Entity Bean
 */

public class TradePK implements java.io.Serializable {

	/*
	 * Note that the primary key fields must be a
	 * subset of the the container-managed Bean fields.
	 * The fields we are marking as container-managed in
	 * our Bean are productID, name, desc, and basePrice.
	 * Therefore our PK fields need to be from that set.
	*/

	public Long clSeqID;

	public TradePK(Long clSeqID) {
		this.clSeqID = clSeqID;
	}
	public TradePK() {
	}

	public String toString() {
		return clSeqID.toString();
	}

	public int hashCode()
	{
	      return clSeqID.hashCode();
	}

	public boolean equals(Object trade)
	{
	      return ((TradePK)trade).clSeqID.equals(clSeqID);
	}  
}
