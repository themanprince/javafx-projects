package shadowmod;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.stage.Stage;

public class ShadowMod extends Application {

    
    //the first segment and its controls
    
    //the rectangle and its group
    Rectangle theRect = new Rectangle(150, 0, 200, 200);
    Group rectGroup = new Group();
    
    //the combo boxes
    ComboBox<Paint> rectColor = new ComboBox(), shadowColor = new ComboBox();
    ComboBox<Integer> shadowWidth = new ComboBox(), shadowHeight = new ComboBox(), shadowHOffset = new ComboBox(), shadowVOffset = new ComboBox(), shadowRadius = new ComboBox();
    
    //the rectangle's shadow
    DropShadow theShadow = new DropShadow();
    
    //the root VBox
    VBox root = new VBox();
    
    //the segmenting root
    HBox segRoot = new HBox();
    
    
    //the second segment and its controls
    
    //the rectangle and its group
    Rectangle rect2 = new Rectangle(700, 0, 200, 200);
    Group rectGroup2 = new Group();
    
    //the combo boxes
    ComboBox<Paint> rectColor2 = new ComboBox(), shadowColor2 = new ComboBox();
    ComboBox<Integer> shadowWidth2 = new ComboBox(), shadowHeight2 = new ComboBox(), shadowVOffset2 = new ComboBox(), shadowHOffset2 = new ComboBox(), shadowRadius2 = new ComboBox();
    
    //the rectangle's shadow
    InnerShadow theShadow2 = new InnerShadow();
    
    //the root vbox
    VBox root2 = new VBox();
    
