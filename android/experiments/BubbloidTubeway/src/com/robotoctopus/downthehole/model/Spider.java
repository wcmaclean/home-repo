package com.robotoctopus.downthehole.model;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.simpleandroidgdf.Assets;


public class Spider extends GamePiece {
	
	private int veloY = 15;
	
	public Spider(float x, float y, int width, int height, int gameWidth, int gameHeight) {
		super(x, y, width, height, gameWidth, gameHeight);
	}
	
	public void updateAnimation(float delta){
		Assets.spiderAnimation.update(delta);
	}
	
	public void renderGamePiece(Painter g){
		Assets.spiderAnimation.render(g, (int)getX(), 
				(int)getY(), getWidth(), getHeight());
		//g.drawRect(spider.getRect());
	}

}
