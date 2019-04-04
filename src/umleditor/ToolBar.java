package umleditor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class ToolBar extends JScrollPane {
	int toolNum = 6;
	JPanel panel = new JPanel();
	
	public ToolBar(JFrame owner) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		ToolButton selectBtn = new ToolButton(new ImageIcon("img/select.png"), 
				"Select");
		panel.add(selectBtn);	
		
		ToolButton associationBtn = new ToolButton(new ImageIcon("img/association_line.png"), 
				"Association Line");
		panel.add(associationBtn);
		
		ToolButton genealizationBtn = new ToolButton(new ImageIcon("img/generalization_line.png"), 
				"Generalization Line");
		panel.add(genealizationBtn);
		
		ToolButton compositionBtn = new ToolButton(new ImageIcon("img/composition_line.png"), 
				"Composition Line");
		panel.add(compositionBtn);
		
		ToolButton classBtn = new ToolButton(new ImageIcon("img/class.png"), 
				"Class");
		panel.add(classBtn);
		
		ToolButton usecaseBtn = new ToolButton(new ImageIcon("img/use_case.png"),
				"Use Case");
		panel.add(usecaseBtn);
		
		
		this.setViewportView(panel);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setPreferredSize(new Dimension(0, 0));
		this.setVerticalScrollBar(scrollBar);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.setPreferredSize(new Dimension(105, owner.getHeight()));
		this.setMaximumSize(new Dimension(105, 
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
	}
	
	class ToolButton extends JPanel {
		private JLabel toolIcon;
		
		public ToolButton(ImageIcon img, String toolName) {
			toolIcon = new JLabel(img);
			
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			this.add(toolIcon);
		}
	}
}
