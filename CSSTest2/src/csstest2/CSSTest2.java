package csstest2;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CSSTest2 extends Application {

    //The Menu Bar
    MenuBar rootBar = new MenuBar();
    
    //The first menu and its items
    Menu MenuOne = new Menu("First Menu");
    MenuItem MOOne = new MenuItem("First Item"), MOTwo = new MenuItem("Second Item"), MOThree = new MenuItem("Third Item"), MOFour = new MenuItem("Fourth Item"), MOFive = new MenuItem("Fifth Item");
    
    //The second menu and its items
    Menu MenuTwo = new Menu("Second Menu");
    MenuItem MTOne = new MenuItem("First Item"), MTTwo = new MenuItem("Second Item"), MTThree = new MenuItem("Third Item"), MTFour = new MenuItem("Fourth Item"), MTFive = new MenuItem("Fifth Item");
    
    //The third menu and its items
    Menu MenuThree = new Menu("Third Menu");
    MenuItem MThOne = new MenuItem("First Item"), MThTwo = new MenuItem("Second Item"), MThThree = new MenuItem("Third Item"), MThFour = new MenuItem("Fourth Item"), MThFive = new MenuItem("Fifth Item");

    //the label
    Label lab = new Label();
    
    //The root pane
    BorderPane root = new BorderPane();
    
    
    
    @Override
    public void start(Stage stage) {
    //customizing the first menu
        MOOne.setId("MOOne");
        MOOne.setOnAction(new handler());
        MOTwo.setId("MOTwo");
        MOTwo.setOnAction(new handler());
        MOThree.setId("MOThree");
        MOThree.setOnAction(new handler());
        MOFour.setId("MOFour");
        MOFour.setOnAction(new handler());
        MOFive.setId("MOFive");
        MOFive.setOnAction(new handler());
        MenuOne.getItems().addAll(MOOne, MOTwo, MOThree, MOFour, MOFive);

    //customizing the second menu
        MTOne.setId("MTOne");
        MTOne.setOnAction(new handler());
        MTTwo.setId("MTTwo");
        MTTwo.setOnAction(new handler());
        MTThree.setId("MTThree");
        MTThree.setOnAction(new handler());
        MTFour.setId("MTFour");
        MTFour.setOnAction(new handler());
        MTFive.setId("MTFive");
        MTFive.setOnAction(new handler());
        MenuTwo.getItems().addAll(MTOne, MTTwo, MTThree, MTFour, MTFive);
        
        
   //customizing the third menu
        MThOne.setId("MTHOne");
        MThOne.setOnAction(new handler());
        MThTwo.setId("MThTwo");
        MThTwo.setOnAction(new handler());
        MThThree.setId("MThThree");
        MThThree.setOnAction(new handler());
        MThFour.setId("MThFour");
        MThFour.setOnAction(new handler());
        MThFive.setId("MThFive");
        MThFive.setOnAction(new handler());
        MenuThree.getItems().addAll(MThOne, MThTwo, MThThree, MThFour, MThFive);
        
        
        //adding the menus to the menu bar
        rootBar.getMenus().addAll(MenuOne, MenuTwo, MenuThree);
        
        
        //adding the menu bar to the root pane
        root.setTop(rootBar);
        root.setCenter(lab);
        
        
        
        //The stage and the scene
        Scene theScene = new Scene(root);
        theScene.getStylesheets().clear();
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
    
//the event handler for the menu items
    class handler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent e) {
     lab.setText("You Pressed the " + ((MenuItem)e.getSource()).getText() + " in the " + ((MenuItem)e.getSource()).getParentMenu().getText());
    }
};

}
