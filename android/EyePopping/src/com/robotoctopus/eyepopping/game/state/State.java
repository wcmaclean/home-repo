package com.robotoctopus.eyepopping.game.state;

import android.view.MotionEvent;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.eyepopping.main.GameMainActivity;

public abstract class State {
	
	int gameWdith, gameHeight;
	
	public State(){
		
	}
	
	public State(int gameWidth, int gameHeight){
		this.gameWdith=gameWidth;
		this.gameHeight=gameHeight;
	}
	
	public void setCurrentState(State newState){
		GameMainActivity.sGame.setCurrentState(newState);
	}
	
	public abstract void init();
	
	public abstract void update(float delta);
	
	public abstract void render(Painter g);
	
	public abstract boolean onTouch(MotionEvent e, int scaledX, int scaledY);

}
