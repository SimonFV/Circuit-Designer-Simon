
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;

public class GateFigure {
    
    public static Group construct(String type){
        Group g = new Group();
        if("AND".equals(type)){
            Line lineIn1 = new Line(-35,-10,-15,-10);
            Line lineIn2 = new Line(-35,10,-15,10);
            Line lineIn3 = new Line(-15,-20,-15,20);
            Line lineOut = new Line(20,0,35,0);
            CubicCurve curve1 = new CubicCurve(-15,-20,30,-20,30,20,-15,20);
            curve1.setFill(Color.BLUE);
            curve1.setStroke(Color.BLACK);
            lineIn1.setStroke(Color.BLACK);
            lineIn2.setStroke(Color.BLACK);
            lineIn3.setStroke(Color.BLACK);
            lineOut.setStroke(Color.BLACK);
            g.getChildren().addAll(lineIn1, lineIn2, lineIn3, lineOut, curve1);
        }
        return g;
    }
    
}
