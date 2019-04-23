import java.lang.reflect.*;

public class ReverseEcho {
	
	/**
	 * The ReverseEcho class takes any number of strings
	 * as input, then prints out each individual entry
	 * in reverse order. It is run from the command line
	 * as follows:
	 *
	 * ReverseEcho <input> <input> <input> <etc.>
	 * 
	 * @param args
	 */
	public static void main (String [] args){
		int x = Array.getLength(args);
		if(Array.getLength(args) < 1){ // attempt some  error handling
			System.out.println("Please run this with input next time.");
			System.out.println("Thank you for your patronage.");
			System.out.println("                      -Management");
		}else{ // Count backwards through the array and print each entry		
			for(int i = x; i>0; i--){
				System.out.print(args[i-1] + " "); /*String.parseString(args[i]);*/
			}
		}
	}
}

