package vidx;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.media.*;
import javafx.geometry.*;
import javafx.scene.effect.*;
import java.io.*;

public class VidX extends Application {
    
    //the Label
    Label lab = new Label("Change the textfield's text to the url of the video \n you want to play and press \"play\" ");
    
    //the buttons 
    Button play = new Button("Play"), stop = new Button("Stop Playing"), shadow = new Button("Shadow"), glowAndBloom = new Button("Glow and Bloom"), perspective = new Button("Perspective"), gausBlur = new Button("Blur"), reflection = new Button("Reflection");
    
    //the textfield
    TextField urlFld = new TextField("C:\\Users\\Public\\Videos\\Sample Videos\\Best%20Of%20Crazeclown-Comedy%20Compilation!_Ot-FNGUMAz4_240p.mp4");
    
    //the root pane
    VBox root = new VBox();
    
    //reference to the media pkayer and the media view
    MediaPlayer medRef;
    MediaView medView;
		
		//the intermediary vbox for my label and controls
		VBox inter = new VBox();
		
    //the scroll pane
    ScrollPane scroll = new ScrollPane();
    
    
    @Override
    public void start(Stage stage) {
        //customizing the intermediary pane
        inter.setAlignment(Pos.CENTER);
        
        //customizing the root pane first
        root.setSpacing(150);
        root.setAlignment(Pos.CENTER);
        
    //working on the buttons before adding them to the scene
        //adding a event handler to the start button
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //removing any old video
                if(root.getChildren().get(0).equals(medView)) {
                    root.getChildren().remove(0);
                    lab.setText("Press Play Again");
                }else{
                
            //creating the video view if and only if the textfield is not empty and is valid
                if(urlFld.getText() == "") {
                    lab.setText("The textfield is empty >:(");
                }else{
                    //meaning its not empty
                    try{
                        Media theMedia = new Media((new File(urlFld.getText())).toURI().toString());
                        MediaPlayer theMediaPlayer = new MediaPlayer(theMedia);
                        theMediaPlayer.setAutoPlay(true);
                        MediaView theMediaView = new MediaView(theMediaPlayer);
                        //customizing thr media view
                        theMediaView.setFitHeight(350);
                        theMediaView.setFitWidth(350);
                        
                        //the references
                        medRef = theMediaPlayer;
                        medView = theMediaView;
                        
                        //adding the media view to the root pane
                        
                        //clearing the root pane
                        for(int i = 0; i < root.getChildren().size() - 1; i++) {
                            root.getChildren().set(i, null);
                        }
                        
                        root.getChildren().set(0, theMediaView);
                        //filling the other indexes
                        root.getChildren().add(inter);
                        
                    }catch(MediaException f){
                        lab.setText("unable to load the video, check the url/extension \n and try again...");
                    }
                }
                }
            }
        });
        
        //the event handler for the stop button
        stop.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            try{
            //stopping the current pkaying media using its reference
        medRef.stop();
            }catch(NullPointerException f) {
                lab.setText("There is no video playing!");
            }
        }
        });
        
        //the event handler for the shadow butotn
			shadow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
                         try{   
                            DropShadow theShad = new DropShadow();
				theShad.setOffsetX(17);
				theShad.setOffsetY(17);
				theShad.setWidth(20);
				theShad.setHeight(20);
				
				//adding the shadow to the video
				medView.setEffect(theShad);
			            }catch(NullPointerException f) {
                lab.setText("There is no video playing!");
            }

                         }
			});
                        
          //the event handler for the glowAndBloom button
                        glowAndBloom.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                try{
                                Glow theGlow = new Glow();
                                theGlow.setLevel(0.4);
                                //the bloom
                               Bloom theBloom = new Bloom();
                               theBloom.setThreshold(0.4);
                               theGlow.setInput(theBloom);
                               
                               //adding to the video
                               medView.setEffect(theGlow);
                                           }catch(NullPointerException f) {
                lab.setText("There is no video playing!");
            }

                                }
                        });
                        
           //the event handler for the perspective button
                        perspective.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                try{
                                PerspectiveTransform thePerspective = new PerspectiveTransform();
                                thePerspective.setUlx(0);
                                thePerspective.setUly(20);
                                thePerspective.setUrx(310);
                                thePerspective.setUry(20);
                                thePerspective.setLlx(40);
                                thePerspective.setLly(310);
                                thePerspective.setLrx(350);
                                thePerspective.setLry(310);
                                //adding it
                                medView.setEffect(thePerspective);
                                            }catch(NullPointerException f) {
                lab.setText("There is no video playing!");
            }

                                }
                        });
                        
                        //the event handler for the gaussian blur
                        gausBlur.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                try{
                                GaussianBlur theBlur = new GaussianBlur();
                                theBlur.setRadius(10);
                                
                                //adding it
                                medView.setEffect(theBlur);
                                            }catch(NullPointerException f) {
                lab.setText("There is no video playing!");
            }

                                }
                        });
                        
                        //the event handler for the reflection button
                        reflection.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                try{
                                Reflection theReflection = new Reflection();
                                theReflection.setTopOffset(5);
                                theReflection.setTopOpacity(0.2);
                                theReflection.setBottomOpacity(0.2);
                                theReflection.setFraction(0.86);
                                
                                //adding it
                                medView.setEffect(theReflection);
                                            }catch(NullPointerException f) {
                lab.setText("There is no video playing!");
            }

                                }
                        });
                        
       //the hbox for the textfield and buttons
                        HBox TAB = new HBox();
                        TAB.setSpacing(10);
                        TAB.getChildren().addAll(urlFld, play, stop, perspective, shadow, reflection, gausBlur, glowAndBloom);
                        
                        //adding them to the intermediary vbox
                        inter.getChildren().addAll(lab, TAB);
                        
                        //adding it to the root pane
                        root.getChildren().add(inter);
                        
                        
                        
                        
    //the finalties
          scroll.setContent(root);
          Scene theScene = new Scene(scroll);
          theScene.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
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
