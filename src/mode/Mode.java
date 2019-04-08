package mode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import umleditor.Canvas;

public abstract class Mode implements MouseListener, MouseMotionListener {
	protected Canvas canvas = Canvas.getInstance();
	public static final int MODE_NUM = 6;
	public static final int SELECT = 0;
	public static final int ASSOCIATION_LINE = 1;
	public static final int GENERALIZATION_LINE = 2;
	public static final int COMPOSITION_LINE = 3;
	public static final int CLASS = 4;
	public static final int USE_CASE = 5;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
