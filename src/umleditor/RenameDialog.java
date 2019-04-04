package umleditor;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * The dialog to rename an object.
 */
@SuppressWarnings("serial")
public class RenameDialog extends JDialog {

	JLabel newNameLbl;
	JTextField inputNameTf;
	JButton okBtn, cancelBtn;
	JPanel panel;
	
	Dimension frameCenter;
	Point frameOffset;
	
	public RenameDialog(JFrame owner, String title) {
		super(owner, title);
		
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(owner);
		this.setResizable(false);
		
		frameOffset = owner.getLocation();
		frameCenter = owner.getSize();
		
		this.setLocation(frameOffset.x + frameCenter.width / 2 - 200, 
				frameOffset.y + frameCenter.height / 2 - 50);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(Box.createVerticalStrut(5));
		
		panel = new JPanel();
		
		panel.add(Box.createHorizontalStrut(5));
		
		newNameLbl = new JLabel("New Name: ");
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(newNameLbl);
		
		panel.add(Box.createHorizontalStrut(5));
		
		inputNameTf = new JTextField();
		inputNameTf.setMaximumSize(new Dimension(280, 30));
		panel.add(inputNameTf);
		
		this.add(panel);
		
		
		this.add(Box.createVerticalStrut(10));
		

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		panel.add(Box.createHorizontalStrut(200));
		
		okBtn = new JButton("Finish");
		panel.add(okBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		panel.add(cancelBtn);
		
		
		this.add(panel);
			
	}
	
	
	
}
