package blurtest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.effect.*;

public class BlurTest extends Application{
    
    //the first combo box
    ComboBox<String> theBox1 = new ComboBox();
    ComboBox<String> theBox2 = new ComboBox();
    ComboBox<String> theBox3 = new ComboBox();
    
    //the root pane
    VBox root = new VBox();
      
      //the root scroll pane
      ScrollPane realRoot = new ScrollPane();
    
    @Override
    public void start(Stage stage) {
        //customizing the root pane
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);
    
        //customizing the combo boxes
        
        //the first one
        theBox1.setPrefWidth(200);
        theBox1.setPrefHeight(100);
        theBox1.getItems().add("Still boxblur");
        theBox1.setPromptText("BoxBlur");
        //its effect
        BoxBlur effect1 = new BoxBlur();
        effect1.setWidth(50);
        effect1.setHeight(50);
        effect1.setIterations(2);
        theBox1.setEffect(effect1);
        //adding it to the root pane
        root.getChildren().add(theBox1);
        
        //the second one
        theBox2.setPrefWidth(200);
        theBox2.setPrefHeight(100);
        theBox2.getItems().add("Gaussianblur of radius 10");
        theBox2.setPromptText("Gaussian Blur");
        //the gaussian blur effect
        GaussianBlur effect2 = new GaussianBlur();
        effect2.setRadius(10);
        theBox2.setEffect(effect2);
        //adding it to the root pane
        root.getChildren().add(theBox2);
        
        //the third one
        theBox3.setPrefWidth(200);
        theBox3.setPrefHeight(100);
        theBox3.setPromptText("Motion Blur");
        theBox3.getItems().add("MotionBlur of radius 20");
        //the motion blur
        MotionBlur effect3 = new MotionBlur();
        effect3.setRadius(20);
        theBox3.setEffect(effect3);
        //adding it to tbe root pane
        root.getChildren().add(theBox3);

        
        
        //the scene and the stage
        realRoot.setContent(root);
        Scene theScene = new Scene(realRoot);
        theScene.getStylesheets().clear();
        theScene.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
        stage.setScene(theScene);
        stage.setResizable(false);
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(500);
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}