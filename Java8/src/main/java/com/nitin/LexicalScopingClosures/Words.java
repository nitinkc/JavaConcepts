package com.nitin.LexicalScopingClosures;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
       *Created by nitin on Thursday,February/13/2020at 1:53AM
*/
public class Words {

    public static void main(String[] args) throws IOException {

        String word = "blue";
        String max = "10";
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("word",word);
        uriVariables.put("max",max);

        RestTemplate restTemplate = new RestTemplate();
        //Response response = restTemplate.getForObject("https://api.datamuse.com/words?ml={word}&amp;max={max}", Response.class);
        ResponseEntity<RestResponse[]> response = restTemplate.getForEntity("https://api.datamuse.com/words?ml={word}&amp;max={max}", RestResponse[].class,uriVariables);

        //RestResponse responseNEW = response.getBody();
        System.out.println("==== RESTful API Response using Spring RESTTemplate START =======");
        for (RestResponse x:
             response.getBody()) {
            System.out.println(x.getWord());

        }
        System.out.println("==== RESTful API Response using Spring RESTTemplate END =======");
    }
    }
