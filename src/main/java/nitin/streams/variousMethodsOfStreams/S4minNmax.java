package nitin.streams.variousMethodsOfStreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/** Created by Nitin Chaurasia on 1/31/18 at 12:49 AM. Returns an optional */
public class S4minNmax {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Pawan");
        list.add("Chiranjeevi");
        list.add("RaviTeja");
        list.add("Venkatesh");
        list.add("Nagarjuna");
        System.out.println(list);

        // min accepts comparator to sort
        String min = list.stream().min((str1, str2) -> str1.compareTo(str2)).get();
        System.out.println(min);

        String max = list.stream().max((str1, str2) -> str1.compareTo(str2)).get();
        System.out.println(max);

        List<String> stringList = List.of("Cat", "Dog", "Elephant", "Frog", "Goat");
        // min needs a comparator
        Optional<String> min2 = stringList.stream().min((s1, s2) -> s1.compareToIgnoreCase(s2));
        min2.ifPresent(System.out::println);
        // get also return the same thing
        // System.out.println(min2.get());

        System.out.println("MIN 3");
        Optional<String> min3 =
                stringList.stream()
                        .min(
                                (s1, s2) -> {
                                    if (s1.length() > s2.length()) return 1;
                                    else if (s1.length() < s2.length()) return -1;
                                    else return s2.compareTo(s1);
                                });
        min3.ifPresent(System.out::println);

        System.out.println("Min 4");
        Optional<String> min4 =
                stringList.stream()
                        .min(
                                Comparator.comparing(
                                                String::length) // TODO : Learn to write in Lambda
                                        .thenComparing(Comparator.reverseOrder()));
        min4.ifPresent(System.out::println);
    }
}
