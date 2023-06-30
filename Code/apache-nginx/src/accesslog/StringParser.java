package accesslog;

public class StringParser {
	private static String ip_addressString = "\\d{3}\\.\\d{3}\\.\\d+\\.\\d+";
	private static String timestampString = "\\[\\d+\\/\\w+\\/\\d+\\:\\d+\\:\\d+\\:\\d+\\s[\\+|\\-]\\d+\\]";
	private static String request_lineString = "\"([^\"]+)\"";
	private static String status_bytesizeString = "(\\d+)\s(\\d+)";
	private static String urlSourceString = "\"([^ ]+)\"";
	private static String user_agentString = "\"([^\"]*)\"";
	private static String cookieString = "\"([^ ]*)\"";
	private static String proxyString = "\"([^ ]*)\"";
	private static String servernameString = "\"([^ ]*)\"";
	private static String remotenameString = "\"([^ ]*)\"";
	private static String respone_timeString = "\"(\\d+\\.\\d+)\"";
	private static String connection_statusString = "\"([^ ]*)\"";
	private static String respone_headerString = "\"([^\"]*)\"";	
	
	public static String getIpAddress(){
        return ip_addressString;
	}

	public static String getTimestamp(){
        return  timestampString;
	}

	public static String getRequestLine(){
        return request_lineString;
	}

	public static String getStatusByteS(){
        return status_bytesizeString;
	}

	public static String getUrlSource(){
        return urlSourceString;
	}
	
	public static String getUserAgent(){
        return user_agentString;
	}

	public static String getCookie(){
        return cookieString;
	}

	public static String getProxy(){
        return proxyString;
	}

	public static String getServerName(){
        return servernameString;
	}

	public static String getRemoteName(){
        return remotenameString;
	}

	public static String getResponeTime(){
        return respone_timeString;
	}

	public static String getConnectionStatus(){
        return connection_statusString;
	}

	public static String getResponeHeader(){
        return respone_headerString;
	}
}
