package csstest4;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*; //just added this one two years after this file was originally created in 2020
//doing so, cus I have to put some shit in a collection before I add em to the root.. weird!
//P.S its Sep 24, 2022

public class CSSTest4 extends Application {
    
    
    //the four buttons
    Button btn1 = new Button("Look at my border design"), btn2 = new Button("Look at my border design"), btn3 = new Button("Look at my border design"), btn4 = new Button("Look at my border design");
    //The stack I'mma add em to... so I can just add em all at once using the addAll method
    List<Button> btnList = new Stack<Button>();
    
    //the root pane
    FlowPane root = new FlowPane();
    
    
    public void start(Stage stage) {
		//customizing the buttons before adding them to the root pane
        btn1.getStyleClass().add("btn");
        btn2.getStyleClass().add("BTN");
        btn3.getStyleClass().add("btn");
        btn4.getStyleClass().add("BTN");
        
        //customizing the root pane before adding the items to it
        root.setOrientation(Orientation.HORIZONTAL);
        root.setVgap(10);
        root.setHgap(30);

        //adding the buttons to the stack
        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);
        btnList.add(btn4);
        //adding the stack to the root pane
        root.getChildren().addAll(btnList);
        
        
        //the scene and the stage
        Scene theScene = new Scene(root);
        theScene.getStylesheets().clear();
        theScene.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(500);
        stage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
