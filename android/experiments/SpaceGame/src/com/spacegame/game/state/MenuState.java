package com.spacegame.game.state;


import android.view.MotionEvent;
import android.graphics.Rect;
import android.util.Log;

import com.spacegame.framework.util.Painter;
import com.spacegame.framework.util.UIButton;
import com.spacegame.simplegdf.Assets;

public class MenuState extends State{
	
	// Declare Rect objects for buttons
	private UIButton goButton;

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
				setCurrentState(new PlayState());
			}else{
				goButton.cancel();
			}
			
		}
		
		return true;
	}

}
