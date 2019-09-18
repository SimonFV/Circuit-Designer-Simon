
package circuit.designer.simon;


import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_DRAGGED;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;

public class MoveGate{
    private static double newX, newY;
    private static double rX, rY;
    private static boolean conecting = false;
    
    
    public static void MouseControl(MouseEvent event, Gate source){
        if(event.getEventType()==MOUSE_PRESSED){
            source.getFigure().setCursor(Cursor.MOVE);
        }else if(event.getEventType()==MOUSE_RELEASED) {
            source.getFigure().setCursor(Cursor.HAND);
        }else if(event.getEventType()==MOUSE_DRAGGED){
            newX = event.getSceneX();
            rX = newX%10;
            newY = event.getSceneY();
            rY = newY%10;
            //Movimiento cuadriculado
            if(newX%10<5){
                newX=newX-rX;
            }else{
                newX=newX-rX+10;
            }
            if(newY%10<5){
                newY=newY-rY;
            }else{
                newY=newY-rY+10;
            }
            if (newX > 500 || newX < 100 || newY < 0 || newY > 500) {
                return;
            }else{
                
                source.moveFigure(newX, newY);
            }
        }else if(event.getEventType()==MOUSE_ENTERED){
                source.getFigure().setCursor(Cursor.HAND);
        }
    }
    
    public static void PointControl(MouseEvent event, Point source){
        
        if(conecting){
            System.out.println("Conecting Done");
            conecting = false;
        }else{
            System.out.println("Conecting Now");
            conecting = true;
        }
        
    }

    
}