    @Override
    public void start(Stage stage) {
        //customizing the root group before adding things to it
        root.setSpacing(50);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        
        
        //customizing the rectangle
        //its shadow first
        theShadow.setWidth(20);
        theShadow.setHeight(20);
        theShadow.setOffsetX(20);
        theShadow.setOffsetY(20);
        theShadow.setRadius(10);
        theRect.setEffect(theShadow);
        //the rest of it
        theRect.setFill(Color.LIGHTGRAY);
        theRect.setStroke(Color.BLACK);
        theRect.setStrokeWidth(3);
        //adding the rectangle to its group
        rectGroup.getChildren().add(theRect);
        //adding the rectGroup to the root pane
        root.getChildren().add(theRect);
        
        
        //customizing the first row of combo boxes
        rectColor.getItems().addAll(Color.PINK, Color.AQUA, Color.LIGHTGRAY, Color.BLUE, Color.RED, Color.ORANGE, Color.GREEN);
        rectColor.setEditable(false);
        rectColor.setVisibleRowCount(5);
        rectColor.setPrefWidth(200);
        rectColor.setPromptText("Rectangle Color");
        rectColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theRect.setFill(rectColor.getSelectionModel().getSelectedItem());
                rectColor.setPromptText("Rectangle Color");
            }
        });
        shadowWidth.setEditable(false);
        shadowWidth.setPromptText("Shadow Width");
        shadowWidth.setVisibleRowCount(5);
        shadowWidth.setPrefWidth(200);
        shadowWidth.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowWidth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theShadow.setWidth(shadowWidth.getSelectionModel().getSelectedItem());
                shadowWidth.setPromptText("Shadow Width");
            }
        });
        shadowHeight.setEditable(false);
        shadowHeight.setPromptText("Shadow Height");
        shadowHeight.setVisibleRowCount(5);
        shadowHeight.setPrefWidth(200);
        shadowHeight.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowHeight.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                theShadow.setHeight(shadowHeight.getSelectionModel().getSelectedItem());
                shadowHeight.setPromptText("Shadow Height");
            }
        });
        //the hbox for the first pane
        HBox firstRow = new HBox();
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setSpacing(30);
        firstRow.getChildren().addAll(rectColor, shadowWidth, shadowHeight);
        root.getChildren().add(firstRow);

        
        //the second row of combo boxes
        shadowHOffset.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowHOffset.setEditable(false);
        shadowHOffset.setPromptText("The Shadow's Horizontal Offset");
        shadowHOffset.setVisibleRowCount(5);
        shadowHOffset.setPrefWidth(200);
        shadowHOffset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theShadow.setOffsetX(shadowHOffset.getSelectionModel().getSelectedItem());
                shadowHOffset.setPromptText("The Shadow's Horzontal Offset");
            }
        });
        shadowVOffset.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowVOffset.setEditable(false);
        shadowVOffset.setPromptText("The Shadow's Vertical Offset");
        shadowVOffset.setVisibleRowCount(5);
        shadowVOffset.setPrefWidth(200);
        shadowVOffset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theShadow.setOffsetY(shadowVOffset.getSelectionModel().getSelectedItem());
                shadowVOffset.setPromptText("The Shadow's Vertical Offset");
            }
        });
        shadowRadius.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowRadius.setEditable(false);
        shadowRadius.setPromptText("The Shadow's Blur Radius");
        shadowRadius.setVisibleRowCount(5);
        shadowRadius.setPrefWidth(200);
        shadowRadius.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
              theShadow.setRadius(shadowRadius.getSelectionModel().getSelectedItem());  
              shadowRadius.setPromptText("The Shadow's Radius");
            }
        });
        //the horizontal pane for the second row
        HBox secondRow = new HBox();
        secondRow.setSpacing(30);
        secondRow.setPadding(new Insets(10));
        secondRow.setAlignment(Pos.CENTER);
        secondRow.getChildren().addAll(shadowHOffset, shadowVOffset, shadowRadius);
        root.getChildren().add(secondRow);
        
        
        //the third row for the shadow's color
        shadowColor.setEditable(false);
        shadowColor.setPromptText("The Shadow's Color");
        shadowColor.setPrefWidth(200);
        shadowColor.setVisibleRowCount(5);
        shadowColor.getItems().addAll(Color.PINK, Color.AQUA, Color.LIGHTGRAY, Color.BLUE, Color.RED, Color.ORANGE, Color.GREEN);
        shadowColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theShadow.setColor((Color)shadowColor.getSelectionModel().getSelectedItem());
                shadowColor.setPromptText("The Shadow's Color");
            }
        });
        //its horizintal pane
        HBox thirdRow = new HBox();
        thirdRow.setPadding(new Insets(10));
        thirdRow.setAlignment(Pos.CENTER_LEFT);
        thirdRow.getChildren().add(shadowColor);
        root.getChildren().add(thirdRow);
        
        //adding the first segment
        segRoot.getChildren().add(root);
        
        
        //the second segment of the program

        //customizing the vbox of the second segment
        root2.setSpacing(30);
        root2.setPadding(new Insets(10));
        root2.setAlignment(Pos.CENTER);
        
        
        //the shadow of the rectangle
        theShadow2.setHeight(20);
        theShadow2.setWidth(20);
        theShadow2.setRadius(10);
        theShadow2.setColor(Color.BLACK);
        theShadow2.setOffsetX(20);
        theShadow2.setOffsetY(20);
        //customizing the rectangle to add it to the root group
        rect2.setFill(Color.LIGHTGRAY);
        rect2.setEffect(theShadow2);
        rect2.setStroke(Color.BLACK);
        rect2.setStrokeWidth(3);
        //adding it to its root group
        rectGroup2.getChildren().add(rect2);
        //adding the group to the second segment's root pane
        root2.getChildren().add(rectGroup2);
        
        //the first row of the second segment
        rectColor2.setEditable(false);
        rectColor2.setPrefWidth(200);
        rectColor2.setVisibleRowCount(5);
        rectColor2.getItems().addAll(Color.FUCHSIA, Color.DARKGREY, Color.BLANCHEDALMOND, Color.BLUEVIOLET);
        rectColor2.setPromptText("The Rectangle's Color");
        rectColor2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                rect2.setFill((Color)rectColor2.getSelectionModel().getSelectedItem());
                rectColor2.setPromptText("The Rectangle's Color");
            }
        });
        
        shadowWidth2.setEditable(false);
        shadowWidth2.setPrefWidth(200);
        shadowWidth2.setVisibleRowCount(5);
        shadowWidth2.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowWidth2.setPromptText("The Shadow's Width");
        shadowWidth2.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent e) {
               theShadow2.setWidth(shadowWidth2.getSelectionModel().getSelectedItem());
               shadowWidth2.setPromptText("The Shadow's Width");
           }
        });
        
        shadowHeight2.setEditable(false);
        shadowHeight2.setPrefWidth(200);
        shadowHeight2.setVisibleRowCount(5);
        shadowHeight2.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowHeight2.setPromptText("The Shadow's Height");
        shadowHeight2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theShadow2.setHeight(shadowHeight2.getSelectionModel().getSelectedItem());
                shadowHeight2.setPromptText("The Shadow's Height");
            }
        });
        //their hbox
        HBox firstRow2 = new HBox();
        firstRow2.setSpacing(30);
        firstRow2.setPadding(new Insets(10));
        firstRow2.setAlignment(Pos.CENTER);
        firstRow2.getChildren().addAll(rectColor2, shadowWidth2, shadowHeight2);
        root2.getChildren().add(firstRow2);
        
        
         //the second row
        shadowHOffset2.setEditable(false);
        shadowHOffset2.setPrefWidth(200);
        shadowHOffset2.setVisibleRowCount(5);
        shadowHOffset2.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowHOffset2.setPromptText("The Shadow's Horizontal Offset");
        shadowHOffset2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theShadow2.setOffsetX(shadowHOffset2.getSelectionModel().getSelectedItem());
                shadowHOffset2.setPromptText("The Shadow's Horizontal Offset");
            }
        });
        
        shadowVOffset2.setEditable(false);
        shadowVOffset2.setPrefWidth(200);
        shadowVOffset2.setVisibleRowCount(5);
        shadowVOffset2.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowVOffset2.setPromptText("The Shadow's Vertical Offset");
        shadowVOffset2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theShadow2.setOffsetY(shadowVOffset2.getSelectionModel().getSelectedItem());
                shadowVOffset2.setPromptText("The Shadow's Vertical Offset");
            }
        });
        
        shadowRadius2.setEditable(false);
        shadowRadius2.setPrefWidth(200);
        shadowRadius2.setVisibleRowCount(5);
        shadowRadius2.getItems().addAll(0, 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        shadowRadius2.setPromptText("The Shadow's Radius");
        shadowRadius2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theShadow2.setRadius(shadowRadius2.getSelectionModel().getSelectedItem());
                shadowRadius2.setPromptText("The Shadow's Radius");
            }
        });
        
        //their hbox
        HBox secondRow2 = new HBox();
        secondRow2.setSpacing(30);
        secondRow2.setPadding(new Insets(10));
        secondRow2.setAlignment(Pos.CENTER);
        secondRow2.getChildren().addAll(shadowHOffset2, shadowVOffset2, shadowRadius2);
        root2.getChildren().add(secondRow2);
       
        
        //the third row for the shadow's color
        shadowColor2.setEditable(false);
        shadowColor2.setPromptText("The Shadow's Color");
        shadowColor2.setPrefWidth(200);
        shadowColor2.setVisibleRowCount(5);
        shadowColor2.getItems().addAll(Color.FUCHSIA, Color.DARKGREY, Color.BLANCHEDALMOND, Color.BLUEVIOLET);
        shadowColor2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                theShadow2.setColor((Color)shadowColor2.getSelectionModel().getSelectedItem());
                shadowColor2.setPromptText("The Shadow's Color");
            }
        });
        //its horizintal pane
        HBox thirdRow2 = new HBox();
        thirdRow2.setPadding(new Insets(10));
        thirdRow2.setAlignment(Pos.CENTER_LEFT);
        thirdRow2.getChildren().add(shadowColor2);
        root2.getChildren().add(thirdRow2);


        
        
        
        //adding the second segment
        segRoot.getChildren().add(root2);
        
        //the scene and the stage
        ScrollPane theRealRoot = new ScrollPane();
        theRealRoot.setContent(segRoot);
        Scene theScene = new Scene(theRealRoot);
        theScene.getStylesheets().clear();
        theScene.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
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
