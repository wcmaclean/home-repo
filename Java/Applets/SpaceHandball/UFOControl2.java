import java.awt.*;
import java.applet.*;

public class UFOControl2 extends Applet implements Runnable{
	Thread animation;
	
	Graphics offscreen;
	Image image;
	
	static final int NUM_SPRITES = 1;
	static final int REFRESH_RATE = 80; 		// in ms

	Sprite2D sprites[];
	int width, height;

	public void init(){
		System.out.println(">>init<<");
		setBackground(Color.black);
		width = bounds().width;
		height = bounds().height;
		initSprites();
		image = createImage(width,height);	// make offscreen buffer
		offscreen = image.getGraphics();
	}

	public void initSprites(){
		sprites = new Sprite2D[NUM_SPRITES];
		Image backImage;
		Image foreImage[] = new Image[4]; 	// 4 foreground images
		
		MediaTracker t = new MediaTracker(this);
		//backImage = getImage(getCodeBase(),"blank.gif");
		//t.addImage(backImage,0);
		for(int i=0; i<4; i++){
			foreImage[i] = getImage(getCodeBase(),
					"uforia" + i + ".gif");
			t.addImage(foreImage[i],0);
		}

		System.out.println("Loading Images");
		
		// wait for all images to finish loading 
		try{
			t.waitForAll();
		}catch (InterruptedException e){
			return;
		}

		// check for errors
		if(t.isErrorAny()){
			System.out.println("error");
		}else if(t.checkAll()){
			System.out.println("successfully loaded");
		}
		
		// initialize the BitmapLoop
		//sprites[0] = new BitmapLoop(13,17,backImage,foreImage,this);
		sprites[0] = new BitmapLooper(13,17,foreImage,this);
	}


	public boolean mouseMove(Event e, int x, int y){
		((Moveable)sprites[0]).setPosition(x,y);
		return true;

	}
	

	public boolean mouseDrag(Event e, int x, int y){
		((Moveable)sprites[0]).setPosition(x,y);
		return true;

	}

	

/*
	// Move UFO depending on Arrow Keys
	public boolean keyDown(Event e, int key){
		switch (key) {
			case Event.RIGHT:
				((Moveable)sprites[0]).setVelocity(3,0);
				break;
			case Event.LEFT:
				((Moveable)sprites[0]).setVelocity(-3,0);
				break;
			case Event.UP:
				((Moveable)sprites[0]).setVelocity(0,-3);
				break;
			case Event.DOWN:
				((Moveable)sprites[0]).setVelocity(0,3);
				break;
			default:
				break;
		}
		return true;
		
	}
*/

	public void start(){
		System.out.println(">>start<<");
		animation = new Thread(this);
		if(animation != null){
			animation.start();
		}
	}

	// call each sprites update() method
	// dynamic binding occurs here
	public void updateSprites(){
		for(int i=0; i<sprites.length; i++){
			sprites[i].update();
		}
	}

	// override update so it doesn't erase screen
	public void update(Graphics g){
		paint(g);
	}

	public void paint(Graphics g){
		offscreen.setColor(Color.black);
		offscreen.fillRect(0,0,width,height);		// clear buffer
		
		for(int i=0; i<sprites.length; i++){
			sprites[i].paint(offscreen);
		}
		g.drawImage(image,0,0,this);
	}

	public void run(){
		while(true){
			repaint();
			updateSprites();
			try{
				Thread.sleep(REFRESH_RATE);
			}catch (Exception exc){};
		}	
	}

	public void stop(){
		System.out.println(">>stop<<");
		if(animation != null) {
			animation.stop();
			animation = null;
		}
	}
}


