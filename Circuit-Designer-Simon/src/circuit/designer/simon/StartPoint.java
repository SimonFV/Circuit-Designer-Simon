
package circuit.designer.simon;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

class StartPoint extends Gate{
    
    private Label LabelName;
    private ChoiceBox<String> InBox;
    private String name;
    
    //Constructor
    public StartPoint(Pane target, double x, double y, CircuitList circuit) {
        super(target, x, y, circuit);
        this.state = "Start";
        this.ID = "STARTPOINT";
        this.code = 0;
        this.gselected = GateFigure.construct("STARTPOINTSELECTED");
        this.name = "n";
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
        
        this.LabelName = new Label(this.name);
        this.LabelName.setLayoutX(0);
        this.LabelName.setLayoutY(5);
        this.g.getChildren().addAll(LabelName);
        
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
    
    @Override
    public void setName(String name){
        this.name = name;
        this.LabelName.setText(this.name);
    }
    
}
