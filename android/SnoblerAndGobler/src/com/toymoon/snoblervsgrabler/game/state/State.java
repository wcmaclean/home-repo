package com.toymoon.snoblervsgrabler.game.state;

import android.view.MotionEvent;

import com.toymoon.snoblervsgrabler.GameMainActivity;
import com.toymoon.snoblervsgrabler.framework.util.Painter;

public abstract class State {
	
	int GAME_WIDTH;
	int GAME_HEIGHT;
	
	public void setCurrentState(State newState){
		GameMainActivity.sGame.setCurrentState(newState);
	}
	
	public abstract void init();
	
	//public abstract void init(int GAME_WIDTH, int GAME_HEIGHT);
	
	public abstract void update(float delta);
	
	public abstract void render(Painter g);
	
	public abstract boolean onTouch(MotionEvent e, int scaledX, int scaledY);
	
	public void onResume(){};
	
	public void onPause(){};

}
