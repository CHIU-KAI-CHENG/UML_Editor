package mode.canvas;

import java.awt.event.MouseEvent;

import mode.Mode;
import shape.UseCase;

public class UseCaseMode extends Mode {

	@Override
	public void mousePressed(MouseEvent e) {
		UseCase useCase = new UseCase(e.getX(), e.getY());
		canvas.addBasicObject(useCase);
		useCase.repaint();
	}
}
