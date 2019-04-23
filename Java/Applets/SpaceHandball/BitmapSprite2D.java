import java.applet.*;
import java.awt.*;

class BitmapSprite2D extends Sprite2D {
	protected int Locx;
	protected int Locy;

	// image dimensions
	protected int width, height;

	Image image;			// the bitmap
	Applet applet;			// the parent applet

	public BitmapSprite2D(Image i, Applet a){
		Locx=0;
		Locy=0;
		image=i;
		applet=a;
		if(image!=null){
			width=image.getWidth(a); // get background
			height=image.getHeight(a);
		}
		restore();
	}


	public BitmapSprite2D(int x, int y, Image i, Applet a){
		Locx = x;
		Locy = y;
		image = i;
		applet = a;
		if(image != null){
			width = image.getWidth(a); // size of background
			height = image.getHeight(a);
		}
		restore();
	}

	public BitmapSprite2D(int x, int y, Applet a){
		Locx = x;
		Locy = y;
		applet = a;
		if(image != null){
			width = image.getWidth(a); // size of background
			height = image.getHeight(a);
		}
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

	