package java8.zJava8Revisions.a1lambdas;

/**
 * Created by nichaurasia on Saturday, January/04/2020 at 2:39 AM
 */

public class BasicLambdas {
    public static void main(String[] args) {
        TestFunctionalInterfaceWithReturnMethod y = null;

        // Lambda for addition
        y = (arg1, arg2) ->  arg1+arg2;
        int result = y.calculate(1,2);
        System.out.println("result sum : " + result);

        // Lambda for Multiplication
        y = (n,m) -> n*m;
        result = y.calculate(5,2);
        System.out.println("result product : " + result);

        /** Without Curly braces we cant use return keyword */
        y = (n,m) -> {return n/m;};
        result = y.calculate(100,2);
        System.out.println("result division : " + result);

        //y = (n,m) -> return n*m; //INVALID
        /** RETURN Always need curly braces and ends with a colon */
        // n->{return n*n};//INVALID, semi colon missing
        //n->{n*n;};//INVALID

    }
}

 @FunctionalInterface
    interface TestFunctionalInterfaceWithReturnMethod {
     int calculate(int a, int b);

     default int multiply(int a, int b) {
         return 0;
     }

     static int multiply2(int a, int b) {
         return 0;
     }
 }