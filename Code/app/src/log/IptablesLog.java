package log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.LinkedHashMap;

public class IptablesLog extends Log implements GetField{
	public LinkedHashMap<String, String> logLine = new LinkedHashMap<String, String>() ;
	private final ArrayList<String> keys = new ArrayList<>(Arrays.asList(
			"Date", "Host name", "Log type", "Time from boot", "Prefix", "Incoming interface (IN)", "Outgoing interface (OUT)", "MAC address (MAC)", 
			 "Source ip address (SRC)", "Destination ip address (DST)", "Packet length (LEN)", "Type of service (TOS)", "Precedence type of service (PREC)", 
			 "Time to live (TTL)", "ID of ip diagram (ID)", "Protocol (PROTO)", "Source port (SPT)", "Destination port (DPT)",
			 "SEQ number (SEQ)", "ACK number (ACK)", "TCP receive window size", "Reserved bits (RES)", "ICMP type (TYPE)", 
			 "ICMP code (CODE)", "ACK flag (ACK)", "SYN flag (SYN)", "PSH flag (PSH)", "URGP", "ECN flag (CE)", "Dont fragment flag (DF)", 
			 "More fragments to follow (MF)"));
	
	public IptablesLog(LinkedHashMap<String, String> line) {
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
