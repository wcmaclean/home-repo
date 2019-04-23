package com.robotoctopus.game.state;

import android.view.MotionEvent;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.simpleandroidgdf.Assets;

public class LoadState extends State {
	
	public LoadState(int gameWidth, int gameHeight){
		super(gameWidth, gameHeight);
	}

	@Override
	public void init() {
		Assets.load();
	}

	@Override
	public void update(float delta) {
		setCurrentState(new MenuState(this.gameWdith, this.gameHeight));
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
