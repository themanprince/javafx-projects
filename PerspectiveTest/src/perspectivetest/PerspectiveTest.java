package perspectivetest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.layout.*;

public class PerspectiveTest extends Application {
	//the group
	Group theGroup = new Group();

		//the root pane
		VBox root = new VBox();
		
                @Override
	public void start(Stage stage) {
	
			Boolean isLight = true;
		//the loop to create the chess board and cells
		for(int i = 0; i < 9; i++) {
			for(int p = 0; p < 9; p++) {
			Rectangle rect = new Rectangle(p * 50, i * 50, 50, 50);
			rect.setStroke(Color.BLACK);
			rect.setStrokeWidth(3);
			if(isLight) {
			rect.setFill(Color.LIGHTGRAY);
			isLight = !isLight;
			}else{
			rect.setFill(Color.BLACK);
                        isLight = !isLight;
			}
			theGroup.getChildren().add(rect);
			}
		}
		
		//changing the perspective of the group
		PerspectiveTransform pers = new PerspectiveTransform();
		pers.setUlx(0);
		pers.setUly(70);
		pers.setUrx(400);
		pers.setUry(70);
		pers.setLlx(120);
		pers.setLly(450);
		pers.setLrx(380);
		pers.setLry(450);
		
		//adding the effect to the group
                theGroup.setEffect(pers);
		
		
		//the scene and the stage
		root.getChildren().add(theGroup);
                Scene theScene = new Scene(root);
		stage.setScene(theScene);
		stage.setX(900);
		stage.setResizable(false);
		stage.setWidth(400);
		stage.setHeight(500);
		stage.show();
	}
	
	public static void main(String[] args) {
	launch(args);
	}

}