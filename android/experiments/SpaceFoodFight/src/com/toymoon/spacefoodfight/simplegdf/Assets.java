package com.toymoon.spacefoodfight.simplegdf;

import java.io.IOException;
import java.io.InputStream;

import com.toymoon.spacefoodfight.framework.animation.Animation;
import com.toymoon.spacefoodfight.framework.animation.Frame;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;

public class Assets {
	
	private static SoundPool soundPool;
	public static Bitmap background, goUp, goDown, ufo1, ufo2, cherryBomb,
		ufo3, ufo4, spaceship1, spaceship2, spaceship3, spaceship4, spaceship5,
		cherry, blueberry;
	public static Animation ufoAnimation, spaceshipAnimation;
	public static int popSound, dropSound;
	
	public static void load(){
		background=loadBitmap("background.png", false);
		goUp=loadBitmap("goUp.png", false);
		goDown=loadBitmap("goDown.png", false);

		cherry=loadBitmap("cherry.png", false);
		blueberry=loadBitmap("blueberry.png", false);
		
		ufo1=loadBitmap("mermaid1.png", false);
		ufo2=loadBitmap("mermaid2.png", false);
		//ufo3=loadBitmap("ufo3.png", false);
		//ufo4=loadBitmap("ufo4.png", false);
		Frame ufof1 = new Frame(ufo1, 2f);
		Frame ufof2 = new Frame(ufo2, 2f);
		//Frame ufof3 = new Frame(ufo3, 2f);
		//Frame ufof4 = new Frame(ufo4, 2f);
		ufoAnimation = new Animation(ufof1, ufof2);
		
		spaceship1=loadBitmap("spider1.png", false);
		spaceship2=loadBitmap("spider2.png", false);
		//spaceship3=loadBitmap("spaceship3.png", false);
		//spaceship4=loadBitmap("spaceship4.png", false);
		//spaceship5=loadBitmap("spaceship5.png", false);
		Frame spaceshipf1 = new Frame(spaceship1, 2f);
		Frame spaceshipf2 = new Frame(spaceship2, 2f);
		//Frame spaceshipf3 = new Frame(spaceship3, 2f);
		//Frame spaceshipf4 = new Frame(spaceship4, 2f);
		//Frame spaceshipf5 = new Frame(spaceship5, 2f);
		spaceshipAnimation = new Animation(spaceshipf1, spaceshipf2);

		cherryBomb=loadBitmap("CherryBomb.png", false);
		popSound = loadSound("popSound.wav");
		dropSound = loadSound("dropSound.wav");
	}
	
	private static Bitmap loadBitmap(String filename, boolean transparency){
		InputStream inputStream=null;
		try{
			inputStream=GameMainActivity.assets.open(filename);
		}catch(IOException e){
			e.printStackTrace();
		}
		Options options = new Options();
		if(transparency){
			options.inPreferredConfig=Config.ARGB_8888;
		}else{
			options.inPreferredConfig=Config.RGB_565;
		}
		Bitmap bitmap=BitmapFactory.decodeStream(inputStream, null, new Options());
		return bitmap;
	}

	
	private static int loadSound(String filename){
		int soundID=0;
		if(soundPool==null){
			soundPool=new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
		}
		try{
			soundID=soundPool.load(GameMainActivity.assets.openFd(filename), 1);
		}catch(IOException e){
			e.printStackTrace();
		}
		return soundID;
	}
	
	public static void playSound(int soundID){
		soundPool.play(soundID, 1, 1, 1, 0, 3);
	}
	
	
}