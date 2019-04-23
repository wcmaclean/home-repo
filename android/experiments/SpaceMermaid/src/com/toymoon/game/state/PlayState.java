package com.toymoon.game.state;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.toymoon.framework.util.Painter;
import com.toymoon.model.Star;
import com.toymoon.simplegdf.Assets;
import com.toymoon.model.Bubbloid;
import com.toymoon.model.GamePiece;
import com.toymoon.model.Spider;
import com.toymoon.model.Eyefrown;
import com.toymoon.model.Mermaid;
import com.toymoon.framework.util.RandomNumberGenerator;

public class PlayState extends State{
	
	private Mermaid mermaid;
	//private Eyefrown eyefrown;
	//private Bubbloid bubbloid;
	//private Spider spider;
	
	private ArrayList<Star> stars;
	private int maxStars = 100;
	Star star;

	private ArrayList<GamePiece> gamePieces;
	
	private int stage = 1;
	private int playerScore = 0;
	private int strikeout = 0;
	private Random random = new Random();
	
	@Override
	public void init() {
		mermaid = new Mermaid(0, 480-156, 71, 156);
		star = new Star(23, 300);
		stars = new ArrayList<Star>();
		for (int i = 0; i<maxStars; i++){
			stars.add(new Star(random.nextInt(380), random.nextInt(420)));
		}
		gamePieces = new ArrayList<GamePiece>();
		//eyefrown = new Eyefrown(300, 140-34, 83, 34);
		gamePieces.add(new Eyefrown(300, 140-34, 83, 34));
		
	}

	@Override
	public void update(float delta) {
		
		if (strikeout>=3) {
			setCurrentState(new GameOverState(playerScore));
		}
		
		updateStars(delta);
		
		Assets.mermaidAnimation.update(delta);
		mermaid.update(delta);
		
		//Assets.eyefrownAnimation.update(delta);
		//if(eyefrown.update(delta)==false){
		//	playerScore++;
		//}
		
		updateGamePieces(delta);
		
		checkForCollisions();
		//checkForScores();
	}
	
	public void checkForCollisions(){
		//if((Rect.intersects(mermaid.getRect(), eyefrown.getRect()))
		//		&& (eyefrown.getGotHit()==false)){
		//	strikeout++;
		//	eyefrown.setGotHit();
		//}
		for(GamePiece g: gamePieces){
			if((Rect.intersects(mermaid.getRect(), g.getRect()))
					&& (g.getGotHit()==false)){
				strikeout++;
				Assets.playSound(Assets.dropSound);
				g.setGotHit();
			}			
		}
	}
	
	//public void checkForScores(){
	//	for(GamePiece g: gamePieces){
	//		if((g.getY()>=g.maxY)&&(g.getGotHit()!=true)){
	//			Assets.playSound(Assets.popSound);
	//			playerScore++;
	//		}			
	//	}
	//	if((eyefrown.getX()>=eyefrown.maxY)&&
	//			(eyefrown.getGotHit()==false)){
	//		playerScore++;
	//	}
	//}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background_blank, 0, 0);
		renderStars(g);
		renderMermaid(g);
		//renderEyefrown(g);
		renderScore(g);
		renderStrikes(g);
		renderGamePieces(g);
	}

	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if(e.getAction() == MotionEvent.ACTION_MOVE) {
        	if(mermaid.getRect().contains(scaledX, scaledY)){
        		mermaid.moveX(scaledX);
        	}
        }         
		return true;
	}
	
	private void updateStars(float delta){
		star.update(delta);
		// iterate the array of bubbles
		for(Star s: stars){
			s.update(delta);
		}
	}
	
	private void updateGamePieces(float delta){
		for(GamePiece g: gamePieces){
			g.updateAnimation(delta);
			// and check for score
			g.update(delta);
			// check if there is a score
			if((g.getY()>=g.maxY)&&(g.getGotHit()!=true)){
				Assets.playSound(Assets.popSound);
				playerScore++;
				//g.reset();
			}
			if(g.getY()>=g.maxY){
				g.reset();
			}
			
		}
		if((playerScore==10)&&(stage==1)){
			//spider = new Spider(120, 0, 87, 121);
			gamePieces.add(new Spider(120, 0, 87, 121));
			stage++;
		}
		if((playerScore==20)&&(stage==2)){
			//bubbloid = new Bubbloid(160, 0, 93, 96);
			gamePieces.add(new Bubbloid(160, 0, 93, 96));
			stage++;
		}
	}
	
	private void renderGamePieces(Painter g){
		for(GamePiece gp: gamePieces){
			gp.renderGamePiece(g);
		}
	}

	// for some reason, Bubble.getRect() seems to have rect from spider instead of Bubble
	private void renderStars(Painter g){
		g.drawImage(Assets.star1, (int) star.getX(), (int) star.getY(), 10, 10);
		for (Star s: stars){
			g.drawImage(Assets.star1, (int) s.getX(), (int) s.getY(), 10, 10);
		}
	}
	
	private void renderScore(Painter g){
		g.setFont(Typeface.SANS_SERIF, 25);
		g.setColor(Color.GREEN);
		g.drawString(""+playerScore, 20, 30);
	}
	
	private void renderStrikes(Painter g){
		g.setFont(Typeface.SANS_SERIF, 25);
		g.setColor(Color.RED);       // hor  ver
		g.drawString(""+strikeout, 280, 30);
	}

	private void renderMermaid(Painter g){
		Assets.mermaidAnimation.render(g, (int)mermaid.getX(), 
				(int)mermaid.getY(), mermaid.getWidth(), mermaid.getHeight());
	}
}
