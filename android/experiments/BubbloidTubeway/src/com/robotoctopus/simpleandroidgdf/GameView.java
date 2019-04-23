package com.robotoctopus.simpleandroidgdf;

import com.robotoctopus.framework.util.InputHandler;
import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.game.state.LoadState;
import com.robotoctopus.game.state.State;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

public class GameView extends SurfaceView implements Runnable{
	
	private Bitmap gameImage;
	private Rect gameImageSrc;
	private Rect gameImageDst;
	private Canvas gameCanvas;
	private Painter graphics;
	
	private Thread gameThread;
	private volatile boolean running=false;
	private volatile State currentState;
	private InputHandler inputHandler;
	
	private int gameWidth, gameHeight;

	public GameView(Context context, final int  gameWidth, final int gameHeight) {
		super(context);
		gameImage=Bitmap.createBitmap(gameWidth, gameHeight, Bitmap.Config.RGB_565);
		gameImageSrc=new Rect(0, 0, gameImage.getWidth(), gameImage.getHeight());
		gameImageDst=new Rect();
		gameCanvas=new Canvas(gameImage);
		graphics=new Painter(gameCanvas);
		this.gameWidth=gameWidth;
		this.gameHeight=gameHeight;
		
		SurfaceHolder holder=getHolder();
		holder.addCallback(new Callback(){
			
			@Override
			public void surfaceCreated(SurfaceHolder holder){
				//Log.d("GameView", "Surface Created");
				initInput();
				if(currentState==null){
					setCurrentState(new LoadState(gameWidth, gameHeight));
				}
				initGame();
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
				
			}
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder){
				//Log.d("GameView", "Surface Destroyed");
				pauseGame();
			}
			
		});
	}
	
	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void setCurrentState(State newState){
		System.gc();
		newState.init();
		currentState=newState;
		inputHandler.setCurrentState(currentState);
	}
	
	private void initInput(){
		if(inputHandler==null){
			inputHandler=new InputHandler();
		}
		setOnTouchListener(inputHandler);
	}
	
	private void initGame(){
		running=true;
		gameThread=new Thread(this,"Game Thread");
		gameThread.start();
	}
	
	private void pauseGame(){
		running=false;
		while(gameThread.isAlive()){
			try{
				gameThread.join();
				break;
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	
	private void updateAndRender(long delta){
		currentState.update(delta/1000f);
		currentState.render(graphics);
		renderGameImage();
	}
	
	private void renderGameImage(){
		Canvas screen=getHolder().lockCanvas();
		if(screen!=null){
			screen.getClipBounds(gameImageDst);
			screen.drawBitmap(gameImage, gameImageSrc, gameImageDst, null);
			getHolder().unlockCanvasAndPost(screen);
		}
	}

	@Override
	public void run() {
		long updateDurationMillis=0;
		long sleepDurationMillis=0;
		
		while(running){
			long beforeUpdateRender=System.nanoTime();
			long deltaMillis=sleepDurationMillis+updateDurationMillis;
			updateAndRender(deltaMillis);
			
			updateDurationMillis=(System.nanoTime()-beforeUpdateRender)/100000L;
			sleepDurationMillis=Math.max(2, 17-updateDurationMillis);
			
			try{
				Thread.sleep(sleepDurationMillis);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
}
