package dataio;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.*;

import util.RawToJson;

public class DataProcess {
	private int nW = 0;
	private String fileName;
	private String data;
	private JsonArray jsonData;
	private ArrayList<HashMap<String, Object>> dataArrayList;
	public String getFileName() {
		return fileName;
	}
	
	public String getData() {
		return data;
	}
	
	public ArrayList<HashMap<String, Object>> getDataArrayList() {
		return dataArrayList;
	}
	
	public JsonArray getJsonData() {
		return jsonData;
	}
	
	//	Constructor
	public DataProcess(String fileName) {
		this.fileName = fileName;
	}
	
	//	Read file
	private boolean readLogFile(String prefix) {
		FileReader file;
		StringBuilder dataBuilder = new StringBuilder("");
		
		try {
			file = new FileReader("./iptablesLog/" + fileName);
			BufferedReader reader = new BufferedReader(file);
			
			String string; 
			while((string = reader.readLine()) != null) {
				if(string.contains(prefix)) {					
					dataBuilder.append(string.replace("  ", " ")+"\n");
				}
			}
			
			System.out.println("Read successfully!");
			reader.close();
			data = dataBuilder.toString();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("Read error.");
		}
		
		return false;
	}
	
	private boolean readJsonFile() {
		return false;
	}
	
	public boolean readFile(String prefix, Boolean isRawFile) {
		if(isRawFile) {			
			return readLogFile(prefix);
		} else {
			return readJsonFile();
		}
	}
	public boolean readFile(boolean isRawFile) {
		return readLogFile("iptables: ");
	}
	
	
	private boolean writeToFile(String fileName, String data) {
		if(!fileName.matches("[\\w.]+") || fileName == this.fileName) {
			fileName = "file_" + nW++ + ".txt";
			System.out.println("Invalid file name, changing it to: " + fileName);
		}
		
		if(data.equals(null)) {
			System.out.println("File has no content.");
			return false;
		}
		
		try {
			FileWriter file = new FileWriter("./iptablesLog/" + fileName); 
			BufferedWriter writer = new BufferedWriter(file);
			
			writer.write(data);
			
			System.out.println("Write successfully!");
			writer.close();
			return true;
		} catch (IOException e) {
			System.out.println("write error");
		}
		return false;
		
	}
	public boolean writeToFile(String fileName) {
		return writeToFile(fileName, this.data);
	}
	
	public boolean writeToFile(String fileName, boolean writeJsonFile) {
		if(writeJsonFile) {
			Gson gson = new GsonBuilder()
							.setPrettyPrinting()
							.create(); 
			String s = gson.toJson(jsonData);
			return writeToFile(fileName, s);
		} else {
			return writeToFile(fileName, this.data);
		}
	}
	
	public void convertToJson() {
		RawToJson rawToJson = new RawToJson(data);
		rawToJson.convertToJson();
		jsonData = rawToJson.getJsonData(); 
	}
	
	public void convertToList() {
		RawToJson rawToJson = new RawToJson(data);
		rawToJson.convertToHashMapList();
		dataArrayList = rawToJson.getData();
	}

	
}
