package java.LexicalScopingClosures;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

/**
 * Created by nitin on Saturday, February/15/2020 at 11:26 PM
 */
public class PlayWithDataMuse {
    public static void main(String[] args) {
        WordsFromDataMuse wordsFromDataMuse = new WordsFromDataMuse();
        List<String> words = wordsFromDataMuse.getWords(new String[]{"loathe", "1000"});

        System.out.println(words.stream()
                .count());

        //Function taking a String as input and returning a Predicate
        final Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> (String word) -> word.startsWith(letter);

        Map<Integer, List<String>> wordsByLength=
                words.stream()
                        .collect(groupingBy(String::length));
        //System.out.println("Group by Length : " + wordsByLength );

        //Print Word count of each word, based on Length
        Map<Integer, Long> wordsByLengthCount=
                words.stream()
                .collect(groupingBy(String::length,counting()));

        System.out.println(wordsByLengthCount);

        //filtering(s -> !s.contains("c")
       /* Map<Integer, List<String>> wordsByCharacter=
                words.stream()
                        .collect(groupingBy(String::length, filtering(x->x.length() == 7,toList())));

        System.out.println(wordsByCharacter);*/


        /*var result = words.stream()
                .collect(
                        groupingBy(String::length,
                                mapping(toStringList(),
                                        flatMapping(s -> s.stream().distinct(),
                                                filtering(s -> s.length() > 0,
                                                        mapping(String::toUpperCase,
                                                                reducing("", (s, s2) -> s + s2)))))
                        ));*/

       // System.out.println(result);

    }

    private static Function<String, List<String>> toStringList() {
        return s -> s.chars()
                .mapToObj(c -> (char) c)
                .map(Object::toString)
                .collect(toList());
    }
}
