// Will MacLean
// CSPP 54001
// PacketServer.java

import java.net.*;
import java.io.*;

// messages
// ---------
// rcv pkt 0
// send ACK 0
// fail pkt 0
// send NAK 0


public class PacketServer{

	// variables for setting up sockets and streams 
	private int port;
	private ServerSocket aServerSocket;
	private Socket aClientSocket;
	private InputStream anInputStream;
	private OutputStream anOutputStream;
	
	// constructor 
	PacketServer(int port){
		this.port = port;
	} // close constructor 
	
	// go() routine to execute server  
	public void go() throws Exception{
		aServerSocket = new ServerSocket(port);
		System.out.println("PacketServer is running on port " + port);
		System.out.println("Awaiting connections...");
		
		// hook up clients as they pop up 
		while(true){
			Socket aClientSocket = aServerSocket.accept();
			new ClientThread(aClientSocket).start();
		} // close while() 
	} // close go()
	
	// got yer main here 
	public static void main(String[] args){
		PacketServer aPacketServer = new PacketServer(15674);
		try{
			aPacketServer.go();
		}catch(Exception e){
			System.out.println("Server Error: " + e);
		}
	} // close main() 
} // close PacketServer 

class ClientThread extends Thread{
		
	// threading variables 
	private Socket aClientSocket;
	private InputStream anInputStream;
	private OutputStream anOutputStream;
		
	// constructor 
	ClientThread(Socket aClientSocket){
		this.aClientSocket = aClientSocket;
		try{
			anInputStream = aClientSocket.getInputStream();
			anOutputStream = aClientSocket.getOutputStream();
		}catch(Exception e){
			System.out.println("Thread Error: " + e);
		}
	}
	
	// the run() routine 
	public void run(){
		int anAckOrNak;
		String inputString;
		try{
			BufferedReader aBufferedInputReader = 
				new BufferedReader
					(new InputStreamReader(anInputStream));
			PrintWriter anOutputWriter = 
					new PrintWriter(anOutputStream);
			while(true){
				inputString = aBufferedInputReader.readLine();

				if(inputString.equalsIgnoreCase("end")){
					System.out.println("Shutting down.");
					System.out.println("Closing connection.");
					aClientSocket.close();
					System.exit(0);
				}


// stuff here
				// fake an ACK or NAK
				anAckOrNak = (int)(Math.random() * 2);
				System.out.println(anAckOrNak);


// messages
// ---------
// rcv pkt 0
// send ACK 0
// fail pkt 0
// send NAK 0
				// messaging based on status randomizer
				if(anAckOrNak==1){
					System.out.println("rcv pkt " + inputString);
					System.out.println("send ACK " + inputString);
				}else{
					System.out.println("fail pkt " + inputString);
					System.out.println("send NAK " + inputString);
				}

				

				//System.out.println(inputString);
				anOutputWriter.println(Integer.toString(anAckOrNak));
				anOutputWriter.flush();

			}
		}catch(Exception e){
			System.out.println("Stream Error: " + e);
		}

	}
		
		
} // close ClientThread 

// how to get random numbers
// int anAckOrNak = (int)(Math.random() * 2);