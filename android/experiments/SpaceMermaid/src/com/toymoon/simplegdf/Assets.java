package com.toymoon.simplegdf;

import java.io.IOException;
import java.io.InputStream;

import com.toymoon.framework.animation.Animation;
import com.toymoon.framework.animation.Frame;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;

public class Assets {
	
	private static SoundPool soundPool;
	public static Bitmap background, background_blank, goUp, goDown, bubbloid1, bubbloid2,
		mermaid1, mermaid2, spider1, spider2, eyefrown1, eyefrown2, star1, star2, star3;
	public static Animation bubbloidAnimation, mermaidAnimation, spiderAnimation,
		eyefrownAnimation;
	public static int popSound, dropSound;
	
	public static void load(){
		background=loadBitmap("background.png", false);
		background_blank=loadBitmap("background-blank.png", false);
		goUp=loadBitmap("goUp.png", false);
		goDown=loadBitmap("goDown.png", false);
		star1=loadBitmap("star-1.png", false);
		star2=loadBitmap("star-2.png", false);
		star3=loadBitmap("star-3.png", false);
		
		mermaid1=loadBitmap("mermaid1.png", false);
		mermaid2=loadBitmap("mermaid2.png", false);
		Frame mermaidf1 = new Frame(mermaid1, 2f);
		Frame mermaidf2 = new Frame(mermaid2, 2f);
		mermaidAnimation = new Animation(mermaidf1, mermaidf2);
		
		bubbloid1=loadBitmap("bubbloid1.png", false);
		bubbloid2=loadBitmap("bubbloid2.png", false);
		Frame bubbloidf1 = new Frame(bubbloid1, 5f);
		Frame bubbloidf2 = new Frame(bubbloid2, 5f);
		bubbloidAnimation = new Animation(bubbloidf1, bubbloidf2);

		eyefrown1=loadBitmap("eyefrown1.png", false);
		eyefrown2=loadBitmap("eyefrown2.png", false);
		Frame eyefrownf1 = new Frame(eyefrown1, 3f);
		Frame eyefrownf2 = new Frame(eyefrown2, 3f);
		eyefrownAnimation = new Animation(eyefrownf1, eyefrownf2);
		
		spider1=loadBitmap("spider1.png", false);
		spider2=loadBitmap("spider2.png", false);
		Frame spiderf1 = new Frame(spider1, 2f);
		Frame spiderf2 = new Frame(spider2, 2f);
		spiderAnimation = new Animation(spiderf1, spiderf2);
				
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