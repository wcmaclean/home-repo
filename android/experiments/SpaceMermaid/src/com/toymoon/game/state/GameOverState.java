package com.toymoon.game.state;


import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;

import com.toymoon.framework.util.Painter;
import com.toymoon.framework.util.UIButton;
import com.toymoon.simplegdf.Assets;
import com.toymoon.simplegdf.GameMainActivity;

public class GameOverState extends State {
	private UIButton goButton;
	private String playerScore;

	public GameOverState(int playerScore){
		this.playerScore = playerScore + "";
	}
	
	@Override
	public void init() {
		goButton = new UIButton(50, 400, 250, 500, Assets.goUp, Assets.goDown);
	}


	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background, 0, 0);
		g.setColor(Color.DKGRAY);
		g.setFont(Typeface.DEFAULT_BOLD, 50);
		g.drawString("GAME OVER", 20, 50);
		g.drawString(playerScore, 40, 100);
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
