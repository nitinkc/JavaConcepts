package com.nitin.a.sandBox;

public class print {
    public static void main(String[] args) {

        Double d = 1234.45d;

        System.out.println(String.format ("%.2f", d));
        System.out.println(String.format ("%f", d));
        System.out.println(Double.toString(d));


        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < 10; j++) {
                if(j > 7){
                    System.out.println("j is > 7" + "\t");
                    continue;
                }
                System.out.print("j = " + j + "\t");
            }
        }
    }
}