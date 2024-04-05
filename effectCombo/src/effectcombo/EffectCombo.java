package effectcombo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.Group;
import javafx.scene.effect.*;

public class EffectCombo extends Application {
    
    //the root group
    Group rootGroup = new Group();
    
    //the root pane
    VBox rootPane = new VBox();
    
    @Override
    public void start(Stage stage) {
		//the circle
		Circle circ1 = new Circle(200, 200, 100);
		circ1.setStroke(Color.BLACK);
		circ1.setStrokeWidth(3);
		//the gradient
		RadialGradient rad1 = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.REPEAT, new Stop(0, Color.ORANGE), new Stop(0.3, Color.BLUE), new Stop(0.5, Color.YELLOW), new Stop(0.7, Color.RED), new Stop(0.9, Color.AQUA));
		circ1.setFill(rad1);
		//the reflection
		Reflection ref1 = new Reflection();
		ref1.setTopOffset(-100);
                //the shadow
		DropShadow shad1 = new DropShadow();
		shad1.setWidth(20);
		shad1.setHeight(20);
		shad1.setOffsetX(20);
		shad1.setOffsetY(20);
                //adding the shadow and reflection
                ref1.setInput(shad1);
                //the perspective
		PerspectiveTransform pers1 = new PerspectiveTransform();
		pers1.setUlx(100);
		pers1.setUly(110);
		pers1.setUrx(100);
		pers1.setUry(110);
		pers1.setLlx(300);
		pers1.setLly(300);
		pers1.setLrx(300);
		pers1.setLry(300);
		//adding the perspective to shad1
		pers1.setInput(ref1);
		
		//adding the effect to the circle
		circ1.setEffect(ref1);
		
		//adding the circle to the root group
		rootGroup.getChildren().add(circ1);
		
		//adding the root group to the root pane
		rootPane.getChildren().add(rootGroup);
		
		
		
		//the finalties
		Scene theScene = new Scene(rootPane);
		stage.setScene(theScene);
		stage.setX(900);
		stage.setWidth(400);
		stage.setHeight(500);
		stage.setResizable(false);
		stage.setTitle("My Pie-ish");
		stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
