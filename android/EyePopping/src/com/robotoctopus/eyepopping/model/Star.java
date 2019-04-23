package com.robotoctopus.eyepopping.model;

import com.robotoctopus.framework.util.RandomNumberGenerator;




public class Star {
	private float original_x, original_y;
	private float x, y;
	private int VEL_X, VEL_Y=1;
	private String quadrant;
	private float MAX_X, MAX_Y;

	RandomNumberGenerator rnd = new RandomNumberGenerator();
	
	public Star(float x, float y) {
		this.original_x=x;
		this.original_y=y;
		this.x = x;
		this.y = y;
		this.MAX_X = x*2;
		this.MAX_Y = y*2;
		setQuadrant();
		this.VEL_X= rnd.getRandIntBetween(1, 10);
		this.VEL_Y= rnd.getRandIntBetween(1, 10);
	}
	
	
	public Star(int x, int y) {
		this.x = (float)x;
		this.y = (float)y;
	}
	
	public void setQuadrant(){
		int quad = rnd.getRandIntBetween(1, 5);
		if(quad==1) { quadrant="upper_left"; }
		if(quad==2) { quadrant="upper_right"; }
		if(quad==3) { quadrant="lower_left"; }
		if(quad==4) { quadrant="lower_right"; }
	}
	
	public void reset(){
		this.x = this.original_x;
		this.y = this.original_y;
		setQuadrant();
		this.VEL_X= rnd.getRandIntBetween(1, 10);
		this.VEL_Y= rnd.getRandIntBetween(1, 10);
	}


	public void update(float delta) {
		if(quadrant.equalsIgnoreCase("upper_left")){
			this.x-=this.VEL_X;
			this.y-=this.VEL_Y;
			if((this.x<=0)||(this.y<=0)){
				reset();
			}
		}
		if(quadrant.equalsIgnoreCase("upper_right")){
			this.x+=this.VEL_X;
			this.y-=this.VEL_Y;
			if((this.x>=this.MAX_X)||(this.y<=0)){
				reset();
			}
		}		
		if(quadrant.equalsIgnoreCase("lower_left")){
			this.x-=this.VEL_X;
			this.y+=this.VEL_Y;
			if((this.x<=0)||(this.y>=this.MAX_Y)){
				reset();
			}
		}
		if(quadrant.equalsIgnoreCase("lower_right")){
			this.x+=this.VEL_X;
			this.y+=this.VEL_Y;
			if((this.x>=this.MAX_X)||(this.y>=this.MAX_Y)){
				reset();
			}
		}
		if (y >= 800) {
			// Reset to the right
			y = 0;
			x = RandomNumberGenerator.getRandIntBetween(1, 350);
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	
	
}