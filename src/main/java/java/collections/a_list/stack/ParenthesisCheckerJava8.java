package java.collections.a_list.stack;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * Created by nitin on Monday, October/14/2019 at 2:02 AM
 */
public class ParenthesisCheckerJava8 {
    public static void main(String[] args) {
        System.out.println(checker("({{}}(){()})"));
    }

    private static boolean checker(String str){
        Stack<Character> s = new Stack<>();

        Consumer<Character> consumer = (c) -> {
            if(c.toString().equals("(") || c == '{') {
                s.push(c);
            }

            if(c == '}' && s.peek() == '{'){
                s.pop();
            }

            if(c == ')' && s.peek() == '('){
                s.pop();
            }
        };
        str.chars()
                .mapToObj(i->(char)i)
                .forEach(x -> consumer.accept(x));

        return s.isEmpty();
    }
}
