package shapetest2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class ShapeTest2 extends Application {
    
    //the root group 
    Group root = new Group();
    
    @Override
    public void start(Stage stage) {
        //editting some properties of the stage first
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(500);
        stage.setResizable(false);
        
        //creating the grid of lines for background
        for(int i = 0; i < 100; i++) {
            //the vertical line
            Line v = new Line((i * 10), 0, (i * 10), stage.getHeight());
            v.setStroke(Color.LIGHTPINK);
            //the horizontal line
            Line h = new Line(0, (i * 10), stage.getWidth(), (i * 10));
            h.setStroke(Color.LIGHTPINK);
            
            //adding them to the root group
            root.getChildren().addAll(v, h);
        }
        
        //the rectangle #ShapeTest 2-1
        Rectangle rect1 = new Rectangle(20, 0 + 20, 100, 70);
        rect1.setStroke(Color.BLACK);
        rect1.setFill(null);
        rect1.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(rect1);
        

        //the rectangle with curved corners #ShapeTest 2-2
        Rectangle rect2 = new Rectangle(150, 0 + 20, 100, 70);
        rect2.setStroke(Color.BLACK);
        rect2.setStrokeWidth(3);
        rect2.setFill(null);
        rect2.setArcHeight(20);
        rect2.setArcWidth(20);
        //adding it to the root group
        root.getChildren().add(rect2);
        
        //the shape created from the rectangle #ShapeTest 2-3
        Rectangle rect3 = new Rectangle(270, 0 + 20, 100, 70);
        rect3.setStroke(Color.BLACK);
        rect3.setStrokeWidth(3);
        rect3.setFill(null);
        rect3.setArcHeight(40);
        rect3.setArcWidth(70);
        //adding it to the root group
        root.getChildren().add(rect3);
        
        //the circle #ShapeTest 2-4
        Circle circ1 = new Circle(70, 200, 50);
        circ1.setFill(null);
        circ1.setStroke(Color.BLACK);
        circ1.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(circ1);
        
        //the ellipse #ShapeTest 2-5
        Ellipse ellipse1 = new Ellipse(200, 200, 50, 35);
        ellipse1.setStroke(Color.BLACK);
        ellipse1.setFill(null);
        ellipse1.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(ellipse1);

        //the second ellipse #ShapeTest 2-6
        Ellipse ellipse2 = new Ellipse(320, 200, 35, 50);
        ellipse2.setStroke(Color.BLACK);
        ellipse2.setFill(null);
        ellipse2.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(ellipse2);
        
        //the first arc #ShapeTest 2- 7
        Arc arc1 = new Arc(70, 380, 50, 50, 90, 90);
        arc1.setStroke(Color.BLACK);
        arc1.setFill(null);
        arc1.setStrokeWidth(3);
        arc1.setType(ArcType.OPEN);
        //adding it to the root group
        root.getChildren().add(arc1);
        
        //the third arc #ShapeTest 2-8
        Arc arc2 = new Arc(200, 380, 50, 50, 30, 120);
        arc2.setStroke(Color.BLACK);
        arc2.setFill(null);
        arc2.setStrokeWidth(3);
        arc2.setType(ArcType.CHORD);
        //adding it to the root group
        root.getChildren().add(arc2);
        
        //the third arc #ShapeTest 2-9
        Arc arc3 = new Arc(320, 380, 50, 50, 30, 120);
        arc3.setStroke(Color.BLACK);
        arc3.setFill(null);
        arc3.setStrokeWidth(3);
        arc3.setType(ArcType.ROUND);
        //adding it to the root group 
        root.getChildren().add(arc3);
        
        
        
        
        //the scene and the stage
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.show();
    
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
