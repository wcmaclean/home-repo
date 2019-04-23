package com.toymoon.model;

import com.toymoon.simplegdf.Assets;

import android.graphics.Rect;

import com.toymoon.framework.util.Painter;
import com.toymoon.framework.util.RandomNumberGenerator;

public class GamePiece {
	private float x, y;
	private int width, height, velY;
	private Rect rect;
	private int mid;
	private int veloX = 10;
	private int veloY = 10;
	private boolean gotHit = false;
	public int maxY=480;
	
	private RandomNumberGenerator rndNumGen = new RandomNumberGenerator();
	
	public GamePiece(){
		
	}
	
	public GamePiece(float x, float y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.mid = width/2;
		rect=new Rect((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public void update(float delta){
		moveY();
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
	
	public void moveX(){
		this.x+=veloX;
		//updateRect();
	}

	public void moveY(){
		this.y+=veloY;
		//updateRect();
	}
	
	/*
	public boolean moveY(){
		this.y+=veloY;
		updateRect();
		if(y>=maxY){
			reset();
			if(this.gotHit==false){
				return false;
			}
		}
		return true;
	}
	*/
	
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
	
	public void setGotHit(){
		this.gotHit=true;
	}
	
	public boolean getGotHit(){
		return this.gotHit;
	}
	
	public void reset(){
		this.gotHit=false;
		// going negative on rnd nums on y to try and stagger them
		this.veloY=rndNumGen.getRandIntBetween(5, 10);
		//this.y=(-rndNumGen.getRandInt(200)); 
		this.y=0;
		this.x=rndNumGen.getRandInt(260);
	}
	
	public void updateAnimation(float delta){
		// override for each class
	}
	
	public void renderGamePiece(Painter g){
		// override for each class
	}
}
