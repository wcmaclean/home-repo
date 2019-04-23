package examples.sell; 

import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Collection;

// modified from ProductHome.java

/**
 * This is the home interface for Sell.  This interface
 * is implemented by the EJB Server's glue-code tools.
 * The implemented object is called the Home Object, and
 * serves as a factory for EJB Objects.
 * 
 * One create() method is in this Home Interface, which
 * corresponds to the ejbCreate() method in the Sell file.
 */

public interface SellHome extends EJBHome {

	/*
	 * Creates a sell
	 *
	 * @param SellID The PK of the Sell (unique)
	 *
	 * @return The newly created EJB Object.
	 */

	Sell create(String sellID, long aClientID, long aClSeqID, int aQuantity, int aPrice, long aClTime) throws CreateException, RemoteException;

	// Finder methods.  These are implemented by the
	// container.  You can customize the functionality of
	// these methods by using the EJB Container tools.

	public Sell findByPrimaryKey(String key) throws FinderException, RemoteException;
	public Collection findBySellID(String sellID) throws FinderException, RemoteException;
	public Collection findByPrice() throws FinderException, RemoteException;
	public Collection findSellsAbove() throws FinderException, RemoteException;
	public Collection findByAllSells() throws FinderException, RemoteException;

//	public Collection findByDescription(String description) throws FinderException, RemoteException;
//	public Collection findByBasePrice(double basePrice) throws FinderException, RemoteException;
//	public Collection findExpensiveProducts(double minPrice) throws FinderException, RemoteException;
//	public Collection findCheapProducts(double maxPrice) throws FinderException, RemoteException;
//	public Collection findAllProducts() throws FinderException, RemoteException;
}
