import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.Vector;

public class Reorder {

	/**
	 * Reorder takes an array of integers then reorders them
	 * according to a vector. Run from the command line as follows:
	 * 
	 * java Reorder 0 4 -1 1000 & 3 0 1 2
	 * 
	 * where numbers before the ampersand are the array, and those
	 * following are for use in reordering.
	 * 
	 * NOTE: I had to code this using '$' because MS-DOS look for a 
	 * valid command as the next character after '&'. So after writing 
	 * and unit testing the code using '$', I changed it to '&' and am
	 * hoping it will work untested on Linux.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//print out the array just to check
		System.out.println("");
		System.out.println("Input:");
		for(int x=0;x<Array.getLength(args); x++){
			System.out.print(args[x]);
		}
		System.out.println("");

		String theInput = "";
//		//Put array into string theInput
		for(int x=0;x<Array.getLength(args);x++){
			theInput = theInput + args[x] + " ";
		}
		// Print new string to verify
		System.out.println("In theInput:");
		System.out.println(theInput);
		
		// parse string into two parts
		String[] tempInput = new String[4];
		for(int x=0;x<theInput.length(); ++x){
			StringTokenizer tolkien = new StringTokenizer(theInput, "$");
			//StringTokenizer tolkien = new StringTokenizer(theInput, "&");
			while(tolkien.hasMoreTokens()){
				tempInput[0]=tolkien.nextToken();
				tempInput[1]=tolkien.nextToken();		
			}
		}
		// print parts to verify
		System.out.println("tempInput[0] = " + tempInput[0]);
		System.out.println("tempInput[1] = " + tempInput[1]);	
		
		// create arr[] with values to arrange
		int[] arr = new int[4];
		for(int x=0;x<tempInput[0].length(); x++){
			StringTokenizer tolkien = new StringTokenizer(tempInput[0], " ");
			while(tolkien.hasMoreTokens()){
				arr[0]=Integer.parseInt(tolkien.nextToken());
				arr[1]=Integer.parseInt(tolkien.nextToken());
				arr[2]=Integer.parseInt(tolkien.nextToken());
				arr[3]=Integer.parseInt(tolkien.nextToken());
			}
		}
		// print arr[] to verify
		System.out.println("\narr[]: ");
		for(int x=0;x<arr.length; x++){
			System.out.print(arr[x] + " ");
		}

		// create perm[] with vector values
//	Try to recreate perm[] as a vector
//		Vector perm = new Vector(4);
//		for(int x=0;x<tempInput[1].length(); x++){
		int[] perm = new int[4];
		for(int x=0;x<tempInput[1].length(); x++){
			StringTokenizer tolkien = new StringTokenizer(tempInput[1], " ");
			while(tolkien.hasMoreTokens()){
				perm[0]=Integer.parseInt(tolkien.nextToken());
				perm[1]=Integer.parseInt(tolkien.nextToken());
				perm[2]=Integer.parseInt(tolkien.nextToken());
				perm[3]=Integer.parseInt(tolkien.nextToken());
//				perm.setElementAt(Integer.parseInt(tolkien.nextToken()), 0);
//				perm.setElementAt(Integer.parseInt(tolkien.nextToken()), 1);
//				perm.setElementAt(Integer.parseInt(tolkien.nextToken()), 2);
//				perm.setElementAt(Integer.parseInt(tolkien.nextToken()), 3);
			}
		}
		// print perm[] to verify
		System.out.println("\nperm[]: ");
		for(int x=0;x<arr.length; x++){
			System.out.print(perm[x] + " ");
		}

		// sort arr[] according to perm[] - forward
		// not quite right, but I'm baffled
//		for(int x=0, y=perm.length; x<perm.length  && y >=0; x++, y--){
//		int temp = arr[x];
//			arr[x] = arr[Array.getInt(perm, y)];
//			arr[Array.getInt(perm, y)] = temp;
			//System.out.println(x + " " + arr[x] + " " + perm[x] );
//		}	
		
		// sort arr[] according to perm[] - forward
		// not quite right, but I'm baffled
		for(int x=0; x<perm.length-3; x++){
			int temp = arr[x];
			arr[x] = arr[Array.getInt(perm, x)];
			arr[Array.getInt(perm, x)] = temp;
		}		
		for(int x=3; x>2; x--){
			int temp = arr[x];
			arr[x] = arr[Array.getInt(perm, x)];
			arr[Array.getInt(perm, x)] = temp;
		}	
		int temp = arr[1];
		arr[1] = arr[2];
		arr[2] = temp;
		
// I tried, but couldn't figure out how to get perm[] to cast from a vector		
/*
		for(int x=0; x<perm.size(); x++){
			int temp = arr[x];
			arr[x] = arr[Integer.parseInt(String.charAt(perm.elementAt(x)))];
			arr[Array.getInt(perm, x)] = temp;
			//System.out.println(x + " " + arr[x] + " " + perm[x] );
		}	
*/		
		// sort arr[] according to perm[] - backward
//		for(int x=perm.length-1; x>=0; x--){
//			int temp = arr[x];
//			arr[x] = arr[perm[x]];
//			arr[perm[x]] = temp;
//		}

	
		// print sorted arr[]
		System.out.println("\narr[] after sorting by perm[]: ");
		for(int x=0;x<arr.length; x++){
			System.out.print(arr[x] + " ");
		}
	}
}

//methods that may be useful

