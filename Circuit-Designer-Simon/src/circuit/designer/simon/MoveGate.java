
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

public class MoveGate{
    private static double newX, newY, xFirst, yFirst;
    private static String state = "normal"; //Permite relizar solo ciertas acciones a la vez
    private static boolean Bstate;
    private static boolean conecting;
    private static Gate tempPoint;
    
    
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
                    }
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
    }
    
    public static void PointControl(MouseEvent event, Gate source, CircuitList circuit){
        if(state.equals("normal")){
            if(conecting){
                if(tempPoint.parent!=source.parent){
                    if(("fOpen".equals(tempPoint.state)||"Start".equals(tempPoint.state))&&
                            ("bOpen".equals(source.state)||"End".equals(source.state))){
                        source.setrFrom(tempPoint);
                        circuit.makeConections();
                        System.out.println("Conecting Done");
                        conecting=false;
                        tempPoint.unSelected();
                        circuit.unSelectAll();
                    }else if(("bOpen".equals(tempPoint.state)||"End".equals(tempPoint.state))&&
                            ("fOpen".equals(source.state)||"Start".equals(source.state))){
                        tempPoint.setrFrom(source);
                        circuit.makeConections();
                        System.out.println("Conecting Done");
                        conecting=false;
                        tempPoint.unSelected();
                        circuit.unSelectAll();
                    }else if("Closed".equals(tempPoint.state)){
                        conecting=false;
                        System.out.println("Conecting Done");
                        tempPoint.unSelected();
                        circuit.unSelectAll();
                    }
                }
            }else{
                tempPoint=source;
                if(tempPoint.parent!=tempPoint){
                    tempPoint.nowSelected();
                }
                
                System.out.println("Conecting Now");
                conecting=true;
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
        }else if("STARTPOINT".equals(state)){
            circuit.addLast("STARTPOINT", adjust(newX), adjust(newY));
        }else if("ENDPOINT".equals(state)){
            circuit.addLast("ENDPOINT", adjust(newX), adjust(newY));
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
    
    public static void notConecting(){
        if(tempPoint!=null){
            System.out.println("Conecting Canceled");
            conecting=false;
            tempPoint.unSelected();
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