// Will MacLean
// CSPP 51037
// Homework 1
// SynthStoreServer class

import java.io.*;
import java.net.*;

public class SynthStoreClient{
	int PORT;
	String HOST;

	SynthStoreClient(String hostName, int portNumber){
		HOST = hostName;
		PORT = portNumber;
	} // end constructor
	
	public static void main(String[] args){
		new SynthStoreClient("localhost", 1492).letsDoThis();
	} // end main

	public void letsDoThis() {
		PrintWriter outWays = null;
		BufferedReader inWays = null;
		Socket sockIt = null;

		try{
			sockIt = new Socket(HOST, PORT);

//System.out.println("got here 1");

		}catch(IOException ioe){
			System.out.println("can't find host #"  + HOST);
			System.out.println(ioe);
		}
	
		try{
			inWays = new BufferedReader(new InputStreamReader(sockIt.getInputStream()));
			outWays = new PrintWriter(sockIt.getOutputStream(), true);

//System.out.println("got here 2");

		}catch (Exception ioe1){
			System.out.println("can't cross the streams");
			System.out.println(ioe1);
		}
		outWays.println("listing things");
		try{
			System.out.println(inWays.readLine());
		}catch (Exception ioe2){
			System.out.println("can't hear the server");
			System.out.println(ioe2);
		}
		finally{
			try{
				sockIt.close();
				inWays.close();
				outWays.close();
			}catch (Exception ioe3){
			}
		}
	} 


}  // end SynthStoreClient