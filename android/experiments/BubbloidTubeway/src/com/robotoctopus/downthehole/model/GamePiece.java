package com.robotoctopus.downthehole.model;

import com.robotoctopus.simpleandroidgdf.Assets;

import android.graphics.Rect;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.framework.util.RandomNumberGenerator;

public class GamePiece {
	private float x, y;
	private int width, height, velY;
	private Rect rect;
	private int mid;
	private boolean gotHit = false;
	public int maxY=480;
	
	//private RandomNumberGenerator rndNumGen = new RandomNumberGenerator();
	
	
	private int veloY = 1;
	private int veloX = 1;
	private int newVelo = 0;
	private int originalWidth;
	private int originalHeight;
	private int gameWidth;
	private int gameHeight;
	private int fieldCenterX;
	private int fieldCenterY;
	private int midWidth;
	private int midHeight;
	//private int bubbloidCenterX;
	//private int bubbloidCenterY;
	private String growOrShrink = "grow";
	private int angle = 3;
	
	private boolean reset = false;
	
	RandomNumberGenerator rnd = new RandomNumberGenerator();

	
	public GamePiece(){
		
	}
	
	public GamePiece(float x, float y, int width, int height, int gameWidth, int gameHeight){
		//this.x=x;
		//this.y=y;
		this.width=width;
		this.height=height;
		this.mid = width/2;
		this.gameWidth=gameWidth;
		this.gameHeight=gameHeight;
		this.originalHeight=height;
		this.originalWidth=width;
		this.midWidth=width/2;
		this.midHeight=height/2;
		this.fieldCenterX=gameWidth/2;
		this.fieldCenterY=gameHeight/2;
		this.angle = rnd.getRandIntBetween(1, 4);
		//this.bubbloidCenterX=this.fieldCenterX;
		//this.bubbloigCenterY=this.bubbloidCenterY;
		this.setX((float)this.fieldCenterX-this.midWidth);
		this.setY((float)this.fieldCenterY-this.midHeight);
		rect=new Rect((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public void shrink(){
		this.growOrShrink="shrink";
	}

	public void grow(){
		this.growOrShrink="grow";
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

	
	public void setWidth(int width){
		this.width=width;
	}
	
	public void setHeight(int height){
		this.height=height;
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
		//this.gotHit=false;
		this.height=this.originalHeight;
		this.width=this.originalWidth;
		this.setX((float)this.fieldCenterX-this.midWidth);
		this.setY((float)this.fieldCenterY-this.midHeight);
		this.grow();
		this.updateRect();
		angle = rnd.getRandIntBetween(1, 5);
		reset = false;
		newVelo = rnd.getRandIntBetween(1, 4);
		veloX = newVelo;
		veloY = newVelo;
		Assets.playSound(Assets.dropSound);
	}
	
	public void updateAnimation(float delta){
		// override for each class
	}
	
	public void renderGamePiece(Painter g){
		// override for each class
	}
	
	
	public void update(float delta){
		growXY();
		updateRect();
	}
	
	public void growXY(){
		//this.setX((float)this.getX()+this.veloX);
		//this.setY((float)this.getY()+this.veloY);

		if(angle==1){ // lower right
		//grow
			if(this.growOrShrink.equalsIgnoreCase("grow")){
				this.setWidth(this.getWidth()+this.veloX);
				this.setHeight(this.getHeight()+this.veloY);			
			} 
			//shrink
			if(this.growOrShrink.equalsIgnoreCase("shrink")){
				this.setWidth(this.getWidth()-this.veloX);
				this.setHeight(this.getHeight()-this.veloY);
			}
		}
		if(angle==2){ // upper left
		//grow
			if(this.growOrShrink.equalsIgnoreCase("grow")){
				this.setWidth(this.getWidth()+this.veloX);
				this.setHeight(this.getHeight()+this.veloY);		
				this.setX(this.getX()-this.veloX);
				this.setY(this.getY()-this.veloY);
			} 
			//shrink
			if(this.growOrShrink.equalsIgnoreCase("shrink")){
				this.setWidth(this.getWidth()-this.veloX);
				this.setHeight(this.getHeight()-this.veloY);
				this.setX(this.getX()+this.veloX);
				this.setY(this.getY()+this.veloY);
			}
		}
		if(angle==3){ // upper right
		//grow
			if(this.growOrShrink.equalsIgnoreCase("grow")){
				this.setWidth(this.getWidth()+this.veloX);
				this.setHeight(this.getHeight()+this.veloY);		
				//this.setX(this.getX()+this.veloX);
				this.setY(this.getY()-this.veloY);
			} 
			//shrink
			if(this.growOrShrink.equalsIgnoreCase("shrink")){
				this.setWidth(this.getWidth()-this.veloX);
				this.setHeight(this.getHeight()-this.veloY);
				//this.setX(this.getX()-this.veloX);
				this.setY(this.getY()+this.veloY);
			}
		}
		if(angle==4){ // lower left
		//grow
			if(this.growOrShrink.equalsIgnoreCase("grow")){
				this.setWidth(this.getWidth()+this.veloX);
				this.setHeight(this.getHeight()+this.veloY);		
				this.setX(this.getX()-this.veloX);
				this.setY(this.getY()+this.veloY);
			} 
			//shrink
			if(this.growOrShrink.equalsIgnoreCase("shrink")){
				this.setWidth(this.getWidth()-this.veloX);
				this.setHeight(this.getHeight()-this.veloY);
				this.setX(this.getX()+this.veloX);
				this.setY(this.getY()-this.veloY);
			}
		}
		
		// test if we should shrink
		if((angle==1)||(angle==3)){
			if((this.getWidth()+this.getX())>=this.gameWidth){
				//growOrShrink="shrink";
				reset();
			}
			// test if we should grow
			if((this.getWidth()+this.getX()<=this.fieldCenterX)){
				reset = true;
				growOrShrink="grow";
			}
		}
		// test if we should shrink
		if((angle==2)||(angle==4)){
			if((this.getX()<=0)){
				//growOrShrink="shrink";
				reset();
			}
			// test if we should grow
			if((this.getX()>=this.fieldCenterX)){
				reset = true;
				growOrShrink="grow";
			}
		}
		if(reset==true){ 
			angle = rnd.getRandIntBetween(1, 4);
			reset = false;
			newVelo = rnd.getRandIntBetween(1, 3);
			veloX = newVelo;
			veloY = newVelo;
		}
	}
}
