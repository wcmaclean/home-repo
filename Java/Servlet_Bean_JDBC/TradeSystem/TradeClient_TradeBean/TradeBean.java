// a TradeBean - modified from ProductBean. 
// Connects to Trade DB. 

package examples.trade; 

import javax.ejb.*;
import java.lang.Long;

// modified from ProductBean.java

/**
 * Entity Bean which demonstrates Container-Managed persistence.
 *
 * This is a Trade that's persistent.  It has a limit, a name,
 * a description, and a base price.
 */

public abstract class TradeBean implements EntityBean {

	protected EntityContext ctx;

	public TradeBean() {
	}

	//----------------------------------------------------------------
	// Begin abstract get/set methods
	//----------------------------------------------------------------

   public abstract String getLimit();
	public abstract void setLimit(String limit);

	public abstract long getClientID();
	public abstract void setClientID(long clientID);	

	public abstract Long getClSeqID();
	public abstract void setClSeqID(Long clSeqID);

	public abstract int getQuantity();
	public abstract void setQuantity(int quantity);

	public abstract int getPrice();
	public abstract void setPrice(int price);

	public abstract long getClTime();
	public abstract void setClTime(long clTime);

	//----------------------------------------------------------------
	// End abstract get/set methods
	//----------------------------------------------------------------

	//----------------------------------------------------------------
	// Begin EJB-required methods.  The methods below are called
	// by the Container, and never called by client code.
	//----------------------------------------------------------------

	/**
	 * Called by Container.
	 * Implementation can acquire needed resources.
	 */
	public void ejbActivate() {
		System.out.println("ejbActivate() called.");
	}

	/**
	 * EJB Container calls this method right before it
	 * removes the Entity Bean from the database.
	 * Corresponds to when client calls home.remove().
	 */
	public void ejbRemove() {
		System.out.println("ejbRemove() called.");
	}

	/**
	 * Called by Container.
	 * Releases held resources for passivation.
	 */
	public void ejbPassivate() {
		System.out.println("ejbPassivate () called.");
	}

	/**
	 * Called from the Container.  Updates the entity bean
	 * instance to reflect the current value stored in
	 * the database.
	 *
	 * Since we're using Container-Managed Persistence, we
	 * can leave this method blank.  The EJB Container will
	 * automatically set our public fields to the correct values.
	 */
	public void ejbLoad() {
		System.out.println("ejbLoad() called.");
	}

	/**
	 * Called from the Container.  Updates the database to
	 * reflect the current values of this in-memory Entity Bean
	 * instance representation.
	 *
	 * Since we're using Container-Managed Persistence, we can
	 * leave this method blank.  The EJB Container will
	 * automatically save our public fields into the database.
	 */
	public void ejbStore() {
		System.out.println("ejbStore() called.");
	}

	/**
	 * Called by Container.  Associates this Bean instance with
	 * a particular context.  Once done, we can query the
	 * Context for environment info
	 */
	public void setEntityContext(EntityContext ctx) {
		System.out.println("setEntityContext called");
		this.ctx = ctx;
	}

	/**
	 * Called by Container.  Disassociates this Bean instance
	 * with a particular context environment.
	 */
	public void unsetEntityContext() {
		System.out.println("unsetEntityContext called");
		this.ctx = null; 
	}

	/**
	 * Called after ejbCreate().  Now, the Bean can retrieve
	 * its EJBObject from its context, and pass it as a 'this'
	 * argument.
	 */
	public void ejbPostCreate(String limit, long clientID, Long clSeqID, int quantity, int price, long clTime) {
		System.out.println("ejbPostCreate() called");
	}

	/**
	 * This is the initialization method that corresponds to the
	 * create() method in the Home Interface.
	 *
	 * When the client calls the Home Object's create() method,
	 * the Home Object then calls this ejbCreate() method.
	 *
	 * NOTE: Since we're using Container-Managed persistence,
	 * this method returns void.  With Bean-Managed Persistence,
	 * we returned the PK.  This is because our Bean was
	 * responsible for dealing with PKs and accessing
	 * the database.  Now that we let the Container handle
	 * persistence, the Container makes the Primary Key.
	 *
	 * We still need to initialize our Bean's fields with the
	 * parameters passed from the client, so that the Container
	 * can inspect our Bean and create the corresponding database
	 * entries.
	 */
	public Long ejbCreate(String limit, long clientID, Long clSeqID, int quantity, int price, long clTime) {
		System.out.println("ejbCreate() called");

		setLimit(limit);
		setClientID(clientID);
		setClSeqID(clSeqID);
		setQuantity(quantity);
		setPrice(price);
		setClTime(clTime);

		return clSeqID;
	}

	// No finder methods - they are implemented by Container

	//----------------------------------------------------------------
	// End EJB-required methods
	//----------------------------------------------------------------
}
