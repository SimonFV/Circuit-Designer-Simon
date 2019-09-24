
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
            curve1.setStrokeWidth(2);
            lineIn1.setStroke(Color.BLACK);
            lineIn1.setStrokeWidth(2);
            lineIn2.setStroke(Color.BLACK);
            lineIn2.setStrokeWidth(2);
            lineIn3.setStroke(Color.BLACK);
            lineIn3.setStrokeWidth(2);
            lineOut.setStroke(Color.BLACK);
            lineOut.setStrokeWidth(2);
            g.getChildren().addAll(lineIn1, lineIn2, lineIn3, lineOut, curve1);
        }else if("ANDSELECTED".equals(type)){
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-20,25,20,-20,20);
            Line lineIn3 = new Line(-20,-20,-20,20);
            lineIn3.setStroke(Color.BLUEVIOLET);
            lineIn3.setStrokeWidth(2);
            curve1.setFill(Color.AQUA);
            curve1.setStroke(Color.BLUEVIOLET);
            curve1.setStrokeWidth(2);
            g.getChildren().addAll(curve1, lineIn3);
        }else if("POINT".equals(type)){
            Circle point = new Circle(4);
            point.setFill(Color.GREEN);
            g.getChildren().add(point);
        }else if("POINTSELECTED".equals(type)){
            Circle pointselected = new Circle(4);
            pointselected.setFill(Color.AQUA);
            g.getChildren().add(pointselected);
        }else if("STARTPOINT".equals(type)){
            Circle point = new Circle(5);
            point.setFill(Color.BLUEVIOLET);
            g.getChildren().add(point);
        }else if("STARTPOINTSELECTED".equals(type)){
            Circle point = new Circle(5);
            point.setFill(Color.AQUA);
            g.getChildren().add(point);
        }else if("ENDPOINT".equals(type)){
            Circle point = new Circle(5);
            point.setFill(Color.DARKCYAN);
            g.getChildren().add(point);
        }else if("ENDPOINTSELECTED".equals(type)){
            Circle point = new Circle(5);
            point.setFill(Color.AQUA);
            g.getChildren().add(point);
        }
        return g;
    }
    
}
