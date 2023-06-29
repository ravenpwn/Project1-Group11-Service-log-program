package log;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class LogLine {
	private HashMap<String, Object> data;
	
	public String getDontFragmentFlag() {
	        return data.get("Dont fragment flag (DF)").toString();
	    }


	    public String getMACAddress() {
	        return data.get("MAC address (MAC)").toString();
	    }


	    public String getIDOfIpDiagram() {
	        return data.get("ID of ip diagram (ID)").toString();
	    }


	    public String getPrefix() {
	        return data.get("Prefix").toString();
	    }


	    public String getSourceIpAddress() {
	        return data.get("Source ip address (SRC)").toString();
	    }


	    public String getDestinationPort() {
	    	Object dP = data.get("Destination port (DPT)");
	        if(dP == null) {
	        	return "";
	        }
	    	return dP.toString();
	    }


	    public String getSourcePort() {
	    	Object sP = data.get("Source port (SPT)");
	    	if(sP == null) {
	    		return "";
	    	}
	        return sP.toString();
	    }


	    public String getPSHFlag() {
	        return data.get("PSH flag (PSH)").toString();
	    }


	    public String getTCPReceiveWindowSize() {
	        return data.get("TCP receive window size").toString();
	    }


	    public String getACKFlag() {
	        return data.get("ACK flag (ACK)").toString();
	    }


	    public String getHostName() {
	        return data.get("Host name").toString();
	    }


	    public String getTypeOfService() {
	        return data.get("Type of service (TOS)").toString();
	    }


	    public String getDestinationIpAddress() {
	        return data.get("Destination ip address (DST)").toString();
	    }


	    public String getLogType() {
	        return data.get("Log type").toString();
	    }


	    public String getPacketLength() {
	        return data.get("Packet length (LEN)").toString();
	    }


	    public String getURGP() {
	        return data.get("URGP").toString();
	    }


	    public String getPrecedenceTypeOfService() {
	        return data.get("Precedence type of service (PREC)").toString();
	    }


	    public String getOutgoingInterface() {
	        return data.get("Outgoing interface (OUT)").toString();
	    }


	    public String getTimeFromBoot() {
	        return data.get("Time from boot").toString();
	    }


	    public String getTimeToLive() {
	        return data.get("Time to live (TTL)").toString();
	    }


	    public String getDate() {
	        return data.get("Date").toString();
	    }


	    public String getProtocol() {
	        return data.get("Protocol (PROTO)").toString();
	    }


	    public String getIncomingInterface() {
	        return data.get("Incoming interface (IN)").toString();
	    }


	    public String getReservedBits() {
	        return data.get("Reserved bits (RES)").toString();
	    }
    
    public LogLine(HashMap<String, Object> collection) {
    	data = collection;
    }
}
