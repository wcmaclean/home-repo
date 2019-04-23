package com.toymoon.simplegdf.model;

import com.toymoon.framework.util.RandomNumberGenerator;

import android.graphics.Rect;

public class Eyefrown {
	
	private float x, y;
	private int width, height, velY;
	private Rect rect;
	private boolean gamePieceTouched = false;
	private int mid = width/2;
	private String direction="left"; // can also be "right"
	private int changeDirection;
	private int randomNonRandomMoves = 0;

	private int hMid = width/2;
	private int vMid = height/2;
	
	public int getHMid(){
		return this.hMid;
	}

	public int getVMid(){
		return this.vMid;
	}
	
	public Eyefrown(float x, float y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.vMid = this.width/2;
		this.hMid = this.height/2;
		//rect=new Rect((int)x, (int)y, (int)x+width, (int)y+height);
		rect=new Rect((int)x, (int)y, width, height);
	}
	public void update(float delta){
		changeDirection = RandomNumberGenerator.getRandInt(2);
		//Log.d("changeDirection", ""+changeDirection);
		if(((int)x<=0)){
			direction="right";
			randomNonRandomMoves = RandomNumberGenerator.getRandInt(50);
		}else if((int)x+width>=320){
			direction="left";
			randomNonRandomMoves = RandomNumberGenerator.getRandInt(50);
		}else if ((changeDirection==0)
				&&(randomNonRandomMoves<=0)){
			direction="right";
		}else if((changeDirection==1)
				&&(randomNonRandomMoves<=0)){
			direction="left";
		}
		if(direction.equalsIgnoreCase("right")){
			x+=10 * delta;
			randomNonRandomMoves=randomNonRandomMoves-10;
		}
		if(direction.equalsIgnoreCase("left")){
			x-=10 * delta;
			randomNonRandomMoves=randomNonRandomMoves-10;
		}
	}
	
	public void updateRect(){
		//rect.set((int)x, (int)y, (int)x+width, (int)y+height);
		rect.set((int)x, (int)y, width, height);
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
