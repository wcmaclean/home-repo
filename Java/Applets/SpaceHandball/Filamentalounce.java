import java.applet.*;
import java.awt.*;

public class FilamentalBounce extends Applet implements Runnable{

	Thread animation;
	
	Graphics offscreen;
	Image image;
	AudioClip a;

	static final int NUM_SPRITES = 7;
	static final int REFRESH_RATE = 80; 	// in ms

	Sprite sprites[];
	int width, height;

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
						getImage(getCodeBase(),"pat.gif"),
						this,
						width-1,height-1);


		sprites[1] = new BouncingBitmap(10,10,
						getImage(getCodeBase(),"elanor.gif"),
						this,
						width-1,height-1);

		sprites[2] = new BouncingBitmap(100,100,
						getImage(getCodeBase(),"deric.gif"),
						this,
						width-1,height-1);
		sprites[3] = new BouncingBitmap(100,290,
						getImage(getCodeBase(),"will.gif"),
						this,
						width-1,height-1);

		sprites[4] = new BouncingRect(0,0,30,30,Color.yellow,width-1,height-1);


		sprites[5] = new BouncingOval(13,13,17,17,Color.blue,114,114);


		//define sprite for the border
		sprites[6] = new RectSprite(0,0,width-1,height-1,
						Color.green);
					


		((Moveable)sprites[4]).setVelocity(3,1);
		((Sprite2D)sprites[4]).setFill(true);
		((Moveable)sprites[5]).setVelocity(3,1);
		((Sprite2D)sprites[5]).setFill(true);

		((Moveable)sprites[0]).setVelocity(1,3);
		((BitmapSprite)sprites[0]).setSize(50,70);
		((Moveable)sprites[1]).setVelocity(2,4);
		((BitmapSprite)sprites[1]).setSize(50,70);
		((Moveable)sprites[2]).setVelocity(70,70);
		((BitmapSprite)sprites[2]).setSize(144,113);
		((Moveable)sprites[3]).setVelocity(60,70);
		((BitmapSprite)sprites[3]).setSize(144,113);

	}

	public void start(){
		System.out.println(">> start <<");
		animation = new Thread(this);
		if(animation!=null) {
			animation.start();
		}
		a = getAudioClip(getCodeBase(), "Sound.au");
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