package umleditor;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class TopMenuBar extends MenuBar {
	
	static final String FILE = "File";
	static final String EDIT = "Edit";
	static final String CHANGE_OBJECT_NAME = "Change Object Name";
	static final String GROUP = "Group";
	static final String UNGROUP = "Ungorup";
	
	Frame frameInstance;
	Menu mFile, mEdit;
	MenuItem menuItem;
	
	public TopMenuBar(Frame frame) {
		frameInstance = frame;
		mFile = new Menu(FILE);
		mEdit = new Menu(EDIT);
		
		menuItem = new MenuItem(CHANGE_OBJECT_NAME);
		menuItem.addActionListener(new RenameListener());
		mEdit.add(menuItem);
		
		menuItem = new MenuItem(GROUP);
		mEdit.add(menuItem);
		
		menuItem = new MenuItem(UNGROUP);
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
