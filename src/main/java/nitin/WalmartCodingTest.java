package nitin;

/*
You are running a classroom and suspect that some of your students are passing around the answers to multiple choice
questions disguised as random strings.

Your task is to write a function that, given a list of words and a string, finds and returns the word in the list
that is scrambled up inside the string, if any exists. There will be at most one matching word. The letters don't need
to be in order or next to each other. The letters cannot be reused.

Example:
words = ['cat', 'baby', 'dog', 'bird', 'car', 'ax']
string1 = 'tcabnihjs'
find_embedded_word(words, string1) -> cat (the letters do not have to be in order)

string2 = 'tbcanihjs'
find_embedded_word(words, string2) -> cat (the letters do not have to be together)

string3 = 'baykkjl'
find_embedded_word(words, string3) -> None / null (the letters cannot be reused)

string4 = 'bbabylkkj'
find_embedded_word(words, string4) -> baby

string5 = 'ccc'
find_embedded_word(words, string5) -> None / null

string6 = 'breadmaking'
find_embedded_word(words, string6) -> bird

Complexity analysis variables:

W = number of words in `words`
S = maximal length of each word or string
*/

import java.util.HashMap;
import java.util.Map;

public class WalmartCodingTest {
    public static void main(String[] argv) {
        String[] words = new String[]{"cat", "baby", "dog", "bird", "car", "ax"};
        String string1 = "tcabnihjs";
        String string2 = "tbcanihjs";
        String string3 = "baykkjl";
        String string4 = "bbabylkkj";
        String string5 = "ccc";
        String string6 = "breadmaking";

        System.out.println(find_embedded_word(words, string1));
        System.out.println(find_embedded_word(words, string2));
        System.out.println(find_embedded_word(words, string3));
        System.out.println(find_embedded_word(words, string4));
        System.out.println(find_embedded_word(words, string5));
        System.out.println(find_embedded_word(words, string6));
    }

    public static String find_embedded_word(String[] words, String str) {
        String ret = "None";

        for (String word : words) {
            boolean flag[] = new boolean[word.length()];//check syntax
            Map<Character, Integer> map = getCharacterIntegerMap(str);
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (map.containsKey(c) && map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                    flag[i] = true;
                }
            }

            if (allTrue(flag)) {
                //ret = word;
                return word;
            }
        }
        return ret;
    }

    private static boolean allTrue(boolean[] flag) {
        for (int i = 0; i < flag.length; i++) {
            if(!flag[i])
                return false;
        }
        return true;
    }

    private static Map<Character, Integer> getCharacterIntegerMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character key = str.charAt(i);//Check for Autoboxing
            map.put(key, map.getOrDefault(key,0)+1);
        }
        return map;
    }
}