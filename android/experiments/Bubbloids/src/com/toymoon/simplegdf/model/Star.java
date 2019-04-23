package com.toymoon.simplegdf.model;


import com.toymoon.framework.util.RandomNumberGenerator;

public class Star {
	private float x, y;
	private static final int VEL_Y = 1;

	public Star(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Star(int x, int y) {
		this.x = (float)x;
		this.y = (float)y;
	}


	public void update(float delta) {
		y += VEL_Y;
		if (y >= 480) {
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