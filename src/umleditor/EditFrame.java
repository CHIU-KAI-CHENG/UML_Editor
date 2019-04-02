package umleditor;

import java.awt.Frame;

public class EditFrame extends Frame {
	
	TopMenuBar menuBar;
	public EditFrame(String frameName) {
		super(frameName);
		
		menuBar = new TopMenuBar();
		this.setMenuBar(menuBar);
		this.setVisible(true);
	}
}
