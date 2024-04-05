/*
NOTE: - THE IDEA TO USE DIFFERENT COLORS ON THE CIRCLES WAS
PRECIOUS' IDEA.
*/
package thecircles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.geometry.*;
import javafx.beans.value.*;

public class TheCircles extends Application {
    
    //the two circles
    Circle circ1 = new Circle(100, 100, 100), circ2 = new Circle(100, 100, 100);
    
    //the root group
    Group rootGroup = new Group();
    
    //the root pane
    VBox root = new VBox();
    
    
    @Override
    public void start(Stage stage) {
        //customizing the root pane
        root.setAlignment(Pos.CENTER);
        
        
        //customizing the circles
        circ1.setStroke(Color.BLACK);
        circ1.setStrokeWidth(3);
        circ1.setOpacity(0.5);
        circ1.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.REPEAT, new Stop(0, Color.PINK), new Stop(0.2, Color.AQUA), new Stop(0.4, Color.RED), new Stop(0.6, Color.BLUE), new Stop(0.8, Color.PURPLE)));
        circ2.setStroke(Color.BLACK);
        circ2.setStrokeWidth(3);
        circ2.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.REPEAT, new Stop(0, Color.GREEN), new Stop(0.2, Color.CYAN), new Stop(0.4 , Color.DARKBLUE), new Stop(0.6, Color.YELLOW), new Stop(0.8, Color.ORANGE)));
        //adding the circles to the root group
        rootGroup.getChildren().addAll(circ2, circ1);
        //adding the root group to the root pane
        root.getChildren().add(rootGroup);
        
        
        //the finalties
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(400);
        //binding the stage width and eight properties to the circles' radius
        //with a change listener such that if the size of the stage
        /*increases, the size of one circle increases and the other increases
        and if it decreases, then vice versa*/
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> value, Number oldValue, Number newValue) {
                if(newValue.doubleValue() > oldValue.doubleValue()) {
                //then the stage has increased in width
                    //circle one will reduce by the same amount
                    circ1.setRadius(circ1.getRadius() - (newValue.doubleValue() - oldValue.doubleValue()));
                    //while circle two will increase by the same amount
                    circ2.setRadius(circ2.getRadius() + (newValue.doubleValue() - oldValue.doubleValue()));
                }else if(newValue.doubleValue() < oldValue.doubleValue()) /*the stage has reduced in width*/{
                    //circle one will incrase by the same amount
                    circ1.setRadius(circ1.getRadius() + (oldValue.doubleValue() - newValue.doubleValue()));
                    //while circle two will reduce by the same amount
                    circ2.setRadius(circ2.getRadius() - (oldValue.doubleValue() - newValue.doubleValue()));
                }
            }
        });
        
        //the reverse is the case for the height property
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> value, Number oldValue, Number newValue) {
                if(newValue.doubleValue() > oldValue.doubleValue()) {
                    //then the stage has increased in height
                    //circle one will increase by the same amount
                    circ1.setRadius(circ1.getRadius() + (newValue.doubleValue() - oldValue.doubleValue()));
                    //while circle two will reduce by the same amount
                    circ2.setRadius(circ2.getRadius() - (newValue.doubleValue() - oldValue.doubleValue()));
                }else if(newValue.doubleValue() < oldValue.doubleValue()) /*this means the stage has reduced in height*/ {
                    //circle one will reduce by the same amount
                    circ1.setRadius(circ1.getRadius() - (oldValue.doubleValue() - newValue.doubleValue()));
                    //circle two will increase by the same amount
                    circ2.setRadius(circ2.getRadius() + (oldValue.doubleValue() - newValue.doubleValue()));
                }
            }
        });
        stage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
