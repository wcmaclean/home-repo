import java.applet.*;
import java.awt.*;

class RectSprite extends Sprite2D{

	protected int width, height;		// dimensions of rectangle

	public RectSprite(int w, int h, Color c){
		Locx=0;
		Locy=0;
		width=w;
		height=h;
		color=c;
		restore();
	}

	public RectSprite(int x, int y, int w, int h, Color c){
		Locx = x;
		Locy = y;
		width = w;
		height = h;
		color = c;
		fill = false;			// default: don't fill
		restore();			// restore the sprite
	}

	// implementation of abstract methods

	public void update(){
		
		// does squat
	
	}

	// check if sprite is visible before painting
	public void paint(Graphics g){
		if(visible){
			g.setColor(color);

			if(fill){
				g.fillRect(Locx,Locy,width,height);
			}
		
			else{
				g.drawRect(Locx,Locy,width,height);
			}
		}
	}
}
