package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Util {
	public static String readFile(String fileName) {
		FileReader file;
		StringBuilder dataBuilder = new StringBuilder("");
		try {
			file = new FileReader("./log/" + fileName);
			BufferedReader reader = new BufferedReader(file);
			
			String string; 
			while((string = reader.readLine()) != null) {				
				dataBuilder.append(string+"\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("Read error.");
		return dataBuilder.toString();
	}
}
