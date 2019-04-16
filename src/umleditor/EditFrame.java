package umleditor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class EditFrame extends JFrame {
	
	MenuBar menuBar;
	JScrollPane toolBar;
	Canvas canvas;
	
	public EditFrame(String frameName) {
		super(frameName);
		
		menuBar = new MenuBar(this);
		this.setJMenuBar(menuBar);
		
		toolBar = new ToolBar(this);
		this.add(toolBar, BorderLayout.WEST);
		
		canvas = Canvas.getInstance();
		canvas.setMenuBar(menuBar);
		this.add(canvas, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
