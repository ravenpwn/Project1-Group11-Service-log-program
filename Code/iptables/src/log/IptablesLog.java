package log;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.*;
import java.time.format.DateTimeFormatter;

import com.google.gson.*;

import util.ComparatorCustom;

public class IptablesLog {
	private ArrayList<HashMap<String, Object>> data;
	private String yearString = String.valueOf(LocalDateTime.now().getYear());
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd HH:mm:ss yyyy");
	
	public IptablesLog(ArrayList<HashMap<String, Object>> jsonArray) {
		data = jsonArray;
		parseAll();
	}
	
	public ArrayList<HashMap<String, Object>> getData() {
		return (ArrayList<HashMap<String, Object>>) data.clone();
	}
	
	public HashMap<String, Object> getSingleLog(int id) {
		return (HashMap<String, Object>) data.get(id).clone();
	}
	
	private void parseAll() {
		for (HashMap<String, Object> h: data) {
			
			String date = h.get("Date").toString();
			LocalDateTime localDateTime = parseTime(date);
			h.put("Date",localDateTime);
			h.put("Log type", "kernel");
			for (Map.Entry<String, Object> f:h.entrySet()) {
				int i = -1;
				try {
					i = Integer.parseInt(f.getValue().toString());
				} catch (Exception e) {
					continue;
				}
				if(i!= -1) {					
					h.put(f.getKey(), i);
				}
			}
		}
	}
	private LocalDateTime parseTime(String time) {
       	String dateTimeString = "";
      	if(time.charAt(5) == ' ') {
      		dateTimeString += time.substring(0,4)+ "0" + time.substring(4) +  " " + yearString;
      	}
   		LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
   		return localDateTime;
	}
	
	public TreeMap<Integer, Integer> countLogsByDestinationPort() {
		TreeMap<Integer, Integer> counter = new TreeMap<>();
		for(HashMap<String, Object> h: data) {
			Object portObject = h.get("Destination port (DPT)");
			if(portObject == null) {
				continue;
			}
			int port = (int) portObject;
			if(counter.containsKey(port)) {
				counter.put(port, counter.get(port)+1);
			} else {
				counter.put(port, 1);
			}
		}
		return counter;
	}
	
	public TreeMap<String, Integer> countLogsBySrcIp(int length) {
		if(1 > length || length > 4) {
			System.out.println("invalid ip length");
			return null;
		}
		TreeMap<String, Integer> counter = new TreeMap<>();
		for(HashMap<String, Object> h: data) {
			Object srcIp = h.get("Source ip address (SRC)");
			String regex = "(\\d+\\.){" + (length-1) +"}\\d+";
			if(srcIp == null) {
				continue;
			}
			String ip = getSubstringRegex(regex, srcIp.toString())+ ".x".repeat(4-length);
			if(counter.containsKey(ip)) {
				counter.put(ip, counter.get(ip)+1);
			} else {
				counter.put(ip, 1);
			}
		}
		return counter;
	}
	private String getSubstringRegex(String regex, String s) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		if (matcher.find())	{
		    return matcher.group();
		}
		return "";
	}
	
	public TreeMap<String, Integer> countLogsPacketLength(int range) {
		range = Integer.parseInt(1 + "0".repeat(String.valueOf(range).length()-1));
		TreeMap<String, Integer> counter = new TreeMap<>(ComparatorCustom.compareRange);
		for(HashMap<String, Object> h: data) {
			Object len = h.get("Packet length (LEN)");
			if(len == null) {
				continue;
			}
			int l = (int)(len)/range * range;
			String rangeString = l + "-" + (l+range);
			if(counter.containsKey(rangeString)) {
				counter.put(rangeString, counter.get(rangeString)+1);
			} else {
				counter.put(rangeString, 1);
			}
		}
		return counter;
	}
	
	public TreeMap<String, Integer> countLogsPacketLength() {
		TreeMap<String, Integer> counter = new TreeMap<>(ComparatorCustom.compareRange);
		for(HashMap<String, Object> h: data) {
			Object len = h.get("Packet length (LEN)");
			if(len == null) {
				continue;
			}
			String z = 1 + "0".repeat(String.valueOf(len).length()-1);
			String rangeString = z + "-" + z +"0";
			if(counter.containsKey(rangeString)) {
				counter.put(rangeString, counter.get(rangeString)+1);
			} else {
				counter.put(rangeString, 1);
			}
		}
		return counter;
	}
	
	public TreeMap<String, Integer> countLogsProtocol() {
		TreeMap<String, Integer> counter = new TreeMap<>();
		for(HashMap<String, Object> h: data) {
			Object o = h.get("Protocol (PROTO)");
			if(o == null) {
				continue;
			}
			String protocol = o.toString();
			if(counter.containsKey(protocol)) {
				counter.put(protocol, counter.get(protocol)+1);
			} else {
				counter.put(protocol, 1);
			}
		}
		return counter;
	}
	
	public TreeMap<String, Integer> countLogsByDate(boolean hasMonth, boolean hasDay, boolean hasHour) {
		if (!hasDay && !hasMonth && !hasHour) {
			System.out.println("invalid option");
			return null;
		}
		TreeMap<String, Integer> counter = new TreeMap<>();
		for(HashMap<String, Object> h: data) {
			Object o = h.get("Date");
			if(o == null) {
				continue;
			}
			LocalDateTime dateTime = (LocalDateTime) o;
			String dateString = "";
			if(hasMonth) {
				dateString += dateTime.getMonthValue() + " ";
			}
			if(hasDay) {
				dateString += dateTime.getDayOfMonth() + " ";
			}
			if(hasHour) {
				dateString += dateTime.getHour() + "h ";
			}
			dateString = dateString.strip();
			if(counter.containsKey(dateString)) {
				counter.put(dateString, counter.get(dateString)+1);
			} else {
				counter.put(dateString, 1);
			}
		}
		return counter;
	}
	
}