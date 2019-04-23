package com.toymoon.model;


import android.graphics.Rect;
import android.util.Log;

public class Mermaid{
	
	private float x, y;
	private int width, height, velY;
	private Rect rect;
	private boolean gamePieceTouched = false;
	private int mid;
	
	
	
	public Mermaid(float x, float y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.mid=width/2;
		rect=new Rect((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public void centerOnFinger(int x){
		rect.set((int)x-mid, (int)y, (int)x+width, (int)y+height);
	}

	public void update(float delta){
		updateRect();
	}
	
	public void updateRect(){
		rect.set((int)x, (int)y, (int)x+width, (int)y+height);
		//rect.set((int)x, (int)y, width, height);
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
	
	public void moveX(float newX){
		if(newX>this.x+mid){
			this.x+=5;
		}
		if(newX<this.x+mid){
			this.x-=5;
		}
		//this.x = x-width;
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