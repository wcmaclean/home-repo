package com.toymoon.spacefoodfight.simplegdf.model;

import com.toymoon.spacefoodfight.simplegdf.Assets;

import android.graphics.Rect;

public class GamePiece {
	private float x, y;
	private int width, height, velY;
	private Rect rect;
	private boolean gamePieceTouched = false;
	private int mid = width/2;
	
	
	public GamePiece(){
		
	}
	
	public GamePiece(float x, float y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		//rect=new Rect((int)x, (int)y, (int)x+width, (int)y+height);
		rect=new Rect((int)x, (int)y, (int)x+width, (int)y+height);
	}
/*	
	public void onTouchDown(int touchX, int touchY) {
		if (this.rect.contains(touchX, touchY)) {
			gamePieceTouched = true;
		} else {
			gamePieceTouched = false;
		}
	}
	
	public void cancel() {
		gamePieceTouched = false;
	}

	public boolean isPressed(int touchX, int touchY) {
		return gamePieceTouched;// && rect.contains(touchX, touchY);
	}
*/	
	public void update(float delta){
		updateRect();
	}
	
	public void updateRect(){
		//rect.set((int)x, (int)y, (int)x+width, (int)y+height);
		rect.set((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public void moveX(float x){
		this.x = x-(float)mid;
		updateRect();
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getVelY(){
		return velY;
	}
	
	public Rect getRect(){
		return rect;
	}

	public int getMid(){
		return mid;
	}
	
}
