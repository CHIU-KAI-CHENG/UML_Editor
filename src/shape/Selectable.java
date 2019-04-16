package shape;

import java.awt.Point;
import java.awt.Rectangle;

public interface Selectable {
	public void select();
	public void unselect();
	public boolean isInside(Rectangle rec);
	public boolean isContain(Point p);
	public void resetLocation(int moveX, int moveY);
}
