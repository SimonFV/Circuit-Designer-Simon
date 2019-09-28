
package circuit.designer.simon;


import javafx.scene.layout.Pane;

/**
* Clase tipo lista simple enlazada. Agrupa los nodos tipo conexión, que enlazan las
* compuertas gráficamente.
* @author: Simon Fallas V.
*/
public class ConectorList {
    private Conector last;
    private Pane target;
    
    /**
    * Método constructor de la lista, recibe el panel donde se realizarás las conexiones gráficamente.
    * @param target Panel donde se ensamblan las conexiones.
    */
    public ConectorList(Pane target){
        this.target = target;
        this.last = null;
    }
    
    /**
    * Método que añade un nodo nuevo a la lista, tomando como puntos de conexión las compuertas
    * recibidas.
    * @param from Compuerta que espera una conexión a otra.
    * @param to Compuerta a la que se le realiza la conexión.
    */
    public void addLast(Gate from, Gate to){
        if(this.last == null){
            this.last = new Conector(from, to, target);
            this.last.setFigure();
            this.last.setColors();
            target.getChildren().add(this.last.getFigure());
            this.last.getFigure().toBack();
            
        }else {
            Conector n = new Conector(from, to, target);
            this.last.next = n;
            this.last.next.prev = this.last;
            this.last = n;
            this.last.setFigure();
            this.last.setColors();
            target.getChildren().add(this.last.getFigure());
            this.last.getFigure().toBack();
        }
        
    }
    
    /**
    * Método que elimina todas las conexiones de la lista.
    */
    public void resetConectors(){
        if(this.last!=null){
            Conector temp = this.last;
            while(true){
                if(temp.prev == null){
                    target.getChildren().remove(temp.getFigure());
                    break;
                }else{
                    target.getChildren().remove(temp.getFigure());
                    temp = temp.prev;
                }
            }

            this.last.prev = null;
            this.last = null;
        }
    }
    
    /**
    * Método que actualiza las pososiciones de las conexiones luego de que una compuerta
    * se haya movido.
    */
    public void update(){
        if(this.last!=null){
            Conector temp = this.last;
            while(true){
                if(temp.prev == null){
                    temp.setFigure();
                    break;
                }else{
                    temp.setFigure();
                    temp = temp.prev;
                }
            }
        }
    }
}
