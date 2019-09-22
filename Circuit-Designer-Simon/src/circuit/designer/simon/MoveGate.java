
package circuit.designer.simon;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_DRAGGED;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import static javafx.scene.input.MouseEvent.MOUSE_EXITED;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;
import javafx.scene.layout.Pane;

public class MoveGate{
    private static double newX, newY;
    private static String state = "normal"; //Permite relizar solo ciertas acciones a la vez
    private static boolean Bstate;
    private static boolean conecting;
    private static Point tempPoint;
    
    
    public static void MouseControl(MouseEvent event, Gate source, CircuitList circuit){
        if("normal".equals(state)){
            if(event.getEventType()==MOUSE_PRESSED){
                //source.getFigure().setCursor(Cursor.MOVE);
            }else if(event.getEventType()==MOUSE_RELEASED) {
                //source.getFigure().setCursor(Cursor.HAND);
            }else if(event.getEventType()==MOUSE_DRAGGED){
                newX = event.getSceneX();
                newY = event.getSceneY();
                //Mantenerse dentro del panel
                if(newX < 500 || newX > 100 || newY > 0 || newY < 500) {
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
    
    public static void PointControl(MouseEvent event, Point source, CircuitList circuit){
        if(conecting){
            tempPoint.setrFrom(source);
            circuit.makeConections();
            System.out.println("Conecting Done");
            conecting=false;
        }else{
            tempPoint=source;
            System.out.println("Conecting Now");
            conecting=true;
        }
        
    }
    
    public static void GateControl(MouseEvent event, Gate source, CircuitList circuit){
        if(event.getButton()==MouseButton.PRIMARY){
            if("gateSelected".equals(state)){
                //System.out.println("Gate deactivated");
                //state = "normal";
            }else{
                //System.out.println("Gate selected");
                //state = "gateSelected";
            }
        }
        
    }
    
    public static void PaneControl(CircuitList circuit, Pane target, Scene mainScene, MouseEvent e){
        newX = e.getSceneX();
        newY = e.getSceneY();
        if("AND".equals(state)){
            circuit.addLast("AND", adjust(newX), adjust(newY));
        }else if("POINT".equals(state)){
            circuit.addLast("POINT", adjust(newX), adjust(newY));
        }
    }
    
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
    
    //Movimiento ajustado
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