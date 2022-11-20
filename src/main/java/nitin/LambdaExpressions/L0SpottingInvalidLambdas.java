package nitin.LambdaExpressions;


import com.entity.SampleData;

import java.util.List;

/**
 * Created by Nitin C on 3/5/2016.
 */
public class L0SpottingInvalidLambdas {
    public static void main(String[] args) {
        TestInterfaceReturnMethod y;//Functional Interface

        //Defining Lambda
        y = (arg1, arg2) -> arg1 + arg2;//Providing implementation to the abstract method

        int resultForStoringY = y.methodWtih2Args(1, 2);
        System.out.println(resultForStoringY);

        y = (n, m) -> n * m;//redefining implementation
        System.out.println(y.methodWtih2Args(2, 3));

        /* Without Curly braces we can't use return keyword */
        y = (n, m) -> {//if using curly braces, have to use return statement
            return n * m;
        };
        /* RETURN Always need curly braces and ends with a colon */

        /********************* INVALID LAMBDAS ********************/
        /*
        y = (n,m) -> return n*m; //INVALID, curly braces missing
        n->{return n*n};//INVALID, semi colon missing
        n->{n*n;};//INVALID, no return statement.
        */

        // () can be omitted only if there is EXACTLY ONE Parameter and NO DATA TYPE


        /*
        String a = "Nitin";

        //VALID Lambdas
        MyFunctionalInterface t;
        t = () -> true; //ZERO Parameter, return Boolean
        t = a -> {return a.startsWith("Ni");}
        t = (String a) -> a.startsWith("Ni")
        t = (int x) -> {} //One parameter and no function body
        t = (int y) -> {return;}

        s = (a , b) -> a.startsWith("Ni")//2 parameters

        multiple parameters need to be enclosed in the brackets.
        a,b -> a.startsWith("Ni")//DOES NOT COMPILE : need small brackets
        CORRECT: (a,b) -> a.startsWith("Ni")

        c -> return 10;// DOES NOT COMPILE : return keyword without {}
        CORRECT: c -> { return 10; }
        a -> {return a.startsWith("test")}//DOES NOT COMPILE : need ; after return
        CORRECT:
        a -> { return a.startsWith("test"); }

        // DATA TYPES FOR THE INPUT PARAMETERS OF A LAMBDA EXPRESSION IS OPTIONAL
        (int y, z) -> { int x = 1; return x+y; }// DOES NOT COMPILE : Either both have data types or none
        CORRECT: ( y, z) -> { int x = 1; return x+y; }
        OR CORRECT: (int y, int z) -> { int x = 1; return x+y; }

        (a,b) -> { int a = 9; return a+b }//DOES NOT COMPILE: Redeclaration of a
        (a,b) -> { int c = 9; return a+b }// CORRECT AS C is an independent local variable
*/

        int a = 10, b = 20;
        List<Integer> list = SampleData.intCargoSequence(5, 10);

        TestInterfaceVoidMethod x = () -> System.out.println("Test");
        x = System.out::println;
        x.voidMethod();

        x = () -> System.out.print(resultForStoringY);
        x.voidMethod();

        //for each expects a Consumer
        //list.forEach((element) -> System.out.println(element));
        //for void or one parameter, the same can be written as
        //list.forEach(System.out :: println);
    }

    @FunctionalInterface
    interface TestInterfaceVoidMethod {
        void voidMethod();
    }

    @FunctionalInterface
    interface TestInterfaceReturnMethod {
        int methodWtih2Args(int a, int b);
    }
}
