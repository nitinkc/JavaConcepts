package nitin.iO;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ReadFileFromURL {
    public static void main(String[] args) {
        Scanner s = null;
        List<String> list = new ArrayList<>();
        try {
            //The Project Gutenberg EBook of Pride and Prejudice, by Jane Austen
            URL url = new URL("https://www.gutenberg.org/files/1342/1342-0.txt");
            s = new Scanner(url.openStream());
        }catch(IOException ex) {
            ex.printStackTrace(); // for now, simply output it.
        }
            Map<String,Integer> map = new HashMap<>();
            while(s.hasNext()) {
                String oneLine = s.nextLine();
                String[] wordsInOneLine = oneLine.split("\\s+");
                findLargerWords(wordsInOneLine,map);
            }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + " Value = "  + entry.getValue());
            if (entry.getValue() > 4){
                list.add(entry.getKey());
            }
        }

        System.out.println(list);
    }

    private static void findLargerWords(String[] wordsInOneLine, Map<String, Integer> map) {
        for (String str : wordsInOneLine) {
            if (str.length() > 8) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
        }
    }
}
