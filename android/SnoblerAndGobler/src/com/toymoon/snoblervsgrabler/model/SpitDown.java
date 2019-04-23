package com.toymoon.snoblervsgrabler.model;

import android.graphics.Rect;

public class SpitDown extends Spit{

	public SpitDown(int startX, int startY){
		super(startX, startY);
	}
	
	public void update(float delta){
		this.y += speedY*delta;
		if (this.y > 800){
			this.visible = false;
		}
		updateRect();
	}
	
}
