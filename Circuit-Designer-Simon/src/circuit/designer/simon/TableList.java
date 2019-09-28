
package circuit.designer.simon;

import javafx.scene.layout.GridPane;


public class TableList {
    
    private TableBox last, first;
    private int size;
    
    public TableList(){
        this.last = null;
        this.first = null;
        this.size = 0;
    }
    
    public void addColumnIn(Gate Title){
        if(this.last==null){
            this.first = new TableBox(Title);
            this.last = this.first;
            this.last.ID="IN";
            this.size++;
        }else{
            TableBox n = new TableBox(Title);
            n.prev = this.last;
            this.last.next = n;
            this.last = n;
            this.last.ID="IN";
            this.size++;
        }
    }
    
    public void addColumnOut(Gate Title){
        if(this.last==null){
            this.last = new TableBox(Title);
            this.first = this.last;
            this.last.ID="OUT";
        }else{
            TableBox n = new TableBox(Title);
            n.prev = this.last;
            this.last.next = n;
            this.last = n;
            this.last.ID="OUT";
        }
        
    }
    
    public void addInRows(){
        int i = 0;
        int div = 0;
        int count = 0;
        int value = 0;
        TableBox temp = this.last;
        while(true){
            if(temp.prev==null){
                TableBox temp2 = temp;
                while(i<Math.pow(2, size)){
                    temp2.bot = new TableBox(temp2.Title);
                    if(count<Math.pow(2, div)){
                        temp2.bot.setValue(value);
                        count++;
                        temp2=temp2.bot;
                        i++;
                    }else{
                        count=0;
                        if(value==0){
                            value=1;
                        }else{
                            value=0;
                        }
                    }
                }
                break;
            }else{
                TableBox temp2 = temp;
                while(i<Math.pow(2, size)){
                    temp2.bot = new TableBox(temp2.Title);
                    if(count<Math.pow(2, div)){
                        temp2.bot.setValue(value);
                        count++;
                        temp2=temp2.bot;
                        i++;
                    }else{
                        count=0;
                        if(value==0){
                            value=1;
                        }else{
                            value=0;
                        }
                    }
                }
                i=0;
                div++;
                count=0;
                value=0;
                temp=temp.prev;
            }
            
        }
    }
    
    public void addOutRows(){
        int i = 0;
        TableBox temp = this.last;
        while(true){
            if(temp.prev==null){
                if("IN".equals(temp.ID)){
                    break;
                }else{
                    TableBox temp2 = temp;
                    while(i<Math.pow(2, size)){
                        temp2.bot = new TableBox(temp2.Title);
                        temp2=temp2.bot;
                        i++;
                    }
                    break;
                }
            }else{
                if("IN".equals(temp.ID)){
                    break;
                }else{
                    TableBox temp2 = temp;
                    while(i<Math.pow(2, size)){
                        temp2.bot = new TableBox(temp2.Title);
                        temp2=temp2.bot;
                        i++;
                    }
                    i=0;
                    temp = temp.prev;
                }
            }
        }
    }
    
    public void setLastRows(GridPane table){
        int i = 0;
        int j = 0;
        TableBox temp = this.first;
        while(i<Math.pow(2, size)){
            while(true){
                if(temp.next==null){
                    if("IN".equals(temp.ID)){
                        temp.setInRow(j, i, table);
                    }else{
                        temp.setOutRow(j, i, table);
                    }
                    break;
                }else{
                    if("IN".equals(temp.ID)){
                        temp.setInRow(j, i, table);
                    }else{
                        temp.setOutRow(j, i, table);
                    }
                    j++;
                    temp=temp.next;
                }
            }
            j=0;
            i++;
            temp = this.first;
        }
    }
}
