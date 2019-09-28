
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
* Clase fábrica de las figuras de la compuertas.
* @author: Simon Fallas V.
*/
public class GateFigure {
    
    /**
    * Método estático que devuelve la figura de la compuerta según el tipo solicitado.
    * @param type Tipo de compuerta.
    * @return g Group
    */
    public static Group construct(String type){
        Group g = new Group();
        g.getChildren().clear();
        if("AND".equals(type)){
            Line lineIn1 = new Line(-40,-10,-20,-10);
            Line lineIn2 = new Line(-40,10,-20,10);
            Line lineIn3 = new Line(-20,-20,-20,20);
            Line lineIn4 = new Line(-20,-20,-10,-20);
            Line lineIn5 = new Line(-20,20,-10,20);
            Line lineOut = new Line(15,0,30,0);
            CubicCurve curve1 = new CubicCurve(-10,-20,25,-18,25,18,-10,20);
            Rectangle fill = new Rectangle(-20,-20,10,40);
            fill.setFill(Color.BLUE);
            curve1.setFill(Color.BLUE);
            curve1.setStroke(Color.BLACK);
            curve1.setStrokeWidth(2);
            lineIn1.setStroke(Color.BLACK);
            lineIn1.setStrokeWidth(2);
            lineIn2.setStroke(Color.BLACK);
            lineIn2.setStrokeWidth(2);
            lineIn3.setStroke(Color.BLACK);
            lineIn3.setStrokeWidth(2);
            lineIn4.setStroke(Color.BLACK);
            lineIn4.setStrokeWidth(2);
            lineIn5.setStroke(Color.BLACK);
            lineIn5.setStrokeWidth(2);
            lineOut.setStroke(Color.BLACK);
            lineOut.setStrokeWidth(2);
            g.getChildren().addAll(fill,lineIn1,lineIn2,lineIn3,lineIn4,lineIn5,lineOut,curve1);
        }else if("ANDSELECTED".equals(type)){
            CubicCurve curve1 = new CubicCurve(-10,-20,25,-18,25,18,-10,20);
            Line lineIn3 = new Line(-20,-20,-20,20);
            Line lineIn4 = new Line(-20,-20,-10,-20);
            Line lineIn5 = new Line(-20,20,-10,20);
            Rectangle fill = new Rectangle(-20,-20,10,40);
            fill.setFill(Color.AQUA);
            lineIn3.setStroke(Color.BLUEVIOLET);
            lineIn3.setStrokeWidth(2);
            lineIn4.setStroke(Color.BLUEVIOLET);
            lineIn4.setStrokeWidth(2);
            lineIn5.setStroke(Color.BLUEVIOLET);
            lineIn5.setStrokeWidth(2);
            curve1.setFill(Color.AQUA);
            curve1.setStroke(Color.BLUEVIOLET);
            curve1.setStrokeWidth(2);
            g.getChildren().addAll(fill, curve1, lineIn3, lineIn4, lineIn5);
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
        }else if("CUSTOM".equals(type)){
            Rectangle rectangle = new Rectangle(50,50);
            rectangle.setFill(Color.GRAY);
            g.getChildren().add(rectangle);
        }else if("NOT".equals(type)){
            Line lineIn1 = new Line(-40,0,-20,0);
            Line lineOut = new Line(15,0,30,0);
            Polygon triangle = new Polygon(-20,-20,-20,20,15,0);
            Circle point = new Circle(17,0,4);
            point.setFill(Color.RED);
            point.setStroke(Color.BLACK);
            point.setStrokeWidth(2);
            triangle.setFill(Color.RED);
            triangle.setStroke(Color.BLACK);
            triangle.setStrokeWidth(2);
            lineIn1.setStroke(Color.BLACK);
            lineIn1.setStrokeWidth(2);
            lineOut.setStroke(Color.BLACK);
            lineOut.setStrokeWidth(2);
            g.getChildren().addAll(lineIn1, lineOut, triangle, point);
        }else if("NOTSELECTED".equals(type)){
            Polygon triangle = new Polygon(-20,-20,-20,20,15,0);
            Circle point = new Circle(17,0,4);
            point.setFill(Color.AQUA);
            point.setStroke(Color.BLUEVIOLET);
            point.setStrokeWidth(2);
            triangle.setFill(Color.AQUA);
            triangle.setStroke(Color.BLUEVIOLET);
            triangle.setStrokeWidth(2);
            g.getChildren().addAll(triangle, point);
        }else if("OR".equals(type)){
            Line lineIn1 = new Line(-40,-10,-20,-10);
            Line lineIn2 = new Line(-40,10,-20,10);
            QuadCurve lineIn3 = new QuadCurve(-20,-20,-15,0,-20,20);
            Line lineOut = new Line(15,0,30,0);
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-10,25,10,-20,20);
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
            Shape fill = Shape.subtract(curve1, lineIn3);
            curve1.setFill(null);
            lineIn3.setFill(null);
            fill.setFill(Color.DARKORANGE);
            g.getChildren().addAll(fill,lineIn1,lineIn2,lineIn3,
                    lineOut,curve1);
        }else if("ORSELECTED".equals(type)){
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-10,25,10,-20,20);
            QuadCurve lineIn3 = new QuadCurve(-20,-20,-15,0,-20,20);
            lineIn3.setStroke(Color.BLUEVIOLET);
            lineIn3.setStrokeWidth(2);
            curve1.setStroke(Color.BLUEVIOLET);
            curve1.setStrokeWidth(2);
            Shape fill = Shape.subtract(curve1, lineIn3);
            curve1.setFill(null);
            lineIn3.setFill(null);
            fill.setFill(Color.AQUA);
            g.getChildren().addAll(fill, curve1, lineIn3);
        }else if("NAND".equals(type)){
            Line lineIn1 = new Line(-40,-10,-20,-10);
            Line lineIn2 = new Line(-40,10,-20,10);
            Line lineIn3 = new Line(-20,-20,-20,20);
            Line lineIn4 = new Line(-20,-20,-10,-20);
            Line lineIn5 = new Line(-20,20,-10,20);
            Line lineOut = new Line(15,0,30,0);
            CubicCurve curve1 = new CubicCurve(-10,-20,25,-18,25,18,-10,20);
            Rectangle fill = new Rectangle(-20,-20,10,40);
            Circle point = new Circle(18,0,4);
            point.setFill(Color.HOTPINK);
            point.setStroke(Color.BLACK);
            point.setStrokeWidth(2);
            fill.setFill(Color.HOTPINK);
            curve1.setFill(Color.HOTPINK);
            curve1.setStroke(Color.BLACK);
            curve1.setStrokeWidth(2);
            lineIn1.setStroke(Color.BLACK);
            lineIn1.setStrokeWidth(2);
            lineIn2.setStroke(Color.BLACK);
            lineIn2.setStrokeWidth(2);
            lineIn3.setStroke(Color.BLACK);
            lineIn3.setStrokeWidth(2);
            lineIn4.setStroke(Color.BLACK);
            lineIn4.setStrokeWidth(2);
            lineIn5.setStroke(Color.BLACK);
            lineIn5.setStrokeWidth(2);
            lineOut.setStroke(Color.BLACK);
            lineOut.setStrokeWidth(2);
            g.getChildren().addAll(fill,lineIn1,lineIn2,lineIn3,lineIn4,lineIn5,
                    lineOut,curve1,point);
        }else if("NANDSELECTED".equals(type)){
            CubicCurve curve1 = new CubicCurve(-10,-20,25,-18,25,18,-10,20);
            Line lineIn3 = new Line(-20,-20,-20,20);
            Line lineIn4 = new Line(-20,-20,-10,-20);
            Line lineIn5 = new Line(-20,20,-10,20);
            Rectangle fill = new Rectangle(-20,-20,10,40);
            Circle point = new Circle(18,0,4);
            point.setFill(Color.AQUA);
            point.setStroke(Color.BLUEVIOLET);
            point.setStrokeWidth(2);
            fill.setFill(Color.AQUA);
            lineIn3.setStroke(Color.BLUEVIOLET);
            lineIn3.setStrokeWidth(2);
            lineIn4.setStroke(Color.BLUEVIOLET);
            lineIn4.setStrokeWidth(2);
            lineIn5.setStroke(Color.BLUEVIOLET);
            lineIn5.setStrokeWidth(2);
            curve1.setFill(Color.AQUA);
            curve1.setStroke(Color.BLUEVIOLET);
            curve1.setStrokeWidth(2);
            g.getChildren().addAll(fill, curve1, lineIn3, lineIn4, lineIn5, point);
        }else if("NOR".equals(type)){
            Line lineIn1 = new Line(-40,-10,-20,-10);
            Line lineIn2 = new Line(-40,10,-20,10);
            QuadCurve lineIn3 = new QuadCurve(-20,-20,-15,0,-20,20);
            Line lineOut = new Line(15,0,30,0);
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-10,25,10,-20,20);
            Circle point = new Circle(17,0,4);
            point.setFill(Color.GREEN);
            point.setStroke(Color.BLACK);
            point.setStrokeWidth(2);
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
            Shape fill = Shape.subtract(curve1, lineIn3);
            curve1.setFill(null);
            lineIn3.setFill(null);
            fill.setFill(Color.GREEN);
            g.getChildren().addAll(fill,lineIn1,lineIn2,lineIn3,
                    lineOut,curve1,point);
        }else if("NORSELECTED".equals(type)){
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-10,25,10,-20,20);
            QuadCurve lineIn3 = new QuadCurve(-20,-20,-15,0,-20,20);
            Circle point = new Circle(17,0,4);
            point.setFill(Color.AQUA);
            point.setStroke(Color.BLUEVIOLET);
            point.setStrokeWidth(2);
            lineIn3.setStroke(Color.BLUEVIOLET);
            lineIn3.setStrokeWidth(2);
            curve1.setStroke(Color.BLUEVIOLET);
            curve1.setStrokeWidth(2);
            Shape fill = Shape.subtract(curve1, lineIn3);
            curve1.setFill(null);
            lineIn3.setFill(null);
            fill.setFill(Color.AQUA);
            g.getChildren().addAll(fill, curve1, lineIn3, point);
        }else if("XOR".equals(type)){
            Line lineIn1 = new Line(-40,-10,-20,-10);
            Line lineIn2 = new Line(-40,10,-20,10);
            QuadCurve lineIn3 = new QuadCurve(-20,-20,-15,0,-20,20);
            QuadCurve lineIn4 = new QuadCurve(-25,-20,-20,0,-25,20);
            Line lineOut = new Line(15,0,30,0);
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-10,25,10,-20,20);
            curve1.setStroke(Color.BLACK);
            curve1.setStrokeWidth(2);
            lineIn1.setStroke(Color.BLACK);
            lineIn1.setStrokeWidth(2);
            lineIn2.setStroke(Color.BLACK);
            lineIn2.setStrokeWidth(2);
            lineIn3.setStroke(Color.BLACK);
            lineIn3.setStrokeWidth(2);
            lineIn4.setStroke(Color.BLACK);
            lineIn4.setStrokeWidth(2);
            lineOut.setStroke(Color.BLACK);
            lineOut.setStrokeWidth(2);
            Shape fill = Shape.subtract(curve1, lineIn3);
            curve1.setFill(null);
            lineIn3.setFill(null);
            lineIn4.setFill(null);
            fill.setFill(Color.YELLOW);
            g.getChildren().addAll(fill,lineIn1,lineIn2,lineIn3,
                    lineOut,curve1,lineIn4);
        }else if("XORSELECTED".equals(type)){
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-10,25,10,-20,20);
            QuadCurve lineIn3 = new QuadCurve(-20,-20,-15,0,-20,20);
            QuadCurve lineIn4 = new QuadCurve(-25,-20,-20,0,-25,20);
            lineIn3.setStroke(Color.BLUEVIOLET);
            lineIn3.setStrokeWidth(2);
            lineIn4.setStroke(Color.BLUEVIOLET);
            lineIn4.setStrokeWidth(2);
            curve1.setStroke(Color.BLUEVIOLET);
            curve1.setStrokeWidth(2);
            Shape fill = Shape.subtract(curve1, lineIn3);
            curve1.setFill(null);
            lineIn3.setFill(null);
            lineIn4.setFill(null);
            fill.setFill(Color.AQUA);
            g.getChildren().addAll(fill, curve1, lineIn3, lineIn4);
        }else if("XNOR".equals(type)){
            Line lineIn1 = new Line(-40,-10,-20,-10);
            Line lineIn2 = new Line(-40,10,-20,10);
            QuadCurve lineIn3 = new QuadCurve(-20,-20,-15,0,-20,20);
            QuadCurve lineIn4 = new QuadCurve(-25,-20,-20,0,-25,20);
            Line lineOut = new Line(15,0,30,0);
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-10,25,10,-20,20);
            Circle point = new Circle(17,0,4);
            point.setFill(Color.YELLOWGREEN);
            point.setStroke(Color.BLACK);
            point.setStrokeWidth(2);
            curve1.setStroke(Color.BLACK);
            curve1.setStrokeWidth(2);
            lineIn1.setStroke(Color.BLACK);
            lineIn1.setStrokeWidth(2);
            lineIn2.setStroke(Color.BLACK);
            lineIn2.setStrokeWidth(2);
            lineIn3.setStroke(Color.BLACK);
            lineIn3.setStrokeWidth(2);
            lineIn4.setStroke(Color.BLACK);
            lineIn4.setStrokeWidth(2);
            lineOut.setStroke(Color.BLACK);
            lineOut.setStrokeWidth(2);
            Shape fill = Shape.subtract(curve1, lineIn3);
            curve1.setFill(null);
            lineIn3.setFill(null);
            lineIn4.setFill(null);
            fill.setFill(Color.YELLOWGREEN);
            g.getChildren().addAll(fill,lineIn1,lineIn2,lineIn3,
                    lineOut,curve1,lineIn4,point);
        }else if("XNORSELECTED".equals(type)){
            CubicCurve curve1 = new CubicCurve(-20,-20,25,-10,25,10,-20,20);
            QuadCurve lineIn3 = new QuadCurve(-20,-20,-15,0,-20,20);
            QuadCurve lineIn4 = new QuadCurve(-25,-20,-20,0,-25,20);
            Circle point = new Circle(17,0,4);
            point.setFill(Color.AQUA);
            point.setStroke(Color.BLUEVIOLET);
            point.setStrokeWidth(2);
            lineIn3.setStroke(Color.BLUEVIOLET);
            lineIn3.setStrokeWidth(2);
            lineIn4.setStroke(Color.BLUEVIOLET);
            lineIn4.setStrokeWidth(2);
            curve1.setStroke(Color.BLUEVIOLET);
            curve1.setStrokeWidth(2);
            Shape fill = Shape.subtract(curve1, lineIn3);
            curve1.setFill(null);
            lineIn3.setFill(null);
            lineIn4.setFill(null);
            fill.setFill(Color.AQUA);
            g.getChildren().addAll(fill, curve1, lineIn3, lineIn4, point);
        }
        return g;
    }
    
}
