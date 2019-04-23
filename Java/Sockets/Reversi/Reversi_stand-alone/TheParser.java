// borrowed from Prof. Siegel's code

import java.io.*;
import java.util.*;

public class TheParser{
    public static String getKeyInput(){
	String input = null;
	try{
	    BufferedReader in = 
		new BufferedReader(new InputStreamReader(System.in));
	    input = in.readLine();
	}
	catch (IOException ioe){
	    System.out.println(ioe);
	}
	return input;
    }
    
    public static String[] getTokens(String input){
    	int i = 0;
    	StringTokenizer st = new StringTokenizer(input);
    	int numTokens = st.countTokens();
    	String[] tokenList = new String[numTokens];
    	while (st.hasMoreTokens()){
    		tokenList[i] = st.nextToken();
    		i++;
    	}
    	return(tokenList);
    }
}
