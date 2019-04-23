// Will MacLean
// Homework 1 - The Reversi Client, sockets version
//
// I borrowed code from one of Prof. Siegel's TicTacToe clients 
// and tried to modify it to fit with my homegrown Reversi game.
//
//To change the port or host, change the PORT or HOST variables.


import java.io.*;
import java.net.*;

public class ReversiClient extends Thread{
	
	// variables
	private final int PORT = 4444;
	private final String HOST = "localhost";
	private DataInputStream input = null;
	private DataOutputStream output = null;
	private boolean myMove;
	private String mark;
	
	// mutators
	public void changeMyMove(boolean myMove){
		this.myMove = myMove;
	}
	
	public void go() throws Exception{
		Socket aSocket = new Socket(HOST, PORT);
		input = new DataInputStream(aSocket.getInputStream());
		output = new DataOutputStream(aSocket.getOutputStream());
		start();
		
		while(true){
			// getting x-coordinate prompt, then requesting...
			System.out.print("Enter an x-coordinate: ");
			String xMove = TheParser.getKeyInput();
			if(xMove.equals("")) continue;
			
			// getting y-coordinate
			System.out.print("Enter a y-coordinate: ");
			String yMove = TheParser.getKeyInput();
			if(yMove.equals("")) continue;
			if(!myMove){
				System.out.println("Please wait until the other player is finished.");
			}else{
				output.writeInt(Integer.parseInt(xMove));
				output.writeInt(Integer.parseInt(yMove));
				String theBoard = new String();
				theBoard = input.readUTF();
				System.out.println(theBoard);
			}
		}
	} 

	public void run(){
		try {
System.out.println("got here");
			mark = input.readUTF();
			myMove = (mark.equals("X") ? true : false);
			System.out.println("You are player " + mark + "\n");
		}catch(IOException e){
			// catch it
		}
		while(true){
			try{
				String message = input.readUTF();
				process(message);
			}catch(IOException e){
				// catch 
			}
		}
	}
	
	private void process(String aString){
		if (aString.equals("Valid move.")){
			System.out.println(aString);
			myMove = false;
		}else if (aString.equals("Invalid. Try again.")){
			System.out.println(aString);
		}else if (aString.equals("Opponent moved")){
			try {
				int location = input.readInt();
				System.out.println("Opponent done. Your turn...\n");
				
				myMove = true;
			}catch (IOException e){
				e.printStackTrace();
			}
		}else{
			System.out.println(aString);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ReversiClient aReversiClient = new ReversiClient();
		aReversiClient.go();
	}
}
