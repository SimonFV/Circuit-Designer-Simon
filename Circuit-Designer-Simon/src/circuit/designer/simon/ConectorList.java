
package circuit.designer.simon;


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
            this.last.setColors();
            target.getChildren().add(this.last.getFigure());
            this.last.getFigure().toBack();
            
        }else {
            Conector n = new Conector(from, to, target);
            this.last.next = n;
            this.last.next.prev = this.last;
            this.last = n;
            this.last.setFigure();
            this.last.setColors();
            target.getChildren().add(this.last.getFigure());
            this.last.getFigure().toBack();
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
    
    public void update(){
        if(this.last!=null){
            Conector temp = this.last;
            while(true){
                if(temp.prev == null){
                    temp.setFigure();
                    break;
                }else{
                    temp.setFigure();
                    temp = temp.prev;
                }
            }
        }
    }
}
