package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import log.*;


public class CreateLog {
	public static LogData createApacheLog() {
		return null;
		
	}
	
	public static LogData createIptablesLog(String fileName) {
		LogData logData;
		String data = Util.readFile(fileName);
		JsonObject regexMap = (JsonObject) Util.readJsonFile("regex/IptablesRegex.json");
		ArrayList<Log> logList = new ArrayList<>();

		for (String s: data.split("\n")) {
			if(s.contains("iptables: ")) {				
				LinkedHashMap<String, String> map = new LinkedHashMap<>();
				for (String attr: regexMap.keySet()) {
					String value = Util.regexFind(regexMap.get(attr).getAsString(), s);
					map.put(attr, value);			
				}
				Log iptableLog = new IptablesLog(map);
				logList.add(iptableLog);
			}
			
		}
		logData = new LogData(logList);
		return logData;
	}
	
}
