/*
  A class containing methods useful for manipulating
  text files
  1. readFileByLine: 
   reads the contents of a text file line by line
   and returns a String array representation, where
   each line is stored in an element of the array.
  2. readFile
   read the contents of a text file into a String
*/

import java.io.*;
import java.util.*;

public class TextManipTools{

    /*------------------------------------------------*/
    public static String[] readFileByLine(String fileName){
	ArrayList fileContents = new ArrayList();
	String[] f;
	String inputLine = new String();
	
	try{
	    BufferedReader bin = new BufferedReader(
			       new InputStreamReader(
				 new FileInputStream(
				     new File(fileName))));
	int line = 0;


	    while ((inputLine = bin.readLine()) != null){
		fileContents.add(inputLine);
		line++;
	    }
	}
	catch(Exception e){
	    System.out.println("An error occurred during file reading " + e);
	}
	
	f = new String[fileContents.size()];
	for (int i=0;i<fileContents.size();i++){
	    f[i] = (String) fileContents.get(i);
	}
	return ( f );
    }
    
    /*------------------------------------------------*/
    public static String readFile(String fileName){
	InputStream in = null;
	byte inputBuffer[] = null;;
	
	try{
	    in = new FileInputStream(new File(fileName));
	    inputBuffer = new byte[in.available()];
	    in.read(inputBuffer);
	}
	catch(Exception e){
	    System.out.println("An error occurred during file reading " + e);
	}
	return(new String(inputBuffer));

    }
    
    /*----just to test--------------------------------*/
    public static void main(String[] args){
	String filename = args[0];
	//String[] fileContents = TextManipTools.readFileByLine(filename);
	String fileContents = TextManipTools.readFile(filename);
	System.out.println( fileContents);
    }
}
