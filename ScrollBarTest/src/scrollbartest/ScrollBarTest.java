package scrollbartest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.stage.Stage;
import java.io.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.event.*;

public class ScrollBarTest extends Application {
    
    //the audio
    Media theMedia = new Media(new File("C:\\Users\\Public\\Music\\Sample Music\\Sleep Away.mp3").toURI().toString());
    MediaPlayer thePlayer = new MediaPlayer(theMedia);
    
    //the scroll bar
    ScrollBar theBar = new ScrollBar();
    
    //the root pane
    VBox root = new VBox();
    
    //the label
    Label theLab = new Label(" Volume - 10");
    
    //the buttons and their pane
    Button play = new Button("Play"), stop = new Button("Stop");
    HBox btnPane = new HBox();
    
    
    @Override
    public void start(Stage stage) {
        //the buttons
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(play.getText().equals("Play")) {
                thePlayer.play();
                play.setText("Restart");
                }else if(play.getText().equals("Restart")) {
                thePlayer.stop();
                thePlayer.play();
                }
            }
        });
        stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                thePlayer.stop();
                play.setText("Play");
            }
        });
        btnPane.setSpacing(30);
        btnPane.setAlignment(Pos.CENTER);
        btnPane.getChildren().addAll(play, stop);
        
        
        //customizing the scroll bar
        theBar.setOrientation(Orientation.VERTICAL);
        theBar.setRotate(180);
        theBar.setPrefWidth(20);
        theBar.setPrefHeight(300);
        theBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> value, Number oldValue, Number newValue) {
            thePlayer.setVolume(newValue.intValue());
            theLab.setText("Volume - " + newValue.intValue());
            }
        });
        theBar.setValue(10);
        
        
        //customizing the root pane
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        
        root.getChildren().addAll(theBar, theLab, btnPane);
        
        
        
        //the finalties
        Scene theScene = new Scene(root);
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
