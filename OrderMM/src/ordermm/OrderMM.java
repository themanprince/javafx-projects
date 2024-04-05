package ordermm;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn.CellEditEvent;

public class OrderMM extends Application {
	//the Scene and root pane
    Scene theScene;
    VBox root = new VBox(10);

	//the "order Moi-Moi" Label
    Label order = new Label("Order Moi Moi");
    Font orderFnt = new Font("Arial", 30);
    HBox orderPane = new HBox();

	//the name and address pane
    Label name = new Label("Name:"), addr = new Label("Address:");
    TextField nameFld = new TextField(), addrFld = new TextField();
    VBox namePane = new VBox(2), addrPane = new VBox(2);
	FlowPane nameAndAddr = new FlowPane(Orientation.HORIZONTAL);

	//beans mixture
	Label beansLbl = new Label("SELECT YOUR PREFFERED BEANS MIXTURE");
	CheckBox soya = new CheckBox("Soya Beans"), brown = new CheckBox("Brown Beans"), white = new CheckBox("White Beans");
	HBox beansPane = new HBox(15);
	VBox selBeans = new VBox(3);
	boolean whiteSel = false, brownSel = false, soyaSel = false;

	//crayfish mixture
	Label seaFoodLbl = new Label("SELECT YOUR PREFFERED SEA FOOD MIXTURE");
	RadioButton crayfish = new RadioButton("Crayfish"), crabs = new RadioButton("Crabs"), shrimp = new RadioButton("Shrimps"), BSCrayfish = new RadioButton("Big-sized Crayfish");
	ToggleGroup seaFood = new ToggleGroup();
	HBox seaFoodPane = new HBox(15);
	VBox selSeaFood = new VBox(2);
	String selectedSeaFood = "crayfish";

	//addables
	HBox addables = new HBox(9);
	ComboBox pepper = new ComboBox(), vegetables = new ComboBox(), tomatoes = new ComboBox();
	String wantsPepper = "no", wantsVegetables = "no", wantsTomatoes = "no";

	//payment method
	Label paymentLbl = new Label("PAYMENT METHOD");
	Font paymentFnt = new Font("Algeria", 17);
	FlowPane payDetails = new FlowPane(Orientation.HORIZONTAL);
	Label bank = new Label("Bank"), accNum = new Label("Acc. Num"), pin = new Label("Pin"), cardType = new Label("Card Type");
	ComboBox bankDrop = new ComboBox(), cardTypeDrop = new ComboBox();
	TextField accNumDrop = new TextField(), pinDrop = new TextField();
	VBox bankPane = new VBox(3), accNumPane = new VBox(3), pinPane = new VBox(3), cardTypePane = new VBox(3);
	VBox payRoot = new VBox(10);

	//the bid "Add OrderTo Cart" Button
	Button AOTC = new Button("Add Order To Cart");
	HBox AOTCPane = new HBox();

	//the cart
	TableView<Table> cart = new TableView<>();


