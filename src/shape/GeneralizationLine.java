package shape;

import java.awt.Graphics;

import utils.Tuple;

public class GeneralizationLine extends Line {
	public GeneralizationLine() {
		
	}
	
	public GeneralizationLine(Port p1, Port p2) {
		ports = new Tuple<>(p1, p2);
	}

	@Override
	public void draw(Graphics g) {		
		Tuple<int[], int[]> vertexes = getVertex(
				ports.getLeft().getXonCanvas(), 
				ports.getLeft().getYonCanvas(),
				ports.getRight().getXonCanvas(),
				ports.getRight().getYonCanvas());
		
		g.fillPolygon(vertexes.getLeft(), vertexes.getRight(), 3);
		
		g.drawLine(ports.getLeft().getXonCanvas(),
				ports.getLeft().getYonCanvas(),
				ports.getRight().getXonCanvas(), 
				ports.getRight().getYonCanvas());
		
	}

	@Override
	public void draw(Graphics g, int x1, int y1, int x2, int y2) {
		Tuple<int[], int[]> vertexes = getVertex(x1, y1, x2, y2);
		
		g.fillPolygon(vertexes.getLeft(), vertexes.getRight(), 3);
		g.drawLine(x1, y1, x2, y2);
	}
	
	private Tuple<int[], int[]> getVertex(int x1, int y1, int x2, int y2) {
		double vectorX = x1 - x2, vectorY = y2 - y1;
		double totalLength = Math.sqrt(vectorX * vectorX + vectorY * vectorY);
		double preRotateX = vectorX * 15 / totalLength, preRotateY = vectorY * 15 / totalLength;
		
		double cos30 = Math.cos(Math.PI / 6), sin30 = Math.sin(Math.PI / 6);
		double cos330 = Math.cos(11 * Math.PI / 6), sin330 = Math.sin(11 * Math.PI / 6);		

		double newVectorX1 = preRotateX * cos30 - preRotateY * sin30;
		double newVectorY1 = preRotateX * sin30 + preRotateY * cos30;
		
		int x3 = (int) (x2 + newVectorX1), y3 = (int) (y2 - newVectorY1);

		double newVectorX2 = preRotateX * cos330 - preRotateY * sin330;
		double newVectorY2 = preRotateX * sin330 + preRotateY * cos330;
		
		int x4 = (int) (x2 + newVectorX2), y4 = (int) (y2 - newVectorY2);

		int[] x = {x2, x3, x4};
		int[] y = {y2, y3, y4};
		
		return new Tuple<int[], int[]>(x, y);
		
	}

}
