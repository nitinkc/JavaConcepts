package nitin.LambdaExpressions.methodRef;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodRefTypes {
    public static void main(String[] args) {

        String str1 = "The Green Mile";
        String str2 = "The Reader, The Pursuit of Happyness, Before Midnight";

        List<String> list = Arrays.asList(str2.split(","));

        List<String> updatedList = list
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(updatedList);

        System.out.println(str1.concat(str2));


    }
}