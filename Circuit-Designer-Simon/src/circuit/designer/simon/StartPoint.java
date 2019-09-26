
package circuit.designer.simon;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;

class StartPoint extends Gate{
    
    private ChoiceBox<String> InBox;
    
    //Constructor
    public StartPoint(Pane target, double x, double y, CircuitList circuit) {
        super(target, x, y, circuit);
        this.state = "Start";
        this.ID = "STARTPOINT";
        this.code = 0;
        this.gselected = GateFigure.construct("STARTPOINTSELECTED");
    }
    
    @Override
    public void constructFigure(){
        
        this.g.getChildren().add(GateFigure.construct("STARTPOINT"));
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
        
        //Drop list
        this.InBox = new ChoiceBox<>();
        this.InBox.getItems().addAll("0", "1");
        this.InBox.setValue("0");
        this.InBox.setLayoutX(-50);
        this.InBox.setLayoutY(-15);
        this.g.getChildren().addAll(InBox);
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
        this.result = Integer.parseInt(this.InBox.getValue());
        return this.result;
    }
    
}
