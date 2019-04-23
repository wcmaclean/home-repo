package examples.calculator;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
import java.lang.reflect.Array;
import java.io.*;
import java.util.*;

/**
 * This class is an example of client code which invokes
 * methods on a simple stateless session bean.
 */
public class CalculatorClient {

	public static void main(String[] args) throws Exception {
		/*
		 * Setup properties for JNDI initialization.
		 *
		 * These properties will be read-in from
		 * the command-line.
		 */
		Properties props = System.getProperties();

		/*
		 * Obtain the JNDI initial context.
		 *
		 * The initial context is a starting point for
		 * connecting to a JNDI tree. We choose our JNDI
		 * driver, the network location of the server, etc
		 * by passing in the environment properties.
		 */
		Context ctx = new InitialContext(props);

		/*
		 * Get a reference to the home object - the
		 * factory for Hello EJB Objects
		 */
		Object obj = ctx.lookup("CalculatorHome");


		/*
		 * Home objects are RMI-IIOP objects, and so
		 * they must be cast into RMI-IIOP objects
		 * using a special RMI-IIOP cast.
		 *
		 * See Appendix X for more details on this.
		 */
		CalculatorHome home = (CalculatorHome)
			javax.rmi.PortableRemoteObject.narrow(
				obj, CalculatorHome.class);

		/*
		 * Use the factory to create the Hello EJB Object
		 */
		Calculator aCalculator = home.create();

		// variables
		int val1;
		int val2;
		int answer;
		String operator;
		String input = " ";
		String[] tokens;
		
		while(!input.equalsIgnoreCase("exit")){
			System.out.println
				("Enter a math problem using the following syntax: ");
			System.out.println
				("<integer> <+,-,*,/,%> <integer>");
			System.out.print("Your math problem?>> ");
			input = CalculatorClient.getKeyInput();
			tokens = CalculatorClient.getTokens(input);
			
			for(int i=0; i<3; i++){
				System.out.println(tokens[i]);
			}

			// check for too many params
			if(Array.getLength(tokens) != 3){
				System.out.println("Incorrect number of arguments. Please reenter.");
			}else{
				// parse out the variables
				val1 = Integer.parseInt(tokens[0]);
				operator = tokens[1];
				val2 = Integer.parseInt(tokens[2]);
					
				// call CalcServer to get math done
				answer = aCalculator.compute(val1, val2, operator);
					
				// print the answer
				System.out.println("The answer is: " + answer);
			}
		}
// aCalculator.compute(stuff);
//		System.out.println(hello.hello());

		/*
		 * Done with EJB Object, so remove it.
		 * The container will destroy the EJB object.
		 */
		aCalculator.remove();
	}
	
	// methods hastily thrown in here cuz I couldn't figure out
	// how to properly add to the Makefile
	// borrowed from Siegel
	public static String getKeyInput(){
		String input = null;
		try{
		    BufferedReader in = 
			new BufferedReader(new InputStreamReader(System.in));
	    	input = in.readLine();
		}
		catch (IOException ioe){
		    System.out.println(ioe);
		}
		return input;
	}
    
	 public static String[] getTokens(String input){

		int i = 0;
		StringTokenizer st = new StringTokenizer(input);
		int numTokens = st.countTokens();
		String[] tokenList = new String[numTokens];

		while (st.hasMoreTokens()){
		    tokenList[i] = st.nextToken();
		    i++;
		}
		return(tokenList);
    	}
	
	
}
