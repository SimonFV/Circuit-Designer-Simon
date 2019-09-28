
package circuit.designer.simon;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
* Clase tipo nodo que contiene los atributos y métodos de las columnas de la tabla de resultados.
* @author: Simon Fallas V.
*/
public class TableBox {
    protected TableBox bot, prev, next;
    protected Gate Title;
    protected int value;
    protected String ID;
    
    /**
    * Método cosntructor de la columna con el título como cabecera.
    * @param Title Compuerta titulo de la columna.
    */
    public TableBox(Gate Title){
        this.bot = null;
        this.prev = null;
        this.next = null;
        this.value = 0;
        this.Title = Title;
        this.ID = "none";
    }
    
    /**
    * Método que retorna el valor de la casilla actual.
    * @return value int
    */
    public int getValue() {
        return value;
    }
    
    /**
    * Método que establece el valor de la casilla actual.
    * @param value Valor nuevo.
    */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
    * Método que establece los valores de las entradas de la lista con el valor especificado,
    * para que puedan ser generados los valores posibles de las salidas. También, agrega el
    * label al panel para ser mostrado.
    * @param j Posición en la columna
    * @param i Posición en la fila
    * @param table Panel de la tabla.
    */
    public void setInRow(int j, int i, GridPane table){
        int i2 = i;
        TableBox temp = this.bot;
        while(i2>0){
            temp = temp.bot;
            i2--;
        }
        temp.Title.setResult(temp.value);
        Label row = new Label(Integer.toString(temp.value));
        GridPane.setConstraints(row, j, i+2);
        table.getChildren().add(row);
    }
    
    /**
    * Método que establece los valores de las salidas de la lista según el establecido en 
    * las entradas. También, agrega el label al panel para ser mostrado.
    * @param j Posición en la columna
    * @param i Posición en la fila
    * @param table Panel de la tabla.
    */
    public void setOutRow(int j, int i, GridPane table){
        int i2 = i;
        TableBox temp = this.bot;
        while(i2>0){
            temp = temp.bot;
            i2--;
        }
        temp.value=temp.Title.getResult();
        Label row = new Label(Integer.toString(temp.value));
        GridPane.setConstraints(row, j, i+2);
        table.getChildren().add(row);
    }
    
}
