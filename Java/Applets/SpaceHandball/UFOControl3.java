import java.awt.*;
import java.applet.*;

/** 
Description:
UFOControl3 draws a box, and in the box is a green ball zooming around 
and an animated sprite of a UFO.  The ball bounces from wall-to-wall, 
triggering a different sound (.au format) when it hits each wall.  
The UFO is mouse-controlled, and will allow the user to bounce the ball
off the UFO to change the direction of the ball.

*/

public class UFOControl3 extends Applet implements Runnable{


	Thread animation;
	
	Graphics offscreen;
	Image image;
	AudioClip Noise[];
	AudioClip a;
	BouncingOvalSound Ball;
	
	static final int NUM_SPRITES = 1;
	static final int REFRESH_RATE = 80; 		// in ms

	BitmapSprite2D sprites[];
	int width, height;


/** init() initializes the background and boundaries, pulling info from html file
*/
	public void init(){
		System.out.println(">>init<<");
		setBackground(Color.black);
		width = bounds().width;
		height = bounds().height;
		initSprites();
		image = createImage(width,height);	// make offscreen buffer
		offscreen = image.getGraphics();
	}

/** initSprites() initializes an array filled with .gifs for animated UFO, as well as a 
ball sprite.  It loads .au files into an array.
*/
	public void initSprites(){
		sprites = new BitmapSprite2D[NUM_SPRITES];
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

		Noise = new AudioClip[4];
		for(int i=0;i<=3;i++){
			Noise[i] = getAudioClip(getCodeBase(),"wuh"+i+".au");
		}
		

		Ball = new BouncingOvalSound(13,13,17,17,Color.green,bounds().width,bounds().height,Noise);

		((Moveable)Ball).setVelocity(10,6);
		((Sprite2D)Ball).setFill(true);



	}


/** mouseMove() reads the location of the mouse, which is used for plotting location of UFO.
*/
	public boolean mouseMove(Event e, int x, int y){
		((Moveable)sprites[0]).setPosition(x,y);
		return true;

	}
	

/** mouseDrag() read the location of the mouse, which is used for plotting location of UFO.
*/
	public boolean mouseDrag(Event e, int x, int y){
		((Moveable)sprites[0]).setPosition(x,y);
		return true;

	}

	

/** keyDown() uses arrow keys for moving the UFO.
*/
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

/* start() begins the animation thread, and loads and loops the beats (.au file).
*/
	public void start(){
		System.out.println(">>start<<");
		animation = new Thread(this);
		if(animation != null){
			animation.start();
		}
		a = getAudioClip(getCodeBase(), "humjam.au");
		a.loop(); 
	}

	// call each sprites update() method
	// dynamic binding occurs here

/** updateSprites() uses a for loop to animate UFO, and accesses intersect() to see
if bounding boxes of the ball and UFO overlap.
*/
	public void updateSprites(){
		for(int i=0; i<sprites.length; i++){
			sprites[i].update();

			if(Ball.intersect(sprites[i].Locx, sprites[i].Locy, sprites[i].Locx+68, 
					sprites[i].Locy+44)){
showStatus("OUCH!");
				Ball.bounce(sprites[i].Locx, sprites[i].Locy, 
						sprites[i].Locx+68, sprites[i].Locy+44);
			}

		}
		Ball.update();

	}

/** update() repaints the updated pictures to graphics object g.
*/
	// override update so it doesn't erase screen
	public void update(Graphics g){
		paint(g);
	}

/** paint() redraws offscreen buffer.
*/
	public void paint(Graphics g){
		offscreen.setColor(Color.black);
		offscreen.fillRect(0,0,width,height);		// clear buffer
		
		for(int i=0; i<sprites.length; i++){
			sprites[i].paint(offscreen);
			Ball.paint(offscreen);
		}
		g.drawImage(image,0,0,this);
	}

/** run() makes it happen.
*/
	public void run(){
		while(true){
			repaint();
			updateSprites();
			try{
				Thread.sleep(REFRESH_RATE);
			}catch (Exception exc){};
		}	
	}

/** stop() is the end of it all.
*/
	public void stop(){
		System.out.println(">>stop<<");
		if(animation != null) {
			animation.stop();
			animation = null;
		}
	}
}


