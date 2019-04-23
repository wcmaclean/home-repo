import java.lang.reflect.Array;

public class Uppercase {

	/**
	 * Class Uppercase loads a file, then walks through
	 * it to convert any lowercase letters appearing after
	 * a period to uppercase. It is run from the command
	 * line as follows:
	 * 
	 * java Uppercase <filename>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = args[0];
		String fileContents = TextManipTools.readFile(filename);
		int arraySize = fileContents.length();
		char[] fileArray = new char[arraySize+10];
		fileArray = fileContents.toCharArray();
		
		System.out.println();
		System.out.println();
		System.out.println("BEFORE:");
		for(int x=0; x<(arraySize); x++){
			System.out.print(fileArray[x]);
		}
		
		// iterate the array
		for(int x=0; x<Array.getLength(fileArray); x++){
			// test if char is "."
			if(fileArray[x]=='.' && x<(arraySize-2)){
				int y = x;
				if(y<(arraySize-2)){
					for( ; !Character.isLetter(fileArray[y]) && y<(arraySize-2); ++y){
						//this is just to get past white spaces
					}
					if(Character.isLowerCase(fileArray[y])){
						fileArray[y]=Character.toUpperCase(fileArray[y]);							
					}
				}					
			}
		} //closes for

		//Print the new text
		System.out.println();
		System.out.println();
		System.out.println("AFTER:");
		for(int x=0; x<(arraySize); x++){
			System.out.print(fileArray[x]);
		}
		System.out.println();
	}// closes main
}// closes class

//methods I may need...
//toCharArray() 
//isLetter(char ch) 
//equals(Object obj) 
//isLowerCase(char ch) 
//toUpperCase(char ch) 
//isSpaceChar(char ch) 
//isSpaceChar(int codePoint) 
//toChars(int codePoint)	
//valueOf(char c)
//isWhitespace(char ch) 

