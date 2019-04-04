package umleditor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class EditFrame extends JFrame {
	
	JMenuBar menuBar;
	JScrollPane toolBar;
	public EditFrame(String frameName) {
		super(frameName);
		
		menuBar = new MenuBar(this);
		this.setJMenuBar(menuBar);		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		toolBar = new ToolBar(this);
		this.add(toolBar, BorderLayout.WEST);
	}
}
