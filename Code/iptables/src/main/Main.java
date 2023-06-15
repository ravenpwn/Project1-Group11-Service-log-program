package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dataio.DataProcess;

public class Main {
	public static void main(String[] args) {
		DataProcess dataProcess = new DataProcess("iptables.log");
		dataProcess.readFile(true);
		dataProcess.convertToJson();
		dataProcess.writeToFile("log_1.json", true);
		dataProcess.getData();
		
	}
}
