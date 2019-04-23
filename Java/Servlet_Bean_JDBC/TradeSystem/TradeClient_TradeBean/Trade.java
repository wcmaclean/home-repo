// a trade interface for the trade bean.


package examples.trade; 

import javax.ejb.*;
import java.rmi.RemoteException;
import java.lang.Long;

// Modified from Product.java

/**
 * These are the public business methods of SellBean.
 *
 * This interface is what clients operate on when they
 * interact with beans. The EJB Server vendor will
 * implement this interface; the implemented object instance
 * is called the EJB Object, which delegates invocations to
 * instances of the SellBean class.
 */

public interface Trade extends EJBObject {

	// Getter/setter methods for Entity Bean fields

   public String getLimit() throws RemoteException;
	public void setLimit(String limit) throws RemoteException;

	public long getClientID() throws RemoteException;
	public void setClientID(long clientID) throws RemoteException;

	public Long getClSeqID() throws RemoteException;
	public void setClSeqID(Long clSeqID) throws RemoteException;

   public int getQuantity() throws RemoteException;
	public void setQuantity(int quantity) throws RemoteException;
      
   public int getPrice() throws RemoteException;
	public void setPrice(int price) throws RemoteException;

   public long getClTime() throws RemoteException;
	public void setClTime(long clTime) throws RemoteException;
}
