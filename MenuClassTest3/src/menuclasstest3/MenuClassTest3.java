/*
this program is just to add controls to a
menu item
*/
package menuclasstest3;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class MenuClassTest3 extends Application {
    
    //a button, textfield, textarea label control
    TextField name = new TextField();
    TextArea message = new TextArea();
    Button display = new Button("Drop Shoutout!");
    Label msgDisplay = new Label("No Shout-Outs From You...");
    
    //the menus and menu items
    Menu shoutOut = new Menu("_Drop a shoutout");
    Menu app = new Menu("_App");
    MenuItem delAll = new MenuItem("Delete all shoutouts"), exit = new MenuItem("Exit");
    
    //the menu bar
    MenuBar rootBar = new MenuBar();
    
    //the root pane
    BorderPane root = new BorderPane();
    
    //reference to the stage
    Stage stageRef;
    
    @Override
    public void start(Stage stage) {
        stageRef = stage;
    //first adding the label to the center of the pane
        root.setCenter(msgDisplay);
        
    //customizing the menu items and menus to add to the root menu bar

        name.setPrefColumnCount(9);
        message.setPrefColumnCount(9);
        message.setPrefRowCount(3);
        display.setPrefWidth(100);
            CustomMenuItem Name = new CustomMenuItem(name, false), Message = new CustomMenuItem(message, false), Display = new CustomMenuItem(display, false);
            shoutOut.getItems().addAll(Name, Message, Display);
        delAll.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                msgDisplay.setText("No Shout-Outs From You...");
            }
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stageRef.close();
            }
        });
        app.getItems().addAll(delAll, exit);
        rootBar.getMenus().addAll(app, shoutOut);
        root.setTop(rootBar);
        
        
        //the stage and the scene
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(800);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
