package log;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface GetField {
	String getField(String fieldname);
	
	LocalDateTime getDate();
	
	ArrayList<String> getAllField();
	
}
