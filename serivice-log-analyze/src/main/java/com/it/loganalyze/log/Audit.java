package com.it.loganalyze.log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Audit extends Log implements GetField {
	public LinkedHashMap<String, String> logLine = new LinkedHashMap<>();
	private final ArrayList<String> keys = new ArrayList<>(Arrays.asList(
			"Timestamp","attacktype","transaction_id", "local_port", "remote_port", "local_address", "remote_address","transaction_id","request_line","respond_body"));
	
	
	public Audit(LinkedHashMap<String, String> line) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSrcIp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getMainField() {
		// TODO Auto-generated method stub
		return null;
	}
}