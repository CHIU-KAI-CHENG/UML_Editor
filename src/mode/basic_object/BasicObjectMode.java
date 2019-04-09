package mode.basic_object;

import java.awt.event.MouseEvent;

import mode.Mode;
import shape.BasicObject;

public abstract class BasicObjectMode extends Mode {
	protected BasicObject o;
	protected void getBasicObjInstance(MouseEvent e) {
		if (e.getSource() instanceof BasicObject) {
			o = (BasicObject) e.getSource();			
		}
	}

}
