
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

abstract class Gate {
    
    protected double xStart, yStart;
    protected Group g, gselected;
    protected Pane target;
    protected Gate next, prev, InTop, InBot, Out, rFrom, parent;
    protected String ID, state; //Estados: Active, bOpen, fOpen, Start, End, Closed
    protected int code,result;
    protected boolean selected;
    protected CircuitList circuit;
    
    public Gate(Pane target, double x, double y, CircuitList circuit){
        this.circuit = circuit;
        this.target = target;
        this.xStart = x;
        this.yStart = y;
        this.result = 0;
        
        this.g = new Group();
        this.gselected = new Group();
        
        this.ID = "GATE";
        this.next = null;
        this.prev = null;
        this.rFrom = null;
        this.InTop = null;
        this.InBot = null;
        this.Out = null;
        this.parent = this;
        
        this.selected = false;
        this.state = "Active";
    }
    
    //Getters & Setters
    public double getxStart() {
        return this.xStart;
    }
    public void setxStart(double xStart) {
        this.xStart = xStart;
    }
    public double getyStart() {
        return this.yStart;
    }
    public void setyStart(double yStart) {
        this.yStart = yStart;
    }
    public String getID() {
        return this.ID;
    }
    
    public void constructFigure(){}
    
    public void moveFigure(double x, double y){}
    
    public Group getFigure(){
        return this.g;
    }
    
    public int getResult(){
        return this.result;
    }
    public void setResult(int result){}
    
    public void setrFrom(Gate rFrom){
        this.rFrom=rFrom;
    }
    public Gate getrFrom(){
        return this.rFrom;
    }
    
    public void nowSelected(){
        this.selected = true;
        this.g.getChildren().add(this.gselected);
    }
    public void unSelected(){
        this.selected = false;
        this.g.getChildren().remove(this.gselected);
    }
    
    public void setName(String name){}
    
    public String getName(){
        return "asd";
    }
    
    public void setTesting(boolean testing){}
}
    
