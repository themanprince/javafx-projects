package imagetest1;

import java.util.HashSet;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ImageTest1 extends Application {
    
    //the label
    Label theLabel = new Label("I'm Denzel Fucking Washington!!");
    //The Image object 
    Image img1 = new Image("file:C:\\Users\\PST JUDE\\Pictures\\2in1 Turbo C++ & .NET Framework (3).png", 400, 400, true, false, true); 
    //the image view object
    ImageView imgView = new ImageView(img1);
    
    //the root pane
    StackPane root = new StackPane();
    @Override
    public void start(Stage stage) {
    //customizng the root pane
        root.setAlignment(Pos.BASELINE_CENTER);
        
        //cutomizing the label
        theLabel.setStyle("-fx-font-size: 15px");
        
        //adding the image and the label to the root pane
        root.getChildren().addAll(imgView, theLabel);
        
        
        //the finalties
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.setTitle("Denzel Washington");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
