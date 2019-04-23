import java.applet.*;
import java.awt.*;


public class UFOManager2{
	
	static int width, height;		// applet dimensions
	private UFO ufo[];
	static final int NUM_UFOS = 7;

	public UFOManager2(int width, int height, Image ufoImages[], Applet a) {
		this.width = width;
		this.height = height;

		ufo = new UFO[NUM_UFOS];
		for(int i=0; i<ufo.length; i++){
			ufo[i] = new UFO(ufoImages,width,height,a);
			initializePosition(ufo[i]);
		}
	}

	// this method tells the UFO class where the gun is 
	// so the UFOs know if they've collided with it
	public void initialize(GunManager2 gm){
		UFO.initialize(gm);
	}

	private void initializePosition(Moveable m){
		m.setPosition(UFO.getRand(width-100)+50,
				UFO.getRand(height-150)+10);
	}

	// accessor, so the sprite knows where targets are
	public UFO[] getUFO(){
		return ufo;
	}

	public void paint(Graphics g){
		for (int i=0; i<ufo.length; i++){
			ufo[i].paint(g);
		}
	}

	public void update(){
		for (int i=0; i<ufo.length; i++) {
			if (ufo[i].isActive()){
				ufo[i].update();
			}
			else{
				// restore UFO at diff locale
				initializePosition(ufo[i]);
				ufo[i].restore();
			}
		}
	}
}
