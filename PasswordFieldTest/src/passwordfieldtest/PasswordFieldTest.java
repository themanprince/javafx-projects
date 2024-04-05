package passwordfieldtest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.geometry.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.util.*;
import javafx.scene.effect.*;

public class PasswordFieldTest extends Application {
    
    Group rootGroup = new Group();
    
    //the textfields
    TextField username = new TextField();
    PasswordField password = new PasswordField();
    //the login button
    Button login = new Button("Login");
    //the logout button
    Button logout = new Button("Logout");
    
    //the two vboxes for the two pages
    VBox page1 = new VBox(), page2 = new VBox();
    
    //reference to the scene
    Scene sceneRef;
    
    //reference to the text on the second page
    Text textRef;
    
    //the password
    String thePassword = "javafx";
    
    //the report label
    Label reports = new Label("");
    
    //the animation fields
    KeyFrame theKeyFrame;
    Timeline theTimeline;
    
    //the glow
    Glow theGlow = new Glow();
    Boolean glowLevelForward;
    
    
    Stage stageRef;
    
    
    
    
    @Override
    public void start(Stage stage) {
        glowLevelForward = true;
        theGlow.setLevel(0);
        stageRef = stage;
        //the animation
        theKeyFrame = new KeyFrame(Duration.millis(90), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(glowLevelForward) {
                    if(theGlow.getLevel() == 1) {
                    glowLevelForward = false;
                    }else{
                    theGlow.setLevel(theGlow.getLevel() + 0.1);
                    textRef.setEffect(theGlow);
                    }
                }else if(glowLevelForward == false) {
                    theGlow.setLevel(theGlow.getLevel() - 0.1);
                    textRef.setEffect(theGlow);
                    if(theGlow.getLevel() == 0) {
                        glowLevelForward = true;
                    }
                }
            }
        });
        theTimeline = new Timeline();
        theTimeline.setCycleCount(Timeline.INDEFINITE);
        theTimeline.getKeyFrames().add(theKeyFrame);
        
        //customizing the second page
        final Text theText = new Text("Welcome, thou good \n and faithful servant!");
        theText.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.REPEAT, new Stop(0.2, Color.GREEN), new Stop(0.6, Color.PINK)));
        theText.setFont(new Font(42));
        textRef = theText;
        page2.setAlignment(Pos.CENTER);
        //the logout button - second page
        logout.setPrefWidth(70);
        logout.setPrefHeight(50);
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                username.clear();
                password.clear();
                reports.setText("");
                sceneRef.setRoot(page1);
            }
        });
        page2.getChildren().addAll(theText, logout);
        
        
        
        //customizing the controls before adding 
        //them to the scene
        username.setPrefWidth(150);
        username.setPrefHeight(50);
        username.setPromptText("Your name");
        Label usLab = new Label("Username");
        VBox usPane = new VBox();
        usPane.setAlignment(Pos.BASELINE_LEFT);
        usPane.getChildren().addAll(usLab, username);
        password.setPrefWidth(150);
        password.setPrefHeight(50);
        password.setPromptText("Hint - check the tootip");
        password.setTooltip(new Tooltip("My favourite programming language"));
        Label psLab = new Label("Password");
        VBox psPane = new VBox();
        psPane.setAlignment(Pos.BASELINE_LEFT);
        psPane.getChildren().addAll(psLab, password);
        login.setPrefWidth(70);
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if((!username.getText().isEmpty()) && password.getText().equals(thePassword)) {
                    sceneRef.setRoot(page2);
                    theTimeline.stop();
                   theTimeline.playFromStart();
                }else{
                    reports.setText("Error in logging in! \n Check that the username field is not empty \n and that the password entered \n is correct!");
                }
            }
        });
        login.setPrefHeight(50);
        
        //customizing the page1 vbox
        page1.setSpacing(39);
        page1.setAlignment(Pos.CENTER);
        page1.setPadding(new Insets(30));
        page1.setId("page1");
        page1.getChildren().addAll(usPane, psPane, login, reports);
        
        
        
        
        
        //the finalties
        Scene theScene = new Scene(page1);
        sceneRef = theScene;
        stage.setScene(theScene);
        stage.setX(900);
        stage.setWidth(400);
        stage.setResizable(false);
        stage.setHeight(500);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
