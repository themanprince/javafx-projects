package resultpreparator;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.control.cell.*;
import javafx.event.*;
import javafx.scene.text.*;
import javafx.collections.*;

public class ResultPreparator extends Application{
//the textfields and their labels
    Label subLbl = new Label("Subject:"), fTestLbl = new Label("First Test"), sTestLbl = new Label("Second Test"), examLbl = new Label("Exam"), totalLbl = new Label("Total"), remarkLbl = new Label("Remark");
TextField subFld =new TextField(), fTestFld = new TextField(), sTestFld = new TextField(), examFld = new TextField(), totalFld = new TextField(), remarkFld = new TextField();
VBox subPane = new VBox(2), fTestPane = new VBox(2), sTestPane = new VBox(2), examPane = new VBox(2), totalPane = new VBox(2), remarkPane = new VBox(2);    
//the pane for the labels and textfield
HBox laf = new HBox(7);
//regions for the labels and fields
Region one = new Region(), two = new Region(), three = new Region(), four = new Region(), five = new Region();
//the add button
Button addBtn = new Button("Add");
//this label is to position the button well, under
Label btnPH = new Label("");
VBox forBtn = new VBox(2);

//the scene
Scene theScene;
VBox rootPane = new VBox(7);
//the table and the table columns
TableView<MyTable> theTable = new TableView();
TableColumn<MyTable, String> subCol = new TableColumn("Subject"), remCol = new TableColumn("Remark");
TableColumn<MyTable, Integer> fTestCol = new TableColumn("First Test"), sTestCol = new TableColumn("Second Test"), examCol = new TableColumn("Exam"), totalCol = new TableColumn("Total");

//the buttons for deleting and uploading the result, and their pane
Button delSel = new Button("Delete Selected Row(s)"), delAll = new Button("Delete All Rows"), submit = new Button("Upload The Result");
HBox buttonsPane = new HBox(5);


public void start(Stage stage) throws Exception{
//setting up the labels and textfields and adding them to their respective panes
subFld.setPrefColumnCount(12);
fTestFld.setPrefColumnCount(5);
sTestFld.setPrefColumnCount(5);
examFld.setPrefColumnCount(5);
totalFld.setPrefColumnCount(5);
remarkFld.setPrefColumnCount(12);
subPane.getChildren().addAll(subLbl, subFld);
fTestPane.getChildren().addAll(fTestLbl, fTestFld);
sTestPane.getChildren().addAll(sTestLbl, sTestFld);
examPane.getChildren().addAll(examLbl, examFld);
totalPane.getChildren().addAll(totalLbl, totalFld);
remarkPane.getChildren().addAll(remarkLbl, remarkFld);
addBtn.setOnAction(new onClickAdd());
forBtn.getChildren().addAll(btnPH, addBtn);
laf.getChildren().addAll(subPane, one, fTestPane, two, sTestPane, three, examPane, four, totalPane, five, remarkPane, forBtn);
rootPane.getChildren().add(laf);

//setting up the columns to add to the table
subCol.setPrefWidth(150);
subCol.setCellValueFactory(new PropertyValueFactory<MyTable, String>("Subject"));
subCol.setSortable(false);
remCol.setPrefWidth(150);
remCol.setCellValueFactory(new PropertyValueFactory<MyTable, String>("Remark"));
remCol.setSortable(false);
fTestCol.setPrefWidth(150);
fTestCol.setCellValueFactory(new PropertyValueFactory<MyTable, Integer>("FTest"));
sTestCol.setPrefWidth(150);
sTestCol.setSortable(false);
sTestCol.setCellValueFactory(new PropertyValueFactory<MyTable, Integer>("STest"));
examCol.setPrefWidth(150);
examCol.setCellValueFactory(new PropertyValueFactory<MyTable, Integer>("Exam"));
examCol.setSortable(false);
totalCol.setPrefWidth(150);
totalCol.setCellValueFactory(new PropertyValueFactory<MyTable, Integer>("Total"));
totalCol.setSortable(false);
theTable.getColumns().addAll(subCol, fTestCol, sTestCol, examCol, totalCol, remCol);
//creating the observable list for the table
ObservableList<MyTable> theTableData = FXCollections.observableArrayList();
theTable.setItems(theTableData);
theTable.setTooltip(new Tooltip("The result sheet"));
theTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
rootPane.getChildren().add(theTable);

//the delete and upload buttons and their pane
int buttonHeight = 50;
delSel.setOnAction(new onClickAdd());
delSel.setPrefHeight(buttonHeight);
delAll.setOnAction(new onClickAdd());
delAll.setPrefHeight(buttonHeight);
submit.setOnAction(new onClickAdd());
submit.setPrefHeight(buttonHeight);
buttonsPane.setPadding(new Insets(10, 0, 10, 0));
buttonsPane.getChildren().addAll(delSel, delAll, submit);
buttonsPane.setAlignment(Pos.CENTER);
rootPane.getChildren().add(buttonsPane);




theScene = new Scene(rootPane);
stage.setScene(theScene);
stage.setWidth(900);
stage.setResizable(false);
stage.setHeight(400);
stage.show();
}

public static void main(String[] args) {
    launch(args);
}

//the table class
public class MyTable{
    String subject, remark;
    Integer fTest, sTest, exam, total;
    public MyTable(String subject, Integer fTest, Integer sTest, Integer exam, Integer total, String remark) {
this.subject = subject;
this.fTest = fTest;
this.sTest = sTest;
this.exam = exam;
this.total = total;
this.remark = remark;
    }
public String getSubject() {
    return this.subject;
}
public String getRemark() {
    return this.remark;
}
public Integer getFTest() {
    return this.fTest;
}
public Integer getSTest() {
    return this.sTest;
}
public Integer getExam() {
    return this.exam;
}
public Integer getTotal() {
    return this.total;
}

}

//my error class
public class Err{
    public String title, msg;
    public Err(String title, String msg) {
        this.title = title;
        this.msg = msg;
    }
public void show() {
    //Create new Stage
    Stage errStg = new Stage();
    //the root pane
    HBox root = new HBox(10);
    root.setPadding(new Insets(20, 0, 20, 0));
    Text message = new Text(msg);
    message.setFont(new Font("Arial", 12));
    root.getChildren().add(message);
    Scene scene = new Scene(root);
    errStg.setWidth(200);
    errStg.setScene(scene);
    errStg.setResizable(false);
    errStg.setTitle(title);
    errStg.initModality(Modality.WINDOW_MODAL);
    errStg.showAndWait();
}
}
public class onClickAdd implements EventHandler<ActionEvent> {

