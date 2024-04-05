package paralleltranstest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.animation.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.*;

public class ParallelTransTest extends Application {
    
    //The ball
    Circle theBall = new Circle(200, 250, 100);
    
    //the fill for the ball
    RadialGradient theRad = new RadialGradient(0, 0, 0.35, 0.35, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.GOLD));
    
    //the root group
    Group rootGroup = new Group();
    
    //the root pane
    VBox rootPane = new VBox();
    
    
    @Override
    public void start(Stage stage) {
        //customizing the ball(fill and anuimations)
        theBall.setFill(theRad);
        
        
        //the animations
        RotateTransition rot = new RotateTransition(Duration.millis(2000), theBall);
        rot.setFromAngle(0);
        rot.setToAngle(360);
        rot.setCycleCount(Animation.INDEFINITE);
        rot.setInterpolator(Interpolator.LINEAR);
        
        //the fade transition
        FadeTransition fad = new FadeTransition(Duration.millis(6000), theBall);
        fad.setFromValue(1);
        fad.setToValue(0.2);
        fad.setAutoReverse(true);
        fad.setCycleCount(Animation.INDEFINITE);
        fad.setInterpolator(Interpolator.LINEAR);
        
        
        
        //the parallel transition object to combine both of them
        ParallelTransition thePar = new ParallelTransition(rot, fad);
        thePar.play();
        
        
        //the refelction effect
        Reflection theRef = new Reflection();
        theRef.setFraction(0.7);
        theRef.setTopOpacity(1);
        theRef.setBottomOpacity(0.3);
        //adding it
        theBall.setEffect(theRef);

        
        
        //adding the ball to the root group
        rootGroup.getChildren().add(theBall);
        //adding the root group to the root pane
        rootPane.setAlignment(Pos.CENTER);
        rootPane.getChildren().add(rootGroup);
        
        
        //the finalties
        Scene theScene = new Scene(rootPane);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setTitle("Wait at least 8 seconds");
        stage.setWidth(400);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
