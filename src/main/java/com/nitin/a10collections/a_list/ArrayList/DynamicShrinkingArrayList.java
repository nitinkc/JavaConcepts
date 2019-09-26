package com.nitin.a10collections.a_list.ArrayList;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicShrinkingArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list = readFileFromInternet();
        System.out.println(list.size());

        dynamicallyShrinkList(list);
        System.out.println(list.size());
    }

    private static void dynamicallyShrinkList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String curr = list.get(i);
            if (curr.length() >= 10) {
                //System.out.println("Removed Word = " + curr);
                list.remove(i);
            }
        }
    }


    private static List<String> readFileFromInternet() {
        Scanner s = null;
        try {
            //The English wordlist
            URL url = new URL("https://www.mit.edu/~ecprice/wordlist.10000");
            s = new Scanner(url.openStream());
        }catch(IOException ex) {
            ex.printStackTrace(); // for now, simply output it.
        }

        //Construct a list of Long Words
        List<String> list = new ArrayList<>();
        while(s.hasNext()) {
            String word = s.nextLine();
            if(word.length() > 10){
                list.add(word);
            }
        }

        return list;
    }
}
