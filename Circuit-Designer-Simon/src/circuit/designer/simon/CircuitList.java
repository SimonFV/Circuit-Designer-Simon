
package circuit.designer.simon;

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
                this.last = new And(target, x,y);
            }else if("POINT".equals(type)){
                this.last = new Point(target, x,y);
            }
        //Si la lista contine algo
        }else{
            if("AND".equals(type)){
                Gate n = new And(target, x,y);
                this.last.next = n;
                n.prev = this.last;
                this.last = n;
            }else if("POINT".equals(type)){
                Gate n = new Point(target, x,y);
                this.last.next = n;
                n.prev = this.last;
                this.last = n;
            }
        }
        
        //Crea y agrega la figura al panel
        this.last.constructFigure();
        target.getChildren().add(this.last.getFigure());
        this.last.code = size+1;
        this.size += 1;
        
    }
    
    public int getSize(){
        return size;
    }
    
    public int getCode(int posicion){
        int D;
        if(posicion>=this.size){
            return -1;
        }else{
            Gate temp = this.last;
            for(int i=1; i<=posicion; i++){
                temp=temp.next;
            }
            D=temp.code;
            return D;
        }
    }

    public Gate getLast() {
        return last;
    }
    
    
}
