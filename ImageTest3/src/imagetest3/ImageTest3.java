package imagetest3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.image.*;

public class ImageTest3 extends Application {
    
    //the file's path
    private final String path = "C:\\Users\\PST JUDE\\Pictures";
    
    @Override
    public void start(Stage stage) {
    //the tile pane
        TilePane theTile = new TilePane();
        theTile.setVgap(10);
        theTile.setHgap(15);
        
    //the file object of the directory
        File dir = new File(path);
        
        //making file objects of all the images in the pictures directory
        File[] allFiles = dir.listFiles();
        
        ///using a loop to add all the 
    //images in the file path to the tile pane
        for(File file: allFiles) {
            Image img = new Image(file.toURI().toString(), 200, 200, true, false, true);
            ImageView imgView = new ImageView(img);
            
            //adding it to the tile pane
            theTile.getChildren().add(imgView);
        }
        
        //the scroll pane
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(theTile);
        
        
        //the finalties
        Scene theScene = new Scene(theTile);
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
