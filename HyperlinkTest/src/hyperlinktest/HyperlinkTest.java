package hyperlinktest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.geometry.*;

public class HyperlinkTest extends Application {
    
    //the Hyperlinks
    Hyperlink link1Page1 = new Hyperlink("Next Page >"), link1Page2 = new Hyperlink("< Prev Page"), link2Page2 = new Hyperlink("Next Page >"), link1Page3 = new Hyperlink("< Prev Page");
    
    //the big texts 
    Text text1 = new Text("Page One"), text2 = new Text("Page Two"), text3 = new Text("Page Three");
    
    //the three panes that represent the three pages
    VBox page1 = new VBox(), page2 = new VBox(), page3 = new VBox();
    
    
    //reference to the scene
    Scene theSceneRef;
    
    //the pages' spacing 
    int pageSpacing = 60;
    
  
    
    @Override
    public void start(Stage stage) {
        //the scene
        Scene theScene = new Scene(page1);
        theSceneRef = theScene;
        
        //customizing the first page
        text1.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.ORANGE), new Stop(0.5, Color.YELLOW)));
        text1.setFont(new Font(13));
        text1.setStyle("-fx-font-size: 30px;"
                + "-fx-font-family: algerian;");
        
        //customizng the first page pane
        page1.setSpacing(pageSpacing);
        page1.setAlignment(Pos.CENTER);
        
        //adding the hyperlink's action shit
        link1Page1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theSceneRef.setRoot(page2);
            }
        });
        
        
        //adding them to the first page
        page1.getChildren().addAll(text1, link1Page1);
        
        
        
        //the second page
        page2.setSpacing(pageSpacing);
        page2.setAlignment(Pos.CENTER);
        
        //customizing the second page's text
        text2.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.BLUE), new Stop(0.5, Color.GREEN)));
        text2.setStyle("-fx-font-size: 30px;"
                + "-fx-font-family: algerian;");
        
        //the hyperlinks
        link1Page2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theSceneRef.setRoot(page1);
            }
        });
        link2Page2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theSceneRef.setRoot(page3);
            }
        });
        //their pane
        HBox theyPane2 = new HBox();
        theyPane2.setSpacing(20);
        theyPane2.setAlignment(Pos.CENTER);
        theyPane2.getChildren().addAll(link1Page2, link2Page2);
        
        //filling the second page
        page2.getChildren().addAll(text2, theyPane2);
        
        
        
        //the third page
        page3.setSpacing(pageSpacing);
        page3.setAlignment(Pos.CENTER);
        
        //customizing the text for the third page
        text3.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.AQUA), new Stop(0.5, Color.BROWN)));
        text3.setStyle("-fx-font-size: 30px;"
                + "-fx-font-family: algerian;");
        
        
        //customizing the links
        link1Page3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theSceneRef.setRoot(page2);
            }
        });
        
        //filling the third page
        page3.getChildren().addAll(text3, link1Page3);
        
        
        
        
        
        
        
        
        //the finalties
        theScene.setRoot(page1);
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
