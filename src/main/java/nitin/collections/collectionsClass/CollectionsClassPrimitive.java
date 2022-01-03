package nitin.collections.collectionsClass;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by nitin on Wednesday, September/25/2019 at 10:15 PM
 */
public class CollectionsClassPrimitive {
    private static final int WORD_LENGTH = 15;
    private static final String URL =  "https://www.mit.edu/~ecprice/wordlist.10000";

    public static void main(String[] args) {
        List<String> list = bringDataFromNet(URL);

        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        //Reverse Sorting
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(list);
    }

    private static List<String> bringDataFromNet(String url_link) {
        //Read Files from the net
        Scanner s = null;
        try {
            //The English word List
            URL url = new URL(url_link);
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
