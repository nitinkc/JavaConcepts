package nitin.zKnowYourJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class T4SharedMutability {
    public static void main(String[] args) {
        String url = "https://www.mit.edu/~ecprice/wordlist.100000";
        List<String> words = getData(url);//Add more data

        sharedMutabilityParallelism(words);
        useCollectorOrToList(words);
    }

    private static void useCollectorOrToList(List<String> words) {
        System.out.println("======== useCollectorOrToList ========");
        System.out.println("initial size = " + words.size());

        //Use collectors instead
        List<String> result = words.parallelStream()
                .map(String::toUpperCase)
                .toList();
        //.collect(Collectors.toList());

        System.out.println("initial size = " + result.size());
    }

    private static void sharedMutabilityParallelism(List<String> words) {
        System.out.println("======== sharedMutabilityParallelism ========");
        System.out.println("initial size = " + words.size());
        List<String> result = new ArrayList<>();//Shared Mutable Variable

        words.parallelStream()//.stream
                .map(String::toUpperCase)
                .forEach(name -> result.add(name));//Shared Mutability is BAD

        System.out.println("initial size = " + result.size());
    }

    private static ArrayList<String> getData(String url) {
        var words = new ArrayList<String>();
        try {
            // Create a URL a5object
            URL urlObject = new URL(url);
            // Open a connection to the URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlObject.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }

            // Close the reader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
