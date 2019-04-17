package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import shape.Group;
import shape.SelectableObject;

public class SelectMode extends Mode {
	int startX, startY, initX, initY;
	SelectableObject so = null;
	Group g = null;
	@Override
	public void mousePressed(MouseEvent e) {
		startX = initX = e.getX();
		startY = initY = e.getY();
		canvas.unSelectAllObjects();
		so = canvas.getTopObjectByPoint(e.getPoint());
		if (so == null) {
			canvas.setMouseStart(new Point(initX, initY));
			g = new Group();
			canvas.setTempGroup(g);
		}
		else {
			g = null;
			canvas.addSelectedObjects(so);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int endX = e.getX(), endY = e.getY();
		if (so == null) {
			g.setRect(initX, initY, endX, endY);
			g.addObjects(canvas.getTopObjects());
			canvas.setMouseEnd(new Point(endX, endY));
			canvas.repaint();
		}
		else {
			int moveX = endX - startX;
			int moveY = endY - startY;
			startX = endX;
			startY = endY;
			
			so.resetLocation(moveX, moveY);
			canvas.repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {	
		if (g != null && g.isEmpty()) {
			g = null;
			canvas.setTempGroup(g);
			canvas.repaint();
			return;
		}

		if (g != null) {
			canvas.addAllSelectedObjects(g.getObjects());
			g.setRect(0, 0, 0, 0);
			canvas.repaint();
		}
	}
	
}
