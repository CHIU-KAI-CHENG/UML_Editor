package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Group extends SelectableObject {
	ArrayList<SelectableObject> objects = new ArrayList<>();

	
	public void setRect(int x1, int y1, int x2, int y2) {
		r.x = (x1 < x2) ? x1 : x2;
		r.y = (y1 < y2) ? y1 : y2;
		r.width = Math.abs(x1 - x2);
		r.height = Math.abs(y1 - y2);
	}
	
	public boolean isEmpty() {
		return objects.size() > 0 ? false : true;
	}
	
	public ArrayList<SelectableObject> getObjects() {
		return objects;
	}

	public boolean addObjects(ArrayList<SelectableObject> objs) {
		for (SelectableObject so: objs) {			
			if (so.isInside(r) && !objects.contains(so)) {
				this.objects.add(so);
				so.select();
			}
			if (!so.isInside(r) && objects.contains(so)) {
				this.objects.remove(so);
				so.unselect();
			}
		}
		return false;
	}
	
	@Override
	public void ungroup() {
		for (SelectableObject o: objects) {
			o.setParentObj(null);
		}
	}

	@Override
	public void select() {
		for (Selectable s: objects) {
			s.select();
		}
	}

	@Override
	public void unselect() {
		for (Selectable s: objects) {
			s.unselect();
		}
	}
	
	@Override
	public boolean isInside(Rectangle rec) {
		boolean ret = true;
		for (Selectable s: objects) {
			if (!s.isInside(rec)) {
				ret = false;
				break;
			}
		}
		return ret;
	}
	
	@Override
	public boolean isContain(Point p) {
		boolean ret = false;
		for (SelectableObject so: objects) {
			if (so.isContain(p)) {
				ret = true;
				break;
			}
		}
		return ret;		
	}

	@Override
	public void resetLocation(int moveX, int moveY) {
		for (SelectableObject so: objects) {
			so.resetLocation(moveX, moveY);
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(209, 233, 255, 85));
		g.fillRect(r.x, r.y, r.width, r.height);
		
		g.setColor(new Color(148, 148, 255, 180));
		g.drawRect(r.x, r.y, r.width, r.height);
	}
	
}
