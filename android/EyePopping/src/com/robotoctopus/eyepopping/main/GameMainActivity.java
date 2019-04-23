package com.robotoctopus.eyepopping.main;

import com.robotoctopus.eyepopping.main.GameView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.WindowManager;

public class GameMainActivity extends Activity{
	
	public static final int GAME_WIDTH=450;
	public static final int GAME_HEIGHT=800;
	//public static final int GAME_WIDTH=320;
	//public static final int GAME_HEIGHT=480;
	public static GameView sGame;
	public static AssetManager assets;
	
	// for high score
	private static SharedPreferences prefs;
	private static final String highScoreKey = "highScoreKey";
	private static int highScore;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		prefs = getPreferences(Activity.MODE_PRIVATE);
		highScore = retrieveHighScore();
		assets=getAssets();
		sGame=new GameView(this, GAME_WIDTH, GAME_HEIGHT);
		setContentView(sGame);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	
	public static void setHighScre(int highScore){
		GameMainActivity.highScore = highScore;
		Editor editor = prefs.edit();
		editor.putInt(highScoreKey, highScore);
		editor.commit();
	}
	
	private int retrieveHighScore(){
		return prefs.getInt(highScoreKey, 0);
	}
	
	public static int getHighScore(){
		return highScore;
	}
	
	public static int getGameWidth(){
		return GAME_WIDTH;
	}
	
	public static int getGameHeight(){
		return GAME_HEIGHT;
	}
}
