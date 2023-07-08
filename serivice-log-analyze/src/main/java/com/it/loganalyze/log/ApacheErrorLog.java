package com.it.loganalyze.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class ApacheErrorLog extends Log implements GetField {
	public LinkedHashMap<String, String> logLine = new LinkedHashMap<>();
	private final ArrayList<String> keys = new ArrayList<>(Arrays.asList(
			"Timestamp", "configure", "Emerge_level", "Process_id", "Thread_id","Client_Ip","Port","Message", "Referer"));
	
	
	public ApacheErrorLog(LinkedHashMap<String, String> line) {
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy");
	    LocalDateTime dateTime = LocalDateTime.parse(getField("Timestamp").substring(4), formatter);
		// TODO Auto-generated method stub
		return dateTime;
	}

	@Override
	public String getSrcIp() {
		String res = logLine.get("Client_Ip");
		return res;
	}

	@Override
	public ArrayList<String> getMainField() {
		// TODO Auto-generated method stub
		return null;
	}
}
