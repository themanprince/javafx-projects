package randsong;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.util.Random;
import javafx.scene.media.*;
import javafx.geometry.*;

public class RandSong extends Application {
    
    //the text field
    TextField theUrl = new TextField();
    
    //the buttons
    Button play = new Button("START"), stop = new Button("STOP");
    
    //the label for console output
    Label console = new Label("You can connect your phone or \n any other audio device and supply the \n url to the music folder\n in the textfield below, then press \n start to play a random song from it");
    
    //the root pane
    VBox root = new VBox();
    
    //reference to the media player
    MediaPlayer mpRef;
    
    
    
    @Override
    public void start(Stage stage) {
        //customizing the root pane
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        
        //adding the console label to the root pane first
        root.getChildren().add(console);

        
        //the string of the url text field
        theUrl.setText("C:\\Users\\Public\\Music\\Sample Music");
        //adding the event handler for the button
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                console.setText("...");
                //first, making a file object of the specified folder
                try{
                File file = new File(theUrl.getText());
                File[] fileList = file.listFiles();
                //next, getting the random file to be played
                File theRandomFile = fileList[(new Random()).nextInt(fileList.length - 1)];
                //making the media object and playing it
                Media theMedia = new Media(theRandomFile.toURI().toString());
                MediaPlayer theMediaPlayer = new MediaPlayer(theMedia);
                mpRef = theMediaPlayer;
                theMediaPlayer.play();
                console.setText("Playing " +theRandomFile.getName());
                }catch(MediaException f) {
                    console.setText("Error in Loading.. Press \"Start\" again please.. :D");
                }
            }
        });
        //the stop button's handler
        stop.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                mpRef.stop();
            }
        });
        //an hbox for the text field and the button
        HBox tfAB = new HBox();
        tfAB.setSpacing(10);
        tfAB.setAlignment(Pos.CENTER);
        //adding them
        tfAB.getChildren().addAll(theUrl, play , stop);
        //adding it to the root pane
        root.getChildren().add(tfAB);
        
        
        
        
        //the finalties
        Scene theScene = new Scene(root);
        theScene.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
        stage.setScene(theScene);
        stage.setTitle("RandSng");
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
