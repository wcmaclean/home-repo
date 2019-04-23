package examples.sell; 

import javax.ejb.*;
import java.rmi.RemoteException;

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

public interface Sell extends EJBObject {

	// Getter/setter methods for Entity Bean fields

        public String getSellID() throws RemoteException;
	public void setSellID(String SellID) throws RemoteException;

	public long getClientID() throws RemoteException;
	public void setClientID(long ClientID) throws RemoteException;

	public long getClSeqID() throws RemoteException;
	public void setClSeqID(long ClSeqID) throws RemoteException;

        public int getQuantity() throws RemoteException;
	public void setQuantity(int aQuantity) throws RemoteException;
      
        public int getPrice() throws RemoteException;
	public void setPrice(int price) throws RemoteException;

        public long getClTime() throws RemoteException;
	public void setClTime(long ClTime) throws RemoteException;
}
