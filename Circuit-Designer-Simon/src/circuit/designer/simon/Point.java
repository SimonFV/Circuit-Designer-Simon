
package circuit.designer.simon;

import javafx.scene.Group;

public class Point{
    
    private boolean conected;
    private Gate prev;
    private Gate next;
    private double x;
    private double y;
    private Group g;
    
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
        this.prev = null;
        this.next = null;
        this.conected = false;
        constructFigure();
    }
    
    public void constructFigure(){
        g = GateFigure.construct("POINT");
        g.setLayoutX(x);
        g.setLayoutY(y);
        
        //EVENTOS DE POINT
        g.setOnMouseClicked(e->MoveGate.PointControl(e, this));
    }
    
    public Group getFigure(){
        return g;
    }
    
    public boolean isConected() {
        return conected;
    }
    public void setConected(boolean conected) {
        this.conected = conected;
    }
    public Gate getPrev() {
        return prev;
    }
    public void setPrev(Gate prev) {
        this.prev = prev;
    }
    public Gate getNext() {
        return next;
    }
    public void setNext(Gate next) {
        this.next = next;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    
}
