package com.nitin.a15java8.lambda.variableInLambda;

/**
 * Created by Nitin Chaurasia on 5/9/16 at 11:03 PM.
 */
public class GorillaFamily {
    String walk = "Walk";

    void everyonePlay(boolean baby){
        String approach = "amble";

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    void play(Gorilla g){
        System.out.println(g.move());
    }

    public static void main(String[] args) {
        GorillaFamily gf = new GorillaFamily();

        gf.everyonePlay(true);
        System.out.println("********************");
        gf.everyonePlay(false);
    }
}
