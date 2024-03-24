package com.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {
    public static String getJsonStringFromFile(String path) throws IOException {
        // Read the content of the file as a string
        String jsonString = new String(Files.readAllBytes(Paths.get(path)));
        return jsonString;
    }
}
