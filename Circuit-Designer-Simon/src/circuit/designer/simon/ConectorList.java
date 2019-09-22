
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class ConectorList {
    private Conector last;
    private Pane target;
    
    public ConectorList(Pane target){
        this.target = target;
        this.last = null;
    }
    
    public void addLast(Gate from, Gate to){
        if(this.last == null){
            this.last = new Conector(from, to, target);
            this.last.setFigure();
            target.getChildren().add(this.last.getFigure());
        //Si la lista contine algo
        }else {
            Conector n = new Conector(from, to, target);
            this.last.next = n;
            this.last.next.prev = this.last;
            this.last = n;
            this.last.setFigure();
            target.getChildren().add(this.last.getFigure());
        }
        
    }
    
    public void resetConectors(){
        if(this.last!=null){
            Conector temp = this.last;
            while(true){
                if(temp.prev == null){
                    target.getChildren().remove(temp.getFigure());
                    break;
                }else{
                    target.getChildren().remove(temp.getFigure());
                    temp = temp.prev;
                }
            }

            this.last.prev = null;
            this.last = null;
        }
    }
}
