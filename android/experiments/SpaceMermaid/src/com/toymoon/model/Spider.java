package com.toymoon.model;

import com.toymoon.framework.util.Painter;
import com.toymoon.simplegdf.Assets;

public class Spider extends GamePiece {
	
	private int veloY = 15;
	
	public Spider(float x, float y, int width, int height) {
		super(x, y, width, height);
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
