package com.toymoon.snoblervsgrabler.game.state;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

//import com.robotoctopus.snoblervsgrabler.framework.util.RandomNumberGenerator;
//import com.robotoctopus.snoblervsgrabler.model.Bubble;
import com.toymoon.snoblervsgrabler.Assets;
import com.toymoon.snoblervsgrabler.GameMainActivity;
import com.toymoon.snoblervsgrabler.framework.util.Painter;
import com.toymoon.snoblervsgrabler.game.state.GameOverState;
import com.toymoon.snoblervsgrabler.model.Grabler;
import com.toymoon.snoblervsgrabler.model.Snobler;
import com.toymoon.snoblervsgrabler.model.SpitDown;
import com.toymoon.snoblervsgrabler.model.SpitUp;

public class PlayState extends State{
	
	//private ArrayList<Bubble> bubbles = new ArrayList();
	//private Rect bubbleCheckRect = new Rect();
	
	
	
	//private static final int BUBBLE_HEIGHT = 20;
	//private static final int BUBBLE_WIDTH = 20;
	
	private int playerScore = 0;
	private int spittlesDropped = 0;
	private int headHits = 0;
	private Random random = new Random();
	
	private Grabler grabler;
	private Snobler snobler;
	
	// a switch, so we don't keep speeding up the whole time playerScore%20==0
	boolean justSpedUp = false;
	
	private int scaling = 5;
	
	private boolean gamePaused = false;
	private String pausedString = "Paused. Tap to go.";
	
	//private Bubble bubble;
	
	@Override
	public void init() {
//		bubbloid = new Bubbloid(160, 0, 93, 96);
		this.GAME_WIDTH = GameMainActivity.getGameWidth();
		this.GAME_HEIGHT = GameMainActivity.getGameHeight();
		int initPosition = random.nextInt(GAME_WIDTH-(520/scaling)); 
		grabler = new Grabler(initPosition, GAME_HEIGHT-(520/scaling), (488/scaling), (520/scaling));
		initPosition = random.nextInt(GAME_WIDTH-(784/scaling)); 
		snobler = new Snobler(initPosition, 100, (519/scaling), (335/scaling));
		//bubble = new Bubble();
	}
	

	@Override
	public void onPause(){
		gamePaused = true;
	}
	


	@Override
	public void update(float delta) {
		
		// check if it's paused
		if(gamePaused){
			return;
		}
		
		// check game end
		if (spittlesDropped>=3) {
			setCurrentState(new GameOverState(playerScore));
		}
		// speed up the game every 10 points
		if((playerScore%20==0)&&(playerScore!=0)&&(justSpedUp==false)){
			snobler.speedUp();
			snobler.moreSpittles();
			grabler.moreSpittles();
			justSpedUp=true;
		}
		

		Assets.snoblerAnimation.update(delta);
		snobler.update(delta);
		
		Assets.grablerAnimation.update(delta);
		grabler.update(delta);
		
		updateSpittles(delta);
		
		//updateBubbles(delta);
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background_blank, 0, 0);
		renderSpittles(g);
		renderGrabler(g);
		renderSnobler(g);
		//renderBubbles(g);
		renderScore(g);
		renderSpittlesDropped(g);
		renderLevel(g);
		
