package mode;

import shape.AssociationLine;

public class AssociationLineMode extends LineMode {

	@Override
	protected void createLine() {
		l = new AssociationLine(p1, p2);	
	}

	@Override
	protected void createTempLine() {
		tempLine = new AssociationLine();
		
	}
}
