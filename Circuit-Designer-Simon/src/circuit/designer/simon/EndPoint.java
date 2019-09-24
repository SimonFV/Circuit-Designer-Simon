
package circuit.designer.simon;

import javafx.scene.layout.Pane;

public class EndPoint extends Gate{
    public EndPoint(Pane target, double x, double y, CircuitList circuit) {
        super(target, x, y, circuit);
        this.state = "End";
        this.ID = "ENDPOINT";
        this.code = 0;
        gselected = GateFigure.construct("ENDPOINTSELECTED");
    }
    
    @Override
    public void constructFigure(){
        
        this.g.getChildren().add(GateFigure.construct("ENDPOINT"));
        this.g.setLayoutX(this.xStart);
        this.g.setLayoutY(this.yStart);
        
        //EVENTO DE POINT
        this.g.setOnMouseClicked(e->MoveGate.PointControl(e, this, this.circuit));
        //EVENTOS DE ARRASTRE DE COMPUERTA
        this.g.setOnMousePressed(e->MoveGate.MouseControl(e,this,circuit));
        this.g.setOnMouseReleased(e->MoveGate.MouseControl(e,this,circuit));
        this.g.setOnMouseDragged(e->MoveGate.MouseControl(e,this,circuit));
        this.g.setOnMouseEntered(e->MoveGate.MouseControl(e,this,circuit));
        this.g.setOnMouseExited(e->MoveGate.MouseControl(e,this,circuit));
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
        if(this.rFrom!=null){
            this.result = this.rFrom.getResult();
        }else{
            this.result = 0;
        }
        return this.result;
    }
    
}
