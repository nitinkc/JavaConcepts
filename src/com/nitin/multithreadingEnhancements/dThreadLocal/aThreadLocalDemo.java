package com.nitin.multithreadingEnhancements.dThreadLocal;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class aThreadLocalDemo {
    public static void main(String[] args) {
        /** #################################################
         *                  Example 1
         * ##################################################
         * */
        ThreadLocal tl = new ThreadLocal();

        System.out.println(tl.get());// null

        tl.set("Nitin");
        System.out.println(tl.get());// Nitin

        tl.remove();
        System.out.println(tl.get());// null

        /** #################################################
         *                  Example 2
         * ##################################################
         * */
         ThreadLocal tl2 = new ThreadLocal(){
            public Object initialValue(){
                return "abc";
            }
        };
        System.out.println(tl2.get());// abc

        tl2.set("Nitin");
        System.out.println(tl2.get());// Nitin

        tl2.remove();
        System.out.println(tl2.get());// abc


    }
}
