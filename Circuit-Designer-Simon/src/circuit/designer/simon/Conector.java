
package circuit.designer.simon;

import javafx.scene.layout.Pane;


public class Conector extends Gate {
    private String state;
    
    public Conector(Pane target, double x, double y){
        super(target, x, y);
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
}
