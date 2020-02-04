package com.nitin.a15LambdaExpressions;

import entity.Cargo;

import java.util.List;

/**
 * Created by Nitin C on 3/5/2016.
 */
public class L0SpottingInvalidLambdas {
    public static void main(String[] args) {
        int a = 10, b=20;
        List<Integer> list = Cargo.intCargoSequence(5,10);

        TestInterfaceVoidMethod x = () -> System.out.println("Test");
        x = System.out::println;
        x.voidMethod();

        TestInterfaceReturnMethod y = (arg1,arg2) ->  arg1+arg2;
        int result = y.intMethod(1,2);

        y = (n,m) -> n*m;
        /** Without Curly braces we cant use return keyword */
        y = (n,m) -> {return n*m;};
        //y = (n,m) -> return n*m; //INVALID
        /** RETURN Always need curly braces and ends with a colon */
        // n->{return n*n};//INVALID, semi colon missing
        //n->{n*n;};//INVALID

        x = ()->System.out.print(result);
        x.voidMethod();

        //for each expects a Consumer
        list.forEach((element) -> System.out.println(element));
        //for void or one parameter, the same can be written as
        list.forEach(System.out :: println);

        // () can be omitted only if there is EXACTLY one parameter and NO DATA TYPE
        /*

        String a = "Nitin";
        //VALID Lambdas
        () -> true; //ZERO Parameter
        a -> {return a.startsWith("Ni");}
        (String a) -> a.startsWith("Ni")
        (int x) -> {} //One parameter and no function body
        (int y) -> {return;}

        (a , b) -> a.startsWith("Ni")//2 parameters

        a,b -> a.startsWith("Ni")//DOES NOT COMPILE : need parentheses
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
    }

    @FunctionalInterface
    interface TestInterfaceVoidMethod{
        public void voidMethod();
    }

    @FunctionalInterface
    interface TestInterfaceReturnMethod{
        public int intMethod(int a, int b);
    }
}
