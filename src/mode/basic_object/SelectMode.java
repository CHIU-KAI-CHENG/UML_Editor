package mode.basic_object;

import java.awt.event.MouseEvent;

import shape.BasicObject;

public class SelectMode extends BasicObjectMode {
	int startX = 0, startY = 0;
	@Override
	public void mousePressed(MouseEvent e) {
		 startX = e.getX();
		 startY = e.getY();
		 getBasicObjInstance(e);
		 canvas.setSelectedObject(o);
		 o.beSelected();
		 
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int moveX = e.getX() - startX;
		int moveY = e.getY() - startY;
		
		o.resetLocation(moveX, moveY);		
		canvas.repaint();
	}
}
