
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class And extends Gate{
    private static Line lineIn1, lineIn2, lineIn3, lineOut;
    //private static Arc arc1;
    private static CubicCurve curve1;
    
    //Constructor
    public And(int x, int y) {
        super(x, y);
    }
    public static Group getFigure(){
        lineIn1 = new Line(xStart, yStart, xStart+20, yStart);
        lineIn2 = new Line(xStart, yStart+20, xStart+20, yStart+20);
        lineIn3 = new Line(xStart+20, yStart-10, xStart+20, yStart+30);
        lineOut = new Line(xStart+55, yStart+10, xStart+70, yStart+10);
        
        //lineIn1.setScaleY(5);
        //arc1 = new Arc(xStart+40, yStart+15, 40, 30, 260, 200);
        curve1 = new CubicCurve(xStart+20,yStart-10,xStart+65,yStart-10,xStart+65,yStart+30,xStart+20,yStart+30);
        curve1.setFill(Color.BLUE);
        curve1.setStroke(Color.BLACK);
        
        Group g = new Group();
        g.getChildren().addAll(lineIn1, lineIn2, lineIn3, lineOut, curve1);
        
        return g;
    }
    
}
