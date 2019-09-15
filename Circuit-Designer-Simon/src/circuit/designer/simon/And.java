
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;

public final class And extends Gate{
    private static Line lineIn1, lineIn2, lineIn3, lineOut;
    private static CubicCurve curve1;
    
    //Constructor
    public And(double x, double y) {
        super(x, y);
        this.ID = 0;
        this.Out = new Point();
        this.InTop = new Point();
        this.InBot = new Point();
        constructFigure();
        
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
    }
    
    @Override
    public void moveFigure(){
        lineIn1.setStartX(xStart);
        lineIn1.setStartY(yStart);
        lineIn1.setEndX(xStart+20);
        lineIn1.setEndY(yStart);
        lineIn2.setStartX(xStart);
        lineIn2.setStartY(yStart+20);
        lineIn2.setEndX(xStart+20);
        lineIn2.setEndY(yStart+20);
        lineIn3.setStartX(xStart+20);
        lineIn3.setStartY(yStart-10);
        lineIn3.setEndX(xStart+20);
        lineIn3.setEndY(yStart+30);
        lineOut.setStartX(xStart+55);
        lineOut.setStartY(yStart+10);
        lineOut.setEndX(xStart+70);
        lineOut.setEndY(yStart+10);
        curve1.setStartX(xStart+20);
        curve1.setStartY(yStart-10);
        curve1.setControlX1(xStart+65);
        curve1.setControlY1(yStart-10);
        curve1.setControlX2(xStart+65);
        curve1.setControlY2(yStart+30);
        curve1.setEndX(xStart+20);
        curve1.setEndY(yStart+30);
    }
    
    @Override
    public Group newPosition(double newX, double newY){
        Gate.setxStart(newX);
        Gate.setyStart(newY);
        moveFigure();
        return getFigure();
    }
}
