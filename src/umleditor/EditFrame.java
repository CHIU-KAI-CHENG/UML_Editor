package umleditor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class EditFrame extends JFrame {
	
	JMenuBar menuBar;
	JScrollPane toolBar;
	Canvas canvas;
	
	public EditFrame(String frameName) {
		super(frameName);
		
		canvas = Canvas.getInstance();
		this.add(canvas, BorderLayout.CENTER);
		
		menuBar = new MenuBar(this);
		this.setJMenuBar(menuBar);
		
		toolBar = new ToolBar(this);
		this.add(toolBar, BorderLayout.WEST);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
