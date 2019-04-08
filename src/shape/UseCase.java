package shape;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class UseCase extends BasicObject {
	final String USE_CASE_NAME = "Use Case";
	
	public UseCase(int initX, int initY) {
		this.name = USE_CASE_NAME;
		this.initX = initX;
		this.initY = initY;
		this.width = 100;
		this.height = 80;
		

		this.setBounds(initX, initY, width, height);
		setPorts();
	}
	
	@Override
	public void paint(Graphics g) {
		g.fillOval(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.fillOval(1, 1, width - 2, height - 2);
		
		int stringLength = g.getFontMetrics().stringWidth(name);
		int indent = (width - stringLength) / 2;
		
		g.setColor(Color.BLACK);
		
		if (isSelected) {
			drawPorts(g);
		}
		
		g.drawString(name, indent, 40); 
	}
}