    @Override
    public void start(Stage stage) {
	//the big label
	order.setFont(orderFnt);
	orderPane.setAlignment(Pos.CENTER);
	orderPane.setPadding(new Insets(13, 0, 13,0));
	orderPane.getChildren().add(order);
	root.getChildren().add(orderPane);

	//the name and address fields        
	namePane.getChildren().addAll(name, nameFld);
	addrPane.getChildren().addAll(addr, addrFld);
	nameAndAddr.setAlignment(Pos.CENTER);
	nameAndAddr.getChildren().addAll(namePane, addrPane);
	root.getChildren().add(nameAndAddr);

	//the beans mixture pane
	soya.setOnAction(new CheckListeners());
	white.setOnAction(new CheckListeners());
	brown.setOnAction(new CheckListeners());
	beansPane.setAlignment(Pos.CENTER);
	beansPane.getChildren().addAll(soya, brown, white);
	selBeans.setPadding(new Insets(20, 2, 20, 2));
	selBeans.setAlignment(Pos.CENTER);
	selBeans.getChildren().addAll(beansLbl, beansPane);
	root.getChildren().add(selBeans);

	//sea food mixture
	crayfish.setToggleGroup(seaFood);
	crayfish.setSelected(true);
	crayfish.setOnAction(new CheckListeners());
	crabs.setToggleGroup(seaFood);
	crabs.setOnAction(new CheckListeners());
	shrimp.setToggleGroup(seaFood);
	shrimp.setOnAction(new CheckListeners());
	BSCrayfish.setToggleGroup(seaFood);
	BSCrayfish.setOnAction(new CheckListeners());
	seaFoodPane.setAlignment(Pos.CENTER);
	selSeaFood.setAlignment(Pos.CENTER);
	seaFoodPane.getChildren().addAll(crayfish, crabs, shrimp, BSCrayfish);
	selSeaFood.setPadding(new Insets(20, 0, 20, 0));
	selSeaFood.getChildren().addAll(seaFoodLbl, seaFoodPane);
	root.getChildren().add(selSeaFood);

	//the addables
	pepper.setPromptText("With Pepper?");
	pepper.setPrefWidth(230);
	pepper.getItems().addAll("yes", "no");
	vegetables.setPromptText("With Vegetables?");
	vegetables.setPrefWidth(230);
	vegetables.getItems().addAll("yes", "no");
	tomatoes.setPrefWidth(230);
	tomatoes.setPromptText("With Tomatoes?");
	tomatoes.getItems().addAll("yes", "no");
	addables.setPadding(new Insets(20, 0, 20, 0));
	addables.setAlignment(Pos.CENTER);
	addables.getChildren().addAll(pepper, vegetables, tomatoes);
	root.getChildren().add(addables);

	//the payment part
	payDetails.setAlignment(Pos.CENTER);
	paymentLbl.setFont(paymentFnt);
	bankDrop.setPrefWidth(150);
	bankDrop.setEditable(true);
	bankDrop.setPromptText("First Bank Of Nigeria");
	bankDrop.getItems().addAll("First Bank of Nigeria", "Stan. IBTC", "Union Bank", "Diamond Yello Bank");
	bankPane.getChildren().addAll(bank, bankDrop);
	accNumDrop.setPrefWidth(150);
	accNumPane.getChildren().addAll(accNum, accNumDrop);
	pinDrop.setPrefWidth(80);
	pinPane.getChildren().addAll(pin, pinDrop);
	cardTypeDrop.setPrefWidth(100);
	cardTypeDrop.setPromptText("Visa");
	cardTypeDrop.getItems().addAll("MasterCard", "Visa");
	cardTypeDrop.setEditable(true);
	cardTypePane.getChildren().addAll(cardType, cardTypeDrop);
	payDetails.getChildren().addAll(bankPane, accNumPane, pinPane, cardTypePane);
	payRoot.setAlignment(Pos.CENTER);
	payRoot.getChildren().addAll(paymentLbl, payDetails);
	root.getChildren().add(payRoot);

	//the big "Add Order To Cart" Button
	AOTC.setPrefWidth(300);
	AOTC.setPrefHeight(70);
	AOTC.setOnAction(new AOTCHandle());
	AOTCPane.setAlignment(Pos.CENTER);
	AOTCPane.getChildren().add(AOTC);
	root.getChildren().add(AOTCPane);


//the cart
TableColumn title = new TableColumn("        ORDER CART"), nameCol = new TableColumn("Name"), mmspecsCol = new TableColumn("Specifications"), addressCol = new TableColumn("Address");
title.setPrefWidth(3000);
nameCol.setPrefWidth(300);
mmspecsCol.setPrefWidth(300);
addressCol.setPrefWidth(200);
nameCol.setCellValueFactory(new PropertyValueFactory<Table, String>("Name"));
nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
nameCol.setOnEditCommit(new EventHandler<CellEditEvent>() {
@Override
public void handle(CellEditEvent e) {
    ((Table)e.getTableView().getItems().get(e.getTablePosition().getRow())).setName(e.getNewValue().toString());
}    
});

mmspecsCol.setCellValueFactory(new PropertyValueFactory<Table, String>("Mmspecs"));
mmspecsCol.setCellFactory(TextFieldTableCell.forTableColumn());
mmspecsCol.setOnEditCommit(new EventHandler<CellEditEvent>() {
@Override
public void handle(CellEditEvent e) {
    ((Table)e.getTableView().getItems().get(e.getTablePosition().getRow())).setMmspecs(e.getNewValue().toString());
}    
});
addressCol.setCellValueFactory(new PropertyValueFactory<Table, String>("Address"));
addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
addressCol.setOnEditCommit(new EventHandler<CellEditEvent>() {
@Override
public void handle(CellEditEvent e) {
    ((Table)e.getTableView().getItems().get(e.getTablePosition().getRow())).setName(e.getNewValue().toString());
}    
});
title.getColumns().addAll(nameCol, mmspecsCol, addressCol);
cart.getColumns().add(title);
ObservableList<Table> tableData = FXCollections.observableArrayList();
cart.setItems(tableData);
root.getChildren().add(cart);



//the stage and the scene
theScene = new Scene(root);
stage.setScene(theScene);
stage.setResizable(false);
stage.setWidth(800);
stage.setHeight(600);
stage.setTitle("Ad. Cate");
stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
class CheckListeners implements EventHandler<ActionEvent> {
@Override
public void handle(ActionEvent e) {
    if(e.getSource() == soya) {
        soyaSel = true;
    }
    if(e.getSource() == brown) {
        brownSel = true;
    }if(e.getSource() == white) {
        whiteSel = true;
    }
    if(e.getSource() == crayfish) {
        selectedSeaFood = "crayfish";
    }else if(e.getSource() == crabs) {
        selectedSeaFood = "crabs";
    }else if(e.getSource() == shrimp) {
        selectedSeaFood = "shrimp";
    }else if(e.getSource() == BSCrayfish) {
        selectedSeaFood = "BSCrayfish";
    }
}    
}

//my info class
class Info {
String title, msg;
public Info(String title, String msg) {
    this.title = title;
    this.msg = msg;
}
public void show() {
Text mesg = new Text(this.msg);
HBox root = new HBox();
root.getChildren().add(mesg);
Scene theScene = new Scene(root);
    
    Stage stage = new Stage();
stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle(title);
 stage.setResizable(false);
 stage.setWidth(400);
 stage.setHeight(400);
stage.show();
}
}

class Table {
   public SimpleStringProperty name = new SimpleStringProperty(), mmspecs = new SimpleStringProperty(), address = new SimpleStringProperty();
    
    public Table() {}
    
    public Table(String name, String mmspecs, String address) {
this.name = new SimpleStringProperty(name);
    this.address = new SimpleStringProperty(address);
    this.mmspecs = new SimpleStringProperty(mmspecs);
    }
    
    //name
   void setName(String name) {
        this.name.set(name);
    }
    String getName() {
        return this.name.getValue();
    }
    
    //mmspecs
    void setMmspecs(String mmspecs) {
        this.mmspecs.set(mmspecs);
    }
  String getMmspecs() {
        return this.mmspecs.getValue();
    }
    
    //address
    void setAddress(String address) {
        this.address.set(address);
    }
    String getAddress() {
        return this.address.getValue();
    }
}

//the add to cart event handler
class AOTCHandle implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
        //first scrutinise and the field sections to make sure there is no error

        //the error message. subsequent error reports will be added as they are discovered. and it will be  eventually displayed to the user.
        String errMsg = "";

        //if there is any error at all, start building the error message, 
        //then return it to the user
        if(nameOrAddressEmpty() || beansMixtureUnset() || addablesUnset() || paymentUnset()) {
            //then there is an error

            //checking which error and building the error message
            
            //nameOrAddressEmpty()
            if(nameOrAddressEmpty()) {
                errMsg += "The Name/Address field was not set \n";
            }
            if(beansMixtureUnset()) {
                errMsg += "You must pick at least one type of beans \n";
            }
            
             if(addablesUnset()) {
                 errMsg += "You must pick at least one addable from pepper, vegetables and tomatoes";
                
             }

             if(paymentUnset()) {
                 errMsg += "You must enter your complete bank details";
             }

             //the error window
             Info err = new Info("Error!", "The following error(s) occured" + errMsg);
			err.show();
        }else{
            //there is no error, create the new column and add to the table
			Table colToAdd = new Table(nameFld.getText(), "", addrFld.getText());
			colToAdd.setName(nameFld.getText());
			String MoiMoiSpec = "Mixture of ";
			if(soya.isSelected()) {
			    MoiMoiSpec += "Soya Beans, ";
			}
			if(brown.isSelected()) {
			    MoiMoiSpec += "Brown Beans, ";
			}
			if(white.isSelected()){
			    MoiMoiSpec += "White beans, ";
			}

			MoiMoiSpec += "with ";

			if(crayfish.isSelected()) { 
			    MoiMoiSpec += "crayfish, ";
			}
			else if(crabs.isSelected()){
			    MoiMoiSpec += "crabs, ";
			}
			else if(shrimp.isSelected()){
			    MoiMoiSpec += "shrimp, ";
			}else if(BSCrayfish.isSelected()){
			    MoiMoiSpec += "Big Size Crayfish, ";
			} 
			MoiMoiSpec += ". \n";
			if("yes".equals((String)pepper.getSelectionModel().getSelectedItem())) {
			MoiMoiSpec += "Pepper, ";
			}
			if("yes".equals((String)vegetables.getSelectionModel().getSelectedItem())) {
			    MoiMoiSpec += "Vegetables, ";
			}
			if("yes".equals((String)tomatoes.getSelectionModel().getSelectedItem())) {
			MoiMoiSpec += "Tomatoes, ";    
			}

			MoiMoiSpec += "will be added";

			colToAdd.setMmspecs(MoiMoiSpec);

			colToAdd.setAddress(addrFld.getText());
			cart.getItems().add(colToAdd);
	        }
        }

    //these methods are for checking if the field sections are empty
    boolean nameOrAddressEmpty() {
        return nameFld.getText().isEmpty() || addrFld.getText().isEmpty();
    
}
    
    boolean beansMixtureUnset() {
        return (!soya.isSelected()) || (!brown.isSelected()) || (!white.isSelected());
}



    boolean addablesUnset() {
        return ("no".equals((String)pepper.getSelectionModel().getSelectedItem()) || "no".equals((String)vegetables.getSelectionModel().getSelectedItem()) || "no".equals(tomatoes.getSelectionModel().getSelectedItem()));  
}
    
 boolean paymentUnset() {
        return "".equals((String)bankDrop.getSelectionModel().getSelectedItem()) || accNumDrop.getText().isEmpty() || pinDrop.getText().isEmpty() || "".equals((String)cardTypeDrop.getSelectionModel().getSelectedItem());
 }   
    
}
}
