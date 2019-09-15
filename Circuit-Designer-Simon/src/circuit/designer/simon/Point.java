
package circuit.designer.simon;

public class Point{
    
    private String state                                                        ;
    Gate prev;
    
    
    public Point() {
        
    }
    
    public void setState(String state){
        this.state = state;
    }
    public String getState() {
        return state;
    }
    
}
