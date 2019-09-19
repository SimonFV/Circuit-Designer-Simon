package circuit.designer.simon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CircuitDesignerMain extends Application{
    
    private String state; //permite agregar compuertas
    private Stage window;
    private Scene mainScene;
    private CircuitList circuit;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        primaryStage.setTitle("Circuit Designer by Simon");
        
        
        //Layouts principales
        Group root = new Group();
        Pane target = new Pane();
        target.setLayoutX(0);
        target.setLayoutY(0);
        target.setMinWidth(500);
        target.setMinHeight(500);
        circuit = new CircuitList(target);
        
        
        //BOTONES y sus EVENTOS
        ToggleButton andButton = new ToggleButton();
        GridPane.setConstraints(andButton,0,0);
        andButton.setGraphic(GateFigure.construct("AND"));
        andButton.setOnMouseClicked(e->MoveGate.ButtonControl(andButton, e, "AND"));
        Button orButton = new Button("OR");
        GridPane.setConstraints(orButton,0,1);
        Button notButton = new Button("NOT");
        GridPane.setConstraints(notButton,0,2);
        Button nandButton = new Button("NAND");
        GridPane.setConstraints(nandButton,0,3);
        Button norButton = new Button("NOR");
        GridPane.setConstraints(norButton,0,4);
        Button xorButton = new Button("XOR");
        GridPane.setConstraints(xorButton,0,5);
        Button xnorButton = new Button("XNOR");
        GridPane.setConstraints(xnorButton,0,6);
        
        //MENU
        GridPane menu = new GridPane();
        menu.setMaxHeight(60);
        menu.setMinHeight(60);
        menu.setVgap(5);
        
        menu.getChildren().addAll(andButton,orButton,notButton,nandButton,norButton,xorButton,xnorButton);
        
        root.getChildren().addAll(target, menu);
        
        target.setOnMouseClicked(e -> {
            if(e.getButton()==MouseButton.PRIMARY){
                MoveGate.PaneControl(circuit, target, mainScene, e);
                }});
        
        
        mainScene = new Scene(root, 620, 480);
        mainScene.setOnMouseClicked(e -> {
            if(e.getButton()==MouseButton.SECONDARY){
                if(andButton.isSelected()){
                    MoveGate.ButtonControl(andButton, e, "AND");
                }
        }});
        
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
}