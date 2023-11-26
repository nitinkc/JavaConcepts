package sandbox;

import org.apache.commons.lang3.BooleanUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        List<Integer> codeList = Arrays.asList(200, 201, 300, 301,504);//205 exception
        /*String singlecode = Integer.toString(200);
        String httpCodeDef = getHttpCodeDef(singlecode);
        System.out.println(httpCodeDef);*/

        codeList
                .stream()
                .forEach(code -> System.out.println("Response received from code : " + code +" is " + getHttpCodeDef(Integer.toString(code))));

    }

    private static String getHttpCodeDef(String code) {
        String url = "https://httpstat.us/" + code;

        StringBuilder response = new StringBuilder();

            // Create URL object
        URL apiUrl = null;
        try {
            apiUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Open connection
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) apiUrl.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set request method
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }

        // Set request property to simulate the behavior of --location in curl
            connection.setInstanceFollowRedirects(true);

            // Get the HTTP response code
        int responseCode = 0;
        try {
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (responseCode == Integer.valueOf(code) ) {
                // Get input stream
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;

                    // Read the response
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    // Print the response
                   // System.out.println("Response received : "  + response.toString());
                }catch (IOException e) {
                    e.printStackTrace();
                }
           } else {
                System.out.println("HTTP request failed with response code: " + responseCode);
            }

            // Disconnect
            connection.disconnect();

        return response.toString();
    }
}