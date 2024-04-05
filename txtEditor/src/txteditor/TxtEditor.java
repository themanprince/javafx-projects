package txteditor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import java.io.*;
import javafx.scene.text.*;


public class TxtEditor extends Application {
    
    //the textarea, textfield, open button and save button
TextArea text = new TextArea();
TextField url = new TextField();
Button openBtn = new Button("Open File"), saveBtn = new Button("Save Txt");
//their panes
HBox textPane = new HBox(10), urlPane /*contains both the url field and the open button*/ = new HBox(10);
VBox rootPane = new VBox(10);
//the label that tells the user the path location for storing the files
Label path = new Label("C:\\Users\\PST JUDE\\Documents\\NetBeansProjects\\libgdx-1.6.1\\GameProjects\\txtEditor\\src\\txteditor\\");
//textfield for change of path
TextField changePath = new TextField("C:\\Users\\PST JUDE\\Documents\\NetBeansProjects\\libgdx-1.6.1\\GameProjects\\txtEditor\\src\\txteditor\\");
Button changePathBtn = new Button("Change Path");
HBox changePane = new HBox(3);



@Override
    public void start(Stage primaryStage) {
//the change pane first(didnt actually come first)
changePath.setPrefColumnCount(50);
changePathBtn.setPrefWidth(100);
changePathBtn.setOnAction(new buttonListeners());
changePane.setPadding(new Insets(10, 0, 0, 0));
changePane.getChildren().addAll(changePath, changePathBtn);
rootPane.getChildren().add(changePane);
//foramtting the textfields and adding them to their panes
text.setTooltip(new Tooltip("Enter the text here"));
text.setPromptText("Enter the text here...");
text.setPrefColumnCount(100);
text.setPrefRowCount(100);
textPane.setPadding(new Insets(10, 0, 10, 0));
textPane.getChildren().add(text);
rootPane.getChildren().add(textPane);

//the url pane
url.setTooltip(new Tooltip("The File Name"));
url.setPromptText("The File Name");
url.setPrefColumnCount(7);
openBtn.setPrefWidth(150);
openBtn.setOnAction(new buttonListeners());
urlPane.getChildren().addAll(path, url, openBtn);
rootPane.getChildren().add(urlPane);


//the save button
saveBtn.setPrefWidth(800);
saveBtn.setPrefHeight(70);
saveBtn.setOnAction(new buttonListeners());
rootPane.getChildren().add(saveBtn);


//the scene
Scene theScene = new Scene(rootPane);
primaryStage.setScene(theScene);
primaryStage.setTitle("Txt Editor");
primaryStage.setWidth(800);
primaryStage.setHeight(500);
primaryStage.setResizable(false);
primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
//my button listeners
    class buttonListeners implements EventHandler<ActionEvent> {
@Override
        public void handle(ActionEvent e) {
if(e.getSource() == saveBtn) {
FileOutputStream FO = null;
    try{
 FO = new FileOutputStream(path.getText() + url.getText());    
}catch(FileNotFoundException i) {
File file = new File(path.getText() + url.getText());
try{
FO = new FileOutputStream(file);
}catch(IOException b) {
Info info = new Info("File not Found", "The file specified in the \n URL was not found in the \n specified location \n \n The file was also unable to \n be created");
info.show();
}
}
    BufferedOutputStream BO = new BufferedOutputStream(FO);
byte[] thingToWrite = text.getText().getBytes();
try{
BO.write(thingToWrite);
BO.flush();
BO.close();
FO.close();
Info doneInfo = new Info("Done", "Successfully editted / created \"" + url.getText() + "\"");
doneInfo.show();
}catch(IOException i) {
Info info = new Info("Error!", "Sorry but we are unable to \n write to your txt file. \n check the file extension... \n bla bla bla");
info.show();
}

}else if(e.getSource() == openBtn) {
FileInputStream FI = null;
BufferedInputStream BI = null;
try{
   FI = new FileInputStream(path.getText() + url.getText()); 
}catch(FileNotFoundException f) {
    Info FNF = new Info("Error!", "The specified file was not found // does \n not exist");
}
BI = new BufferedInputStream(FI);
int i;
text.clear();
try{
while((i = BI.read()) != -1) {
    //converting the byte returned to string so that
    //I can enter it into the text textarea
char[] t = new char[1];
t[0] = (char)i;
String s = new String(t);
    text.setText(text.getText() + s);
}
}catch(IOException o) {
    Info error = new Info("Error", "Unable to open. Check if the file exists");
    error.show();
}
} else if(e.getSource() == changePathBtn) {
    //changing the path
path.setText(changePath.getText());
}
}        
    }

//my information class
class Info{
    String title, msg;
    public Info(String title, String msg) {
        this.title = title;
        this.msg = msg;
    }
Button close = new Button("OK");
Stage stage;
public void show() {
    Text TTD = new Text(msg);
VBox pane = new VBox(10);
pane.setPadding(new Insets(20, 20, 20, 20));
pane.setAlignment(Pos.CENTER);
close.requestFocus();
close.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
   stage.close();
}
});
pane.getChildren().addAll(TTD, close);
Scene scene = new Scene(pane);
stage = new Stage();
stage.setScene(scene);
stage.setTitle(title);
stage.initModality(Modality.APPLICATION_MODAL);
stage.showAndWait();
}    
}
}
