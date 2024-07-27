package nitin.virtualThreads;

import com.utilities.MultiThreadUtility;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static com.utilities.PerformanceUtility.startTimer;
import static com.utilities.PerformanceUtility.stopTimer;

public class Business {
    private static final String FILE_PATH = "src/main/resources/twitter-words.txt";

    public static void executeBusinessLogic() {
        MultiThreadUtility.logMessage("Start::executeBusinessLogic");
        MultiThreadUtility.delay(1_000);//Simulating an IO blocking call
        MultiThreadUtility.logMessage("END::executeBusinessLogic");
    }

    public static String fetchFile() {
        startTimer();
        MultiThreadUtility.logMessage("Start fetchFile()");
        List<String> list = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {
            MultiThreadUtility.delay(5000);
            list = lines.toList();
        } catch (IOException e) {
            System.out.println(e);
        }finally {
            MultiThreadUtility.logMessage("End fetchFile()");
        }
        //Returning a random string
        String str = list.get(new Random().nextInt(list.size()));
        stopTimer();
        return str;
    }

    public static String blockingDbCall(int secs) {
        MultiThreadUtility.logMessage("Start DB Call");
        URI uri = null;
        try {
            uri = new URI("http://httpbin.org/delay/" + secs);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URI: " + e.getMessage(), e);
        }

        try (InputStream stream = uri.toURL().openStream()) {
            String response = new String(stream.readAllBytes(), StandardCharsets.UTF_8);

            // Parse the JSON response
            JSONObject jsonObject = new JSONObject(response);

            // Get the headers object from the JSON
            JSONObject headers = jsonObject.getJSONObject("headers");

            // Get the X-Amzn-Trace-Id value from the headers
            String traceId = headers.getString("X-Amzn-Trace-Id");

            return traceId;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            MultiThreadUtility.logMessage("End DB Call");
        }
    }

    public static String blockingNetworkCall(int secs) {
        MultiThreadUtility.logMessage("Start Network Call");
        URI uri = null;
        try {
            uri = new URI("http://httpbin.org/delay/" + secs);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URI: " + e.getMessage(), e);
        }

        try (InputStream stream = uri.toURL().openStream()) {
            String response = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(response);// Parse the JSON response
            return jsonObject.getString("url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            MultiThreadUtility.logMessage("End DB Call");
        }
    }

    public static String getBrewer() {
        MultiThreadUtility.logMessage("Start getBrewer()");

        URI uri = null;
        try {
            MultiThreadUtility.delay(1_000);//One request per second is allowed
            uri = new URI("https://api.openbrewerydb.org/v1/breweries/random");
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URI: " + e.getMessage(), e);
        }

        try (InputStream stream = uri.toURL().openStream()) {
            // Read all bytes from the stream into a string
            String response = new String(stream.readAllBytes(), StandardCharsets.UTF_8);

            // Parse JSON response
            JSONArray jsonArray = new JSONArray(response);
            if (!jsonArray.isEmpty()) {
                JSONObject brewery = jsonArray.getJSONObject(0);
                return brewery.getString("name");
            } else {
                throw new RuntimeException("No brewery found in the response");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            MultiThreadUtility.logMessage("End getBrewer()");
        }
    }

    public static String getBeer() {
        MultiThreadUtility.logMessage("Start getBeer()");
        URI uri = null;
        try {
            uri = new URI("https://random-data-api.com/api/v2/beers?size=1");
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URI: " + e.getMessage(), e);
        }

        String apiResponse = "";
        try (InputStream stream = uri.toURL().openStream()) {
            // Read all bytes from the stream into a string
            String response = new String(stream.readAllBytes(), StandardCharsets.UTF_8);

            // Parse JSON response
            JSONObject jsonObject = new JSONObject(response);
            String name = jsonObject.getString("name");
            String style = jsonObject.getString("style");

            apiResponse = STR."\{name} \{style} ";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            MultiThreadUtility.logMessage("End getBeer()");
        }
        return apiResponse;
    }
}
