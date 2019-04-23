package com.toymoon.game.state;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.toymoon.framework.util.Painter;
import com.toymoon.simplegdf.model.Star;
import com.toymoon.simplegdf.Assets;
import com.toymoon.simplegdf.model.Bubbloid;
import com.toymoon.simplegdf.model.Mermaid;
import com.toymoon.simplegdf.model.Eyefrown;
import com.toymoon.simplegdf.model.Spider;
import com.toymoon.simplegdf.model.Bubble;
import com.toymoon.framework.util.RandomNumberGenerator;

public class PlayState extends State{
	
	private int bubblesDropped = 0;
	private int bubbleMax = 50;
	private int bubbleMaxCount = 1;
	
	boolean timeForANewBubble = false;

	private Bubbloid bubbloid;
	private Mermaid mermaid;
	private Eyefrown eyefrown;
	private Spider spider;
	
	private ArrayList<Bubble> bubbles = new ArrayList();
	
	private Rect bubbleCheckRect = new Rect();
	
	private static final int BUBBLE_HEIGHT = 20;
	private static final int BUBBLE_WIDTH = 20;
	
	private int playerScore = 0;
	private Random random = new Random();
	
	private ArrayList<Star> stars;
	private int maxStars = 100;
	
	@Override
	public void init() {
		bubbloid = new Bubbloid(160, 0, 93, 96);
		mermaid = new Mermaid(80, 300-156, 71, 156);
		eyefrown = new Eyefrown(300, 140-34, 83, 34);
		spider = new Spider(0, 480-121, 87, 121);
		bubbles.add(createRandomBubble());	
		stars = new ArrayList<Star>();
		for (int i = 0; i<maxStars; i++){
			stars.add(new Star(random.nextInt(380), random.nextInt(420)));
		}
	}
	
	public void init(int GAME_WIDTH, int GAME_HEIGHT){
		this.GAME_HEIGHT = GAME_HEIGHT;
		this.GAME_WIDTH = GAME_WIDTH;
		init();
	}

