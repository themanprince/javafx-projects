package scrollpanetest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.geometry.*;

public class ScrollPaneTest extends Application {

    //the tile pane
    TilePane tiles = new TilePane();
    
    //the scroll pane
    ScrollPane root = new ScrollPane();
    
    @Override
    public void start(Stage stage) {
    
        //customizing the tiles pane before adding the rectangles to it
        tiles.setHgap(20);
        tiles.setVgap(20);
        tiles.setPadding(new Insets(10, 10, 10, 10));
        tiles.setPrefColumns(2);
        
        //creating, customizing and adding rectangles to the tile pane
        for(int i = 0; i < 12; i++) {
            StackPane pane = new StackPane();
            Text text = new Text("Square " +(i + 1));
            Rectangle rect = new Rectangle(100, 100);
            rect.setFill(Color.BROWN);
            pane.getChildren().addAll(rect, text);
            
            tiles.getChildren().add(pane);
        }
    
        root.setContent(tiles);
        
        
        //the scene and the stage
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(280);
        stage.setHeight(300);
        stage.setResizable(false);
        stage.show();
        
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
