package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

import com.google.gson.*;
import dataio.DataProcess;
import log.IptablesLog;
import log.LogLine;
import util.ComparatorCustom;
import util.RawToJson;

public class Test {
	public static void main(String[] args) {
		DataProcess dataProcess = new DataProcess("iptables.log");
		dataProcess.readFile(true);
		dataProcess.convertToList();
		IptablesLog logs = new IptablesLog(dataProcess.getDataArrayList());
//		TreeMap<Integer, Integer> destinationPortCount =  logs.countLogsByDestinationPort();
//		TreeMap<String, Integer> counter = logs.countLogsByDate(false, true, true);
//		int i = 565;
//		System.out.println(counter);
		ArrayList<HashMap<String, Object>> data = logs.getData();
//		LogLine logTest = new LogLine(data.get(0).values().toArray());
		for (String s: data.get(0).keySet()) {
			System.out.println(s.indexOf("("));
		}
		System.out.println(data.get(0).get("Destination port (DPT)"));
	}
}
