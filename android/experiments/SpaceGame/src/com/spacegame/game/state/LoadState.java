package com.spacegame.game.state;


import android.view.MotionEvent;

import com.spacegame.framework.util.Painter;
import com.spacegame.simplegdf.Assets;

public class LoadState extends State {

	@Override
	public void init() {
		Assets.load();
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