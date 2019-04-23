import java.awt.*;
import java.applet.*;

class MissileSprite extends RectSprite{
	protected int vy;		// velocity in y coord
	protected int start_y;		// starting y coord
	protected int stop_y;		// stop at y coord
	Intersect target[];

	public MissileSprite(int w, int h, Color c, int vy, 
				int start_y, int stop_y, Intersect target[]){
		super(w,h,c);
		setFill(true);
		this.vy=vy;			// init speed
		this.start_y=start_y;		// init start point
		this.stop_y=stop_y;		// init end point
		this.target=target;		// init targets
		suspend();
	}

	// start missile at given x coord
	public void init(int x){
		Locx=x;
		Locy=start_y;
		restore();
	}

	public void update(){
		
		if(active){
			
			// move missile
			Locy+=vy;
			if(Locy<stop_y){
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
