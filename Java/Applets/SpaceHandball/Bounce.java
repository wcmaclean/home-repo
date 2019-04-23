import java.applet.*;
import java.awt.*;

public class Bounce extends Applet implements Runnable{

	Thread animation;
	
	Graphics offscreen;
	Image image;

	static final int NUM_SPRITES = 3;
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
		
		// define sprite for border
		sprites[0] = new RectSprite(0,0,width-1,height-1,Color.green);
		sprites[1] = new BouncingRect(0,0,30,30,Color.yellow,width-1,height-1);
		sprites[2] = new BouncingRect(17,17,13,13,Color.red,width-1,height-1);
		
		((Moveable)sprites[1]).setVelocity(4,3);
		((Moveable)sprites[2]).setVelocity(1,2);
		((Sprite2D)sprites[2]).setFill(true);

	}

	public void start(){
		System.out.println(">> start <<");
		animation = new Thread(this);
		if(animation!=null) {
			animation.start();
		}

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
		if(animation!=null){
			animation.stop();
			animation = null;
		}
	}
}