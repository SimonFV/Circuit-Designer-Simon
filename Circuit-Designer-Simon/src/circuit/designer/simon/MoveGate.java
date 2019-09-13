
package circuit.designer.simon;


import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import static javafx.scene.input.DragEvent.DRAG_DONE;
import static javafx.scene.input.DragEvent.DRAG_DROPPED;
import static javafx.scene.input.DragEvent.DRAG_ENTERED;
import static javafx.scene.input.DragEvent.DRAG_EXITED;
import static javafx.scene.input.DragEvent.DRAG_OVER;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class MoveGate {
    
    public static void MouseControl(And source, Pane target, MouseEvent event){
        Dragboard db = source.getFigure().startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString("asd");
        db.setContent(content);
        event.consume(); 
    }
    
    public static void DragControl (And source, Pane target, DragEvent event){
        if (event.getEventType()==DRAG_OVER && 
                event.getGestureSource() != target && 
                event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.MOVE);
            source.newPosition(event.getX(), event.getY());
        }else if(event.getEventType()==DRAG_ENTERED &&
                event.getGestureSource() != target &&
                event.getDragboard().hasString()) {
            //target.getChildren().add(source.getFigure());
        }else if(event.getEventType()==DRAG_EXITED){
            //ASD
        }else if(event.getEventType()==DRAG_DROPPED){
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                success = true;
            }
            event.setDropCompleted(success);
        }else if(event.getEventType()==DRAG_DONE){
            if (event.getTransferMode() == TransferMode.MOVE) {
                System.out.println("Drag Done");
            }
        }
        event.consume();
        
    }
}