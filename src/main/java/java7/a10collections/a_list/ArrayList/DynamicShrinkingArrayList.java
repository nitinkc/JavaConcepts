package java7.a10collections.a_list.ArrayList;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicShrinkingArrayList {
    public static final int WORD_LENGTH = 10;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list = readFileFromInternet();
        System.out.println("Original List Size : "+list.size());

        dynamicallyShrinkList(list, WORD_LENGTH);
        System.out.println("List After First shrinking " + list.size());

        dynamicallyShrinkList(list, WORD_LENGTH + 3);
        System.out.println("List After Second shrinking " + list.size());

        System.out.println(list);
    }

    private static void dynamicallyShrinkList(List<String> list, int wordLength) {
        for (int i = 0; i < list.size(); i++) {
            String curr = list.get(i);
            if (curr.length() >= WORD_LENGTH) {
                //System.out.println("Removed Word = " + curr);
                list.remove(i);
            }
        }
    }

    private static List<String> readFileFromInternet() {
        Scanner s = null;
        try {
            //The English word List
            URL url = new URL("https://www.mit.edu/~ecprice/wordlist.10000");
            s = new Scanner(url.openStream());
        }catch(IOException ex) {
            ex.printStackTrace(); // for now, simply output it.
        }

        //Construct a list of Long Words
        List<String> list = new ArrayList<>();
        while(s.hasNext()) {
            String word = s.nextLine();
            if(word.length() > WORD_LENGTH - 1){
                list.add(word);
            }
        }
        return list;
    }
}