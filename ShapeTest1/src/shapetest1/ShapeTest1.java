package shapetest1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShapeTest1 extends Application {

    //the array of the 600 lines
    Line[] theArr = new Line[600];
    
    
    //the root pane
    VBox root = new VBox();
    @Override
    public void start(Stage stage) {
        
        //setting up the stage as some of its set properties would be needed to properly create the lines
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(500);
        
        
        //the loop to initialise the first 300 horizontal lines 
        for(int i = 0; i < 301; i++) {
            theArr[i] = new Line((i + 2), stage.getY(), (i + 2), stage.getHeight());
        }
        
        //the loop to initialise the 300 horizontal lines
        for(int i = 1; i < 300; i++) {
            theArr[i + 300] = new Line(stage.getX(), (stage.getY() - i - 1), stage.getWidth(), (stage.getY() - i - 1));
        }
        
        //adding the lines to the root pane
        for(int i = 0; i < 600; i++) {
            root.getChildren().add(theArr[i]);
        }
        
        //the stage and the scene
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.show();
    
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
