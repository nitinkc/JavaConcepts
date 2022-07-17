package com.utilities;

import com.entity.Card;
import com.entity.CovidIndia;
import com.entity.Vehicle;
import com.entity.git.GitUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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

    public static void main(String[] args) throws IOException {
        //cardReader();
        List<CovidIndia> list = covidReader();
                list.forEach(x -> System.out.println(x.toString()));
        //System.out.println(getRandomGitUsers().credentials.token);
       // System.out.println(getRandomVehicles().size());
    }
}