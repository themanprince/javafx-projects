package colorshadez;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class ColorShadez extends Application {
    
    //reference to the scene
    Scene theScene;
    
    //the radio buttons for the "green pane"
    RadioButton lightGreen = new RadioButton("Light Green"), normGreen = new RadioButton("Normal Green"), darkGreen = new RadioButton("DarkGreen");
    //the togglegroup
    ToggleGroup tGroup1 = new ToggleGroup();
    //the title pane
    TitledPane greenPane = new TitledPane();
    
    
    //the radio buttons for the "blue pane"
    RadioButton lightBlue = new RadioButton("Light Blue"), normBlue = new RadioButton("Normal Blue"), darkBlue = new RadioButton("Dark Blue");
    //the togglegroup
    ToggleGroup tGroup2 = new ToggleGroup();
    //the title pane
    TitledPane bluePane = new TitledPane();
    
    
    //the radio buttons for the "yellow pane"
    RadioButton lightPink = new RadioButton("Light Pink"), normPink = new RadioButton("Normal Pink"), darkPink = new RadioButton("Dark Pink");
    //the toggle pane
    ToggleGroup tGroup3 = new ToggleGroup();
    //the title pane
    TitledPane pinkPane = new TitledPane();
    
   
    //the radio buttons for the "grey pane"
    RadioButton lightGrey = new RadioButton("Light Grrey"), normGrey = new RadioButton("Normal Grey"), darkGrey = new RadioButton("Dark Grey");
    //the toggle pane
    ToggleGroup tGroup4 = new ToggleGroup();
    //the title pane
    TitledPane greyPane = new TitledPane();
    
    
    //the radio buttons for the "golden rod yellow pane"
    RadioButton lightGoldenRodYellow = new RadioButton("Light Golden Rod Yellow"), normGoldenRodYellow = new RadioButton("Normal Golden Rod Yellow"), darkGoldenRodYellow = new RadioButton("Dark Golden Rod Yellow");
    //the toggle pane
    ToggleGroup tGroup5 = new ToggleGroup();
    //the title pane
    TitledPane goldenRodYellowPane = new TitledPane();
    
 
    //the radio buttons for the "coral pane"
    RadioButton lightCoral = new RadioButton("Light Coral"), normCoral = new RadioButton("Normal Coral"), darkCoral = new RadioButton("Dark Coral");
    //the toggle pane
    ToggleGroup tGroup6 = new ToggleGroup();
    //the title pane
    TitledPane coralPane = new TitledPane();
 
    
    
    //the root title pane
    TitledPane rootTit = new TitledPane();
    
    //the two accordions
    Accordion accord1 = new Accordion(), accord2 = new Accordion();
    
    //the root hbox
    HBox rootHBox = new HBox();
    
    //reference to the stage
    Stage stageRef;
    
    @Override
    public void start(Stage stage) {
        stageRef = stage;
		//adding the event listeners to all the radio buttons... phewww... work!... thank you Ctrl+C and Ctrl+v
		lightGreen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: lightGreen ");
			}
		});
		normGreen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: green");
			}
		});
		darkGreen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: darkGreen");
			}
		});
		
		
		lightBlue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: lightBlue");
			}
		});
		normBlue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: blue");
			}
		});
		darkBlue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: darkBlue");
			}
		});
		
		
		lightPink.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: lightPink");
			}
		});
		normPink.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: pink");
			}
		});
		darkPink.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: pink");
                                stageRef.setTitle("no dark pink :D");
			}
		});
		
		
		lightGrey.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: lightGrey");
			}
		});
		normGrey.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: grey");
			}
		});
		darkGrey.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: darkGrey");
			}
		});
		
		
		lightGoldenRodYellow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: lightYellow");
			}
		});
		normGoldenRodYellow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: yellow");
			}
		});
		darkGoldenRodYellow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: yellow");
                     stageRef.setTitle("No Dark Golden Rod Yellow :D");
			}
		});
		
		
		lightCoral.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: lightCoral");
			}
		});
		normCoral.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: coral");
			}
		});
		darkCoral.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				rootHBox.setStyle("-fx-background-color: coral");
                                stageRef.setTitle("No Dark Coral :D");
			}
		});
		
		
		
		
		
    
        tGroup1.getToggles().addAll(lightGreen, normGreen, darkGreen);
        //adding them to the title pane
        VBox pane1 = new VBox();
        pane1.setSpacing(15);
        pane1.getChildren().addAll(lightGreen, normGreen, darkGreen);
        greenPane.setText("Green");
        greenPane.setContent(pane1);
        
        
        tGroup2.getToggles().addAll(lightBlue, normBlue, darkBlue);
        //adding them to the title pane
        VBox pane2 = new VBox();
        pane2.setSpacing(15);
        pane2.getChildren().addAll(lightBlue, normBlue, darkBlue);
        bluePane.setText("Blue");
        bluePane.setContent(pane2);
        
        
        tGroup3.getToggles().addAll(lightPink, normPink, darkPink);
        //adding them to the title pane
        VBox pane3 = new VBox();
        pane3.setSpacing(15);
        pane3.getChildren().addAll(lightPink, normPink, darkPink);
        pinkPane.setText("Pink");
        pinkPane.setContent(pane3);
		
		//the accordion for the first set of color controllers
		accord1.getPanes().addAll(greenPane, bluePane, pinkPane);
		
		
		//the second part of the tots
		tGroup4.getToggles().addAll(lightGrey, normGrey, darkGrey);
		//adding them to the title pane
		VBox pane4 = new VBox();
		pane4.setSpacing(15);
		pane4.getChildren().addAll(lightGrey, normGrey, darkGrey);
		greyPane.setText("Grey");
		greyPane.setContent(pane4);
		
		
		tGroup5.getToggles().addAll(lightGoldenRodYellow, normGoldenRodYellow, darkGoldenRodYellow);
		//adding them to the titl epane
		VBox pane5 = new VBox();
		pane5.setSpacing(15);
		pane5.getChildren().addAll(lightGoldenRodYellow, normGoldenRodYellow, darkGoldenRodYellow);
		goldenRodYellowPane.setText("GoldenRodYellow");
		goldenRodYellowPane.setContent(pane5);
		
		
		tGroup6.getToggles().addAll(lightCoral, normCoral, darkCoral);
		//adding them to the title pane
		VBox pane6 = new VBox();
		pane6.setSpacing(15);
		pane6.getChildren().addAll(lightCoral, normCoral, darkCoral);
		coralPane.setText("Coral");
		coralPane.setContent(pane6);
		
		
		//the second accordion
		accord2.getPanes().addAll(greyPane, goldenRodYellowPane, coralPane);
		
		
		//the hbox to hold both of them accordions
		
		rootHBox.setSpacing(40);
		rootHBox.getChildren().addAll(accord1, accord2);
		
		//the root title pane
		rootTit.setText("COLORS");
                rootTit.setCollapsible(false);
		rootTit.setContent(rootHBox);
                
		//the finalties
		theScene = new Scene(rootTit);
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
