// Will MacLean
// Homework 1 - The Reversi Game, stand-alone version
//
// This code is from scratch. I didn't get every bit of it working,  
// but moved on to the client-server version due to time constraints.

import java.io.*;
import java.util.*;

public class ReversiGame {

	/**
	 * This is a simple game of Reversi.
	 * It will run on it's own from the command line.
	 * 
	 * @param args
	 */
	
	// instance variables
	private static int maxX = 8, maxY = 8;
	private String[][] reversiBoard;
	private boolean gameOver;
	private String currentPlayer;
	private int x, y;
	
	// constructor
	ReversiGame(){
		reversiBoard = initReversiBoard();
		gameOver = false;
		currentPlayer = "X";
	}
	
	// accessors
	public String[][] getReversiBoard(){
		return this.reversiBoard;
	} 
	public boolean getGameOver(){
		return this.gameOver;
	} 
	public String getCurrentPlayer(){
		return this.currentPlayer;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public String getTheCoordinate(int a, int y){
		return this.reversiBoard[x][y];
	}
	
	// mutators
	public void setGameOver(boolean gameOver){
		gameOver = this.gameOver;
	}
	public void switchCurrentPlayer(){
		if (this.currentPlayer.equals("X")){
			this.currentPlayer = "O";
		}else{
			this.currentPlayer = "X";
		}
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void changeAnXYCoordinate(int x, int y, String currentPlayer){
		this.reversiBoard[x][y] = currentPlayer;
	} 
	
	// methods for the board
	public void reversingTheSpots(int x, int y, String currentPlayer){
		// straight up
		for (int x2 = x; x2 >= 0; x2--){  
			checkAndSwitch(x2, y, currentPlayer);
		}
		// up to the right
		for (int x2 = x, y2 = y; x2 >= 0 && y2< maxY; x2--, y2++){  
			checkAndSwitch(x2, y2, currentPlayer);
		}
		// to the right
		for (int y2 = y; y2 < maxY; y2++){  
			checkAndSwitch(x, y2, currentPlayer);
		}
		// down to the right
		for (int x2 = x, y2 = y; x2 < maxX && y2< maxY; x2++, y2++){  
			checkAndSwitch(x2, y2, currentPlayer);
		}
		// straight down
		for (int x2 = x; x2 < maxX; x2++){  
			checkAndSwitch(x2, y, currentPlayer);
		}
		// down to the left
		for (int x2 = x, y2 = y; x2 < maxX && y2 >= 0; x2++, y2--){  
			checkAndSwitch(x2, y2, currentPlayer);
		}
		// to the left
		for (int y2 = y; y2 >= 0; y2--){  
			checkAndSwitch(x, y2, currentPlayer);
		}
		// up to the left
		for (int x2 = x, y2 = y; x2 >= 0 && y2 >= 0; x2--, y2--){  
			checkAndSwitch(x2, y2, currentPlayer);
		}
	}
	public void checkAndSwitch(int x, int y, String currentPlayer){
		if(!this.reversiBoard[x][y].equals("*")){
			this.changeAnXYCoordinate(x, y, currentPlayer);
		}
	}
	
	public String[][] initReversiBoard(){
		String[][] reversiBoard = new String[maxX][maxY];
		// walk through the multidimenasional array - mostly to remember how
		for(int x = 0; x<maxX; x++){
			for(int y = 0; y<maxY; y++){
				reversiBoard[x][y] = "*";
			}
		}
		// setup centerpieces for beginning of game
		reversiBoard[3][3] = "X";
		reversiBoard[3][4] = "O";
		reversiBoard[4][3] = "O";
		reversiBoard[4][4] = "X";
		return reversiBoard;
	}
	public static String toString(String[][] reversiBoard){
		String reversiBoardString = 
			" " + "0" + "1" + "2" + "3" + "4" + "5" + "6" + "7" + " " + "y-axis" + "\n" +
			"0" + reversiBoard[0][0] + reversiBoard[0][1] + reversiBoard[0][2]+ reversiBoard[0][3]+ reversiBoard[0][4]+ reversiBoard[0][5]+ reversiBoard[0][6]+ reversiBoard[0][7]+ "\n" + 
			"1" + reversiBoard[0][1] + reversiBoard[1][1] + reversiBoard[1][2]+ reversiBoard[1][3]+ reversiBoard[1][4]+ reversiBoard[1][5]+ reversiBoard[1][6]+ reversiBoard[1][7]+ "\n" + 
			"2" + reversiBoard[0][2] + reversiBoard[2][1] + reversiBoard[2][2]+ reversiBoard[2][3]+ reversiBoard[2][4]+ reversiBoard[2][5]+ reversiBoard[2][6]+ reversiBoard[2][7]+ "\n" + 
			"3" + reversiBoard[0][3] + reversiBoard[3][1] + reversiBoard[3][2]+ reversiBoard[3][3]+ reversiBoard[3][4]+ reversiBoard[3][5]+ reversiBoard[3][6]+ reversiBoard[3][7]+ "\n" + 
			"4" + reversiBoard[0][4] + reversiBoard[4][1] + reversiBoard[4][2]+ reversiBoard[4][3]+ reversiBoard[4][4]+ reversiBoard[4][5]+ reversiBoard[4][6]+ reversiBoard[4][7]+ "\n" + 
			"5" + reversiBoard[0][5] + reversiBoard[5][1] + reversiBoard[5][2]+ reversiBoard[5][3]+ reversiBoard[5][4]+ reversiBoard[5][5]+ reversiBoard[5][6]+ reversiBoard[5][7]+ "\n" + 
			"6" + reversiBoard[0][6] + reversiBoard[6][1] + reversiBoard[6][2]+ reversiBoard[6][3]+ reversiBoard[6][4]+ reversiBoard[6][5]+ reversiBoard[6][6]+ reversiBoard[6][7]+ "\n" + 
			"7" + reversiBoard[0][7] + reversiBoard[7][1] + reversiBoard[7][2]+ reversiBoard[7][3]+ reversiBoard[7][4]+ reversiBoard[7][5]+ reversiBoard[7][6]+ reversiBoard[7][7]+ "\n" + 
			"x-axis"
			;
		return reversiBoardString;	
	}
	
	// endgame methods
	public boolean isGameOver(){
		System.out.print("Do you want to end the game now? Enter 'Y' if yes. ");
		String input = getKeyInput();
	    if (input.equals("Y")){
	    	return true;
	    }else{
	    	return false;
	    }
	}
	
	// input methods
	public int getX(String currentPlayer){
		int x = getCoordinate(currentPlayer, "x");
		return x;
	}
	public int getY(String currentPlayer){
		int y = getCoordinate(currentPlayer, "y");
		return y;
	}	
	public int getCoordinate(String currentPlayer, String coordinate){
		int aNumber = 0;
		String input;
		boolean dataIsSafe = false;
		while(dataIsSafe == false){
			System.out.println("Player " + currentPlayer + ", please enter an "+ coordinate + "-coordinate: ");
			input = getKeyInput();
			if(checkIfInputIfNumber(input) == true){
				aNumber = Integer.parseInt(input);
				if (aNumber <= maxX || aNumber <= maxY){
					dataIsSafe = true;
				}
			}
		}
		return aNumber;
	}
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
	public boolean checkIfInputIfNumber(String anInput){
		char charInput = anInput.charAt(0);
	    if (Character.isDigit(charInput)) {
		      return true;
		}
		return false;
	}
	public boolean checkingForNeighbors(int x, int y){
		boolean spotNextDoor = false;
		// looking for at least one adjacent spot with X or O
		if (x > 0 && x+1 < maxX && y > 0 && y+1 < maxY){
			if (!this.reversiBoard[x-1][y].equals("*") || // check straight up
				!this.reversiBoard[x-1][y+1].equals("*") || // check up to right
				!this.reversiBoard[x][y+1].equals("*") || // check to right
				!this.reversiBoard[x+1][y+1].equals("*") || // check down to right
				!this.reversiBoard[x+1][y+1].equals("*") || // check straight down
				!this.reversiBoard[x+1][y-1].equals("*") || // check down to left
				!this.reversiBoard[x][y-1].equals("*") || // check left
				!this.reversiBoard[x-1][y-1].equals("*") // check up to left
			){
				spotNextDoor = true;
			}else{
				System.out.println("No adjacent occupied spaces - try again.");
			}
		}
		return spotNextDoor;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// init game
		ReversiGame aReversiGame = new ReversiGame();

		while(aReversiGame.getGameOver() == false) {
			//display the board
			System.out.println(toString(aReversiGame.getReversiBoard()));
			
			// get x and y coordinates for current player's next move
			boolean goodMove = false;
			while(goodMove == false){
				aReversiGame.setX(aReversiGame.getX(aReversiGame.getCurrentPlayer()));
				aReversiGame.setY(aReversiGame.getY(aReversiGame.getCurrentPlayer()));
				String whatIsThere = aReversiGame.getTheCoordinate(
						aReversiGame.getX(), 
						aReversiGame.getY());
				if(whatIsThere.equals("X") || whatIsThere.equals("O")){
					goodMove = false;
					System.out.println("That spot is taken - try again.");
				}else{
					if (aReversiGame.checkingForNeighbors(
							aReversiGame.getX(), 
							aReversiGame.getY()) 
							== true){
						goodMove = true;
					}
				}
			}
					
			// finally, if the spot if good, change the spot
			aReversiGame.changeAnXYCoordinate(
					aReversiGame.getX(), 
					aReversiGame.getY(), 
					aReversiGame.getCurrentPlayer()
			);
			
			// check all adjacent spots and reverse them
			aReversiGame.reversingTheSpots(
					aReversiGame.getX(), 
					aReversiGame.getY(), 
					aReversiGame.getCurrentPlayer()
			);
			
			// change player after move
			aReversiGame.switchCurrentPlayer();
			
			// check to end game
			//aReversiGame.setGameOver(aReversiGame.isGameOver());
		}
	}

}
