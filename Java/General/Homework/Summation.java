import java.lang.reflect.Array;

public class Summation {

	/**
	 * Class Summation takes two integers as input, then
	 * adds them up sequentially from lowest to highest, 
	 * including all numbers in between.
	 * 
	 * For example, 3 and 6 would result in 18, as follows:
	 * 3 + 4 = 7
	 * 7 + 5 = 12
	 * 12 + 6 = 18
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create variables to hold the input
		int minval = Integer.parseInt(args[0]);
		int maxval = Integer.parseInt(args[1]);
		int nextval = minval + 1;
		int sum = minval;

		if(Array.getLength(args) < 2  || Array.getLength(args) > 2){ // attempt some  error handling
			System.out.println("Please enter two numbers next time.");
		}else if(minval > maxval){
			System.out.println("The first number must be less than the second.");
		}else{ // Count backwards through the array and print each entry		
			for (int i=minval; i<maxval; i++){
				sum = sum + nextval;
				nextval++;
			}
			System.out.println("Sum: " + sum);
		}

	}
}
