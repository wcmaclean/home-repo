package com.spacegame.simplegdf.model;

import android.graphics.Rect;
import android.util.Log;


// see:
//http://www.kilobolt.com/day-7-shooting-bullets/unit-2-day-7-shooting-bullets

public class FruitBomb {

	private int x, y, width=40, height=40, speedY;
	private boolean visible;
	private Rect rect;

	public FruitBomb(int startX, int startY){
			x = startX;
			y = startY;
			speedY = 7;
			visible = true;
			rect = new Rect(x, y, x+width, y+height);
	}

	public FruitBomb(int startX, int startY, int width, int height){
		x = startX;
		y = startY;
		width = width;
		height = height;
		speedY = 1;
		visible = true;
		rect = new Rect(startX, startY, x+width, y+height);
}
	
	public void update(float delta){
		y += speedY*delta;
		if (y > 480){
			visible = false;
		}
		updateRect();
	}
	
	public void updateRect(){
		rect.set(x, y, x+width, y+height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public int getSpeedY() {
		return speedY;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setWdith(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void setRect(Rect rect){
		this.rect = rect;
	}
	
	public Rect getRect(){
		return rect;
	}

}