package circuit.designer.simon;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        And and = new And(120,120);
        
        //LAYOUTS
        HBox topMenu = new HBox(10);
        topMenu.getChildren().addAll(menu);
        VBox rightMenu = new VBox(10);
        rightMenu.getChildren().addAll(tablaCompuertas, andLabel);
        
        VBox leftMenu = new VBox(10);
        leftMenu.getChildren().addAll(resultsLabel);
        
        //Zona de ensamble
        Pane ensambleZone = new Pane();
        
        ensambleZone.getChildren().addAll(areaEnsamble, and.getFigure());
        Pane target = ensambleZone;
        
        //Layout Principal
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(topMenu);
        mainLayout.setRight(rightMenu);
        mainLayout.setCenter(ensambleZone);
        mainLayout.setLeft(leftMenu);
        
        mainScene = new Scene(mainLayout, 620, 480);
        
        //EVENTOS DE ARRASTRE DE COMPUERTAS
        and.getFigure().setOnDragDetected(event -> MoveGate.MouseControl(and, target, event));
        target.setOnDragOver(event -> MoveGate.DragControl(and, target, event));
        target.setOnDragEntered(event -> MoveGate.DragControl(and, target, event));
        target.setOnDragExited(event -> MoveGate.DragControl(and, target, event));
        target.setOnDragDropped(event -> MoveGate.DragControl(and, target, event));
        and.getFigure().setOnDragDone(event -> MoveGate.DragControl(and, target, event));
        
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
}
