package shapetest3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class ShapeTest3 extends Application {

    //creating the three rectangles
    Rectangle rect1 = new Rectangle(20, 20, 150, 300), rect2 = new Rectangle(220, 20, 150, 300), rect3 = new Rectangle(0, 100, 398, 150);
    
    //the root group
    Group root = new Group();
    
    @Override
    public void start(Stage stage) {
        //customizing the three rectangles before adding them to the root group
        rect1.setFill(Color.rgb(200, 200, 200, 0.5));
        rect1.setStroke(Color.BLACK);
        rect1.setStrokeWidth(3);
        rect2.setFill(Color.rgb(200, 200, 200, 0.5));
        rect2.setStroke(Color.BLACK);
        rect2.setStrokeWidth(3);
        rect3.setFill(Color.rgb(210, 210, 210, 1));
        rect3.setStroke(Color.BLACK);
        rect3.setStrokeWidth(3);
        
        //adding them to the root group
        root.getChildren().addAll(rect3, rect1, rect2);
        
        
        //the stage and the scene
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
