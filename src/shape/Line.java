package shape;

import java.awt.Graphics;

import utils.Tuple;


public abstract class Line {
	protected Tuple<Port, Port> ports;
	
	public Port getPort1() {
		return ports.getLeft();
	}
	
	public Port getPort2() {
		return ports.getRight();
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void draw(Graphics g, int x1, int y1, int x2, int y2);
	

}
