package com.spacegame.simplegdf.model;

import java.util.ArrayList;

import android.graphics.Rect;
import android.util.Log;

import com.spacegame.framework.util.RandomNumberGenerator;

public class Ufo extends GamePiece{
	

	private String direction="left"; // can also be "right"
	private int changeDirection;
	private int randomNonRandomMoves = 0;
	//private Rect rect;
	private ArrayList<FruitBomb> fruitBombs = new ArrayList<FruitBomb>();
	private int shootFruitBomb;
	
	public Ufo(float x, float y, int width, int height){
		super(x, y, width, height);
	}

	public void update(float delta){
		changeDirection = RandomNumberGenerator.getRandInt(2);
		//Log.d("changeDirection", ""+changeDirection);
		if(((int)getX()<=0)){
			direction="right";
			randomNonRandomMoves = RandomNumberGenerator.getRandInt(100);
		}else if((int)getX()+getWidth()>=320){
			direction="left";
			randomNonRandomMoves = RandomNumberGenerator.getRandInt(100);
		}else if ((changeDirection==0)
				&&(randomNonRandomMoves<=0)){
			direction="right";
		}else if((changeDirection==1)
				&&(randomNonRandomMoves<=0)){
			direction="left";
		}
		if(direction.equalsIgnoreCase("right")){
			setX(getX()+10*delta);
			randomNonRandomMoves=randomNonRandomMoves-10;
		}
		if(direction.equalsIgnoreCase("left")){
			setX(getX()-10*delta);
			randomNonRandomMoves=randomNonRandomMoves-10;
		}
		shoot();
	}

 	public void shoot() {
 		shootFruitBomb = RandomNumberGenerator.getRandInt(10);
 		if(shootFruitBomb<=0){
 	 		FruitBomb fb = new 
 	 				FruitBomb((int)this.getX()+(this.getWidth()/2), 
 	 							(int)this.getY()+this.getHeight());
 	 		fruitBombs.add(fb);	
 		}
 	}

	public ArrayList getFruitBombs() {
		return fruitBombs;
	}

}
