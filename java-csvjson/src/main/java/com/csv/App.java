package com.csv;

import org.json.CDL;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;


/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream("work.csv");
        String csvAsString = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
        InputStream inputStream2 = App.class.getClassLoader().getResourceAsStream("work2.csv");
        String Keys = new BufferedReader(new InputStreamReader(inputStream2)).lines().collect(Collectors.joining("\n"));
        CDL.toJSONArray(Keys);
        String json = CDL.toJSONArray(csvAsString).toString();
        JSONObject item = new JSONObject();

        if (Files.exists(Path.of("C:/Users/dima/IdeaProjects/java-test/java-csvjson/src/main/resources/output.json")))
            try {
                Files.write(Path.of("C:/Users/dima/IdeaProjects/java-test/java-csvjson/src/main/resources/output.json"), json.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
