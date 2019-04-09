package mode.canvas;

import java.awt.Point;
import java.awt.event.MouseEvent;

import mode.Mode;
import shape.BasicObject;
import shape.Line;
import shape.Port;

public abstract class LineMode extends Mode {
	protected BasicObject o1 = null, o2 = null;
	protected Port p1, p2;
	protected Line l, tempLine;
	
	@Override
	public void mousePressed(MouseEvent e) {
		o1 = canvas.getObjectByPoint(e.getPoint());
		if (o1 == null)	return;
		
		p1 = o1.getNearest(e.getX(), e.getY());
		canvas.setLineStart(new Point(o1.getX() + p1.getCenterX(), o1.getY() + p1.getCenterY()));
		createTempLine();
		canvas.setTempLine(tempLine);
	}
	
	@Override
	public void mouseDragged (MouseEvent e) {
		if (o1 == null) return;
		
		canvas.setLineEnd(new Point(e.getX(), e.getY()));
		canvas.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		tempLine = null;
		canvas.setTempLine(tempLine);
		
		if (o1 == null) return;
		
		o2 = canvas.getObjectByPoint(e.getPoint());
		if (o2 == null || o1 == o2) {
			canvas.repaint();
			return;
		}
		
		p2 = o2.getNearest(e.getX(), e.getY());
		createLine();

		o1 = null;
		o2 = null;
		
		canvas.addLine(l);
		canvas.repaint();
	}
	
	protected abstract void createLine();
	
	protected abstract void createTempLine();
}
