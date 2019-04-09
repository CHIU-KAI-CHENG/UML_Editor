package shape;


import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import mode.Mode;

@SuppressWarnings("serial")
public abstract class BasicObject extends JLabel implements Observer {
	final int TOP = 0;
	final int LEFT = 1;
	final int BOT = 2;
	final int RIGHT = 3;
	protected int initX, initY, width, height;
	protected boolean isSelected = false;
	protected String name;
	protected Port[] ports = new Port[4];
	private Mode mode = null;
	
	protected void setPorts() {
		ports[TOP] = new Port(width / 2 , 0, initX, initY);
		ports[LEFT] = new Port(0, height / 2, initX, initY);
		ports[BOT] = new Port(width / 2, height, initX, initY);
		ports[RIGHT] = new Port(width, height / 2, initX, initY);
	}
	
	public void changeName(String newName) {
		this.name = newName;
		repaint();
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
		this.addMouseListener(mode);
		this.addMouseMotionListener(mode);
	}
	
	public void beSelected() {
		isSelected = true;		
		this.repaint();
	}
	
	public void unSelect() {
		isSelected = false;
		this.repaint();
	}
	
	public void resetLocation(int moveX, int moveY) {
		initX += moveX;
		initY += moveY;
		for (Port p: ports) {
			p.setParentX(initX);
			p.setParentY(initY);
		}
		this.setBounds(initX, initY, width, height);
		repaint();
	}
	
	public int getX() {
		return initX;
	}
	
	public int getY() {
		return initY;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isInside(Point p) {
		boolean ret = true;
		if (p.x < initX || p.y < initY) {
			ret = false;
		}
		if (p.x > initX + width || p.y > initY + height) {
			ret = false;
		}
		
		return ret;
	}
	
	public Port getNearest(int x, int y) {
		x -= initX;
		y -= initY;
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
		g.fillRoundRect(ports[RIGHT].getInitX(), ports[RIGHT].getInitY(), Port.offset * 2, Port.offset * 2, Port.offset, Port.offset);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (mode != null) {
			this.removeMouseListener(mode);
			this.removeMouseMotionListener(mode);
		}		
		setMode((Mode) arg);
		
	}
}
