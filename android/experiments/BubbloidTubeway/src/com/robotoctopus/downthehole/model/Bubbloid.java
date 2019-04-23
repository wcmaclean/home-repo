package com.robotoctopus.downthehole.model;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.framework.util.RandomNumberGenerator;
import com.robotoctopus.simpleandroidgdf.Assets;

public class Bubbloid extends GamePiece{
	
	private int veloY = 1;
	private int veloX = 1;
	private int angle = 3;


	public Bubbloid(float x, float y, int width, int height, int gameWidth, int gameHeight) {
		super(x, y, width, height, gameWidth, gameHeight);
	}
	
	public void updateAnimation(float delta){
		Assets.bubbloidAnimation.update(delta);
	}
	
	public void renderGamePiece(Painter g){
		Assets.bubbloidAnimation.render(g, (int)getX(), 
				(int)getY(), getWidth(), getHeight());
	}

	
}
