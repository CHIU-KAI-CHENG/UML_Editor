package mode.canvas;

import java.awt.event.MouseEvent;

import mode.Mode;
import shape.Class;

public class ClassMode extends Mode {

	@Override
	public void mousePressed(MouseEvent e) {
		Class classObj = new Class(e.getX(), e.getY());
		canvas.addBasicObject(classObj);
		classObj.repaint();
	}

}
 