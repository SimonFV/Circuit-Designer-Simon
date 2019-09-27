
package circuit.designer.simon;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class TableBox {
    protected TableBox bot, prev, next;
    protected Gate Title;
    protected int value;
    protected String ID;
    
    public TableBox(Gate Title){
        this.bot = null;
        this.prev = null;
        this.next = null;
        this.value = 0;
        this.Title = Title;
        this.ID = "none";
    }
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    
    public void setInRow(int j, int i, GridPane table){
        int i2 = i;
        TableBox temp = this.bot;
        while(i2>0){
            temp = temp.bot;
            i2--;
        }
        temp.Title.setResult(temp.value);
        Label row = new Label(Integer.toString(temp.value));
        GridPane.setConstraints(row, j, i+1);
        table.getChildren().add(row);
    }
    
    public void setOutRow(int j, int i, GridPane table){
        int i2 = i;
        TableBox temp = this.bot;
        while(i2>0){
            temp = temp.bot;
            i2--;
        }
        temp.value=temp.Title.getResult();
        Label row = new Label(Integer.toString(temp.value));
        GridPane.setConstraints(row, j, i+1);
        table.getChildren().add(row);
    }
    
}
