package com.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonUtils {

    public static String getJsonStringFromFile(String path) throws IOException {
        // Read the content of the file as a string
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}