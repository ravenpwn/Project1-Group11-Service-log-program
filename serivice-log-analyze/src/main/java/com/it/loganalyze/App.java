package com.it.loganalyze;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.it.loganalyze.log.LogData;
import com.it.loganalyze.util.CreateLog;
import com.it.loganalyze.util.Util;

import convertRawToJson.accessLogCode.createLogEntry;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	private static LogData iptablesLogData;
	private static LogData apacheAccess;
	private static LogData apacheError;
	private static LogData modAudit;
	private static LogData modDebug;

	public static LogData getIptablesLogData() {
		return iptablesLogData;
	}

	public static LogData getApacheError() {
		return apacheError;
	}

	public static LogData getApacheAccess() {
		return apacheAccess;
	}

	public static LogData getModSecurityAuditLog() {
		return modAudit;
	}

	public static LogData getModSecurityDebugLog() {
		return modDebug;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("design/App.fxml"));
			Scene scene = new Scene(root, 1336, 768);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Service Log Analysis");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createLog() {
		String[] paths = Util.readFile("src/main/resources/com/it/loganalyze/config/logFile.conf").split("\n");
		try {
			apacheAccess = CreateLog.createApacheAccessLog(paths[0].split("=")[1]);
			apacheError = CreateLog.createApacheErrorLog(paths[1].split("=")[1]);
			iptablesLogData = CreateLog.createIptablesLog(paths[2].split("=")[1]);
			modAudit = CreateLog.createAudit(paths[3].split("=")[1]);
			modDebug = CreateLog.createDebug(paths[4].split("=")[1]);
		}catch (IndexOutOfBoundsException e2) {
			System.out.println("Got error while extracting paths from logFile.conf");
		}catch (Exception e) {
		}
	}
	
	public static void main(String[] args) {
		createLog();
		launch(args);
	}

}
