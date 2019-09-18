
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;

public class GateFigure {
    
    public static Group construct(String type){
        Group g = new Group();
        g.getChildren().clear();
        if("AND".equals(type)){
            Line lineIn1 = new Line(-40,-10,-20,-10);
            Line lineIn2 = new Line(-40,10,-20,10);
            Line lineIn3 = new Line(-20,-20,-20,20);
            Line lineOut = new Line(15,0,30,0);
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-20,25,20,-20,20);
            curve1.setFill(Color.BLUE);
            curve1.setStroke(Color.BLACK);
            lineIn1.setStroke(Color.BLACK);
            lineIn2.setStroke(Color.BLACK);
            lineIn3.setStroke(Color.BLACK);
            lineOut.setStroke(Color.BLACK);
            g.getChildren().addAll(lineIn1, lineIn2, lineIn3, lineOut, curve1);
        }if("POINT".equals(type)){
            Circle point = new Circle(4);
            g.getChildren().add(point);
        }
        return g;
    }
    
}
