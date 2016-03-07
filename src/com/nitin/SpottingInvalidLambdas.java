package com.nitin;

/**
 * Created by Nitin C on 3/5/2016.
 */
public class SpottingInvalidLambdas {
    /*

        // () can be omitted only if there is EXACTLY one parameter and NO DATA TYPE
        Duck d -> d.quack; //DOES NOT COMPILE
        a,d -> d.quack; //DOES NOT COMPILE
        Animal a, Duck d -> d.quack; //DOES NOT COMPILE

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

        // DATA TYPES FOR THE INPUT PARAMETERS OF N1PathFileTest LAMBDA EXPRESSION IS OPTIONAL
        (int y, z) -> { int x = 1; return x+y; }// DOES NOT COMPILE : Either both have data types or none
        CORRECT: ( y, z) -> { int x = 1; return x+y; }
        OR CORRECT: (int y, int z) -> { int x = 1; return x+y; }

        (a,b) -> { int a = 9; return a+b }//DOES NOT COMPILE: Redeclaration of a
        (a,b) -> { int c = 9; return a+b }// CORRECT AS C is an independent local variable

    */
}
