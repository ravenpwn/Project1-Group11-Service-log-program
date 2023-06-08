
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
    public static void main(String[] args) {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("/home/dumi/IdeaProjects/test3/src/course.json"));

            // convert JSON array to list of users
            List<User> users = new Gson().fromJson(reader, new TypeToken<List<User>>() {}.getType());

            // print users
            users.forEach(System.out::println);


            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}