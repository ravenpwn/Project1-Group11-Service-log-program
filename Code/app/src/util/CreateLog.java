package util;

import java.util.ArrayList;

import log.IptablesLog;
import log.LogData;
import regex.IptablesLogRegex;

public class CreateLog {
	public static LogData createApacheLog() {
		return null;
		
	}
	
	public static LogData createIptablesLog(String fileName) {
		LogData logData;
		String data = Util.readFile("iptables.log");
		
		for (String s: data.split("\n")) {
			for (String regex: IptablesLogRegex.getIptablesRegex().keySet()) {
				
			}
		}
		return logData;
	}
	
}
