
package circuit.designer.simon;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
            }else if("STARTPOINT".equals(type)){
                this.last = new StartPoint(target, x,y, this);
            }else if("ENDPOINT".equals(type)){
                this.last = new EndPoint(target, x,y, this);
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
            }else if("STARTPOINT".equals(type)){
                Gate n = new StartPoint(target, x,y, this);
                this.last.next = n;
                this.last.next.prev = this.last;
                this.last = n;
            }else if("ENDPOINT".equals(type)){
                Gate n = new EndPoint(target, x,y, this);
                this.last.next = n;
                this.last.next.prev = this.last;
                this.last = n;
            }
        }
        
        //Crea y agrega la figura al panel
        this.last.constructFigure();
        target.getChildren().add(this.last.getFigure());
        if("NOT".equals(type)){
            
        }else if("POINT".equals(type)||"STARTPOINT".equals(type)||"ENDPOINT".equals(type)){
            
        }else{
            target.getChildren().addAll(this.last.Out.getFigure(),
                    this.last.InTop.getFigure(),this.last.InBot.getFigure());
        }
        
        setInsOuts();
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
        if(this.last!=null){
            Gate temp = this.last;
            while(true){
                if(temp.prev == null){
                    if("POINT".equals(temp.ID)){
                        //POINT
                    }else if("NOT".equals(temp.ID)){
                        //NOT
                    }else if("STARTPOINT".equals(temp.ID)){
                        //NOT
                    }else if("ENDPOINT".equals(temp.ID)){
                        if(temp.rFrom!=null){
                            if(!"Closed".equals(temp.rFrom.state)){
                                cList.addLast(temp,temp.rFrom);
                            }else{
                                temp.rFrom=null;
                            }
                        }
                    }else{
                        if(temp.InTop.rFrom!=null){
                            if(!"Closed".equals(temp.InTop.rFrom.state)){
                                cList.addLast(temp.InTop,temp.InTop.rFrom);
                            }else{
                                temp.InTop.rFrom=null;
                            }
                        }
                        if(temp.InBot.rFrom!=null){
                            if(!"Closed".equals(temp.InBot.rFrom.state)){
                                cList.addLast(temp.InBot,temp.InBot.rFrom);
                            }else{
                                temp.InBot.rFrom=null;
                            }
                        }
                    }
                    break;
                }else{
                    if("POINT".equals(temp.ID)){
                        //POINT
                    }else if("NOT".equals(temp.ID)){
                        //NOT
                    }else if("STARTPOINT".equals(temp.ID)){
                        //NOT
                    }else if("ENDPOINT".equals(temp.ID)){
                        if(temp.rFrom!=null){
                            if(!"Closed".equals(temp.rFrom.state)){
                                cList.addLast(temp,temp.rFrom);
                            }else{
                                temp.rFrom=null;
                            }
                        }
                    }else{
                        if(temp.InTop.rFrom!=null){
                            if(!"Closed".equals(temp.InTop.rFrom.state)){
                                cList.addLast(temp.InTop,temp.InTop.rFrom);
                            }else{
                                temp.InTop.rFrom=null;
                            }
                        }
                        if(temp.InBot.rFrom!=null){
                            if(!"Closed".equals(temp.InBot.rFrom.state)){
                                cList.addLast(temp.InBot,temp.InBot.rFrom);
                            }else{
                                temp.InBot.rFrom=null;
                            }
                        }
                    }
                    temp = temp.prev;
                }
            }
        }
    }
    
    public void refresh(){
        cList.update();
    }
    
    public void delete(){
        System.out.println("deleting");
        if(this.last!=null){
            Gate temp = this.last;
            while(true){
                if(temp.prev==null){
                    if(temp.selected){
                        if(temp.next==null){
                            target.getChildren().remove(temp.getFigure());
                            temp.state="Closed";
                            if("NOT".equals(temp.ID)){
                                //NOT
                            }else if("POINT".equals(temp.ID)){
                                //point
                            }else if("STARTPOINT".equals(temp.ID)){
                                temp.state="Closed";
                            }else if("ENDPOINT".equals(temp.ID)){
                                
                            }else{
                                temp.Out.state="Closed";
                                temp.InBot.state="Closed";
                                temp.InTop.state="Closed";
                                target.getChildren().remove(temp.Out.getFigure());
                                target.getChildren().remove(temp.InTop.getFigure());
                                target.getChildren().remove(temp.InBot.getFigure());
                            }
                            this.last=null;
                            temp=null;
                        }else{
                            target.getChildren().remove(temp.getFigure());
                            temp.state="Closed";
                            if("NOT".equals(temp.ID)){
                                //NOT
                            }else if("POINT".equals(temp.ID)){
                                //point
                            }else if("STARTPOINT".equals(temp.ID)){
                                temp.state="Closed";
                            }else if("ENDPOINT".equals(temp.ID)){
                                
                            }else{
                                temp.Out.state="Closed";
                                temp.InBot.state="Closed";
                                temp.InTop.state="Closed";
                                target.getChildren().remove(temp.Out.getFigure());
                                target.getChildren().remove(temp.InTop.getFigure());
                                target.getChildren().remove(temp.InBot.getFigure());
                            }
                            temp.next.prev=null;
                            temp.next=null;
                            temp=null;
                        }
                    }
                    System.out.println("done");
                    break;
                }else{
                    if(temp.selected){
                        if(temp.next==null){
                            target.getChildren().remove(temp.getFigure());
                            temp.state="Closed";
                            if("NOT".equals(temp.ID)){
                                //NOT
                            }else if("POINT".equals(temp.ID)){
                                //point
                            }else if("STARTPOINT".equals(temp.ID)){
                                temp.state="Closed";
                            }else if("ENDPOINT".equals(temp.ID)){
                                
                            }else{
                                temp.Out.state="Closed";
                                temp.InBot.state="Closed";
                                temp.InTop.state="Closed";
                                target.getChildren().remove(temp.Out.getFigure());
                                target.getChildren().remove(temp.InTop.getFigure());
                                target.getChildren().remove(temp.InBot.getFigure());
                            }
                            this.last.prev.next=null;
                            this.last=this.last.prev;
                        }else{
                            target.getChildren().remove(temp.getFigure());
                            temp.state="Closed";
                            if("NOT".equals(temp.ID)){
                                //NOT
                            }else if("POINT".equals(temp.ID)){
                                //point
                            }else if("STARTPOINT".equals(temp.ID)){
                                temp.state="Closed";
                            }else if("ENDPOINT".equals(temp.ID)){
                                
                            }else{
                                temp.Out.state="Closed";
                                temp.InBot.state="Closed";
                                temp.InTop.state="Closed";
                                target.getChildren().remove(temp.Out.getFigure());
                                target.getChildren().remove(temp.InTop.getFigure());
                                target.getChildren().remove(temp.InBot.getFigure());
                            }
                            temp.next.prev=temp.prev;
                            temp.prev.next=temp.next;
                        }
                    }
                    temp=temp.prev;
                }
            }
            MoveGate.notConecting();
            makeConections();
            setInsOuts();
        }
    }
    
    public void unSelectAll(){
        if(this.last!=null){
            Gate temp = this.last;
            while(true){
                if(temp.prev == null){
                    temp.unSelected();
                    break;
                }else{
                    temp.unSelected();
                    temp = temp.prev;
                }
            }
        }
    }
    
    public void showResults(){
        if(this.last!=null){
            Gate temp = this.last;
            while(true){
                if(temp.prev == null){
                    if("ENDPOINT".equals(temp.ID)){
                        System.out.println(temp.getResult());
                        temp.setResult(1);
                    }
                    break;
                }else{
                    if("ENDPOINT".equals(temp.ID)){
                        System.out.println(temp.getResult());
                        temp.setResult(1);
                    }
                    temp = temp.prev;
                }
            }
        }
    }
    
    public void setInsOuts(){
        int i = 0;
        int j = 0;
        if(this.last!=null){
            Gate temp = this.last;
            while(true){
                if(temp.prev == null){
                    if("ENDPOINT".equals(temp.ID)){
                        temp.setName("O<"+Integer.toString(j)+">");
                        j++;
                    }else if("STARTPOINT".equals(temp.ID)){
                        temp.setName("I<"+Integer.toString(i)+">");
                        i++;
                    }
                    break;
                }else{
                    if("ENDPOINT".equals(temp.ID)){
                        temp.setName("O<"+Integer.toString(j)+">");
                        j++;
                    }else if("STARTPOINT".equals(temp.ID)){
                        temp.setName("I<"+Integer.toString(i)+">");
                        i++;
                    }
                    temp = temp.prev;
                }
            }
        }
    }
    
    public void generateTable(GridPane table){
        int i = 0;
        int e = 0;
        TableList tablelist = new TableList();
        if(this.last!=null){
            Gate temp = this.last;
            while(true){
                if(temp.prev == null){
                    if("STARTPOINT".equals(temp.ID)){
                        Label stLabel = new Label(temp.getName());
                        GridPane.setConstraints(stLabel,i,0);
                        tablelist.addColumnIn(temp);
                        table.getChildren().add(stLabel);
                        i++;
                    }
                    break;
                }else{
                    if("STARTPOINT".equals(temp.ID)){
                        Label stLabel = new Label(temp.getName());
                        GridPane.setConstraints(stLabel,i,0);
                        tablelist.addColumnIn(temp);
                        table.getChildren().add(stLabel);
                        i++;
                    }
                    temp = temp.prev;
                }
            }
            if(i!=0){
                tablelist.addInRows();
            }
            
            temp = this.last;
            while(true){
                if(temp.prev == null){
                    if("ENDPOINT".equals(temp.ID)){
                        Label endLabel = new Label(temp.getName());
                        GridPane.setConstraints(endLabel,i+e,0);
                        tablelist.addColumnOut(temp);
                        table.getChildren().add(endLabel);
                        e++;
                    }
                    break;
                }else{
                    if("ENDPOINT".equals(temp.ID)){
                        Label endLabel = new Label(temp.getName());
                        GridPane.setConstraints(endLabel,i+e,0);
                        tablelist.addColumnOut(temp);
                        table.getChildren().add(endLabel);
                        e++;
                    }
                    temp = temp.prev;
                }
            }
            if(e!=0){
                tablelist.addOutRows();
            }
            testingNow();
            tablelist.setLastRows(table);
            testingDone();
        }
    }
    
    public void testingNow(){
        if(this.last!=null){
            Gate temp = this.last;
            while(true){
                if(temp.prev == null){
                    if("STARTPOINT".equals(temp.ID)){
                        temp.setTesting(true);
                    }
                    break;
                }else{
                    if("STARTPOINT".equals(temp.ID)){
                        temp.setTesting(true);
                    }
                    temp = temp.prev;
                }
            }
        }
    }
    public void testingDone(){
        if(this.last!=null){
            Gate temp = this.last;
            while(true){
                if(temp.prev == null){
                    if("STARTPOINT".equals(temp.ID)){
                        temp.setTesting(false);
                    }
                    break;
                }else{
                    if("STARTPOINT".equals(temp.ID)){
                        temp.setTesting(false);
                    }
                    temp = temp.prev;
                }
            }
        }
    }
}
