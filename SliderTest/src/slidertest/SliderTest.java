package slidertest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.stage.Stage;
import java.io.*;
import javafx.geometry.*;
import javafx.beans.value.*;

public class SliderTest extends Application {
    
    Media problems = new Media((new File("C:\\Users\\Public\\Music\\Sample Music\\Problems_-_TrapNew_School_Instrumental_Beat.3gp").toURI().toString()));
    MediaPlayer thePlayer = new MediaPlayer(problems);
    
    //the slider
    Slider theSlider = new Slider();
    //the label
    Label volumeLab = new Label("Volume - 10");
    
    //the root pane
    VBox root = new VBox();
    
    @Override
    public void start(Stage stage) {
        thePlayer.setVolume(10);
        
        theSlider.setOrientation(Orientation.HORIZONTAL);
        theSlider.setValue(10);
        theSlider.setShowTickLabels(false);
        theSlider.setMax(100);
        theSlider.setMin(0);
        theSlider.setShowTickMarks(false);
        theSlider.setPrefWidth(300);
        theSlider.valueProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> value, Number oldVlaue, Number newValue) {
        thePlayer.setVolume(newValue.intValue());
        volumeLab.setText("Volume - " + newValue.intValue());
        }
        });
        
        //customizing the root pane before adding
        //to it
        root.setSpacing(30);
        root.setAlignment(Pos.CENTER);
        
        
        root.getChildren().addAll(theSlider, volumeLab);
        thePlayer.play();
        
        
        
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
