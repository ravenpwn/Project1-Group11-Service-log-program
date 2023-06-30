package util;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.google.gson.JsonObject;


import log.*;


public class CreateLog {
	public static LogData createApacheLog(String fileName) {
		LogData logData; 
		JsonObject data = Util.readJsonFile(fileName).getAsJsonObject();
		ArrayList<Log> logList = new ArrayList<>();
		// logList contains logLine in the form <key, value>
		
		for(String line: data.keySet()) {
			// line is the index of each logLine
			LinkedHashMap<String, String> map = new LinkedHashMap<>();
			JsonObject logLine =  data.get(line).getAsJsonObject();
			for(String key: logLine.keySet()) {
				// key is field in a log
				// value is the value of that key field
				String value = logLine.get(key).toString();
				map.put(key, value);
				// so map will be a LinkedHashMap that contains all pair <key, value> in a log 
			}
			Log apacheLog = new ApacheLog(map);
			logList.add(apacheLog);
		}
		logData = new LogData(logList);
		return logData;
		
	}
	
	public static LogData createIptablesLog(String fileName) {
		LogData logData;
		String data = Util.readFile(fileName);
		JsonObject regexMap = Util.getIptablesRegexMap();
		ArrayList<Log> logList = new ArrayList<>();

		for (String s: data.split("\n")) {
			if(s.contains("iptables: ")) {				
				LinkedHashMap<String, String> map = new LinkedHashMap<>();
				for (String attr: regexMap.keySet()) {
					String value = Util.regexFind(regexMap.get(attr).getAsString(), s);
					if(!value.isEmpty() || attr.equals("Outgoing interface (OUT)") || attr.equals("Incoming interface (IN)")) {						
						map.put(attr, value);			
					}
				}
				Log iptableLog = new IptablesLog(map);
				logList.add(iptableLog);
			}
			
		}
		logData = new LogData(logList);
		return logData;
	}

	public static void main(String[] args) {
//		LogData data = CreateLog.createIptablesLog("./log/iptables.log");
//		System.out.println(data.toString());
		LogData data2 = CreateLog.createApacheLog("./src/util/access.json");
		System.out.println(data2);
	}
}
