package com.utilities;

import com.entity.Card;
import com.entity.CovidIndia;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.List;

public class JsonReadUtility {

    ObjectMapper mapper = new ObjectMapper();

    public static void cardReader() {
        ObjectMapper mapper = new ObjectMapper();
        List<Card> listCard = null;
        String url = "https://random-data-api.com/api/business_credit_card/random_card?size=100";

        try {
             listCard = mapper.readValue(new URL(url), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listCard.size());
    }


    public static void covidReader() {
        ObjectMapper mapper = new ObjectMapper();
        List<CovidIndia> listCard = null;

        String url = "https://api.covid19api.com/total/country/india";
        //Getting the response code
       // int responsecode = getConnectionResponse(url);

        try {
            listCard = mapper.readValue(new URL(url), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listCard.size());

    }
    public static int getConnectionResponse(String urlLink) throws IOException {
        URL url = new URL(urlLink);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        }

        return responsecode;
    }

    public static void main(String[] args) throws IOException {
        //cardReader();
        covidReader();
    }
}
