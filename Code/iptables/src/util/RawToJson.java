package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import log.LogAttribute;

public class RawToJson {
	private String rawData;
	private JsonArray jsonData;
	private ArrayList<String> dataLines; 
	private ArrayList<HashMap<String, Object>> data;
	
	public RawToJson(String data) {
		rawData = data;
		dataLines = new ArrayList<>(Arrays.asList(rawData.split("\n")));
	}
	
	public JsonArray getJsonData() {
		return jsonData.deepCopy();
	}
	
	public ArrayList<HashMap<String, Object>> getData() {
		return (ArrayList<HashMap<String, Object>>) data.clone();
	}
	
	public boolean convertToJson() {
		jsonData = new JsonArray();
		getFieldFromLineJsonArray();
		return false;
	}
	
	public void convertToHashMapList() {
		data = new ArrayList<>();
		getFieldFromLineList();
	}
	
	private JsonArray getFieldFromLineJsonArray() {
		HashMap<String, String> fieldsMap = LogAttribute.getAllAttributes();
		for (int i =0; i< dataLines.size(); i++) {
			String s = dataLines.get(i);
			JsonObject jObject = new JsonObject();
			for (Map.Entry<String, String> f:fieldsMap.entrySet()) {
				String value = getFieldAndValue(f.getValue(), s);
				if(!value.isEmpty() || f.getKey().equals("Incoming interface (IN)") || f.getKey().equals("Outgoing interface (OUT)")) {
					jObject.addProperty(f.getKey(), value);
				}
			}
			jsonData.add(jObject);
		}
		return jsonData;
	}
	
	private ArrayList<HashMap<String, Object>> getFieldFromLineList() {
		HashMap<String, String> fieldsMap = LogAttribute.getAllAttributes();
		for (int i =0; i< dataLines.size(); i++) {
			String s = dataLines.get(i);
			HashMap<String, Object> hMap = new HashMap<>();
			for (Map.Entry<String, String> f:fieldsMap.entrySet()) {
				String value = getFieldAndValue(f.getValue(), s);
				if(!value.isEmpty() || f.getKey().equals("Incoming interface (IN)") || f.getKey().equals("Outgoing interface (OUT)")) {
					hMap.put(f.getKey(), value);
				}
			}
			data.add(hMap);
		}
		return data;
	}
	
	
	
	private String getFieldAndValue(String regex, String s) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		if (matcher.find())
		{
		    return matcher.group();
		}
		return "";
	}
	
}
