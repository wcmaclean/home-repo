package com.toymoon.model;

import com.toymoon.framework.util.Painter;
import com.toymoon.framework.util.RandomNumberGenerator;
import com.toymoon.simplegdf.Assets;

import android.graphics.Rect;

public class Eyefrown extends GamePiece{
		
	public Eyefrown(float x, float y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void updateAnimation(float delta){
		Assets.eyefrownAnimation.update(delta);
	}
	
	public void renderGamePiece(Painter g){
		Assets.eyefrownAnimation.render(g, (int)getX(), 
				(int)getY(), getWidth(), getHeight());
	}
	
}
