package bouncingballs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.util.*;

public class BouncingBalls extends Application {
		//the balls array list
		ArrayList<Ball> theBalls;
		
		//the root group
		Group rootGroup = new Group();
			
    @Override
    public void start(Stage stage) {
    //initialising the balls array
    theBalls = new ArrayList<Ball>();
    
    //filling it
    for(int i = 0; i < 12; i++) {
    theBalls.add(new Ball(20, 400, 500, theBalls));
    }
    
    //adding the animation to the balls before adding them to the root group
    KeyFrame k = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
    for(int i = 0; i < theBalls.size(); i++) {
    theBalls.get(i).move();
    }
    }
    });
    
    Timeline T = new Timeline();
    T.getKeyFrames().add(k);
    T.setCycleCount(Timeline.INDEFINITE);
    T.play();
    
    
    
    //adding the balls to the root group
    for(int i = 0; i < theBalls.size(); i++) {
    rootGroup.getChildren().add(theBalls.get(i));
    }
    
    
    //the finalties
    Scene theScene = new Scene(rootGroup);
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
