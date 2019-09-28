
package circuit.designer.simon;

import javafx.scene.layout.Pane;

public class Not extends Gate{
    public Not(Pane target, double x, double y, CircuitList circuit) {
        super(target, x, y, circuit);
        this.state = "Active";
        this.ID = "NOT";
        this.code = 0;
        this.Out = new Point(target,x+30,y,circuit);
        this.Out.constructFigure();
        this.Out.state = "fOpen";
        this.Out.code = 1;
        this.InTop = new Point(target,x-40,y,circuit);
        this.InTop.constructFigure();
        this.InTop.state = "bOpen";
        this.InTop.code = 2;
        this.Out.parent = this;
        this.InTop.parent = this;
        this.gselected = GateFigure.construct("NOTSELECTED");
    }
    
    @Override
    public void constructFigure(){
        
        this.g.getChildren().add(GateFigure.construct("NOT"));
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
        this.InTop.moveFigure(x-40, y);
    }
    
    @Override
    public int getResult(){
        int in1 = this.InTop.getResult();
        if(in1==1){
            this.result = 0;
        }else{
            this.result = 1;
        }
        return this.result;
    }
    
}
