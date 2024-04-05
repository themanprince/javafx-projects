package theball;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TheBall extends Application {

    //the ball
    Circle theBall = new Circle(50, 50, 20);
    
    //the root group
    Group rootGroup = new Group();
    
    //the root pane
    VBox rootPane = new VBox();
    
    
    @Override
    public void start(Stage stage) {
        //customizing the ball
        theBall.setStroke(Color.BLACK);
        theBall.setStrokeWidth(1);
        
        
        //the fill for the ball
        RadialGradient rad = new RadialGradient(0, 0, 0.35, 0.35, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.ORANGE));
        theBall.setFill(rad);
        
        //tha animations
                RotateTransition rotateAnim = new RotateTransition(Duration.millis(1700), theBall);
                rotateAnim.setCycleCount(Animation.INDEFINITE);
                rotateAnim.setAutoReverse(false);
                rotateAnim.setInterpolator(Interpolator.LINEAR);
                rotateAnim.setFromAngle(0);
                rotateAnim.setToAngle(360);
                rotateAnim.play();
                
                
        // adding the ball to the root group
        rootGroup.getChildren().add(theBall);
        
        //adding the root group to the root pane
        rootPane.getChildren().add(rootGroup);
        
        


        //the finalties
        Scene theScene = new Scene(rootPane);
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
