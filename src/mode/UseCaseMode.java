package mode;

import java.awt.event.MouseEvent;

import shape.UseCase;

public class UseCaseMode extends Mode {

	@Override
	public void mousePressed(MouseEvent e) {
		UseCase useCase = new UseCase(e.getX(), e.getY());
		canvas.addBasicObject(useCase);
		useCase.repaint();
	}
}
