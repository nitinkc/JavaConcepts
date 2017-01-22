package com.nitin.a.sandBox;

public class PractiseJAVA_LANG_MATH {

    /**
     * @param args
     */
    public static void main(String[] args) {
        double j = Math.PI;
        System.out.println(j);
        j = Math.floor(j);
        System.out.println(j);
        j = Math.E;
        System.out.println(j);
        j = Math.ceil(Math.PI);
        System.out.println(j);
        j = Math.abs(-j); //absolute value : DISTANCE FROM THE ZERO ON THE NUMBER LINE
        System.out.println(j);
        j = Math.cbrt(1000); //cube root
        System.out.println(j);
        j = Math.exp(10); // e to the power 10 : e = euler's number
        System.out.println(j);
        j = Math.hypot(3, 4); //finding c in pythegoras theorem!!
        System.out.println(j);

        System.out.println(Math.IEEEremainder(1001, 12));//Remainder when 1001 is divided by 12
        System.out.println(Math.max(100, 143)); //MAXIMA
        System.out.println(Math.min(100, 143)); //MINIMA
        System.out.println(Math.pow(2, 4));//x to power y

        System.out.println(Math.random()); // RANDOM Double int b/w 0 and 1
    }

}
