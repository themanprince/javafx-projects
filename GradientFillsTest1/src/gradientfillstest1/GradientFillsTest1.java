package gradientfillstest1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;

public class GradientFillsTest1 extends Application {

    //the root group
    Group root = new Group();
    
    
    @Override
    public void start(Stage stage) {
    //the fisrt rectangle
    Rectangle rect1 = new Rectangle(20, 20, 100, 70);

        //customizing the first rectangle and adding the gradient fill to the first rectangle before adding it to the root group
        LinearGradient lin1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.BLACK));
        rect1.setFill(lin1);
        rect1.setStrokeWidth(3);
        rect1.setStroke(Color.BLACK);
    //adding the rectangle to the root group
        root.getChildren().add(rect1);
        
        
        //the second rectangle
        Rectangle rect2 = new Rectangle(140, 20, 100, 70);
        //customizing it
        LinearGradient lin2 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.BLACK));
        rect2.setFill(lin2);
        rect2.setStrokeWidth(3);
        rect2.setStroke(Color.BLACK);
        //adding the rectangle to the root group
        root.getChildren().add(rect2);

/*        //the third rectangle(wrong)
        Rectangle rect3 = new Rectangle(260, 20, 100, 70);
        //customizing it
        LinearGradient lin3 = new LinearGradient(0, 1, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(0.58, Color.BLACK));
        rect3.setFill(lin3);
        rect3.setStroke(Color.BLACK);
        rect3.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(rect3);
*/
        
        //the third rectagnle(redone)
        Rectangle rect3 = new Rectangle(260, 20, 100, 70);
        //customizing it
        LinearGradient lin3 = new LinearGradient(0, 1, 1, 0, true,  CycleMethod.NO_CYCLE, new Stop(0.2, Color.WHITE), new Stop(0.6, Color.BLACK));
        rect3.setFill(lin3);
        rect3.setStrokeWidth(3);
        rect3.setStroke(Color.BLACK);
        //adding it to the root group
        root.getChildren().add(rect3);
        
        //the fourth rectangle
        Rectangle rect4 = new Rectangle(20, 110, 100, 70);
        //customizing it
        LinearGradient lin4 = new LinearGradient(0, 0, 0, 0.2, true, CycleMethod.REPEAT, new Stop(0.1, Color.BLACK), new Stop(0.2, Color.WHITE));
        rect4.setFill(lin4);
        rect4.setStrokeWidth(3);
        rect4.setStroke(Color.BLACK);
        //adding it to the root group
        root.getChildren().add(rect4);

        //the fifth rectangle
        Rectangle rect5 = new Rectangle(140, 110, 100, 70);
        //customizing it
        LinearGradient lin5 = new LinearGradient(0, 0, 0, 0.2, true, CycleMethod.REFLECT, new Stop(0, Color.BLACK), new Stop(1, Color.WHITE));
        rect5.setFill(lin5);
        rect5.setStroke(Color.BLACK);
        rect5.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(rect5);


          //the sixth rectangle
          Rectangle rect6 = new Rectangle(260, 110, 100, 70);
          //customizing it 
          RadialGradient rad1 = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.BLACK));
          rect6.setFill(rad1);
          rect6.setStroke(Color.BLACK);
          rect6.setStrokeWidth(3);
          //adding it to the root group
          root.getChildren().add(rect6);

          //the seventh rectangle
          Rectangle rect7 = new Rectangle(20, 200, 100, 70);
          //customizing it
          RadialGradient rad2 = new RadialGradient(0, 0, 0.5, 0.5, 0.1, false, CycleMethod.REFLECT, new Stop(0.2, Color.WHITE), new Stop(0.8, Color.BLACK));
          rect7.setFill(rad2);
          rect7.setStroke(Color.BLACK);
          rect7.setStrokeWidth(3);
          //adding it to the root group
          root.getChildren().add(rect7);
          
          
        
        
        //the scene and the stage
        Scene theScene = new Scene(root);
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