		//if game is paused
		if(gamePaused){
			g.setColor(Color.argb(153, 0, 0, 0));
			g.fillRect(0, 0, GameMainActivity.getGameWidth(), GameMainActivity.getGameHeight());
			g.drawString(pausedString, 235, 240);
		}
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if(e.getAction() == MotionEvent.ACTION_MOVE) {
        	if(grabler.getRect().contains(scaledX, scaledY)){
        		grabler.moveX(scaledX);
        	}
        }         
        if(e.getAction() == MotionEvent.ACTION_UP){
        	// shoot
        	if(gamePaused){
        		gamePaused=false;
        	}else{
        		grabler.spit();
        	}
        }
		return true;
	}

	private void renderGrabler(Painter g){
		Assets.grablerAnimation.render(g, (int)grabler.getX(), 
				(int)grabler.getY(), grabler.getWidth(), grabler.getHeight());
		//g.drawRect(spider.getRect());
	}
	
	private void renderSnobler(Painter g){
		Assets.snoblerAnimation.render(g, (int)snobler.getX(), 
				(int)snobler.getY(), snobler.getWidth(), snobler.getHeight());
		//g.drawRect(spider.getRect());
	}	

	//private void renderBubbles(Painter g){
	//	g.drawImage(Assets.bubble, (int)bubble.getX(), (int)bubble.getY(), bubble.getWidth(), bubble.getHeight());
	//}
	
	private void renderScore(Painter g){
		g.setFont(Typeface.SANS_SERIF, 25);
		g.setColor(Color.GREEN);
		g.drawString("Snobbles:", 20, 30);
		g.drawString(""+playerScore, 20, 55);
	}
	
	
	private void renderLevel(Painter g){
		g.setFont(Typeface.SANS_SERIF, 25);
		g.setColor(Color.BLUE);       // hor  ver
		g.drawString("Headshots: ", GAME_WIDTH-((GAME_WIDTH/2)+(GAME_WIDTH/9)), 30);
		g.drawString(""+headHits, GAME_WIDTH-((GAME_WIDTH/2)+(GAME_WIDTH/9)), 55);
	}
	
	private void renderSpittlesDropped(Painter g){
		g.setFont(Typeface.SANS_SERIF, 25);
		g.setColor(Color.RED);       // hor  ver
		g.drawString("Missed:", GAME_WIDTH-(GAME_WIDTH/5), 30);
		g.drawString(""+spittlesDropped, GAME_WIDTH-(GAME_WIDTH/5), 55);
	}
	
	
	private void renderSpittles(Painter g){

		ArrayList spittlesDown = snobler.getSpittles();
		for (int i = 0; i < spittlesDown.size(); i++) {
			SpitDown sd = (SpitDown) spittlesDown.get(i);
			g.drawImage(Assets.downSpit, (int)sd.getX(), (int)sd.getY(), sd.getWidth(), sd.getHeight());
		}
		
		ArrayList spittlesUp = grabler.getSpittles();
		for (int i = 0; i < spittlesUp.size(); i++) {
			SpitUp su = (SpitUp) spittlesUp.get(i);
			g.drawImage(Assets.upSpit, (int)su.getX(), (int)su.getY(), su.getWidth(), su.getHeight());
		}
		
	}
	
	//private void updateBubbles(float delta){
	//	bubble.move();
	//}
	
	private void updateSpittles(float delta){
		
		ArrayList spittlesDown = snobler.getSpittles();
		for (int i = 0; i < spittlesDown.size(); i++) {
			SpitDown sd = (SpitDown) spittlesDown.get(i);
			if (sd.isVisible() == true) {
				sd.update(delta);     
			} else {
				spittlesDown.remove(i);
			}
		}
		
		ArrayList spittlesUp = grabler.getSpittles();
		for (int i = 0; i < spittlesUp.size(); i++) {
			SpitUp su = (SpitUp) spittlesUp.get(i);
			if (su.isVisible() == true) {
				su.update(delta);
			} else {
				spittlesUp.remove(i);
			}
		}
		
		// traverse the spittles
		if(!(spittlesDown.isEmpty())){
			for (int i = 0; i < spittlesDown.size(); i++) {
				SpitDown sd = (SpitDown) spittlesDown.get(i);
				if (sd.isVisible() == true) {
					// check spit down hits grabler
					if (Rect.intersects(sd.getRect(), grabler.getRect())){
						Log.d("Grabler", "Ate one - score one.");
						Assets.playSound(Assets.popSound);
						playerScore++;
						sd.setVisible(false);
						if(justSpedUp==true){ // flip the switch
							justSpedUp=false;
						}
					} 
					// check if the spittle down makes it all the way - 3 strikes and yer out
					if(sd.getY()+sd.height>GAME_HEIGHT){ 
						// if the bubble hits the bottom, reset, and count it as a bad
						Assets.playSound(Assets.dropSound);
						spittlesDropped++;
						sd.setVisible(false);
					}
					// do any of the spittlesUp collide with any spittlesDown?
					if(!(spittlesUp.isEmpty())){
						for (int j = 0; j < spittlesUp.size(); j++) {
							SpitUp su = (SpitUp) spittlesUp.get(j);
							if (su.isVisible() == true) {
								// if they intersect, they explode
								if ((Rect.intersects(sd.getRect(), su.getRect()))
										&&(sd.isVisible())){
									//cherryBombs.remove(i);
									//fruitBombs.remove(j);
									Assets.playSound(Assets.popSound);
									sd.setVisible(false);
									su.setVisible(false);
									playerScore++;
								}
								// if it hits snobler, headshot
								if(Rect.intersects(su.getRect(), snobler.getRect())){
									//setCurrentState(new GameOverState(playerScore));
									Assets.playSound(Assets.popSound);
									// regain a dropped spittle, speed up snobler, more downspit
									headHits++;
									if(spittlesDropped>0){ // lose a dropped spittle
										spittlesDropped--;
									}
									//snobler.
									su.setVisible(false);
								}
								// if it hits the bubble, reset bubble
								//if(Rect.intersects(su.getRect(), bubble.getRect())){
								//	bubble.reset();
								//}
							}
						}
					}
				}
			}
		}
	}	
}
