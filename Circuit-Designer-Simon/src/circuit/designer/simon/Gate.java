
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

abstract class Gate {
    
    protected double xStart;
    protected double yStart;
    protected Group g;
    protected Pane target;
    
    protected Gate next;
    protected Gate prev;
    protected Gate InTop;
    protected Gate InBot;
    protected Gate Out;
    protected String ID;
    protected int code;
    protected String state; //Estados de los puntos: BackOpen, FrontOpen, FrontFinal, Closed
    protected Gate rFrom;  //Recibe datos de...
    protected int result;  
    protected boolean selected;
    
    public Gate(Pane target, double x, double y){
        
        this.target = target;
        xStart = x;
        yStart = y;
        g = new Group();
        
        this.ID = "GATE";
        this.next = null;
        this.prev = null;
        this.rFrom = null;
        
        
    }
    
    public double conextion(){
        return xStart;
    }
    
    //Getters & Setters
    public double getxStart() {
        return xStart;
    }
    public void setxStart(double xStart) {
        this.xStart = xStart;
    }
    public double getyStart() {
        return yStart;
    }
    public void setyStart(double yStart) {
        this.yStart = yStart;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    
    
    public void constructFigure(){}
    
    public void moveFigure(double x, double y){}
    
    public Group getFigure(){
        return g;
    }
}
    
