package mode.canvas;

import shape.GeneralizationLine;

public class GeneralizationLineMode extends LineMode {

	@Override
	protected void createLine() {
		l = new GeneralizationLine(p1, p2);
	}

	@Override
	protected void createTempLine() {
		tempLine = new GeneralizationLine();
	}

}
