package com.it.loganalyze.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
public class Util {
	private static JsonObject iptablesRegexMap;
	
	public static String readFile(String filePath) {
		FileReader file;
		StringBuilder dataBuilder = new StringBuilder("");
		try {
			file = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(file);
			String string; 
			while((string = reader.readLine()) != null) {				
				dataBuilder.append(string+"\n");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("IO Exception.");
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
			FileWriter fileWriter = new FileWriter("src/main/resources/com/it/loganalyze/tmp" + (new Random().nextInt())+".json");
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
}
