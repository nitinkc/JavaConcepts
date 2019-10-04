package com.nitin.a15LambdaExpressions;

/**
 * Created by Nitin Chaurasia on 5/9/16 at 11:03 PM.
 */
class VariableInLambda {
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
        VariableInLambda gf = new VariableInLambda();

        gf.everyonePlay(true);
        System.out.println("********************");
        gf.everyonePlay(false);
    }
}

@FunctionalInterface
interface Gorilla {
    String move();
}
