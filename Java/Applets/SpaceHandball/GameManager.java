import java.applet.*;
import java.awt.*;

public class GameManager extends Applet implements Runnable{
	
	Thread animation;
	Graphics offscreen;
	Image image;

	static final int REFRESH_RATE = 20;	// in ms

	Image ufoImages[] = new Image[6];
	Image gunImage;
	GunManager gm;
	UFOManager um;

	int width, height;

	public void init(){
		showStatus("Loading Images -- WAIT!!");
		setBackground(Color.black);
		width = bounds().width;
		height = bounds().height;
		loadImages();
		um = new UFOManager(width,height,ufoImages,this);
		gm = new GunManager(width,height,gunImage,um.getUFO(),this);
		um.initialize(gm);
		image = createImage(width,height);
		offscreen = image.getGraphics();
	}

	public void loadImages(){
		MediaTracker t = new MediaTracker(this);
		gunImage = getImage(getCodeBase(),"image/gun.gif");
		t.addImage(gunImage,0);
		for(int i=0; i<6; i++){
			ufoImages[i] = getImage(getCodeBase(),"image/ufo"+i+".gif");
			t.addImage(ufoImages[i],0);
		}
	
	
		// wait for all images to finish loading
		try {
			t.waitForAll();
		}catch (InterruptedException e) {
		}
	
		// check for errors
		if(t.isErrorAny()){
			showStatus("Error Loading Images");
		}
		else if (t.checkAll()) {
			showStatus("Images happily loaded");
		}

		// intialize the bitmaploop
	}

	public boolean mouseMove(Event e, int x, int y){
		gm.moveGun(x);
		return true;
	}

	public boolean mouseDrag(Event e, int x, int y){
		gm.moveGun(x);
		return true;
	}

	public boolean mouseDown(Event e, int x, int y){
		gm.fireMissile(x);
		return true;
	}

	public void start(){
		showStatus("Starting Game");
		animation = new Thread(this);
		if(animation != null){
			animation.start();
		}
	}

	public void updateManagers(){
		gm.update();
		um.update();
	}

	// override update so it don't erase screen
	public void update(Graphics g){
		paint(g);
	}

	public void paint(Graphics g){
		offscreen.setColor(Color.black);
		offscreen.fillRect(0,0,width,height);	// clear buffer
		
		gm.paint(offscreen);
		um.paint(offscreen);
		
		g.drawImage(image,0,0,this);

	}

	public void run(){
		while(true){
			repaint();
			updateManagers();
			Thread.currentThread().yield();
			try{
				Thread.sleep(REFRESH_RATE);
			}catch (Exception exc){
			}
		}
	}
		
	public void stop(){
		showStatus("Game Stopped");
		if(animation!=null){
			animation.stop();
			animation = null;
		}
	}
}