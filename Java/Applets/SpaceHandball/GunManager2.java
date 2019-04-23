import java.applet.*;
import java.awt.*;

public class GunManager2{

	private GunSprite gun;				// your gun
	private int gun_width;
	private int gun_height;
	private MissileSprite2 missile;			// missile
	static int width, height;			// applet dimensions
	private int min_y,max_y;			// min coords for gun move

	private int gun_min_y, gun_max_y;
	private int mis_min_y, mis_max_y;
	private int gun_y;

	static final int MISSILE_WIDTH = 27;
	static final int MISSILE_HEIGHT = 3;
	static final int MISSILE_SPEED = 27;		// missile flies up
	static final Color MISSILE_COLOR = Color.red;

	public GunManager2(int width, int height, Image gunImage, 
				Intersect target[], Applet a){
		this.width = width;
		this.height = height;
		gun = new GunSprite(gunImage, a);

		gun_width = gunImage.getWidth(a)/2;
		gun_height = gunImage.getHeight(a);

		gun_y = width;
		min_y = gun_height;
		max_y = height - gun_height;
		gun_min_y = 0;
		gun_max_y = height - 2*gun_height;
		mis_min_y = min_y-2;
		mis_max_y = max_y-2;
		gun.setPosition(width/2-gun_width,gun_y);

		missile = new MissileSprite2(MISSILE_WIDTH-(MISSILE_WIDTH/2), MISSILE_HEIGHT,
						MISSILE_COLOR, MISSILE_SPEED,
						gun_width,
						width, target);
		}
		

		// move gun to given y coord
		public void moveGun(int y){
			if (y<=min_y){
				gun.setPosition(gun_y, gun_min_y);
			}else if (y>=max_y){
				gun.setPosition(gun_y, gun_max_y);
			}else{
				gun.setPosition(gun_y, y-gun_height);
			}
		}

		// fire missile from given y coord
		public void fireMissile(int y){
			if(!missile.isActive()){
				if(y >= max_y){
					missile.init(mis_min_y);
				}else if (y <= min_y){
					missile.init(mis_min_y);
				}else{
					missile.init(y+2);
				}
			}
		}

		// update all params associated with the gun.
		// in this case, only the missile needs to move
		// automatically.  also, the gun manager checks if 
		// the missile hits anything
		
		public void update(){
			missile.update();
		}

		// paint all sprites associated with the gun
		
		public void paint(Graphics g){
			gun.paint(g);
			missile.paint(g);
		}

		// accessor function for gun
		
		public GunSprite getGun(){
			return gun;
		}

		public int getGunY(){
			return gun_y;
		}
	}
