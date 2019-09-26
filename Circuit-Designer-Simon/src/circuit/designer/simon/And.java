
package circuit.designer.simon;

import javafx.scene.layout.Pane;

class And extends Gate{
    
    //Constructor
    public And(Pane target, double x, double y, CircuitList circuit) {
        super(target, x, y, circuit);
        this.state = "Active";
        this.ID = "AND";
        this.code = 0;
        this.Out = new Point(target,x+30,y,circuit);
        this.Out.constructFigure();
        this.Out.state = "fOpen";
        this.InTop = new Point(target,x-40,y-10,circuit);
        this.InTop.constructFigure();
        this.InTop.state = "bOpen";
        this.InBot = new Point(target,x-40,y+10,circuit);
        this.InBot.constructFigure();
        this.InBot.state = "bOpen";
        this.Out.parent = this;
        this.InTop.parent = this;
        this.InBot.parent = this;
        this.gselected = GateFigure.construct("ANDSELECTED");
        
    }
    
    @Override
    public void constructFigure(){
        
        this.g.getChildren().add(GateFigure.construct("AND"));
        this.g.setLayoutX(this.xStart);
        this.g.setLayoutY(this.yStart);
        
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
        this.Out.moveFigure(x+30, y);
        this.InTop.moveFigure(x-40, y-10);
        this.InBot.moveFigure(x-40, y+10);
    }
    
    @Override
    public int getResult(){
        int in1 = this.InTop.getResult();
        int in2 = this.InBot.getResult();
        this.result = in1*in2;
        return this.result;
    }
    
}
