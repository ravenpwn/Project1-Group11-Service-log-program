package gui.test;

import java.io.IOException;
import java.util.ArrayList;


import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import log.Log;
import log.LogData;

public class ShowLogTable {
	private LogData logData;
	private ArrayList<String> columns;
	private TableView<Log> tableView;
	
	public ShowLogTable(LogData log) {
		logData = log;
		if(log == null) {
			columns = null;			
		} else {
			columns = log.getKeys();
		}
		
	}
	public ShowLogTable(LogData log, ArrayList<String> cols) {
		logData = log;
		columns = cols;
	}
	
	public TableView<Log> createTableView() throws IOException {
		if(tableView == null) {
			tableView = new TableView<>();
			for (String i:columns) {
				TableColumn<Log, String> column = new TableColumn<Log,String>(i);
				column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getField(i)));
				tableView.getColumns().add(column);
			}
			
			for (Log line: logData.getData()) {        	
				tableView.getItems().add(line);
			}
			
		}
		return tableView;
	}
}
