package gridpanetest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.geometry.*;


public class GridPaneTest extends Application {

    //the grid pane
    GridPane root = new GridPane();
    
    
    @Override
    public void start(Stage stage) {
//customizing the grid pane before adding elements to it
        root.setHgap(20);
        root.setVgap(20);
        root.setPadding(new Insets(20, 20, 20, 20));
        
        //manually adding the rows of rectangles to the grid pane
        Rectangle rect1 = new Rectangle(20, 20), rect2 = new Rectangle(100, 20), rect3 = new Rectangle(20, 20), rect4 = new Rectangle(100, 20), rect5 = new Rectangle(20, 20), rect6 = new Rectangle(100, 20);
        rect1.setFill(Color.CORNFLOWERBLUE);
        rect2.setFill(Color.CORNFLOWERBLUE);
        rect3.setFill(Color.CORNFLOWERBLUE);
        rect4.setFill(Color.CORNFLOWERBLUE);
        rect5.setFill(Color.CORNFLOWERBLUE);
        rect6.setFill(Color.CORNFLOWERBLUE);
           
        root.add(rect1, 0, 0);
        root.add(rect2, 1, 0);
        root.add(rect4, 0, 1, 6, 1);
        root.add(rect3, 1, 1);
        root.add(rect5, 0, 2);
        root.add(rect6, 1, 2);
        
        
        
        
        //customizing the scene and stage
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
