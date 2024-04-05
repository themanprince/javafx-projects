package colorpickertest;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.beans.value.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class ColorPickerTest extends Application {
	
	//the two circles
	Circle circ1 = new Circle(100, 100, 150), circ2 = new Circle(100, 100, 50);
	
	//the two color pickers'
	ColorPicker pick1 = new ColorPicker(), pick2 = new ColorPicker();
		
	//reference to the stage
	Stage stageRef;
			
	//the label at the top
	Label theLab = new Label("Switch the colors using the picker and resize the \n stage till the smaller one becomes bigger..."), lab1 = new Label("Circle 1"), lab2 = new Label("Circle 2");		
		
	//the root pane
	VBox rootPane = new VBox();
		
		
    @Override
    public void start(Stage stage) {
	    stageRef = stage;
	    
	    //customizing theLab
	    theLab.setStyle("-fx-font-size: 12px;"
	            + "-fx-font-family: sans-serif;");
	    
	    //customizing the rootPane
	    rootPane.setSpacing(30);
	    rootPane.setAlignment(Pos.CENTER);
	    
		//customizing the two circles
		circ1.setStroke(Color.BLACK);
		circ1.setStrokeWidth(3);
		circ1.setFill(Color.rgb(12, 120, 34, 0.5));
		
		circ2.setStroke(Color.BLACK);
		circ2.setStrokeWidth(3);
		circ2.setFill(Color.PINK);
		
		
		//binding the stage's width and height properties
		//to the circles' widths and heights for resizing
		stageRef.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> value, Number oldValue, Number newValue) {
				//if the stage increases in width, the first circle
				//should also incease in size by the same amount
				//while the second one should reduce by the same amount
				if(newValue.intValue() > oldValue.intValue()) {
					circ1.setRadius(circ1.getRadius() + (newValue.intValue() - oldValue.intValue()));
					circ2.setRadius(circ2.getRadius() - (newValue.intValue() - oldValue.intValue()));
				}
				
				//if the stage decreases in width, the first circle
				//should reduce in size, while the second one should increase
				//in size
				if(newValue.intValue() < oldValue.intValue()) {
				circ1.setRadius(circ1.getRadius() - (oldValue.intValue() - newValue.intValue()));
				circ2.setRadius(circ2.getRadius() + (oldValue.intValue() - newValue.intValue()));
				}
			stageRef.setTitle("Circle 1 - " +circ1.getRadius() + "... Circle 2 - " +circ2.getRadius());
			}
		});
		stageRef.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> value, Number oldValue, Number newValue) {
				//if the stage increases in width, the first circle should
				//should reduce in size by the same amount
				//while the second one should increase by the same amount
				if(newValue.intValue() > oldValue.intValue()) {
					circ1.setRadius(circ1.getRadius() - (newValue.intValue() - oldValue.intValue()));
					circ2.setRadius(circ2.getRadius() + (newValue.intValue() - oldValue.intValue()));
				}
				
				//if the stage reduces in height, the first circle should
				//increase in size, while the secons one should reduce
				//in size
				if(newValue.intValue() < oldValue.intValue()) {
				circ1.setRadius(circ1.getRadius() + (oldValue.intValue() - newValue.intValue()));
				circ2.setRadius(circ2.getRadius() - (oldValue.intValue() - newValue.intValue()));
				}
					stageRef.setTitle("Circle 1 - " +circ1.getRadius() + "... Circle 2 - " +circ2.getRadius());
			}
		});
	    
	    
	    //the root group
	    Group rootGroup = new Group();
	    rootGroup.getChildren().addAll(circ2, circ1);
		
		
		//adding them to the root pane
		rootPane.getChildren().addAll(theLab, rootGroup);
	        
	        
	        
	        //the two color pickers
	        pick1.valueProperty().addListener(new ChangeListener<Color>() {
	        @Override
	        public void changed(ObservableValue<? extends Color> value, Color oldValue, Color newValue) {
	             circ1.setFill(newValue);
	             circ1.setOpacity(0.5);
	        }
	        });
	        pick2.valueProperty().addListener(new ChangeListener<Color>() {
	        @Override
	        public void changed(ObservableValue<? extends Color> value, Color oldValue, Color newValue) {
	            circ2.setFill(newValue);
	        }
	        });
	        
	        //adding them to the scene
	        VBox pick1Pane = new VBox(), pick2Pane = new VBox();
	        pick1Pane.getChildren().addAll(lab1, pick1);
	        pick2Pane.getChildren().addAll(lab2, pick2);
	        
	        HBox forBoth = new HBox();
	        forBoth.setSpacing(80);
	        forBoth.setPadding(new Insets(10));
	        forBoth.getChildren().addAll(pick1Pane, pick2Pane);
	        
	        
	        rootPane.getChildren().add(forBoth);
	        
	        
	        
	        
	        //the finalties
	        Scene theScene = new Scene(rootPane);
	        stage.setScene(theScene);
	        stage.setX(900);
	        stage.setResizable(true);
	        stage.setWidth(400);
	        stage.setHeight(500);
	        stage.show();
    }
    
    
    public static void main(String[] args) {
    launch(args);
    }
}