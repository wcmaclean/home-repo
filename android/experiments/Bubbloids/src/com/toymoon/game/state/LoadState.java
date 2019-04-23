package com.toymoon.game.state;


import android.view.MotionEvent;

import com.toymoon.framework.util.Painter;
import com.toymoon.simplegdf.Assets;

public class LoadState extends State {

	@Override
	public void init() {
		Assets.load();
	}
	
	public void init(int GAME_WIDTH, int GAME_HEIGHT){
		this.GAME_HEIGHT = GAME_HEIGHT;
		this.GAME_WIDTH = GAME_WIDTH;
		init();
	}

	@Override
	public void update(float delta) {
		setCurrentState(new MenuState());
	}

	@Override
	public void render(Painter g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}