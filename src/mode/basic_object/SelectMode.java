package mode.basic_object;

import java.awt.event.MouseEvent;

import mode.Mode;
import shape.BasicObject;

public class SelectMode extends Mode {
	BasicObject o;
	int startX = 0, startY = 0;
	@Override
	public void mousePressed(MouseEvent e) {
		 startX = e.getX();
		 startY = e.getY();
		 if (e.getSource() instanceof BasicObject) {
			 o = (BasicObject) e.getSource();
		 }
		 System.out.println(o.getLocation().toString());
		 canvas.setSelectedObject(o);
		 o.beSelected();
		 
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int moveX = e.getX() - startX;
		int moveY = e.getY() - startY;
		
		o.resetLocation(moveX, moveY);		
		
	}
}
