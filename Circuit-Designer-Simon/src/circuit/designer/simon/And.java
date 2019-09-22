
package circuit.designer.simon;

import javafx.scene.layout.Pane;

class And extends Gate{
    
    //Constructor
    public And(Pane target, double x, double y, CircuitList circuit) {
        super(target, x, y, circuit);
        this.state = "fOpen";
        this.ID = "AND";
        this.code = 0;
        this.Out = new Point(target,30,0,circuit);
        this.Out.constructFigure();
        this.Out.state = "fOpen";
        this.InTop = new Point(target,-40,-10,circuit);
        this.InTop.constructFigure();
        this.InTop.state = "bOpen";
        this.InBot = new Point(target,-40,10,circuit);
        this.InBot.constructFigure();
        this.InBot.state = "bOpen";
        
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
