
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

class And extends Gate{
    
    //Constructor
    public And(Pane target, double x, double y) {
        super(target, x, y);
        this.ID = 0;
        this.Out = new Point();
        this.InTop = new Point();
        this.InBot = new Point();
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
        g = GateFigure.construct("AND");
        g.setLayoutX(xStart);
        g.setLayoutY(yStart);
        
        //EVENTOS DE ARRASTRE DE COMPUERTA
        g.setOnMousePressed(e->MoveGate.MouseControl(e,this));
        g.setOnMouseReleased(e->MoveGate.MouseControl(e,this));
        g.setOnMouseDragged(e->MoveGate.MouseControl(e,this));
        g.setOnMouseEntered(e->MoveGate.MouseControl(e,this));
    }
    
    @Override
    public void moveFigure(){
        g.setLayoutX(xStart);
        g.setLayoutY(yStart);
    }
    
    @Override
    public Group newPosition(double newX, double newY){
        moveFigure();
        return getFigure();
    }
   
}
