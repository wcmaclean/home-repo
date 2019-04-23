import java.util.*;
import java.lang.reflect.Array;

public class StudentSorter {

	/**
	 * Class StudentSorter reads a formatted file, then puts
	 * the results into an array of class Student. Then, it
	 * sorts the results. It is run from the command line
	 * as follows:
	 * 
	 *    java StudentSorter <input file> 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = args[0];
		String[] fileContents = TextManipTools.readFileByLine(filename);

//		for(int x=0; x<fileContents.length;x++){
//			System.out.println(fileContents[x]);
//		}
		
		Student[] theStudents = new Student[20];
		for(int x=0;x<fileContents.length;x++){
//			String s = Array.get(fileContents, x);
			StringTokenizer tolkien = new StringTokenizer(fileContents[x], " ");
			while(tolkien.hasMoreTokens()){
//				System.out.println(tolkien.nextToken());
				String lName = tolkien.nextToken();
				String fName = tolkien.nextToken();
				int qtrH = Integer.parseInt(tolkien.nextToken());
				int qtrC = Integer.parseInt(tolkien.nextToken());
				theStudents[x] = new Student(lName, fName, qtrH, qtrC);
			}
		}
		
		System.out.println("\nThe unsorted students:");
		for(int x=0;x<fileContents.length;x++){
			System.out.print(theStudents[x].LastName + " ");
			System.out.print(theStudents[x].FirstName + " ");
			System.out.print(theStudents[x].QtrsHouse + " ");
			System.out.print(theStudents[x].QtrsCollege + "\n");
		}
		
		//sort by QtrsHouse
//		int end = Array.getLength(theStudents)/5;
		int end = fileContents.length;
		System.out.println(end);
		for(int x=0; x<end; x++){
			for(int y=x; y<end /*Array.getLength(theStudents)-1*/; y++){
				int xVal = theStudents[x].QtrsHouse;
				int yVal = theStudents[y].QtrsHouse;
//				System.out.println(x + " " + y);
//				if(theStudents[x].QtrsHouse < theStudents[y].QtrsHouse){
				if(xVal < yVal){
					StudentSwap(theStudents, x, y);
//				}else if(theStudents[x].QtrsHouse==theStudents[y].QtrsHouse){
				}else if(xVal==yVal){
					Random generator = new Random();
					int randomNum = generator.nextInt(2);
					if(randomNum==0){
						StudentSwap(theStudents, x, y);						
					}
				}
			}
		}
		
		//sort by QtrsCollege
		for(int x=0; x<end; x++){
			for(int y=x; y<end; y++){
				int xVal = theStudents[x].QtrsCollege;
				int yVal = theStudents[y].QtrsCollege;
//				System.out.println(x + " " + y);
//				if(theStudents[x].QtrsCollege>theStudents[y].QtrsCollege){
				if(xVal < yVal){
					StudentSwap(theStudents, x, y);
//				}else if(theStudents[x].QtrsCollege==theStudents[y].QtrsCollege){
				}else if(xVal==yVal){
					Random generator = new Random();
					int randomNum = generator.nextInt(2);
					if(randomNum==0){
						StudentSwap(theStudents, x, y);						
					}
				}
			}
		}
		
		System.out.println("\nThe sorted students");
		for(int x=0;x<fileContents.length;x++){
			System.out.print(theStudents[x].LastName + " ");
			System.out.print(theStudents[x].FirstName + " ");
			System.out.print(theStudents[x].QtrsHouse + " ");
			System.out.print(theStudents[x].QtrsCollege + "\n");
		}
		
//StudentSwap(Student[] theStudents, int x, int y)
		
		
		
	}//closes main

	public static void StudentSwap(Student[] theStudents, int x, int y){
		Student studentTemp = theStudents[x];
		theStudents[x] = theStudents[y];
		theStudents[y] = studentTemp;
	}

}//closes class
