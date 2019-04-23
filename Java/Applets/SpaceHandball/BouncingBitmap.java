import java.applet.*;
import java.awt.*;

class BouncingBitmap extends BitmapSprite implements Moveable{

	// the coords where the bitmap bounces
	protected int max_width;
	protected int max_height;
	
	// sprite velocity.  used to implement Moveable interface
	protected int vx;
	protected int vy;

	public BouncingBitmap(int x, int y, Image i, Applet a, 
						int max_w, int max_h) {
		super(x,y,i,a);
		max_width = max_w;
		max_height = max_h;
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

	// move and bounce bitmap if it hits borders
	public void update(){

		// flip x velocity if it hits left or right bounds
		if ((Locx + width > max_width) || Locx < 0) {
			vx = -vy;
		}
		
		// flip y velocity if it hits top or bottom bounds
		if ((Locy + height > max_height) || Locy < 0){
			vy = -vy;
		}
	updatePosition();
	}
}
