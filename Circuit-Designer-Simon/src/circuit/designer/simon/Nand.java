
package circuit.designer.simon;

import javafx.scene.layout.Pane;

public class Nand extends Gate {
    public Nand(Pane target, double x, double y, CircuitList circuit) {
        super(target, x, y, circuit);
        this.state = "Active";
        this.ID = "NAND";
        this.code = 0;
        this.Out = new Point(target,x+30,y,circuit);
        this.Out.constructFigure();
        this.Out.state = "fOpen";
        this.Out.code = 1;
        this.InTop = new Point(target,x-40,y-10,circuit);
        this.InTop.constructFigure();
        this.InTop.state = "bOpen";
        this.InTop.code = 2;
        this.InBot = new Point(target,x-40,y+10,circuit);
        this.InBot.constructFigure();
        this.InBot.state = "bOpen";
        this.InBot.code = 3;
        this.Out.parent = this;
        this.InTop.parent = this;
        this.InBot.parent = this;
        this.gselected = GateFigure.construct("NANDSELECTED");
    }
    
    @Override
    public void constructFigure(){
        
        this.g.getChildren().add(GateFigure.construct("NAND"));
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
        if(in1==0&&in2==0){
            this.result = 1;
        }else{
            this.result = 0;
        }
        return this.result;
    }
}
