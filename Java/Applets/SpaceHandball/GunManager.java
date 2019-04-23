import java.applet.*;
import java.awt.*;

public class GunManager{

	private GunSprite gun;				// your gun
	private int gun_width;
	private int gun_height;
	private MissileSprite missile;			// missile
	static int width, height;			// applet dimensions
	private int min_x,max_x;			// min coords for gun move

	private int gun_min_x, gun_max_x;
	private int mis_min_x, mis_max_x;
	private int gun_y;

	static final int MISSILE_WIDTH = 3;
	static final int MISSILE_HEIGHT = 27;
	static final int MISSILE_SPEED = -27;		// missile flies up
	static final Color MISSILE_COLOR = Color.red;

	public GunManager(int width, int height, Image gunImage, 
				Intersect target[], Applet a){
		this.width = width;
		this.height = height;
		gun = new GunSprite(gunImage, a);

		gun_width = gunImage.getWidth(a)/2;
		gun_height = gunImage.getHeight(a);

		gun_y = height - gun_height;
		min_x = gun_width;
		max_x = width - gun_width;
		gun_min_x = 0;
		gun_max_x = width - 2*gun_width;
		mis_min_x = min_x-2;
		mis_max_x = max_x-2;
		gun.setPosition(width/2-gun_width,gun_y);

		missile = new MissileSprite(MISSILE_WIDTH, MISSILE_HEIGHT,
						MISSILE_COLOR, MISSILE_SPEED,
						height-gun_height,
						0, target);
		}
		

		// move gun to given x coord
		public void moveGun(int x){
			if (x<=min_x){
				gun.setPosition(gun_min_x, gun_y);
			}else if (x>=max_x){
				gun.setPosition(gun_max_x, gun_y);
			}else{
				gun.setPosition(x-gun_width, gun_y);
			}
		}

		// fire missile from given x coord
		public void fireMissile(int x){
			if(!missile.isActive()){
				if(x >= max_x){
					missile.init(mis_min_x);
				}else if (x <= min_x){
					missile.init(mis_min_x);
				}else{
					missile.init(x+2);
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
