package com.toymoon.snoblervsgrabler.model;

import android.graphics.Rect;

import com.toymoon.snoblervsgrabler.framework.util.RandomNumberGenerator;

public class Bubble extends GamePiece{
	
	int minX = 0;
	int minY = 0;
	int maxX = 450;
	int maxY = 800;
	int dx = 5;
	int dy = 5;

	
	public Bubble(){
		this.x = RandomNumberGenerator.getRandInt(maxX);
		this.y = RandomNumberGenerator.getRandInt(maxY);
		this.width = 221/5;
		this.height = 221/5;
		this.rect=new Rect((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public void reset(){
		this.x = RandomNumberGenerator.getRandInt(maxX);
		this.y = RandomNumberGenerator.getRandInt(maxY);
		this.width = 221/5;
		this.height = 221/5;
		this.rect=new Rect((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public void move(){
		x += dx;
		y += dy;
		if(this.x < minX){
			x = minX;
			dx = -dx;
		}
		if(this.x+this.width > maxX){
			x = maxX-this.width;
			dx = -dx;
		}
		if(this.y < minY){
			y = minY;
			dy = -dy;
		}
		if(this.y+this.height >= maxY){
			y = maxY - this.height;
			dy = -dy;
		}
		updateRect();
	}

}
