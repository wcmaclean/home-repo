import java.applet.*;
import java.awt.*;

public class FilamentalBounce5 extends Applet implements Runnable{

	Thread animation;
	
	Graphics offscreen;
	Image image;
	AudioClip a;

	static final int NUM_FRAMES = 4;	// UFO
	static final int NUM_SPRITES = 7;	// shapes and band
	static final int REFRESH_RATE = 80; 	// in ms

	Sprite sprites[];
	int width, height;
	AudioClip Noise[];

	Sprite2D UFO[];


	public void init(){
		System.out.println(">> init <<");
		setBackground(Color.black);
		width = bounds().width;
		height = bounds().height;
		initSprites();
		image = createImage(width,height); 	// make offscreen buffer
		offscreen = image.getGraphics();
	}

	public void initSprites(){
		sprites = new Sprite[NUM_SPRITES]; 	// init sprite array
		
		sprites[0] = new BouncingBitmap(37,37,
						getImage(getCodeBase(),"uforiaAnim.gif"),
						this,
						width-1,height-1);		

		sprites[1] = new BouncingBitmap(37,37,
						getImage(getCodeBase(),"will.gif"),
						this,
						width-1,height-1);
		sprites[2] = new BouncingBitmap(10,10,
						getImage(getCodeBase(),"deric.gif"),
						this,
						width-1,height-1);
		sprites[3] = new BouncingBitmap(100,100,
						getImage(getCodeBase(),"elanor.gif"),
						this,
						width-1,height-1);
		sprites[4] = new BouncingBitmap(100,100,
						getImage(getCodeBase(),"pat.gif"),
						this,
						width-1,height-1);

		sprites[5] = new BouncingRect(0,0,30,30,Color.yellow,width-1,height-1);


//		sprites[5] = new BouncingOval(13,13,17,17,Color.blue,114,114);

		Noise = new AudioClip[4];
		for(int i=0;i<=3;i++){
			Noise[i] = getAudioClip(getCodeBase(),"wuh"+i+".au");
		}
		

		sprites[6] = new BouncingOvalSound(13,13,17,17,Color.blue,114,114,Noise);




		//define sprite for the border
//		sprites[7] = new RectSprite(0,0,width-1,height-1,
//						Color.green);
					


		((Moveable)sprites[4]).setVelocity(3,1);
		((Sprite2D)sprites[4]).setFill(true);
		((Moveable)sprites[5]).setVelocity(3,1);
		((Sprite2D)sprites[5]).setFill(true);

		((Moveable)sprites[0]).setVelocity(1,3);
		((BitmapSprite)sprites[0]).setSize(50,70);

		((Moveable)sprites[1]).setVelocity(2,3);
		((BitmapSprite)sprites[1]).setSize(50,70);

		((Moveable)sprites[2]).setVelocity(2,4);
		((BitmapSprite)sprites[2]).setSize(144,113);

		((Moveable)sprites[3]).setVelocity(2,3);
		((BitmapSprite)sprites[3]).setSize(144,113);

		// Finish initializing the UFO
		UFO = new Sprite2D[NUM_FRAMES];
		Image foreImage[] = new Image[4]; 	// foreground images
		
		MediaTracker t = new MediaTracker(this);
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
		
		UFO[0] = new BitmapLooper(13,17,foreImage,this);

	}

	//**************************************************************************
	// MOving the UFO
	
	public boolean mouseMove(Event e, int x, int y){
		((Moveable)UFO[0]).setPosition(x,y);
		return true;

	}
	

	public boolean mouseDrag(Event e, int x, int y){
		((Moveable)UFO[0]).setPosition(x,y);
		return true;

	}

	


	// Move UFO depending on Arrow Keys
	public boolean keyDown(Event e, int key){
		switch (key) {
			case Event.RIGHT:
				((Moveable)UFO[0]).setVelocity(3,0);
				break;
			case Event.LEFT:
				((Moveable)UFO[0]).setVelocity(-3,0);
				break;
			case Event.UP:
				((Moveable)UFO[0]).setVelocity(0,-3);
				break;
			case Event.DOWN:
				((Moveable)UFO[0]).setVelocity(0,3);
				break;
			default:
				break;
		}
		return true;
		
	}




	public void start(){
		System.out.println(">> start <<");
		animation = new Thread(this);
		if(animation!=null) {
			animation.start();
		}
		a = getAudioClip(getCodeBase(), "humjam.au");
		a.loop(); 

	}

	// call each sprites update() method
	// Dynamic method binding occurs here
	public void updateSprites(){
		for(int i=0; i<sprites.length; i++){
			sprites[i].update();
		}
	}

	// override update() so it doesn't erase screen
	public void update(Graphics g){
		paint(g);
	}

	public void paint(Graphics g){
	
		offscreen.setColor(Color.black);
		offscreen.fillRect(0,0,width,height);		// clear buffer

		for(int i=0; i<sprites.length; i++){
			sprites[i].paint(offscreen);		// paint each rectangle
		}
		// draw UFO
//		for(int i=0; i<sprites.length; i++){
//			UFO[i].paint(offscreen);
//		}

		g.drawImage(image,0,0,this);
	}

	public void run(){
		while(true){
			repaint();
			updateSprites();
			try{
				Thread.sleep(REFRESH_RATE);
			}catch (Exception exc) {
			}
		}
	}

	public void stop(){
		System.out.println(">> stop <<");
		a.stop();
		if(animation!=null){
			animation.stop();
			animation = null;
		}
	}
}