package typo;

import javafx.application.Application;
import javafx.event.*;
import java.util.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.animation.*;
import javafx.util.*;

public class Typo extends Application {
    
    //the keyframe and the timeline references
    KeyFrame theKeyFrame;
    Timeline theTimeline;
    //the duration variable
    int duration;
    
    //the radio buttons
    RadioButton slow = new RadioButton("Slow"), medium = new RadioButton("Medium"), fast = new RadioButton("Fast");
    ToggleGroup speedTog = new ToggleGroup();
    //their hbox
    HBox speedPane = new HBox();
    //the button
    Button start = new Button("Start");
    
    //the user's progress field
    Double userProgress = 0.0;
    
    
    //the strings
    String string1 = "";
    String string2 = "";
    String string3 = "";
    String string4 = "";
    String string5 = "";
    
    //fmLab's text
    String fmLabText = "";
    
    //the labels
    Label lab1 = new Label(""), lab2 = new Label(""), lab3 = new Label(""), lab4 = new Label(""), lab5 = new Label("");
    
    //the textfields
    TextField text1 = new TextField(""), text2 = new TextField(""), text3 = new TextField(""), text4 = new TextField(""), text5 = new TextField("");
    
    //the root pane
    VBox root = new VBox();
    
    //the stage's ref
    Stage stageRef;
		
    //the "for-my-future-self" tag
	Label fmLab = new Label("");
        
        ProgressIndicator theInd = new ProgressIndicator();
        Double theConstant = 0.00347222;
        
