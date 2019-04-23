package com.toymoon.snoblervsgrabler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import com.toymoon.snoblervsgrabler.framework.animation.Animation;
import com.toymoon.snoblervsgrabler.framework.animation.Frame;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class Assets {
	
	private static SoundPool soundPool;
	public static Bitmap background, background_blank, background_title, goUp, goDown, snobler1, snobler2,
		grabler1, grabler2, upSpit, downSpit, bubble;
	public static Animation snoblerAnimation, grablerAnimation;
	public static int popSound, dropSound;
	
	private static MediaPlayer mediaPlayer;
	static Song song = new Song();
	
	public static void load(){
		background=loadBitmap("background-blank.png", false);
		background_blank=loadBitmap("background-blank.png", false);
		background_title=loadBitmap("background-title.png", false);
		goUp=loadBitmap("goUp.png", false);
		goDown=loadBitmap("goDown.png", false);

		upSpit=loadBitmap("projectile-up.png", false);
		downSpit=loadBitmap("projectile-down.png", false);
		bubble=loadBitmap("bubble.png", false);
		
		snobler1=loadBitmap("snobler.png", false);
		snobler2=loadBitmap("snobler-flip.png", false);
		Frame snoblerf1 = new Frame(snobler1, 5f);
		Frame snoblerf2 = new Frame(snobler2, 5f);
		snoblerAnimation = new Animation(snoblerf1, snoblerf2);

		grabler1=loadBitmap("grabler.png", false);
		grabler2=loadBitmap("grabler-flip.png", false);
		Frame grablerf1 = new Frame(grabler1, 2f);
		Frame grablerf2 = new Frame(grabler2, 2f);
		grablerAnimation = new Animation(grablerf1, grablerf2);
		
		//popSound = loadSound("popSound.wav");
		//dropSound = loadSound("dropSound.wav");
		//music select
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
	
	
	public static void onResume(){
		popSound = loadSound("popSound.wav");
		dropSound = loadSound("dropSound.wav");
		playMusic(Song.getSong(), true);
	}
	
	public static void onPause(){
		if(soundPool!=null){
			soundPool.release();
			soundPool=null;
		}
		if(mediaPlayer!=null){
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}
	
	public static void playSound(int soundID){
		if(soundPool!=null){
			soundPool.play(soundID, 1, 1, 1, 0, 3);
		}	
	}
	
	public static void playMusic(String filename, boolean looping){
		if(mediaPlayer==null){
			mediaPlayer = new MediaPlayer();
			
		}
		try{
			AssetFileDescriptor afd = GameMainActivity.assets.openFd(filename);
			mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer.prepare();
			mediaPlayer.setLooping(looping);
			mediaPlayer.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}