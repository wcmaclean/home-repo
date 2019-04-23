import java.awt.*;
import java.applet.*;

class GunSprite extends BitmapSprite implements Moveable,Intersect{
	
	public GunSprite(Image i, Applet a){
		super(i,a);
	}

	// implements Moaveable:
	
	public void setPosition(int x, int y){
		Locx = x;
		Locy = y;
	}

	public void setVelocity(int x, int y){
		// nada
	}

	public void updatePosition(){
		// nada
	}

	// implement Intersect
	
	// compare bounding boxes
	public boolean intersect(int x1, int y1, int x2, int y2){
		return visible && (x2>=Locx) && (Locx+width>=x1)
				&& (y2>=Locy) && (Locy+height>=y1);
	}

	// echo to stdout
	public void hit(){
		System.out.println("HIT!");
	}
}			