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
	JMenuItem renameMI, groupMI, ungroupMI;
	
	public MenuBar(JFrame frame) {
		frameInstance = frame;
		mFile = new JMenu(FILE);
		mEdit = new JMenu(EDIT);
		
		renameMI = new JMenuItem(CHANGE_OBJECT_NAME);
		renameMI.addActionListener(new RenameListener());
		renameMI.setEnabled(false);
		mEdit.add(renameMI);
		
		groupMI = new JMenuItem(GROUP);
		groupMI.addActionListener(new GroupListener());
		groupMI.setEnabled(false);
		mEdit.add(groupMI);
		
		ungroupMI = new JMenuItem(UNGROUP);
		mEdit.add(ungroupMI);
		
		this.add(mFile);
		this.add(mEdit);
	}
	
	public JMenuItem getRenameMI() {
		return renameMI;
	}
	
	public JMenuItem getGroupMI() {
		return groupMI;
	}
	
	public void enableMenuItem(JMenuItem mi) {
		mi.setEnabled(true);
	}
	
	public void disableMenuItem(JMenuItem mi) {
		mi.setEnabled(false);
	}
	
	class RenameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			RenameDialog renameDialog = new RenameDialog(frameInstance, "Rename Object");
			renameDialog.setSize(400, 100);
			renameDialog.setVisible(true);
		}		
	}
	
	class GroupListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.groupObjects();
		}
		
	}
	
	
}
