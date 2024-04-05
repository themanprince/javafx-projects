package texttest1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.*;
import javafx.scene.paint.*;

public class TextTest1 extends Application {


    //the root group
    Group root = new Group();

      //the text
      Text text = new Text("Hello World!!!");
      
      //the linear gradient fill for the text
      LinearGradient lin1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.RED), new Stop(0.5, Color.YELLOW));

      
    @Override
    public void start(Stage stage) {
    //customizing the text
    text.setFont(new Font("Times New Roman", 100));
    text.setFill(lin1);
    text.setX(0);
    text.setY(100);
    text.setStroke(Color.BLACK);
    text.setStrokeWidth(3);
    //adding it to the root group
    root.getChildren().add(text);
    
    
    
    //the scene and the stage
    Scene theScene = new Scene(root);
    stage.setScene(theScene);
    stage.setX(900);
    stage.setWidth(600);
    stage.setTitle("Text Test 1");
    stage.setHeight(300);
    stage.setResizable(false);
    stage.show();
    
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
