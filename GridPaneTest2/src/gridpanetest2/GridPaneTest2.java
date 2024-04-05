package gridpanetest2;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

public class GridPaneTest2 extends Application {

    //reference to theis class
    GridPaneTest2 reference;
        
    public GridPaneTest2() {
        reference = this;
    }
    
    //the grid pane
    GridPane root = new GridPane();
    
    //the title label
    Label title = new Label("Order MM 2");
    
    //the name and address labels and textfields
    Label nameLbl = new Label("Name");
    TextField nameFld = new TextField();
    Label addressLbl = new Label("Address");
    TextField addressFld = new TextField();
    
    //the size pane, label and radio buttons
    VBox sizePane = new VBox(5);
    Label sizeLbl = new Label("Size");
    RadioButton small = new RadioButton("Small"), medium = new RadioButton("Medium"), large = new RadioButton("Large");
    ToggleGroup sizeGroup = new ToggleGroup();
    
    //the toppings pane
    VBox toppingsPane = new VBox(5);
    Label toppingsLbl = new Label("Toppings");
    RadioButton crayfish = new RadioButton("CrayFish"), shrimp = new RadioButton("Shrimp"), lobster = new RadioButton("Lobster");
    ToggleGroup toppingsGroup = new ToggleGroup();
    
    //the spices pane
    VBox spicesPane = new VBox(5);
    Label spicesLbl = new Label("Spices");
    CheckBox salt = new CheckBox("Salt"), pepper = new CheckBox("Pepper"), tomatoes = new CheckBox("Tomatoes");
    
    //The submit button and cancel buttons
    Button submitBtn = new Button("Submit"), cancelBtn = new Button("Cancel");
    HBox buttonsPane = new HBox(15);
    
    
    
    @Override
    public void start(Stage stage) {
    //reference to stage, for inner class
    final Stage reStage = stage;

        //working on the "name and address part" to add to the grid pane
    nameFld.setPrefColumnCount(20);
    nameFld.requestFocus();
    addressFld.setPrefColumnCount(25);
    
        //working on the size pane 
    small.setToggleGroup(sizeGroup);
    medium.setToggleGroup(sizeGroup);
    large.setToggleGroup(sizeGroup);
    sizePane.setAlignment(Pos.BASELINE_LEFT);
    sizePane.getChildren().addAll(sizeLbl, small, medium, large);
    
        //working on the topppings pane
    crayfish.setToggleGroup(toppingsGroup);
    shrimp.setToggleGroup(toppingsGroup);
    lobster.setToggleGroup(toppingsGroup);
    toppingsPane.getChildren().addAll(toppingsLbl, crayfish, shrimp, lobster);
    
        //working on the spices pane
    spicesPane.getChildren().addAll(spicesLbl, salt, pepper, tomatoes);
    
        //working on the buttons
    submitBtn.setPrefWidth(100);
    cancelBtn.setPrefWidth(100);    
    submitBtn.setOnAction(new handler());
    cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            reStage.close();
        }
    });
    submitBtn.setStyle("-fx-background-color: blue; \n"
            + "-fx-font-family: algerian; \n"
            + "-fx-font-size: 15;");
    cancelBtn.setStyle("-fx-background-color: blue; \n"
            + "-fx-font-family: algerian; \n"
            + "-fx-font-size: 15;");
    
    
    
    
    //customizing the gridpane 
    root.setVgap(10);
    root.setHgap(10);
    ColumnConstraints col1 = new ColumnConstraints(), col2 = new ColumnConstraints(), col3 = new ColumnConstraints();
    col1.setHalignment(HPos.CENTER);
    col1.setPercentWidth(33);
    col2.setHalignment(HPos.CENTER);
    col2.setPercentWidth(33);
    col3.setHalignment(HPos.LEFT);
    col3.setPercentWidth(33);

    
    root.getColumnConstraints().addAll(col1, col2);
    
    
    //adding the items to the grid pane

root.addColumn(0, nameLbl, addressLbl);
root.add(nameFld, 1, 0, 2, 1);
root.add(addressFld, 1, 1, 3, 1);
//adding the size, toppings and spices pane to a border pane before adding them to the grid pane
BorderPane STS = new BorderPane();
STS.setLeft(sizePane);
toppingsPane.setAlignment(Pos.CENTER);
STS.setCenter(toppingsPane);
STS.setRight(spicesPane);
root.add(STS, 0, 2, 5, 5);
root.add(submitBtn, 0, 11, 3, 2);
root.add(cancelBtn, 2, 11, 3, 2);
    
    
    //customizing the scene and the stage 
    Scene theScene = new Scene(root);
    stage.setScene(theScene);
    stage.setX(900);
    stage.setWidth(500);
    stage.setHeight(500);
    stage.setResizable(false);
    stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
//the event handler for the submit button
    class handler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
String name = nameFld.getText(), address = addressFld.getText(), size = "", topping = "", spice1 = "", spice2 = "", spice3 = "";
if(small.isSelected()) {
size = "small";    
}else if(medium.isSelected()) {
    size = "medium";
}else if(large.isSelected()) {
    size = "large";
}

if(crayfish.isSelected()) {
    topping = "crayfish";
}else if(shrimp.isSelected()) {
    topping = "shrimp";
}else if(lobster.isSelected()) {
    topping = "lobster";
}

if(tomatoes.isSelected()) {
    spice1 = "tomatoes, ";
}
if(salt.isSelected()) {
    spice2 = "salt, ";
}
if(pepper.isSelected()) {
    spice3 = "pepper";
}

//creating the message box
MsgBox theMsg = new MsgBox(name, address, size, topping, spice1, spice2, spice3, reference);
theMsg.show();

        }
    }
}
