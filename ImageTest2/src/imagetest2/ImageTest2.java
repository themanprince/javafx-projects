package imagetest2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.effect.*;

public class ImageTest2 extends Application {
    
    //the image
    Image img1 = new Image("file:C:\\Users\\PST JUDE\\Pictures\\2in1 Turbo C++ & .NET Framework (2).png", 400, 400, true, false, true);
    //the image view
    ImageView img1View = new ImageView(img1), img2View = new ImageView(img1);
    
    
    //the root pane
    VBox root = new VBox();
    
    @Override
    public void start(Stage stage) {
        //customizing the image view before adding it to the root pane
        img2View.setRotate(270);
        img1View.setRotate(270);
        Glow img1Glow = new Glow();
        img1Glow.setLevel(0.4);
        Bloom img1Bloom = new Bloom();
        img1Bloom.setThreshold(0.6);
        //adding the two effects together\
        img1Glow.setInput(img1Bloom);
        //adding the efects to the image
        img1View.setEffect(img1Glow);
        
        //customizing the root pane before adding the imagae to it
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        
        //adding the image to the root  pane
        root.getChildren().addAll(img2View, img1View);
        
        
        //the finalties
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setTitle("The second one has glow");
        stage.setWidth(400);
        stage.setHeight(900);
        stage.setResizable(false);
        stage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
