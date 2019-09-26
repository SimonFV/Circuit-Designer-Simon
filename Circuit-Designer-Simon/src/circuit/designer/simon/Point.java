
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class Point extends Gate{
    
    public Point(Pane target, double x, double y, CircuitList circuit){
        super(target, x, y, circuit);
        this.ID = "POINT";
        this.gselected = GateFigure.construct("POINTSELECTED");
    }
    
    @Override
    public void constructFigure(){
        this.g = GateFigure.construct("POINT");
        this.g.setLayoutX(this.xStart);
        this.g.setLayoutY(this.yStart);
        
        //EVENTOS DE POINT
        this.g.setOnMouseClicked(e->MoveGate.PointControl(e, this, this.circuit));
        
        if(this.prev != null){
            this.g.setOnMousePressed(e->MoveGate.MouseControl(e,this,circuit));
            this.g.setOnMouseReleased(e->MoveGate.MouseControl(e,this,circuit));
            this.g.setOnMouseDragged(e->MoveGate.MouseControl(e,this,circuit));
            this.g.setOnMouseEntered(e->MoveGate.MouseControl(e,this,circuit));
        }
    }
    
    @Override
    public void moveFigure(double x, double y){
        this.xStart=x;
        this.yStart=y;
        this.g.setLayoutX(this.xStart);
        this.g.setLayoutY(this.yStart);
        
    }
    
    @Override
    public int getResult(){
        if(this.prev==null){
            if(this.rFrom!=null){
                this.result = this.rFrom.getResult();
            }else if("fOpen".equals(this.state)){
                this.result = this.parent.getResult();
            }else{
                this.result = 0;
            }
        }else{
            if(this.rFrom!=null){
                this.result = this.rFrom.getResult();
            }else{
                this.result = 0;
            }
        }
        return this.result;
    }
    
}
