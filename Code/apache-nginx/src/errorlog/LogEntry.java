package errorlog;

import java.util.Date;

public class LogEntry {
	private final Date timestampString;
	private final String configureString ;
	private final String emerge_levelString;
	private final String pIDString;
	private final String tIDString;
//	private final String ip_addressString;
	private final String messageString;
	
	public LogEntry(Date timestamp, String configure, String emerge_level, String pIDString, String tIDString, String message) {
		this.timestampString = timestamp;
		this.configureString = configure;
		this.emerge_levelString = emerge_level;
		this.pIDString = pIDString;
		this.tIDString = tIDString;
		this.messageString = message;
	}
	
	public String getTimestamp() {
		return this.timestampString.toString();
	}
	
	public String getConfigure() {
		return this.configureString;
	}
	
	public String getEmergeLevel() {
		return this.emerge_levelString;
	}
	
	public String getPID() {
		return this.pIDString;
	}
	
	public String getTID() {
		return this.tIDString;
	}
//	public String getIpAddress() {
//		return this.ip_addressString;
//	}
	
	public String getMessage() {
		return this.messageString;
	}
}
