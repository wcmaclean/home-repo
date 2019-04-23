package com.toymoon.model;

import com.toymoon.framework.util.Painter;
import com.toymoon.simplegdf.Assets;

public class Bubbloid extends GamePiece{
	
	private int veloY = 5;

	public Bubbloid(float x, float y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void updateAnimation(float delta){
		Assets.bubbloidAnimation.update(delta);
	}
	
	public void renderGamePiece(Painter g){
		Assets.bubbloidAnimation.render(g, (int)getX(), 
				(int)getY(), getWidth(), getHeight());
	}
	
}
