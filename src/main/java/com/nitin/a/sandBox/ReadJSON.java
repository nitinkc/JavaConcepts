package com.nitin.a.sandBox;


import org.apache.commons.io.IOUtils;


import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.simple.JSONObject;

/**
 * Created by nitin on Wednesday, September/25/2019 at 10:30 PM
 */
public class ReadJSON {
    public static void main(String[] args) throws MalformedURLException {
       /* //http://api.zippopotam.us/IN/110001

        // Apache Commons Library
        JSONObject jo = new JSONObject(IOUtils.toString(new URL("http://api.zippopotam.us/IN/110001"), Charset.forName("UTF-8")));

        // getting firstName and lastName
        System.out.println(jo.get("country"));
        System.out.println(jo.get("places"));
*/
    }
}
