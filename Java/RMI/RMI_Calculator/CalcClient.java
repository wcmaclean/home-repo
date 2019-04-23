// Will MacLean
// CSPP 51024
// 
// This is based on Matei's Time Client
// And uses Prof. Siegel's ParserUtils from CSPP51037

// add to package
package edu.cspp51024.wmaclean;

import java.rmi.*;
import java.util.*;
import java.lang.reflect.Array;

public class CalcClient {
    //final static String server = "guts.cs.uchicago.edu";
    final static String server = "localhost";
    public static void main(String args[]) {

	// variables
	int val1;
	int val2;
	int answer;
	String operator;
	String input = " ";
	String[] tokens;

        if (System.getSecurityManager() == null) { 
            System.setSecurityManager(new RMISecurityManager()); 
        } 
        try {
            	CalcServer aCalcServer = (CalcServer) 
                            Naming.lookup("//"+server+"/CalcServer");
            	while(true){
			while(!input.equalsIgnoreCase("exit")){
				System.out.println
					("Enter a math problem using the following syntax: ");
				System.out.println
					("<integer> <+,-,*,/,%> <integer>");
				System.out.print("Your math problem?>> ");
				input = ParserUtils.getKeyInput();
				tokens = ParserUtils.getTokens(input);
				
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
					answer = aCalcServer.compute(val1, val2, operator);

					// print the answer
					System.out.println("The answer is: " + answer);
				}
			}
		}
        }
        catch(Exception e) {
            System.out.println("Couldn't connect: " + e);
        }
    }
}
