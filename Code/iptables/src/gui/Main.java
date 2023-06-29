package gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import dataio.DataProcess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import log.IptablesLog;
import log.LogLine;

public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	DataProcess dataProcess = new DataProcess("iptables.log");
		dataProcess.readFile(true);
		dataProcess.convertToList();
		IptablesLog logs = new IptablesLog(dataProcess.getDataArrayList());
		ArrayList<HashMap<String, Object>> data = logs.getData();
		ArrayList<LogLine> lines = new ArrayList<>();
//		for (int i =0; i<= data.size(); i++) {
//			lines.add(new LogLine(data.get(i).values().toArray()));
//		}
		String[] keys = {"Protocol", "SourceIpAddress", "Date", "DestinationPort", "DestinationIpAddress", "TimeToLive", "PacketLength", "SourcePort"};
		
		LogLine testLine = new LogLine(data.get(10));
        Parent root = FXMLLoader.load(getClass().getResource("tableScene.fxml"));
//        BorderPane root = new BorderPane();
        
        TableView<LogLine> tableView = new TableView<>();
        for (String i:keys) {
        	TableColumn<LogLine, String> column = new TableColumn<LogLine,String>(i);
        	column.setCellValueFactory(new PropertyValueFactory<LogLine, String>(i));
        	tableView.getColumns().add(column);        	
        }
//        System.out.println(root.getChildrenUnmodifiable().get(1));
//        root.setCenter(tableView);
        
        for (HashMap<String, Object> h: data) {        	
        	tableView.getItems().add(new LogLine(h));
        }
        
        primaryStage.setTitle("Hello World");
        Scene scene =  new Scene(root, 1366, 768);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    	
    public static void main(String[] args) {
        launch(args);
    }
}