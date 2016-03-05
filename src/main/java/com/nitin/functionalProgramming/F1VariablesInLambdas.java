package com.nitin.functionalProgramming;

/**
 * Created by Nitin C on 3/3/2016.
 * Lambda expression can access static variables, instance variables,
 * effectively final variables and effectively Final local variables
 */
public class F1VariablesInLambdas {
    String walk = "walk";

    void everyonePlay(boolean baby){
        String approach = "abmle";

        // if reassigned : Error: local variables referenced from a lambda expression must be final or effectively final
        //approach = "run";

        play(() -> walk); // uses instance variable in Lambda
        play(() -> baby ? "hitch a ride" : "run"); // using the method parameter
        play(() -> approach);//Effectively Final Local Variable as approach is not re-assigned
    }

    void play(Gorilla g){
        System.out.println(g.move());
    }

    public static void main(String[] args) {
        F1VariablesInLambdas f = new F1VariablesInLambdas();
        f.everyonePlay(true);
    }
}
