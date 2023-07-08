package com.it.loganalyze.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
public class Util {
	private static JsonObject iptablesRegexMap;
	private static SecureRandom random = new SecureRandom();
	public static String readFile(String filePath) {
		FileReader file;
		BufferedReader reader = null;
		StringBuilder dataBuilder = new StringBuilder("");
		try {
			file = new FileReader(filePath);
			reader = new BufferedReader(file);
			String string; 
			while((string = reader.readLine()) != null) {				
				dataBuilder.append(string+"\n");
			}
		} catch (Exception e) {
			System.err.println("Error reading file: " + e.getMessage() );
		} 
		finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// Log the exception
				System.err.println("Error closing reader: " + e.getMessage());
			}
		}
		
		return dataBuilder.toString();
	}
	
	public static JsonElement readJsonFile(String filePath) {
		String data =  readFile(filePath);

		Gson gson = new Gson();
		JsonElement obj = gson.fromJson(data, JsonElement.class);
		return obj;
	}
	
	public static String regexFind(String regex, String s) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		if (matcher.find())
		{
		    return matcher.group();
		}
		return "";
	}

	public static JsonObject getIptablesRegexMap() {
		if (iptablesRegexMap == null) {
			iptablesRegexMap = (JsonObject)readJsonFile("src/main/resources/com/it/loganalyze/regex/IptablesRegex.json");
		}
		return iptablesRegexMap;
	}
	
	public static void writeToJsonFile(Object obj) {
		try {
			FileWriter fileWriter = new FileWriter("src/main/resources/com/it/loganalyze/tmp" + random.nextInt()+ ".json");
			BufferedWriter writer = new BufferedWriter(fileWriter);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String element = gson.toJson(obj);
			writer.write(element);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String prettyPrintMap(Map<?, ?> map) {
		StringBuilder sb = new StringBuilder();
		for (Entry<?, ?> entry : map.entrySet()) {
		    sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n\n");
		}
		String prettyPrint = sb.toString().trim();
		return prettyPrint;
	}
}
