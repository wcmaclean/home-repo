import java.lang.reflect.Array;

public class CharCount {
	/**
	 * CharCount takes a letter and a filename as input, 
	 * loads the file, then counts the number of instances
	 * of the letter. It is run as follows:
	 * 
	 * Java CharCount <letter> <filname>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create variables
		char letterCount;
		char letter = args[0].charAt(0);
		String filename = args[1];
		String fileContents = TextManipTools.readFile(filename);
		int Tot = 0;
		
		// check for too few/many numbers
		if (Array.getLength(args) > 2){
			System.out.println("Whoa!! Too much information!!");
		}else if(args[0].length()>1){
			System.out.println("No sneaky putting in too many letters!");
		}else{
			// do the math
			for(int x=0; x<fileContents.length(); x++){
				letterCount = fileContents.charAt(x);
				if(letterCount==letter){
					Tot++;
				} //closes if
			} //closes for
			// print output
			System.out.println(Tot + " occurences of " + letter + " occurred.");
		} //closes if
	} //closes main
} //closes class
