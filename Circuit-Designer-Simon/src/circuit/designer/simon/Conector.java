
package circuit.designer.simon;

import static java.lang.Math.abs;
import java.util.Random;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class Conector{
    protected Pane target;
    protected Conector prev, next;
    protected Gate from, to;
    protected double xStart, yStart, xFinal, yFinal;
    protected Line line1, line2, line3;
    protected Group g;
    
    public Conector(Gate from, Gate to, Pane target){
        this.from = from;
        this.to = to;
        this.target = target;
        g = new Group();
        
        this.line1 = new Line(0,10,0,10);
        this.line2 = new Line(0,10,0,5);
        this.line3 = new Line(0,2,0,4);
        this.g.getChildren().addAll(this.line1, this.line2, this.line3);
        
    }
    
    public void setFigure(){
        this.xStart = from.getxStart();
        this.yStart = from.getyStart();
        this.xFinal = to.getxStart();
        this.yFinal = to.getyStart();
        if(this.xStart<this.xFinal){
            this.line1.setStartX(this.xStart);
            this.line1.setStartY(this.yStart);
            this.line1.setEndX((this.xFinal+this.xStart)/2);
            this.line1.setEndY(this.yStart);
            this.line2.setStartX((this.xFinal+xStart)/2);
            this.line2.setStartY(this.yStart);
            this.line2.setEndX((this.xFinal+this.xStart)/2);
            this.line2.setEndY(this.yFinal);
            this.line3.setStartX((this.xFinal+this.xStart)/2);
            this.line3.setStartY(this.yFinal);
            this.line3.setEndX(this.xFinal);
            this.line3.setEndY(this.yFinal);
        }else if(this.xStart>this.xFinal){
            this.line1.setStartX(this.xStart);
            this.line1.setStartY(this.yStart);
            this.line1.setEndX(this.xStart);
            this.line1.setEndY((this.yStart+this.yFinal)/2);
            this.line2.setStartX(xStart);
            this.line2.setStartY((this.yStart+this.yFinal)/2);
            this.line2.setEndX(this.xFinal);
            this.line2.setEndY((this.yStart+this.yFinal)/2);
            this.line3.setStartX(this.xFinal);
            this.line3.setStartY((this.yStart+this.yFinal)/2);
            this.line3.setEndX(this.xFinal);
            this.line3.setEndY(this.yFinal);
        }
        
        
    }
    
    public Group getFigure(){
        return this.g;
    }
    
    public void setColors(){
        Random random = new Random();
        int red = random.nextInt(250);
        int green = random.nextInt(250);
        int blue = random.nextInt(200);
        if(abs(red-green)>60 || abs(red-blue)>60 || abs(blue-green)>60){
            this.line1.setStrokeWidth(2);
            this.line2.setStrokeWidth(2);
            this.line3.setStrokeWidth(2);
            this.line1.setStroke(Color.rgb(red, green, blue));
            this.line2.setStroke(Color.rgb(red, green, blue));
            this.line3.setStroke(Color.rgb(red, green, blue));
        }else{
            setColors();
        }
    }
}
