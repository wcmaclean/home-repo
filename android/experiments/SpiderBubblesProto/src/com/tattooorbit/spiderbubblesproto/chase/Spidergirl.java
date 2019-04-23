package com.tattooorbit.spiderbubblesproto.chase;


public class Spidergirl {
    public int x, y;
    
    public Spidergirl(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void move(int testX, int testY){
        if(testX<this.x){
        	this.x=this.x-3;
        }
        if(testX>this.x){
        	this.x=this.x+3;
        }
        	
        if(testY<this.y){
        	this.y=this.y-3;
        }
        if(testY>this.y){
        	this.y=this.y+3;
        }
    }
}   
