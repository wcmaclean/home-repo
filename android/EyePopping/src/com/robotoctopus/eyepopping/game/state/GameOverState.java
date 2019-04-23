package com.robotoctopus.eyepopping.game.state;


import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.framework.util.UIButton;
import com.robotoctopus.eyepopping.main.Assets;
import com.robotoctopus.eyepopping.main.GameMainActivity;

/**
 * The page that displays at the end of the game. 
 * It shows the last score, and the high score.
 * @author wmaclean
 *
 */
public class GameOverState extends State {
	private UIButton goButton;
	private String playerScore;
	private String gameOverMessage = "Game Over";
	private int horizontalCenter;
	private int verticalCenter;
	
	/**
	 * Initializes the game over screen with the latest score.
	 * Checks if the new score is also a new high score, and records it if it is.
	 * @param playerScore
	 */
	public GameOverState(int playerScore){
		this.playerScore = playerScore + "";
		if(playerScore > GameMainActivity.getHighScore()){
			GameMainActivity.setHighScre(playerScore);
			gameOverMessage = "High Score";
		}
		this.gameWdith = GameMainActivity.getGameWidth();
		this.gameHeight = GameMainActivity.getGameHeight();
		this.horizontalCenter = this.gameWdith/2;
		this.verticalCenter = this.gameHeight/2;		
	}
	
	@Override
	public void init() {
		goButton = new UIButton(200, 700, 250, 800, Assets.goUp, Assets.goDown);
		//goButton = new UIButton(50, 400, 250, 500, Assets.goUp, Assets.goDown);
	}

	//public void init(int GAME_WIDTH, int GAME_HEIGHT){
	//	this.GAME_HEIGHT = GAME_HEIGHT;
	//	this.GAME_WIDTH = GAME_WIDTH;
	//	this.horizontalCenter = this.GAME_WIDTH/2;
	//	this.verticalCenter = this.GAME_HEIGHT/2;
	//	init();
	//}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		//g.drawImage(Assets.background, 0, 0);
		g.setColor(Color.BLUE);
		g.setFont(Typeface.DEFAULT_BOLD, 50);
		g.drawString("GAME OVER", this.horizontalCenter-150, this.verticalCenter-100);
		g.drawString(playerScore, this.horizontalCenter-75, this.verticalCenter-50);
		g.setColor(Color.BLUE);
		g.drawString("High Score", this.horizontalCenter-150, this.verticalCenter+50);
		g.drawString(""+GameMainActivity.getHighScore(), this.horizontalCenter-75, this.verticalCenter+100);
		
		//g.drawString("Touch the screen", 200, 50);
		goButton.render(g);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		if(e.getAction()==MotionEvent.ACTION_DOWN){
			goButton.onTouchDown(scaledX, scaledY);
		}
		
		if(e.getAction()==MotionEvent.ACTION_UP){
			if(goButton.isPressed(scaledX, scaledY)){
				goButton.cancel();
				//Log.d("MenuState", "Play Button Pressed");
				setCurrentState(new PlayState(this.gameWdith, this.gameHeight));
			}else{
				goButton.cancel();
			}
			
		}
		
		return true;
	}

}
