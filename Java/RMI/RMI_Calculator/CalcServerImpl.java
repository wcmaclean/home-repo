// Will MacLean
// CSPP 51024
// 
// This is based on Matei's TimeServer.java


// add to package
package edu.cspp51024.wmaclean;

import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.util.*;

public class CalcServerImpl extends UnicastRemoteObject implements CalcServer {
    //final static String server = "guts.cs.uchicago.edu";
    final static String server = "localhost";
 
   public CalcServerImpl() throws RemoteException {
        super();
    }

	public int compute(int op1, int op2, String operation) throws java.rmi.RemoteException{
		
		int answer = 0;

		// check operator, and do math accordingly
		if(operation.equals("+")){
			answer = op1 + op2;
		}else if(operation.equals("-")){
			answer = op1 - op2;
		}else if(operation.equals("*")){
			answer = op1 * op2;
		}else if(operation.equals("/")){
			answer = op1 / op2;
		}else  if(operation.equals("%")){
			answer = op1 % op2;
		}else{ 
			// if the operator didn't show, report error
			System.out.println("Error: No such operator: " + operation);
		}
	
		return answer;
				
	}
    

    public static void main(String args[]) {
        if (System.getSecurityManager() == null) { 
            System.setSecurityManager(new RMISecurityManager()); 
        }try {
            CalcServerImpl aCalcServer = new CalcServerImpl();
            Naming.rebind("//"+server+"/CalcServer", aCalcServer);
            System.out.println("CalcServer ready on "+server+" ...");
        }catch(RemoteException e) {
            System.out.println("Error: " + e);
        }catch(MalformedURLException e) {
            System.out.println("Error: " + e);
        }
    }
}