package gui;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import log.Log;
import log.LogData;

public class PopUpTable extends JFrame {
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
		BorderPane pane = FXMLLoader.load(getClass().getResource("LogTable.fxml"));
		pane.setVisible(true);
		return pane;
	}
	
}
