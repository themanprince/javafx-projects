package famtreebuilder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Tooltip;
import javafx.scene.control.SelectionMode;
import javafx.beans.value.*;

/**
 *
 * @author prince adigwe
 */
public class FamTreeBuilder extends Application {
//the tree
    TreeView<String> famTree;
    //the name field and the already-existing-
    //names combobox
//and their pane
    TextField nameField = new TextField();
    ComboBox<String> AEN = new ComboBox<>();
    HBox namePane = new HBox(7);
    //the tree item
    TreeItem<String> root = new TreeItem<>("You");
//the scene
    Scene theScene;
    VBox rootPane = new VBox(20);
    
    
    @Override
    public void start(Stage primaryStage) {
nameField.setPrefColumnCount(10);
AEN.setTooltip(new Tooltip("Touch this to put family member under preffered ancestor"));
AEN.getItems().add("You");
AEN.setVisibleRowCount(4);
//the comboBox listener
AEN.getSelectionModel().selectedItemProperty().addListener(new MyListener());
namePane.getChildren().addAll(nameField, AEN);
root.setExpanded(true);
famTree = new TreeView<>(root);
famTree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
famTree.setShowRoot(false);
rootPane.getChildren().addAll(namePane, famTree);
theScene = new Scene(rootPane);
primaryStage.setScene(theScene);
primaryStage.setWidth(700);
primaryStage.setHeight(400);
primaryStage.setResizable(false);
primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    class MyListener implements ChangeListener<String> {
    	@Override
    	public void changed(ObservableValue<? extends String> value, String oldValue, String newValue) {
    		//this listener is for my combo box
	        /*its work is to add the specified name under
	        the specified parent in the tree view
	        */

			//t also adds the specified text to the combo box.. if shit was entered
			        if(!nameField.getText().isEmpty())
				{        AEN.getItems().add(nameField.getText());
				    //adding the name to the tree under the specified parent..
				    add(root, AEN.getValue());
				            //and clears the textfield
				    nameField.setText("");
				    AEN.getSelectionModel().clearSelection();
			    }
    	}
    }


public void add(TreeItem<String> it, String valueToCheckFor) {
    //if this node is the specified node, add
//the name to it
    
    //else goto its children
    if(it.getValue().toString().equals(valueToCheckFor)) {
TreeItem<String> nodeToBeCreated = new TreeItem<String>(nameField.getText());
        nodeToBeCreated.setExpanded(true);
        it.getChildren().add(it.getChildren().size(), nodeToBeCreated);
    return;
    } 
//perform add on children
        for(int i = 0; i < it.getChildren().size(); i++) {
add((TreeItem<String>)it.getChildren().get(i), valueToCheckFor);
 }

    
}
}
