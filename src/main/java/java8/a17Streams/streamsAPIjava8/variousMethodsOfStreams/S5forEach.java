package java8.a17Streams.streamsAPIjava8.variousMethodsOfStreams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 12:53 AM.
 * Applies the lambda to each element
 */
public class S5forEach {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Pawan");
        list.add("Chiranjeevi");
        list.add("RaviTeja");
        list.add("Venkatesh");
        list.add("Nagarjuna");
        System.out.println(list);

        //For each method applies the lambda to each element of the collection
        //Prints each element
        list.stream().forEach(str -> System.out.println(str));

        //Where ever Lambda is there it can be replaced by method reference
        list.stream().forEach(System.out :: print);

    }
}
