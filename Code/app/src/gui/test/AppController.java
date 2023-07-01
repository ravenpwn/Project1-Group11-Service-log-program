package gui.test;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class AppController {
	private ArrayList<Button> btns = new ArrayList<>();

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

    }

    @FXML
    void apacheLabelClick(MouseEvent event) {
    	showButton(0);
    }

    @FXML
    void apacheTablePressed(ActionEvent event) {

    }

    @FXML
    void iptablesGraphBtnPressed(ActionEvent event) {

    }

    @FXML
    void iptablesLabelClick(MouseEvent event) {
    	showButton(2);
    }

    @FXML
    void iptablesTablePressed(ActionEvent event) {

    }

    @FXML
    void modsecGraphBtnPressed(ActionEvent event) {

    }

    @FXML
    void modsecLabelClick(MouseEvent event) {
    	showButton(4);
    }

    @FXML
    void modsecTablePressed(ActionEvent event) {

    }
    
    @FXML
    void initialize() {
    	btns.add(apacheTableBtn);
    	btns.add(apacheGraphBtn);
    	btns.add(iptablesTableBtn);
    	btns.add(iptablesGraphBtn);
    	btns.add(modsecTableBtn);
    	btns.add(modsecGraphBtn);
    	
    	searchBar.setVisible(false);
    	searchBar.managedProperty().bind(searchBar.visibleProperty());
    	
    	for (Button b:btns) {
    		b.setVisible(false);
    		b.managedProperty().bind(b.visibleProperty());
    	}
    	
//    	apacheLabel.hoverProperty().ad
    	
    }
    
    void showButton(int index) {
    	for (int i = 0; i < btns.size(); i++) {
    		Button b = btns.get(i);
    		if(!b.isVisible() && (i==index || i==index+1)) {
    			b.setVisible(true);
    		} else if(btns.get(i).isVisible() && (i!=index &&i!=index+1)) {
    			b.setVisible(false);
    		}
    	}
    }
}
