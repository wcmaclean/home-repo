package com.robotoctopus.eyepopping.main;

import java.io.IOException;
import java.io.InputStream;

import com.robotoctopus.framework.animation.Animation;
import com.robotoctopus.framework.animation.Frame;
import com.robotoctopus.eyepopping.main.GameMainActivity;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;

public class Assets {
	
	private static SoundPool soundPool;
	public static Bitmap background, background_blank, goUp, goDown, eyeball1, eyeballBloodshot2, 
		eyeballBloodshot3, eyeballBloodshot, 
		star1, star2, star3, splat;
	public static Animation eyeball1Animation, eyeballBloodshotAnimation2, eyeballBloodshotAnimation3, eyeballBloodshotAnimation, splatAnimation;
	public static int popSound, dropSound;
	
	public static void load(){
		background=loadBitmap("background.png", false);
		background_blank=loadBitmap("background-blank.png", false);
		goUp=loadBitmap("goUp.png", false);
		goDown=loadBitmap("goDown.png", false);
		star1=loadBitmap("star-1.png", false);
		//star2=loadBitmap("star-2.png", false);
		//star3=loadBitmap("star-3.png", false);
		splat=loadBitmap("splat.png", false);
		
		eyeball1=loadBitmap("eyeball01.png", false);
		eyeballBloodshot=loadBitmap("eyeball02.png", false);
		eyeballBloodshot2=loadBitmap("eyeball03.png", false);
		eyeballBloodshot3=loadBitmap("eyeball04.png", false);
		
		//bubbloid2=loadBitmap("bubbloid2.png", false);
		Frame eyeballf1 = new Frame(eyeball1, 5f);
		Frame eyeballf2 = new Frame(eyeball1, 5f);
		eyeball1Animation = new Animation(eyeballf1, eyeballf2);

		Frame eyeballBloodshotf1 = new Frame(eyeballBloodshot, 5f);
		Frame eyeballBloodshotf2 = new Frame(eyeballBloodshot, 5f);
		eyeballBloodshotAnimation = new Animation(eyeballBloodshotf1, eyeballBloodshotf2);
		
		Frame eyeballBloodshot2f1 = new Frame(eyeballBloodshot2, 5f);
		Frame eyeballBloodshot2f2 = new Frame(eyeballBloodshot2, 5f);
		eyeballBloodshotAnimation2 = new Animation(eyeballBloodshot2f1, eyeballBloodshot2f2);
		
		Frame eyeballBloodshot3f1 = new Frame(eyeballBloodshot3, 5f);
		Frame eyeballBloodshot3f2 = new Frame(eyeballBloodshot3, 5f);
		eyeballBloodshotAnimation3 = new Animation(eyeballBloodshot3f1, eyeballBloodshot3f2);

		Frame splatf1 = new Frame(splat, 5f);
		splatAnimation = new Animation(splatf1, splatf1);
				
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
