package shape;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public abstract class BasicObject extends SelectableObject{
	final int TOP = 0;
	final int LEFT = 1;
	final int BOT = 2;
	final int RIGHT = 3;
	protected boolean isSelected = false;
	protected String name;
	protected Port[] ports = new Port[4];
	
	protected View view;
	
	private Group parentGroup = null;
	
	public int getX() {
		return r.x;
	}
	
	public int getY() {
		return r.y;
	}
	
	public View getView() {
		return view;
	}
	
	public String getName() {
		return name;
	}
	
	protected void setPorts() {
		ports[TOP] = new Port(r.width / 2 , 0, r.x, r.y);
		ports[LEFT] = new Port(0, r.height / 2, r.x, r.y);
		ports[BOT] = new Port(r.width / 2, r.height, r.x, r.y);
		ports[RIGHT] = new Port(r.width, r.height / 2, r.x, r.y);
	}
	
	public void changeName(String newName) {
		this.name = newName;
		view.repaint();
	}
	
	public void repaint() {
		view.repaint();
	}
	
	@Override
	public void ungroup() {
		SelectableObject so = parentObj;
		while(so.getParentObj() != null) {
			so = so.getParentObj();
		}
		so.ungroup();
	}
	
	@Override
	public void select() {
		if (parentGroup == null) {
			isSelected = true;
			view.repaint();
		}
		else {
			parentGroup.select();
		}
	}
	
	@Override
	public void unselect() {
		isSelected = false;
		view.repaint();
	}
	
	@Override
	public boolean isInside(Rectangle rec) {
		return rec.contains(this.r);
	}
	
	@Override
	public boolean isContain(Point p) {
		boolean ret = true;
		if (p.x < r.x || p.y < r.y) {
			ret = false;
		}
		if (p.x > r.x + r.width || p.y > r.y + r.height) {
			ret = false;
		}
		
		return ret;
	}
	
	@Override
	public void resetLocation(int moveX, int moveY) {
		r.x += moveX;
		r.y += moveY;
		for (Port p: ports) {
			p.setParentX(r.x);
			p.setParentY(r.y);
		}
		view.setBounds(r.x, r.y, r.width, r.height);
		view.repaint();
	}
	
	public Port getNearest(int x, int y) {
		x -= r.x;
		y -= r.y;
		Port retPort = null;
		int shortest = Integer.MAX_VALUE;
		int edge1, edge2, distance;
		for(int i = 0; i < 4; i++) {
			edge1 = Math.abs(ports[i].getInitX() - x);
			edge2 = Math.abs(ports[i].getInitY() - y);
			distance = edge1 * edge1 + edge2 * edge2;
			if (distance < shortest) {
				shortest = distance;
				retPort = ports[i];
			}
		}
		return retPort;
	}
	
	protected void drawPorts(Graphics g) {
		g.fillRect(ports[TOP].getInitX(), ports[TOP].getInitY(), Port.offset * 2, Port.offset * 2);
		g.fillRect(ports[LEFT].getInitX(), ports[LEFT].getInitY(), Port.offset * 2, Port.offset * 2);
		g.fillRect(ports[BOT].getInitX(), ports[BOT].getInitY(), Port.offset * 2, Port.offset * 2);
		g.fillRect(ports[RIGHT].getInitX(), ports[RIGHT].getInitY(), Port.offset * 2, Port.offset * 2);
	}
	
	protected abstract class View extends JLabel {
		@Override
		public abstract void paint(Graphics g);
	}

}
