
package circuit.designer.simon;

import javafx.scene.Group;


abstract public class Gate {
    
    protected static double xStart;
    protected static double yStart;
    protected Group g;
    
    Gate next;
    Gate prev;
    Point InTop;
    Point InBot;
    Point Out;
    int ID;
    int code;
    
    public Gate(double x, double y){
        xStart = x;
        yStart = y;
        g = new Group();
        
        this.ID = 0;
        this.next = null;
        this.prev = null;
    }
    
    public double conextion(){
        return xStart;
    }
    
    //Getters & Setters
    public static double getxStart() {
        return xStart;
    }
    public static void setxStart(double xStart) {
        Gate.xStart = xStart;
    }
    public static double getyStart() {
        return yStart;
    }
    public static void setyStart(double yStart) {
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
