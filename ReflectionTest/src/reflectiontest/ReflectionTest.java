package reflectiontest;

import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.*;
import javafx.scene.effect.*;

public class ReflectionTest extends Application {
    
    //the button
    Button theBigBtn = new Button("Wanna be big and reflected?");
    
    //the root pane
    VBox root = new VBox();
    
    @Override
    public void start(Stage stage) {
       //customizing the stage first
        stage.setWidth(400);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.setX(900);
        
        //customizing the root pane
        root.setPrefWidth(stage.getWidth());
        root.setAlignment(Pos.CENTER);
        
        //customizing the big button
        theBigBtn.setPrefWidth(200);
        theBigBtn.setPrefHeight(100);
        theBigBtn.setStyle("-fx-background-color: green;"
                + "-fx-font-family: algerian;"
                + "-fx-font-size: 12px;");
        //the reflection part
        Reflection ref1 = new Reflection();
        ref1.setFraction(0.87);
        ref1.setTopOffset(0);
        ref1.setBottomOpacity(0.2);
        ref1.setTopOpacity(0.5);
        //adding it to the big button
        theBigBtn.setEffect(ref1);
        //adding the button to the root pane
        root.getChildren().add(theBigBtn);
        
        
        //the scene and the stage
          Scene theScene = new Scene(root);
          stage.setScene(theScene);
          stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}