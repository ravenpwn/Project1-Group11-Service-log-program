package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import log.*;


public class CreateLog {
//	public static JsonElement createApacheLog(String fileName) {

//	}
	
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

	
}
