package gridpanetest2;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.stage.*;

public class MsgBox {
//the stage
    Stage theStage = new Stage();
    //the root gridpane
    GridPane root = new GridPane();
    
    //the values
    String name, address, size, topping, spice1, spice2, spice3;

        //reference to the gridpanetest class, needed to clear its textfields on the stage's closing
        GridPaneTest2 ref;

           Text nameTxt;
       Text addressTxt;
       Text orderTxt;
       Text theOrderTxt;
       Button orderBtn = new Button("ORDER"), cancelBtn = new Button("CANCEL");

        
    public MsgBox(String name, String address, String size, String topping, String spice1, String spice2, String spice3, GridPaneTest2 ref) {
        this.ref = ref;
        this.name = name;
        this.address = address;
        this.topping = topping;
        this.size = size;
        this.spice1 = spice1;
        this.spice2 = spice2;
        this.spice3 = spice3;
        nameTxt = new Text("Name: " + this.name + "\n");
        addressTxt = new Text("Address: " + this.address + "\n");
        orderTxt = new Text("ORDER");
        theOrderTxt = new Text();
    }

    
       
       
    public void show() {
        //working on the texts to be displayed on the stage
        nameTxt.setFont(new Font("Arial", 15));
        addressTxt.setFont(new Font("Arial", 15));
        orderTxt.setFont(new Font("Arial", 18));
        theOrderTxt.setFont(new Font("Arial", 15));
        theOrderTxt.setText(this.size + " moi- moi, with " + this.topping + " topping. Spice(s) to be included are " + spice1 + spice2 + spice3);
        
        
        //working on the buttons to be added to the stage
        orderBtn.setOnAction(new subHandler());
        
            cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    ref.addressFld.clear();
                    ref.nameFld.clear();
                    theStage.close();
                }
            });
        
        
        //customizing the root pane before adding things to it
        root.setVgap(30);
        root.setHgap(10);
        ColumnConstraints col1 = new ColumnConstraints(), col2 = new ColumnConstraints(), col3 = new ColumnConstraints();
        col1.setPercentWidth(33);
        col1.setHalignment(HPos.CENTER);
        col2.setPercentWidth(33);
        col2.setHalignment(HPos.CENTER);
        col3.setPercentWidth(33);
        col3.setHalignment(HPos.CENTER);
        root.getColumnConstraints().addAll(col1, col2, col3);
        
        //adding them to the root
        root.add(nameTxt, 0, 2, 3, 1);
        root.add(addressTxt, 0, 3, 3, 1);
        root.add(orderTxt, 1, 5, 1, 1);
        root.add(theOrderTxt, 0, 6, 3, 2);
        root.add(orderBtn, 0, 8, 2, 1);
        root.add(cancelBtn, 1, 9, 2, 1);
        
        
        //displaying the stage
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        theStage.setX(900);
        theStage.setResizable(false);
        theStage.show();
        
        //consuming the close request
        theStage.setOnCloseRequest(new handler());
    }
    
//the handler for the stage's close request
    class handler implements EventHandler<WindowEvent> {
        public void handle(WindowEvent e) {
            ref.addressFld.clear();
            ref.nameFld.clear();
        }
    }
//handler for the submit button
    public class subHandler implements EventHandler<ActionEvent> {
                    public void handle(ActionEvent e) {
                theStage.setTitle("Your Order Was Successfully created!");
                root.getChildren().removeAll(nameTxt, addressTxt, orderTxt, theOrderTxt, orderBtn, cancelBtn);
                theStage.setResizable(true);
                Text success = new Text("Your Order Was Created Successfully!");
                success.setFont(new Font("Arial", 19));
                root.add(success, 1, 4);
                theStage.setResizable(false);
                    }
    }
}
