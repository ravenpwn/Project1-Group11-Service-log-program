package log;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface GetField {
	String getField(String fieldName);
	
	LocalDateTime getDate();
	
	ArrayList<String> getAllField();
	
}