	@Override
	public void update(float delta) {
		
		if (bubblesDropped>=3) {
			setCurrentState(new GameOverState(playerScore));
		}
		
		updateStars(delta);
		
		Assets.bubbloidAnimation.update(delta);
		bubbloid.update(delta);

		Assets.mermaidAnimation.update(delta);
		mermaid.update(delta);

		Assets.eyefrownAnimation.update(delta);
		eyefrown.update(delta);
		
		Assets.spiderAnimation.update(delta);
		spider.update(delta);

		updateBubbles(delta);			
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background_blank, 0, 0);
		renderStars(g);
		renderBubbloid(g);
		renderMermaid(g);
		renderEyefrown(g);
		renderSpider(g);
		renderBubbles(g);
		renderScore(g);
		renderBubblesDropped(g);
		//g.fillOval(3, 54, 23, 23);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if(e.getAction() == MotionEvent.ACTION_MOVE) {
        	if(spider.getRect().contains(scaledX, scaledY)){
        		spider.moveX(scaledX);
        	}
        //	if((scaledY>(int)spider.getY()) && 
        //			((scaledX>(int)spider.getX())
        //			||(scaledX<(int)spider.getX()+spider.getWidth()))){
		//		spider.moveX((float)scaledX);
				//Log.d("ScaledX", ""+scaledX);
		//	}
        	
        }         
		return true;
	}
	
	private void renderBubbloid(Painter g){
		Assets.bubbloidAnimation.render(g, (int)bubbloid.getX(), 
				(int)bubbloid.getY(), bubbloid.getWidth(), bubbloid.getHeight());
		//g.drawRect(bubbloid.getRect());
	}

	private void renderMermaid(Painter g){
		Assets.mermaidAnimation.render(g, (int)mermaid.getX(), 
				(int)mermaid.getY(), mermaid.getWidth(), mermaid.getHeight());
		//g.fillRect((int)mermaid.getX(), (int)mermaid.getY(), (int)mermaid.getX()+mermaid.getWidth(),  (int)mermaid.getY()+mermaid.getHeight());
		//g.fillRect((int)mermaid.getX(), (int)mermaid.getY(), mermaid.getWidth(),  mermaid.getHeight());
		//g.drawRect(mermaid.getRect());
	}
	
	private void renderEyefrown(Painter g){
		Assets.eyefrownAnimation.render(g, (int)eyefrown.getX(), 
				(int)eyefrown.getY(), eyefrown.getWidth(), eyefrown.getHeight());
		//g.drawRect(eyefrown.getRect());
	}
	
	private void renderSpider(Painter g){
		Assets.spiderAnimation.render(g, (int)spider.getX(), 
				(int)spider.getY(), spider.getWidth(), spider.getHeight());
		//g.drawRect(spider.getRect());
	}
	
	private void updateBubbles(float delta){
		
		// iterate the array of bubbles
		for(Bubble b: bubbles){
			b.update(delta);
			if(Rect.intersects(b.getRect(), spider.getRect())){
				Assets.playSound(Assets.popSound);
				playerScore++;
				if((playerScore%10==0)&&(bubbleMaxCount<=bubbleMax)){
					// time to create a new bubble - every 10 points
					timeForANewBubble = true;
				}
				b = resetABubble(b);
			}
			if(b.getY()>480){ 
				// if the bubble hits the bottom, reset, and count it as a bad
				Assets.playSound(Assets.dropSound);
				bubblesDropped++;
				b = resetABubble(b);
			}
		}
		// is it time to create a new bubble?
		if(timeForANewBubble==true){
			bubbles.add(createRandomBubble());
			bubbleMaxCount++;
			timeForANewBubble=false;
		}

	}
	
	
	// for some reason, Bubble.getRect() seems to have rect from spider instead of Bubble
	private void renderBubbles(Painter g){
		for (Bubble b: bubbles){
			g.fillOval((int)b.getX(), (int)b.getY(), b.getWidth(), b.getHeight());
		}
	}
	
	private Bubble resetABubble(Bubble b){
		int whichOne = random.nextInt(3);
		if(whichOne==0){
			b.reset(bubbloid.getX()+bubbloid.getHMid(), bubbloid.getY()+bubbloid.getVMid());
		}else if (whichOne==1){
			b.reset(mermaid.getX()+mermaid.getHMid(), mermaid.getY()+mermaid.getVMid());
		}else if (whichOne==2){
			b.reset(eyefrown.getX()+eyefrown.getHMid(), eyefrown.getY()+eyefrown.getVMid());
		}
		return b;
	}
	
	private Bubble createRandomBubble(){
		int whichOne = random.nextInt(3);
		Bubble b = null;
		if(whichOne==0){
			b = new Bubble(bubbloid.getX()+bubbloid.getHMid(), bubbloid.getY()+bubbloid.getVMid(), BUBBLE_WIDTH, BUBBLE_HEIGHT);
		}else if (whichOne==1){
			b = new Bubble(mermaid.getX()+mermaid.getHMid(), mermaid.getY()+mermaid.getVMid(), BUBBLE_WIDTH, BUBBLE_HEIGHT);
		}else if (whichOne==2){
			b =  new Bubble(eyefrown.getX()+eyefrown.getHMid(), eyefrown.getY()+eyefrown.getVMid(), BUBBLE_WIDTH, BUBBLE_HEIGHT);
		}
		return b;
	}
	
	private void updateStars(float delta){
		// iterate the array of stars
		for(Star s: stars){
			s.update(delta);
		}
	}
	
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
	
	private void renderBubblesDropped(Painter g){
		g.setFont(Typeface.SANS_SERIF, 25);
		g.setColor(Color.RED);       // hor  ver
		g.drawString(""+bubblesDropped, 280, 30);
	}
}
