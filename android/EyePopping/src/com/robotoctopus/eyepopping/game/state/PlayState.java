package com.robotoctopus.eyepopping.game.state;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.eyepopping.game.state.GameOverState;
import com.robotoctopus.eyepopping.main.Assets;
import com.robotoctopus.eyepopping.model.GamePiece;
import com.robotoctopus.eyepopping.model.Eyeball;
import com.robotoctopus.eyepopping.model.Star;

public class PlayState extends State{
	
	private ArrayList<Eyeball> eyeballs;
	private int maxEyeballs = 1;
	private Eyeball eyeball;
	
	private ArrayList<Star> stars;
	private int maxStars = 50;
	Star star;
	
	private ArrayList<GamePiece> gamePieces;
	
	private int stage = 1;
	private int playerScore = 0;
	private int strikeout = 0;
	
	private boolean justTouchedOne;
	
	boolean justSpedUp;
	
	public PlayState(int gameWidth, int gameHeight){
		super(gameWidth, gameHeight);
	}

	
	@Override
	public void init() {
		eyeballs = new ArrayList<Eyeball>();
		eyeball = new Eyeball(0, 0, 221/80, 221/80, this.gameWdith, this.gameHeight);
		eyeball.reset();
		eyeballs.add(eyeball);
		justSpedUp = false;
		stars = new ArrayList<Star>();
		stars.add(new Star((float)this.gameWdith/2, (float)this.gameHeight/2));
		
	}

	@Override
	public void update(float delta) {

		updateStars(delta);
		updateEyeballs(delta);
		
		// speed up the game every 10 points
		if((playerScore%10==0)&&(playerScore!=0)&&(justSpedUp==false)){
			eyeball = new Eyeball(0, 0, 5, 5, this.gameWdith, this.gameHeight);
			eyeball.reset();
			eyeballs.add(eyeball);
			justSpedUp=true;
		}
		if((playerScore%10!=0)){
			justSpedUp=false;
		}
		
	}


	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background_blank, 0, 0);
		renderStars(g);
		renderEyeball(g);
		renderScore(g);
		//renderStrikes(g);
		if (strikeout==2) {
			renderEyeball(g);
			setCurrentState(new GameOverState(playerScore));
		}
	}

	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if((e.getAction() == MotionEvent.ACTION_MOVE)) {
        	for(int i=0; i<eyeballs.size(); i++){
        		eyeball = eyeballs.get(i);
        		if(justTouchedOne==false){ // trying to make them have to lift a finger each time
                	if((eyeball.getRect().contains(scaledX, scaledY))
                			&&(eyeball.getBloodshot()==true)){
                		justTouchedOne = true;
                		//eyeball.reset();
                		eyeball.shrink();
                		playerScore++;
                		Assets.playSound(Assets.popSound);
                	}	
        		}
        	}
        }
        if(e.getAction() == MotionEvent.ACTION_UP){
        	justTouchedOne = false;
        }
		return true;
	}
	
	public void updateEyeballs(float delta){
		
		for(int i=0; i<eyeballs.size(); i++){
			eyeball = eyeballs.get(i);
			if(eyeball.splatStatus()=="not splatted"){
				eyeball.setBloodshot(false);
			}
			if(eyeball.getBloodshot()==false){
				Assets.eyeball1Animation.update(delta);
			}
			if(eyeball.getBloodshot()==true){
				if(eyeball.eyeballType==1){
					Assets.eyeballBloodshotAnimation.update(delta);
				}
				if(eyeball.eyeballType==2){
					Assets.eyeballBloodshotAnimation2.update(delta);
				}
				if(eyeball.eyeballType==3){
					Assets.eyeballBloodshotAnimation3.update(delta);
				}
			}
			if(eyeball.splatStatus()=="splatted"){
				Assets.splatAnimation.update(delta);
			}
			
			eyeball.update(delta);
			
			// if eyeball is to close to either left or right, make it bloodshot
			if(eyeball.getX() < 100){
				eyeball.setBloodshot(true);
			}
			if(eyeball.getX() + eyeball.getWidth() > this.gameWdith -100){
				eyeball.setBloodshot(true);
			}
			
			if((eyeball.getX()<=0)
					||((eyeball.getX() + eyeball.getWidth())>=this.gameWdith))
					//||(eyeball.getY()+eyeball.getHeight()>=this.gameHeight))
					{
				Assets.playSound(Assets.dropSound);
				Assets.splatAnimation.update(delta);
				strikeout++;
			}
		}
	}
	
	private void updateStars(float delta){
		if(stars.size()<maxStars){
			stars.add(new Star((float)this.gameWdith/2, (float)this.gameHeight/2));
		}
		for(int i=0; i<stars.size(); i++){
			stars.get(i).update(delta);
		}
	}


	private void renderEyeball(Painter g){
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		//Eyeball eyeball = null;
		for(int i = 0; i<eyeballs.size(); i++){
			//draw a rect for troubleshooting
			//g.canvas.drawRect(eyeball.getRect(), paint);
			eyeball = eyeballs.get(i);
			// draw the eyeballs
			if(eyeball.getBloodshot()==false){
				Assets.eyeball1Animation.render(g, (int)eyeball.getX(), 
						(int)eyeball.getY(), eyeball.getWidth(), eyeball.getHeight());										
			}
			if(eyeball.getBloodshot()==true){	
				if(eyeball.eyeballType==1){
					Assets.eyeballBloodshotAnimation.render(g, (int)eyeball.getX(), 
							(int)eyeball.getY(), eyeball.getWidth(), eyeball.getHeight());
				}
				if(eyeball.eyeballType==2){
					Assets.eyeballBloodshotAnimation2.render(g, (int)eyeball.getX(), 
							(int)eyeball.getY(), eyeball.getWidth(), eyeball.getHeight());
				}
				if(eyeball.eyeballType==3){
					Assets.eyeballBloodshotAnimation3.render(g, (int)eyeball.getX(), 
							(int)eyeball.getY(), eyeball.getWidth(), eyeball.getHeight());
				}
			}
			if(eyeball.splatStatus()=="splatted"){
				Assets.splatAnimation.render(g, (int)eyeball.getX(), 
						(int)eyeball.getY(), eyeball.getWidth(), eyeball.getHeight());				
			}
		}
	}

	// for some reason, Bubble.getRect() seems to have rect from spider instead of Bubble
	private void renderStars(Painter g){
		for (int i=0; i<stars.size(); i++){
			g.drawImage(Assets.star1, (int) stars.get(i).getX(), (int) stars.get(i).getY(), 10, 10);
		}
	}
	
	private void renderScore(Painter g){
		g.setFont(Typeface.SANS_SERIF, 25);
		g.setColor(Color.GREEN);
		//g.drawString(""+playerScore, 20, 30);
		g.drawString(""+playerScore, 200, 30);
	}
	
	private void renderStrikes(Painter g){
		g.setFont(Typeface.SANS_SERIF, 25);
		g.setColor(Color.RED);       // hor  ver
		g.drawString(""+strikeout, 280, 30);
	}
	
}
