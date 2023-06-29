package regex;

import java.util.HashMap;

public class IptablesLogRegex {
	private static HashMap<String,String> iptablesRegex = generateIptablesRegex();
	
	public static HashMap<String,String> getIptablesRegex() {
		return (HashMap<String,String>) iptablesRegex.clone();
	}
	
	private static HashMap<String,String> generateIptablesRegex() {
		HashMap<String,String> attrs = new HashMap<>();
		
        attrs.put("Date", "^[A-Za-z]+\\s+\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}");
        attrs.put("Host name", "(?<=\\d{2}\\s)\\w+\\s?\\w+(?=\\skernel:)");
        attrs.put("Log type", "kernel:");
        attrs.put("Time from boot", "(?<=\\[\\s)\\d+.\\d+(?=\\])");
        attrs.put("Prefix", "[^\\s]+(?=\\sIN=)");
        attrs.put("Incoming interface (IN)", "(?<=IN=)\\w+");	
        attrs.put("Outgoing interface (OUT)", "(?<=OUT=)\\w+");
        attrs.put("MAC address (MAC)", "(?<=MAC=)[0-9a-f:]+");
        attrs.put("Source ip address (SRC)", "(?<=SRC=)[\\d.]+");
        attrs.put("Destination ip address (DST)", "(?<=DST=)[\\d.]+");
        attrs.put("Packet length (LEN)", "(?<=LEN=)\\d+");
        attrs.put("Type of service (TOS)", "(?<=TOS=)\\w+");
        attrs.put("Precedence type of service (PREC)", "(?<=PREC=)\\w+");
        attrs.put("Time to live (TTL)", "(?<=TTL=)\\d+");
        attrs.put("ID of ip diagram (ID)", "(?<=ID=)\\d+");
        attrs.put("Protocol (PROTO)", "(?<=PROTO=)\\w+");
        attrs.put("Source port (SPT)", "(?<=SPT=)\\d+");
        attrs.put("Destination port (DPT)", "(?<=DPT=)\\d+");
        attrs.put("SEQ number (SEQ)", "(?<=SEQ=)\\d+");
        attrs.put("ACK number (ACK)", "(?<=ACK=)\\d+");
        attrs.put("TCP receive window size", "(?<=WINDOW=)\\d+");
        attrs.put("Reserved bits (RES)", "(?<=RES=)\\d+");
        attrs.put("ICMP type (TYPE)", "(?<=TYPE=)\\d+");
        attrs.put("ICMP code (CODE)", "(?<=CODE=)\\d+");
        attrs.put("ACK flag (ACK)", "ACK");
        attrs.put("SYN flag (SYN)", "SYN");
        attrs.put("PSH flag (PSH)", "PSH");
        attrs.put("URGP", "(?<=URGP=)\\d+");
        attrs.put("ECN flag (CE)", "CE");
        attrs.put("Dont fragment flag (DF)", "DF");
        attrs.put("More fragments to follow (MF)", "MF");
        
		return attrs;
	}
	
}
