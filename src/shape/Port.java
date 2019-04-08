package shape;

import java.util.ArrayList;

public class Port {
	public static int offset = 3;
	int centerX, centerY;
	
	ArrayList<Line> lines = new ArrayList<Line>();
	
	public Port(int centerX, int centerY) {
		this.centerX = centerX;
		this.centerY = centerY;
	}
	
	public int getInitX() {
		return centerX - offset;
	}
	
	public int getInitY() {
		return centerY - offset;
	}
	
	public void addLines(Line line) {
		lines.add(line);
	}

}
