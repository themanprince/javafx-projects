import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;

public class GridPaneTest3 extends Application {

//The name and address labels and textfields
Label nameLbl = new Label("Name: "), addressLbl = new Label("Address: ");
TextField nameFld = new TextField(), addressFld = new TextField();

//The size label and radio buttons
Label size = new Label("Size");
RadioButton small = new RadioButton("Small"), medium = new RadioButton("Medium"), large = new RadioButton("Large");
ToggleGroup sizeGroup = new ToggleGroup();

//the toppings label and radio buttons
Label topping = new Label("Topping");
RadioButotn crayfish = new RadioButton("CrayFish"), lobster = new RadioButton("Lobster"), shrimp = new RadioButotn("Lobster");
ToggleGroup toppingsGroup = new ToggleGroup();

//the spices label and check boxes
Label spice = new Label("Spice");
CheckBox pepper = new CheckBox("Pepper"), salt = new CheckBox("Salt"), tomatoes = new CheckBox("Tomatoes");


@Override
public void start(Stage stage) {
System.out.println("test");
}

public static void main(String[] args) {
launch(args);
}
}