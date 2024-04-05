package glowandbloomtest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;

public class GlowAndBloomTest extends Application {
    
    //the root pane
    VBox root = new VBox();

	//the scroll pane
	ScrollPane realRoot = new ScrollPane();
    @Override
    public void start(Stage stage) {
		//customizing the vbox
		root.setSpacing(30);
		
		
		//the first group of plain text
		Group group1 = new Group();
		Text text1 = new Text("Plain Text");
		text1.setFont(new Font(50));
                text1.setFill(Color.WHITE);
		text1.setX(0);
		text1.setY(50);
		//its root rectangle
		Rectangle rect1 = new Rectangle(0, 0, 300, 300);
		rect1.setFill(Color.BLACK);
		//adding it to the group
		group1.getChildren().add(rect1);
		group1.getChildren().add(text1);
		//adding the rectangle to the root pane
		root.getChildren().add(group1);
		
		//the glowing text
		Group group2 = new Group();
		Text text2 = new Text("Glowing Text");
		text2.setFont(new Font(50));
		text2.setX(0);
		text2.setY(50);
		text2.setFill(Color.YELLOW);
		//its glow
		Glow glow = new Glow();
		glow.setLevel(0.2);
		text2.setEffect(glow);
		//its root rectangle
		Rectangle rect2 = new Rectangle(0, 0, 300, 300);
		rect2.setStroke(Color.GREEN);
		rect2.setStrokeWidth(3);
		rect2.setFill(Color.BLACK);
                //adding them to their groups
		group2.getChildren().addAll(rect2, text2);
		//adding it to the root pane
		root.getChildren().add(group2);
		
		//the third text
		Group group3 = new Group();
		Text text3 = new Text("Blooming Text");
		text3.setFont(new Font(50));
		text3.setX(0);
		text3.setY(50);
		text3.setFill(Color.BROWN);
		//its bloom
		Bloom bloom = new Bloom();
		bloom.setThreshold(0.2);
		text3.setEffect(bloom);
		//its root rectangle
		Rectangle rect3 = new Rectangle(0, 0, 300, 400);
		rect3.setFill(Color.BLACK);
                rect3.setStroke(Color.BLACK);
		rect3.setStrokeWidth(3);
		//adding them to their groups
		group3.getChildren().addAll(rect3, text3);
		//adding it to the root group
		root.getChildren().add(group3);
		
		
		//the finalties
		realRoot.setContent(root);
		Scene theScene = new Scene(realRoot);
		stage.setScene(theScene);
		stage.setX(900);
		stage.setWidth(400);
		stage.setHeight(400);
		stage.setResizable(false);
		stage.show();
		
		
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
