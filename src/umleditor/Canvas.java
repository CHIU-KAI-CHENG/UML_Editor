package umleditor;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import mode.Mode;
import shape.BasicObject;
import shape.Group;
import shape.Line;
import shape.SelectableObject;

@SuppressWarnings("serial")
public class Canvas extends JLayeredPane {
	private static Canvas instance = null;
	private Mode currentMode = null;
	private ArrayList<SelectableObject> selectedObjects = new ArrayList<>();
	private ArrayList<BasicObject> objects = new ArrayList<>();
	private ArrayList<Line> lines = new ArrayList<>();
	private ArrayList<SelectableObject> topObjects = new ArrayList<>();
	private int depth = 0;
	private Line tempLine = null;
	private Group tempGroup = null;
	private MenuBar menuBar;
	
	private Point mouseStart, mouseEnd;
	
	private Canvas() {
		this.setLayout(null);
	}
	
	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}
	
	public void setMenuBar(MenuBar mb) {
		this.menuBar = mb;
	}
	
	public void setMode(Mode mode) {
		if (currentMode != null) {
			this.removeMouseListener(currentMode);
			this.removeMouseMotionListener(currentMode);
		}
		currentMode = mode;
		this.addMouseListener(currentMode);
		this.addMouseMotionListener(currentMode);
	}
	
	public ArrayList<SelectableObject> getSelectedObjects() {
		return selectedObjects;
	}
	
	public void addSelectedObjects(SelectableObject so) {
		selectedObjects.add(so);
		so.select();
		setRenameBtn();
		setUngroupBtn();
	}
	
	public void addAllSelectedObjects(ArrayList<SelectableObject> sos) {
		selectedObjects.addAll(sos);
		setRenameBtn();
		setGroupBtn();
		setUngroupBtn();
	}
	
	public void unSelectAllObjects() {
		for (int i = 0; i < selectedObjects.size(); i++) {
			selectedObjects.get(i).unselect();
		}
		selectedObjects.clear();
		setRenameBtn();
		setGroupBtn();
		setUngroupBtn();
	}
	
//	public void unSelectObject(SelectableObject so) {
//		so.unselect();
//		selectedObjects.remove(so);
//	}
	
	public void renameObject(String newName) {
		((BasicObject) this.selectedObjects.get(0)).changeName(newName);
	}
	
	public void groupObjects() {
		if (tempGroup == null) {
			tempGroup = new Group(selectedObjects);
		}
		tempGroup.commit();
		topObjects.removeAll(tempGroup.getObjects());
		topObjects.add(tempGroup);
		selectedObjects.removeAll(tempGroup.getObjects());
		selectedObjects.add(tempGroup);
		setGroupBtn();
		setUngroupBtn();
	}
	
	public void ungroupObjects() {
		Group g = ((Group) selectedObjects.get(0));
		g.ungroup();
		topObjects.remove(g);
		topObjects.addAll(g.getObjects());
		selectedObjects.remove(g);
		selectedObjects.addAll(g.getObjects());
		setGroupBtn();
		setUngroupBtn();
	}
	
	public void setTempLine(Line l) {
		this.tempLine = l;
	}
	

	public void setTempGroup(Group g) {
		this.tempGroup = g;
	}
	
	
	public void setMouseStart(Point p) {
		mouseStart = p;
	}
	
	public void setMouseEnd(Point p) {
		mouseEnd = p;
	}
	
	public void addLine(Line l) {
		lines.add(l);
	}
	
	public Point getMouseStart() {
		return mouseStart;
	}
	
	public Point getMouseEnd() {
		return mouseEnd;
	}	
	
	public void addBasicObject(BasicObject o) {
		this.add(o.getView(), new Integer(depth));
		objects.add(o);
		topObjects.add(o);
		unSelectAllObjects();
		addSelectedObjects(o);
		depth++;
	}
	
	public ArrayList<BasicObject> getBasicObjects() {
		return objects;
	}
	
	public ArrayList<SelectableObject> getTopObjects() {
		return topObjects;
	}
	
	private void setRenameBtn() {
		if (selectedObjects.size() == 1 && selectedObjects.get(0) instanceof BasicObject) {
			menuBar.enableMenuItem(menuBar.getRenameMI());
		}
		else {
			menuBar.disableMenuItem(menuBar.getRenameMI());
		}
	}
	
	private void setGroupBtn() {
		if (selectedObjects.size() > 1) {
			menuBar.enableMenuItem(menuBar.getGroupMI());
		}
		else {
			menuBar.disableMenuItem(menuBar.getGroupMI());
		}
	}
	
	private void setUngroupBtn() {
		if (selectedObjects.size() == 1 && selectedObjects.get(0) instanceof Group) {
			menuBar.enableMenuItem(menuBar.getUngroupMI());
		}
		else {
			menuBar.disableMenuItem(menuBar.getUngroupMI());
		}
	}
	
	public BasicObject getBasicObjectByPoint(Point p) {
		BasicObject o = null;
		for (int i = objects.size() - 1; i >= 0; i--) {
			if (objects.get(i).isContain(p)) {
				o = objects.get(i);
				break;
			}
		}
		return o;
	}
	
	public SelectableObject getTopObjectByPoint(Point p) {
		SelectableObject so = null;
		for (int i = topObjects.size() - 1; i >= 0; i--) {
			if (topObjects.get(i).isContain(p)) {
				so = topObjects.get(i);
				break;
			}
		}
		return so;
	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Line l: lines) {
			l.draw(g);
		}
		if (tempLine != null) {
			tempLine.draw(g, mouseStart.x, mouseStart.y, mouseEnd.x, mouseEnd.y);
		}
		if (tempGroup != null) {
			tempGroup.draw(g);
		}
	}

}