package shapetest4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.event.*;
import javafx.scene.control.*;

public class ShapeTest4 extends Application {

//The root group
  Group root = new Group();
//the scaling button
  Button scaleBtn = new Button("SCALE");
  
  
    @Override
    public void start(Stage stage) {
        //customizing the stage
    stage.setX(900);
    stage.setWidth(430);
    stage.setHeight(500);
    
    
    //the loop to draw the grid lines 
    for(int i = 0; i < 100; i++) {
    //the horizontal line
    //10 is the constant space between them
    Line hor = new Line(0, i * 10, stage.getWidth(), i * 10);
      hor.setStroke(Color.BLACK);
      hor.setStrokeWidth(3);
      
      //the vertical line
      Line ver = new Line(i * 10, 0, i * 10, stage.getHeight() + 100);
        ver.setStroke(Color.BLACK);
        ver.setStrokeWidth(3);
        
        //adding them to the root group
        root.getChildren().addAll(hor, ver);
    }

  //the first rectangle
    Rectangle rect1 = new Rectangle(20, 70, 100, 70);
    rect1.setStroke(Color.rgb(120, 100, 12, 1));
    rect1.setStrokeWidth(3);
    rect1.setFill(Color.rgb(120, 100, 12, 0.45));
    //adding it to the root group
    root.getChildren().add(rect1);
    
    //the second rectangle
    Rectangle rect2 = new Rectangle(140, 70, 100, 70);
    rect2.setArcHeight(25);
    rect2.setArcWidth(25);
    rect2.setStroke(Color.rgb(120, 100, 12, 1));
    rect2.setStrokeWidth(3);
    rect2.setFill(Color.rgb(120, 100, 12, 0.45));
    //adding it to the root group
    root.getChildren().add(rect2);


      //the third rectangle
     Rectangle rect3 = new Rectangle(260, 70, 100, 70);
     rect3.setArcHeight(75);
     rect3.setArcWidth(75);
     rect3.setStroke(Color.rgb(120, 100, 12, 1));
     rect3.setStrokeWidth(3);
     rect3.setFill(Color.rgb(120, 100, 12, 0.45));
     //adding it to the root group
     root.getChildren().add(rect3);

      //the first circle
      Circle circ1 = new Circle(70, 265, 35);
      circ1.setFill(Color.rgb(120, 100, 12, 0.45));
      circ1.setStroke(Color.rgb(120, 100, 12, 1));
      circ1.setStrokeWidth(3);
      //adding it to the root group
      root.getChildren().add(circ1);
      
      //the first ellipse
      Ellipse ellip1 = new Ellipse(190, 265, 50, 35);
        ellip1.setFill(Color.rgb(120, 100, 12, 0.45));
        ellip1.setStroke(Color.rgb(120, 100, 12, 1));
        ellip1.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(ellip1);
        
       //the second ellipse
       Ellipse ellip2 = new Ellipse(315, 265, 35, 50);
       ellip2.setFill(Color.rgb(120, 100, 12, 0.45));
       ellip2.setStroke(Color.rgb(120, 100, 12, 1));
       ellip2.setStrokeWidth(3);
       //adding it to the root group
       root.getChildren().add(ellip2);
      
        //the first arc
        Arc arc1 = new Arc(70, 455, 50, 50, 30, 120);
        arc1.setType(ArcType.OPEN);
        arc1.setStroke(Color.rgb(120, 100, 12, 1));
        arc1.setFill(Color.rgb(120, 100, 12, 0.45));
        arc1.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(arc1);
        
        //the second arc
        Arc arc2 = new Arc(190, 455, 50, 50, 30, 120);
        arc2.setType(ArcType.CHORD);
        arc2.setFill(Color.rgb(120, 100, 12, 0.45));
        arc2.setStroke(Color.rgb(120, 100, 12, 1));
        arc1.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(arc2);
        
        //the third arc
        Arc arc3 = new Arc(310, 455, 50, 50, 30, 120);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.rgb(120, 100, 12, 0.45));
        arc3.setStroke(Color.rgb(120, 100, 12, 1));
        arc3.setStrokeWidth(3);
        //adding it to the root group
        root.getChildren().add(arc3);

        //the scaling button
        scaleBtn.setStyle("-fx-background-color: green; \n -fx-font-size: 35px; \n -fx-font-family: algerian;");
        scaleBtn.setOnAction(new scalListener());
          //adding it to the root group
          root.getChildren().add(scaleBtn);
      

      

      //rotating and translating the root group
      root.setRotate(9);
      root.setTranslateX(10);
      root.setTranslateY(30);
    //the scene and the finalties of the stage
    Scene theScene = new Scene(root);
    stage.setScene(theScene);
    stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
//the event listener for the scaling button
class scalListener implements EventHandler<ActionEvent> {
@Override
public void handle(ActionEvent e) {
if(scaleBtn.getText().equals("SCALE")) {
root.setScaleX(0.5);
root.setScaleY(0.5);
scaleBtn.setText("SCALE BACK");
}else if(scaleBtn.getText().equals("SCALE BACK")) {
root.setScaleX(1);
root.setScaleY(1);
scaleBtn.setText("SCALE");
}
}
}
}
