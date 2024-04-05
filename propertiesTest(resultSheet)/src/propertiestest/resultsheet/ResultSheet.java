package propertiestest.resultsheet;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.control.cell.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.geometry.*;

public class ResultSheet extends Application {

                //the table
                TableView<TableRow> theTable = new TableView();
                //the table columns
                TableColumn<TableRow, String> subjectCol = new TableColumn("Subject"), remarkCol = new TableColumn("Remark");
                TableColumn<TableRow, Integer> ftestCol = new TableColumn("First Test"), stestCol = new TableColumn("Second Test"), examCol = new TableColumn("Exam"), totalCol = new TableColumn("Total");
                
                //the table's scroll pane
                ScrollPane tableScroll = new ScrollPane();
                
                //the buttons and textfields for modifying table rows
                TextField subjectFld = new TextField(), ftestFld = new TextField(), stestFld = new TextField(), examFld = new TextField(), totalFld = new TextField(), remarkFld = new TextField();
                Button addRow = new Button("Add Row"), removeRow = new Button("Remove Selected Rows");

                //the pre-root scroll pane
                ScrollPane rootScroll = new ScrollPane();
                
                //the root pane
                VBox root = new VBox();
                
		@Override
		public void start(Stage stage) {
                    //customizing the root pane
                    root.setSpacing(30);
                    root.setPadding(new Insets(20));
                    
                    
                    

                    //the table first
                    theTable.setEditable(true);
                    theTable.setPrefHeight(300);
                    //the table scroll pane
                    tableScroll.setPrefHeight(300);
                    
                    
                    //the table columns
                    //#sortables
                    subjectCol.setSortable(false);
                    ftestCol.setSortable(false);
                    stestCol.setSortable(false);
                    examCol.setSortable(false);
                    totalCol.setSortable(false);
                    remarkCol.setSortable(false);
                    //#widths
                    subjectCol.setPrefWidth(200);
                    ftestCol.setPrefWidth(200);
                    stestCol.setPrefWidth(200);
                    examCol.setPrefWidth(200);
                    totalCol.setPrefWidth(200);
                    remarkCol.setPrefWidth(200);
                    //#cell value factories
                    subjectCol.setCellValueFactory(new PropertyValueFactory<TableRow, String>("subject"));
                    ftestCol.setCellValueFactory(new PropertyValueFactory<TableRow, Integer>("ftest"));
                    stestCol.setCellValueFactory(new PropertyValueFactory<TableRow, Integer>("stest"));
                    examCol.setCellValueFactory(new PropertyValueFactory<TableRow, Integer>("exam"));
                    totalCol.setCellValueFactory(new PropertyValueFactory<TableRow, Integer>("total"));
                    remarkCol.setCellValueFactory(new PropertyValueFactory<TableRow, String>("remark"));
                    //#cell factories
                    subjectCol.setCellFactory(TextFieldTableCell.<TableRow>forTableColumn());
                    remarkCol.setCellFactory(TextFieldTableCell.<TableRow>forTableColumn());
                    //#on edit commit event handler
                    subjectCol.setOnEditCommit(new EventHandler<CellEditEvent<TableRow, String>>() {
                        @Override
                        public void handle(CellEditEvent<TableRow, String> e) {
                            e.getTableView().getItems().get(e.getTablePosition().getRow()).setSubject(e.getNewValue());
                        }
                    });
                    remarkCol.setOnEditCommit(new EventHandler<CellEditEvent<TableRow, String>>() {
                        @Override
                        public void handle(CellEditEvent<TableRow, String> e) {
                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setRemark(e.getNewValue());
                        }
                    });
                    
                    //adding the columns to the table
                    theTable.getColumns().addAll(subjectCol, ftestCol, stestCol, examCol, totalCol, remarkCol);
                    
                    //adding the table to its scroll pane
                    tableScroll.setContent(theTable);
                    
                    //adding it to the root pane
                    root.getChildren().add(tableScroll);
                    
                    //the textfields and buttons for modifying the table row
                    //cusotmizing the textfields first
                    //#widths
                    subjectFld.setPrefWidth(100);
                    ftestFld.setPrefWidth(100);
                    stestFld.setPrefWidth(100);
                    examFld.setPrefWidth(100);
                    totalFld.setPrefWidth(100);
                    remarkFld.setPrefWidth(100);
                    //#prompt texts
                    subjectFld.setPromptText("Subject");
                    ftestFld.setPromptText("First Test");
                    stestFld.setPromptText("Second Test");
                    examFld.setPromptText("Exam");
                    totalFld.setPromptText("Total");
                    remarkFld.setPromptText("Remark");
                    
                    //customizing the buttons next
                    addRow.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    String subjectT = subjectFld.getText(), remarkT = remarkFld.getText();
                    Integer ftestT = Integer.parseInt(ftestFld.getText()), stestT = Integer.parseInt(stestFld.getText()), examT = Integer.parseInt(examFld.getText()), totalT = Integer.parseInt(totalFld.getText());
                    TableRow newRow = new TableRow(subjectT, ftestT, stestT, examT, totalT, remarkT);
                    theTable.getItems().add(newRow);
                    //clearing the textfields
                    subjectFld.clear();
                    ftestFld.clear();
                    stestFld.clear();
                    examFld.clear();
                    totalFld.clear();
                    remarkFld.clear();
                    }
                    });
                    removeRow.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    theTable.getItems().remove(theTable.getSelectionModel().getSelectedIndex());
                    
                    //clearing the textfields
                    //just in case
                    subjectFld.clear();
                    ftestFld.clear();
                    stestFld.clear();
                    examFld.clear();
                    totalFld.clear();
                    remarkFld.clear();

                    }
                    });
                    
                    //a separate hbox for the modifier controls
                    HBox modPane = new HBox();
                    modPane.setSpacing(10);
                    modPane.getChildren().addAll(subjectFld, ftestFld, stestFld, examFld, totalFld, remarkFld, addRow, removeRow);
                    
                    //adding it to the root pane
                    root.getChildren().add(modPane);
                    
                    
                    //adding the root pane to the root scroll pane
                    rootScroll.setContent(root);
                    
                    //the finalties
                    Scene theScene = new Scene(rootScroll);
                    theScene.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
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

		//the table class
		public class TableRow{
		private final StringProperty subject = new SimpleStringProperty(this, "subject", ""), remark = new SimpleStringProperty(this, "remark", "");
		private final IntegerProperty ftest = new SimpleIntegerProperty(this, "ftest", 0), stest = new SimpleIntegerProperty(this, "stest", 0), exam = new SimpleIntegerProperty(this, "exam", 0), total = new SimpleIntegerProperty(this, "total", 0);

		public TableRow(String subjectVal, Integer ftestVal, Integer stestVal, Integer examVal, Integer totalVal, String remarkVal) {
			this.subject.set(subjectVal);
			this.ftest.set(ftestVal);
			this.stest.set(stestVal);
			this.exam.set(examVal);
			this.total.set(totalVal);
			this.remark.set(remarkVal);
		}
		
		//the getters, setters and accessors
		public final String getSubject() {
		return this.subject.get();
		}
		public final void setSubject(String nSubject) {
		this.subject.set(nSubject);
		}
		public final StringProperty subjectProperty() {
		return this.subject;
		}
		
		
		public final String getRemark() {
		return this.remark.get();
		}
		public final void setRemark(String nRemark) {
		this.remark.set(nRemark);
		}
		public final StringProperty remarkProperty() {
		return this.remark;
		}
		
		
		public final Integer getFtest() {
		return this.ftest.get();
		}
		public final void setFtest(Integer nFtest) {
		this.ftest.set(nFtest);
		}
		public final IntegerProperty ftestProperty() {
		return this.ftest;
		}
		
		public final Integer getStest() {
		return this.stest.get();
		}
		public final void setStest(Integer nStest) {
		this.stest.set(nStest);
		}
		public final IntegerProperty stestProperty() {
                return this.stest;
                }
                   
                
                public final Integer getExam() {
                return this.exam.get();
                }
                public final void setExam(Integer nExam) {
                this.exam.set(nExam);
                }
                public final IntegerProperty examProperty() {
                return this.exam;
                }
                
                public final Integer getTotal() {
                return this.total.get();
                }
                public final void setTotal(Integer nTotal) {
                this.total.set(nTotal);
                }
                public final IntegerProperty totalProperty() {
                return this.total;
                }
                
                }

}