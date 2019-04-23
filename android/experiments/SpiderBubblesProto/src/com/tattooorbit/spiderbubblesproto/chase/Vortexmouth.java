package com.tattooorbit.spiderbubblesproto.chase;


public class Vortexmouth {
    public int x, y;
    
    public Vortexmouth(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void move(int testX, int testY){
        if(testX<this.x){
        	this.x=this.x-1;
        }
        if(testX>this.x){
        	this.x=this.x+1;
        }
        	
        if(testY<this.y){
        	this.y=this.y-1;
        }
        if(testY>this.y){
        	this.y=this.y+1;
        }
    }
}
