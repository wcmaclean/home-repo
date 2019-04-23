import java.util.*;
import java.lang.reflect.Array;
import java.lang.Character;

public class Adder {

	/**
	 * Adder is a simple calculator. 
	 * Start from the command line as follows:
	 *     java Adder
	 * Enter math using the following format:
	 *     <integer> <+,-,*,/,%> <integer>
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create variable
		int val1;
		int val2;
		int answer;
		//String operator;
		char operator;
		String input = " ";
		String[] tokens;

		// set up input
		while (!input.equalsIgnoreCase("exit")){
		    System.out.println("Enter a math problem using the following format:");
		    System.out.println("<integer> <+,-,*,/,%> <integer>");
			System.out.print("PROMPT >> ");
		    input = ParserUtils.getKeyInput();
		    tokens = ParserUtils.getTokens(input);

		    // check for too many parameters
		    if(Array.getLength(args) > 3){
				System.out.println("Not enough parameters.");
// Trying to think of a test to see if the strings in the array will cast to integers
//			}else if((Integer.parseInt(tokens[0]))==false || (Integer.parseInt(tokens[2]))==false){
//				System.out.println("Tsk! Tsk! Those aren't numbers.");
//		    }else if (Character.isDigit(tokens[0])==false || Character.isDigit(tokens[2])==false){
//		    	
//		    }else if (args[0].matches("[0-9]+") && args[2].matches("[0-9]+")){
		    }else{ 
			    //move values to variables
			    val1 = Integer.parseInt(tokens[0]);
			    operator = tokens[1].charAt(0);
			    val2 = Integer.parseInt(tokens[2]);

			    // check operator, and do math accordingly
			    if(operator=='+'){
			    	answer = val1 + val2;
			    	System.out.println(answer + "\n");
			    }else if(operator=='-'){
			    	answer = val1 - val2;
			    	System.out.println(answer + "\n");
			    }else if(operator=='*'){
			    	answer = val1 * val2;
			    	System.out.println(answer + "\n");
			    }else if(operator=='/'){
			    	answer = val1 / val2;
			    	System.out.println(answer + "\n");
			    }else  if(operator=='%'){
			    	answer = val1 % val2;
			    	System.out.println(answer + "\n");
			    }else{ 
			    	// if the operator didn't show, report error
			    	System.out.println("Error: No such operator: " + operator);
			    }				
			}		    
		}
	}
}

