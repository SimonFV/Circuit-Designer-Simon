
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

abstract class Gate {
    
    protected double xStart, yStart;
    protected Group g;
    protected Pane target;
    protected Gate next, prev, InTop, InBot, Out;
    protected Point rFrom;
    protected String ID, state; //Estados de los puntos: Active, BackOpen, FrontOpen, BackFinal, FrontFinal, Closed
    protected int code,result;
    protected boolean selected;
    protected CircuitList circuit;
    
    public Gate(Pane target, double x, double y, CircuitList circuit){
        this.circuit = circuit;
        this.target = target;
        xStart = x;
        yStart = y;
        g = new Group();
        
        this.ID = "GATE";
        this.next = null;
        this.prev = null;
        this.rFrom = null;
        this.selected = false;
        this.state = "Active";
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
    
    public void constructFigure(){}
    
    public void moveFigure(double x, double y){}
    
    public Group getFigure(){
        return g;
    }
    
    public void Operate(){
        //realiza la operacion segun la compuerta
    }
    
    public int getResult(){
        return result;
    }
    
}
    
