package com.toymoon.snoblervsgrabler.game.state;


import android.view.MotionEvent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;

import com.toymoon.snoblervsgrabler.Assets;
import com.toymoon.snoblervsgrabler.GameMainActivity;
import com.toymoon.snoblervsgrabler.framework.util.Painter;
import com.toymoon.snoblervsgrabler.framework.util.UIButton;

public class MenuState extends State{
	
	// Declare Rect objects for buttons
	private UIButton goButton;
	private String title = "Snobler and Gobler";
	private int horizontalCenter;
	private int verticalCenter;
	
	@Override
	public void init() {
		goButton = new UIButton(200, 700, 254, 790, Assets.goUp, Assets.goDown);
		
		this.GAME_WIDTH = GameMainActivity.getGameWidth();
		this.GAME_HEIGHT = GameMainActivity.getGameHeight();
		this.horizontalCenter = this.GAME_WIDTH/2;
		this.verticalCenter = this.GAME_HEIGHT/2;	
	}
	
	//public void init(int GAME_WIDTH, int GAME_HEIGHT){
	//	this.GAME_HEIGHT = GAME_HEIGHT;
	//	this.GAME_WIDTH = GAME_WIDTH;
	//	init();
	//}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background_title, 0, 0);
		//renderTitle(g);

		// beta
		//g.setFont(Typeface.DEFAULT_BOLD, 30);
		//g.setColor(Color.BLUE);
		//g.drawString("BETA", this.horizontalCenter-80, this.verticalCenter-50);
		
		// copyright
		g.setFont(Typeface.DEFAULT_BOLD, 15);
		g.setColor(Color.WHITE);
		g.drawString("Copyright 2018 Toy Moon", this.horizontalCenter-110, this.verticalCenter+220);
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
