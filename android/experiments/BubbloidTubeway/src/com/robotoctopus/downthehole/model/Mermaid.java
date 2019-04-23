package com.robotoctopus.downthehole.model;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.simpleandroidgdf.Assets;


public class Mermaid extends GamePiece{
		
	public Mermaid(float x, float y, int width, int height, int gameWidth, int gameHeight) {
		super(x, y, width, height, gameWidth, gameHeight);
	}
	
	public void updateAnimation(float delta){
		Assets.eyefrownAnimation.update(delta);
	}
	
	public void renderGamePiece(Painter g){
		Assets.eyefrownAnimation.render(g, (int)getX(), 
				(int)getY(), getWidth(), getHeight());
	}
	
}