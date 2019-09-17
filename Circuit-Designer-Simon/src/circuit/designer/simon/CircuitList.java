
package circuit.designer.simon;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CircuitList{
    private Gate last;
    private int size;
    private Pane target;
    
    public CircuitList(Pane target){
        this.target = target;
        
        this.last = null;
        this.size = 0;
    }
    
    public void addLast(String type, double x, double y){
        //Si la lista esta vacia
        if(this.last == null){
            if("AND".equals(type)){
                System.out.println("Primer And");
                this.last = new And(target, x,y);
            }
        //Si la lista ya contine algo
        }else{
            if("AND".equals(type)){
                System.out.println("And añadido");
                Gate n = new And(target, x,y);
                this.last.next = n;
                n.prev = this.last;
                this.last = n;
            }
        }
        if("NOT".equals(type)){
            //NOT
        }else{
            this.last.InTop.prev = this.last;
            this.last.InBot.prev = this.last;
            this.last.Out.prev = this.last;
        }
        
        
        //this.last.getFigure().setOnMousePressed(e->MoveGate.MouseControl(e,this.last));
        //this.last.getFigure().setOnMouseReleased(e->MoveGate.MouseControl(e,this.last));
        //this.last.getFigure().setOnMouseDragged(e->MoveGate.MouseControl(e,this.last));
        //this.last.getFigure().setOnMouseEntered(e->MoveGate.MouseControl(e,this.last));
        
        //target.setOnDragOver(e->MoveGate.DragControl(e,this.last,target));
        //target.setOnDragEntered(e->MoveGate.DragControl(e,this.last,target));
        //target.setOnDragExited(e->MoveGate.DragControl(e,this.last,target));
        //target.setOnDragDropped(e->MoveGate.DragControl(e,this.last,target));
        
        target.getChildren().add(this.last.getFigure());
        this.last.ID = size+1;
        this.size += 1;
        
        //EVENTOS DE ARRASTRE DE COMPUERTAS
        
    }
    
    public int getSize(){
        return size;
    }
    
    public int getID(int posicion){
        int D;
        if(posicion>=this.size){
            return -1;
        }else{
            Gate temp = this.last;
            for(int i=1; i<=posicion; i++){
                temp=temp.next;
            }
            D=temp.ID;
            return D;
        }
    }

    public Gate getLast() {
        return last;
    }
    
    
}
