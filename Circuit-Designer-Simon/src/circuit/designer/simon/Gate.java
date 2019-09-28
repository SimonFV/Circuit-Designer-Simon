
package circuit.designer.simon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

/**
 * Clase abstracta que contiene los atributos y métodos de las compuertas. Además funciona
 * como nodo de la lista que representa el diagrama lógico.
 * @author: Simon Fallas V.
 */
abstract class Gate {
    
    protected double xStart, yStart;
    protected Group g, gselected;
    protected Pane target;
    protected Gate next, prev, InTop, InBot, Out, rFrom, parent;
    protected String ID, state; //Estados: Active, bOpen, fOpen, Start, End, Closed
    protected int code,result;
    protected boolean selected;
    protected CircuitList circuit;
    
    /**
    * Método constructor de la clase compuerta. Establece todos los valores generales
    * de las compuertas por defecto.
    * @param target Panel donde se ensambla el circuito.
    * @param x Posición inicial x de la compuerta;
    * @param y Posición inicial y de la compuerta;
    * @param circuit Referencia a la propia lista donde se añade esta compuerta;
    */
    public Gate(Pane target, double x, double y, CircuitList circuit){
        this.circuit = circuit;
        this.target = target;
        this.xStart = x;
        this.yStart = y;
        this.result = 0;
        
        this.g = new Group();
        this.gselected = new Group();
        
        this.ID = "GATE";
        this.next = null;
        this.prev = null;
        this.rFrom = null;
        this.InTop = null;
        this.InBot = null;
        this.Out = null;
        this.parent = this;
        
        this.selected = false;
        this.state = "Active";
    }
    
    /**
    * Método que retorna la posición en x de la compuerta actual.
    * @return xStart double
    */
    public double getxStart() {
        return this.xStart;
    }
    
    /**
    * Método que reestablece el valor actual de la posición x de la compuerta actual.
    * @param xStart Nueva posición en x.
    */
    public void setxStart(double xStart) {
        this.xStart = xStart;
    }
    
    /**
    * Método que retorna la posición en y de la compuerta actual.
    * @return yStart double
    */
    public double getyStart() {
        return this.yStart;
    }
    
    /**
    * Método que reestablece el valor actual de la posición y de la compuerta actual.
    * @param yStart Nueva posición en y.
    */
    public void setyStart(double yStart) {
        this.yStart = yStart;
    }
    
    /**
    * Método que retorna la ID, es decir, el tipo de compuerta que es.
    * @return ID String
    */
    public String getID() {
        return this.ID;
    }
    
    /**
    * Método que construye la figura, y sus eventos asociados, de la compuerta 
    * teniendo en cuenta el tipo que es.
    */
    public void constructFigure(){}
    
    /**
    * Método que resetea la posición de la figura en base a los valores recibidos.
    * @param x Nueva posición de la figura en x;
    * @param y Nueva posición de la figura en y;
    */
    public void moveFigure(double x, double y){}
    
    /**
    * Método que retorna la figura de la actual compuerta.
    * @return g Group
    */
    public Group getFigure(){
        return this.g;
    }
    
    /**
    * Método que retorna el valor de salida de la compuerta actual en base a sus
    * valores de entrada.
    * @return result int
    */
    public int getResult(){
        return this.result;
    }
    
    /**
    * Método que reestablece el valor de salida de la compuerta al ingresado como parámetro.
    * @param result Nuevo valor de salida.
    */
    public void setResult(int result){}
    
    /**
    * Método que establece el nodo al que se encuentra conectado el actual.
    * @param rFrom Nuevo nodo de referencia.
    */
    public void setrFrom(Gate rFrom){
        this.rFrom=rFrom;
    }
    
    /**
    * Método que retorna la compuerta a la que se encuentra conectado actualmente
    * esta compuerta.
    * @return rFrom Gate
    */
    public Gate getrFrom(){
        return this.rFrom;
    }
    
    /**
    * Método que establece el estado de esta compuerta como seleccionado.
    */
    public void nowSelected(){
        this.selected = true;
        this.g.getChildren().add(this.gselected);
    }
    
    /**
    * Método que establece el estado de esta compuerta como no seleccionado.
    */
    public void unSelected(){
        this.selected = false;
        this.g.getChildren().remove(this.gselected);
    }
    
    /**
    * Método que establece el nombre de la compuerta actual.
    * @param name Nuevo nombre.
    */
    public void setName(String name){}
    
    /**
    * Método que retorna el nombre de la compuerta actual. Para el caso de las 
    * entradas y salidas.
    * @return result int
    */
    public String getName(){
        return "name";
    }
    
    /**
    * Método que establece el modo de testeo en verdadero o falso en las compuertas tipo entrada para
    * que tomen o ignoren el valor ingresado desde la interfaz.
    * @param testing Estado del modo de testeo.
    */
    public void setTesting(boolean testing){}
}
    
