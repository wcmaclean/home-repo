package com.toymoon.snoblervsgrabler.model;

import android.graphics.Rect;

public class SpitUp extends Spit{

	int speedY = 10;
	
	public SpitUp(int startX, int startY){
		super(startX, startY);
	}
	
	public void update(float delta){
		this.y -= speedY*delta;
		if (this.y <0){
			this.visible = false;
		}
		updateRect();
	}
	
}