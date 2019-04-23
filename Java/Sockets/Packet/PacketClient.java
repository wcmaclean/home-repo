// Will MacLean
// CSPP 54001
// PacketClient.java

import java.net.*;
import java.io.*;


public class PacketClient{
	
	// the main 
	public static void main(String[] args){
	
		//  variables we'll need 
		int timeout = 5;
		int ackNackStatus = 0;
		int packetNumber = 0;

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
				int timer = 0;

				System.out.print("\nEnter stuff: ");
				String someInput = userInputReader.readLine();

				while(ackNackStatus==0 &&  timer < timeout){

					anOutputWriter.println(someInput);
					anOutputWriter.flush();
					String aReply = networkInputReader.readLine();

					if(someInput.equalsIgnoreCase("end")){
						System.out.println("Closing connection.");
						System.exit(0);
					}if(someInput.equalsIgnoreCase("z") || 
					    someInput.equalsIgnoreCase("cheeze") ||
					    someInput.equalsIgnoreCase("evil")
						){
						System.out.println("timer = " + timer);
						//timer++;
					}else{

						System.out.println("send pkt " 
							+ Integer.toString(packetNumber));
						anOutputWriter.println(Integer.toString(packetNumber));
						anOutputWriter.flush();
						String aNewReply = networkInputReader.readLine();
						//System.out.println(aNewReply);


						while(ackNackStatus==0 &&  timer < timeout){

							if(aNewReply.equalsIgnoreCase("0")){
								// NAK
								System.out.println("rcv NAK " 
									+ Integer.toString(packetNumber));
								System.out.println("resend " 
									+ Integer.toString(packetNumber));
							}else if(aNewReply.equalsIgnoreCase("1")){
								// ACK
								System.out.println("rcv ACK " 
									+ Integer.toString(packetNumber));
								System.out.println("packet complete " 
									+ Integer.toString(packetNumber));
								ackNackStatus = 1;
							}else{}

							// read again
							anOutputWriter.println(Integer.toString(packetNumber));
							anOutputWriter.flush();
							aNewReply = networkInputReader.readLine();
							
						}
					}

					timer++;
					if(timer >= timeout){
						System.out.println("Timed out");
					}

				}
				// new packet numbet, reset status
				packetNumber++;
				ackNackStatus = 0;

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

} // close PacketClient 