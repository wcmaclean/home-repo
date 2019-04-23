package com.toymoon.simplegdf.model;

import android.graphics.Rect;
import android.util.Log;

public class Bubble {
	
	private float x, y;
	private int width, height, velY;
	private Rect rect;
	private int mid = width/2;
	
	public Bubble(float x, float y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		rect=new Rect((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public void update(float delta, float velX){
		y+=10 * delta;
		//Log.d("UpdateBubbleY", ""+this.getY());
		updateRect();
	}
	
	public void update(float delta){
		y+=10 * delta;
		//Log.d("UpdateBubbleY", ""+this.getY());
		updateRect();
	}
	
	public void updateRect(){
		rect.set((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public void reset(float x, float y){
		this.setX(x);
		this.setY(y);
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
		//this.x = x-(float)mid;
		//updateRect();
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
