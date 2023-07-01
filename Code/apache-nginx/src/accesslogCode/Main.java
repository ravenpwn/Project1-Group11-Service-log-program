package accesslogCode;

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
//    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        //specify the path of the input file
        String inputfile = "accessLog/access.log";
        // Create a JsonObject
        JsonObject jsonObject = new JsonObject();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputfile))){
                String line;
                int lineNumber = 1;
                //read each line from the inputfile
                while((line = reader.readLine()) != null){
                        //preocess each line and extract log information
                        LogEntry logEntry = createLogEntry.extractLogEntry(line);
                        jsonObject.add("line_" + lineNumber, createLogEntry.create(logEntry));
                        //add log information to the JsonObject
                        lineNumber ++;
                }
        }catch (IOException e){
                e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(jsonObject);
        //specify the path of the output JSON file
        String outputfile = "accessJson/access.json";
        //write the Json string to the output
        try (FileWriter fileWriter = new FileWriter(outputfile)){
            fileWriter.write(jsonString);
        }catch (IOException e){
                e.printStackTrace();
        }

    }
}