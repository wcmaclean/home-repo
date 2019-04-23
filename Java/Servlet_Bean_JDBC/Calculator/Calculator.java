package examples.calculator;

/**
 * This is the HelloBean remote interface.
 *
 * This interface is what clients operate on when
 * they interact with EJB objects.  The container
 * vendor will implement this interface; the
 * implemented object is the EJB object, which
 * delegates invocations to the actual bean.
 */
public interface Calculator extends javax.ejb.EJBObject
{

  /**
   * The one method - calculate - takes some variables and returns an int.
   */
  public int compute(int op1, int op2, String operation) throws java.rmi.RemoteException;
}
