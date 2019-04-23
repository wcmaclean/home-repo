// Will MacLean
// CSPP 51024
// 
// This interface is from the homework assignment

// add to package
package edu.cspp51024.wmaclean;

import java.rmi.*;
import java.util.*;

public interface CalcServer extends Remote{
	public int compute(int op1, int op2, String operation) throws java.rmi.RemoteException;
}