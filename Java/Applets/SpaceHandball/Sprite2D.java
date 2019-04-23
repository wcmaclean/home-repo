import java.applet.*;
import java.awt.*;

abstract class Sprite2D extends Sprite implements IntersectBounce{
	
	protected int Locx;
	protected int Locy;

	Color color;
	boolean fill;

	public boolean getFill(){
		return fill;
	}

	public void setFill(boolean b){
		fill = b;
	}

	public void setColor(Color c){
		color = c;
	}

	public Color getColor(){
		return color;
	}

/******************************************************** Implementing IntersectBounce */
	public boolean intersect(int x1, int y1, int x2, int y2){
		return false;
	}

	public void hit(){
		// nada
	}

	public void bounce(int x1, int y1, int x2, int y2){
		// nada

	}
}