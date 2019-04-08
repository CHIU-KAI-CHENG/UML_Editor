package mode.canvas;

import java.awt.event.MouseEvent;

import mode.Mode;
import shape.BasicObject;

public class SelectMode extends Mode {

	@Override
	public void mousePressed(MouseEvent e) {
		canvas.unSelectObject();
	}
	

}
