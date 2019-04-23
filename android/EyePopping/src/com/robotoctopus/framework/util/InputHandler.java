package com.robotoctopus.framework.util;

import com.robotoctopus.eyepopping.game.state.State;
import com.robotoctopus.eyepopping.main.GameMainActivity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class InputHandler implements OnTouchListener{
	
	private State currentState;
	
	public void setCurrentState(State currentState){
		this.currentState=currentState;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int scaledX=(int)((event.getX()/v.getWidth()) * GameMainActivity.GAME_WIDTH);
		int scaledY=(int)((event.getY()/v.getHeight()) * GameMainActivity.GAME_HEIGHT);
		return currentState.onTouch(event, scaledX, scaledY);
	}

}
