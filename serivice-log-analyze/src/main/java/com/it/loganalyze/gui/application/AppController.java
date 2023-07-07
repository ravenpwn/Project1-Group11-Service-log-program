package com.it.loganalyze.gui.application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.it.loganalyze.App;
import com.it.loganalyze.log.Log;
import com.it.loganalyze.log.LogData;
import com.it.loganalyze.util.CreateLog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class AppController {
	private ArrayList<Button> btns = new ArrayList<>();
	private String whatLog;
	private TabPane tabPane = new TabPane();
	private Tab accessTab = new Tab("access.log");
	private Tab errorTab =  new Tab("error.log");
	
	private LogData modsecurityAuditLog = App.getModSecurityAuditLog();
	private LogData modsecurityDebugLog = App.getModSecurityDebugLog();
	private LogData iptablesLogData = App.getIptablesLogData();
	private LogData apacheAccess = App.getApacheAccess();
	private LogData apacheError = App.getApacheError();
	

	
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
    private DatePicker dateSearch;
    
    @FXML
    private Label dashboardLabel;
    
    @FXML
    private TextField ipSearch;

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
    private Button searchBtn;
	

    @FXML
    void apacheGraphBtnPressed(ActionEvent event) {
        if (searchBar.isVisible()) {
            searchBar.setVisible(false);
        }
        displaySelectedBtn(apacheGraphBtn);

        // Create the charts
        ShowLogCharts showLogCharts = new ShowLogCharts(apacheAccess, "Ip_address", "Timestamp");
        HBox hbox = showLogCharts.createCharts();

        // Display the charts in the infoPane
        infoPane.getChildren().set(0, hbox);
    }



    @FXML
    void apacheLabelClick(MouseEvent event) {
    	whatLog = "apache";
    	showButton(0);
    }

    @FXML
    void apacheTablePressed(ActionEvent event) {
    	if(!searchBar.isVisible()) {
    		searchBar.setVisible(true);
    	}
    	displaySelectedBtn(apacheTableBtn);
//    	LogData apacheAccess = App.getApacheAccess();
//    	LogData apacheError = App.getApacheError();
    	
    	ShowLogTable show = new ShowLogTable(apacheAccess);
    	ShowLogTable show2 = new ShowLogTable(apacheError);
    	try {
			accessTab.setContent(show.createTableView());
			errorTab.setContent(show2.createTableView());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	showTable(tabPane);
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
        if (searchBar.isVisible()) {
            searchBar.setVisible(false);
        }
        displaySelectedBtn(iptablesGraphBtn);

        // Create the charts
        ShowLogCharts showLogCharts = new ShowLogCharts(iptablesLogData, "Source ip address (SRC)", "Date");
        HBox hbox = showLogCharts.createCharts();

        // Display the charts in the infoPane
        infoPane.getChildren().set(0, hbox);
    }


    @FXML
    void iptablesLabelClick(MouseEvent event) {
    	whatLog = "iptables";
    	showButton(2);
    }

    @FXML
    void iptablesTablePressed(ActionEvent event) {
    	if(!searchBar.isVisible()) {
    		searchBar.setVisible(true);
    	}
    	displaySelectedBtn(iptablesTableBtn);
    	LogData iptablesLogData = App.getIptablesLogData();
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
        if (searchBar.isVisible()) {
            searchBar.setVisible(false);
        }
        displaySelectedBtn(modsecGraphBtn);

        // Create the charts
        ShowLogCharts showLogCharts = new ShowLogCharts(modsecurityAuditLog, "remote_address", "Timestamp");
        HBox hbox = showLogCharts.createCharts();

        // Display the charts in the infoPane
        infoPane.getChildren().set(0, hbox);
    }



    @FXML
    void modsecLabelClick(MouseEvent event) {
    	whatLog = "modsec";
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
    void searchBtnPressed() {
    	String ipString = ipSearch.getText();
    	LocalDate date;
    	try {
    		date = dateSearch.getValue();
    	} catch (Exception e) {
			e.printStackTrace();
    		date = null;
		}
    	
    	if(date!=null) {    		
    		search(date);
    	} else {
    		search(ipString);
    	}
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
    	searchBar.setHgap(10);
    	tabPane.getTabs().add(accessTab);
    	tabPane.getTabs().add(errorTab);
    	accessTab.setClosable(false);
    	errorTab.setClosable(false);
        tabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab == accessTab) {
            	searchBar.setVisible(true);
            } else if (newTab == errorTab) {
                searchBar.setVisible(true);
            }
        });
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
    
    private void showTable(Node node) {
    	infoPane.getChildren().set(0, (Node) node);
	}
    
    private void search(LocalDate date) {
		// TODO Auto-generated method stub
		switch (whatLog) {
		case "apache":
			LogData apacheAccess = App.getApacheAccess().filterByDate(date);
			System.out.println(apacheAccess.getData());
			LogData apacheError = App.getApacheError();
			ShowLogTable show = new ShowLogTable(apacheAccess);
	    	ShowLogTable show2 = new ShowLogTable(apacheError);
	    	try {
				accessTab.setContent(show.createTableView());
				errorTab.setContent(show2.createTableView());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "iptables":
			displaySelectedBtn(iptablesTableBtn);
	    	LogData iptablesLogData = App.getIptablesLogData().filterByDate(date);
	    	ShowLogTable show3 = new ShowLogTable(iptablesLogData, iptablesLogData.getMainKeys());
	    	
	    	try {
				showTable(show3.createTableView());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}



	private void search(String ipString) {
		// TODO Auto-generated method stub
		switch (whatLog) {
		case "apache":
			LogData apacheAccess = App.getApacheAccess().filterByIpAddress(ipString,4);
			LogData apacheError = App.getApacheError();
			ShowLogTable show = new ShowLogTable(apacheAccess);
	    	ShowLogTable show2 = new ShowLogTable(apacheError);
	    	try {
				accessTab.setContent(show.createTableView());
				errorTab.setContent(show2.createTableView());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "iptables":
	    	LogData iptablesLogData = App.getIptablesLogData().filterByIpAddress(ipString, 4);
	    	ShowLogTable show3 = new ShowLogTable(iptablesLogData, iptablesLogData.getMainKeys());
	    	
	    	try {
				showTable(show3.createTableView());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}
