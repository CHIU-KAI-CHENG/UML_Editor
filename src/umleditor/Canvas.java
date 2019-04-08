package umleditor;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JLayeredPane;

import mode.Mode;
import shape.BasicObject;
import utils.Tuple;


@SuppressWarnings("serial")
public class Canvas extends JLayeredPane {
	private static Canvas instance = null;
	ModeBroadcaster broadcaster = new ModeBroadcaster();
	Tuple<Mode, Mode> currentMode = null;
	BasicObject selectedObject = null;
	ArrayList<BasicObject> objectsRef = new ArrayList<>();
	private int depth = 0;
	
	private Canvas() {
		this.setLayout(null);
	}
	
	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}
	
	public void setMode(Tuple<Mode, Mode> mode) {
		if (currentMode != null) {
			this.removeMouseListener(currentMode.getLeft());
			this.removeMouseMotionListener(currentMode.getLeft());
		}
		currentMode = mode;
		this.addMouseListener(currentMode.getLeft());
		this.addMouseMotionListener(currentMode.getLeft());
		this.broadcaster.broadcastMode(currentMode.getRight());
	}
	
	public void setSelectedObject(BasicObject o) {
		if (selectedObject != null) {
			unSelectObject(); 
		}
		this.selectedObject = o;
	}
	
	public void unSelectObject() {
		this.selectedObject.unSelect();
	}
	
	public void renameObject(String newName) {
		this.selectedObject.changeName(newName);
	}
	
	public void addBasicObject(BasicObject o) {
		o.setMode(currentMode.getRight());
		this.add(o, new Integer(depth));
		objectsRef.add(o);
		broadcaster.addObserver(o);
		depth++;
	}

	public class ModeBroadcaster extends Observable {
		public void broadcastMode(Mode mode) {
			this.setChanged();
			this.notifyObservers(mode);
		}
	}
	
	

}
