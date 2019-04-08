package mode.basic_object;

import java.awt.event.MouseEvent;

import mode.Mode;
import shape.BasicObject;
import shape.UseCase;

public class UseCaseMode extends Mode {

	private BasicObject o;
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof BasicObject) {
			o = (BasicObject) e.getSource();
		}
		UseCase useCase = new UseCase(o.getX() + e.getX(), o.getY() + e.getY());
		canvas.addBasicObject(useCase);
		useCase.repaint();
	}
}
