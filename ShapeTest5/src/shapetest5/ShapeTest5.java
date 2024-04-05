package shapetest5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.paint.*;

public class ShapeTest5 extends Application {
    
    //the root group
    Group root = new Group();
    
    @Override
    public void start(Stage stage) {
    //the first modified shape(the union)
    Shape shape1 = Shape.union(new Circle(50, 50, 50), new Circle(90, 50, 50));
    shape1.setFill(Color.rgb(45, 12, 45, 0.5));
    shape1.setStroke(Color.BLACK);
    shape1.setStrokeWidth(3);
    //adding the shape to the root group
    root.getChildren().add(shape1);
    
    //the second modified shape(the intersect)
    Shape shape2 = Shape.intersect(new Circle(240, 50, 50), new Circle(260, 50, 50));
    shape2.setFill(Color.rgb(45, 12, 45, 0.5));
    shape2.setStroke(Color.BLACK);
    shape2.setStrokeWidth(3);
    //adding the shape to the root group
    root.getChildren().add(shape2);
    
    //the third modified shape(the subtraction)
    Shape shape3 = Shape.subtract(new Circle(50, 170, 50), new Circle(70, 150, 50));
    shape3.setFill(Color.rgb(45, 12, 45, 0.5));
    shape3.setStroke(Color.BLACK);
    shape3.setStrokeWidth(3);
    //adding it to the root group
    root.getChildren().add(shape3);

    
    
    
    //the scene and the stage
    Scene theScene = new Scene(root);
    stage.setScene(theScene);
    stage.setX(900);
    stage.setWidth(400);
    stage.setResizable(false);
    stage.setHeight(400);
    stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
