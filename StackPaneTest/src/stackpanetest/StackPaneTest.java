package stackpanetest;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import java.util.Random;
import javafx.geometry.*;


public class StackPaneTest extends Application {

    //the stack pane
    Rectangle r1 = new Rectangle(400, 400);
    Text txt = new Text("Click the button to change my position");
    StackPane pane = new StackPane();
    
    //an array of random positions for moving the text
    Pos[] arr = new Pos[9];
    
    //the root pane
    Button click = new Button("Click Me!");
    VBox root = new VBox(15);
    
    
    @Override
    public void start(Stage stage) {
        
        //first filling the position array
        arr[0] = Pos.TOP_LEFT;
        arr[1] = Pos.TOP_CENTER;
        arr[2] = Pos.TOP_RIGHT;
        arr[3] = Pos.CENTER_LEFT;
        arr[4] = Pos.CENTER;
        arr[5] = Pos.CENTER_RIGHT;
        arr[6] = Pos.BOTTOM_LEFT;
        arr[7] = Pos.BOTTOM_CENTER;
        arr[8] = Pos.BOTTOM_RIGHT;
        
        //working on the stack pane elements before adding them to the stackpane
        r1.setFill(Color.LIGHTPINK);
        txt.setFont(new Font("Algerian", 12));
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(r1, txt);
        root.getChildren().add(pane);
        
        //the root pane and the button
        click.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Random rnd = new Random();
                pane.setAlignment(arr[rnd.nextInt(8)]);
            }
        });
        
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(click);
        
        //the stage and the scene
        Scene theScene = new Scene(root);
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(400);
        stage.setHeight(900);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
