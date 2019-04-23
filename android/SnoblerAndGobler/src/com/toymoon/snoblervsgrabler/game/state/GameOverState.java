package com.toymoon.snoblervsgrabler.game.state;


import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;

import com.toymoon.snoblervsgrabler.Assets;
import com.toymoon.snoblervsgrabler.GameMainActivity;
import com.toymoon.snoblervsgrabler.framework.util.Painter;
import com.toymoon.snoblervsgrabler.framework.util.UIButton;


public class GameOverState extends State {
	private UIButton goButton;
	private String playerScore;
	private String gameOverMessage = "Game Over";
	private int horizontalCenter;
	private int verticalCenter;
	
	public GameOverState(int playerScore){
		this.playerScore = playerScore + "";
		if(playerScore > GameMainActivity.getHighScore()){
			GameMainActivity.setHighScre(playerScore);
			gameOverMessage = "High Score";
		}
		this.GAME_WIDTH = GameMainActivity.getGameWidth();
		this.GAME_HEIGHT = GameMainActivity.getGameHeight();
		this.horizontalCenter = this.GAME_WIDTH/2;
		this.verticalCenter = this.GAME_HEIGHT/2;		
	}
	
	@Override
	public void init() {
		goButton = new UIButton(200, 700, 254, 790, Assets.goUp, Assets.goDown);
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
		g.setColor(Color.WHITE);
		g.setFont(Typeface.DEFAULT_BOLD, 50);
		g.drawString("GAME OVER", this.horizontalCenter-150, this.verticalCenter-100);
		g.drawString(playerScore, this.horizontalCenter-75, this.verticalCenter-50);
		//g.setColor(Color.BLUE);
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
				setCurrentState(new PlayState());
			}else{
				goButton.cancel();
			}
			
		}
		
		return true;
	}

}
