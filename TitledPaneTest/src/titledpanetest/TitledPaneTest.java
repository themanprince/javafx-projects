package titledpanetest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

public class TitledPaneTest extends Application {
    
    //the check boxes
    CheckBox checkBox1 = new CheckBox("CheckBox one"), checkBox2 = new CheckBox("CheckBox two"), checkBox3 = new CheckBox("CheckBox three");
    
    //the titled pane
    TitledPane theTPane/*t-pain ha ha*/ = new TitledPane();
    
    @Override
    public void start(Stage stage) {
        //the vbox for the checkboxes
        VBox root = new VBox();
        root.setPadding(new Insets(13));
        root.setSpacing(17);
        root.getChildren().addAll(checkBox1, checkBox2, checkBox3);
        
        
        //adding them to the titled pane
        theTPane.setText("Just Useless CheckBoxes");
        theTPane.setContent(root);
        theTPane.setCollapsible(false);
        
        
        
        //the finalties
        Scene theScene = new Scene(theTPane);
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
