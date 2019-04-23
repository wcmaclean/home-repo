import java.awt.*;
import java.applet.*;


///////////////////////////////////////////////////////////////////////////
class DragRect extends RectSprite{

	protected boolean draggable;	// is rect draggable?
	
	// accessors
	public void setDraggable(boolean b) {
		draggable = b;
	}

	// return draggable
	public boolean isDraggable() {
		return draggable;
	}

	// check if (x,y) is inside the rectangle
	public boolean inside(int x, int y){
		return(Locx <= x 
		&& Locy <= y
		&& (Locx + width >= x)
		&& (Locy + height >= y));
	}

	public void translate(int x, int y){
		Locx += x;
		Locy += y;
	}

	public DragRect(int x, int y, int w, int h, Color c){
		super(x,y,w,h,c);
		fill = true;
		draggable = false; 	// initially not draggable
	}

	// increase size of rectangle. no max size
	public void grow(){
		width++;
		height++;
	}

	// shrink the rectangle
	public void shrink(){
		if(width > 0){
			width--;
		}
		if(height > 0){
			height--;
		}
	}
}
