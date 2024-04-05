package menuclasstest1;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;


public class MenuClassTest1 extends Application {

    //The menu bar
    MenuBar bar = new MenuBar();
Menu Prince = new Menu("Prince"), Peace = new Menu("Peace"), Precious = new Menu("Precious");
MenuItem makeNewI = new MenuItem("Make _new"), delExistI = new MenuItem("Delete _Existing one"), makeNewE = new MenuItem("Make New"), delExistE = new MenuItem("Delete Existing one"), makeNewR = new MenuItem("Make new"), delExistR = new MenuItem("Delete Existing One");
SeparatorMenuItem princeSep = new SeparatorMenuItem(), peaceSep = new SeparatorMenuItem(), preSep = new SeparatorMenuItem();

//the big button and its pane
Button eraseActs = new Button("Erase All Actions");
HBox pane = new HBox(12);


    //the root pane and the label
Label text = new Label();
BorderPane root = new BorderPane();


    @Override
    public void start(Stage stage) {

root.setPadding(new Insets(10, 0, 10, 0));

makeNewI.setOnAction(new handleMakeNew());
makeNewE.setOnAction(new handleMakeNew());
makeNewR.setOnAction(new handleMakeNew());
delExistI.setOnAction(new handleDelExist());
delExistE.setOnAction(new handleDelExist());
delExistR.setOnAction(new handleDelExist());

Prince.getItems().addAll(makeNewI, princeSep, delExistI);
Peace.getItems().addAll(makeNewE, peaceSep, delExistE);
Precious.getItems().addAll(makeNewR, preSep, delExistR);

    bar.getMenus().addAll(Peace, Prince, Precious);
root.setTop(bar);


    //the label
    root.setCenter(text);
    
//the button
    eraseActs.setPrefWidth(150);
    eraseActs.setPrefHeight(50);
    eraseActs.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
    text.setText("");
}
    });
pane.setAlignment(Pos.CENTER);
pane.getChildren().add(eraseActs);
    root.setBottom(pane);
    
    
    //the scene and the stage
    Scene theScene = new Scene(root);
stage.setWidth(500);
stage.setHeight(500);
    stage.setScene(theScene);
    stage.setResizable(false);
    stage.show();
    
    }

    public static void main(String[] args) {
        launch(args);
    }
    
class handleMakeNew implements EventHandler<ActionEvent>{
public void handle(ActionEvent e) {
text.setText(text.getText() + "\n \n *Making New " + ((MenuItem)e.getSource()).getParentMenu().getText() + "... We're all tired of the current one! ");
}    
}
class handleDelExist implements EventHandler<ActionEvent>{
public void handle(ActionEvent e) {
text.setText(text.getText() + "\n \n *Deleting " + ((MenuItem)e.getSource()).getParentMenu().getText() + "... We're all tired! ");
}    
}
}
