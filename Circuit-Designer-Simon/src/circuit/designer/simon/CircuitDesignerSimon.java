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

public class CircuitDesignerSimon extends Application{
    
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
        
        
        
        
        //Zona de ensamble
        Group root = new Group();
        Pane target = new Pane();
        target.setLayoutX(0);
        target.setLayoutY(0);
        target.setMinWidth(500);
        target.setMinHeight(500);
        
        
        
        //BOTONES y sus EVENTOS
        ToggleButton andButton = new ToggleButton();
        GridPane.setConstraints(andButton,0,0);
        andButton.setGraphic(GateFigure.construct("AND"));
        andButton.setOnMouseClicked(e->{
            if("AND".equals(state)){
                andButton.setSelected(false);
                state="disabled";
            }else{
                andButton.setSelected(true);
                state="AND";
            }
        });
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
                addGate(e);
                }});
        circuit = new CircuitList(target);
        
        
        mainScene = new Scene(root, 620, 480);
        mainScene.setOnMouseClicked(e -> {
            if(e.getButton()==MouseButton.SECONDARY){
                state="disabled";
                andButton.setSelected(false);
                }});
        
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
    //AÑADE COMPUERTAS DEPENDIENDO DEL BOTON PRESIONADO
    public void addGate(MouseEvent e){
        if("AND".equals(state)){
            circuit.addLast("AND", e.getSceneX(), e.getSceneY());
        }
    }
    
}