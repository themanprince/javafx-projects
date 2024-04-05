package lettercomposer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.stage.WindowEvent;

public class LetterComposer extends Application{

    public static void main(String[] args) {
        launch(args);
    }

VBox root = new VBox(20);
Scene scene;
BorderPane yrAddr = new BorderPane();
Text yrAddrTxt = new Text("Your Address \n & \n Date:");
TextArea yrAddrField = new TextArea();
RadioButton isFormal, isNotFormal;
ToggleGroup formality = new ToggleGroup();
HBox formalityPane = new HBox(10);
Text recpAddrTxt = new Text("Enter the recipient's address");
TextArea recpAddrField = new TextArea();
VBox recpAddrPane = new VBox();
HBox dearPane = new HBox(5);
Text dearTxt = new Text("Dear..:");
TextField dearField = new TextField();
Text titleTxt = new Text("Title:");
TextField titleField = new TextField();
VBox titlePane = new VBox();
VBox bodyPane = new VBox(5);
TextArea bodyField = new TextArea();
Text bodyTxt = new Text("Enter the body of the letter");
HBox salPane = new HBox(2);
Text salTxt = new Text("Enter the salution text");
TextArea salField = new TextArea();
Button done = new Button("Done!");
BorderPane buttonPane = new BorderPane();
HBox theRealRecpAddrPane = new HBox(10);
//the sal combo box
ComboBox<String> salList = new ComboBox<String>();
Stage theStage;
LetterComposer theOneToBePassedLater = this;


public void start(Stage stage) {
this.theStage = stage;
    root.setSpacing(10.0);
    //the writer's address pane
yrAddrField.setPrefRowCount(4);
yrAddrField.setPrefColumnCount(20);
    yrAddrField.setPromptText("Type in your address \n and the date of writing here");
yrAddr.setLeft(yrAddrTxt);
yrAddr.setRight(yrAddrField);
yrAddr.setPadding(new Insets(10));
root.getChildren().add(yrAddr);
//the isFormal radio buttons
isFormal = new RadioButton("A formal Letter?");
isNotFormal = new RadioButton("Or not?");
isFormal.setSelected(true);
isFormal.setToggleGroup(formality);
isNotFormal.setToggleGroup(formality);
formalityPane.setPadding(new Insets(10));
Text formalityQues = new Text("Is it ");
formalityPane.getChildren().addAll(formalityQues, isFormal, isNotFormal);
isFormal.setOnAction(new FormalityListener());
isNotFormal.setOnAction(new FormalityListener());
formalityPane.setAlignment(Pos.CENTER);
root.getChildren().add(formalityPane);
//The recipientt's address pane
recpAddrField.setPromptText("Enter recipient's address");
recpAddrField.setPrefWidth(25);
recpAddrField.setPrefRowCount(4);
Region recpAddrSpace = new Region();
recpAddrSpace.setPrefHeight(100);
recpAddrSpace.setPrefWidth(300);
recpAddrPane.getChildren().addAll(recpAddrTxt, recpAddrField);
recpAddrPane.setAlignment(Pos.CENTER_LEFT);
    
    theRealRecpAddrPane.getChildren().addAll(recpAddrPane, recpAddrSpace);
root.getChildren().add(theRealRecpAddrPane);
//The 'Dear ...' Pane
dearField.setPrefColumnCount(10);
dearPane.getChildren().addAll(dearTxt, dearField);
root.getChildren().add(dearPane);
//the title pane
titleField.setPrefColumnCount(10);
titlePane.getChildren().addAll(titleTxt, titleField);
root.getChildren().add(titlePane);
//the body pane
bodyField.setPrefColumnCount(100);
bodyField.setPrefRowCount(4);
bodyField.setPromptText("The Body of the leter...");
bodyPane.getChildren().addAll(bodyTxt, bodyField);
root.getChildren().add(bodyPane);
//the ending salutauion
salField.setPromptText("Your name");
salField.setPrefRowCount(1);
//the VBox salPane
VBox forSal = new VBox();
salList.setPrefHeight(20);
salList.setPrefWidth(200);
salList.setPromptText("Your's Faithfully");
salList.setEditable(true);
salList.getItems().addAll("Your's faithfully", "Your's dearly", "Your's sincerely", "Your's in affection");
forSal.getChildren().addAll(salList, salField);
//the salPane will be in a border pane so that i can align it to the left
salPane.getChildren().addAll(salTxt, forSal);
BorderPane sal = new BorderPane();
sal.setRight(salPane);
sal.setPadding(new Insets(10, 0, 10, 0));
root.getChildren().add(sal);
//the "done" button
buttonPane.setCenter(done);
done.setOnAction(new EventHandler<ActionEvent>() {
   public void handle(ActionEvent e) {
letterWindow wind = new letterWindow(yrAddrField.getText(), recpAddrField.getText(), dearField.getText(), titleField.getText(), bodyField.getText(), salList.getValue() + "\n" + "\n" + salField.getText(), theOneToBePassedLater);
wind.show();
   } 
});
root.getChildren().add(buttonPane);
//setting all the toltips
yrAddrField.setTooltip(new Tooltip("Enter your address the way it \n should appear in the letter"));
recpAddrField.setTooltip(new Tooltip("Enter the recipient's address \n like it should be in the letter"));
dearField.setTooltip(new Tooltip("Enter the recipient's name"));
titleField.setTooltip(new Tooltip("in capital letters ( Uppercase letters )"));
bodyField.setTooltip(new Tooltip("The letter's main body. \n It completely appears the way you \n type it."));
done.setTooltip(new Tooltip("Submit and create your letter"));



scene = new Scene(root);
stage.setScene(scene);
stage.setTitle("Letter Composer");
stage.setHeight(700);
stage.setWidth(300);
stage.show();
stage.setResizable(false);
}

class FormalityListener implements EventHandler<ActionEvent> {
public void handle(ActionEvent e) {
 if(e.getSource() == isFormal) {
     if(!(root.getChildren().contains(theRealRecpAddrPane))) {
		root.getChildren().add(root.getChildren().indexOf(formalityPane) + 1, theRealRecpAddrPane);
		root.getChildren().add(root.getChildren().indexOf(dearPane) + 1, titlePane);
     }
 }else if(e.getSource() == isNotFormal) {
if(root.getChildren().contains(theRealRecpAddrPane)) {
root.getChildren().remove(titlePane); 
root.getChildren().remove(theRealRecpAddrPane);
}
}
 
 if(salList.getValue() == null) {
     salList.setValue("Your's faithfully,");
 }
}
}

static class letterWindow {
Text yrAddr, recpAddr, dear, title, body, sal;
LetterComposer masterStage;
public letterWindow(String yrAddr, String recpAddr, String dear, String title, String body, String sal, LetterComposer masterStage) {
this.masterStage = masterStage;
    this.yrAddr = new Text(yrAddr + "\n");
this.yrAddr.setFont(new Font(11));
    this.recpAddr = new Text(recpAddr);
this.recpAddr.setFont(new Font(11));
    this.dear = new Text("Dear " + dear + ",");
this.dear.setFont(new Font(15));
this.title = new Text(title);
this.body = new Text(body);
this.body.setFont(new Font(15));
this.sal = new Text(sal);
this.sal.setFont(new Font(14));
this.title.setFont(new Font(20));
}
Stage theWindow;
VBox rootPane = new VBox();
public void show() {
    theWindow = new Stage();
//the yrAddr pane
    BorderPane yrAddrPane = new BorderPane();
    yrAddrPane.setRight(yrAddr);
    rootPane.getChildren().add(yrAddrPane);
    //the recpAddr pane
BorderPane recpAddrPane = new BorderPane();
recpAddrPane.setLeft(recpAddr);
rootPane.getChildren().add(recpAddrPane);
//the dear pane
BorderPane dearPane = new BorderPane();
dearPane.setPadding(new Insets(10, 0, 15, 0));
dearPane.setLeft(dear);
rootPane.getChildren().add(dearPane);
//the title pane
BorderPane titlePane = new BorderPane();
titlePane.setCenter(title);
titlePane.setPadding(new Insets(10, 0, 15, 0));
rootPane.getChildren().add(titlePane);
//the body pane
BorderPane bodyPane = new BorderPane();
bodyPane.setCenter(body);
bodyPane.setPadding(new Insets(10, 0, 15, 0));
rootPane.getChildren().add(bodyPane);
//the sal pane
BorderPane salPane = new BorderPane();
salPane.setRight(sal);
rootPane.getChildren().add(salPane);
theWindow.setScene(new Scene(rootPane));
theWindow.setResizable(false);
theWindow.show();
theWindow.setOnCloseRequest(new EventHandler<WindowEvent>() {
//this is to handle the close request of the
//user
public void handle(WindowEvent e) {
//emptying all the fields in the form stage
masterStage.yrAddrField.setText("");
masterStage.titleField.setText("");
    masterStage.bodyField.setText("");
    masterStage.dearField.setText("");
    masterStage.recpAddrField.setText("");
    masterStage.salField.setText("");
}    
});

}

}
}