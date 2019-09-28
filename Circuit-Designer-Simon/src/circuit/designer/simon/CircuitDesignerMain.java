package circuit.designer.simon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CircuitDesignerMain extends Application{
    
    private Stage window;
    private Scene mainScene;
    private CircuitList circuit;
    private boolean showingTable = false;
    
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
        //AND
        ToggleButton andButton = new ToggleButton("AND");
        GridPane.setConstraints(andButton,0,0);
        andButton.setGraphic(GateFigure.construct("AND"));
        andButton.setOnMouseClicked(e->MoveGate.ButtonControl(andButton, e, "AND"));
        //OR
        ToggleButton orButton = new ToggleButton("OR");
        GridPane.setConstraints(orButton,0,1);
        orButton.setGraphic(GateFigure.construct("OR"));
        orButton.setOnMouseClicked(e->MoveGate.ButtonControl(orButton, e, "OR"));
        //NOT
        ToggleButton notButton = new ToggleButton("NOT");
        GridPane.setConstraints(notButton,0,2);
        notButton.setGraphic(GateFigure.construct("NOT"));
        notButton.setOnMouseClicked(e->MoveGate.ButtonControl(notButton, e, "NOT"));
        //NAND
        ToggleButton nandButton = new ToggleButton("NAND");
        GridPane.setConstraints(nandButton,0,3);
        nandButton.setGraphic(GateFigure.construct("NAND"));
        nandButton.setOnMouseClicked(e->MoveGate.ButtonControl(nandButton, e, "NAND"));
        //NOR
        ToggleButton norButton = new ToggleButton("NOR");
        GridPane.setConstraints(norButton,0,4);
        norButton.setGraphic(GateFigure.construct("NOR"));
        norButton.setOnMouseClicked(e->MoveGate.ButtonControl(norButton, e, "NOR"));
        //XOR
        ToggleButton xorButton = new ToggleButton("XOR");
        GridPane.setConstraints(xorButton,0,5);
        xorButton.setGraphic(GateFigure.construct("XOR"));
        xorButton.setOnMouseClicked(e->MoveGate.ButtonControl(xorButton, e, "XOR"));
        //XNOR
        ToggleButton xnorButton = new ToggleButton("XNOR");
        GridPane.setConstraints(xnorButton,0,6);
        xnorButton.setGraphic(GateFigure.construct("XNOR"));
        xnorButton.setOnMouseClicked(e->MoveGate.ButtonControl(xnorButton, e, "XNOR"));
        //STARTPOINT
        ToggleButton startButton = new ToggleButton("IN");
        GridPane.setConstraints(startButton,0,7);
        startButton.setGraphic(GateFigure.construct("STARTPOINT"));
        startButton.setOnMouseClicked(e->MoveGate.ButtonControl(startButton, e, "STARTPOINT"));
        //ENDPOINT
        ToggleButton endButton = new ToggleButton("OUT");
        GridPane.setConstraints(endButton,0,8);
        endButton.setGraphic(GateFigure.construct("ENDPOINT"));
        endButton.setOnMouseClicked(e->MoveGate.ButtonControl(endButton, e, "ENDPOINT"));
        //GENERA LA TABLA
        Button generateButton = new Button("SIMULATE");
        GridPane.setConstraints(generateButton,0,9);
        generateButton.setOnMouseClicked(e->{
            try{
                if(!showingTable){
                    showingTable = true;
                    circuit.showResults();
                    addToTable(root);
                }
            }catch(StackOverflowError st){
                System.out.println("Circuito incorrecto, ciclo infinito");
                showingTable = false;
            }
        });
        Button saveButton = new Button("SAVE");
        GridPane.setConstraints(saveButton,0,10);
        
        //MENU
        GridPane menu = new GridPane();
        menu.setVgap(5);
        menu.setHgap(5);
        menu.getChildren().addAll(andButton,orButton,notButton,
                nandButton,norButton,xorButton,xnorButton, startButton,
                endButton, generateButton, saveButton);
        //Carga los diagramas guardados
        GateFileReader.loadNames(circuit, menu);
        //Funcion para guardar los diagramas
        saveButton.setOnMouseClicked(e->{
            String diagram = circuit.getDiagram();
            if(!"\n".equals(diagram)){
                SaveBox.saveName(circuit, menu, diagram);
            }
        });
        
        root.getChildren().addAll(target, menu);
        
        target.setOnMouseClicked(e -> {
            if(e.getButton()==MouseButton.PRIMARY){
                MoveGate.PaneControl(circuit, target, mainScene, e);
                }});
        
        mainScene = new Scene(root, 800, 600);
        //Desactiva los botones para añadir compuertas
        //deselecciona todo y cierra las conexiones pendientes
        mainScene.setOnMouseClicked(e -> {
            if(e.getButton()==MouseButton.SECONDARY){
                if(andButton.isSelected()){
                    MoveGate.ButtonControl(andButton, e, "AND");
                }
                if(startButton.isSelected()){
                    MoveGate.ButtonControl(startButton, e, "STARTPOINT");
                }
                if(endButton.isSelected()){
                    MoveGate.ButtonControl(endButton, e, "ENDPOINT");
                }
                if(notButton.isSelected()){
                    MoveGate.ButtonControl(notButton, e, "NOT");
                }
                if(orButton.isSelected()){
                    MoveGate.ButtonControl(orButton, e, "OR");
                }
                if(nandButton.isSelected()){
                    MoveGate.ButtonControl(nandButton, e, "NAND");
                }
                if(norButton.isSelected()){
                    MoveGate.ButtonControl(norButton, e, "NOR");
                }
                if(xorButton.isSelected()){
                    MoveGate.ButtonControl(xorButton, e, "XOR");
                }
                if(xnorButton.isSelected()){
                    MoveGate.ButtonControl(xnorButton, e, "XNOR");
                }
                circuit.unSelectAll();
                MoveGate.notConecting();
            }
        });
        mainScene.setOnKeyPressed(key->{
            if(key.getCode()==KeyCode.DELETE){
                circuit.delete();
            }
        });
        
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
    public void addToTable(Group root){
        GridPane table = new GridPane();
        Button closeTable = new Button("Close");
        GridPane.setConstraints(closeTable,0,0);
        
        circuit.generateTable(table);
        
        table.getChildren().addAll(closeTable);
        table.setLayoutX(400);
        table.setLayoutY(400);
        root.getChildren().add(table);
        
        closeTable.setOnMouseClicked(e->{
            showingTable = false;
            root.getChildren().remove(table);
        });
    }
    
    
}