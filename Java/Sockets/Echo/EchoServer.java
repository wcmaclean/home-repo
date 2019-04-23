// Will MacLean
// CSPP 54001
// EchoServer.java

import java.net.*;
import java.io.*;

public class EchoServer{

	// variables for setting up sockets and streams 
	private int port;
	private ServerSocket aServerSocket;
	private Socket aClientSocket;
	private InputStream anInputStream;
	private OutputStream anOutputStream;
	
	// constructor 
	EchoServer(int port){
		this.port = port;
	} // close constructor 
	
	// go() routine to execute server  
	public void go() throws Exception{
		aServerSocket = new ServerSocket(port);
		System.out.println("EchoServer is running on port " + port);
		System.out.println("Awaiting connections...");
		
		// hook up clients as they pop up 
		while(true){
			Socket aClientSocket = aServerSocket.accept();
			new ClientThread(aClientSocket).start();
		} // close while() 
	} // close go()
	
	// got yer main here 
	public static void main(String[] args){
		EchoServer anEchoServer = new EchoServer(15674);
		try{
			anEchoServer.go();
		}catch(Exception e){
			System.out.println("Server Error: " + e);
		}
	} // close main() 
} // close EchoServer 

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
		String inputString;
		try{
			BufferedReader aBufferedInputReader = 
				new BufferedReader
					(new InputStreamReader(anInputStream));
			PrintWriter anOutputWriter = 
					new PrintWriter(anOutputStream);
			while(true){
				inputString = aBufferedInputReader.readLine();
				System.out.println(inputString);
				anOutputWriter.println(inputString);
				anOutputWriter.flush();
				if(inputString.equalsIgnoreCase("end")){
					System.out.println("Shutting down.");
					System.out.println("Closing connection.");
					aClientSocket.close();
					//break;
				}

			}
		}catch(Exception e){
			System.out.println("Stream Error: " + e);
		}
	}
		
		
} // close ClientThread 

