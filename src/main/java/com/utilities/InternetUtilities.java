package com.utilities;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InternetUtilities {

    private static final String URL =  "https://www.mit.edu/~ecprice/wordlist.10000";

    public static List<String> bringWordListFromNet() {
        //Read Files from the net
        Scanner s = null;
        try {
            //The English word List
            URL url = new URL(URL);
            s = new Scanner(url.openStream());
        }catch(IOException ex) {
            ex.printStackTrace(); // for now, simply output it.
        }

        //Construct a list of Long Words
        List<String> list = new ArrayList<>();
        while(s.hasNext()) {
            String word = s.nextLine();
            list.add(word);
        }
        s.close();
        return list;
    }
}
