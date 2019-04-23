package com.toymoon.spacefoodfight.simplegdf.model;

import java.util.ArrayList;

import android.graphics.Rect;

public class Spaceship extends GamePiece{
	
	private ArrayList<CherryBomb> cherryBombs = new ArrayList<CherryBomb>();
	
	public Spaceship(float x, float y, int width, int height){
		super(x, y, width, height);
		//rect=new Rect((int)x, (int)y, width, height);
	}
 	public void shoot() {
 		//CherryBomb cb = new CherryBomb((int)this.getMid() + 50, (int)this.getY() - 25);
 		CherryBomb cb = new CherryBomb((int)this.getX(), (int)this.getY());
 		cherryBombs.add(cb);
 	}

	public ArrayList getCherryBombs() {
		return cherryBombs;
	}

}
