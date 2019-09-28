
package circuit.designer.simon;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
* Clase que muestra una ventana emergente para guardar el diagrama actual.
* @author: Simon Fallas V.
*/
public class SaveBox {
    
    /**
    * Método estático que muestra una ventana emergente para guardar el diagrama actual con
    * el nombre ingresado por el usuario.
    * @param circuit Lista a guardar.
    * @param menu Panel donde se agregará el nuevo botón.
    * @param diagram Información de las compuertas y conexiones de la lista.
    */
    public static void saveName(CircuitList circuit, GridPane menu, String diagram){
        Stage saveWindow = new Stage();
        saveWindow.initModality(Modality.APPLICATION_MODAL);
        saveWindow.setTitle("Saving...");
        
        
        Label info = new Label("Save as:");
        TextField getName = new TextField();
        getName.setMinWidth(120);
        
        Button save = new Button("Save");
        save.setOnMouseClicked(e->{
            String name = getName.getText();
            if(GateFileReader.checkName(name)){
                GateFileReader.writeName(name);
                GateFileReader.writeFile(name+";"+diagram);
                GateFileReader.addCustomButton(circuit, menu, name);
                saveWindow.close(); 
            }else{
                info.setText("Try again:");
            }
        });
        Button cancel = new Button("Cancel");
        
        cancel.setOnAction(e->saveWindow.close());
        
        VBox main = new VBox(15);
        HBox top = new HBox(15);
        HBox bot = new HBox(15);
        
        top.getChildren().addAll(info, getName);
        top.setAlignment(Pos.CENTER);
        bot.getChildren().addAll(save, cancel);
        bot.setAlignment(Pos.CENTER);
        main.getChildren().addAll(top, bot);
        main.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(main);
        saveWindow.setScene(scene);
        saveWindow.showAndWait();
    }
    
}
