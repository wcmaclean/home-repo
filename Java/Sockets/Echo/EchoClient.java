// Will MacLean
// CSPP 54001
// EchoClient.java

import java.net.*;
import java.io.*;

public class EchoClient{
	
	// the main 
	public static void main(String[] args){
	
		//  variables we'll need 
		String hostname = "localhost";
		PrintWriter anOutputWriter = null;
		BufferedReader networkInputReader = null;
		BufferedReader userInputReader = null;

		// use an IP Address from command line input 
		if(args.length>0){
			hostname = args[0];		
		}
		
		// see if we can connect 
		try{
			// set up the socket 
			Socket aSocket = new Socket(hostname, 15674);
			
			// cross the streams 
			networkInputReader = new BufferedReader
				(new InputStreamReader
					(aSocket.getInputStream()));
			userInputReader = new BufferedReader
				(new InputStreamReader
					(System.in));
			anOutputWriter = 
				new PrintWriter(aSocket.getOutputStream());
			System.out.println("Connected.");
			
			// take input, send to server 
			while(true){
				System.out.print("Enter stuff: ");
				String someInput = userInputReader.readLine();
				anOutputWriter.println(someInput);
				anOutputWriter.flush();
				String aReply = networkInputReader.readLine();
				System.out.println("Echo (echo) (echo): " + aReply);
				//if(aReply.equalsIgnoreCase("end")){
				//	System.out.println("Closing connection.");
				//	System.exit(0);
				//}
			}
			
		}catch(IOException e){
			System.out.println("IOError: " + e);
		}finally{
			try{
				if(networkInputReader != null){
					networkInputReader.close();
				}
				if(anOutputWriter != null){
					anOutputWriter.close();
				}
			}catch(IOException e){
				// do nothing 
			} 
		} // close finally
		
		
	} // close main 

} // close EchoClient 
