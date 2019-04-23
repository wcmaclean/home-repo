package com.toymoon.snoblervsgrabler.model;

import android.graphics.Rect;

public class ProjectileDown extends GamePiece {
	
	int speedY = 2;
	

	
	
	public ProjectileDown(int startX, int startY){
			x = startX;
			y = startY;
			width=(117/5);
			height=(451/5);
			mid = width/2;
			speedY = 7;
			visible = true;
			rect = new Rect((int)x, (int)y, (int)width, (int)height);
	}

	
	public void update(float delta){
		this.y += speedY*delta;
		if (this.y > 800){
			this.visible = false;
		}
		updateRect();
	}
	


}
