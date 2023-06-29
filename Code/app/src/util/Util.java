package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
public class Util {
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
}
