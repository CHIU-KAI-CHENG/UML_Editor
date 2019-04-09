package shape;

import java.awt.Graphics;

import utils.Tuple;

public class AssociationLine extends Line {
	
	public AssociationLine() {
		
	}
	
	public AssociationLine(Port p1, Port p2) {
		ports = new Tuple<>(p1, p2);
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(ports.getLeft().getXonCanvas(),
				ports.getLeft().getYonCanvas(),
				ports.getRight().getXonCanvas(), 
				ports.getRight().getYonCanvas());

	}

	public void draw(Graphics g, int x1, int y1, int x2, int y2) {
		g.drawLine(x1, y1, x2, y2);	
	}

}
