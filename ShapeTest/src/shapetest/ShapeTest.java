package shapetest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class ShapeTest extends Application {

    //the root group 
    Group root = new Group();
    
    
    @Override
    public void start(Stage stage) {
//editting the stage first
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(500);
        stage.setResizable(false);
        
//the loop that adds creates the lines and adds them to the group
        for(int i = 0; i < 200; i++) {
            //the vertical line
            Line v = new Line(i + (10 * i), stage.getHeight(), i + (10 * i), 0);
            v.setStroke(Color.BLACK);
            v.setStrokeWidth(1);
            //the horizontal line
            Line h = new Line(0, i + (10 * i), stage.getWidth(), i + (10 * i));
            h.setStroke(Color.BLACK);
            h.setStrokeWidth(1);
            //adding them to the group
            root.getChildren().addAll(v, h);
        }
    
    //customizing the scene and the stage
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
