package com.it.loganalyze.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Debug extends Log implements GetField {
	public LinkedHashMap<String, String> logLine = new LinkedHashMap<>();
	private final ArrayList<String> keys = new ArrayList<>(Arrays.asList(
			"Time","Attackname","id","Msg","Severity","Data"));
	
	
	public Debug(LinkedHashMap<String, String> line) {
		logLine = line;
	}
	
	@Override
	public String getField(String fieldName) {
		String value = logLine.get(fieldName);
		return value;
	}

	@Override
	public ArrayList<String> getAllField() {
		return keys;
	}

	@Override
	public LocalDateTime getDate() {
	    String dateString = getField("Time");
	    LocalDateTime dateTime = null;
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss");
	        dateTime = LocalDateTime.parse(dateString, formatter);
	    } catch (DateTimeParseException e) {
	        // handle exception
	    }
	    return dateTime;
	}

	@Override
	public String getSrcIp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getMainField() {
		ArrayList<String> mainKeys = new ArrayList<>(Arrays.asList(
				"Time","Attackname","id","Msg","Severity"));
		return mainKeys;
	}

	public LinkedHashMap<String, String> getLogLine() {
		return logLine;
	}
}
