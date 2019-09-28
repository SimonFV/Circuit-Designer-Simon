
package circuit.designer.simon;


import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_DRAGGED;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import static javafx.scene.input.MouseEvent.MOUSE_EXITED;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;
import javafx.scene.layout.Pane;

/**
* Clase que gestiona los eventos del mouse del usuario.
* @author: Simon Fallas V.
*/
public class MoveGate{
    private static double newX, newY, xFirst, yFirst;
    private static String state = "normal"; //Permite relizar solo ciertas acciones a la vez
    private static boolean Bstate;
    private static boolean conecting;
    private static Gate tempPoint;
    
    /**
    * Método estático que maneja los eventos de arrastre y selección de las compuertas.
    * @param event Evento del mouse
    * @param source Compuerta sobre la que ocurre el evento.
    * @param circuit Lista principal del diagrama.
    */
    public static void MouseControl(MouseEvent event, Gate source, CircuitList circuit){
        if("normal".equals(state)){
            if(event.getButton()==MouseButton.PRIMARY){
                if(event.getEventType()==MOUSE_PRESSED){
                    xFirst = event.getSceneX();
                    yFirst = event.getSceneY();
                }else if(event.getEventType()==MOUSE_RELEASED){
                    newX = event.getSceneX();
                    newY = event.getSceneY();
                    if(source.selected==false && xFirst==newX && yFirst==newY){   
                        source.nowSelected();
                    }else if(source.selected==true && xFirst==newX && yFirst==newY){
                        source.unSelected();
                        if(tempPoint!=null){
                            conecting=false;
                            tempPoint.unSelected();
                        }  
                    }else if(source.selected==false){
                        source.nowSelected();
                    }
                }else if(event.getEventType()==MOUSE_DRAGGED){
                    newX = event.getSceneX();
                    newY = event.getSceneY();
                    //Mantenerse dentro del panel
                    if(newX < 980 || newX > 120 || newY > 0 || newY < 680) {
                        source.moveFigure(adjust(newX), adjust(newY));
                        circuit.refresh();
                    }
                }else if(event.getEventType()==MOUSE_ENTERED){
                        //Brillar
                        //source.getFigure().setCursor(Cursor.HAND);
                }else if(event.getEventType()==MOUSE_EXITED){
                        //Normal
                        //source.getFigure().setCursor(Cursor.HAND);
                }
            }
        }
    }
    
    /**
    * Método estático que maneja los eventos de conexión entre los puntos.
    * @param event Evento del mouse
    * @param source Compuerta sobre la que ocurre el evento.
    * @param circuit Lista principal del diagrama.
    */
    public static void PointControl(MouseEvent event, Gate source, CircuitList circuit){
        if(state.equals("normal")){
            if(conecting){
                if(tempPoint.parent!=source.parent){
                    if(("fOpen".equals(tempPoint.state)||"Start".equals(tempPoint.state))&&
                            ("bOpen".equals(source.state)||"End".equals(source.state))){
                        source.setrFrom(tempPoint);
                        circuit.makeConections();
                        conecting=false;
                        tempPoint.unSelected();
                        circuit.unSelectAll();
                    }else if(("bOpen".equals(tempPoint.state)||"End".equals(tempPoint.state))&&
                            ("fOpen".equals(source.state)||"Start".equals(source.state))){
                        tempPoint.setrFrom(source);
                        circuit.makeConections();
                        conecting=false;
                        tempPoint.unSelected();
                        circuit.unSelectAll();
                    }else if("Closed".equals(tempPoint.state)){
                        conecting=false;
                        tempPoint.unSelected();
                        circuit.unSelectAll();
                    }
                }
            }else{
                tempPoint=source;
                if(tempPoint.parent!=tempPoint){
                    tempPoint.nowSelected();
                }
                conecting=true;
            }
        }
    }
    
    /**
    * Método estático que maneja los eventos de creación de compuertas en el panel de ensamble.
    * @param circuit Lista principal del diagrama.
    * @param target Panel donde ocurre el evento.
    * @param mainScene Escena principal del programa.
    * @param e Evento del mouse.
    */
    public static void PaneControl(CircuitList circuit, Pane target, Scene mainScene, MouseEvent e){
        newX = e.getSceneX();
        newY = e.getSceneY();
        if("AND".equals(state)){
            circuit.addLast("AND", adjust(newX), adjust(newY));
        }else if("POINT".equals(state)){
            circuit.addLast("POINT", adjust(newX), adjust(newY));
        }else if("STARTPOINT".equals(state)){
            circuit.addLast("STARTPOINT", adjust(newX), adjust(newY));
        }else if("ENDPOINT".equals(state)){
            circuit.addLast("ENDPOINT", adjust(newX), adjust(newY));
        }else if("NOT".equals(state)){
            circuit.addLast("NOT", adjust(newX), adjust(newY));
        }else if("OR".equals(state)){
            circuit.addLast("OR", adjust(newX), adjust(newY));
        }else if("NAND".equals(state)){
            circuit.addLast("NAND", adjust(newX), adjust(newY));
        }else if("NOR".equals(state)){
            circuit.addLast("NOR", adjust(newX), adjust(newY));
        }else if("XOR".equals(state)){
            circuit.addLast("XOR", adjust(newX), adjust(newY));
        }else if("XNOR".equals(state)){
            circuit.addLast("XNOR", adjust(newX), adjust(newY));
        }
    }
    
    /**
    * Método estático que maneja los eventos de modificación del tipo de compuerta que
    * se debe añadir según el botón seleccionado por el usuario.
    * @param b Botón donde ocurre el evento.
    * @param e Evento del mouse.
    * @param s Tipo de la compuerta a crear.
    */
    public static void ButtonControl(ToggleButton b, MouseEvent e, String s){
        if(Bstate){
            b.setSelected(false);
            Bstate=false;
            state="normal";
        }else{
            b.setSelected(true);
            state=s;
            Bstate=true;
        }
    }
    
    /**
    * Método estático que establece el estado de conexión entre puntos como falso.
    */
    public static void notConecting(){
        if(tempPoint!=null){
            conecting=false;
            tempPoint.unSelected();
        }  
    }
    
    /**
    * Método estático que ajusta el valor de posición de las compuertas para simular
    * un movimiento cuadriculado.
    * @param x Valor a ajustar
    * @return x double
    */
    public static double adjust(double x){
        double rX = x%10;
        if(rX<5){
            x=x-rX;
        }else{
            x=x-rX+10;
        }
        return x;
    }
    
}