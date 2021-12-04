package java8.a17Streams.streamsAPIjava8;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Created by Nitin C on 3/3/2016.
 * Unary and Binary are the special case of a Function where all input parameter
 * and return value are all of Same type
 */
public class F7ImplementUnaryBinaryOperators {
    public static void main(String[] args) {
        UnaryOperator<String> u1 = String::toLowerCase;
        System.out.println(u1.apply("NITIN"));

        BinaryOperator<String> binaryOperator1 = String::concat;
        BinaryOperator<String> binaryOperator2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(binaryOperator1.apply("Nitin"," Chaurasia"));
        System.out.println(binaryOperator2.apply("Kirti"," Chaurasia"));
    }
}
