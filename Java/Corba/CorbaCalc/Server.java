// Will MacLean
// CSPP 51024
//
// mutated from the bank example
//
// Server.java

import org.omg.PortableServer.*;

public class Server {

  public static void main(String[] args) {
    try {

      // Initialize the ORB.
      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

      // get a reference to the root POA
      POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

      // Create policies for our persistent POA
      org.omg.CORBA.Policy[] policies = { 
        rootPOA.create_lifespan_policy(LifespanPolicyValue.PERSISTENT) 
      };

      // Create myPOA with the right policies
//      POA myPOA = rootPOA.create_POA( "bank_agent_poa", rootPOA.the_POAManager(), 
//                                       policies );
      POA myPOA = rootPOA.create_POA( "CorbaCalc_agent_poa", rootPOA.the_POAManager(), 
                                        policies );

      // Create the servant
//      AccountManagerImpl managerServant = new AccountManagerImpl();
      CalculatorImpl aCalculatorServant = new CalculatorImpl();

      // Decide on the ID for the servant
//      byte[] managerId = "BankManager".getBytes();
      byte[] calculatorId = "CalculatorManager".getBytes();

      // Activate the servant with the ID on myPOA
//      myPOA.activate_object_with_id(managerId, managerServant);
      myPOA.activate_object_with_id(calculatorId, aCalculatorServant);

      // Activate the POA manager
      rootPOA.the_POAManager().activate();
//      System.out.println(myPOA.servant_to_reference(managerServant) + 
//                         " is ready.");
      System.out.println(myPOA.servant_to_reference(aCalculatorServant) + 
                         " is ready.");

      // Wait for incoming requests
      orb.run();

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
