package com.robotoctopus.game.state;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.simpleandroidgdf.Assets;
import com.robotoctopus.downthehole.model.Bubbloid;
import com.robotoctopus.downthehole.model.Eyefrown;
import com.robotoctopus.downthehole.model.GamePiece;
import com.robotoctopus.downthehole.model.Mermaid;
import com.robotoctopus.downthehole.model.Spider;
import com.robotoctopus.downthehole.model.Star;

public class PlayState extends State{
	
	private Bubbloid bubbloid;
	private Mermaid mermaid;
	private Spider spider;
	private Eyefrown eyefrown;
	
	private ArrayList<Star> stars;
	private int maxStars = 100;
	Star star;
	
	private ArrayList<GamePiece> gamePieces;
	
	private int stage = 1;
	private int playerScore = 0;
	private int strikeout = 0;
	
	public PlayState(int gameWidth, int gameHeight){
		super(gameWidth, gameHeight);
	}

	
	@Override
	public void init() {
		bubbloid = new Bubbloid(0, 0, 93/3, 96/3, this.gameWdith, this.gameHeight);
		mermaid = new Mermaid(0, 0, 93/3, 96/3, this.gameWdith, this.gameHeight);
		spider = new Spider(0, 0, 93/3, 96/3, this.gameWdith, this.gameHeight);
		eyefrown = new Eyefrown(0, 0, 93/3, 96/3, this.gameWdith, this.gameHeight);
		
		stars = new ArrayList<Star>();
		stars.add(new Star((float)this.gameWdith/2, (float)this.gameHeight/2));
	}

	@Override
	public void update(float delta) {

		updateStars(delta);
		
		Assets.bubbloidAnimation.update(delta);
		bubbloid.update(delta);
		
		Assets.mermaidAnimation.update(delta);
		mermaid.update(delta);
		
		Assets.spiderAnimation.update(delta);
		spider.update(delta);
		
		Assets.eyefrownAnimation.update(delta);
		eyefrown.update(delta);
		
	}


	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background_blank, 0, 0);
		renderStars(g);
		renderBubbloid(g);
		renderMermaid(g);
		renderSpider(g);
		renderEyefrown(g);
		renderScore(g);
		renderStrikes(g);

	}

	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if(e.getAction() == MotionEvent.ACTION_MOVE) {
        	if(mermaid.getRect().contains(scaledX, scaledY)){
        		//mermaid.moveX(scaledX);
        		mermaid.shrink();
        		playerScore++;
        		Assets.playSound(Assets.popSound);
        	}
        	if(spider.getRect().contains(scaledX, scaledY)){
        		//mermaid.moveX(scaledX);
        		spider.shrink();
        		playerScore++;
        		Assets.playSound(Assets.popSound);
        	}
        	if(bubbloid.getRect().contains(scaledX, scaledY)){
        		//mermaid.moveX(scaledX);
        		bubbloid.shrink();
        		playerScore++;
        		Assets.playSound(Assets.popSound);
        	}
        	if(eyefrown.getRect().contains(scaledX, scaledY)){
        		//mermaid.moveX(scaledX);
        		eyefrown.shrink();
        		playerScore++;
        		Assets.playSound(Assets.popSound);
        	}
        }         
		return true;
	}
	
	private void updateStars(float delta){
		if(stars.size()<maxStars){
			stars.add(new Star((float)this.gameWdith/2, (float)this.gameHeight/2));
		}
		for(Star s: stars){
			s.update(delta);
		}
	}


	private void renderBubbloid(Painter g){
		Assets.bubbloidAnimation.render(g, (int)bubbloid.getX(), 
				(int)bubbloid.getY(), bubbloid.getWidth(), bubbloid.getHeight());
	}
	
	private void renderMermaid(Painter g){
		Assets.mermaidAnimation.render(g, (int)mermaid.getX(), 
				(int)mermaid.getY(), mermaid.getWidth(), mermaid.getHeight());
	}
	
	private void renderSpider(Painter g){
		Assets.spiderAnimation.render(g, (int)spider.getX(), 
				(int)spider.getY(), spider.getWidth(), spider.getHeight());
	}
	
	private void renderEyefrown(Painter g){
		Assets.eyefrownAnimation.render(g, (int)eyefrown.getX(), 
				(int)eyefrown.getY(), eyefrown.getWidth(), eyefrown.getHeight());
	}
	
	// for some reason, Bubble.getRect() seems to have rect from spider instead of Bubble
	private void renderStars(Painter g){
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
	
}
