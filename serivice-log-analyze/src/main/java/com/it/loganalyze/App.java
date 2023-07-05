package com.it.loganalyze;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.it.loganalyze.log.LogData;
import com.it.loganalyze.util.CreateLog;
import com.it.loganalyze.util.Util;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class App extends Application {
	private static LogData iptablesLogData = CreateLog.createIptablesLog("src/main/resources/com/it/loganalyze/log/iptables.log");
	private static LogData apacheAccess = CreateLog.createApacheAccessLog("src/main/resources/com/it/loganalyze/log/access.json");
	private static LogData apacheError = CreateLog.createApacheAccessLog("src/main/resources/com/it/loganalyze/log/error.json");
	public static LogData getIptablesLogData() {
		return iptablesLogData;
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
		launch(args);
	}
	public static LogData getApacheError() {
		return apacheError;
	}
	public static LogData getApacheAccess() {
		return apacheAccess;
	}
}
