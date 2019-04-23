package com.toymoon.game.state;

import android.view.MotionEvent;

import com.toymoon.framework.util.Painter;
import com.toymoon.simplegdf.GameMainActivity;

public abstract class State {
	
	public void setCurrentState(State newState){
		GameMainActivity.sGame.setCurrentState(newState);
	}
	
	public abstract void init();
	
	public abstract void update(float delta);
	
	public abstract void render(Painter g);
	
	public abstract boolean onTouch(MotionEvent e, int scaledX, int scaledY);

}
