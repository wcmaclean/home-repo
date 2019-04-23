//import java.security.Timestamp;
//import java.util.Date;
import java.lang.System;

// might need this...
// -tsa http://example.tsa.url

public class Matrix {

	/**
	 * The Matrix class calculates two Matrices of 15 by 15 suze. 
	 * It also counts the milliseconds before and after to determine 
	 * the total calculation time. These numbers are to be compare to
	 * those of a study found at the following website:
	 * 
	 *   http://cdmetcalf.home.comcast.net/papers/milan/node17.html
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Date startTime = Date;
		long start;
		long stop = 0;
		
		// matrix 1
		int[][] matrix1 = {
				{1, 3, 2, 2, 6, 8, 0, 0, 3, 7, 6, 4, 0, 6, 4},
				{8, 0, 0, 3, 7, 3, 3, 5, 2, 6, 3, 3, 5, 2, 6},
				{3, 3, 5, 2, 6, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{6, 4, 0, 6, 4, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{2, 7, 7, 9, 3, 3, 3, 5, 2, 6, 2, 7, 7, 9, 6},
				{1, 3, 2, 2, 6, 8, 0, 0, 3, 7, 6, 4, 0, 6, 4},
				{8, 0, 0, 3, 7, 3, 3, 5, 2, 6, 3, 3, 5, 2, 6},
				{3, 3, 5, 2, 6, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{6, 4, 0, 6, 4, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{2, 7, 7, 9, 3, 3, 3, 5, 2, 6, 2, 7, 7, 9, 6},
				{1, 3, 2, 2, 6, 8, 0, 0, 3, 7, 6, 4, 0, 6, 4},
				{8, 0, 0, 3, 7, 3, 3, 5, 2, 6, 3, 3, 5, 2, 6},
				{3, 3, 5, 2, 6, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{6, 4, 0, 6, 4, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{2, 7, 7, 9, 3, 3, 3, 5, 2, 6, 2, 7, 7, 9, 6}
		};
		int iterations1 = 0;
		System.out.println("\nMatrix 1:");
		for(int x=0;x<matrix1.length;x++){
			for(int y=0;y<matrix1[x].length;y++){
				System.out.print(matrix1[x][y] + " ");
				iterations1 = iterations1 + 1;
			}
			System.out.println();
		}
		
		// matrix 2
		int[][] matrix2 = {
				{1, 3, 2, 2, 6, 8, 0, 0, 3, 7, 6, 4, 0, 6, 4},
				{8, 0, 0, 3, 7, 3, 3, 5, 2, 6, 3, 3, 5, 2, 6},
				{3, 3, 5, 2, 6, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{6, 4, 0, 6, 4, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{2, 7, 7, 9, 3, 3, 3, 5, 2, 6, 2, 7, 7, 9, 6},
				{1, 3, 2, 2, 6, 8, 0, 0, 3, 7, 6, 4, 0, 6, 4},
				{8, 0, 0, 3, 7, 3, 3, 5, 2, 6, 3, 3, 5, 2, 6},
				{3, 3, 5, 2, 6, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{6, 4, 0, 6, 4, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{2, 7, 7, 9, 3, 3, 3, 5, 2, 6, 2, 7, 7, 9, 6},
				{1, 3, 2, 2, 6, 8, 0, 0, 3, 7, 6, 4, 0, 6, 4},
				{8, 0, 0, 3, 7, 3, 3, 5, 2, 6, 3, 3, 5, 2, 6},
				{3, 3, 5, 2, 6, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{6, 4, 0, 6, 4, 2, 7, 7, 9, 3, 2, 7, 7, 9, 3},
				{2, 7, 7, 9, 3, 3, 3, 5, 2, 6, 2, 7, 7, 9, 6}
		};
		int iterations2 = 0;
		System.out.println("\nMatrix 2:");
		for(int x=0;x<matrix2.length;x++){
			for(int y=0;y<matrix2[x].length;y++){
				System.out.print(matrix2[x][y] + " ");
				iterations2 = iterations2 + 1;
			}
			System.out.println();
		}
		
		//matrix 3
		int[][] matrix3 = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		start = System.currentTimeMillis();
		for(int x=0;x<matrix1.length;x++){
			for(int y=0;y<matrix1[x].length;y++){
				matrix3[x][y] = matrix1[x][y] * matrix2[x][y];
			}
		}
		System.out.println("\nMatrix 3 is the result of multiplying matrices 1 and 2:");
		for(int x=0;x<matrix3.length;x++){
			for(int y=0;y<matrix3[x].length;y++){
				System.out.print(matrix3[x][y] + " ");
			}
			System.out.println();
		}

		
		// get end time and calculate the difference - output all
		stop = System.currentTimeMillis();
		long runTime = stop - start;
		System.out.println("\nJava calculating a 15x15 matrix");
		System.out.println("compared to Paris, Lisp, and Milan");
		System.out.println("-----------------------------------");
		System.out.println("Paris:  0.19 seconds");
		System.out.println("Lisp:   0.69 seconds");
		System.out.println("Milan:  0.30 seconds");
		System.out.println("Java:   " + runTime + " milliseconds\n");
		System.out.println("For the original study, please see:");
		System.out.println("http://cdmetcalf.home.comcast.net/papers/milan/node17.html");
	
	}
}
