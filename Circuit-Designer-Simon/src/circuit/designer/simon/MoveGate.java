
package circuit.designer.simon;


import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_DRAGGED;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;

public class MoveGate{
    private static double newX, newY;
    
    
    public static void MouseControl(MouseEvent event, Gate source){
        if(event.getEventType()==MOUSE_PRESSED){
            source.getFigure().setCursor(Cursor.MOVE);
        }else if(event.getEventType()==MOUSE_RELEASED) {
            source.getFigure().setCursor(Cursor.HAND);
        }else if(event.getEventType()==MOUSE_DRAGGED){
            newX = event.getSceneX();
            newY = event.getSceneY();
            if (newX > 500 || newX < 0 || newY < 0 || newY > 500) {
                return;
            }else{
                source.setxStart(newX);
                source.setyStart(newY);
                source.moveFigure();
            }
        }else if(event.getEventType()==MOUSE_ENTERED){
                source.getFigure().setCursor(Cursor.HAND);
        }
    }
}