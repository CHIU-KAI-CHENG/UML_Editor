package umleditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import mode.Mode;

@SuppressWarnings("serial")
public class ToolBar extends JScrollPane {
	Canvas canvas = Canvas.getInstance();
	JPanel panel = new JPanel();
	final Color btnBgColor = new Color(215, 215, 234);
	final Color selectedBtnBgColor = new Color(198, 198, 226);
	final ArrayList<Mode> events = new ArrayList<>();
	
	private JPanel selectedBtn = null;
	
	public ToolBar(JFrame owner) {		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		events.add(new mode.SelectMode());
		events.add(new mode.AssociationLineMode());
		events.add(new mode.GeneralizationLineMode());
		events.add(new mode.CompositionLineMode());
		events.add(new mode.ClassMode());
		events.add(new mode.UseCaseMode());
		
		
		ToolButton selectBtn = new ToolButton(new ImageIcon("img/select.png"), 
				"Select",
				events.get(Mode.SELECT));
		panel.add(selectBtn);
		
		ToolButton associationBtn = new ToolButton(new ImageIcon("img/association_line.png"), 
				"Association Line",
				events.get(Mode.ASSOCIATION_LINE));
		panel.add(associationBtn);
		
		ToolButton genealizationBtn = new ToolButton(new ImageIcon("img/generalization_line.png"), 
				"Generalization Line", 
				events.get(Mode.GENERALIZATION_LINE));
		panel.add(genealizationBtn);
		
		ToolButton compositionBtn = new ToolButton(new ImageIcon("img/composition_line.png"), 
				"Composition Line", 
				events.get(Mode.COMPOSITION_LINE));
		panel.add(compositionBtn);
		
		ToolButton classBtn = new ToolButton(new ImageIcon("img/class.png"), 
				"Class", 
				events.get(Mode.CLASS));
		panel.add(classBtn);
		
		ToolButton usecaseBtn = new ToolButton(new ImageIcon("img/use_case.png"),
				"Use Case", 
				events.get(Mode.USE_CASE));
		panel.add(usecaseBtn);
		
		panel.setBackground(btnBgColor);
		
		
		this.setViewportView(panel);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setPreferredSize(new Dimension(0, 0));
		this.setVerticalScrollBar(scrollBar);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
	}
	
	class ToolButton extends JPanel {
		private Mode toolMode;
		private JLabel toolIcon;
		private JLabel toolNameLbl;
		
		public ToolButton(ImageIcon img, String toolName, Mode toolMode) {
			
			this.setLayout(new GridLayout(2, 1, 1, 1));
			
			toolIcon = new JLabel(img);
			toolIcon.setAlignmentX(CENTER_ALIGNMENT);
			
			toolNameLbl = new JLabel(toolName);
			toolNameLbl.setHorizontalAlignment(JLabel.CENTER);
			
			this.toolMode = toolMode;
			
			this.setMaximumSize(new Dimension(120, 100));
			this.setBackground(btnBgColor);
			this.add(toolIcon);
			this.add(toolNameLbl);
			
			this.addMouseListener(new ToolButtonListener());
		}
		
		class ToolButtonListener extends MouseAdapter {

			@Override
			public void mousePressed(MouseEvent e) {
				if (selectedBtn != null) {					
					selectedBtn.setBackground(btnBgColor);
				}
				selectedBtn = (JPanel) e.getSource();
				selectedBtn.setBackground(selectedBtnBgColor);
				canvas.setMode(toolMode);
			}
			
		}
		
	}
}
