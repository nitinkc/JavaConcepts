package nitin.zKnowYourJava;

import java.util.List;

public class T5Stream {
    public static void main(String[] args) {
        int[] factor = new int[]{2};
    var numbers = List.of(1,2,3);

    var stream = numbers.stream()
            .map(number -> number*factor[0]);//Does not evaluate yet, as there is no terminal operator

    factor[0] = 0;

    stream.forEach(System.out::println);//Evaluates here

    }
}