    Integer fTest = null, sTest = null, exam = null, total = null;

public void handle(ActionEvent e) {
if(e.getSource() == addBtn) {
//lets convert the string-integers to perfect integers
    try{    
    fTest = Integer.parseInt(fTestFld.getText());
sTest = Integer.parseInt(sTestFld.getText());
exam = Integer.parseInt(examFld.getText());
total = Integer.parseInt(examFld.getText());
}catch(Exception i){
    Err wrngVal = new Err("Error! Wrong value(s)", "You entered letter(s) where you \n were supposed to enter a \n number");
wrngVal.show();
return;
}
//next, adding them to the table
    theTable.getItems().add(new MyTable(subFld.getText(), this.fTest, this.sTest, this.exam, this.total, remarkFld.getText()));
 
//clearing the textfields
subFld.clear();
fTestFld.clear();
sTestFld.clear();
examFld.clear();
totalFld.clear();
remarkFld.clear();
}else if(e.getSource() == delSel) {
//create an observable list to hold the selected ones
ObservableList<MyTable> selOnes = FXCollections.observableArrayList();
selOnes = theTable.getSelectionModel().getSelectedItems();
for(MyTable i : selOnes) {
    theTable.getItems().remove(i);
}
}else if(e.getSource() == delAll) {
for(int i = 0; i < theTable.getItems().size(); i++) {
theTable.getItems().remove(i);
}
}else if(e.getSource() == submit) {
Err submitted = new Err("Upload Successful", "The result has been successfully uploaded \n to the schoool's database. ");    
submitted.show();
//clearing the textfields
subFld.clear();
fTestFld.clear();
sTestFld.clear();
examFld.clear();
totalFld.clear();
remarkFld.clear();
}
}
}
}
    