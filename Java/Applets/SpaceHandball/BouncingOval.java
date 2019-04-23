import java.applet.*;
import java.awt.*;
	
class BouncingOval extends OvalSprite implements Moveable{

	// the coords where the oval bounces
	protected int max_width;
	protected int max_height;

	// sprite 
	protected int vx;
	protected int vy;

	public BouncingOval(int x, int y, int w, int h, Color c, 
				int max_w, int max_h) {
		super(x,y,w,h,c);
		max_width = max_w;
		max_height = max_h;
	}

	// implements Moveable interface
	public void setPosition(int x, int y){
		Locx = x;
		Locy = y;
	}

	public void setVelocity(int x, int y){
		vx = x;
		vy = y;
	}

	// update position according to velocity
	public void updatePosition(){
		Locx += vx;
		Locy += vy;
	}

	// move and bounce oval if it hits left or right bound
	public void update(){
		
		// flip x velocity if it hits left or right bound
		if((Locx + width > max_width) || Locx < 0){
			vx = -vx;
		}

		// flip y velocity if it hits top or bottom bound
		if((Locy + height > max_height) || Locy < 0){
			vy = -vy;
		}
	
		updatePosition();
	}
}
