package gui.test;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import log.LogData;
import util.CreateLog;

public class Test extends Application{
	private static LogData iptablesLogData = CreateLog.createIptablesLog("log/iptables.log");
	public static LogData getIptablesLogData() {
		return iptablesLogData;
	}
	@Override
	public void start(Stage primaryStage) {
	    try {
			Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
			Scene scene = new Scene(root, 1336,768);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Service Log Analysis");
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
