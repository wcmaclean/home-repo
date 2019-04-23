package com.spacegame.simplegdf;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.WindowManager;

public class GameMainActivity extends Activity{
	
	//public static final int GAME_WIDTH=450;
	//public static final int GAME_HEIGHT=800;
	public static final int GAME_WIDTH=320;
	public static final int GAME_HEIGHT=480;
	public static GameView sGame;
	public static AssetManager assets;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		assets=getAssets();
		sGame=new GameView(this, GAME_WIDTH, GAME_HEIGHT);
		setContentView(sGame);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	
}
