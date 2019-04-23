package com.robotoctopus.game.state;


import android.view.MotionEvent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;

import com.robotoctopus.framework.util.Painter;
import com.robotoctopus.framework.util.UIButton;
import com.robotoctopus.simpleandroidgdf.Assets;

public class MenuState extends State{
	
	// Declare Rect objects for buttons
	private UIButton goButton;
	private String title = "Bubbleoid Vortex";
	
	public MenuState(int gameWidth, int gameHeight){
		super(gameWidth, gameHeight);
	}

	@Override
	public void init() {
		goButton = new UIButton(50, 400, 250, 500, Assets.goUp, Assets.goDown);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.background, 0, 0);
		renderTitle(g);
		goButton.render(g);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		if(e.getAction()==MotionEvent.ACTION_DOWN){
			goButton.onTouchDown(scaledX, scaledY);
		}
		
		if(e.getAction()==MotionEvent.ACTION_UP){
			if(goButton.isPressed(scaledX, scaledY)){
				goButton.cancel();
				//Log.d("MenuState", "Play Button Pressed");
				setCurrentState(new PlayState(this.gameWdith, this.gameHeight));
			}else{
				goButton.cancel();
			}
			
		}
		
		return true;
	}
	
	private void renderTitle(Painter g){
		g.setFont(Typeface.SANS_SERIF, 30);
		g.setColor(Color.RED);       // hor  ver
		g.drawString(""+title, 20, 75);
	}

}
