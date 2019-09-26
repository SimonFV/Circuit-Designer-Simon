
package circuit.designer.simon;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class EndPoint extends Gate{
    
    private Label LabelOut, LabelName;
    private String name;
    
    public EndPoint(Pane target, double x, double y, CircuitList circuit) {
        super(target, x, y, circuit);
        this.state = "End";
        this.ID = "ENDPOINT";
        this.code = 0;
        gselected = GateFigure.construct("ENDPOINTSELECTED");
        this.name = "n";
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
        
        this.LabelName = new Label(this.name);
        this.LabelName.setLayoutX(0);
        this.LabelName.setLayoutY(5);
        this.g.getChildren().addAll(LabelName);
        
        this.LabelOut = new Label("0");
        this.LabelOut.setLayoutX(15);
        this.LabelOut.setLayoutY(-10);
        this.g.getChildren().add(LabelOut);
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
        this.LabelOut.setText(Integer.toString(this.result));
        return this.result;
    }
    
    @Override
    public void setName(String name){
        this.name = name;
        this.LabelName.setText(this.name);
    }
    
}
