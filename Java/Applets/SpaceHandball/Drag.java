import java.awt.*;
import java.applet.*;

////////////////////////////////////////////////////////////////////////////
public class Drag extends Applet{
	Font courierFont;
	String testString = "Drag the Rectangle!";
	DragRect r = new DragRect(0,0,107,103,Color.red);

	public void init(){
		courierFont = new Font("Courier",Font.BOLD+Font.ITALIC,14);
	}

	public void paint(Graphics g){
		g.setFont(courierFont);

		// center the string
		FontMetrics m = g.getFontMetrics();
		int stringWidth = m.stringWidth(testString);
		int width = (bounds().width - stringWidth )/2;
		int height = bounds().height / 2;

		// draw the string
		g.setColor(Color.green);
		g.drawString(testString,width,height);
		r.paint(g);
	}

	// if user clicks in the rectangle make it draggable
	int oldx, oldy;					// old mouse location
	public boolean mouseDown(Event e, int x, int y){
		if(r.inside(x,y)){
			oldx = x;
			oldy = y;
			r.setDraggable(true);
		}
		return true;
	}

	// if mouseUp, rectangle is no longer draggable
	public boolean mouseUp(Event e, int x, int y){
		r.setDraggable(false);
		return true;
	}

	// translate the rectangle by the diff between 
	// new mouse position and old
	public boolean mouseDrag(Event e, int x, int y){
		if(r.isDraggable()){
			r.translate(x-oldx, y-oldy);		//move rectangle
			oldx = x;
			oldy = y;
			repaint();
		}	
		return true;
	}

	// resize triangle
	// right arrow = grow
	// left arrow = shrink
	public boolean keyDown(Event e, int key){
		switch(key){
			case Event.RIGHT:
				r.grow();
				repaint();
				break;
			case Event.LEFT:
				r.shrink();
				repaint();
				break;
		}
		return true;
	}
}