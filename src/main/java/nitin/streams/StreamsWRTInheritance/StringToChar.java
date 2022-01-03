package nitin.streams.StreamsWRTInheritance;

/**
 * Created by nitin on Thursday, February/13/2020 at 10:26 PM
 */
public class StringToChar {
    public static void main(String[] args) {
        final String str = "w00t";

        str.chars()
                .forEach(aChar -> System.out.println(Character.toChars(aChar)));

        str.chars()
                .filter(ch -> Character.isDigit(ch))
                .forEach(ch -> System.out.println(Character.toChars(ch)));
    }
}
