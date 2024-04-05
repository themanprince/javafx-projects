package timnt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.animation.*;
import javafx.scene.text.*;
import javafx.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;

public class TimNT extends Application {
    
    //the text
    Text theText = new Text("TimNT");
    
    //the label for the next header text
     Label theLab = new Label("");
     String theLabText = "We Gon' do it differently...";

    //the animation
    KeyFrame theKeyFrame = new KeyFrame(Duration.millis(800), new theHandler());
    Timeline theTimeline = new Timeline();
    
    //the root pane
    VBox root = new VBox();
    
     //the variable for the text's font size. need it for something else later
     double theCurrentFontSize;
     
     //the pane for the header texts
     VBox headerPane = new VBox();
          
     
     
    
    
    @Override
    public void start(Stage stage) {
        theCurrentFontSize = theText.getFont().getSize();
        
        //customizing the headerPane
        headerPane.setAlignment(Pos.TOP_RIGHT);
        headerPane.getChildren().addAll(theText, theLab);
        
        //customizing theLab
        theLab.setFont(new Font(15));
        
        //customizing the root pane
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setSpacing(30);
        
        //customizing the text
        theText.setFill(new RadialGradient(0, 0, 0.2, 0.2, 0.4, true, CycleMethod.NO_CYCLE, new Stop(0.2, Color.WHITE), new Stop(0.5, Color.ORANGE)));
        
        
        //the animation
        theTimeline.getKeyFrames().add(theKeyFrame);
        theTimeline.setCycleCount(5);
        theTimeline.play();
        
    
    //sdding them to the root pane
    root.getChildren().add(headerPane);
    
    
    //the finalties
    ScrollPane theScroll = new ScrollPane();
    theScroll.setContent(root);
    Scene theScene = new Scene(theScroll);
    stage.setScene(theScene);
    stage.setX(900);
    stage.setY(10);
    stage.setWidth(400);
    stage.setHeight(500);
    stage.setResizable(false);
    stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
class theHandler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent e) {
                    theText.setFont(new Font(theText.getFont().getSize() + 20));
                    if(theText.getFont().getSize() == (theCurrentFontSize + 100)) {
                        //the animation to add the next header text
                        KeyFrame ht = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                theLab.setText(theLab.getText() + theLabText.charAt(theLab.getText().length()));
                            }
                        });
                        Timeline tm = new Timeline();
                        tm.getKeyFrames().add(ht);
                        tm.setCycleCount(theLabText.length());
                        tm.play();
                    }
    }
}
}


