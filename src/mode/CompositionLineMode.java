package mode;

import shape.CompositionLine;

public class CompositionLineMode extends LineMode {

	@Override
	protected void createLine() {
		l = new CompositionLine(p1, p2);
	}

	@Override
	protected void createTempLine() {
		tempLine = new CompositionLine();
	}

}
