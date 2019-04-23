import java.awt.*;
import java.applet.*;

class BitmapLoop extends BitmapSprite implements Moveable{
	protected Image images[];		// sequence of bitmaps
	protected int currentImage;		// the current bitmap
	protected boolean foreground;		// are there foreground images?
	protected boolean background;

	// constructor - assumes background image is already loaded
	public BitmapLoop(int x, int y, Image b, Image f[], Applet a){
		super(x,y,b,a);
		if (image != null){
			background = true;
		}else{
			background = false;
		}

		images = f;
		currentImage = 0;
		if(images == null || images.length == 0){
			foreground = false;	// nothing in array of images
		}else{
			foreground = true;
			if(!background){
				width = images[0].getWidth(a);
				height = images[0].getHeight(a);
			}
		}
	}

	// cycle currentImage id sprite is active, 
	// and there are foreground images
	public void update(){
		if(active && foreground){
			currentImage = (currentImage + 1) % images.length;
		}
		updatePosition();
	}

	public void paint(Graphics g){
		if(visible){			// draw background first
			g.drawImage(image,Locx,Locy,applet);
			if(foreground){		//now draw foreground image
				g.drawImage(images[currentImage],Locx,Locy,applet);
			}
		}
	}

	// implement Moveable interface
	public void setPosition(int x, int y){
		Locx = x;
		Locy = y;
	}
	protected int vx;
	protected int vy;
	
	public void setVelocity(int x, int y){
		vx = x;
		vy = y;
	}

	// update position according to velocity
	public void updatePosition(){
		Locx += vx;
		Locy += vy;
		vx=0;
		vy=0;
	}
}

	