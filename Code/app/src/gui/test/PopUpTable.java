package gui.test;

import java.io.IOException;
import java.util.ArrayList;


import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import log.Log;
import log.LogData;

public class PopUpTable {
	private LogData logData;
	private ArrayList<String> columns;
	
	public PopUpTable(LogData log) {
		logData = log;
		if(log == null) {
			columns = null;			
		} else {
			columns = log.getKeys();
		}
		
	}
	public PopUpTable(LogData log, ArrayList<String> cols) {
		logData = log;
		columns = cols;
	}
	
	public BorderPane createTableView() throws IOException {
		
		BorderPane pane = new BorderPane();
		TableView<Log> tableView = new TableView<>();
		for (String i:columns) {
        	TableColumn<Log, String> column = new TableColumn<Log,String>(i);
        	column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getField(i)));
        	tableView.getColumns().add(column);
		}
		
        for (Log line: logData.getData()) {        	
        	tableView.getItems().add(line);
        }
        pane.setCenter(tableView);
		pane.setVisible(true);
		return pane;
	}
	
}
