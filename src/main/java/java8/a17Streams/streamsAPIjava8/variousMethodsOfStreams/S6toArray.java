package java8.a17Streams.streamsAPIjava8.variousMethodsOfStreams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 12:59 AM.
 */
public class S6toArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Pawan");
        list.add("Chiranjeevi");
        list.add("RaviTeja");
        list.add("Venkatesh");
        list.add("Nagarjuna");
        System.out.println(list);

        String[] arr = list.stream().toArray(String[]::new);

        for (String a : arr){
            System.out.println(a);
        }


    }
}
