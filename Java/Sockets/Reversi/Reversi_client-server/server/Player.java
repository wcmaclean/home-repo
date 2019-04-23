// Will MacLean
//
// Modified from Prof. Siegel's version online.


import java.net.*;
import java.io.*;

public class Player extends Thread{
	
	// variables
	private Socket aSocket;
	private DataInputStream input;
	private DataOutputStream output;
	private ReversiServer aReversiServer;
	private int number;
	private String mark;
	protected boolean threadSuspended = true;
	private boolean goodMove;
	
	// constructor
	public Player(	Socket aSocket, 
					ReversiServer aReversiServer, 
					int num, 
					String mark){
		this.mark = mark;
		this.aSocket = aSocket;
		this.aReversiServer = aReversiServer;
		this.number = num;
		
		// connect the streams and sockets
		try {
			input = new DataInputStream(aSocket.getInputStream());
			output = new DataOutputStream(aSocket.getOutputStream());
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void otherPlayerMoved(int x, int y){
		try{
			System.out.println("Writing to player " + number);
			output.writeUTF("Opponent moved");
			output.writeInt(x);
			output.writeInt(y);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		boolean done = false;
		try{
			System.out.println("in Player run()");
			aReversiServer.display("Player " + 
					(number == 0 ? 'X' : 'O') + " is connected.");
			output.writeUTF(mark);
			output.writeUTF(aReversiServer.displayBoard());
			output.writeUTF("Waiting for another player...");
			
			// waiting for another player
			if(mark.equals("X")){
				try {
					synchronized(this){
						while(threadSuspended){
							wait();
						}
					}
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				output.writeUTF("Other player connected... your move.");
				output.writeUTF("Opponent moved");
				output.writeUTF(aReversiServer.displayBoard());
			}
			
			// Working in the game logic
			// int specifies next move
			while(!done){			
				goodMove = false;
				while(goodMove == false){
					output.writeUTF("Enter an x-coordinate:");
					int xLoc = input.readInt();
					int yLoc = input.readInt();
					System.out.println(xLoc + " " + yLoc);
					if (aReversiServer.validMove(xLoc, yLoc)){
						output.writeUTF(aReversiServer.displayBoard());
						goodMove = true;
					}
				}
				
				//aSocket.close();
			}
			
		}catch (IOException e){}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
