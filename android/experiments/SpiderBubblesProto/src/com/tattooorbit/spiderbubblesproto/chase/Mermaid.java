package com.tattooorbit.spiderbubblesproto.chase;


public class Mermaid {
    public int x, y;
    
    public Mermaid(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int moveX(int testX){
    	if(testX>this.x){
    		return testX-1;
    	}
    	if(testX<this.x){
    		return testX+1;
    	}
    	return testX;
    }
    
    public int moveY(int testY){
    	if(testY>this.y){
    		return testY-1;
    	}
    	if(testY<this.y){
    		return testY+1;
    	}
    	return testY;
    }
}       
