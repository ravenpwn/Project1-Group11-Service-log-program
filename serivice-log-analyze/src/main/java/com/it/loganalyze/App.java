package com.it.loganalyze;

import java.io.IOException;

import com.it.loganalyze.log.LogData;
import com.it.loganalyze.util.CreateLog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
	
	
	
	private static LogData iptablesLogData = CreateLog.createIptablesLog("src/main/resources/com/it/loganalyze/log/iptables.log");
	private static LogData apacheAccessLogData = CreateLog.createApacheAccessLog("src/main/resources/com/it/loganalyze/log/access.json");
	private static LogData apacheErrorLogData = CreateLog.createApacheAccessLog("src/main/resources/com/it/loganalyze/log/error.json");
	
	public static LogData getIptablesLogData() {
		return iptablesLogData;
	}
	public static LogData getApacheError() {
		return apacheErrorLogData;
	}
	public static LogData getApacheAccess() {
		return apacheAccessLogData;
	}
	
	@Override
	public void start(Stage primaryStage) {
	    try {
			Parent root = FXMLLoader.load(getClass().getResource("design/App.fxml"));
			Scene scene = new Scene(root, 1336,768);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Service Log Analysis");
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		convertRawToJson.ErrorLogCode.Convert errConvert = new convertRawToJson.ErrorLogCode.Convert();
		errConvert.Start();
		convertRawToJson.accessLogCode.Convert accConvert = new convertRawToJson.accessLogCode.Convert();
		accConvert.Start();
		
		launch(args);
	}

}
