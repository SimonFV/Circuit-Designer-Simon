
package circuit.designer.simon;


public class Conector extends Gate {
    private String state;
    
    public Conector(double x, double y){
        super(x, y);
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
}
