package mode.basic_object;

import java.awt.event.MouseEvent;

import mode.Mode;
import shape.BasicObject;
import shape.Class;

public class ClassMode extends Mode {
	private BasicObject o;
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof BasicObject) {
			o = (BasicObject) e.getSource();
		}
		Class classObj = new Class(o.getX() + e.getX(), o.getY() + e.getY());
		canvas.addBasicObject(classObj);
		classObj.repaint();
	}
}
