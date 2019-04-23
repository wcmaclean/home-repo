package com.toymoon.snoblervsgrabler.model;

public class ProjectileUp extends GamePiece{
	
	
	int speedY = 2;
	
	public void update(float delta){
		this.y += speedY*delta;
		if (this.y > 800){
			this.visible = false;
		}
		updateRect();
	}
	


}
