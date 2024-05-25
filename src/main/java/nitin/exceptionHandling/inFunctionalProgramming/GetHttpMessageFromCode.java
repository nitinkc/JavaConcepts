package nitin.exceptionHandling.inFunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class GetHttpMessageFromCode {
    private static final String BASE_URL = "https://httpstat.us/";

    public static void main(String[] args) throws IOException {
        List<Integer> codeList = Arrays.asList(301, 299, 410, 505, 200, 201, 300);//205 exception
        //Imperative style
        /*for(Integer code : codeList){
            String httpCodeDef = getHttpCodeDef(Integer.toString(code));
            System.out.println(httpCodeDef);
        }*/

        //Functional Style
        codeList
                .parallelStream()
                .map(code -> tryGetHttpCodeDef(Integer.toString(code)))//If getHttpCodeDef throws an exception, should not use try catch in functional style
                //.map(String::toUpperCase)
                .map(result -> result.map(String::toUpperCase))
                .map(result -> switch (result) {
                    case Success data -> data.getResult();
                    case Failure err -> err.getError();
                })
                .forEach(code -> System.out.println("Response received from code : " + code));
    }

    public static Try<String> tryGetHttpCodeDef(String code) {
        return Try.of(() -> getHttpCodeDef(code));
    }

    public static String getHttpCodeDef(String code) {
        StringBuilder response = new StringBuilder();

        try {
            // Create URL a5object
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