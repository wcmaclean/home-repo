import java.applet.*;
import java.awt.*;

class BouncingBitmapSound extends BitmapSprite implements Moveable{

	// the coords where the bitmap bounces
	protected int max_width;
	protected int max_height;
	
	// sprite velocity.  used to implement Moveable interface
	protected int vx;
	protected int vy;

	// sound... makes this when bounced
	protected AudioClip aud;

	public BouncingBitmapSound(int x, int y, Image i, Applet a, 
						int max_w, int max_h,
						AudioClip new_aud) {
		super(x,y,i,a);
		max_width = max_w;
		max_height = max_h;
		aud = new_aud;
	}

	public void setPosition(int x, int y){
		Locx = x;
		Locy = y;
	}

	public void setVelocity(int x, int y){
		vx = x;
		vy = y;
	}

	// update positions according to velocity
	public void updatePosition(){
		Locx += vx;
		Locy += vy;
	}

	public void setAudioClip(AudioClip new_aud){
		aud = new_aud;
	}

	// move and bounce bitmap if it hits borders
	public void update(){

		// flip x velocity if it hits left or right bounds
		if ((Locx + width > max_width) || Locx < 0) {
			vx = -vy;
			aud.play();
		}
		
		// flip y velocity if it hits top or bottom bounds
		if ((Locy + height > max_height) || Locy < 0){
			vy = -vy;
			aud.play();
		}
	updatePosition();
	}

	

}


class BitmapSprite extends Sprite {
	protected int Locx;
	protected int Locy;

	// image dimensions
	protected int width, height;

	Image image;			// the bitmap
	Applet applet;			// the parent applet

	public BitmapSprite(int x, int y, Image i, Applet a){
		Locx = x;
		Locy = y;
		image = i;
		applet = a;
		restore();
	}

	// set the size of the bitmap
	public void setSize(int w, int h){
		width = w;
		height = h;
	}

	public void update(){

		// squat

	}

	public void paint(Graphics g){
		if (visible){
			g.drawImage(image,Locx,Locy,applet);
		}
	}
}
