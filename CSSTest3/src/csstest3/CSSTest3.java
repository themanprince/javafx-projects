package csstest3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CSSTest3 extends Application {
    
    //the three labels
    Label lab1 = new Label("This label uses pre-definfed colors"), lab2 = new Label("This label uses hex"), lab3 = new Label("This label uses the color I defined");
    
    //the root pane
    VBox root = new VBox(30);
    
    @Override
    public void start(Stage stage) {
        //customizing the labels before adding them to the root pane
        lab1.getStyleClass().add("lab1");
        lab2.getStyleClass().add("lab2");
        lab3.getStyleClass().add("lab3");
        
        
        //adding the labels to the root pane
        root.getChildren().addAll(lab1, lab2, lab3);
        
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
