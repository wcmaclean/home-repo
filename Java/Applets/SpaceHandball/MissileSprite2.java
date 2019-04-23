import java.awt.*;
import java.applet.*;

class MissileSprite2 extends RectSprite{
	protected int vy;		// velocity in y coord
	protected int start_x;		// starting x coord
	protected int stop_x;		// stop at x coord
	Intersect target[];

	public MissileSprite2(int w, int h, Color c, int vy, 
				int start_x, int stop_x, Intersect target[]){
		super(w,h,c);
		setFill(true);
		this.vy=vy;			// init speed
		this.start_x=start_x;		// init start point
		this.stop_x=stop_x;		// init end point
		this.target=target;		// init targets
		suspend();
	}

	// start missile at given y coord
	public void init(int y){
		Locy=y;
		Locx=start_x;
		restore();
	}

	public void update(){
		
		if(active){
			
			// move missile
			Locx+=vy;
			if(Locx<stop_x){
				suspend();
			}	
			// else if missile hits target, suspend
			else{
				for(int i=0;i<target.length;i++){
					if(target[i].intersect(Locx,Locy+height,
							Locx+width,Locy+height)){
						// tell taret it's been hit
						target[i].hit(); 
						
						suspend();
						break;
					}
				}
			}
		}
	}
}
