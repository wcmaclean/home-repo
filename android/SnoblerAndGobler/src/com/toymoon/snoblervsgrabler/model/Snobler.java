package com.toymoon.snoblervsgrabler.model;

import java.util.ArrayList;

import com.toymoon.snoblervsgrabler.framework.util.RandomNumberGenerator;

public class Snobler extends GamePiece{
	
	private ArrayList<SpitDown> spittlesDown = new ArrayList<SpitDown>();
	private int newSpittleDown;
	
	int maxSpittles = 5;
	
	int snoblerSpeed = 5;
	

	
	private String direction="left"; // can also be "right"
	
	public Snobler(float x, float y, int width, int height){
		super(x, y, width, height);
		//rect=new Rect((int)x, (int)y, width, height);
	}
	
	public void update(float delta){
		if ((int)x<=0){
			direction="right";
		}
		if((int)x+width>=450){
			direction="left";
		}
		if(direction.equalsIgnoreCase("right")){
			x+=snoblerSpeed * delta;
		}
		if(direction.equalsIgnoreCase("left")){
			x-=snoblerSpeed * delta;
		}
		updateRect();
		spit();
	}


 	public void spit() {
 		newSpittleDown = RandomNumberGenerator.getRandInt(10);
 		if((newSpittleDown<=0)&&(spittlesDown.size()<maxSpittles)){
 	 		SpitDown sd = new 
 	 				SpitDown((int)this.getX()+(this.getWidth()/2), (int)this.getY()+this.getHeight());
 	 		spittlesDown.add(sd);	
 		}
 	}
 	
 	public ArrayList<SpitDown> getSpittles(){
 		return this.spittlesDown;
 	}
 	
 	public void moreSpittles(){
 		maxSpittles+=2;
 	}
	
 	public void speedUp(){
 		snoblerSpeed+=2;
 	}
}
