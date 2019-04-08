package umleditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	
	static final String FILE = "File";
	static final String EDIT = "Edit";
	static final String CHANGE_OBJECT_NAME = "Change Object Name";
	static final String GROUP = "Group";
	static final String UNGROUP = "Ungorup";
	
	Canvas canvas = Canvas.getInstance();
	
	JFrame frameInstance;
	JMenu mFile;
	JMenu mEdit;
	JMenuItem menuItem;
	
	public MenuBar(JFrame frame) {
		frameInstance = frame;
		mFile = new JMenu(FILE);
		mEdit = new JMenu(EDIT);
		
		menuItem = new JMenuItem(CHANGE_OBJECT_NAME);
		menuItem.addActionListener(new RenameListener());
		mEdit.add(menuItem);
		
		menuItem = new JMenuItem(GROUP);
		mEdit.add(menuItem);
		
		menuItem = new JMenuItem(UNGROUP);
		mEdit.add(menuItem);
		
		this.add(mFile);
		this.add(mEdit);
	}
	
	class RenameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			RenameDialog renameDialog = new RenameDialog(frameInstance, "Rename Object");
			renameDialog.setSize(400, 100);
			renameDialog.setVisible(true);
		}
		
	}
	
	
}
