package com.toymoon.game.state;


import android.view.MotionEvent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;

import com.toymoon.framework.util.Painter;
import com.toymoon.framework.util.UIButton;
import com.toymoon.simplegdf.Assets;

public class MenuState extends State{
	
	// Declare Rect objects for buttons
	private UIButton goButton;
	private String title = "Bubbloids";

	@Override
	public void init() {
		goButton = new UIButton(50, 400, 250, 500, Assets.goUp, Assets.goDown);
	}
	
	public void init(int GAME_WIDTH, int GAME_HEIGHT){
		this.GAME_HEIGHT = GAME_HEIGHT;
		this.GAME_WIDTH = GAME_WIDTH;
		init();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background, 0, 0);
		renderTitle(g);
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
	
	private void renderTitle(Painter g){
		g.setFont(Typeface.SANS_SERIF, 50);
		g.setColor(Color.RED);       // hor  ver
		g.drawString(""+title, 20, 75);
	}

}
