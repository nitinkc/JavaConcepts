package com.utilities;

import com.entity.Beer;
import com.entity.Vehicle;
import com.entity.WordResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class InternetUtilities {

    private static final String URL = "https://www.mit.edu/~ecprice/wordlist.100000";
    private static final String DATA_MUSE_WORDS_URL = "https://api.datamuse.com/words?ml={word}&max={max}";
    private static final String RANDOM_BEERS_URL = "https://random-data-api.com/api/v2/beers?size=";

    ObjectMapper mapper = new ObjectMapper();


    public static List<String> bringWordListFromNet() {
        Scanner s = getScannerFromURL();

        //Construct a list of Long Words
        List<String> list = new ArrayList<>();
        while (s.hasNext()) {
            String word = s.nextLine();
            list.add(word);
        }
        s.close();
        return list;
    }

    public List<String> getWords(String[] args) {
        String word = args[0];
        String max = args[1];

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("word", word);
        uriVariables.put("max", max);

        RestTemplate restTemplate = new RestTemplate();
        //Response response = restTemplate.getForObject("https://api.datamuse.com/words?ml={word}&amp;max={max}", Response.class);
        ResponseEntity<WordResponse[]> response = restTemplate.getForEntity(DATA_MUSE_WORDS_URL, WordResponse[].class, uriVariables);

        //RestResponse responseNEW = response.getBody();
        System.out.println("==== RESTful API Response using Spring RESTTemplate START =======");


        List<String> wordList = new ArrayList<>();
        for (WordResponse x : response.getBody()) {
            //System.out.println(x.getWord());
            wordList.add(x.getWord());
        }
        System.out.println("======= RESTful API Response using Spring RESTTemplate END =======");

        return wordList;
    }

    public List<Beer> getBeers(int size) {
        ObjectMapper mapper = new ObjectMapper();
        List<Beer> beerList = new ArrayList<>();

        try {
            beerList = mapper.readValue(new URL(RANDOM_BEERS_URL+size), new TypeReference<List<Beer>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return beerList;
    }

    private static Scanner getScannerFromURL() {
        //Read Files from the net
        Scanner s = null;
        try {
            //The English word List
            URL url = new URL(URL);
            s = new Scanner(url.openStream());
        } catch (IOException ex) {
            ex.printStackTrace(); // for now, simply output it.
        }
        return s;
    }
}
