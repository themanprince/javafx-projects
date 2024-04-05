package changelistenertest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.beans.value.*;
import javafx.geometry.*;

public class ChangeListenerTest extends Application {

    //the circle shape
    Circle circ1 = new Circle(100, 100, 100);
    //the root group
    Group rootGroup = new Group();
    //the root pane
    VBox root = new VBox();
    
    
    @Override
    public void start(Stage stage) {
        //customizing the circle
        circ1.setFill(Color.PINK);
        circ1.setStroke(Color.BLACK);
        circ1.setStrokeWidth(3);
        //adding the circle to the root group
        rootGroup.getChildren().add(circ1);
        //adding the root group to the root pane
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(rootGroup);
     
        
        
        
        //the finalties
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setTitle("Resize the window to see what happens");
        stage.setWidth(400);
        stage.setHeight(500);
                //the change listeners
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> value, Number oldValue, Number newValue) {
            //if the width of the window is increased, reduce the width of the circle by the same amount
                if(newValue.doubleValue() > oldValue.doubleValue()) {
                //means that the window has increased in size
                    circ1.setRadius(circ1.getRadius() - (newValue.doubleValue() - oldValue.doubleValue()));
                }else if(newValue.doubleValue() < oldValue.doubleValue()) /*this means the window has reduced in size, the circle should be increased by the same amount*/ {
                    circ1.setRadius(circ1.getRadius() + (oldValue.doubleValue() - newValue.doubleValue()));
            }
            }
        });
        
        stage.heightProperty().addListener(new ChangeListener<Number>() {
          @Override
            public void changed(ObservableValue<? extends Number> value, Number oldValue, Number newValue) {
                //if the window has increased on height the circle should reduce in radius by the same amount
                if(newValue.doubleValue() > oldValue.doubleValue()) {
                circ1.setRadius(circ1.getRadius() - (newValue.doubleValue() - oldValue.doubleValue()));
                }else if(newValue.doubleValue() < oldValue.doubleValue()) /*this means the window has reduced in size, the circle should increase by the same amount*/ {
                    circ1.setRadius(circ1.getRadius() + (oldValue.doubleValue() - newValue.doubleValue()));
            }
            }
        });

        stage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