    //the reference to "theyPane".. you gon' understand later
        VBox theyPaneRef;
		
    

    
    @Override
    public void start(Stage stage) {
        stageRef = stage;
        int theNo = (new Random()).nextInt(5);
        
            if(theNo < 2) {
    string1 = "Prince is a really cool guy, and he's a rapper too. He tries";
    string2 = "he drops poetry, freestyles with his rythm and sometimes";
    string3 = "raps it up. Cool nigga, does cool things. Trapping and";
    string4 = "killing it all the time. He does alotta things I don't want to";
    string5 = "say in order not to hype him. Yo, Prince, kill it. Idol!";
    fmLabText = "FOR MY FUTURE SELF";
            }
            else if(theNo > 1 && theNo < 3) {
                string1 = "Yo, Peace. Babe with the demeanor, style and looks.";
                string2 = "Killer-dresser, crazy ass person. Fine omalicha.";
                string3 = "Omini-wisest. Mother of all useful advices. Crazy design ideas,";
                string4 = "both in drawing patterns and sewing designs.";
                string5 = "She got other things too... Yo, Peace, feel yourself!";
                fmLabText = "FOR PEACE";
            }
            else if(theNo > 2 && theNo < 4) {
                string1 = "Alright, sicko' minded bitch with alotta swag. Crazy in many ways.";
                string2 = "Funny, like she took all the genes. Fine, like no need for";
                string3 = "natural bleaching. Raps too! Peace is to queen-demeanor swag";
                string4 = "as Precious is to Cardi B swag. Yea, she raps too.";
                string5 = "Sometimes though. She does more singing. Yo, Precious ...";
                fmLabText = "FOR PRECIOUS";
            }
            else if(theNo > 3 && theNo < 5) {
                string1 = "Funny ass man. The funniest on the planet. Dad + Mom = Best Combination.";
                string2 = "We got the best of qualities from 'em. like we";
                string3 = "so f'ing lucky. And they both great too. So we lucky too.";
                string4 = "Yea, Dad... He funny... calm even when you expect otherwise";
                string5 = "great. Coulda' added some other things but I kept it for some reasons. Yo, Dad, Idol!";
                fmLabText = "FOR DAD";
                
            }
            else if(theNo > 4) {
                string1 = "Alright, she too caring. Like, it don't make sense some";
                string2 = "times. like, she'll go out of her way. She funny too...";
                string3 = "Yea... has her moments...Ok, she really funny when she decides";
                string4 = "to be funny. She cooks great food... yea... gives good advice";
                string5 = "is a great companion. She treat me like 5 when I'm 20 :D. Yo, Momma... :D";
                fmLabText = "FOR MOM";
            }
                
        
        
        slow.setSelected(true);
        //customizing the root pane
        root.setStyle("-fx-background-color: pink");
        root.setSpacing(15);
        
        //customizing the textfields
        text1.setPrefWidth(string1.length());
        text2.setPrefWidth(string2.length());
        text3.setPrefWidth(string3.length());
        text4.setPrefWidth(string4.length());
        text5.setPrefWidth(string5.length());
        
        text1.setStyle("-fx-background-color: pink");
        text2.setStyle("-fx-background-color: pink");
        text3.setStyle("-fx-background-color: pink");
        text4.setStyle("-fx-background-color: pink");
        text5.setStyle("-fx-background-color: pink");
        
        //the hboxes for all the textfields and their labels
        VBox noOne = new VBox(), noTwo = new VBox(), noThree = new VBox(), noFour = new VBox(), noFive = new VBox();
        noOne.setAlignment(Pos.BOTTOM_LEFT);
        noTwo.setAlignment(Pos.BOTTOM_LEFT);
        noThree.setAlignment(Pos.BOTTOM_LEFT);
        noFour.setAlignment(Pos.BOTTOM_LEFT);
        noFive.setAlignment(Pos.BOTTOM_LEFT);
        noOne.getChildren().addAll(lab1, text1);
        noTwo.getChildren().addAll(lab2, text2);
        noThree.getChildren().addAll(lab3, text3);
        noFour.getChildren().addAll(lab4, text4);
        noFive.getChildren().addAll(lab5, text5);
        
        //the speed buttons
        speedTog.getToggles().addAll(slow, medium , fast);
        speedPane.setSpacing(23);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                text1.requestFocus();
                fmLab.setText(fmLabText);
                //initializing the animation to start the typo
                //and playing it for AN INDEFINITE PERIOD OF TIME
                if(slow.isSelected()) {
                    duration = 1000;
                }else if(medium.isSelected()) {
                    duration = 500;
                }else if(fast.isSelected()) {
                    duration = 260;
                }
                theKeyFrame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        //there will be five conditions to determine
                        //which label is currently written to and which
                        //textfield currently has focus
                        if(lab1.getText().length() < string1.length() && lab2.getText().isEmpty()/*i.e. its empty*/ && lab3.getText().isEmpty() && lab4.getText().isEmpty() && lab5.getText().isEmpty()) {
                            lab1.setText(lab1.getText() + string1.charAt(lab1.getText().length()));
                            }else if(/*the condition for moving to the next textfield*/lab1.getText().length() == string1.length() && lab3.getText().isEmpty() && lab4.getText().isEmpty() && lab5.getText().isEmpty() && lab2.getText().length() < string2.length()) {
                            text2.requestFocus();
                            lab2.setText(lab2.getText() + string2.charAt(lab2.getText().length()));
                            }else if(/*the condition for the third textfield*/lab1.getText().length() == string1.length() && lab2.getText().length() == string2.length() && lab4.getText().isEmpty() && lab5.getText().isEmpty() && lab3.getText().length() < string3.length()) {
                            text3.requestFocus();
                            lab3.setText(lab3.getText() + string3.charAt(lab3.getText().length()));
                            }else if(/*the condition for the fourth textfield*/lab1.getText().length() == string1.length() && lab2.getText().length() == string2.length() && lab5.getText().isEmpty() && lab4.getText().length() < string4.length()) {
                            text4.requestFocus();
                            lab4.setText(lab4.getText() + string4.charAt(lab4.getText().length()));
                            }else if(/*the condition for the last textfield*/lab1.getText().length() == string1.length() && lab2.getText().length() == string2.length() && lab3.getText().length() == string3.length() && lab4.getText().length() == string4.length() && lab5.getText().length() < string5.length()) {
                            text5.requestFocus();
                            lab5.setText(lab5.getText() + string5.charAt(lab5.getText().length()));
                            }else if(/*the condtion for calculating the progress*/lab1.getText().length() == string1.length() && lab2.getText().length() == string2.length() && lab3.getText().length() == string3.length() && lab4.getText().length() == string4.length() && lab5.getText().length() == string5.length()) {
                                String[] arr = new String[5];
                                arr[0] = string1;
                                arr[1] = string2;
                                arr[2] = string3;
                                arr[3] = string4;
                                arr[4] = string5;
                                
                                for(String item : arr) {
                                    
                                if(item.equals(string1)) {
                                    
                                    for(int i = 0; i < text1.getText().length(); i++) {

                                        if(text1.getText().charAt(i) == string1.charAt(i)) {
                                            userProgress += theConstant;
                                        }
                                    }
                                }else if(item.equals(string2)) {
                                    for(int i = 0; i < text2.getText().length(); i++) {
                                        if(text2.getText().charAt(i) == string2.charAt(i)) {
                                            userProgress += theConstant;
                                        }
                                    }
                                }else if(item.equals(string3)) {
                                    for(int i = 0; i < text3.getText().length(); i++) {
                                        if(text3.getText().charAt(i) == string3.charAt(i)) {
                                            userProgress += theConstant;
                                        }
                                    }
                                }else if(item.equals(string4)) {
                                    for(int i = 0; i < text4.getText().length(); i++) {
                                        if(text4.getText().charAt(i) == string4.charAt(i)) {
                                            userProgress += theConstant;
                                        }
                                    }
                                }else if(item.equals(string5)) {
                                    for(int i = 0; i < text5.getText().length(); i++)  {
                                        if(text5.getText().charAt(i) == string5.charAt(i)) {
                                            userProgress += theConstant;
                                        }
                                    }
                                }
                                }
                                VBox theyPane = new VBox();
                                theyPaneRef = theyPane;
                                theyPane.setAlignment(Pos.CENTER);
                                theInd.setPrefWidth(100);
                                theInd.setPrefHeight(80);
                                theInd.setProgress(userProgress);
                                Button restart = new Button("Restart");
                                restart.setPrefHeight(47);
                                restart.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent e) {
                                    lab1.setText("");
                                    lab2.setText("");
                                    lab3.setText("");
                                    lab4.setText("");
                                    lab5.setText("");
                                    
                                    text1.clear();
                                    text2.clear();
                                    text3.clear();
                                    text4.clear();
                                    text5.clear();
                                    
                                    fmLab.setText("");
                                    
                                    root.getChildren().remove(root.getChildren().indexOf(theyPaneRef));
                                    
                                    }
                                });
                                theyPane.getChildren().addAll(new Label("Your Progress"), theInd, restart);
                                root.getChildren().addAll(theyPane);
                            }
                            }
                });
            theTimeline = new Timeline();
            theTimeline.getKeyFrames().add(theKeyFrame);
            theTimeline.setCycleCount(string1.length() + string2.length() + string3.length() + string4.length() + string5.length() + 1/*the extra one cycle is the one in which the progress will be calculated and any other thing :D*/);
            theTimeline.play();
            }
        });
        speedPane.getChildren().addAll(slow, medium, fast, start);


        

        //the finalties
        root.getChildren().addAll(speedPane, fmLab, noOne, noTwo, noThree, noFour, noFive);
        
        Scene theScene = new Scene(root);
        theScene.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
        stage.setTitle("Typo");
        stage.setScene(theScene);
        stage.setResizable(false);
        stage.setX(900);
        stage.setWidth(500);
        stage.setHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
