package umleditor;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
/**
 * The dialog to rename an object.
 */
@SuppressWarnings("serial")
public class RenameDialog extends Dialog {

	Label newNameLbl;
	TextField inputNameTf;
	Dimension frameCenter;
	Button okBtn, cancelBtn;
	Panel panel;
	
	public RenameDialog(Frame owner, String title) {
		super(owner, title);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		
		frameCenter = owner.getSize();
		this.setLocation(frameCenter.width / 2 - 200, frameCenter.height / 2 - 50);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		this.add(Box.createVerticalStrut(5));
		
		panel = new Panel();
		
		newNameLbl = new Label("New Name: ");
		panel.add(newNameLbl);
		
		inputNameTf = new TextField();
		inputNameTf.setColumns(36);
		panel.add(inputNameTf);
		
		this.add(panel);
		
		
		this.add(Box.createVerticalStrut(10));
		

		panel = new Panel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		panel.add(Box.createHorizontalStrut(200));
		
		okBtn = new Button("Finish");
		panel.add(okBtn);
		
		cancelBtn = new Button("Cancel");
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
