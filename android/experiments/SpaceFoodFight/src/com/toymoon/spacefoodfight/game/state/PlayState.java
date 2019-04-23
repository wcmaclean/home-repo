package com.toymoon.spacefoodfight.game.state;

import java.util.ArrayList;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import com.toymoon.spacefoodfight.framework.util.Painter;
import com.toymoon.spacefoodfight.framework.util.RandomNumberGenerator;
import com.toymoon.spacefoodfight.simplegdf.Assets;
import com.toymoon.spacefoodfight.simplegdf.model.CherryBomb;
import com.toymoon.spacefoodfight.simplegdf.model.FruitBomb;
import com.toymoon.spacefoodfight.simplegdf.model.Spaceship;
import com.toymoon.spacefoodfight.simplegdf.model.Ufo;

import android.graphics.Color;

public class PlayState extends State{

	private Spaceship spaceship;
	private Ufo ufo;
	//private CherryBomb cherryBomb;
	
	@Override
	public void init() {
		ufo = new Ufo(80, 0, 71, 156);
		spaceship = new Spaceship(0, 480-121, 87, 121);
	}

	@Override
	public void update(float delta) {
		Assets.ufoAnimation.update(delta);
		ufo.update(delta);

		Assets.spaceshipAnimation.update(delta);
		spaceship.update(delta);

		//updateCherryBombs();
		//updateFruitBombs();
		updateBombs(delta);
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background, 0, 0);
		renderUfo(g);
		renderSpaceship(g);
		renderCherryBombs(g);
		renderFruitBombs(g);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if(e.getAction() == MotionEvent.ACTION_MOVE) {
        	if((scaledY>(int)spaceship.getY())
        			||(scaledX>(int)spaceship.getX())
        			||(scaledX<(int)spaceship.getX()+spaceship.getWidth())){
				spaceship.moveX((float)scaledX);
				//Log.d("ScaledX", ""+scaledX);
			}
        }
        if(e.getAction() == MotionEvent.ACTION_UP){
        	// shoot
        	spaceship.shoot();
        	Assets.playSound(Assets.popSound);
        }
		return true;
	}
	
	private void renderUfo(Painter g){
		Assets.ufoAnimation.render(g, (int)ufo.getX(), 
				(int)ufo.getY(), ufo.getWidth(), ufo.getHeight());
		//g.drawRect(ufo.getRect());
	}

	private void renderSpaceship(Painter g){
		Assets.spaceshipAnimation.render(g, (int)spaceship.getX(), 
				(int)spaceship.getY(), spaceship.getWidth(), spaceship.getHeight());
	}
	
	private void updateCherryBombs(float delta){
		ArrayList cherryBombs = spaceship.getCherryBombs();
		for (int i = 0; i < cherryBombs.size(); i++) {
		CherryBomb cb = (CherryBomb) cherryBombs.get(i);
		if (cb.isVisible() == true) {
			cb.update(delta);
		} else {
			cherryBombs.remove(i);
		}
		}
	}
	
	private void renderCherryBombs(Painter g){
		ArrayList cherryBombs = spaceship.getCherryBombs();
		for (int i = 0; i < cherryBombs.size(); i++) {
		CherryBomb cb = (CherryBomb) cherryBombs.get(i);
		g.setColor(Color.RED);
			//g.fillRect(cb.getX(), cb.getY(), 10, 5);
			//g.fillRect(cb.getX(), cb.getY(), cb.getWidth(), cb.getHeight());
			//g.drawRect(cb.getRect());
			g.drawImage(Assets.cherry, cb.getX(), cb.getY());
		}
	}

	private void updateFruitBombs(float delta){
		ArrayList fruitBombs = ufo.getFruitBombs();
		for (int i = 0; i < fruitBombs.size(); i++) {
		FruitBomb fb = (FruitBomb) fruitBombs.get(i);
		if (fb.isVisible() == true) {
			fb.update(delta);
		} else {
			fruitBombs.remove(i);
		}
		}
	}
	
	private void renderFruitBombs(Painter g){
		ArrayList fruitBombs = ufo.getFruitBombs();
		for (int i = 0; i < fruitBombs.size(); i++) {
			FruitBomb fb = (FruitBomb) fruitBombs.get(i);
			g.setColor(Color.BLUE);
				//g.fillRect(fb.getX(), fb.getY(), 10, 5);
				//g.fillRect(fb.getX(), fb.getY(), fb.getWidth(), fb.getHeight());
				//g.drawRect(fb.getRect());
				g.drawImage(Assets.blueberry, fb.getX(), fb.getY());
		}
	}
	
	private void updateBombs(float delta){
		
		// cherryBombs
		ArrayList cherryBombs = spaceship.getCherryBombs();
		for (int i = 0; i < cherryBombs.size(); i++) {
			CherryBomb cb = (CherryBomb) cherryBombs.get(i);
			if (cb.isVisible() == true) {
				cb.update(delta);
			} else {
				cherryBombs.remove(i);
			}
		}
		
		// fruitBombs
		ArrayList fruitBombs = ufo.getFruitBombs();
		for (int i = 0; i < fruitBombs.size(); i++) {
			FruitBomb fb = (FruitBomb) fruitBombs.get(i);
			if (fb.isVisible() == true) {
					fb.update(delta);
			} else {
				fruitBombs.remove(i);
			}
		}
		
		// check for explosions
		for (int i = 0; i < cherryBombs.size(); i++) {
			CherryBomb cb = (CherryBomb) cherryBombs.get(i);
			if (cb.isVisible() == true) {
				// check cherryBomb hits ufo
				if (Rect.intersects(cb.getRect(), ufo.getRect())){
					//Log.d("CherryBomb", "A Hit!");
				}
				for (int j = 0; j < fruitBombs.size(); j++) {
					FruitBomb fb = (FruitBomb) fruitBombs.get(j);
					if (fb.isVisible() == true) {
						// check fruitBomb hits spaceship
						if (Rect.intersects(fb.getRect(), spaceship.getRect())){
							//Log.d("FruitBomb", "A Hit!");
						}
						// if they intersect, they explode
						if ((Rect.intersects(cb.getRect(), fb.getRect()))
								&&(cb.isVisible())){
							//cherryBombs.remove(i);
							//fruitBombs.remove(j);
							Assets.playSound(Assets.dropSound);
							cb.setVisible(false);
							fb.setVisible(false);
						}
					}
				}
			}
		}

	}
	
}
