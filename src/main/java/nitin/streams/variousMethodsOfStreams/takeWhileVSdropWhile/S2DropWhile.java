package nitin.streams.variousMethodsOfStreams.takeWhileVSdropWhile;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nitin on Sunday, January/26/2020 at 8:21 PM
 * TakeWhile runs until the first false/negative condition is met
 * DropWhile runs from the first negative condition is met.
 */
public class S2DropWhile {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", null, "two", "three", "four", null,"circuit breaker", "five",
                "six", "seven","","",null,null);

        //list = Arrays.asList(null,null,null,null);
        //list = Arrays.asList("","","","");

        List<String> takeWhileList = list
                .stream()
                .filter(str -> null != str)
                .takeWhile(str -> str.length() < 7)
                //.takeWhile(str -> str.equals("one"))
                .collect(Collectors.toList());
       System.out.println(takeWhileList);

        //DropWhile runs from the first negative condition is met.
        List<String> dropWhileList = list
                .stream()
                .filter(str -> null != str)
                .dropWhile(str -> str.length() < 7)
                .collect(Collectors.toList());
        System.out.println(dropWhileList);

        List<String> singleElementList = pickFirstNonNullSortedString(list);
        System.out.println(singleElementList);
    }

    private static List<String> pickFirstNonNullSortedString(List<String> list) {
        return Collections.singletonList(Optional.of(list
                .stream()
                .filter(singleStr -> null != singleStr)//Removing nulls
                .sorted(Comparator.naturalOrder())
                .dropWhile(str -> str.isBlank())//Removing Empty Strings
                //.peek(x-> System.out.println(x))
                .findFirst()).get().orElse(StringUtils.EMPTY));
    }
}
