package com.nitin.LexicalScopingClosures;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

/**
 * Created by nitin on Thursday, February/13/2020 at 1:53 AM
 */
public class Words {


    public static <JSONException> JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) {

        JSONObject json = null;
        try {
            json = readJsonFromUrl("https://graph.facebook.com/19292868552");
        } catch (RuntimeException o) {
            o.printStackTrace();
        }
        System.out.println(json.toString());
        System.out.println(json.get("id"));
        /*try {
            final URL url =
                    new URL("https://api.datamuse.com/words?ml=duck&amp;max=100");
            final BufferedReader reader =
                    new BufferedReader(new InputStreamReader(url.openStream()));

            System.out.println(reader.readLine());


        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }*/


    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
