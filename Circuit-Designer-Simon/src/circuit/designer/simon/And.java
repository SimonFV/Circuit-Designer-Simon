
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;

class And extends Gate{
    private static Line lineIn1, lineIn2, lineIn3, lineOut;
    private static CubicCurve curve1;
    
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
        lineIn1 = new Line(xStart, yStart, xStart+20, yStart);
        lineIn2 = new Line(xStart, yStart+20, xStart+20, yStart+20);
        lineIn3 = new Line(xStart+20, yStart-10, xStart+20, yStart+30);
        lineOut = new Line(xStart+55, yStart+10, xStart+70, yStart+10);
        
        curve1 = new CubicCurve(xStart+20,yStart-10,xStart+65,yStart-10,xStart+65,yStart+30,xStart+20,yStart+30);
        curve1.setFill(Color.BLUE);
        curve1.setStroke(Color.BLACK);
        lineIn1.setStroke(Color.BLACK);
        lineIn2.setStroke(Color.BLACK);
        lineIn3.setStroke(Color.BLACK);
        lineOut.setStroke(Color.BLACK);
        
        g.getChildren().addAll(lineIn1, lineIn2, lineIn3, lineOut, curve1);
        g.setLayoutX(xStart);
        g.setLayoutY(yStart);
        
        g.setOnMousePressed(e->MoveGate.MouseControl(e,this));
        g.setOnMouseReleased(e->MoveGate.MouseControl(e,this));
        g.setOnMouseDragged(e->MoveGate.MouseControl(e,this));
        g.setOnMouseEntered(e->MoveGate.MouseControl(e,this));
        //g.setOnDragDetected(e->MoveGate.MouseControl(e,this));
        //target.setOnDragOver(e->MoveGate.DragControl(e,this,target));
        //target.setOnDragEntered(e->MoveGate.DragControl(e,this,target));
        //target.setOnDragExited(e->MoveGate.DragControl(e,this,target));
        //target.setOnDragDropped(e->MoveGate.DragControl(e,this,target));
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
