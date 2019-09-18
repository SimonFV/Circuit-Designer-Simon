
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

class And extends Gate{
    
    //Constructor
    public And(Pane target, double x, double y) {
        super(target, x, y);
        this.ID = 0;
        this.Out = new Point(30,0);
        this.InTop = new Point(-40,-10);
        this.InBot = new Point(-40,10);
        g.getChildren().addAll(Out.getFigure(),InTop.getFigure(),InBot.getFigure());
    }
    
    @Override
    public void setxStart(double xStart) {
        Gate.xStart = xStart;
    }
    @Override
    public void setyStart(double yStart) {
        Gate.yStart = yStart;
    }
    @Override
    public void constructFigure(){
        
        g.getChildren().add(GateFigure.construct("AND"));
        g.setLayoutX(xStart);
        g.setLayoutY(yStart);
        
        
        //EVENTOS DE ARRASTRE DE COMPUERTA
        g.setOnMousePressed(e->MoveGate.MouseControl(e,this));
        g.setOnMouseReleased(e->MoveGate.MouseControl(e,this));
        g.setOnMouseDragged(e->MoveGate.MouseControl(e,this));
        g.setOnMouseEntered(e->MoveGate.MouseControl(e,this));
    }
    
    @Override
    public void moveFigure(double x, double y){
        xStart=x;
        yStart=y;
        Out.setX(x+30);
        Out.setY(y);
        InTop.setX(x-40);
        InTop.setY(y-10);
        InBot.setX(x-40);
        InBot.setY(y+10);
        g.setLayoutX(xStart);
        g.setLayoutY(yStart);
        
    }
   
   
}
