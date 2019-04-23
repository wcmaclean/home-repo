package examples.calculator;

import javax.ejb.SessionContext;

/**
 * Demonstration stateless session bean.
 */
public class CalculatorBean implements javax.ejb.SessionBean
{
    //
    // EJB-required methods
    //
    public void ejbCreate()
    {
        System.out.println("ejbCreate()");
    }

    public void ejbRemove()
    {
        System.out.println("ejbRemove()");
    }

    public void ejbActivate()
    {
        System.out.println("ejbActivate()");
    }

    public void ejbPassivate()
    {
        System.out.println("ejbPassivate()");
    }

    public void setSessionContext(SessionContext ctx)
    {
        System.out.println("setSessionContext()");
    }

    //
    // Business methods
    //
    public int compute(int op1, int op2, String operation)
    {
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
}
