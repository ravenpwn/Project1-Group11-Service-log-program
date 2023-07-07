package com.it.loganalyze.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class ApacheAccessLog extends Log implements GetField {
	public LinkedHashMap<String, String> logLine = new LinkedHashMap<>();
	private final ArrayList<String> keys = new ArrayList<>(Arrays.asList(
			"Ip_address", "User_identity", "User_name", "Timestamp", "HttpMethod",
			"Url", "Version", "Status_code", "Bytesize", "UrlSource", "User_agent"
			));
	
	
	public ApacheAccessLog(LinkedHashMap<String, String> line) {
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd HH:mm:ss zzz yyyy");
	    LocalDateTime dateTime = LocalDateTime.parse(getField("Timestamp").substring(4), formatter);
		// TODO Auto-generated method stub
		return dateTime;
	}

	@Override
	public String getSrcIp() {
		// TODO Auto-generated method stub
		return getField("Ip_address");
	}

	@Override
	public ArrayList<String> getMainField() {
		// TODO Auto-generated method stub
		return null;
	}
}
