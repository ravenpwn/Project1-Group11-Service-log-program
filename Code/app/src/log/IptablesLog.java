package log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import iptables.LogRegex;

public class IptablesLog extends Log implements GetField{
	private HashMap<String, ?> logLine = new HashMap<>() ;
	
	public IptablesLog(HashMap<String, ?> line) {
		logLine = line;
	}
	
	@Override
	public String getField(String fieldname) {
		String value = (String) logLine.get(fieldname);
		return value;
	}

	@Override
	public ArrayList<String> getAllField() {
		ArrayList<String> keys = (ArrayList<String>) LogRegex.getIptablesRegex().keySet();
		return keys;
	}

	@Override
	public LocalDateTime getDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
