
package circuit.designer.simon;

import javafx.scene.layout.Pane;

class StartPoint extends Gate{
    
    //Constructor
    public StartPoint(Pane target, double x, double y, CircuitList circuit) {
        super(target, x, y, circuit);
        this.state = "Start";
        this.ID = "STARTPOINT";
        this.code = 0;
    }
    
    @Override
    public void setxStart(double xStart) {
        this.xStart = xStart;
    }
    @Override
    public void setyStart(double yStart) {
        this.yStart = yStart;
    }
    @Override
    public void constructFigure(){
        
        this.g.getChildren().add(GateFigure.construct("AND"));
        this.g.setLayoutX(this.xStart);
        this.g.setLayoutY(this.yStart);
        this.g.getChildren().addAll(this.Out.getFigure(),this.InTop.getFigure(),this.InBot.getFigure());
        
        this.g.setOnMouseClicked(e->MoveGate.GateControl(e,this,this.circuit));
        //EVENTOS DE ARRASTRE DE COMPUERTA
        this.g.setOnMousePressed(e->MoveGate.MouseControl(e,this,circuit));
        this.g.setOnMouseReleased(e->MoveGate.MouseControl(e,this,circuit));
        this.g.setOnMouseDragged(e->MoveGate.MouseControl(e,this,circuit));
        this.g.setOnMouseEntered(e->MoveGate.MouseControl(e,this,circuit));
        this.g.setOnMouseExited(e->MoveGate.MouseControl(e,this,circuit));
        this.Out.setxStart(this.xStart+30);
        this.Out.setyStart(this.yStart);
        this.InTop.setxStart(this.xStart-40);
        this.InTop.setyStart(this.yStart-10);
        this.InBot.setxStart(this.xStart-40);
        this.InBot.setyStart(this.yStart+10);
    }
    
    @Override
    public void moveFigure(double x, double y){
        this.xStart=x;
        this.yStart=y;
        this.Out.setxStart(x+30);
        this.Out.setyStart(y);
        this.InTop.setxStart(x-40);
        this.InTop.setyStart(y-10);
        this.InBot.setxStart(x-40);
        this.InBot.setyStart(y+10);
        this.g.setLayoutX(this.xStart);
        this.g.setLayoutY(this.yStart);
    }
   
   
}
