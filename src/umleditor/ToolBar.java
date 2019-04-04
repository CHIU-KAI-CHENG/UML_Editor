package umleditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

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
	int width;
	JPanel panel = new JPanel();
	
	public ToolBar(JFrame owner) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		ToolButton selectBtn = new ToolButton(new ImageIcon("img/select.png"), 
				"Select");
		panel.add(selectBtn);
		selectBtn.setBackground(Color.GRAY);
		
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
		
		panel.setBackground(Color.LIGHT_GRAY);
		
		
		this.setViewportView(panel);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setPreferredSize(new Dimension(0, 0));
		this.setVerticalScrollBar(scrollBar);
		this.setMinimumSize(new Dimension(0, Toolkit.getDefaultToolkit().getScreenSize().height));
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		width = this.getWidth();
	}
	
	class ToolButton extends JPanel {
		private JLabel toolIcon;
		private JLabel toolNameLbl;
		
		public ToolButton(ImageIcon img, String toolName) {
			
			this.setLayout(new GridLayout(2, 1, 1, 1));
			
			toolIcon = new JLabel(img);
			toolIcon.setAlignmentX(CENTER_ALIGNMENT);
			
			toolNameLbl = new JLabel(toolName);
			toolNameLbl.setHorizontalAlignment(JLabel.CENTER);
			
			this.setMaximumSize(new Dimension(120, 100));
			this.setBackground(Color.LIGHT_GRAY);
			this.add(toolIcon);
			this.add(toolNameLbl);
		}
		
//		@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.drawImage(Toolkit.getDefaultToolkit().getImage("img/icons8-rounded_rectangle.png"),
//					0, 
//					0, 
//					this.getSize().width,
//					this.getSize().height,
//					this
//					);
//		}
	}
}
