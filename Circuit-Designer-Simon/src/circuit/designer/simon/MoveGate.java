
package circuit.designer.simon;


import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import static javafx.scene.input.DragEvent.DRAG_DONE;
import static javafx.scene.input.DragEvent.DRAG_DROPPED;
import static javafx.scene.input.DragEvent.DRAG_ENTERED;
import static javafx.scene.input.DragEvent.DRAG_EXITED;
import static javafx.scene.input.DragEvent.DRAG_OVER;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_DRAGGED;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class MoveGate{
    private static double newX, newY;
    
    
    public static void MouseControl(MouseEvent event, Gate source){
        double orgSceneX = 0;
        double orgSceneY = 0;
        double orgTranslateX = 0;
        double orgTranslateY = 0;
        
        final Delta dragDelta = new Delta();
        if(event.getEventType()==MOUSE_PRESSED){
            
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
            orgTranslateX = ((Group)(event.getSource())).getTranslateX();
            orgTranslateY = ((Group)(event.getSource())).getTranslateY();
            
            //dragDelta.x = source.getFigure().getLayoutX() - event.getSceneX();
            //dragDelta.y = source.getFigure().getLayoutY() - event.getSceneY();
            
            source.getFigure().setCursor(Cursor.MOVE);
        }else if(event.getEventType()==MOUSE_RELEASED) {
            source.getFigure().setCursor(Cursor.HAND);
        }else if(event.getEventType()==MOUSE_DRAGGED){
            newX = event.getSceneX();
            newY = event.getSceneY();
            System.out.println(newX+","+ newY);
            if (newX > 500 || newX < 0 || newY < 0 || newY > 500) {
                return;
            }else{
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;
                
                //source.setxStart(event.getX());
                //source.setyStart(event.getY());
                
                //((Group)(event.getSource())).setTranslateX(newTranslateX);
                //((Group)(event.getSource())).setTranslateY(newTranslateY);
                //source.getFigure().setLayoutX(event.getSceneX() + dragDelta.x);
                //source.getFigure().setLayoutY(event.getSceneY() + dragDelta.y);
                
            }
            source.setxStart(event.getSceneX());
            source.setyStart(event.getSceneY());
            source.moveFigure();
                
        }else if(event.getEventType()==MOUSE_ENTERED){
                source.getFigure().setCursor(Cursor.HAND);
        }
        //event.consume();   
        
        //System.out.println("Click"+source.getFigure().toString());
        //Dragboard db = source.getFigure().startDragAndDrop(TransferMode.MOVE);
        //ClipboardContent content = new ClipboardContent();
        //content.putString("asd");
        //db.setContent(content);
        //event.consume();
    }

    public static void DragControl(DragEvent event, Gate source, Pane target) {
        if (event.getEventType()==DRAG_OVER && 
                event.getGestureSource() != target && 
                event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.MOVE);
            //System.out.println(source.getFigure().toString());
            
            System.out.println("aqui");
            source.setxStart(event.getX());
            source.setyStart(event.getY());
            //source.getFigure().setLayoutX(event.getX());
            //source.getFigure().setLayoutY(event.getY());
            
        }else if(event.getEventType()==DRAG_ENTERED &&
                event.getGestureSource() != target &&
                event.getDragboard().hasString()) {
            //ASD
        }else if(event.getEventType()==DRAG_EXITED){
            //ASD
        }else if(event.getEventType()==DRAG_DROPPED){
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                success = true;
            }
            event.setDropCompleted(success);
        }
        event.consume();
    }
    
    
}
class Delta { double x, y; }