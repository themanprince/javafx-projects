package menuclasstest2;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.beans.value.*;

public class MenuClassTest2 extends Application {
    
    
//reference to stage
    Stage sStage;
    
    
    //the menus and menu items
    MenuBar rootBar = new MenuBar();
    Menu GameMenu = new Menu("_Game"), options = new Menu("_Options"), difficulty = new Menu("_Difficulty");
    MenuItem start = new MenuItem("Start"), pause = new MenuItem("Pause"), exit = new MenuItem("Exit");
    CheckMenuItem sound = new CheckMenuItem("Sound"), music = new CheckMenuItem("Music");
    RadioMenuItem easy = new RadioMenuItem("Easy"), normal = new RadioMenuItem("Normal"), difficult = new RadioMenuItem("Difficult");
    ToggleGroup group = new ToggleGroup();

    //the label
    Label lab = new Label("...");

    //the root pane
    BorderPane root = new BorderPane();
    
    
    @Override
    public void start(Stage stage) {
sStage = stage;        
//customizing the menus to add to the menu bar

        //game menu
        start.setOnAction(new handler());
        pause.setOnAction(new handler());
        exit.setOnAction(new handler());
        GameMenu.getItems().addAll(start, pause, exit);
rootBar.getMenus().add(GameMenu);
        
        //difficulty menu
        easy.setOnAction(new handler2());
        normal.setOnAction(new handler2());
        difficult.setOnAction(new handler2());
        easy.setToggleGroup(group);
        normal.setToggleGroup(group);
        difficult.setToggleGroup(group);
        difficulty.getItems().addAll(easy, normal, difficult);
        
        //options menu
        sound.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
              if(sound.isSelected()) {
                  lab.setText("Enabling sounds...");
              }else if(! sound.isSelected()){
                 lab.setText("Disabling sounds...");
              }
            }
        });
        music.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(music.isSelected()) {
                    lab.setText("Enabling music...");
                }else if(!music.isSelected()) {
                    lab.setText("Disabling music...");
                }
            }
        });
        options.getItems().addAll(sound, music, difficulty);
rootBar.getMenus().add(options);        
        
root.setTop(rootBar);


//the label
root.setCenter(lab);



    //the stage and scene
Scene theScene = new Scene(root);
stage.setScene(theScene);
stage.setX(900);
stage.setWidth(800);
stage.setHeight(500);
stage.show();
    }


    
    public static void main(String[] args) {
        launch(args);
    }
    

class handler implements EventHandler<ActionEvent>{
@Override
    public void handle(ActionEvent e) {
        //next, the start, pause and exit menu items
if(((MenuItem)e.getSource()).equals(start)) {
            switch (start.getText()) {
                case "Start":
                   lab.setText("Starting the game again...");
                   break;
                case "Resume":
                    exit.setDisable(false);
lab.setText("Resuming the game...");
start.setText("Start");
                    break;
            }
}else if(((MenuItem)e.getSource()).equals(pause)) {
exit.setDisable(true);
lab.setText("You've paused the game... \n You cannot exit the game till you resume again...");
start.setText("Resume");
}else if(((MenuItem)e.getSource()).equals(exit)) {
lab.setText("Closing the game...");
sStage.close();
}

//the sound and music menu items

}    
}
class handler2 implements EventHandler<ActionEvent> {
public void handle(ActionEvent e) {
    //firstly, handling the radio menu items
        if((((RadioMenuItem)e.getSource()).getToggleGroup()).equals(group)) {
        //then it is one of the radio menu items
if(easy.isSelected()){
lab.setText("Setting the difficulty level to easy...");
}   else if(normal.isSelected()) {
lab.setText("Setting the difficulty level to normal...");    
}   else if(difficult.isSelected()) {
lab.setText("Setting the difficulty level to really difficult...");    
}      
        }        

}    
}
}
