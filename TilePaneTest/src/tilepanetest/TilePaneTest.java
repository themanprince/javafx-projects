package tilepanetest;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.geometry.*;

public class TilePaneTest extends Application {
    
    //the tile pane
    TilePane tiles = new TilePane();
    
    
    @Override
    public void start(Stage stage) {
//working on the tile pane before adding the rectangle to it
        tiles.setOrientation(Orientation.HORIZONTAL);
        tiles.setAlignment(Pos.CENTER_LEFT);
        tiles.setPrefRows(4);
        tiles.setPrefColumns(4);
        
        //creating and adding the rectangles to the tilepane
        for(int i = 0; i < 12; i++) {
            Rectangle rect = new Rectangle(100, 100);
            rect.setFill(Color.DARKGOLDENROD);
            Text text = new Text("Square " + (i + 1));
            
            StackPane pane = new StackPane();
            pane.setPadding(new Insets(10, 10, 10, 10));
            pane.setAlignment(Pos.CENTER);
            pane.getChildren().addAll(rect, text);
            
            tiles.getChildren().add(pane);
        }
        
        //the scene and the stage
        Scene theScene = new Scene(tiles);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setY(20);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
