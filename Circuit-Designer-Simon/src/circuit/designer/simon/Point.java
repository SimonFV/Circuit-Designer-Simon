
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class Point extends Gate{
    
    public Point(Pane target, double x, double y, CircuitList circuit){
        super(target, x, y, circuit);
        this.ID = "POINT";
    }
    
    @Override
    public void constructFigure(){
        this.g = GateFigure.construct("POINT");
        this.g.setLayoutX(this.xStart);
        this.g.setLayoutY(this.yStart);
        
        //EVENTOS DE POINT
        this.g.setOnMouseClicked(e->MoveGate.PointControl(e, this, this.circuit));
        
        if(this.prev != null){
            this.g.setOnMousePressed(e->MoveGate.MouseControl(e,this));
            this.g.setOnMouseReleased(e->MoveGate.MouseControl(e,this));
            this.g.setOnMouseDragged(e->MoveGate.MouseControl(e,this));
            this.g.setOnMouseEntered(e->MoveGate.MouseControl(e,this));
        }
    }
    
    @Override
    public void moveFigure(double x, double y){
        this.xStart=x;
        this.yStart=y;
        this.g.setLayoutX(this.xStart);
        this.g.setLayoutY(this.yStart);
        
    }
    
    public void setrFrom(Point rFrom){
        this.rFrom=rFrom;
    }
    public Gate getrFrom(){
        return this.rFrom;
    }
    
    
}
