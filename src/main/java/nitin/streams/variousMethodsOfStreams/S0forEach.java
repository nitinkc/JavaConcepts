package nitin.streams.variousMethodsOfStreams;

import java.util.ArrayList;
import java.util.List;

/** Created by Nitin Chaurasia on 1/31/18 at 12:53 AM. Applies the s2lambda to each element */
public class S0forEach {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Pawan");
        list.add("Chiranjeevi");
        list.add("RaviTeja");
        list.add("Venkatesh");
        list.add("Nagarjuna");
        System.out.println(list);

        // For each method applies the s2lambda to each element of the collection
        // Prints each element
        list.stream().forEach(str -> System.out.println(str));

        // Lambda can be replaced by method reference
        list.stream().forEach(System.out::print);
    }
}
