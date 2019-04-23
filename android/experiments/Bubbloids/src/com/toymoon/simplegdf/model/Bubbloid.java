package com.toymoon.simplegdf.model;

import com.toymoon.simplegdf.Assets;

import android.graphics.Rect;

public class Bubbloid {
	private float x, y;
	private int width, height, velY;
	private Rect rect;
	private String direction="left"; // can also be "right"
	private int hMid = width/2;
	private int vMid = height/2;
	
	public int getHMid(){
		return this.hMid;
	}

	public int getVMid(){
		return this.vMid;
	}
	
	public Bubbloid(float x, float y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.vMid = this.width/2;
		this.hMid = this.height/2;
		rect=new Rect((int)x, (int)y, width, height);
	}
	
	public void update(float delta){
		if ((int)x<=0){
			direction="right";
		}
		if((int)x+width>=320){
			direction="left";
		}
		if(direction.equalsIgnoreCase("right")){
			x+=5 * delta;
		}
		if(direction.equalsIgnoreCase("left")){
			x-=5 * delta;
		}
		updateRect();
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

}
