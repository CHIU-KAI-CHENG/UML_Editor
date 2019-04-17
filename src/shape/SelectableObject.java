package shape;

import java.awt.Rectangle;

public abstract class SelectableObject implements Selectable {
	protected SelectableObject parentObj = null;
	protected Rectangle r = new Rectangle();
	
	public Rectangle getRect() {
		return r;
	}
	
	public void setParentObj(SelectableObject so) {
		this.parentObj = so;
	}
	
	public SelectableObject getParentObj() {
		return parentObj;
	}
	
	public SelectableObject getTopParentObject() {
		SelectableObject topParent = this;
		while (topParent.getParentObj() != null) {
			topParent = topParent.getParentObj();
		}
		return topParent;
	}
}
