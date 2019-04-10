package shape;

import java.awt.Graphics;

import utils.Tuple;

public class CompositionLine extends Line {
	
	public CompositionLine() {
		
	}
	
	public CompositionLine(Port p1, Port p2) {
		ports = new Tuple<Port, Port>(p1, p2);
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(ports.getLeft().getXonCanvas(),
				ports.getLeft().getYonCanvas(),
				ports.getRight().getXonCanvas(),
				ports.getRight().getYonCanvas());
		
		Tuple<int[], int[]> vertexes = getVertex(
				ports.getLeft().getXonCanvas(),
				ports.getLeft().getYonCanvas(),
				ports.getRight().getXonCanvas(),
				ports.getRight().getYonCanvas());
		
		g.fillPolygon(vertexes.getLeft(), vertexes.getRight(), 4);		
	}

	@Override
	public void draw(Graphics g, int x1, int y1, int x2, int y2) {
		g.drawLine(x1, y1, x2, y2);
		Tuple<int[], int[]> vertexes = getVertex(x1, y1, x2, y2);
		g.fillPolygon(vertexes.getLeft(), vertexes.getRight(), 4);
	}
	
	private Tuple<int[], int[]> getVertex(int x1, int y1, int x2, int y2) {
		double vectorX = x1 - x2, vectorY = y2 - y1;
		double totalLength = Math.sqrt(vectorX * vectorX + vectorY * vectorY);
		double preRotateX = vectorX * 12 / totalLength, preRotateY = vectorY * 12 / totalLength;
		
		double cos45 = Math.cos(Math.PI / 4), sin45 = Math.sin(Math.PI / 4);
		double cos315 = Math.cos(7 * Math.PI / 4), sin315 = Math.sin(7 * Math.PI / 4);
		
		double newVectorX1 = cos45 * preRotateX - sin45 * preRotateY;
		double newVectorY1 = sin45 * preRotateX + cos45 * preRotateY;
		
		int x3 = (int) Math.round(x2 + newVectorX1), y3 = (int) Math.round(y2 - newVectorY1);
		int x4 = (int) Math.round(x2 + preRotateX * Math.sqrt(2)), y4 = (int) Math.round(y2 - preRotateY * Math.sqrt(2));
		
		double newVectorX2 = cos315 * preRotateX - sin315 * preRotateY;
		double newVectorY2 = sin315 * preRotateX + cos315 * preRotateY;
		
		int x5 = (int) Math.round(x2 + newVectorX2), y5 = (int) Math.round(y2 - newVectorY2);
		
		
		int[] x = {x2, x3, x4, x5};
		int[] y = {y2, y3, y4, y5};
		
		return new Tuple<int[], int[]>(x, y);
	}

}
