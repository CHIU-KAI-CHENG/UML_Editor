package umleditor;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class EditFrame extends Frame {
	
	TopMenuBar menuBar;
	public EditFrame(String frameName) {
		super(frameName);
		
		menuBar = new TopMenuBar(this);
		this.setMenuBar(menuBar);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
