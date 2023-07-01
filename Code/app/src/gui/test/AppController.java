package gui.test;

import java.io.IOException;
import java.util.ArrayList;

import gui.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import log.Log;
import log.LogData;

public class AppController {
	private ArrayList<Button> btns = new ArrayList<>();
	private Label selectedLog = new Label();
	
	@FXML
	private StackPane infoPane;
	
    @FXML
    private VBox apacheBox;

    @FXML
    private Button apacheGraphBtn;

    @FXML
    private Label apacheLabel;

    @FXML
    private Button apacheTableBtn;

    @FXML
    private Label dashboardLabel;

    @FXML
    private VBox iptablesBox;

    @FXML
    private Button iptablesGraphBtn;

    @FXML
    private Label iptablesLabel;

    @FXML
    private Button iptablesTableBtn;

    @FXML
    private VBox modsecBox;

    @FXML
    private Button modsecGraphBtn;

    @FXML
    private Label modsecLabel;

    @FXML
    private Button modsecTableBtn;

    @FXML
    private FlowPane searchBar;

    @FXML
    void apacheGraphBtnPressed(ActionEvent event) {
    	if(searchBar.isVisible()) {
    		searchBar.setVisible(false);
    	}
    	displaySelectedBtn(apacheGraphBtn);
    }

    @FXML
    void apacheLabelClick(MouseEvent event) {
    	selectedLog = apacheLabel;
    	showButton(0);
    }

    @FXML
    void apacheTablePressed(ActionEvent event) {
    	if(!searchBar.isVisible()) {
    		searchBar.setVisible(true);
    	}
    	displaySelectedBtn(apacheTableBtn);
    }

    @FXML
    void dashboardClick(MouseEvent event) {
    	if(searchBar.isVisible()) {
    		searchBar.setVisible(false);
    	}
    	showButton(6);
    	
    }

    @FXML
    void iptablesGraphBtnPressed(ActionEvent event) {
    	if(searchBar.isVisible()) {
    		searchBar.setVisible(false);
    	}
    	displaySelectedBtn(iptablesGraphBtn);
    }

    @FXML
    void iptablesLabelClick(MouseEvent event) {
    	selectedLog = iptablesLabel;
    	showButton(2);
    }

    @FXML
    void iptablesTablePressed(ActionEvent event) {
    	if(!searchBar.isVisible()) {
    		searchBar.setVisible(true);
    	}
    	displaySelectedBtn(iptablesTableBtn);
    	LogData iptablesLogData = Test.getIptablesLogData();
    	ShowLogTable show = new ShowLogTable(iptablesLogData, iptablesLogData.getMainKeys());
    	
    	try {
			showTable(show.createTableView());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@FXML
    void modsecGraphBtnPressed(ActionEvent event) {
    	if(searchBar.isVisible()) {
    		searchBar.setVisible(false);
    	}
    	displaySelectedBtn(modsecGraphBtn);
    }

    @FXML
    void modsecLabelClick(MouseEvent event) {
    	selectedLog = modsecLabel;
    	showButton(4);
    }

    @FXML
    void modsecTablePressed(ActionEvent event) {
    	if(!searchBar.isVisible()) {
    		searchBar.setVisible(true);
    	}
    	displaySelectedBtn(modsecTableBtn);
    }
    
    @FXML
    void initialize() {
    	btns.add(apacheTableBtn);
    	btns.add(apacheGraphBtn);
    	btns.add(iptablesTableBtn);
    	btns.add(iptablesGraphBtn);
    	btns.add(modsecTableBtn);
    	btns.add(modsecGraphBtn);
    	
    	bindVisible();
    }
    
    void bindVisible() {
    	searchBar.setVisible(false);
    	searchBar.managedProperty().bind(searchBar.visibleProperty());
    	
    	for (Button b:btns) {
    		b.setVisible(false);
    		b.managedProperty().bind(b.visibleProperty());
    	}
    }
    
    
    void displaySelectedBtn(Button b) {
    	for(Button btn: btns) {
    		if(b.equals(btn)) {
    			btn.setStyle("-fx-background-color: #1299f6");    			
    		} else {
    			btn.setStyle("-fx-background-color: #dddddd"); 
    		}
    	}
    }
    
    void showButton(int index)  {
    	for (int i = 0; i < btns.size(); i++) {
    		Button b = btns.get(i);
    		if(!b.isVisible() && (i==index || i==index+1)) {
    			b.setVisible(true);
    		} else if(btns.get(i).isVisible() && (i!=index &&i!=index+1)) {
    			b.setVisible(false);
    		}
    	}
    }
    
    private void showTable(TableView<Log> tableView) {
    	infoPane.getChildren().set(0, tableView);
	}
}
