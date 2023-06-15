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
import util.ComparatorCustom;
import util.RawToJson;

public class Test {
	public static void main(String[] args) {
		DataProcess dataProcess = new DataProcess("iptables.log");
		dataProcess.readFile(true);
		dataProcess.convertToList();
		IptablesLog logs = new IptablesLog(dataProcess.getDataArrayList());
//		TreeMap<Integer, Integer> destinationPortCount =  logs.countLogsByDestinationPort();
		TreeMap<String, Integer> counter = logs.countLogsByDate(false, true, true);
		int i = 565;
		System.out.println(counter);
	}
}
