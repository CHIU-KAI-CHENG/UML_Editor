package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Class extends BasicObject {
	final String INIT_NAME = "Class Name";
	int gap;
	
	public Class(int initX, int initY) {
		this.view = new ClassView();
		this.name = INIT_NAME;
		this.r = new Rectangle(initX, initY, 100, 120);
		this.gap = 40;
		
		view.setBounds(r);
		setPorts();
	}
	
	public void paintClass(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, r.width, r.height);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, r.width, r.height);		
		g.drawLine(0, gap, r.width, gap);
		g.drawLine(0, gap * 2, r.width, gap * 2);
		
				
		if (isSelected) {
			drawPorts(g);
		}
		
		int stringLength = g.getFontMetrics().stringWidth(name);
		int indent = (r.width - stringLength) / 2;
		
		g.drawString(name, indent, 25);
	}
	
	protected class ClassView extends View {

		@Override
		public void paint(Graphics g) {
			paintClass(g);
			
		}
		
	}

}
