package csstest1;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.File;

public class CSSTest1 extends Application {

    //The three buttons
    Button btn1 = new Button("First Button"), btn2 = new Button("Second Button"), btn3 = new Button("Third Button");
    
    //the root pane
    GridPane root = new GridPane();
    
    @Override
    public void start(Stage stage) {
        //customizing the buttons to add the root pane
        btn1.getStyleClass().add("button-1");
        btn2.getStyleClass().add("button-2");
        btn3.getStyleClass().add("button-3");
        
//adding the buttons to the gridpane
        root.add(btn1, 0, 0);
        root.add(btn2, 0, 1);
        root.add(btn3, 0, 2);
        

    //the scene and stage
        Scene theScene = new Scene(root);
        
    //adding the style sheet to the scene
    File f = new File("C:/Users/PST JUDE/Documents/NetBeansProjects/libgdx-1.6.1/GameProjects/CSSTest1/src/csstest1/CSSFile.css");
    theScene.getStylesheets().clear();
    theScene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));    
        
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
