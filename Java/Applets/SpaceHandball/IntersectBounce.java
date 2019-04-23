import java.awt.*;
import java.applet.*;

interface IntersectBounce{
	public boolean intersect(int x1, int y1, int x2, int y2);
	public void hit();
	public void bounce(int x1, int y1, int x2, int y2);
}
