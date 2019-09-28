
package circuit.designer.simon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
* Clase que manipula los eventos relaionados al tratamiento de archivos de texto, el guardado
* de los diagramas personalizados y la creación de sus respectivos botones.
* @author: Simon Fallas V.
*/
public class GateFileReader{
    private static int row = 11;
    private static String line = "";
    
    /**
    * Método estático que busca la información de las compuertas del diagrama personalizado
    * especificado por el usuario, y las añade a la lista principal.
    * @param circuit Lista del diagrama.
    * @param name Nombre de la lista a buscar.
    */
    public static void readFile(CircuitList circuit, String name){
        FileReader fileReader = null;
        BufferedReader br = null;

        try{
            fileReader = new FileReader("SavedGates.txt");
            br = new BufferedReader(fileReader);
            
            //Lee un caracter.
            int i;
            String temp = "";
            while ((i = br.read()) != -1){
                if((char)i!=';'){
                    temp=temp+(char)i;
                }else{
                    if(name.equals(temp)){
                        int lastSize = circuit.getSize();
                        temp = "";
                        //Añade compuertas
                        String type = "";
                        String x = "";
                        String y = "";
                        while(true){
                            i = br.read();
                            if((char)i!=';'){
                                if((char)i!=','){
                                    if((char)i!='('){
                                        type=type+(char)i;
                                    }else{
                                        //Posicion de la compuerta x
                                        while(true){
                                            i = br.read();
                                            if((char)i!=','){
                                                x=x+(char)i;
                                            }else{
                                                //Posicion de la compuerta x
                                                while(true){
                                                    i = br.read();
                                                    if((char)i!=')'){
                                                        y=y+(char)i;
                                                    }else{
                                                        circuit.addLast(type, Double.parseDouble(x),
                                                                Double.parseDouble(y));
                                                        type = "";
                                                        x = "";
                                                        y = "";
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                            }else{
                                //Realiza las conexiones
                                String sourceS = "";
                                Gate sourceGate = null;
                                while(true){
                                    i = br.read();
                                    if((char)i!='\n'){
                                        if((char)i!='-'){
                                            //source
                                            if((char)i!=','){
                                                sourceS=sourceS+(char)i;
                                            }
                                        }else{
                                            i = br.read();
                                            int p = Integer.parseInt(sourceS)+lastSize;
                                            if((char)i=='0'){
                                                sourceGate=circuit.getPosition(p);
                                            }else if((char)i=='2'){
                                                sourceGate=circuit.getPosition(p).InTop;
                                            }else{
                                                sourceGate=circuit.getPosition(p).InBot;
                                            }
                                            //rFrom
                                            i = br.read();
                                            Gate rFromGate = null;
                                            String rFromS = "";
                                            while(true){
                                                i = br.read();
                                                if((char)i!='-'){
                                                    rFromS = rFromS+(char)i;
                                                }else{
                                                    i = br.read();
                                                    int r = Integer.parseInt(rFromS)+lastSize;
                                                    if((char)i=='0'){
                                                        rFromGate=circuit.getPosition(r);
                                                    }else{
                                                        rFromGate=circuit.getPosition(r).Out;
                                                    }
                                                    sourceGate.setrFrom(rFromGate);
                                                    sourceS = "";
                                                    sourceGate = null;
                                                    break;
                                                }
                                            }
                                        }
                                    }else{
                                        circuit.makeConections();
                                        break;
                                    }
                                }
                                break;
                            }

                        }
                    }else{
                        temp = "";
                        line = br.readLine();
                    }
                }
            }
        }catch(IOException e){
            System.out.println("File not found");
            //Crear txt
        }finally{
            try{
                if(fileReader!=null){
                    fileReader.close();
                }
                if(br!=null){
                    br.close();
                }
            }catch(IOException e){
                System.out.println("File not found");
            }
        }
    }
    
    /**
    * Método estático que escribe en un archivo de texto la información del diagrama
    * guardado por el usuario.
    * @param diagram Información de la lista a guardar.
    */
    public static void writeFile(String diagram){
        FileReader fileReader = null;
        BufferedReader br = null;
        FileWriter fileWriter = null;
        try{
            fileReader = new FileReader("SavedGates.txt");
            br = new BufferedReader(fileReader);
            String text = "";
            line = "";
            while((line=br.readLine())!=null){
                text=text+line+"\n";
            }
            //sobreescribe todo
            fileWriter = new FileWriter("SavedGates.txt");
            fileWriter.write(text+diagram);
        }catch(IOException e){
            System.out.println("fileNotFound");
        }finally{
            try{
                if(fileReader!=null){
                    fileReader.close();
                }
                if(br!=null){
                    br.close();
                }
                if(fileWriter!=null){
                    fileWriter.close();
                }
            }catch(IOException e){
                System.out.println("File not found");
            }
        }
    }
    
    /**
    * Método estático que escribe en un archivo de texto el nombre asignado al botón
    * para almacenar el diagrama personalizado.
    * @param name Nombre de la lista a guardar.
    */
    public static void writeName(String name){
        FileReader fileReader = null;
        BufferedReader br = null;
        FileWriter fileWriter = null;
        try{
            fileReader = new FileReader("GateNames.txt");
            br = new BufferedReader(fileReader);
            String text = "";
            line = "";
            while((line=br.readLine())!=null){
                text=text+line+"\n";
            }
            //sobreescribe todo
            fileWriter = new FileWriter("GateNames.txt");
            fileWriter.write(text+name+"\n");
        }catch(IOException e){
            System.out.println("fileNotFound");
        }finally{
            try{
                if(fileReader!=null){
                    fileReader.close();
                }
                if(br!=null){
                    br.close();
                }
                if(fileWriter!=null){
                    fileWriter.close();
                }
            }catch(IOException e){
                System.out.println("File not found");
            }
        }
    }
    
    /**
    * Método estático que revisa que el nombre del circuito a guardar no se encuentre repetido y 
    * retorna un verdadero si no encuentra ninguno.
    * @param name Nombre de la lista a guardar.
    * @return check boolean
    */
    public static boolean checkName(String name){
        boolean check = true;
        FileReader fileReader = null;
        BufferedReader br = null;
        try{
            fileReader = new FileReader("GateNames.txt");
            br = new BufferedReader(fileReader);
            line = "";
            while((line=br.readLine())!=null){
                if(name.equals(line)){
                    check = false;
                    break;
                }
            }
        }catch(IOException e){
            System.out.println("fileNotFound");
        }finally{
            try{
                if(fileReader!=null){
                    fileReader.close();
                }
                if(br!=null){
                    br.close();
                }
            }catch(IOException e){
                System.out.println("File not found");
            }
        }
        return check;
    }
    
    /**
    * Método estático que busca los diagramas guardados al iniciar el programa para crear los 
    * botones respectivos.
    * @param circuit Lista del diagrama principal.
    * @param menu Panel donde se agregarán los botones.
    */
    public static void loadNames(CircuitList circuit, GridPane menu){
        FileReader fileReader = null;
        BufferedReader br = null;
        try{
            fileReader = new FileReader("GateNames.txt");
            br = new BufferedReader(fileReader);
            line = "";
            while((line=br.readLine())!=null){
                if(!"".equals(line)){
                    addCustomButton(circuit, menu, line);
                }
            }
        }catch(IOException e){
            System.out.println("fileNotFound");
        }finally{
            try{
                if(fileReader!=null){
                    fileReader.close();
                }
                if(br!=null){
                    br.close();
                }
            }catch(IOException e){
                System.out.println("File not found");
            }
        }
    }
    
    /**
    * Método estático que agrega los botones al panel principal, y los prepara para que se
    * agreguen a las lista principal cuando sean añadidos por el usuario.
    * @param circuit Lista del diagrama principal.
    * @param menu Panel donde se agregarán los botones.
    * @param name Nombre de la lista a guardar.
    */
    public static void addCustomButton(CircuitList circuit, GridPane menu, String name){
        VBox pack = new VBox(2);
        Button customButton = new Button(name);
        customButton.setOnMouseClicked(e->{
            GateFileReader.readFile(circuit, name);
        });
        Button deleteButton = new Button("Delete");
        
        pack.getChildren().addAll(customButton, deleteButton);
        GridPane.setConstraints(pack,0,row);
        menu.getChildren().add(pack);
        row++;
        
        deleteButton.setOnMouseClicked(e->{
            deleteCustomGate(name);
            menu.getChildren().remove(pack);
        });
    }
    
    /**
    * Método estático que elimina el botón especificado por el usuario.
    * @param name Nombre de la lista a borrar.
    */
    public static void deleteCustomGate(String name){
        int i = 0;
        FileReader nameReader = null;
        FileReader fileReader = null;
        BufferedReader br = null;
        FileWriter fileWriter = null;
        
        try{
            nameReader = new FileReader("GateNames.txt");
            br = new BufferedReader(nameReader);
            String text = "";
            line = "";
            int j = 0;
            while((line=br.readLine())!=null){
                if(!line.equals(name)){
                    System.out.println(line+","+name);
                    text=text+line+"\n";
                }else{
                    i=j;
                }
                j++;
            }
            fileWriter = new FileWriter("GateNames.txt");
            fileWriter.write(text);
            fileWriter.close();
            
            fileReader = new FileReader("SavedGates.txt");
            br = new BufferedReader(fileReader);
            text = "";
            j=0;
            line = "";
            while((line=br.readLine())!=null){
                if(i!=j){
                    text=text+line+"\n";
                }
                j++;
            }
            fileWriter = new FileWriter("SavedGates.txt");
            fileWriter.write(text);
            
        }catch(IOException e){
            System.out.println("fileNotFound");
        }finally{
            try{
                if(fileReader!=null){
                    fileReader.close();
                }
                if(br!=null){
                    br.close();
                }
                if(fileWriter!=null){
                    fileWriter.close();
                }
                if(nameReader!=null){
                    nameReader.close();
                }
            }catch(IOException e){
                System.out.println("File not found");
            }
        }
    }
}
