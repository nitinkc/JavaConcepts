package nitin.LambdaExpressions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 4:25 AM.
 * Lambda Expression is just an anonymous (nameless) function.
 */
public class L1Lambda {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(doubling(list));
        System.out.println(doublingWithIfElse(list));
    }

    // When only one parameter is available, small parenthesis is optional
    private static List<Integer> doubling(List<Integer> nums){
        //small parenthesis around x is optional
        //nums.replaceAll( (x) -> {return x*2;});//First Doubling

        // simplified
        nums.replaceAll(x -> x%2 == 0 ? x : x*x);//Second Doubling
        return nums;
    }

    private static List<Integer> doublingWithIfElse(List<Integer> list){
        //Testing if else in Lambda
        list.replaceAll( (x) -> { if (x%2 == 0)
            return x;
        else
            return x*x;});

        return list;
    }
}
