package com.utilities;

import nitin.streams.LexicalScopingClosures.WordResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nitin on Thursday,February/13/2020at 1:53AM
 */
public class WordsFromDataMuse {

    public List<String> getWords(String[] args) {
        String word = args[0];
        String max = args[1];

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("word", word);
        uriVariables.put("max", max);

        RestTemplate restTemplate = new RestTemplate();
        //Response response = restTemplate.getForObject("https://api.datamuse.com/words?ml={word}&amp;max={max}", Response.class);
        ResponseEntity<WordResponse[]> response = restTemplate.getForEntity("https://api.datamuse.com/words?ml={word}&max={max}", WordResponse[].class, uriVariables);

        //RestResponse responseNEW = response.getBody();
        System.out.println("==== RESTful API Response using Spring RESTTemplate START =======");


        List<String> wordList = new ArrayList<>();
        for (WordResponse x : response.getBody()) {
            //System.out.println(x.getWord());
            wordList.add(x.getWord());
        }
        System.out.println("==== RESTful API Response using Spring RESTTemplate END =======");

        return wordList;
    }
}