
package circuit.designer.simon;

import javafx.scene.layout.Pane;

public class CircuitList{
    private Gate last;
    private int size;
    private Pane target;
    private ConectorList cList;
    
    public CircuitList(Pane target){
        cList = new ConectorList(target);
        this.target = target;
        this.last = null;
        this.size = 0;
    }
    
    public void addLast(String type, double x, double y){
        //Si la lista esta vacia
        if(this.last == null){
            if("AND".equals(type)){
                this.last = new And(target, x,y, this);
            }else if("POINT".equals(type)){
                this.last = new Point(target, x,y, this);
            }
        //Si la lista contine algo
        }else{
            if("AND".equals(type)){
                Gate n = new And(target, x,y, this);
                this.last.next = n;
                this.last.next.prev = this.last;
                this.last = n;
            }else if("POINT".equals(type)){
                Gate n = new Point(target, x,y, this);
                this.last.next = n;
                this.last.next.prev = this.last;
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
    
    public void makeConections(){
        cList.resetConectors();
        Gate temp = this.last;
        while(true){
            if(temp.prev == null){
                if("POINT".equals(temp.ID)){
                    //POINT
                }else if("NOT".equals(temp.ID)){
                    //NOT
                }else{
                    if(temp.Out.rFrom!=null){
                        cList.addLast(temp.Out,temp.Out.rFrom);
                    }
                    if(temp.InTop.rFrom!=null){
                        cList.addLast(temp.InTop,temp.InTop.rFrom);
                    }
                    if(temp.InBot.rFrom!=null){
                        cList.addLast(temp.InBot,temp.InBot.rFrom);
                    }
                }
                break;
            }else{
                if("POINT".equals(temp.ID)){
                    //POINT
                }else if("NOT".equals(temp.ID)){
                    //NOT
                }else{
                    if(temp.Out.rFrom!=null){
                        cList.addLast(temp.Out,temp.Out.rFrom);
                    }
                    if(temp.InTop.rFrom!=null){
                        cList.addLast(temp.InTop,temp.InTop.rFrom);
                    }
                    if(temp.InBot.rFrom!=null){
                        cList.addLast(temp.InBot,temp.InBot.rFrom);
                    }
                }
                temp = temp.prev;
            }
        }
    }
    
    public void refresh(){
        cList.update();
    }
    
}
