
package circuit.designer.simon;

public class CircuitList{
    private And first;
    private And last;
    private int size;
    
    public CircuitList(){
        this.first = null;
        this.size = 0;
    }
    
    public void addFirst(int x, int y){
        if(this.first == null){
            this.first = new And(x,y);
        }else{
            And n = new And(x,y);
            this.first = n;
        }
        this.size += 1;
    }
    
    public void addLast(int x, int y){
        if(this.last==null){
            this.last = new And(x,y);
        }else{
            And m = new And(x,y);
            this.last.next = null;
            this.last = m;
        }
        this.size += 1;
    }
    
    public int getSize(){
        return size;
    }
    
    public String getDato(int posicion){
        String D;
        if(posicion>=this.size){
            return "-1";
        }else{
            And temp = this.first;
            for(int i=1; i<=posicion; i++){
                temp=temp.next;
            }
            D=temp.ID;
            return D;
        }
    }
}
