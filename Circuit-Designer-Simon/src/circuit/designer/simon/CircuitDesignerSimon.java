package circuit.designer.simon;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_DRAGGED;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class CircuitDesignerSimon extends Application{
    
    Stage window;
    Scene mainScene;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        primaryStage.setTitle("Circuit Designer by Simon");
        
        //Labels de prueba
        Label tablaCompuertas = new Label("Compuertas\nlógicas");
        Label andLabel = new Label("AND");
        Label areaEnsamble = new Label("Zona de Ensamble");
        Label resultsLabel = new Label("Resultado");
        Label menu = new Label("Menu");
        
        
        
        
        //LAYOUTS
        HBox topMenu = new HBox(10);
        topMenu.getChildren().addAll(menu);
        VBox rightMenu = new VBox(10);
        rightMenu.getChildren().addAll(tablaCompuertas, andLabel);
        
        VBox leftMenu = new VBox(10);
        leftMenu.getChildren().addAll(resultsLabel);
        
        //Zona de ensamble
        Pane root = new Pane();
        CircuitList bb = new CircuitList(root);
        bb.addLast("AND", 0, 0);
        bb.addLast("AND", 30, 0);
        
        //Layout Principal
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(topMenu);
        mainLayout.setRight(rightMenu);
        //mainLayout.setCenter(subscene);
        mainLayout.setLeft(leftMenu);
        
        
        
        mainScene = new Scene(root, 620, 480);
        
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
    public void test(Gate source, MouseEvent event){
        
            //System.out.println(event.getSource().toString());
            if(event.getEventType()==MOUSE_PRESSED){
                source.getFigure().setCursor(Cursor.MOVE);
            }else if(event.getEventType()==MOUSE_RELEASED) {
                source.getFigure().setCursor(Cursor.HAND);
            }else if(event.getEventType()==MOUSE_DRAGGED){
                source.getFigure().setLayoutX(event.getSceneX());
                source.getFigure().setLayoutY(event.getSceneY());
                //source.newPosition(event.getX(), event.getY());
            }else if(event.getEventType()==MOUSE_ENTERED){
                source.getFigure().setCursor(Cursor.HAND);
            }
            event.consume();
    }
}
