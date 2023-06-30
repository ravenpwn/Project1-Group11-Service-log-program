package log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class ApacheLog extends Log implements GetField {
	public LinkedHashMap<String, String> logLine = new LinkedHashMap<>();
	private final ArrayList<String> keys = new ArrayList<>(Arrays.asList(
			"Ip_address", "User_identity", "User_name", "Timestamp", "HttpMethod",
			"Url", "Version", "Status_code", "Bytesize", "UrlSource", "User_agent",
			"Cookie", "Proxy", "Server_name", "Remote_name", "Respone_time",
			"Connection_status", "Respone_header"));
	
	
	public ApacheLog(LinkedHashMap<String, String> line) {
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
}
