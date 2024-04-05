package theball2;

import javafx.application.Application;
import javafx.event.*;
import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.util.*;

public class TheBall2 extends Application {
    
    //The ball
    Circle theBall = new Circle(0, 0, 20);
    //the radial gradient
    RadialGradient rad = new RadialGradient(0, 0, 0.35, 0.35, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.BLUE));
    
    //the root group
    Group rootGroup = new Group();
    
    //the root pane
    VBox rootPane = new VBox();
    
    
    //the fields for the required stage's data
    private final Integer stageWidth = 400;
    private final Integer stageHeight = 500;
	private Integer ballSpeedX = 20;
	private Integer ballSpeedY = 20;

    @Override
    public void start(Stage stage) {
        //customizing the ball before adding it to the root group
        theBall.setFill(rad);
        
                //the animation part
			KeyFrame k = new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
                            
                            @Override
                                public void handle(ActionEvent e) {
			theBall.setCenterX(theBall.getCenterX() + ballSpeedX);
			theBall.setCenterY(theBall.getCenterY() + ballSpeedY);

			//checking the if the ball has passed its limits to reverse it
			if(theBall.getCenterX() < theBall.getRadius() || theBall.getCenterX() > (stageWidth - theBall.getRadius())) {
			//inverting the ball speed (direction)
			ballSpeedX = -ballSpeedX;
			}else if(theBall.getCenterY() < theBall.getRadius() || theBall.getCenterY() > (stageHeight - theBall.getRadius())) {
			//inverting the ball speed (direction)
			ballSpeedY = -ballSpeedY;
                        }
			}
			});
			
			
			Timeline theTimeLine = new Timeline();
			theTimeLine.getKeyFrames().add(k);
			theTimeLine.setCycleCount(Timeline.INDEFINITE);
			theTimeLine.play();
                        
			
			
			
			//adding the ball to the root group
			rootGroup.getChildren().add(theBall);
			
			
			
			
			
			//the finalties
			Scene theScene = new Scene(rootGroup);
			stage.setScene(theScene);
			stage.setX(900);
			stage.setWidth(stageWidth);
			stage.setHeight(stageHeight);
			stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
