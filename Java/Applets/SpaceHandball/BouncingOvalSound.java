import java.applet.*;
import java.awt.*;
import java.util.*;
	
class BouncingOvalSound extends OvalSprite implements Moveable, IntersectBounce{

	// the coords where the oval bounces
	protected int max_width;
	protected int max_height;

	// sprite 
	protected int vx;
	protected int vy;

	// bouncing sound array
	protected AudioClip aud[];

	public BouncingOvalSound(int x, int y, int w, int h, Color c, 
				int max_w, int max_h, AudioClip aud_new[]) {
		super(x,y,w,h,c);
		max_width = max_w;
		max_height = max_h;
		aud = aud_new;
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
		if((Locx + width > max_width)){
			vx = -vx;
			aud[0].play();
		}

		if(Locx < 0){
			vx = -vx;
			aud[2].play();
		}

		// flip y velocity if it hits top or bottom bound
		if((Locy + height > max_height)){
			vy = -vy;
			aud[1].play();
		}

		if(Locy < 0){
			vy = -vy;
			aud[3].play();
		}
	
		updatePosition();
	}

	public int randomized(){
		Random Noise = new Random();
		int i = Noise.nextInt();
		if(i>3){
			randomized();
		}
		return i;
	}

/******************************************************** Implementing IntersectBounce */
	public boolean intersect(int x1, int y1, int x2, int y2){



		return visible && (x2 >= Locx) && (Locx+width >= x1) && (y2 >= Locy)
				&& (Locy+height >= y1);
	}

	public void hit(){
		// nada
	}

	public void bounce(int x1, int y1, int x2, int y2){
		vy = -vy;
		vx = -vx;
		// top... right
		if((this.Locx >= x1) && (this.Locx <= x2) && (y1 == Locy)){
			vy = -vy;

//			aud[0].play();
		}
		// bottom... left
		if((this.Locx >= x1) && (this.Locx <= x2) && (y2 == Locy+height)){
			vy = -vy;
//			aud[2].play();
		}

		// left... bottom
		if((x1 == Locx) && (this.Locy >= y1) && (this.Locy <= y2)){

			vx = -vx;
//			aud[1].play();
		}
		// right... top
		if((x2 == Locx+width) && (this.Locy >= y1) && (this.Locy <= y2)){
	
			vx = -vx;
//			aud[3].play();
		}
	
		updatePosition();

	}
	
}



