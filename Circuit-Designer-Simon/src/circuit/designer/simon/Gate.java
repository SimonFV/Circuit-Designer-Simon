
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

abstract class Gate {
    
    protected static double xStart;
    protected static double yStart;
    protected Group g;
    protected Pane target;
    
    protected Gate next;
    protected Gate prev;
    protected Point InTop;
    protected Point InBot;
    protected Point Out;
    protected int ID;
    protected int code;
    
    public Gate(Pane target, double x, double y){
        this.target = target;
        xStart = x;
        yStart = y;
        g = new Group();
        
        this.ID = 0;
        this.next = null;
        this.prev = null;
        constructFigure();
        
    }
    
    public double conextion(){
        return xStart;
    }
    
    //Getters & Setters
    public static double getxStart() {
        return xStart;
    }
    public void setxStart(double xStart) {
        Gate.xStart = xStart;
    }
    public double getyStart() {
        return yStart;
    }
    public void setyStart(double yStart) {
        Gate.yStart = yStart;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    public void constructFigure(){}
    
    public void moveFigure(){}
    
    public Group getFigure(){
        return g;
    }
    public Group newPosition(double newX, double newY){
        return getFigure();
    }
}
    
