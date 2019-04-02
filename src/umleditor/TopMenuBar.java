package umleditor;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Window;


public class TopMenuBar extends MenuBar {
	
	static final String FILE = "File";
	static final String EDIT = "Edit";
	static final String CHANGE_OBJECT_NAME = "Change Object Name";
	static final String GROUP = "Group";
	static final String UNGROUP = "Ungorup";
	
	Menu mFile, mEdit;
	MenuItem menuItem;
	
	public TopMenuBar() {
		mFile = new Menu(FILE);
		mEdit = new Menu(EDIT);
		
		menuItem = new MenuItem(CHANGE_OBJECT_NAME);
		mEdit.add(menuItem);
		
		menuItem = new MenuItem(GROUP);
		mEdit.add(menuItem);
		
		menuItem = new MenuItem(UNGROUP);
		mEdit.add(menuItem);
		
		this.add(mFile);
		this.add(mEdit);
		
	}
	
	
}
