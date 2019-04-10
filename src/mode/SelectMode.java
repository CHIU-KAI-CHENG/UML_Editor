package mode;

import java.awt.event.MouseEvent;

import shape.BasicObject;

public class SelectMode extends Mode {
	int startX, startY;
	BasicObject o = null;
	@Override
	public void mousePressed(MouseEvent e) {
		o = canvas.getObjectByPoint(e.getPoint());
		if (o == null) {
			canvas.unSelectObject();
		}
		else {
			startX = e.getX();
			startY = e.getY();
			canvas.setSelectedObject(o);
			o.beSelected();
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (o != null) {
			int moveX = e.getX() - startX;
			int moveY = e.getY() - startY;
			startX = e.getX();
			startY = e.getY();
			
			o.resetLocation(moveX, moveY);
			canvas.repaint();
		}
	}
	

}
