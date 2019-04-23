// Will MacLean
// Homework 1 - The Reversi Server, sockets version
//
// I borrowed code from one of Prof. Seigel's TicTacToe servers 
// and tried to modify it to fit with my homegrown Reversi game.
//
// To change the port, modify the PORT variable

import java.net.*;
import java.io.*;

public class ReversiServer {
	
	// instance variables
	private ReversiGame aReversiGame;
	private boolean xMove;
	private Player players[];
	private ServerSocket aServer;
	private final int PORT = 4444;
	private int numPlayers;
	private int currentPlayer;
	
	// constructor
	public ReversiServer(){
		aReversiGame = new ReversiGame();
		xMove = true;
		numPlayers = 2;
		players = new Player[numPlayers];
		currentPlayer = 0;
		
		// creating server socket
		try {
			aServer = new ServerSocket(PORT, 2);
		}catch(IOException e){
				System.out.println(e);
				System.exit(1);
			}
		System.out.println("ReversiServer running - waiting for connections...");
	}
	
	// accessors
	public ReversiGame getAReversiGame(){
		return this.aReversiGame;
	}
	
	// to run the thing
	public void execute(){
		for (int i = 0; i < players.length; i++){
			
			try {
				Socket aSocket = aServer.accept();
				if (i==0){
					players[i] = new Player(aSocket, this, i, "X");
					players[i].start();
					//players[i].run();
					System.out.println("Player X is connected");
				}else if(i==1){
					players[i] = new Player(aSocket, this, i, "O");
					players[i].start();
					//players[i].run();
					System.out.println("Player O is connected");
				}else{
					// create an observer
				}
			}catch(IOException e){
				System.out.println(e);
				System.exit(1);
			}
		}
		synchronized (players[0]){
			players[0].threadSuspended = false;
			players[0].notify();
		}
	} // close execute()

	public String displayBoard(){
		String aString = aReversiGame.toString(
				aReversiGame.getReversiBoard());
		return aString;
	}
	
	public void display(String aString){
		System.out.println(aString);
	}
	
	public boolean validMove(int xLoc, int yLoc){
		boolean yes = false;
		if (!getAReversiGame().checkingTheSpot(xLoc, yLoc)){
			yes = true;
		}
		return yes;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReversiServer aReversiServer = new ReversiServer();
		aReversiServer.execute();

	}

}
