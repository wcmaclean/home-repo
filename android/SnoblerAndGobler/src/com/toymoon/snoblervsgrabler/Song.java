package com.toymoon.snoblervsgrabler;

import java.util.Random;


public class Song {

	static Random random = new Random();
	public static String song = null;
	
	Song(){
		int thisSong = random.nextInt(3);
		if(thisSong==0){
			song="03-Soma Sutra.mp3";
		}
		if(thisSong==1){
			song="04-Waking Up Dinosaurs.mp3";
		}
		if(thisSong==2){
			song="10-Celestial Slingshot (Oscillator B.mp3";
		}
		if(thisSong==3){
			song="11-Purpple Sky (Odd Nosdam Remix).mp3";
		}
	}
	
	public static String getSong(){
		return song;
	}
	
}
