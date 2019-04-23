package com.tattooorbit.spiderbubblesproto.chase;


public class Eyefrown {
    public int x, y;
    
    public Eyefrown(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void move(int testX, int testY){
        if(testX<this.x){
        	this.x=this.x-2;
        }
        if(testX>this.x){
        	this.x=this.x+2;
        }
        	
        if(testY<this.y){
        	this.y=this.y-2;
        }
        if(testY>this.y){
        	this.y=this.y+2;
        }
    }
}