package shape;

import java.util.ArrayList;

public class Port {
	public static int offset = 4;
	private int centerX, centerY;
	private int parentX, parentY;
	
	ArrayList<Line> lines = new ArrayList<Line>();
	
	public Port(int centerX, int centerY, int parentX, int parentY) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.parentX = parentX;
		this.parentY = parentY;
	}
	
	public int getCenterX() {
		return centerX;
	}
	
	public int getCenterY() {
		return centerY;
	}
	
	public int getXonCanvas() {
		return centerX + parentX;
	}
	
	public int getYonCanvas() {
		return centerY + parentY;
	}
	
	public int getInitX() {
		return centerX - offset;
	}
	
	public int getInitY() {
		return centerY - offset;
	}
	
	public void setParentX(int x) {
		this.parentX = x;
	}
	
	public void setParentY(int y) {
		this.parentY = y;
	}
	
	public int getParentX() {
		return parentX;
	}
	
	public int getParentY() {
		return parentY;
	}
	
	public void addLines(Line line) {
		lines.add(line);
	}

}
