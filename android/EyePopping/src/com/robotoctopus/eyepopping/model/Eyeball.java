package com.robotoctopus.eyepopping.model;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.framework.util.RandomNumberGenerator;
import com.robotoctopus.eyepopping.main.Assets;

public class Eyeball extends GamePiece{
	
	private int veloY = 5;
	private int veloX = 5;
	private int angle = 3;

	private boolean bloodshot;

	public int eyeballType;

	public Eyeball(float x, float y, int width, int height, int gameWidth, int gameHeight) {
		super(x, y, width, height, gameWidth, gameHeight);
		this.bloodshot = false;
	}
	
	public void updateAnimation(float delta){
		Assets.eyeball1Animation.update(delta);	
	}
	
	public void renderGamePiece(Painter g){
			Assets.eyeball1Animation.render(g, (int)getX(), 
					(int)getY(), getWidth(), getHeight());	
	}
	
	public void setBloodshot(boolean bloodshotStatus){
		this.bloodshot = bloodshotStatus;
	}
	
	public boolean getBloodshot(){
		return this.bloodshot;
	}

	public void reset(){
		this.bloodshot = false;
		//this.eyeballType=3;
		this.eyeballType = RandomNumberGenerator.getRandIntBetween(1, 4);
		super.reset();
	}
}
