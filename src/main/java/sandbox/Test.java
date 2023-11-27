package sandbox;

import org.apache.commons.lang3.BooleanUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private static final String BASE_URL = "https://httpstat.us/";

    public static void main(String[] args) throws IOException {
        List<Integer> codeList = Arrays.asList(301, 299,410, 505, 200, 201, 300);//205 exception
        //Imperative style
        /*for(Integer code : codeList){
            String httpCodeDef = getHttpCodeDef(Integer.toString(code));
            System.out.println(httpCodeDef);
        }*/

        //Functional Style
        codeList
                .parallelStream()
                .map(code -> {
                    try {
                        return getHttpCodeDef(Integer.toString(code));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })//If getHttpCodeDef throws an exception, should nto use try catch in functional style
                .map(String::toUpperCase)
                .forEach(code -> System.out.println("Response received from code : " + code));
    }


    public static String getHttpCodeDef(String code) throws IOException {
        StringBuilder response = new StringBuilder();

        try {
            // Create URL object
            URL apiUrl = new URL(BASE_URL + code);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            try {
                connection.setRequestMethod("GET");// Set request method
                connection.setRequestProperty("Accept", "text/plain");// "application/json" Set headers
                connection.setInstanceFollowRedirects(true);// Set instance follow redirects

                // Get the HTTP response code
                int responseCode = connection.getResponseCode();

                if (responseCode >= 300) {//For Status codes for which Exception were thrown
                    readErrorResponse(connection, response);
                } else if (responseCode == Integer.parseInt(code)) {
                    readSuccessResponse(connection, response);
                } else {//If an irrelevant code is sent
                    System.out.println("HTTP request code does not exist " + code);
                }
            } finally {
                // Disconnect
                connection.disconnect();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response.toString();
    }

    private static void readErrorResponse(HttpURLConnection connection, StringBuilder response) throws IOException {
        try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()))) {
            String line;
            // Read the response
            while ((line = errorReader.readLine()) != null) {
                response.append(line);
            }
        }
    }

    private static void readSuccessResponse(HttpURLConnection connection, StringBuilder response) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            // Read the response
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
    }
}