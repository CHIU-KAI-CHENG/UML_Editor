package shape;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Class extends BasicObject {
	final String INIT_NAME = "Class Name";
	int gap;
	
	public Class(int initX, int initY) {
		this.name = INIT_NAME;
		this.initX = initX;
		this.initY = initY;
		this.width = 100;
		this.height = 120;
		this.gap = height / 3;
			

		this.setBounds(initX, initY, width, height);
		setPorts();
	}
	
	public Class(int initX, int initY, int width, int height) {
		this.name = INIT_NAME;
		this.initX = initX;
		this.initY = initY;
		this.width = width;
		this.height = height;
		this.gap = height / 3;
		this.setVisible(true);
		
		this.setBounds(initX, initY, width, height);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width, height);		
		g.drawLine(0, gap, width, gap);
		g.drawLine(0, gap * 2, width, gap * 2);
		
				
		if (isSelected) {
			drawPorts(g);
		}
		
		int stringLength = g.getFontMetrics().stringWidth(name);
		int indent = (width - stringLength) / 2;
		
		g.drawString(name, indent, 25);
	}

}
