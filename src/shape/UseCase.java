package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class UseCase extends BasicObject {
	final String USE_CASE_NAME = "Use Case";
	
	public UseCase(int initX, int initY) {
		view = new UseCaseView();	
		this.name = USE_CASE_NAME;
		
		r = new Rectangle(initX, initY, 100, 80);
		
		view.setBounds(r.x, r.y, r.width, r.height);
		setPorts();
	}
	
	public void paintUseCase(Graphics g) {
		g.fillOval(0, 0, r.width, r.height);
		g.setColor(Color.WHITE);
		g.fillOval(1, 1, r.width - 2, r.height - 2);
		
		int stringLength = g.getFontMetrics().stringWidth(name);
		int indent = (r.width - stringLength) / 2;
		
		g.setColor(Color.BLACK);
		
		if (isSelected) {
			drawPorts(g);
		}
		
		g.drawString(name, indent, 40); 
	}
	
	protected class UseCaseView extends View {

		@Override
		public void paint(Graphics g) {
			paintUseCase(g);			
		}
		
	}
}
