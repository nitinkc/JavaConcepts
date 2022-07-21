package com.utilities;

import com.entity.Card;
import com.entity.CovidIndia;
import com.entity.Vehicle;
import com.entity.crossRef.CrossRef;
import com.entity.git.GitUser;
import com.entity.gutendex.Gutendex;
import com.entity.openLibrary.Isbn;
import com.entity.openLibrary.OpenLibrary;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JsonReadUtility {

    //COVID API : https://documenter.getpostman.com/view/10808728/SzS8rjbc

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


    public static List<CovidIndia> covidReader() {
        ObjectMapper mapper = new ObjectMapper();
        List<CovidIndia> covidIndiaList = null;

        String url = "https://api.covid19api.com/total/country/india";
        //Getting the response code
       // int responsecode = getConnectionResponse(url);

        try {
            covidIndiaList = mapper.readValue(new URL(url), new TypeReference<List<CovidIndia>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return covidIndiaList;

    }

    public static List<Vehicle> getRandomVehicles(){
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> randomVehicleList = null;
        String url = "https://random-data-api.com/api/vehicle/random_vehicle?size=100";

        try {
            randomVehicleList = mapper.readValue(new URL(url), new TypeReference<List<Vehicle>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomVehicleList;

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

    public static GitUser getRandomGitUsers(){
        ObjectMapper mapper = new ObjectMapper();
        GitUser randomGitUser = null;
        String url = "https://random-data-api.com/api/omniauth/github_get?size=100";//Returns a singl;e git user


        try {
            randomGitUser = mapper.readValue(new URL(url), GitUser.class );//TODO : NOT WORKING, find a way to map to an array of GitUSers
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomGitUser;
    }

    public static Gutendex getGutenbergResults(String searchString){
        ObjectMapper mapper = new ObjectMapper();
        Gutendex results = null;
        String url = "https://gutendex.com/books/?search="+searchString;//Returns a singl;e git user


        try {
            results = mapper.readValue(new URL(url), Gutendex.class);//TODO : NOT WORKING, find a way to map to an array of GitUSers
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static CrossRef getCrossRef(String searchString){
        ObjectMapper mapper = new ObjectMapper();
        CrossRef results = null;
        String url = "https://api.crossref.org/works?query.author="+searchString;//Returns a singl;e git user

        try {
            results = mapper.readValue(new URL(url), CrossRef.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static OpenLibrary getBookDetailsOpenLibrary(String searchString){
        ObjectMapper mapper = new ObjectMapper();
        OpenLibrary results = null;
        String url = "https://openlibrary.org/api/books?bibkeys=ISBN:" + searchString+"&format=json&jscmd=data";//Returns a singl;e git user

        try {
            results = mapper.readValue(new URL(url), OpenLibrary.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
    public static void main(String[] args) throws IOException {
        //cardReader();
//        List<CovidIndia> list = covidReader();
//                list.forEach(x -> System.out.println(x.toString()));
        //System.out.println(getRandomGitUsers().credentials.token);
       // System.out.println(getRandomVehicles().size());
//        getGutenbergResults("Pride+and+Prejudice")
//                .results.forEach(result -> result.getAuthors().forEach(author -> System.out.println(author.name)));

        //Item -> Author and Indexed
        //getCrossRef("jane+austin").getMessage().getItems().forEach(item -> System.out.println(item.getIsbn()));

       // System.out.println(getBookDetailsOpenLibrary("9781108074568").getIsbn().getNumberOfPages());

        test();
    }

    public static void test() throws IOException {
        URL url = new URL("https://openlibrary.org/api/books?bibkeys=ISBN:9780980200447,ISBN:0385472579,LCCN:62019420&jscmd=data&format=json");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");

        ObjectMapper mapper = new ObjectMapper();
        OpenLibrary results = new OpenLibrary();

        JsonNode jsonNode = null;
        try {
           jsonNode = mapper.readTree(url);//readValue(new URL(url.toString()), OpenLibrary.class);
            Map<String, Isbn> resultsMap = mapper.treeToValue(jsonNode.get("ISBN:9780980200447"), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* Jackson Library used
       if(jsonNode.isObject()){
            Iterator<String> fieldNames = jsonNode.fieldNames();

            String fieldName = fieldNames.next();
            JsonNode fieldValue = jsonNode.get(fieldName);

            Isbn isbn = mapper.treeToValue(fieldValue, Isbn.class);
            System.out.println(isbn.getNumberOfPages());

        }*/


        // Google GSON library used
        JsonObject jsonobj =  JsonParser.parseReader(new InputStreamReader((InputStream) httpConn.getContent())).getAsJsonObject();
       // JsonObject isbn = value.getAsJsonObject().getAsJsonObject(key);

        for (Map.Entry<String, JsonElement> entry : jsonobj.entrySet()){
            String key   = entry.getKey();
            JsonElement value = entry.getValue();
            System.out.println(value.getAsJsonObject());
        }
        System.out.println(jsonobj.entrySet().size());
    }
}