package com.toymoon.snoblervsgrabler.model;


import java.util.ArrayList;

import com.toymoon.snoblervsgrabler.framework.util.RandomNumberGenerator;

import android.graphics.Rect;

public class Grabler extends GamePiece{
	
	private ArrayList<SpitUp> spittlesUp = new ArrayList<SpitUp>();
	int maxSpittles = 1;
	
	public Grabler(float x, float y, int width, int height){
		super(x, y, width, height);
		//rect=new Rect((int)x, (int)y, width, height);
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


 	public void spit() {
 		//CherryBomb cb = new CherryBomb((int)this.getMid() + 50, (int)this.getY() - 25);
 		SpitUp su = new SpitUp((int)this.getX()+((this.mid)-(this.mid/3)), (int)this.getY());
 		if(spittlesUp.size()<maxSpittles){
 			spittlesUp.add(su);
 		}
 	}

	public ArrayList<SpitUp> getSpittles() {
		return spittlesUp;
	}
	
	public void moreSpittles(){
		maxSpittles++;
	}

}
