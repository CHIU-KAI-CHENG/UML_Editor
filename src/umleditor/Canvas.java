package umleditor;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import mode.Mode;
import shape.BasicObject;
import shape.Line;

@SuppressWarnings("serial")
public class Canvas extends JLayeredPane {
	private static Canvas instance = null;
	private Mode currentMode = null;
	private BasicObject selectedObject = null;
	private ArrayList<BasicObject> objects = new ArrayList<>();
	private ArrayList<Line> lines = new ArrayList<>();
	private int depth = 0;
	private Line tempLine = null;
	
	private Point lineStart, lineEnd;
	
	private Canvas() {
		this.setLayout(null);
	}
	
	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
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
	
	public void setSelectedObject(BasicObject o) {
		if (selectedObject != null) {
			unSelectObject(); 
		}
		this.selectedObject = o;
	}
	
	public void unSelectObject() {
		if (selectedObject != null)
		{
			this.selectedObject.unSelect();
			this.selectedObject = null;
		}
	}
	
	public void renameObject(String newName) {
		this.selectedObject.changeName(newName);
	}
	
	public void setTempLine(Line l) {
		this.tempLine = l;
	}
	
	public void setLineStart(Point p) {
		lineStart = p;
	}
	
	public void setLineEnd(Point p) {
		lineEnd = p;
	}
	
	public void addLine(Line l) {
		lines.add(l);
	}
	
	public Point getLineStart() {
		return lineStart;
	}
	
	public Point getLineEnd() {
		return lineEnd;
	}	
	
	public void addBasicObject(BasicObject o) {
		this.add(o, new Integer(depth));
		objects.add(o);
		depth++;
	}
	
	public BasicObject getObjectByPoint(Point p) {
		BasicObject o = null;
		for (int i = objects.size() - 1; i >= 0; i--) {
			if (objects.get(i).isInside(p)) {
				o = objects.get(i);
				break;
			}
		}
		return o;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (tempLine != null) {
			tempLine.draw(g, lineStart.x, lineStart.y, lineEnd.x, lineEnd.y);
		}
		for (Line l: lines) {
			l.draw(g);
		}
		
	}}