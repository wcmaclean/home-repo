import java.applet.*;
import java.awt.*;

class OvalSprite extends Sprite2D{

	protected int width, height;		// dimensions 

	public OvalSprite(int x, int y, int w, int h, Color c){
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
				g.fillOval(Locx,Locy,width,height);
			}
		
			else{
				g.drawOval(Locx,Locy,width,height);
			}
		}
	}
}
